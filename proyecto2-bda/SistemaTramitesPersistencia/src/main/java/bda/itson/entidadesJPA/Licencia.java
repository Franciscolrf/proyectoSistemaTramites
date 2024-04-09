/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bda.itson.entidadesJPA;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.*;

/**
 *Clase que represnta una entidad licencia con su mapeo
 * @author ID145
 */
@Entity
@Table(name = "licencia")
public class Licencia implements Serializable {
   // Atributos de la clase

    /** Identificador único de la licencia. */
    private static final long serialVersionUID = 1L;

    /** Identificador de la licencia. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLicencia;

    /** Fecha en que se expedición la licencia. */
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaExpedicion", nullable = false)
    private Calendar fechaExpedicion;

    /** Fecha en que la licencia vence. */
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaVencimiento", nullable = false)
    private Calendar fechaVencimiento;

    /** Costo asociado con la licencia. */
    private double costo;

    /** Periodo de vigencia de la licencia. */
    private int vigencia;

    /** Estado actual de la licencia. */
    private String estado;

    /** Persona a la que se le otorga la licencia. */
    @ManyToOne
    @JoinColumn(name = "idPersona")
    private Persona persona;

    // Constructores

    /**
     * Constructor con parámetros para inicializar todos los atributos de la licencia.
     *
     * @param fechaExpedicion Fecha de expedición de la licencia.
     * @param fechaVencimiento Fecha de vencimiento de la licencia.
     * @param costo Costo de la licencia.
     * @param vigencia Periodo de vigencia de la licencia.
     * @param estado Estado actual de la licencia.
     * @param persona Persona a la que se le otorga la licencia.
     */
    public Licencia(Calendar fechaExpedicion, Calendar fechaVencimiento, double costo, int vigencia, String estado, Persona persona) {
        this.fechaExpedicion = fechaExpedicion;
        this.fechaVencimiento = fechaVencimiento;
        this.costo = costo;
        this.vigencia = vigencia;
        this.estado = estado;
        this.persona = persona;
    }

    /**
     * Constructor con parámetros para inicializar todos los atributos excepto el id de la licencia.
     *
     * @param idLicencia Identificador de la licencia.
     * @param fechaExpedicion Fecha de expedición de la licencia.
     * @param fechaVencimiento Fecha de vencimiento de la licencia.
     * @param costo Costo de la licencia.
     * @param vigencia Periodo de vigencia de la licencia.
     * @param estado Estado actual de la licencia.
     * @param persona Persona a la que se le otorga la licencia.
     */
    public Licencia(Integer idLicencia, Calendar fechaExpedicion, Calendar fechaVencimiento, double costo, int vigencia, String estado, Persona persona) {
        this.idLicencia = idLicencia;
        this.fechaExpedicion = fechaExpedicion;
        this.fechaVencimiento = fechaVencimiento;
        this.costo = costo;
        this.vigencia = vigencia;
        this.estado = estado;
        this.persona = persona;
    }

    /**
     * Constructor vacío.
     */
    public Licencia() {
    }

    // Métodos getters y setters

    /**
     * Método que regresa el id de la licencia.
     *
     * @return Id de la licencia.
     */
    public Integer getIdLicencia() {
        return idLicencia;
    }

    /**
     * Método que establece el id de la licencia.
     *
     * @param idLicencia Id de la licencia.
     */
    public void setIdLicencia(Integer idLicencia) {
        this.idLicencia = idLicencia;
    }

    /**
     * Método que regresa la fecha de expedición de la licencia.
     *
     * @return Fecha de expedición de la licencia.
     */
    public Calendar getFechaExpedicion() {
        return fechaExpedicion;
    }

    /**
     * Método que establece la fecha de expedición de la licencia.
     *
     * @param fechaExpedicion Fecha de expedición de la licencia.
     */
    public void setFechaExpedicion(Calendar fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    /**
     * Método que regresa la fecha de vencimiento de la licencia.
     *
     * @return Fecha de vencimiento de la licencia.
     */
    public Calendar getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * Método que establece la fecha de vencimiento de la licencia.
     *
     * @param fechaVencimiento Fecha de vencimiento de la licencia.
     */
    public void setFechaVencimiento(Calendar fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * Método que regresa el costo de la licencia.
     *
     * @return Costo de la licencia.
     */
    public double getCosto() {
        return costo;
    }

    /**
     * Método que establece el costo de la licencia.
     *
     * @param costo Costo de la licencia.
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }

    /**
     * Método que regresa el estado de la licencia.
     *
     * @return Estado de la licencia.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Método que establece el estado de la licencia.
     *
     * @param estado Estado de la licencia.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método que regresa la vigencia de la licencia.
     *
     * @return Vigencia de la licencia.
     */
    public int getVigencia() {
        return vigencia;
    }

    /**
     * Método que establece la vigencia de la licencia.
     *
     * @param vigencia Vigencia de la licencia.
     */
    public void setVigencia(int vigencia) {
        this.vigencia = vigencia;
    }

    /**
     * Método que regresa la persona a la que se le otorga la licencia.
     *
     * @return Persona a la que se le otorga la licencia.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Método que establece la persona a la que se le otorga la licencia.
     *
     * @param persona Persona a la que se le otorga la licencia.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    // Métodos sobrescritos

    /**
     * Método que genera un valor hash basado en el id de la licencia.
     *
     * @return Valor hash.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLicencia != null ? idLicencia.hashCode() : 0);
        return hash;
    }

    /**
     * Método que compara si dos objetos Licencia son iguales basándose en el id de la licencia.
     *
     * @param object Objeto a comparar.
     * @return true si son iguales, false si no.
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
     * Método que devuelve una representación en cadena de la licencia.
     *
     * @return Representación en cadena de la licencia.
     */
    @Override
    public String toString() {
        return "Licencia [idLicencia=" + idLicencia + ", fechaExpedicion=" + fechaExpedicion + ", fechaVencimiento="
                + fechaVencimiento + ", costo=" + costo + ", estado=" + estado + ", persona=" + persona + "]";
    }
}


