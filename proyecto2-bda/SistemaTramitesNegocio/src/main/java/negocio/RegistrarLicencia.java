/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import bda.itson.entidadesJPA.Licencia;
import dao.LicenciaDAO;
import dtos.LicenciaDTO;
import excepciones.PersistenciaException;
import interfaces.IRegistrarLicenciaBO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabri
 */
public class RegistrarLicencia implements IRegistrarLicenciaBO {

    private final LicenciaDAO licenciaDAO;

    public RegistrarLicencia() {
        this.licenciaDAO = new LicenciaDAO();
    }

    @Override
    public void registrarLicencia(LicenciaDTO licenciaDTO) {
        try {
            if (licenciaDTO.getPersona() == null) {
                throw new PersistenciaException("No existe el cliente, por favor, enlace correctamente en el sistema al cliente con el tramite");
            }
            if (licenciaDTO.getPersona().getRFC() == null) {
                throw new PersistenciaException("El cliente no tiene un RFC valido, corrije primero el RFC");
            }
            if (licenciaDTO.getPersona().getNombres() == null || licenciaDTO.getPersona().getNombres().equals("")) {
                throw new PersistenciaException("Modifique el nombre del cliente");

            }
            if (licenciaDTO.getPersona().getTelefono() == null || licenciaDTO.getPersona().getTelefono().equals("")) {
                throw new PersistenciaException("Error en el telefono asociado con el cliente, verifique los datos del cliente");

            }
            if (licenciaDTO.getPersona().getFechaNacimiento() == null) {
                throw new PersistenciaException("Error en la fecha de nacimiento del cliente, verifique los datos del cliente");

            } else {
                Licencia licencia = convertirALicencia(licenciaDTO);
                licenciaDAO.registrarLicencia(licencia);
                System.out.println("\nNombre: "+licencia.getPersona().getNombres());
                System.out.println("\nRFC: "+licencia.getPersona().getRFC());
                System.out.println("\nTelefono: "+licencia.getPersona().getTelefono());
                System.out.println("\nFecha de nacimiento: "+licencia.getPersona().getFechaNacimiento());
            }

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
    private Licencia convertirALicencia(LicenciaDTO licenciaDTO) {
        Licencia licencia = new Licencia();
        licencia.setCosto(licenciaDTO.getCosto());
        licencia.setFechaExpedicion(licenciaDTO.getFechaExpedicion());
        licencia.setFechaVencimiento(licenciaDTO.getFechaVencimiento());
        licencia.setIdLicencia(licenciaDTO.getIdLicencia());
        licencia.setPersona(licenciaDTO.getPersona());
                return licencia;
    }


}
