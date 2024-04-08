/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import interfaces.IConexion;
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
 *
 * @author abelc
 */
public class RegistrarPlaca implements IRegistrarPlaca {

    private final IPlacaDAO placaDAO;
    private final Conversiones conversiones;
    private final GeneradorPlacas generadorPlacas;
    private final IVehiculoDAO vehiculoDAO;

    public RegistrarPlaca() {
        placaDAO = new PlacaDAO();
        conversiones = new Conversiones();
        generadorPlacas = new GeneradorPlacas();
        vehiculoDAO = new VehiculoDAO();
    }

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

    @Override
    public void generarPlaca(PlacaDTO placaDTO) {
        generadorPlacas.generarPlaca(placaDTO);
    }

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
