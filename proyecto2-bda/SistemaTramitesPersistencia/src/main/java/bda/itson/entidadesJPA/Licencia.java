/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bda.itson.entidadesJPA;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.*;

/**
 *
 * @author ID145
 */
@Entity
@Table(name = "licencia")
public class Licencia implements Serializable {

    // Atributos de la clase
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLicencia;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaExpedicion", nullable = false)
    private Calendar fechaExpedicion;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaVencimiento", nullable = false)
    private Calendar fechaVencimiento;

    private double costo;

    private String estado;

    @ManyToOne
    @JoinColumn(name = "RFC_persona")
    private Persona persona;

    /*
     * Constructor que recibe todo.
     * @param idLicencia
     * @param fechaExpedicion
     * @param fechaVencimiento
     * @param costo
     * @param estado
     * @param persona
     * @return Objeto de tipo Licencia
     */
    public Licencia(Integer idLicencia, Calendar fechaExpedicion, Calendar fechaVencimiento, double costo, String estado,
            Persona persona) {
        this.idLicencia = idLicencia;
        this.fechaExpedicion = fechaExpedicion;
        this.fechaVencimiento = fechaVencimiento;
        this.costo = costo;
        this.estado = estado;
        this.persona = persona;
    }

    /**
     * Constructor que recibe todo excepto el id
     * @param fechaExpedicion
     * @param fechaVencimiento
     * @param costo
     * @param estado
     * @param persona
     * @return Objeto de tipo Licencia
     */
    public Licencia(Calendar fechaExpedicion, Calendar fechaVencimiento, double costo, String estado, Persona persona) {
        this.fechaExpedicion = fechaExpedicion;
        this.fechaVencimiento = fechaVencimiento;
        this.costo = costo;
        this.estado = estado;
        this.persona = persona;
    }


    /**
     * Método que regresa el id de la licencia
     *
     * @return
     */
    public Integer getIdLicencia() {
        return idLicencia;
    }

    /**
     * Método que regresa la fecha de expedición
     *
     * @return
     */
    public void setIdLicencia(Integer idLicencia) {
        this.idLicencia = idLicencia;
    }

    /**
     * Método que regresa la fecha de expedición
     *
     * @return
     */
    public Calendar getFechaExpedicion() {
        return fechaExpedicion;
    }

    /**
     * Método que recibe la fecha de expedición
     *
     * @param fechaExpedicion
     */
    public void setFechaExpedicion(Calendar fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    /**
     * Método que regresa la fecha de vencimiento
     *
     * @return
     */
    public Calendar getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * Método que recibe la fecha de vencimiento
     *
     * @param fechaVencimiento
     */
    public void setFechaVencimiento(Calendar fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * Método que regresa el costo
     *
     * @return
     */
    public double getCosto() {
        return costo;
    }

    /**
     * Método que recibe el costo
     *
     * @param costo
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }

    /**
     * Método que regresa el estado
     *
     * @return
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Método que recibe el estado
     *
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método que regresa la persona
     *
     * @return
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Método que recibe la persona
     *
     * @param persona
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Método que regresa el hash
     * 
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLicencia != null ? idLicencia.hashCode() : 0);
        return hash;
    }

    /**
     * Método que compara objetos
     * 
     * @param object
     * @return true si son iguales, false si no
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Licencia)) {
            return false;
        }
        Licencia other = (Licencia) object;
        if ((this.idLicencia == null && other.idLicencia != null)
                || (this.idLicencia != null && !this.idLicencia.equals(other.idLicencia))) {
            return false;
        }
        return true;
    }

    /**
     * Método que regresa la representación en cadena del objeto
     * 
     * @return
     */
    @Override
    public String toString() {
        return "Licencia [idLicencia=" + idLicencia + ", fechaExpedicion=" + fechaExpedicion + ", fechaVencimiento="
                + fechaVencimiento + ", costo=" + costo + ", estado=" + estado + ", persona=" + persona + "]";
    }

}