/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;

import javax.persistence.*;

import bda.itson.entidadesJPA.Vehiculo;
import excepciones.PersistenciaException;
import interfaces.IConexion;
import interfaces.IVehiculoDAO;

/**
 *
 * @author ID145
 */
public class VehiculoDAO implements IVehiculoDAO {
    private IConexion conexion;

    public VehiculoDAO (IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public Vehiculo agregar(Vehiculo Vehiculo) {
        EntityManager entityManager = conexion.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(Vehiculo);
        entityManager.getTransaction().commit();
        entityManager.refresh(Vehiculo);
        entityManager.close();
        return Vehiculo;
    }

    @Override
    public Vehiculo consultar(Long idAutomovil) {
        EntityManager entityManager = conexion.getEntityManager();
        Vehiculo Vehiculo = entityManager.find(Vehiculo.class, idAutomovil);
        entityManager.close();
        return Vehiculo;
    }

    /**
     * Realiza una inserción masiva de automóviles en la base de datos.
     *
     * @param automoviles Lista de objetos Automovil que se insertarán.
     * @return La lista de automóviles insertados.
     * @throws PersistenciaException Si ocurre un error durante la inserción masiva.
     */
    public List<Vehiculo> insercionMasivaAutomovil(List<Vehiculo> Vehiculos) throws PersistenciaException {
        EntityManager entityManager = null;
        try {
            entityManager = conexion.getEntityManager();
            entityManager.getTransaction().begin();
            for (Vehiculo Vehiculo : Vehiculos) {
                entityManager.persist(Vehiculo);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al insertar Vehiculos: " + e.getMessage(), e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return Vehiculos;
    }

}
