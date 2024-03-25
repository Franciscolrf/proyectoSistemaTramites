/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.Calendar;
import java.util.List;
import excepciones.PersistenciaException;

import bda.itson.entidadesJPA.Placa;

/**
 *
 * @author ID145
 */
public interface IPlacaDAO {
    /**
     * Método que agrega una placa
     * 
     * @param placa Placa a agregar
     * @return Placa agregada
     * @throws PersistenciaException Si ocurre un error al agregar la placa
     */
    public Placa agregar(Placa placa) throws PersistenciaException;

    /**
     * Método para consultar una placa por su id.
     * 
     * @param idPlaca Identificador de la placa a consultar.
     * @return Placa consultada.
     * @throws PersistenciaException Si ocurre un error al consultar la placa.
     */
    public Placa consultar(Long idPlaca) throws PersistenciaException;

    /**
     * Método para consultar las placas tramitadas entre dos fechas.
     * 
     * @param fechaInicio Fecha de inicio del rango de búsqueda.
     * @param fechaFin    Fecha de fin del rango de búsqueda.
     * @return Lista de placas tramitadas entre las fechas especificadas.
     * @throws PersistenciaException Si ocurre un error al consultar las placas.
     */

    public List<Placa> consultarPlacasTramitadasPorPeriodo(Calendar fechaInicio, Calendar fechaFin)
            throws PersistenciaException;
}
