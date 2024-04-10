/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import bda.itson.entidadesJPA.Licencia;
import bda.itson.entidadesJPA.Persona;
import excepciones.PersistenciaException;
import java.util.Calendar;
import java.util.List;

/**
 * Interfaz para la clase Licencia
 *
 * @author fabri
 */
public interface ILicencia {

    /**
     * Método para registrar una licencia
     *
     * @param licencia Licencia a registrar
     * @return true si se registró correctamente, false en caso contrario
     * @throws PersistenciaException excepcion si falla algo en la operacion
     */
    public boolean registrarLicencia(Licencia licencia) throws PersistenciaException;

    /**
     * Método para obtener una licencia a partir de un parametro de busqueda
     *
     * @param buscarParametro Parámetro de busqueda
     * @return Licencia con el parametro de busqueda especificado
     * @throws PersistenciaException excepcion si falla algo en la operacion
     */
    public List<Persona> buscarPersonas(String buscarParametro) throws PersistenciaException;

    /**
     * Método para obtener licencias a partir de un periodo entre dos fechas.
     *
     * @param persona Persona que le pertenece la licencia
     * @param fechaInicio Fecha de inicio del periodo
     * @param fechaFin Fecha de fin del periodo
     * @return Lista de licencias en el periodo especificado
     * @throws PersistenciaException excepcion si falla algo en la operacion
     *
     */
    public List<Licencia> obtenerLicenciasPorPeriodo(Persona persona, Calendar fechaInicio, Calendar fechaFin) throws PersistenciaException;

    /**
     * Obtiene una lista de todas las licencias emitidas para una persona.
     *
     * @param persona La persona para la cual se desean consultar las licencias.
     * @return Lista de todas las licencias emitidas para la persona.
     * @throws PersistenciaException Si hay un error durante la consulta.
     */
    public List<Licencia> obtenerLicenciasPorPersona(Persona persona) throws PersistenciaException;

    /**
     * Obtiene la licencia activa más reciente emitida para una persona.
     *
     * @param persona La persona para la cual se desean consultar la licencia
     * activa.
     * @return La licencia activa más reciente emitida para la persona, o null
     * si no tiene ninguna licencia activa.
     * @throws PersistenciaException Si hay un error durante la consulta.
     */
    public Licencia obtenerLicenciaActiva(Persona persona) throws PersistenciaException;

    /**
     * Actualiza la información de una licencia en la base de datos.
     *
     * @param licencia La licencia que se desea actualizar.
     * @return true si la licencia se actualizó correctamente, false de lo
     * contrario.
     * @throws PersistenciaException Si hay un error durante la actualización.
     */
    public boolean actualizarLicencia(Licencia licencia) throws PersistenciaException;

}
