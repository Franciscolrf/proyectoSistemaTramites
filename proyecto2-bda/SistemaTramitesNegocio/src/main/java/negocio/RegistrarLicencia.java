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
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import otros.Conversiones;
import otros.Encriptacion;

/**
 * Esta clase proporciona metodos para realizar todas las operacionas
 * relacionadas al registro de licencias
 *
 * @author fabri
 */
public class RegistrarLicencia implements IRegistrarLicenciaBO {

    private final ILicencia licenciaDAO;
    private final Conversiones conversiones;
    private final PersonaDAO personaDAO;

    public RegistrarLicencia() {
        this.licenciaDAO = new LicenciaDAO();
        this.conversiones = new Conversiones();
        this.personaDAO = new PersonaDAO();

    }

    /**
     * Registra una licencia a partir de un objeto LicenciaDTO. Convierte el
     * objeto DTO a un objeto Licencia y lo pasa al LicenciaDAO para su
     * registro.
     *
     * @param licenciaDTO Objeto LicenciaDTO que contiene la información de la
     * licencia a registrar.
     */
    @Override
    public void registrarLicencia(LicenciaDTO licenciaDTO) {

        try {
            Licencia licencia = conversiones.LicenciaDTOALicencia(licenciaDTO);
            licencia.setEstado("No expirada");
            licenciaDAO.registrarLicencia(licencia);
        } catch (PersistenciaException ex) {
            Logger.getLogger(RegistrarLicencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Busca personas según un parámetro de búsqueda y devuelve una lista de
     * objetos PersonaDTO.
     *
     * @param buscarParametro Parámetro de búsqueda para encontrar personas.
     * @return Lista de objetos PersonaDTO que satisfacen el criterio de
     * búsqueda.
     */
    @Override
    public List<PersonaDTO> buscarPersonas(String buscarParametro) {
        List<PersonaDTO> personasRegistradasDTO = new ArrayList<>();

        // Obtener la lista de personas del DAO
        List<Persona> personasRegistradas = null;
        try {
            personasRegistradas = personaDAO.buscarPersonas(buscarParametro);
        } catch (PersistenciaException ex) {
            Logger.getLogger(RegistrarLicencia.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Convertir cada persona a DTO y agregarla a la lista de DTOs
        for (Persona persona : personasRegistradas) {
            try {
                persona.setTelefono(Encriptacion.desencriptarTelefono(persona.getTelefono()));
            } catch (Exception ex) {
                Logger.getLogger(RegistrarLicencia.class.getName()).log(Level.SEVERE, null, ex);
            }
            PersonaDTO personaDTO = conversiones.convertirAPersonaDTO(persona);
            personasRegistradasDTO.add(personaDTO);
        }

        return personasRegistradasDTO;
    }

    /**
     * Asigna valores a una licencia según su vigencia y la condición de
     * discapacidad de la persona.
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

    /**
     * Verifica si una persona tiene una licencia activa y dentro del período de
     * validez.
     *
     * @param personadto El objeto PersonaDTO que representa a la persona cuya
     * licencia se desea verificar.
     * @return true si la persona tiene una licencia activa y dentro del período
     * de validez, false de lo contrario.
     */
    @Override
    public boolean verificarLicenciaActiva(PersonaDTO personadto) {
        Persona persona = conversiones.PersonaDTOAPersona(personadto);
        try {

            Licencia licenciaActiva = licenciaDAO.obtenerLicenciaActiva(persona);

            if (licenciaActiva != null) {

                Calendar fechaActual = Calendar.getInstance();
                Calendar fechaVencimiento = licenciaActiva.getFechaVencimiento();
                if (fechaVencimiento != null && fechaVencimiento.before(fechaActual)) {

                    licenciaActiva.setEstado("expirada");
                    licenciaDAO.actualizarLicencia(licenciaActiva);
                    System.out.println("La licencia ha expirado y se ha actualizado.");
                    return false;
                } else {
                    System.out.println("La licencia está activa y dentro del período de validez.");
                    return true;
                }
            } else {
                System.out.println("No hay licencia activa para la persona.");
                return false;
            }
        } catch (PersistenciaException ex) {
            System.out.println("Error al obtener la licencia activa.");
            return false;
        }
    }

    /**
     * Actualiza el estado de una licencia a "expirada".
     *
     * @param licenciaDTO El objeto LicenciaDTO que representa la licencia a
     * actualizar.
     */
    private void actualizarLicencia(LicenciaDTO licenciaDTO) {
        licenciaDTO.setEstadoActual(LicenciaDTO.estadoDTO.EXPIRADA);
        Licencia licencia = conversiones.LicenciaDTOALicencia(licenciaDTO);
        try {
            licenciaDAO.actualizarLicencia(licencia);
        } catch (PersistenciaException ex) {
            Logger.getLogger(RegistrarLicencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Obtiene una lista de todas las personas registradas en el sistema.
     *
     * @return Lista de objetos PersonaDTO que representan a todas las personas
     * registradas en el sistema.
     */
    public List<PersonaDTO> obtenerPersonas() {
        List<PersonaDTO> personasRegistradasDTO = new ArrayList<>();

        // Obtener la lista de personas del DAO
        List<Persona> personasRegistradas = null;
        try {
            personasRegistradas = personaDAO.obtenerTodasLasPersonas();
        } catch (PersistenciaException ex) {
            Logger.getLogger(RegistrarLicencia.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Convertir cada persona a DTO y agregarla a la lista de DTOs
        for (Persona persona : personasRegistradas) {
            try {
                persona.setTelefono(Encriptacion.desencriptarTelefono(persona.getTelefono()));
            } catch (Exception ex) {
                Logger.getLogger(RegistrarLicencia.class.getName()).log(Level.SEVERE, null, ex);
            }
            PersonaDTO personaDTO = conversiones.convertirAPersonaDTO(persona);
            personasRegistradasDTO.add(personaDTO);
        }

        return personasRegistradasDTO;
    }
}
