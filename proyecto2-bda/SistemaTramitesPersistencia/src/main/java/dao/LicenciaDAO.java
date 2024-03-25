package dao;

import bda.itson.entidadesJPA.Licencia;
import bda.itson.entidadesJPA.Persona;
import excepciones.PersistenciaException;
import interfaces.IConexion;
import interfaces.ILicencia;
import java.util.List;
import javax.persistence.EntityManager;
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

    public LicenciaDAO(){
        conexion = new ConexionJPA("bda.itson_SistemaTramitesPersistencia_jar_1.0-SNAPSHOTPU");
    }

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

    @Override
    public List<Persona> buscarPersonas(String buscarParametro) throws PersistenciaException {
      EntityManager entityManager = null;
    entityManager = conexion.getEntityManager();
    TypedQuery<Persona> query = entityManager.createQuery(
            "SELECT p FROM Persona p WHERE p.RFC LIKE :parametro OR p.nombres LIKE :parametro",
            Persona.class);
    query.setParameter("parametro", "%" + buscarParametro + "%");
    return query.getResultList();
    }

}