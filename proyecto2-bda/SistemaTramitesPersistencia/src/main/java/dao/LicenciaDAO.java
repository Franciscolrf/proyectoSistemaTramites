package dao;

import bda.itson.entidadesJPA.Licencia;
import bda.itson.entidadesJPA.Persona;
import excepciones.PersistenciaException;
import interfaces.IConexion;
import interfaces.ILicencia;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author fabri
 */
public class LicenciaDAO implements ILicencia {

    private final IConexion conexion;

//    public LicenciaDAO(IConexion conexion) {
//        this.conexion = conexion;
//    }
    public LicenciaDAO() {
        conexion = new ConexionJPA("bda.itson_SistemaTramitesPersistencia_jar_1.0-SNAPSHOTPU");
    }

    /**
     * Método para registrar una licencia
     *
     * @param licencia Licencia a registrar
     * @return true si se registró correctamente, false en caso contrario
     * @throws PersistenciaException
     */
    @Override
    public boolean registrarLicencia(Licencia licencia) throws PersistenciaException {
        EntityManager entityManager = null;
        try {
            entityManager = conexion.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(licencia);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al realizar la solicitud de registro de licencia", ex);
        } finally {
            conexion.close();
        }

    }

    /**
     * Actualiza una licencia en la base de datos.
     *
     * @param licencia La licencia que se actualizará en la base de datos.
     * @return true si la licencia se actualizó correctamente, false en caso
     * contrario.
     * @throws PersistenciaException Si ocurre un error durante la actualización
     * de la licencia.
     */
    @Override
    public boolean actualizarLicencia(Licencia licencia) throws PersistenciaException {
        EntityManager entityManager = null;
        try {
            entityManager = conexion.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(licencia); // Utilizamos merge en lugar de persist para actualizar la licencia existente
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al actualizar la licencia", ex);
        } finally {
            conexion.close();
        }
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

    /**
     * Método para obtener licencias a partir de un periodo entre dos fechas.
     *
     * @param fechaInicio Fecha de inicio del periodo
     * @param fechaFin Fecha de fin del periodo
     * @return Lista de licencias en el periodo especificado
     * @throws PersistenciaException
     *
     */
    @Override
    public List<Licencia> obtenerLicenciasPorPeriodo(Persona persona, Calendar fechaInicio, Calendar fechaFin) throws PersistenciaException {

        EntityManager entityManager = null;
        try {
            entityManager = conexion.getEntityManager();
            TypedQuery<Licencia> query = entityManager.createQuery(
                    "SELECT l FROM Licencia l JOIN l.persona per WHERE per.id= :personaId AND l.fechaExpedicion BETWEEN :fechaInicio AND :fechaFin ORDER BY l.fechaExpedicion DESC",
                    Licencia.class);
            query.setParameter("personaId", persona.getId());
            query.setParameter("fechaInicio", fechaInicio);
            query.setParameter("fechaFin", fechaFin);
            return query.getResultList();
        } catch (Exception ex) {
            throw new PersistenciaException("Error al realizar la solicitud de consulta de licencias", ex);
        } finally {
            conexion.close();
        }
    }
/**
 * Metodo para obtener la licencia activa de una persona si la hay
 * @param persona
 * @return licencia activa, null si es que no hay una licencia activa
 * @throws PersistenciaException 
 */
    @Override
    public Licencia obtenerLicenciaActiva(Persona persona) throws PersistenciaException {
        EntityManager entityManager = null;
        Licencia licencia = null;
        try {
            entityManager = conexion.getEntityManager();
            TypedQuery<Licencia> query = entityManager.createQuery(
                    "SELECT l FROM Licencia l WHERE l.persona.id = :personaId AND l.estado = 'no expirada'",
                    Licencia.class);
            query.setParameter("personaId", persona.getId());
            // Obtener la licencia activa
            licencia = query.getSingleResult();
        } catch (NoResultException ex) {
            licencia = null;
        } catch (Exception ex) {
            throw new PersistenciaException("Error al realizar la solicitud de consulta de licencias", ex);
        } finally {
            conexion.close();
        }
        return licencia;
    }
/**
 * Metodo que regresa una lista con todas las licencias asociadas con una persona
 * @param persona
 * @return Lista de licencias
 * @throws PersistenciaException 
 */
    @Override
    public List<Licencia> obtenerLicenciasPorPersona(Persona persona) throws PersistenciaException {

        EntityManager entityManager = null;
        try {
            entityManager = conexion.getEntityManager();
            TypedQuery<Licencia> query = entityManager.createQuery(
                    "SELECT l FROM Licencia l JOIN l.persona per WHERE per.id= :personaId ORDER BY l.fechaExpedicion DESC", Licencia.class);
            query.setParameter("personaId", persona.getId());
            return query.getResultList();
        } catch (Exception ex) {
            throw new PersistenciaException("Error al realizar la solicitud de consulta de licencias", ex);
        } finally {
            conexion.close();
        }
    }

}
