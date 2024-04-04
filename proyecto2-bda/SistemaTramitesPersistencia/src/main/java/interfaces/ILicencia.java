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
     * @throws PersistenciaException
     */
    public boolean registrarLicencia(Licencia licencia) throws PersistenciaException;

    /**
     * Método para obtener una licencia a partir de un parametro de busqueda
     *
     * @param buscarParametro Parámetro de busqueda
     * @return Licencia con el parametro de busqueda especificado
     * @throws PersistenciaException
     */
    public List<Persona> buscarPersonas(String buscarParametro) throws PersistenciaException;

    /**
     * Método para obtener licencias a partir de un periodo entre dos fechas.
     *
     * @param fechaInicio Fecha de inicio del periodo
     * @param fechaFin Fecha de fin del periodo
     * @return Lista de licencias en el periodo especificado
     * @throws PersistenciaException
     *
     */
    public List<Licencia> obtenerLicenciasPorPeriodo(Persona persona, Calendar fechaInicio, Calendar fechaFin) throws PersistenciaException;

    public List<Licencia> obtenerLicenciasPorPersona(Persona persona)throws PersistenciaException;;

    public Licencia obtenerLicenciaActiva(Persona persona) throws PersistenciaException;
}
