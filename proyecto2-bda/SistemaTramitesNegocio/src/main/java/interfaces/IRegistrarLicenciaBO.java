/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import bda.itson.entidadesJPA.Licencia;
import bda.itson.entidadesJPA.Persona;

import dtos.LicenciaDTO;
import dtos.PersonaDTO;
import java.util.List;

/**
 *
 * @author fabri
 *
 * Interfaz que define las operaciones para el registro y búsqueda de licencias.
 */
public interface IRegistrarLicenciaBO {

    /**
     * Método para registrar una licencia en el sistema.
     *
     * @param licencia La licencia a registrar.
     */
    void registrarLicencia(LicenciaDTO licencia);

    /**
     * Método para buscar personas en el sistema según un parámetro de búsqueda.
     *
     * @param buscarParametro El parámetro de búsqueda para buscar personas.
     * @return Una lista de objetos PersonaDTO que coinciden con el parámetro de búsqueda.
     */
    List<PersonaDTO> buscarPersonas(String buscarParametro);

    /**
     * Método para asignar valores a una licencia antes de ser registrada.
     *
     * @param licenciaDTO La licencia a la cual se le asignarán los valores.
     */
    void asignarValoresLicencia(LicenciaDTO licenciaDTO);
    /**
     * Metodo que sirve como validador que una persona tenga una licencia activa o no al momento de ser seleccionada
     * @param persona
     * @return dependiendo de lo establecido lanzara un mensaje
     */
    boolean verificarLicenciaActiva(PersonaDTO persona);
    /**
     * Obtiene una lista de todas las personas registradas en el sistema.
     *
     * @return Lista de objetos PersonaDTO que representan a todas las personas
     * registradas en el sistema.
     */
    public List<PersonaDTO> obtenerPersonas();
}


