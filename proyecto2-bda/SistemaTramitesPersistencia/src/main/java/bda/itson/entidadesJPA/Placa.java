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
@Table(name = "placa")
public class Placa implements Serializable {

    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numeroSerie")
    private Long id;
    
    private double costo;
    
    @Temporal(TemporalType.DATE)
    private Calendar fechaRecepcion;
    
    private String estado;
    
    @Temporal(TemporalType.DATE)
    private Calendar fechaExpedicion;
    
    @ManyToOne
    @JoinColumn(name = "numeroSerieVehiculo")
    private Vehiculo vehiculo;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Placa() {
    }

    /**
     * Constructor que recibe todo, excepto el id
     * @param costo
     * @param fechaRecepcion
     * @param estado
     * @param fechaExpedicion
     * @param vehiculo
     */
    public Placa(double costo, Calendar fechaRecepcion, String estado, Calendar fechaExpedicion, Vehiculo vehiculo) {
        this.costo = costo;
        this.fechaRecepcion = fechaRecepcion;
        this.estado = estado;
        this.fechaExpedicion = fechaExpedicion;
        this.vehiculo = vehiculo;
    }

    /**
     * Constructor que recibe todo.
     * @param id
     * @param costo
     * @param fechaRecepcion
     * @param estado
     * @param fechaExpedicion
     * @param vehiculo
     */
    public Placa(Long id, double costo, Calendar fechaRecepcion, String estado, Calendar fechaExpedicion, Vehiculo vehiculo) {
        this.id = id;
        this.costo = costo;
        this.fechaRecepcion = fechaRecepcion;
        this.estado = estado;
        this.fechaExpedicion = fechaExpedicion;
        this.vehiculo = vehiculo;
    }

    /**
     * Constructor que recibe todo excepto el id y el vehículo.
     * @param costo
     * @param fechaRecepcion
     * @param estado
     * @param fechaExpedicion
     */
    public Placa( double costo, Calendar fechaRecepcion, String estado, Calendar fechaExpedicion ) {
        this.costo = costo;
        this.fechaRecepcion = fechaRecepcion;
        this.estado = estado;
        this.fechaExpedicion = fechaExpedicion;
    }

    /**
     * Método que regresa el id de la placa
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * Método que establece el id de la placa
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    
    /**
     * Método que regresa el costo de la placa
     * @return
     */
    public double getCosto() {
        return costo;
    }

    /**
     * Método que recibe el costo de la placa
     * @param costo
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }

    /**
     * Método que regresa la fecha de recepción
     * @return
     */
    public Calendar getFechaRecepcion() {
        return fechaRecepcion;
    }

    /**
     * Método que recibe la fecha de recepción
     * @param fechaRecepcion
     */
    public void setFechaRecepcion(Calendar fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    /**
     * Método que regresa el estado de la placa
     * @return
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Método que recibe el estado de la placa
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método que regresa la fecha de expedición
     * @return
     */
    public Calendar getFechaExpedicion() {
        return fechaExpedicion;
    }

    /**
     * Método que recibe la fecha de expedición
     * @param fechaExpedicion
     */
    public void setFechaExpedicion(Calendar fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    /**
     * Método que regresa el vehículo
     * @return
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Método que recibe el vehículo
     * @param vehiculo
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /*
     * Método para generar el hashcode
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /*
     * Método para comparar objetos
     * @param object
     * @return true si son iguales, false si no
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Placa)) {
            return false;
        }
        Placa other = (Placa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Placa [id=" + id + ", costo=" + costo + ", fechaRecepcion=" + fechaRecepcion + ", estado=" + estado
                + ", fechaExpedicion=" + fechaExpedicion + ", vehiculo=" + vehiculo + "]";
    }

    /**
     * Método que regresa la representación en cadena de la placa
     * @return cadena
     */
    
    
}
