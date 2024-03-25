/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.persistence.EntityManager;

import bda.itson.entidadesJPA.Placa;
import interfaces.IConexion;
import interfaces.IPlacaDAO;

/**
 *
 * @author ID145
 */
public class PlacaDAO implements IPlacaDAO{
    /**
     * Objeto que proporciona la conexión a la base de datos.
     */
    private IConexion conexion;

    /**
     * Constructor de la clase PlacaDAO.
     * @param conexion
     */
    public PlacaDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Registra una nueva placa en la base de datos.
     * @param placa Objeto de tipo Placa que se registrará.
     * @return El objeto Placa registrado.
     */
    @Override
    public Placa agregar(Placa placa) {
        EntityManager entityManager = conexion.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(placa);
        entityManager.getTransaction().commit();
        entityManager.refresh(placa);
        entityManager.close();
        return placa;
    }

    /**
     * Consulta una placa en la base de datos por su identificador.
     * @param idPlaca Identificador de la placa a consultar.
     * @return El objeto Placa consultado.
     */
    @Override
    public Placa consultar(Long idPlaca) {
        EntityManager entityManager = conexion.getEntityManager();
        Placa placa = entityManager.find(Placa.class, idPlaca);
        entityManager.close();
        return placa;
        
    }
    
}
