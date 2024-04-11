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
 * Esta clase proporciona métodos para realizar consultas relacionadas con
 * licencias y placas. Implementa la interfaz IConsultas.
 *
 * @author abelc
 */
public class Consultas implements IConsultas {

    Conversiones conversiones;
    ILicencia licenciaDAO;
    IPlacaDAO placaDAO;

    /**
     * Constructor de la clase Consultas. Inicializa las instancias de las
     * clases DAO necesarias.
     */
    public Consultas() {
        conversiones = new Conversiones();
        licenciaDAO = new LicenciaDAO();
        placaDAO = new PlacaDAO();
    }

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

    /**
     * Obtiene una lista de todas las licencias emitidas para una persona.
     *
     * @param personaDTO El objeto PersonaDTO que representa a la persona para
     * la cual se desean consultar las licencias.
     * @return Lista de objetos LicenciaDTO emitidos para la persona.
     */
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

    /**
     * Obtiene una lista de todas las placas tramitadas para una persona.
     *
     * @param personaDTO El objeto PersonaDTO que representa a la persona para
     * la cual se desean consultar las placas tramitadas.
     * @return Lista de objetos PlacaDTO tramitadas para la persona.
     */
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

    public PlacaDTO consultarPlacaPorCodigo(String codigo) {
        Placa placa = null;
        PlacaDTO placaDTO = new PlacaDTO();

        try {

            placa = placaDAO.buscarPlacaCodigo(codigo);
            if (placa == null) {
                throw new PersistenciaException("La placa no se encuentra en la base de datos");
            } else {
                placaDTO = conversiones.placaAPlacaDTO(placa);

            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return placaDTO;

    }

}
