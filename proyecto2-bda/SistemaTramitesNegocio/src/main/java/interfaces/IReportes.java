/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dtos.LicenciaDTO;
import dtos.PlacaDTO;
import dtos.TramiteReporteDTO;
import java.util.List;

/**
 * interace encargada de transferir los datos que se soliciten desde
 * presentacion a negocio, esta interface se dedica a los reportes
 *
 * @author abelc
 */
public interface IReportes {

    /**
     * Regresa una lista de tramites con el formato del reporte a partir de una
     * lista de licencias
     *
     * @param licencias licencias a consultar al reporte
     * @return una lista de tipo TramiteReporteDTO
     */
    public List<TramiteReporteDTO> listaReporteLicencias(List<LicenciaDTO> licencias);

    /**
     * Regrese de tramites con el formato del reporte a partir de una lista de
     * placas
     *
     * @param placas lista de placas a consultar en el reporte
     * @return una lista de tipo TramiteReporteDTO
     */
    public List<TramiteReporteDTO> listaReportePlacas(List<PlacaDTO> placas);

    /**
     * Regresa una lista con el formato para el reporte a partir de la listas de
     * tramites que le pases
     *
     * @param placas lista de placas
     * @param licencias lista de licencias
     * @return una lista de tipo TramiteReporteDTO
     */
    public List<TramiteReporteDTO> listaReporteTramites(List<PlacaDTO> placas, List<LicenciaDTO> licencias);
}
