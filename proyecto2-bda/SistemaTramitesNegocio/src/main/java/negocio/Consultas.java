/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import bda.itson.entidadesJPA.Licencia;
import bda.itson.entidadesJPA.Placa;
import dao.LicenciaDAO;
import dao.PlacaDAO;
import dtos.LicenciaDTO;
import dtos.PersonaDTO;
import dtos.PlacaDTO;
import excepciones.PersistenciaException;
import interfaces.IConsultas;
import interfaces.ILicencia;
import interfaces.IPlacaDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import otros.Conversiones;

/**
 *
 * @author abelc
 */
public class Consultas implements IConsultas {
    
    Conversiones conversiones;
    ILicencia licenciaDAO;
    IPlacaDAO placaDAO;
    
    public Consultas() {
        conversiones = new Conversiones();
        licenciaDAO = new LicenciaDAO();
        placaDAO = new PlacaDAO();
    }
    
    @Override
    public List<LicenciaDTO> obtenerLicenciasPorPeriodo(PersonaDTO personaDTO, Calendar fechaInicio, Calendar fechaFin) {
        List<LicenciaDTO> licenciasDTO = new ArrayList<>();
        List<Licencia> licencias = null;
        try {
            licencias = licenciaDAO.obtenerLicenciasPorPeriodo(conversiones.PersonaDTOAPersona(personaDTO), fechaInicio, fechaFin);
        } catch (PersistenciaException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Licencia licencia : licencias) {
            LicenciaDTO licenciaDTO = conversiones.licenciaALicenciaDTO(licencia);
            licenciasDTO.add(licenciaDTO);
        }
        return licenciasDTO;
    }
    
    @Override
    public List<LicenciaDTO> obtenerLicenciasPorPersona(PersonaDTO personaDTO) {
        List<LicenciaDTO> licenciasDTO = new ArrayList<>();
        List<Licencia> licencias = null;
        try {
            licencias = licenciaDAO.obtenerLicenciasPorPersona(conversiones.PersonaDTOAPersona(personaDTO));
        } catch (PersistenciaException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Licencia licencia : licencias) {
            LicenciaDTO licenciaDTO = conversiones.licenciaALicenciaDTO(licencia);
            licenciasDTO.add(licenciaDTO);
        }
        return licenciasDTO;
    }
    
    @Override
    public List<PlacaDTO> obtenerPlacasPorPeriodo(PersonaDTO personaDTO, Calendar fechaInicio, Calendar fechaFin) {
        List<PlacaDTO> placasDTO = new ArrayList<>();
        List<Placa> placas = null;
        try {
            placas = placaDAO.consultarPlacasTramitadasPorPeriodo(conversiones.PersonaDTOAPersona(personaDTO), fechaInicio, fechaFin);
        } catch (PersistenciaException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Placa placa : placas) {
            PlacaDTO placaDTO = conversiones.placaAPlacaDTO(placa);
            placasDTO.add(placaDTO);
        }
        return placasDTO;
    }
    
    @Override
    public List<PlacaDTO> obtenerPlacasPorPersona(PersonaDTO personaDTO) {
        List<PlacaDTO> placasDTO = new ArrayList<>();
        List<Placa> placas = null;
        try {
            placas = placaDAO.consultarPlacasTramitadasPorPersona(conversiones.PersonaDTOAPersona(personaDTO));
        } catch (PersistenciaException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Placa placa : placas) {
            PlacaDTO placaDTO = conversiones.placaAPlacaDTO(placa);
            placasDTO.add(placaDTO);
        }
        return placasDTO;
    }
    
}
