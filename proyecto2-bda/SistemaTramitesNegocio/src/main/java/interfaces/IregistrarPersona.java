/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dtos.PersonaDTO;
import java.util.List;

/**
 * @author abelc 
 * Interfaz para el registro de personas en el sistema.
 */
public interface IregistrarPersona {

    /**
     * Método para realizar un registro masivo de personas en el sistema.
     *
     * @param personas Lista de objetos PersonaDTO a registrar.
     * @return True si el registro fue exitoso, False si ocurrió algún error.
     */
    public boolean registroMasivo(List<PersonaDTO> personas);

    /**
     * Método para generar una lista de personas con datos aleatorios.
     *
     * @param cantidad Cantidad de personas a generar.
     * @return Lista de objetos PersonaDTO generados.
     */
    public List<PersonaDTO> generarlista(int cantidad);

    /**
     * Busca una persona por su RFC y la devuelve como un DTO de Persona.
     *
     * @param rfc El RFC de la persona a buscar.
     * @return El DTO de Persona que corresponde al RFC especificado, si se
     * encuentra; de lo contrario, devuelve null.
     */
    public PersonaDTO buscarRFC(String rfc);
}
