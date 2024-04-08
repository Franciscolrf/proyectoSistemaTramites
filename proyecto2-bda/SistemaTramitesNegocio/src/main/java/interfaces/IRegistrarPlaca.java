/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import dtos.PersonaDTO;
import dtos.PlacaDTO;
import dtos.VehiculoDTO;
import java.util.List;

/**
 *
 * @author abelc interfaz para el registro y acciones necesarias relacionadas a placas
 */
public interface IRegistrarPlaca {

    /**
     * Registra una nueva placa en el sistema.
     *
     * @param placaDTO El objeto PlacaDTO que contiene la información de la
     * placa a registrar.
     */
    void registrarPLaca(PlacaDTO placaDTO);

    /**
     * Obtiene una lista de vehículos asociados a una persona.
     *
     * @param persona El objeto PersonaDTO que representa a la persona para la
     * cual se desean obtener los vehículos.
     * @return Lista de objetos VehiculoDTO asociados a la persona.
     */
    List<VehiculoDTO> obtenerVehiculosDePersona(PersonaDTO persona);

    /**
     * Genera una nueva placa en el sistema.
     *
     * @param placaDTO El objeto PlacaDTO que contiene la información de la
     * placa a generar.
     */
    void generarPlaca(PlacaDTO placaDTO);

    /**
     * Busca un vehículo por su número de serie en el sistema.
     *
     * @param numeroSerie El número de serie del vehículo que se desea buscar.
     * @return El objeto VehiculoDTO correspondiente al número de serie
     * proporcionado, o null si no se encuentra ningún vehículo con ese número
     * de serie.
     */
    VehiculoDTO buscarVehiculoPorNumeroSerie(String numeroSerie);
}
