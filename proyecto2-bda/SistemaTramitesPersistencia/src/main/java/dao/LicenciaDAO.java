/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bda.itson.entidadesJPA.Licencia;
import excepciones.PersistenciaException;
import interfaces.IConexion;
import interfaces.ILicencia;
import javax.persistence.EntityManager;

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

}
