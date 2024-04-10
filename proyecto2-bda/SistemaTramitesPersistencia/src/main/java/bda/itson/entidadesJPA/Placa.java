/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bda.itson.entidadesJPA;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.*;

/**
 * Clase que representa una entidad placa
 *
 * @author ID145
 */
@Entity
@Table(name = "placa")
public class Placa implements Serializable {

    // Atributos de la clase
    /**
     * Identificador único de la placa.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Identificador de la placa.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPlaca")
    private Long id;

    /**
     * Código de la placa.
     */
    private String codigo;

    /**
     * Costo de la placa.
     */
    private double costo;

    /**
     * Fecha de recepción de la placa.
     */
    @Temporal(TemporalType.DATE)
    private Calendar fechaRecepcion;

    /**
     * Estado de la placa.
     */
    private String estado;

    /**
     * Fecha de expedición de la placa.
     */
    @Temporal(TemporalType.DATE)
    private Calendar fechaExpedicion;

    /**
     * Vehículo al que pertenece la placa.
     */
    @ManyToOne
    @JoinColumn(name = "idVehiculo")
    private Vehiculo vehiculo;

    // Constructores
    /**
     * Constructor vacío requerido por JPA.
     */
    public Placa() {
    }

    /**
     * Constructor con parámetros para inicializar todos los atributos de la
     * placa.
     *
     * @param id Identificador de la placa.
     * @param codigo Código de la placa.
     * @param costo Costo de la placa.
     * @param fechaRecepcion Fecha de recepción de la placa.
     * @param estado Estado de la placa.
     * @param fechaExpedicion Fecha de expedición de la placa.
     * @param vehiculo Vehículo al que pertenece la placa.
     */
    public Placa(Long id, String codigo, double costo, Calendar fechaRecepcion, String estado, Calendar fechaExpedicion, Vehiculo vehiculo) {
        this.id = id;
        this.codigo = codigo;
        this.costo = costo;
        this.fechaRecepcion = fechaRecepcion;
        this.estado = estado;
        this.fechaExpedicion = fechaExpedicion;
        this.vehiculo = vehiculo;
    }

    /**
     * Método que obtiene el código de la placa.
     *
     * @return El código de la placa.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Método que establece el código de la placa.
     *
     * @param codigo El código de la placa a establecer.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Método que obtiene el identificador de la placa.
     *
     * @return El identificador de la placa.
     */
    public Long getId() {
        return id;
    }

    /**
     * Método que establece el identificador de la placa.
     *
     * @param id El identificador de la placa a establecer.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método que obtiene el costo de la placa.
     *
     * @return El costo de la placa.
     */
    public double getCosto() {
        return costo;
    }

    /**
     * Método que establece el costo de la placa.
     *
     * @param costo El costo de la placa a establecer.
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }

    /**
     * Método que obtiene la fecha de recepción de la placa.
     *
     * @return La fecha de recepción de la placa.
     */
    public Calendar getFechaRecepcion() {
        return fechaRecepcion;
    }

    /**
     * Método que establece la fecha de recepción de la placa.
     *
     * @param fechaRecepcion La fecha de recepción de la placa a establecer.
     */
    public void setFechaRecepcion(Calendar fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    /**
     * Método que obtiene el estado de la placa.
     *
     * @return El estado de la placa.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Método que establece el estado de la placa.
     *
     * @param estado El estado de la placa a establecer.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método que obtiene la fecha de expedición de la placa.
     *
     * @return La fecha de expedición de la placa.
     */
    public Calendar getFechaExpedicion() {
        return fechaExpedicion;
    }

    /**
     * Método que establece la fecha de expedición de la placa.
     *
     * @param fechaExpedicion La fecha de expedición de la placa a establecer.
     */
    public void setFechaExpedicion(Calendar fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    /**
     * Método que obtiene el vehículo asociado a la placa.
     *
     * @return El vehículo asociado a la placa.
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Método que establece el vehículo asociado a la placa.
     *
     * @param vehiculo El vehículo asociado a la placa a establecer.
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Método que genera el hashcode para la placa.
     *
     * @return El valor hash generado.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Método que compara dos objetos Placa para verificar si son iguales.
     *
     * @param object El objeto a comparar.
     * @return true si los objetos son iguales, false si no lo son.
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Placa)) {
            return false;
        }
        Placa other = (Placa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Método que devuelve una representación en cadena de la placa.
     *
     * @return La representación en cadena de la placa.
     */
    @Override
    public String toString() {
        return "Placa [id=" + id + ", costo=" + costo + ", fechaRecepcion=" + fechaRecepcion + ", estado=" + estado
                + ", fechaExpedicion=" + fechaExpedicion + ", vehiculo=" + vehiculo + "]";
    }

}
