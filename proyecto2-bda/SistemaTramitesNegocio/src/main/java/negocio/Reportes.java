/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dtos.LicenciaDTO;
import dtos.PlacaDTO;
import dtos.TramiteReporteDTO;
import interfaces.IReportes;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abelc
 */
public class Reportes implements IReportes {

    public Reportes() {
    }

    @Override
    public List<TramiteReporteDTO> listaReporteLicencias(List<LicenciaDTO> licencias) {
        List<TramiteReporteDTO> listaTramites = new ArrayList<>();
        for (LicenciaDTO licencia : licencias) {
            TramiteReporteDTO tramite = new TramiteReporteDTO();
            String estado = licencia.getEstadoActual() == LicenciaDTO.estadoDTO.EXPIRADA ? "Expirada" : "No expirada";
            tramite.setTramite("Licencia");
            tramite.setCosto(licencia.getCosto());
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            String fechaExp = formatoFecha.format(licencia.getFechaExpedicion().getTime());
            String fechaRec = licencia.getFechaVencimiento() != null ? formatoFecha.format(licencia.getFechaVencimiento().getTime()) : "Vigente";
            tramite.setFecha_Exp(fechaExp);
            tramite.setFecha_Recepcion(fechaRec);
            tramite.setEstado(estado);
            listaTramites.add(tramite);
        }
        return listaTramites;
    }

    @Override
    public List<TramiteReporteDTO> listaReportePlacas(List<PlacaDTO> placas) {
        List<TramiteReporteDTO> listaTramites = new ArrayList<>();
        for (PlacaDTO placa : placas) {
            TramiteReporteDTO tramite = new TramiteReporteDTO();
            tramite.setTramite("Placa");
            tramite.setCosto(placa.getCosto());
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            String fechaExp = formatoFecha.format(placa.getFechaExpedicion().getTime());
            String fechaRec = placa.getFechaRecepcion() != null ? formatoFecha.format(placa.getFechaRecepcion().getTime()) : "Vigente";
            tramite.setFecha_Exp(fechaExp);
            tramite.setFecha_Recepcion(fechaRec);
            tramite.setEstado(placa.getEstado());
            listaTramites.add(tramite);
        }
        return listaTramites;
    }

    @Override
    public List<TramiteReporteDTO> listaReporteTramites(List<PlacaDTO> placas, List<LicenciaDTO> licencias) {
        List<TramiteReporteDTO> listaTramites = new ArrayList<>();
        for (LicenciaDTO licencia : licencias) {
            TramiteReporteDTO tramite = new TramiteReporteDTO();
            String estado = licencia.getEstadoActual() == LicenciaDTO.estadoDTO.EXPIRADA ? "Expirada" : "No expirada";
            tramite.setTramite("Licencia");
            tramite.setCosto(licencia.getCosto());
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            String fechaExp = formatoFecha.format(licencia.getFechaExpedicion().getTime());
            String fechaRec = licencia.getFechaVencimiento() != null ? formatoFecha.format(licencia.getFechaVencimiento().getTime()) : "Vigente";
            tramite.setFecha_Exp(fechaExp);
            tramite.setFecha_Recepcion(fechaRec);
            tramite.setEstado(estado);
            listaTramites.add(tramite);
        }

        for (PlacaDTO placa : placas) {
            TramiteReporteDTO tramite = new TramiteReporteDTO();
            tramite.setTramite("Placa");
            tramite.setCosto(placa.getCosto());
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            String fechaExp = formatoFecha.format(placa.getFechaExpedicion().getTime());
            String fechaRec = placa.getFechaRecepcion() != null ? formatoFecha.format(placa.getFechaRecepcion().getTime()) : "Vigente";
            tramite.setFecha_Exp(fechaExp);
            tramite.setFecha_Recepcion(fechaRec);
            tramite.setEstado(placa.getEstado());
            listaTramites.add(tramite);
        }

        return listaTramites;
    }

}
