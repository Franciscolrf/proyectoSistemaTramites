/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bda.itson.entidadesJPA.Persona;
import excepciones.PersistenciaException;
import interfaces.IConexion;
import interfaces.IPersona;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author abelc Clase que implementa la interfaz IPersona para realizar
 * operaciones relacionadas con entidades Persona en la base de datos.
 */
public class PersonaDAO implements IPersona {

    private final IConexion conexion;

    /**
     * Constructor de la clase PersonaDAO.
     *
     * @param conexion Objeto que proporciona la conexión a la base de datos.
     */
    public PersonaDAO() {
         conexion = new ConexionJPA("bda.itson_SistemaTramitesPersistencia_jar_1.0-SNAPSHOTPU");
    }

    /**
     * Registra una nueva persona en la base de datos.
     *
     * @param persona Objeto de tipo Persona que se registrará.
     * @return El objeto Persona registrado.
     * @throws PersistenciaException Si ocurre un error durante el registro de
     * la persona.
     */
    @Override
    public Persona registrarPersona(Persona persona) throws PersistenciaException {
        EntityManager entityManager = null;
        try {
            entityManager = conexion.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(persona);
            entityManager.getTransaction().commit();
            return persona;
        } catch (Exception ex) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al registrar persona", ex);
        } finally {
            conexion.close();
        }
    }

    /**
     * Realiza una inserción masiva de personas en la base de datos.
     *
     * @param personas Lista de objetos Persona que se insertarán.
     * @return La lista de personas insertadas.
     * @throws PersistenciaException Si ocurre un error durante la inserción
     * masiva.
     */
    @Override
    public List<Persona> insercionMasivaPersonas(List<Persona> personas) throws PersistenciaException {
        EntityManager entityManager = null;
        try {
            entityManager = conexion.getEntityManager();
            entityManager.getTransaction().begin();
            for (Persona persona : personas) {
                entityManager.persist(persona);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al insertar personas: " + e.getMessage(), e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return personas;
    }

    /**
     * Obtiene una persona de la base de datos según su RFC (Registro Federal de
     * Contribuyentes).
     *
     * @param rfc El RFC de la persona que se busca.
     * @return El objeto Persona correspondiente al RFC proporcionado, o null si
     * no se encuentra.
     */
  public Persona obtenerPersonaRFC(String rfc) {
    EntityManager entityManager = null;
    Persona persona = null;
    try {
        entityManager = conexion.getEntityManager();
        Query query = entityManager.createQuery("SELECT p FROM Persona p WHERE p.RFC = :rfc");
        query.setParameter("rfc", rfc);
        persona = (Persona) query.getSingleResult();
    } catch (NoResultException e) {
        persona = null;
    } finally {
        if (entityManager != null) {
            entityManager.close();
        }
    }
    return persona;
}
  
    /**
     * Método para obtener una licencia a partir de un parametro de busqueda
     *
     * @param buscarParametro Parámetro de busqueda
     * @return Licencia con el parametro de busqueda especificado
     * @throws PersistenciaException
     */
    @Override
    public List<Persona> buscarPersonas(String buscarParametro) throws PersistenciaException {
        EntityManager entityManager = null;
        entityManager = conexion.getEntityManager();
        TypedQuery<Persona> query = entityManager.createQuery(
                "SELECT p FROM Persona p WHERE p.RFC LIKE :parametro OR p.nombres LIKE :parametro OR p.apellidoPaterno LIKE :parametro OR p.apellidoMaterno LIKE :parametro",
                Persona.class);
        query.setParameter("parametro", "%" + buscarParametro + "%");
        return query.getResultList();
    }
}
