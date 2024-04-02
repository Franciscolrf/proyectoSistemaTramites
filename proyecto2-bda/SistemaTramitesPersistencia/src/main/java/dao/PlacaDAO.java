/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import bda.itson.entidadesJPA.Placa;
import excepciones.PersistenciaException;
import interfaces.IConexion;
import interfaces.IPlacaDAO;
import javax.persistence.NoResultException;

/**
 *
 * @author ID145
 */
public class PlacaDAO implements IPlacaDAO {

    /**
     * Objeto que proporciona la conexión a la base de datos.
     */
    private IConexion conexion;

    /**
     * Constructor de la clase PlacaDAO.
     *
     * @param conexion
     */
    public PlacaDAO() {
        conexion = new ConexionJPA("bda.itson_SistemaTramitesPersistencia_jar_1.0-SNAPSHOTPU");
    }

    /**
     * Registra una nueva placa en la base de datos.
     *
     * @param placa Objeto de tipo Placa que se registrará.
     * @return El objeto Placa registrado.
     * @throws PersistenciaException Si ocurre un error durante el registro de
     * la placa.
     */
    @Override
    public Placa agregar(Placa placa) throws PersistenciaException {
        EntityManager entityManager = null;
        try {
            entityManager = conexion.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(placa);
            entityManager.getTransaction().commit();
            return placa;
        } catch (Exception ex) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al registrar placa", ex);
        } finally {
            conexion.close();
        }
    }

    /**
     * Consulta una placa en la base de datos por su identificador.
     *
     * @param idPlaca Identificador de la placa a consultar.
     * @return El objeto Placa consultado.
     * @throws PersistenciaException Si ocurre un error al consultar la placa.
     */
    @Override
    public Placa consultar(Long idPlaca) throws PersistenciaException {
        EntityManager entityManager = null;
        try {
            entityManager = conexion.getEntityManager();
            return entityManager.find(Placa.class, idPlaca);
        } catch (Exception ex) {
            throw new PersistenciaException("Error al consultar placa", ex);
        } finally {
            conexion.close();
        }

    }

    /**
     * Método para consultar las placas tramitadas entre dos fechas.
     *
     * @param fechaInicio Fecha de inicio del rango de búsqueda.
     * @param fechaFin Fecha de fin del rango de búsqueda.
     * @return Lista de placas tramitadas entre las fechas especificadas.
     * @throws PersistenciaException Si ocurre un error al consultar las placas.
     */
    @Override
    public List<Placa> consultarPlacasTramitadasPorPeriodo(Calendar fechaInicio, Calendar fechaFin) throws PersistenciaException {
        EntityManager entityManager = null;
        try {
            entityManager = conexion.getEntityManager();
            TypedQuery<Placa> query = entityManager.createQuery(
                    "SELECT p FROM Placa p WHERE p.fechaExpedicion BETWEEN :fechaInicio AND :fechaFin", Placa.class);
            query.setParameter("fechaInicio", fechaInicio);
            query.setParameter("fechaFin", fechaFin);
            return query.getResultList();
        } catch (Exception ex) {
            throw new PersistenciaException("Error al consultar placas", ex);
        } finally {
            conexion.close();
        }
    }

    @Override
    public Placa buscarPlacaCodigo(String codigo) throws PersistenciaException {
        EntityManager entityManager = null;
        Placa placa = null;
    try {
        entityManager = conexion.getEntityManager();
        TypedQuery<Placa> query = entityManager.createQuery(
                "SELECT p FROM Placa p WHERE p.codigo=:codigo", Placa.class
        );
        query.setParameter("codigo", codigo);
        return query.getSingleResult();
    } catch (NoResultException ex) {
        return null;
    } catch (Exception ex) {
        throw new PersistenciaException("Error al consultar placas", ex);
    } finally {
        conexion.close();
    }
    }

}
