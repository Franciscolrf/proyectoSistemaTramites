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
import interfaces.IConexion;
import interfaces.IPlacaDAO;

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
    public PlacaDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Registra una nueva placa en la base de datos.
     * 
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
     * 
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

    /**
     * Método para consultar las placas tramitadas entre dos fechas.
     * 
     * @param fechaInicio Fecha de inicio del rango de búsqueda.
     * @param fechaFin    Fecha de fin del rango de búsqueda.
     * @return Lista de placas tramitadas entre las fechas especificadas.
     * 
     */
    @Override
    public List<Placa> consultarPlacasTramitadasPorPeriodo(Calendar fechaInicio, Calendar fechaFin) {
        EntityManager entityManager = conexion.getEntityManager();
        TypedQuery<Placa> query = entityManager.createQuery(
                "SELECT p FROM Placa p WHERE p.fechaTramite BETWEEN :fechaInicio AND :fechaFin", Placa.class);
        query.setParameter("fechaInicio", fechaInicio);
        query.setParameter("fechaFin", fechaFin);
        List<Placa> placas = query.getResultList();
        entityManager.close();
        return placas;
    }

}
