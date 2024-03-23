/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;

import javax.persistence.*;

import bda.itson.entidadesJPA.Automovil;
import excepciones.PersistenciaException;
import interfaces.IAutomovilDAO;
import interfaces.IConexion;

/**
 *
 * @author ID145
 */
public class AutomovilDAO implements IAutomovilDAO {
    private IConexion conexion;

    public AutomovilDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public Automovil agregar(Automovil automovil) {
        EntityManager entityManager = conexion.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(automovil);
        entityManager.getTransaction().commit();
        entityManager.refresh(automovil);
        entityManager.close();
        return automovil;
    }

    @Override
    public Automovil consultar(Long idAutomovil) {
        EntityManager entityManager = conexion.getEntityManager();
        Automovil automovil = entityManager.find(Automovil.class, idAutomovil);
        entityManager.close();
        return automovil;
    }

    /**
     * Realiza una inserción masiva de automóviles en la base de datos.
     *
     * @param automoviles Lista de objetos Automovil que se insertarán.
     * @return La lista de automóviles insertados.
     * @throws PersistenciaException Si ocurre un error durante la inserción masiva.
     */
    public List<Automovil> insercionMasivaAutomovil(List<Automovil> automoviles) throws PersistenciaException {
        EntityManager entityManager = null;
        try {
            entityManager = conexion.getEntityManager();
            entityManager.getTransaction().begin();
            for (Automovil automovil : automoviles) {
                entityManager.persist(automovil);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al insertar automóviles: " + e.getMessage(), e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return automoviles;
    }

}
