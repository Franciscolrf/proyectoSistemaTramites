/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bda.itson.entidadesJPA;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 *
 * @author ID145
 */
@Entity
@Table(name = "vehiculo")
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVehiculo")
    private Long id;
    private String numeroSerie;
    private String estado;
    private String color;
    private String modelo;
    private String marca;
    private String linea;

    @ManyToOne
    @JoinColumn(name = "idPersona")
    private Persona propietario;

    @OneToMany(mappedBy = "vehiculo")
    private List<Placa> placas;

    /**
     * Constructor vacío
     */
    public Vehiculo() {
    }

    public Vehiculo(String numeroSerie, String estado, String color, String modelo, String marca, String linea, Persona propietario, List<Placa> placas) {
        this.numeroSerie = numeroSerie;
        this.estado = estado;
        this.color = color;
        this.modelo = modelo;
        this.marca = marca;
        this.linea = linea;
        this.propietario = propietario;
        this.placas = placas;
    }

    public Vehiculo(Long id, String numeroSerie, String estado, String color, String modelo, String marca, String linea, Persona propietario, List<Placa> placas) {
        this.id = id;
        this.numeroSerie = numeroSerie;
        this.estado = estado;
        this.color = color;
        this.modelo = modelo;
        this.marca = marca;
        this.linea = linea;
        this.propietario = propietario;
        this.placas = placas;
    }

    /**
     * Método que regresa el id del vehículo
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * Método que recibe el id del vehículo
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método que regresa el estado del vehículo
     *
     * @return
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Método que establece el estado del vehículo
     *
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método que regresa el color del vehículo
     *
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     * Método que establece el color del vehículo
     *
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Método que regresa el modelo del vehículo
     *
     * @return
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Método que establece el modelo del vehículo
     *
     * @param modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Método que regresa la marca del vehículo
     *
     * @return
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Método que establece la marca del vehículo
     *
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Método que regresa la línea del vehículo
     *
     * @return
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Método que establece la línea del vehículo
     *
     * @param linea
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * Método que regresa el propietario
     *
     * @return
     */
    public Persona getPropietario() {
        return propietario;
    }

    /**
     * Método que establece el propietario
     *
     * @param propietario
     */
    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }

    /**
     * Método que regresa las placas
     *
     * @return
     */
    public List<Placa> getPlacas() {
        return placas;
    }

    /**
     * Método que establece las placas
     *
     * @param placas
     */
    public void setPlacas(List<Placa> placas) {
        this.placas = placas;
    }

    /*
     * Método que regresa el hash
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /*
     * Método que regresa si dos objetos son iguales
     * @param object
     * @return true si son iguales, false si no
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /*
     * Método que regresa el objeto en forma de string
     * @return cadena
     */
    @Override
    public String toString() {
        return "Vehiculo [id=" + id + ", estado=" + estado + ", color=" + color + ", modelo=" + modelo + ", marca="
                + marca + ", linea=" + linea + ", propietario=" + propietario + ", placas=" + placas + "]";
    }

}
