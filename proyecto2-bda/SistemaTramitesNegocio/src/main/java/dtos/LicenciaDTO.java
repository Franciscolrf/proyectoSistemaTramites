/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import bda.itson.entidadesJPA.Persona;
import java.util.Calendar;

/**
 *
 * @author fabri
 */
public class LicenciaDTO {

    private Long idLicencia;
    private PersonaDTO persona;
    private Calendar fechaExpedicion;
    private Calendar fechaVencimiento;
    private double costo;
    private int vigencia;

    public enum estadoDTO {
        EXPIRADA,
        NOEXPIRADA
    }
    estadoDTO estadoActual;

    public LicenciaDTO() {
    }

    public LicenciaDTO(Long idLicencia, PersonaDTO persona, Calendar fechaExpedicion, Calendar fechaVencimiento, double costo, estadoDTO estadoActual) {
        this.idLicencia = idLicencia;
        this.persona = persona;
        this.fechaExpedicion = fechaExpedicion;
        this.fechaVencimiento = fechaVencimiento;
        this.costo = costo;
        this.estadoActual = estadoActual;
    }

    public Long getIdLicencia() {
        return idLicencia;
    }

    public void setIdLicencia(Long idLicencia) {
        this.idLicencia = idLicencia;
    }

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

    public Calendar getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Calendar fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public Calendar getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Calendar fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public estadoDTO getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(estadoDTO estadoActual) {
        this.estadoActual = estadoActual;
    }

    public int getVigencia() {
        return vigencia;
    }

    public void setVigencia(int vigencia) {
        this.vigencia = vigencia;
    }

    @Override
    public String toString() {
        return "LicenciaDTO{" + "idLicencia=" + idLicencia + ", persona=" + persona + ", fechaExpedicion=" + fechaExpedicion + ", fechaVencimiento=" + fechaVencimiento + ", costo=" + costo + ", estadoActual=" + estadoActual + '}';
    }

}
