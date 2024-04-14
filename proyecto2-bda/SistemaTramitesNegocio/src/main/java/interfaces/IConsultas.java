/**
 * IConsultas.java
 *
 * Clase creada en Abril de 2024
 */
package interfaces;

import dtos.LicenciaDTO;
import dtos.PersonaDTO;
import dtos.PlacaDTO;
import dtos.VehiculoDTO;
import java.util.Calendar;
import java.util.List;

/**
 * Interfaz que define métodos para realizar consultas relacionadas con
 * licencias y placas.
 *
 * @author abelc
 *
 *
 */
public interface IConsultas {

    /**
     * Obtiene una lista de licencias emitidas para una persona durante un
     * período de tiempo específico.
     *
     * @param personaDTO El objeto PersonaDTO que representa a la persona para
     * la cual se desean consultar las licencias.
     * @param fechaInicio La fecha de inicio del período de tiempo.
     * @param fechaFin La fecha de fin del período de tiempo.
     * @return Lista de objetos LicenciaDTO emitidos para la persona durante el
     * período de tiempo especificado.
     */
    List<LicenciaDTO> obtenerLicenciasPorPeriodo(PersonaDTO personaDTO, Calendar fechaInicio, Calendar fechaFin);

    /**
     * Obtiene una lista de todas las licencias emitidas para una persona.
     *
     * @param personaDTO El objeto PersonaDTO que representa a la persona para
     * la cual se desean consultar las licencias.
     * @return Lista de objetos LicenciaDTO emitidos para la persona.
     */
    List<LicenciaDTO> obtenerLicenciasPorPersona(PersonaDTO personaDTO);

    /**
     * Obtiene una lista de placas tramitadas para una persona durante un
     * período de tiempo específico.
     *
     * @param personaDTO El objeto PersonaDTO que representa a la persona para
     * la cual se desean consultar las placas tramitadas.
     * @param fechaInicio La fecha de inicio del período de tiempo.
     * @param fechaFin La fecha de fin del período de tiempo.
     * @return Lista de objetos PlacaDTO tramitadas para la persona durante el
     * período de tiempo especificado.
     */
    List<PlacaDTO> obtenerPlacasPorPeriodo(PersonaDTO personaDTO, Calendar fechaInicio, Calendar fechaFin);

    /**
     * Obtiene una lista de todas las placas tramitadas para una persona.
     *
     * @param personaDTO El objeto PersonaDTO que representa a la persona para
     * la cual se desean consultar las placas tramitadas.
     * @return Lista de objetos PlacaDTO tramitadas para la persona.
     */
    List<PlacaDTO> obtenerPlacasPorPersona(PersonaDTO personaDTO);

    /**
     * Metodo para buscar un vehiculo por su numero de serie
     *
     * @param numSerie numero de serie del vehiculo
     * @return regresa el vehiculo encontrado
     */
    public VehiculoDTO consultarVehiculos(String numSerie);

    /**
     * Metodo para consultar una placa mediante el codigo
     *
     * @param codigo codigo de la placa
     * @return regesa la placa encontrada
     */
    public PlacaDTO consultarPlacaPorCodigo(String codigo);

    /**
     * Metodo para obtener todos los vehiculos de una persona
     *
     * @param personaDto persona a buscar
     * @return lista de vehiculos de la persona
     */
    public List<VehiculoDTO> consultarVehiculosPorPersona(PersonaDTO personaDto);
}
