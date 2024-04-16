/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para un
 * trámite. Contiene información sobre el nombre, tipo, fecha y costo del
 * trámite. Se usa para darle formato al reporte
 *
 * @author abelc
 */
public class TramiteReporteDTO {

    private String tramite;
    private String fecha_Recepcion;
    private String fecha_Exp;
    private double costo;
    private String estado;

    public TramiteReporteDTO() {
    }

    public TramiteReporteDTO(String tramite, String fecha_Recepcion, String fecha_Exp, double costo, String estado) {
        this.tramite = tramite;
        this.fecha_Recepcion = fecha_Recepcion;
        this.fecha_Exp = fecha_Exp;
        this.costo = costo;
        this.estado = estado;
    }

    public String getTramite() {
        return tramite;
    }

    public void setTramite(String tramite) {
        this.tramite = tramite;
    }

    public String getFecha_Recepcion() {
        return fecha_Recepcion;
    }

    public void setFecha_Recepcion(String fecha_Recepcion) {
        this.fecha_Recepcion = fecha_Recepcion;
    }

    public String getFecha_Exp() {
        return fecha_Exp;
    }

    public void setFecha_Exp(String fecha_Exp) {
        this.fecha_Exp = fecha_Exp;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
