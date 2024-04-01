/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.Calendar;

/**
 *
 * @author abelc
 */
public class PlacaDTO {
    private Long id;
    private String codigo;
    private double costo;
    private Calendar fechaRecepcion;
    private String estado;
    private Calendar fechaExpedicion;
    private VehiculoDTO Vehiculo; 
    
    // Constructor
    public PlacaDTO() {
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Calendar getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Calendar fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Calendar getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Calendar fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public VehiculoDTO getVehiculo() {
        return Vehiculo;
    }

    public void setVehiculo(VehiculoDTO Vehiculo) {
        this.Vehiculo = Vehiculo;
    }

    @Override
    public String toString() {
        return "PlacaDTO{" + "id=" + id + ", codigo=" + codigo + ", costo=" + costo + ", fechaRecepcion=" + fechaRecepcion + ", estado=" + estado + ", fechaExpedicion=" + fechaExpedicion + ", Vehiculo=" + Vehiculo + '}';
    }
    
}