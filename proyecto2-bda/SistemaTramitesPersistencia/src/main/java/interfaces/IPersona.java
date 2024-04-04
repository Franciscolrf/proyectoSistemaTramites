/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import bda.itson.entidadesJPA.Persona;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *  Interfaz para el registro de personas en el sistema.
 * @author abelc
 */
public interface IPersona {

  /**
   * Metodo para registrar una persona
   * 
   * @param persona Persona a registrar
   * @return Persona registrada
   * @throws PersistenciaException
   */
  Persona registrarPersona(Persona persona) throws PersistenciaException;

  /**
   * Método para inserar masivamente personas en la base de datos.
   * @param personas Lista de personas a insertar.
   * @return Lista de personas insertadas.
   * @throws PersistenciaException
   */
  List<Persona> insercionMasivaPersonas(List<Persona> personas) throws PersistenciaException;

  /**
   * Metodo para obtener una persona por su rfc.
   * @param rfc RFC de la persona a obtener
   * @return Persona con el RFC especificado
   */
  Persona obtenerPersonaRFC(String rfc);
  
  
    /**
     * Método para obtener una licencia a partir de un parametro de busqueda
     *
     * @param buscarParametro Parámetro de busqueda
     * @return Licencia con el parametro de busqueda especificado
     * @throws PersistenciaException
     */
    public List<Persona> buscarPersonas(String buscarParametro) throws PersistenciaException;
}
