/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dtos.LicenciaDTO;
import dtos.PersonaDTO;
import dtos.PlacaDTO;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author abelc
 */
public interface IConsultas {

    List<LicenciaDTO> obtenerLicenciasPorPeriodo(PersonaDTO personaDTO, Calendar fechaInicio, Calendar fechaFin);

     List<LicenciaDTO> obtenerLicenciasPorPersona(PersonaDTO personaDTO);

    List<PlacaDTO> obtenerPlacasPorPeriodo(PersonaDTO personaDTO, Calendar fechaInicio, Calendar fechaFin);

     List<PlacaDTO> obtenerPlacasPorPersona(PersonaDTO personaDTO);
}
