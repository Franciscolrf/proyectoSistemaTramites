/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package otros;

import bda.itson.entidadesJPA.Licencia;
import bda.itson.entidadesJPA.Persona;
import bda.itson.entidadesJPA.Placa;
import bda.itson.entidadesJPA.Vehiculo;
import dtos.LicenciaDTO;
import dtos.PersonaDTO;
import dtos.PlacaDTO;
import dtos.VehiculoDTO;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que se encarga de proporcionar las conversiones de DTO a DAO y
 * viceversa
 *
 * @author abelc
 */
public class Conversiones {

    public Conversiones() {
    }

    /**
     * Metodo que se encarga de convertir una licenciaDTO a una licencia entity
     *
     * @param licenciaDTO
     * @return objeto entidad licencia
     */
    public Licencia LicenciaDTOALicencia(LicenciaDTO licenciaDTO) {
        Licencia licencia = new Licencia();
        licencia.setCosto(licenciaDTO.getCosto());
        licencia.setFechaExpedicion(licenciaDTO.getFechaExpedicion());
        licencia.setFechaVencimiento(licenciaDTO.getFechaVencimiento());
        licencia.setPersona(PersonaDTOAPersona(licenciaDTO.getPersona()));
        licencia.setVigencia(licenciaDTO.getVigencia());
        return licencia;
    }

    /**
     * Método que se encarga de convertir una entidad Licencia a un LicenciaDTO
     *
     * @param licencia La entidad Licencia a convertir
     * @return Objeto LicenciaDTO
     */
    public LicenciaDTO licenciaALicenciaDTO(Licencia licencia) {
        LicenciaDTO licenciaDTO = new LicenciaDTO();
        licenciaDTO.setIdLicencia(licencia.getIdLicencia().longValue());
        licenciaDTO.setCosto(licencia.getCosto());
        licenciaDTO.setFechaExpedicion(licencia.getFechaExpedicion());
        licenciaDTO.setFechaVencimiento(licencia.getFechaVencimiento());
        licenciaDTO.setPersona(convertirAPersonaDTO(licencia.getPersona()));
        licenciaDTO.setVigencia(licencia.getVigencia());
        return licenciaDTO;
    }

    /**
     * Convierte un objeto PersonaDTO a un objeto Persona.
     *
     * @param personaDTO Objeto PersonaDTO a convertir.
     * @return Objeto Persona convertido.
     */
    public Persona PersonaDTOAPersona(PersonaDTO personaDTO) {
        Persona persona = new Persona();
        persona.setId(personaDTO.getId());
        persona.setNombres(personaDTO.getNombres());
        persona.setApellidoPaterno(personaDTO.getApellidoPaterno());
        persona.setApellidoMaterno(personaDTO.getApellidoMaterno());
        persona.setFechaNacimiento(personaDTO.getFechaNacimiento());
        persona.setRFC(personaDTO.getRFC());
        persona.setTelefono(personaDTO.getTelefono());
        persona.setEsDiscapacitado(personaDTO.isEsDiscapacitado());
        return persona;
    }

    /**
     * Convierte un objeto Persona a un objeto PersonaDTO.
     *
     * @param persona Objeto Persona a convertir.
     * @return Objeto PersonaDTO convertido.
     */
    public PersonaDTO convertirAPersonaDTO(Persona persona) {
        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO.setId(persona.getId());
        personaDTO.setNombres(persona.getNombres());
        personaDTO.setApellidoPaterno(persona.getApellidoPaterno());
        personaDTO.setApellidoMaterno(persona.getApellidoMaterno());
        personaDTO.setFechaNacimiento(persona.getFechaNacimiento());
        personaDTO.setRFC(persona.getRFC());
        personaDTO.setTelefono(persona.getTelefono());
        personaDTO.setEsDiscapacitado(persona.isEsDiscapacitado());
        return personaDTO;
    }

