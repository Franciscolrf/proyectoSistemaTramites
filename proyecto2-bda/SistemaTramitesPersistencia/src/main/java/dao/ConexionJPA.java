/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author abelc
 */
import interfaces.IConexion;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexionJPA implements IConexion {

    private final String unidadPersistencia;
    private EntityManager entityManager;

    /**
     * Constructor de la clase ConexionJPA.
     *
     * @param unidadPersistencia El nombre de la unidad de persistencia configurada en persistence.xml.
     */
    public ConexionJPA(String unidadPersistencia) {
        this.unidadPersistencia = unidadPersistencia;
    }

    /**
     * Establece la conexión utilizando EntityManager de JPA.
     *
     * @return Una instancia de EntityManager que permite interactuar con la base de datos.
     */
    @Override
    public EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(unidadPersistencia);
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }

    /**
     * Cierra la conexión.
     */
    @Override
    public void close() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
