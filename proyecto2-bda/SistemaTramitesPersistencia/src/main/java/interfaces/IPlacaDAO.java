/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import bda.itson.entidadesJPA.Persona;
import java.util.Calendar;
import java.util.List;
import excepciones.PersistenciaException;

import bda.itson.entidadesJPA.Placa;
import bda.itson.entidadesJPA.Vehiculo;

/**
 *Interface para la clase placaDAO
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
     * @param persona Persona a la que le pertenecen las placas
     * @param fechaInicio Fecha de inicio del rango de búsqueda.
     * @param fechaFin Fecha de fin del rango de búsqueda.
     * @return Lista de placas tramitadas entre las fechas especificadas.
     * @throws PersistenciaException Si ocurre un error al consultar las placas.
     */
    public List<Placa> consultarPlacasTramitadasPorPeriodo(Persona persona, Calendar fechaInicio, Calendar fechaFin)
            throws PersistenciaException;

    /**
     * Consulta las placas tramitadas por una persona.
     *
     * @param persona La persona para la cual se desean consultar las placas
     * tramitadas.
     * @return Lista de placas tramitadas por la persona.
     * @throws PersistenciaException Si hay un error durante la consulta.
     */
    public List<Placa> consultarPlacasTramitadasPorPersona(Persona persona) throws PersistenciaException;

    /**
     * Busca una placa por su código.
     *
     * @param codigo El código de la placa a buscar.
     * @return La placa correspondiente al código proporcionado, o null si no se
     * encuentra ninguna placa con ese código.
     * @throws PersistenciaException Si hay un error durante la consulta.
     */
    public Placa buscarPlacaCodigo(String codigo) throws PersistenciaException;

    /**
     * Actualiza la información de una placa en la base de datos.
     *
     * @param placa La placa que se desea actualizar.
     * @return La placa actualizada.
     * @throws PersistenciaException Si hay un error durante la actualización.
     */
    public Placa actualizar(Placa placa) throws PersistenciaException;

    /**
     * Obtiene la última placa registrada para un vehículo.
     *
     * @param vehiculo El vehículo para el cual se desea obtener la última
     * placa.
     * @return La última placa registrada para el vehículo, o null si no hay
     * ninguna placa registrada para el vehículo.
     * @throws PersistenciaException Si hay un error durante la consulta.
     */
    public Placa obtenerUltimaPlacaPorVehiculo(Vehiculo vehiculo) throws PersistenciaException;
}
