/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import bda.itson.entidadesJPA.Licencia;
import bda.itson.entidadesJPA.Licencia.estado;
import dao.LicenciaDAO;
import dtos.LicenciaDTO;
import dtos.LicenciaDTO.estadoDTO;
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

    private Licencia convertirALicencia(LicenciaDTO licenciaDTO) {
        Licencia licencia = new Licencia();
        licencia.setCosto(licenciaDTO.getCosto());
        licencia.setEstadoActual(estado.EXPIRADA);
        licencia.setFechaExpedicion(licenciaDTO.getFechaExpedicion());
        licencia.setFechaVencimiento(licenciaDTO.getFechaVencimiento());
        licencia.setIdLicencia(licenciaDTO.getIdLicencia());
        licencia.setPersona(licenciaDTO.getPersona());
        licencia.setEstadoActual(convertirEstadoLicenciaDTO(licenciaDTO.getEstadoActual()));
        return licencia;
    }
    private estado convertirEstadoLicenciaDTO(estadoDTO estadoDTO) {
        switch (estadoDTO) {
            case NOEXPIRADA -> {
                return estado.NOEXPIRADA;
            }
            case EXPIRADA -> {
                return estado.NOEXPIRADA;
            }

            default ->
                throw new IllegalArgumentException("Estado de licencia no válido");
        }
    }
//    private estadoDTO convertirEstadoLicencia(estado estadoActual) {
//        switch (estadoActual) {
//            case NOEXPIRADA -> {
//                return estadoDTO.NOEXPIRADA;
//            }
//            case EXPIRADA -> {
//                return estadoDTO.NOEXPIRADA;
//            }
//
//            default ->
//                throw new IllegalArgumentException("Estado de licencia no válido");
//        }
//    }

}