    /**
     * Convierte una lista de DTO de Vehiculo a una lista de entidades de
     * Vehiculo.
     *
     * @param vehiculosDTO La lista de DTO de Vehiculo a convertir.
     * @return La lista de entidades de Vehiculo generada.
     */
    public List<Vehiculo> convertirVehiculosDTOaEntidad(List<VehiculoDTO> vehiculosDTO) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        for (VehiculoDTO vehiculoDTO : vehiculosDTO) {
            Vehiculo vehiculo = new Vehiculo();
            vehiculo.setMarca(vehiculoDTO.getMarca());
            vehiculo.setModelo(vehiculoDTO.getModelo());
            vehiculo.setLinea(vehiculoDTO.getLinea());
            vehiculo.setNumeroSerie(vehiculoDTO.getNumeroSerie());
            vehiculo.setEstado(vehiculoDTO.getEstado());
            vehiculo.setColor(vehiculoDTO.getColor());
            vehiculo.setTipoVehiculo(vehiculoDTO.getTipoVehiculo());
            vehiculos.add(vehiculo);
        }
        return vehiculos;

    }

    public Vehiculo VehiculoDTOAVehiculo(VehiculoDTO vehiculoDTO) {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setId(vehiculoDTO.getId());
        vehiculo.setNumeroSerie(vehiculoDTO.getNumeroSerie());
        vehiculo.setEstado(vehiculoDTO.getEstado());
        vehiculo.setColor(vehiculoDTO.getColor());
        vehiculo.setModelo(vehiculoDTO.getModelo());
        vehiculo.setMarca(vehiculoDTO.getMarca());
        vehiculo.setLinea(vehiculoDTO.getLinea());
        vehiculo.setColor(vehiculoDTO.getTipoVehiculo());
        vehiculo.setPropietario(PersonaDTOAPersona(vehiculoDTO.getPropietario()));
        return vehiculo;
    }

    public VehiculoDTO VehiculoAVehiculoDTO(Vehiculo vehiculo) {
        VehiculoDTO vehiculoDTO = new VehiculoDTO();
        vehiculoDTO.setId(vehiculo.getId());
        vehiculoDTO.setNumeroSerie(vehiculo.getNumeroSerie());
        vehiculoDTO.setEstado(vehiculo.getEstado());
        vehiculoDTO.setColor(vehiculo.getColor());
        vehiculoDTO.setModelo(vehiculo.getModelo());
        vehiculoDTO.setMarca(vehiculo.getMarca());
        vehiculoDTO.setLinea(vehiculo.getLinea());
        vehiculoDTO.setTipoVehiculo(vehiculo.getTipoVehiculo());
        vehiculoDTO.setPropietario(convertirAPersonaDTO(vehiculo.getPropietario()));
        return vehiculoDTO;
    }

    public Placa PlacaDTOAPlaca(PlacaDTO placaDTO) {
        Placa placa = new Placa();
        placa.setCodigo(placaDTO.getCodigo());
        placa.setCosto(placaDTO.getCosto());
        placa.setEstado(placaDTO.getEstado());
        placa.setFechaExpedicion(placaDTO.getFechaExpedicion());
        placa.setFechaRecepcion(placaDTO.getFechaRecepcion());
        placa.setVehiculo(VehiculoDTOAVehiculo(placaDTO.getVehiculo()));
        return placa;
    }
 public Placa PlacaDTOAPlacaSinVehiculo(PlacaDTO placaDTO) {
        Placa placa = new Placa();
        placa.setCodigo(placaDTO.getCodigo());
        placa.setCosto(placaDTO.getCosto());
        placa.setEstado(placaDTO.getEstado());
        placa.setFechaExpedicion(placaDTO.getFechaExpedicion());
        placa.setFechaRecepcion(placaDTO.getFechaRecepcion());
        return placa;
    }
    public List<Placa> PlacasDTOAPlacas(List<PlacaDTO> placasDTO) {
        List<Placa> placas = new ArrayList<>();
        for (PlacaDTO placaDTO : placasDTO) {
            Placa placa =PlacaDTOAPlacaSinVehiculo(placaDTO);
            placas.add(placa);
        }
        return placas;
    }

    /**
     * Método que se encarga de convertir una entidad Placa a un PlacaDTO
     *
     * @param placa La entidad Placa a convertir
     * @return Objeto PlacaDTO
     */
    public PlacaDTO placaAPlacaDTO(Placa placa) {
        PlacaDTO placaDTO = new PlacaDTO();
        placaDTO.setCodigo(placa.getCodigo());
        placaDTO.setCosto(placa.getCosto());
        placaDTO.setEstado(placa.getEstado());
        placaDTO.setFechaExpedicion(placa.getFechaExpedicion());
        placaDTO.setFechaRecepcion(placa.getFechaRecepcion());
        placaDTO.setVehiculo(VehiculoAVehiculoDTO(placa.getVehiculo()));
        return placaDTO;
    }
}
