/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bda.itson.entidadesJPA;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;

/**
 *
 * @author ID145
 */
@Entity
@Table(name="persona")
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="RFC", length=13)
    private Long id;
    
    @Temporal(TemporalType.DATE)
    private Calendar fechaNacimiento;
    
    private boolean esDiscapacitado;
    private String telefono;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private List<Licencia> licencias;

    @OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL)
    private List<Vehiculo> vehiculos;


    /**
     * Constructor que recibe todo, excepto el id
     * @param fechaNacimiento
     * @param esDiscapacitado
     * @param telefono
     * @param nombres
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param licencias
     * @param vehiculos
     */
    public Persona(Calendar fechaNacimiento, boolean esDiscapacitado, String telefono, String nombres, String apellidoPaterno, String apellidoMaterno, List<Licencia> licencias, List<Vehiculo> vehiculos) {
        this.fechaNacimiento = fechaNacimiento;
        this.esDiscapacitado = esDiscapacitado;
        this.telefono = telefono;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.licencias = licencias;
        this.vehiculos = vehiculos;
    }

    /**
     * Constructor que recibe todo, excepto ID y lista de licencias
     * @param fechaNacimiento
     * @param esDiscapacitado
     * @param telefono
     * @param nombres
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param vehiculos
     */
    public Persona(Calendar fechaNacimiento, boolean esDiscapacitado, String telefono, String nombres, String apellidoPaterno, String apellidoMaterno, List<Vehiculo> vehiculos) {
        this.fechaNacimiento = fechaNacimiento;
        this.esDiscapacitado = esDiscapacitado;
        this.telefono = telefono;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.vehiculos = vehiculos;
    }

    

    /**
     * Constructor que recibe todo.
     * @param id
     * @param fechaNacimiento
     * @param esDiscapacitado
     * @param telefono
     * @param nombres
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param licencias
     * @param vehiculos
     */
    public Persona(Long id, Calendar fechaNacimiento, boolean esDiscapacitado, String telefono, String nombres, String apellidoPaterno, String apellidoMaterno, List<Licencia> licencias, List<Vehiculo> vehiculos) {
        this.id = id;
        this.fechaNacimiento = fechaNacimiento;
        this.esDiscapacitado = esDiscapacitado;
        this.telefono = telefono;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.licencias = licencias;
        this.vehiculos = vehiculos;
    }

    /**
     * Constructor vacío
     */
    public Persona() {
    }
    /**
     * Método que regresa el id de la persona
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Método que establece el id de la persona
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método que regresa la fecha de nacimiento
     * @return fechaNacimiento
     */
    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Método que establece la fecha de nacimiento
     * @param fechaNacimiento
     */
    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Método que regresa si es discapacitado
     * @return esDiscapacitado
     */
    public boolean isEsDiscapacitado() {
        return esDiscapacitado;
    }

    /**
     * Método que establece si es discapacitado
     * @param esDiscapacitado
     */
    public void setEsDiscapacitado(boolean esDiscapacitado) {
        this.esDiscapacitado = esDiscapacitado;
    }

    /**
     * Método que regresa el teléfono
     * @return telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Método que establece el teléfono
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Método que regresa los nombres
     * @return nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Método que establece los nombres
     * @param nombres
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Método que regresa el apellido paterno
     * @return apellidoPaterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Método que establece el apellido paterno
     * @param apellidoPaterno
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Método que regresa el apellido materno
     * @return apellidoMaterno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Método que establece el apellido materno
     * @param apellidoMaterno
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Método que regresa las licencias
     * @return licencias
     */
    public List<Licencia> getLicencias() {
        return licencias;
    }

    /**
     * Método que establece las licencias
     * @param licencias
     */
    public void setLicencias(List<Licencia> licencias) {
        this.licencias = licencias;
    }

    /**
     * Método que regresa los vehículos
     * @return vehiculos
     */
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Método que establece los vehículos
     * @param vehiculos
     */
    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     * Método que regresa el hash
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Método que compara objetos
     * @param object
     * @return true si son iguales, false si no
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Método que regresa el objeto en forma de cadena
     * @return cadena
     */
    @Override
    public String toString() {
        return "Persona [id=" + id + ", apellidoMaterno=" + apellidoMaterno + ", apellidoPaterno=" + apellidoPaterno
                + ", esDiscapacitado=" + esDiscapacitado + ", fechaNacimiento=" + fechaNacimiento + ", licencias="
                + licencias + ", nombres=" + nombres + ", telefono=" + telefono + ", vehiculos=" + vehiculos + "]";
    }
}