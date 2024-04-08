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
 *
 * Interfaz que define métodos para realizar consultas relacionadas con licencias y placas.
 */
public interface IConsultas {

    /**
     * Obtiene una lista de licencias emitidas para una persona durante un período de tiempo específico.
     *
     * @param personaDTO El objeto PersonaDTO que representa a la persona para la cual se desean consultar las licencias.
     * @param fechaInicio La fecha de inicio del período de tiempo.
     * @param fechaFin La fecha de fin del período de tiempo.
     * @return Lista de objetos LicenciaDTO emitidos para la persona durante el período de tiempo especificado.
     */
    List<LicenciaDTO> obtenerLicenciasPorPeriodo(PersonaDTO personaDTO, Calendar fechaInicio, Calendar fechaFin);

    /**
     * Obtiene una lista de todas las licencias emitidas para una persona.
     *
     * @param personaDTO El objeto PersonaDTO que representa a la persona para la cual se desean consultar las licencias.
     * @return Lista de objetos LicenciaDTO emitidos para la persona.
     */
    List<LicenciaDTO> obtenerLicenciasPorPersona(PersonaDTO personaDTO);

    /**
     * Obtiene una lista de placas tramitadas para una persona durante un período de tiempo específico.
     *
     * @param personaDTO El objeto PersonaDTO que representa a la persona para la cual se desean consultar las placas tramitadas.
     * @param fechaInicio La fecha de inicio del período de tiempo.
     * @param fechaFin La fecha de fin del período de tiempo.
     * @return Lista de objetos PlacaDTO tramitadas para la persona durante el período de tiempo especificado.
     */
    List<PlacaDTO> obtenerPlacasPorPeriodo(PersonaDTO personaDTO, Calendar fechaInicio, Calendar fechaFin);

    /**
     * Obtiene una lista de todas las placas tramitadas para una persona.
     *
     * @param personaDTO El objeto PersonaDTO que representa a la persona para la cual se desean consultar las placas tramitadas.
     * @return Lista de objetos PlacaDTO tramitadas para la persona.
     */
    List<PlacaDTO> obtenerPlacasPorPersona(PersonaDTO personaDTO);
}
