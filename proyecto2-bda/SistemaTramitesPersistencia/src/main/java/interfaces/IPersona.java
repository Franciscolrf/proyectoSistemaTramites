/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import bda.itson.entidadesJPA.Persona;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author abelc
 */
public interface IPersona {

    Persona registrarPersona(Persona persona) throws PersistenciaException;

    List<Persona> insercionMasivaPersonas(List<Persona> personas) throws PersistenciaException;
    
  Persona obtenerPersonaRFC(String rfc);
}
