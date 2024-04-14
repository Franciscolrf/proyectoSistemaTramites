/**
 * RegistrarPlaca.java
 *
 * Clase creada en Abril de 2024
 */
package negocio;

import bda.itson.entidadesJPA.Placa;
import bda.itson.entidadesJPA.Vehiculo;
import dao.PlacaDAO;
import dao.VehiculoDAO;
import dtos.PersonaDTO;
import dtos.PlacaDTO;
import dtos.VehiculoDTO;
import excepciones.PersistenciaException;
import interfaces.IPlacaDAO;
import interfaces.IRegistrarPlaca;
import interfaces.IVehiculoDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import otros.Conversiones;
import otros.GeneradorPlacas;

/**
 * Esta clase se encarga de gestionar el registro y generación de placas, así
 * como también de realizar consultas relacionadas con los vehículos. Implementa
 * la interfaz IRegistrarPlaca.
 *
 * @author abelc
 *
 */
public class RegistrarPlaca implements IRegistrarPlaca {

    private final IPlacaDAO placaDAO;
    private final Conversiones conversiones;
    private final GeneradorPlacas generadorPlacas;
    private final IVehiculoDAO vehiculoDAO;

    /**
     * Constructor de la clase RegistrarPlaca. Inicializa las instancias de las
     * clases DAO necesarias.
     */
    public RegistrarPlaca() {
        placaDAO = new PlacaDAO();
        conversiones = new Conversiones();
        generadorPlacas = new GeneradorPlacas();
        vehiculoDAO = new VehiculoDAO();
    }

    /**
     * Registra una nueva placa en la base de datos.
     *
     * @param placaDTO El objeto PlacaDTO que contiene la información de la
     * placa a registrar.
     */
    @Override
    public void registrarPLaca(PlacaDTO placaDTO) {
        actualizarPlacaAnterior(placaDTO);
        Placa placa = new Placa();
        placa = conversiones.PlacaDTOAPlaca(placaDTO);
        try {
            placaDAO.agregar(placa);
        } catch (PersistenciaException ex) {
            Logger.getLogger(RegistrarPlaca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Genera una nueva placa.
     *
     * @param placaDTO El objeto PlacaDTO que contiene la información de la
     * placa a generar.
     */
    @Override
    public void generarPlaca(PlacaDTO placaDTO) {
        generadorPlacas.generarPlaca(placaDTO);
    }

    /**
     * Obtiene una lista de los vehículos asociados a una persona.
     *
     * @param persona El objeto PersonaDTO para el cual se desean consultar los
     * vehículos.
     * @return Lista de objetos VehiculoDTO asociados a la persona.
     */
    @Override
    public List<VehiculoDTO> obtenerVehiculosDePersona(PersonaDTO persona) {
        List<VehiculoDTO> vehiculosDTO = new ArrayList<>();
        List<Vehiculo> vehiculos = null;
        try {
            vehiculos = vehiculoDAO.consultarVehiculosPersona(conversiones.PersonaDTOAPersona(persona));
        } catch (PersistenciaException ex) {
            Logger.getLogger(RegistrarPlaca.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Vehiculo vehiculo : vehiculos) {
            VehiculoDTO vehiculoDTO = conversiones.VehiculoAVehiculoDTO(vehiculo);
            vehiculosDTO.add(vehiculoDTO);
        }
        return vehiculosDTO;
    }

    /**
     * Busca un vehículo por su número de serie.
     *
     * @param numeroSerie El número de serie del vehículo que se desea buscar.
     * @return El objeto VehiculoDTO correspondiente al número de serie
     * proporcionado, o null si no se encuentra ningún vehículo con ese número
     * de serie.
     */
    @Override
    public VehiculoDTO buscarVehiculoPorNumeroSerie(String numeroSerie) {
        VehiculoDTO vehiculoDTO = new VehiculoDTO();
        try {
            vehiculoDTO = conversiones.VehiculoAVehiculoDTO(vehiculoDAO.consultarNumeroSeria(numeroSerie));
        } catch (PersistenciaException ex) {
            Logger.getLogger(RegistrarPlaca.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehiculoDTO;
    }

    /**
     * Actualiza el estado de la última placa activa asociada a un vehículo para
     * marcarla como inactiva.
     *
     * @param placaDTO El objeto PlacaDTO que contiene la información de la
     * nueva placa a registrar, utilizado para obtener la información del
     * vehículo asociado.
     */
    private void actualizarPlacaAnterior(PlacaDTO placaDTO) {
        try {
            Placa placa = placaDAO.obtenerUltimaPlacaPorVehiculo(conversiones.VehiculoDTOAVehiculo(placaDTO.getVehiculo()));
            if (placa != null && placa.getEstado().equals("activa")) {
                placa.setEstado("inactiva");
                placa.setFechaRecepcion(placaDTO.getFechaExpedicion());
                placaDAO.actualizar(placa); // Actualizar la placa en la base de datos
            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(RegistrarPlaca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}
