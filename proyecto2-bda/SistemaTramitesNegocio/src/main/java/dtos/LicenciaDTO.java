/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import bda.itson.entidadesJPA.Persona;
import java.util.Calendar;

/**
 *
 * @author fabri Clase que representa una licencia de conducir en formato DTO
 * (Data Transfer Object). Contiene información sobre la licencia, como la
 * persona a la que pertenece, la fecha de expedición, la fecha de vencimiento,
 * el costo y el estado actual.
 */
public class LicenciaDTO {

    private Long idLicencia;
    private PersonaDTO persona;
    private Calendar fechaExpedicion;
    private Calendar fechaVencimiento;
    private double costo;
    private int vigencia;

    /**
     * Enumeración que representa el estado actual de la licencia. Puede ser
     * EXPIRADA o NOEXPIRADA.
     */
    public enum estadoDTO {
        EXPIRADA,
        NOEXPIRADA
    }
    estadoDTO estadoActual;

    /**
     * Constructor por defecto de LicenciaDTO. Crea un objeto LicenciaDTO sin
     * inicializar sus atributos.
     */
    public LicenciaDTO() {
    }
/**
     * Constructor de LicenciaDTO que inicializa todos los atributos.
     *
     * @param idLicencia Identificador único de la licencia.
     * @param persona    Persona a la que pertenece la licencia.
     * @param fechaExpedicion   Fecha de expedición de la licencia.
     * @param fechaVencimiento  Fecha de vencimiento de la licencia.
     * @param costo Costo de la licencia.
     * @param estadoActual  Estado actual de la licencia.
     */
    public LicenciaDTO(Long idLicencia, PersonaDTO persona, Calendar fechaExpedicion, Calendar fechaVencimiento, double costo, estadoDTO estadoActual) {
        this.idLicencia = idLicencia;
        this.persona = persona;
        this.fechaExpedicion = fechaExpedicion;
        this.fechaVencimiento = fechaVencimiento;
        this.costo = costo;
        this.estadoActual = estadoActual;
    }
/**
     * Obtiene el identificador único de la licencia.
     *
     * @return El identificador único de la licencia.
     */
    public Long getIdLicencia() {
        return idLicencia;
    }

    /**
     * Establece el identificador único de la licencia.
     *
     * @param idLicencia El identificador único de la licencia a establecer.
     */
    public void setIdLicencia(Long idLicencia) {
        this.idLicencia = idLicencia;
    }

    /**
     * Obtiene la persona a la que pertenece la licencia.
     *
     * @return La persona a la que pertenece la licencia.
     */
    public PersonaDTO getPersona() {
        return persona;
    }

    /**
     * Establece la persona a la que pertenece la licencia.
     *
     * @param persona La persona a la que pertenece la licencia a establecer.
     */
    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

    /**
     * Obtiene la fecha de expedición de la licencia.
     *
     * @return La fecha de expedición de la licencia.
     */
    public Calendar getFechaExpedicion() {
        return fechaExpedicion;
    }

    /**
     * Establece la fecha de expedición de la licencia.
     *
     * @param fechaExpedicion La fecha de expedición de la licencia a establecer.
     */
    public void setFechaExpedicion(Calendar fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    /**
     * Obtiene la fecha de vencimiento de la licencia.
     *
     * @return La fecha de vencimiento de la licencia.
     */
    public Calendar getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * Establece la fecha de vencimiento de la licencia.
     *
     * @param fechaVencimiento La fecha de vencimiento de la licencia a establecer.
     */
    public void setFechaVencimiento(Calendar fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * Obtiene el costo de la licencia.
     *
     * @return El costo de la licencia.
     */
    public double getCosto() {
        return costo;
    }

    /**
     * Establece el costo de la licencia.
     *
     * @param costo El costo de la licencia a establecer.
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }

    /**
     * Obtiene la vigencia de la licencia en años.
     *
     * @return La vigencia de la licencia en años.
     */
    public int getVigencia() {
        return vigencia;
    }

    /**
     * Establece la vigencia de la licencia en años.
     *
     * @param vigencia La vigencia de la licencia en años a establecer.
     */
    public void setVigencia(int vigencia) {
        this.vigencia = vigencia;
    }

    /**
     * Obtiene el estado actual de la licencia.
     *
     * @return El estado actual de la licencia.
     */
    public estadoDTO getEstadoActual() {
        return estadoActual;
    }

    /**
     * Establece el estado actual de la licencia.
     *
     * @param estadoActual El estado actual de la licencia a establecer.
     */
    public void setEstadoActual(estadoDTO estadoActual) {
        this.estadoActual = estadoActual;
    }
    
    @Override
    public String toString() {
        return "LicenciaDTO{" + "idLicencia=" + idLicencia + ", persona=" + persona + ", fechaExpedicion=" + fechaExpedicion + ", fechaVencimiento=" + fechaVencimiento + ", costo=" + costo + ", estadoActual=" + estadoActual + '}';
    }

}
