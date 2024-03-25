/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import bda.itson.entidadesJPA.Licencia;
import bda.itson.entidadesJPA.Persona;
import dao.LicenciaDAO;
import dao.PersonaDAO;
import dtos.LicenciaDTO;
import dtos.PersonaDTO;
import excepciones.PersistenciaException;
import interfaces.ILicencia;
import interfaces.IRegistrarLicenciaBO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabri
 */
public class RegistrarLicencia implements IRegistrarLicenciaBO {
    
    private final ILicencia licenciaDAO;
    PersonaDAO personaDAO;

    public RegistrarLicencia() {
        this.licenciaDAO = new LicenciaDAO();
        this.personaDAO = new PersonaDAO();
       
    }
     /**
     * Registra una licencia a partir de un objeto LicenciaDTO.
     * Convierte el objeto DTO a un objeto Licencia y lo pasa al LicenciaDAO para su registro.
     * 
     * @param licenciaDTO Objeto LicenciaDTO que contiene la información de la licencia a registrar.
     */
    @Override
    public void registrarLicencia(LicenciaDTO licenciaDTO) {
        
        try {
            Licencia licencia = convertirALicencia(licenciaDTO);
            
            licenciaDAO.registrarLicencia(licencia);
        } catch (PersistenciaException ex) {
            Logger.getLogger(RegistrarLicencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

//    private LicenciaDTO convertirALicenciaDTO(Licencia licencia) {
//        LicenciaDTO licenciaDTO = new LicenciaDTO();
//        licenciaDTO.setIdLicencia(licencia.getIdLicencia());
//        licenciaDTO.setCosto(licencia.getCosto());
//        licenciaDTO.setEstadoActual(convertirEstadoLicencia(licencia.getEstadoActual()));
//        licenciaDTO.setFechaExpedicion(licencia.getFechaExpedicion());
//        licenciaDTO.setFechaVencimiento(licencia.getFechaVencimiento());
//        licenciaDTO.setPersona(licencia.getPersona());
//        return licenciaDTO;
//    }
    
     /**
     * Busca personas según un parámetro de búsqueda y devuelve una lista de objetos PersonaDTO.
     * 
     * @param buscarParametro Parámetro de búsqueda para encontrar personas.
     * @return Lista de objetos PersonaDTO que satisfacen el criterio de búsqueda.
     */
    private Licencia convertirALicencia(LicenciaDTO licenciaDTO) {
        Licencia licencia = new Licencia();
        licencia.setCosto(licenciaDTO.getCosto());
        licencia.setFechaExpedicion(licenciaDTO.getFechaExpedicion());
        licencia.setFechaVencimiento(licenciaDTO.getFechaVencimiento());
        licencia.setPersona(convertirAPersona(licenciaDTO.getPersona()));
        licencia.setVigencia(licenciaDTO.getVigencia());
        return licencia;
    }
    /**
     * Busca personas según un parámetro de búsqueda y devuelve una lista de objetos PersonaDTO.
     * 
     * @param buscarParametro Parámetro de búsqueda para encontrar personas.
     * @return Lista de objetos PersonaDTO que satisfacen el criterio de búsqueda.
     */
    @Override
    public List<PersonaDTO> buscarPersonas(String buscarParametro) {
        List<PersonaDTO> personasRegistradasDTO = new ArrayList<>();

        // Obtener la lista de personas del DAO
        List<Persona> personasRegistradas = null;
        try {
            personasRegistradas = licenciaDAO.buscarPersonas(buscarParametro);
        } catch (PersistenciaException ex) {
            Logger.getLogger(RegistrarLicencia.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Convertir cada persona a DTO y agregarla a la lista de DTOs
        for (Persona persona : personasRegistradas) {
            PersonaDTO personaDTO = convertirAPersonaDTO(persona);
            personasRegistradasDTO.add(personaDTO);
        }
        
        return personasRegistradasDTO;
    }
    
     /**
     * Convierte un objeto PersonaDTO a un objeto Persona.
     * 
     * @param personaDTO Objeto PersonaDTO a convertir.
     * @return Objeto Persona convertido.
     */
    private Persona convertirAPersona(PersonaDTO personaDTO) {
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
    private PersonaDTO convertirAPersonaDTO(Persona persona) {
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
     * Asigna valores a una licencia según su vigencia y la condición de discapacidad de la persona.
     * 
     * @param licenciaDTO Objeto LicenciaDTO al que se le asignarán los valores.
     */
    @Override
    public void asignarValoresLicencia(LicenciaDTO licenciaDTO) {
        Calendar fechaActual = Calendar.getInstance();
        licenciaDTO.setFechaExpedicion(fechaActual);
        Calendar fechaVencimiento = Calendar.getInstance();
        fechaVencimiento.add(Calendar.YEAR, licenciaDTO.getVigencia());
        licenciaDTO.setFechaVencimiento(fechaVencimiento);
        int Vigencia = licenciaDTO.getVigencia();
        if (Vigencia == 1) {
            if (licenciaDTO.getPersona().isEsDiscapacitado()) {
                licenciaDTO.setCosto(200);
            } else {
                licenciaDTO.setCosto(600);
            }
        } else if (Vigencia == 2) {
            if (licenciaDTO.getPersona().isEsDiscapacitado()) {
                licenciaDTO.setCosto(500);
            } else {
                licenciaDTO.setCosto(900);
            }
        } else if (Vigencia == 3) {
            if (licenciaDTO.getPersona().isEsDiscapacitado()) {
                licenciaDTO.setCosto(700);
            } else {
                licenciaDTO.setCosto(1100);
            }
        }
    }
    
    
}
