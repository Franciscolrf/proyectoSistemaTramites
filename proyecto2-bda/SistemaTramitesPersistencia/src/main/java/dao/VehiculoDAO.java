/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bda.itson.entidadesJPA.Licencia;
import bda.itson.entidadesJPA.Persona;
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

    public VehiculoDAO () {
        conexion = new ConexionJPA("bda.itson_SistemaTramitesPersistencia_jar_1.0-SNAPSHOTPU");
    }

    /**
     * Registra un nuevo Vehiculo en la base de datos.
     * @param vehiculo Objeto de tipo Vehiculo que se registrará.
     * @return El objeto Vehiculo registrado.
     */
    @Override
    public Vehiculo agregar(Vehiculo vehiculo) {
        EntityManager entityManager = conexion.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(vehiculo);
        entityManager.getTransaction().commit();
        entityManager.refresh(vehiculo);
        entityManager.close();
        return vehiculo;
    }

    /**
     * Consulta un Vehiculo en la base de datos por su identificador.
     * @param id Identificador del Vehiculo a consultar.
     * @return El objeto Vehiculo consultado.
     */
    @Override
    public Vehiculo consultar(Long id) {
        EntityManager entityManager = conexion.getEntityManager();
        Vehiculo Vehiculo = entityManager.find(Vehiculo.class, id);
        entityManager.close();
        return Vehiculo;
    }

    /**
     * Realiza una inserción masiva de Vehiculos en la base de datos.
     *
     * @param Vehiculos Lista de objetos Vehiculo que se insertarán.
     * @return La lista de Vehiculos insertados.
     * @throws PersistenciaException Si ocurre un error durante la inserción masiva.
     */
    public List<Vehiculo> insercionMasivaVehiculo(List<Vehiculo> vehiculos) throws PersistenciaException {
        EntityManager entityManager = null;
        try {
            entityManager = conexion.getEntityManager();
            entityManager.getTransaction().begin();
            for (Vehiculo Vehiculo : vehiculos) {
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
        return vehiculos;
    }
    
    @Override
    public List<Vehiculo> consultarVehiculosPersona(Persona persona) throws PersistenciaException{
    EntityManager entityManager = null;
    try {
            entityManager = conexion.getEntityManager();
            TypedQuery<Vehiculo> query = entityManager.createQuery(
            "SELECT v FROM Vehiculo v WHERE v.propietario.id=:personaId",
                    Vehiculo.class);
            query.setParameter("personaId", persona.getId());
            return query.getResultList();
    } catch (Exception ex) {
            throw new PersistenciaException("Error al realizar la solicitud de consulta de licencias", ex);
        } finally {
            conexion.close();
        }

}

}
