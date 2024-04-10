/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bda.itson.entidadesJPA;

import java.io.Serializable;
import javax.persistence.*;
import java.util.*;
import java.util.logging.Logger;

/**
 * Clase que represnta el mape de la entidad persona
 *
 * @author ID145
 */
@Entity
@Table(name = "persona")
public class Persona implements Serializable {
    // Atributos de la clase

    /**
     * Identificador único de la persona.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Identificador de la persona.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersona")
    private Long id;

    /**
     * RFC (Registro Federal de Contribuyentes) de la persona.
     */
    private String RFC;

    /**
     * Fecha de nacimiento de la persona.
     */
    @Temporal(TemporalType.DATE)
    private Calendar fechaNacimiento;

    /**
     * Indicador de si la persona es discapacitada o no.
     */
    private boolean esDiscapacitado;

    /**
     * Número de teléfono de la persona.
     */
    private String telefono;

    /**
     * Nombres de la persona.
     */
    private String nombres;

    /**
     * Apellido paterno de la persona.
     */
    private String apellidoPaterno;

    /**
     * Apellido materno de la persona.
     */
    private String apellidoMaterno;

    /**
     * Lista de licencias asociadas a la persona.
     */
    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private List<Licencia> licencias;

    /**
     * Lista de vehículos asociados a la persona como propietario.
     */
    @OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL)
    private List<Vehiculo> vehiculos;

    /**
     * Logger para la clase Persona.
     */
    private static final Logger LOG = Logger.getLogger(Persona.class.getName());

    /**
     * Constructor que recibe todos los atributos de una persona, excepto el ID.
     *
     * @param RFC El Registro Federal de Contribuyentes (RFC) de la persona.
     * @param fechaNacimiento La fecha de nacimiento de la persona.
     * @param esDiscapacitado Indica si la persona tiene alguna discapacidad.
     * @param telefono El número de teléfono de la persona.
     * @param nombres Los nombres de la persona.
     * @param apellidoPaterno El apellido paterno de la persona.
     * @param apellidoMaterno El apellido materno de la persona.
     * @param licencias Las licencias asociadas a la persona.
     * @param vehiculos Los vehículos asociados a la persona.
     */
    public Persona(String RFC, Calendar fechaNacimiento, boolean esDiscapacitado, String telefono, String nombres, String apellidoPaterno, String apellidoMaterno, List<Licencia> licencias, List<Vehiculo> vehiculos) {
        this.RFC = RFC;
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
     * Constructor que recibe todos los atributos de una persona.
     *
     * @param id El identificador único de la persona.
     * @param RFC El Registro Federal de Contribuyentes (RFC) de la persona.
     * @param fechaNacimiento La fecha de nacimiento de la persona.
     * @param esDiscapacitado Indica si la persona tiene alguna discapacidad.
     * @param telefono El número de teléfono de la persona.
     * @param nombres Los nombres de la persona.
     * @param apellidoPaterno El apellido paterno de la persona.
     * @param apellidoMaterno El apellido materno de la persona.
     * @param licencias Las licencias asociadas a la persona.
     * @param vehiculos Los vehículos asociados a la persona.
     */
    public Persona(Long id, String RFC, Calendar fechaNacimiento, boolean esDiscapacitado, String telefono, String nombres, String apellidoPaterno, String apellidoMaterno, List<Licencia> licencias, List<Vehiculo> vehiculos) {
        this.id = id;
        this.RFC = RFC;
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
     * Constructor que recibe los atributos básicos de una persona, sin
     * licencias ni vehículos asociados.
     *
     * @param RFC El Registro Federal de Contribuyentes (RFC) de la persona.
     * @param fechaNacimiento La fecha de nacimiento de la persona.
     * @param esDiscapacitado Indica si la persona tiene alguna discapacidad.
     * @param telefono El número de teléfono de la persona.
     * @param nombres Los nombres de la persona.
     * @param apellidoPaterno El apellido paterno de la persona.
     * @param apellidoMaterno El apellido materno de la persona.
     */
    public Persona(String RFC, Calendar fechaNacimiento, boolean esDiscapacitado, String telefono, String nombres, String apellidoPaterno, String apellidoMaterno) {
        this.RFC = RFC;
        this.fechaNacimiento = fechaNacimiento;
        this.esDiscapacitado = esDiscapacitado;
        this.telefono = telefono;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Constructor vacío para la clase Persona.
     */
    public Persona() {
    }

    /**
     * Método que obtiene el ID de la persona.
     *
     * @return El ID de la persona.
     */
    public Long getId() {
        return id;
    }

    /**
     * Método que establece el ID de la persona.
     *
     * @param id El ID de la persona.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método que obtiene el RFC (Registro Federal de Contribuyentes) de la
     * persona.
     *
     * @return El RFC de la persona.
     */
    public String getRFC() {
        return RFC;
    }

    /**
     * Método que establece el RFC (Registro Federal de Contribuyentes) de la
     * persona.
     *
     * @param RFC El RFC de la persona.
     */
    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    /**
     * Método que obtiene la fecha de nacimiento de la persona.
     *
     * @return La fecha de nacimiento de la persona.
     */
    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Método que establece la fecha de nacimiento de la persona.
     *
     * @param fechaNacimiento La fecha de nacimiento de la persona.
     */
    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Método que indica si la persona tiene alguna discapacidad.
     *
     * @return Verdadero si la persona tiene alguna discapacidad, falso si no.
     */
    public boolean isEsDiscapacitado() {
        return esDiscapacitado;
    }

    /**
     * Método que establece si la persona tiene alguna discapacidad.
     *
     * @param esDiscapacitado Verdadero si la persona tiene alguna discapacidad,
     * falso si no.
     */
    public void setEsDiscapacitado(boolean esDiscapacitado) {
        this.esDiscapacitado = esDiscapacitado;
    }

    /**
     * Método que obtiene el número de teléfono de la persona.
     *
     * @return El número de teléfono de la persona.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Método que establece el número de teléfono de la persona.
     *
     * @param telefono El número de teléfono de la persona.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Método que obtiene los nombres de la persona.
     *
     * @return Los nombres de la persona.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Método que establece los nombres de la persona.
     *
     * @param nombres Los nombres de la persona.
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Método que obtiene el apellido paterno de la persona.
     *
     * @return El apellido paterno de la persona.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Método que establece el apellido paterno de la persona.
     *
     * @param apellidoPaterno El apellido paterno de la persona.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Método que obtiene el apellido materno de la persona.
     *
     * @return El apellido materno de la persona.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Método que establece el apellido materno de la persona.
     *
     * @param apellidoMaterno El apellido materno de la persona.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Método que obtiene la lista de licencias asociadas a la persona.
     *
     * @return La lista de licencias asociadas a la persona.
     */
    public List<Licencia> getLicencias() {
        return licencias;
    }

    /**
     * Método que establece la lista de licencias asociadas a la persona.
     *
     * @param licencias La lista de licencias asociadas a la persona.
     */
    public void setLicencias(List<Licencia> licencias) {
        this.licencias = licencias;
    }

    /**
     * Método que obtiene la lista de vehículos asociados a la persona.
     *
     * @return La lista de vehículos asociados a la persona.
     */
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Método que establece la lista de vehículos asociados a la persona.
     *
     * @param vehiculos La lista de vehículos asociados a la persona.
     */
    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     * Método que genera el hash de la instancia de Persona.
     *
     * @return El hash de la instancia de Persona.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Método que compara dos instancias de Persona para determinar si son
     * iguales.
     *
     * @param object El objeto con el que se comparará la instancia de Persona.
     * @return Verdadero si las instancias son iguales, falso en caso contrario.
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
     * Método que retorna una representación en forma de cadena de la instancia
     * de Persona.
     *
     * @return La representación en forma de cadena de la instancia de Persona.
     */
    @Override
    public String toString() {
        return "Persona [id=" + id + ", apellidoMaterno=" + apellidoMaterno + ", apellidoPaterno=" + apellidoPaterno
                + ", esDiscapacitado=" + esDiscapacitado + ", fechaNacimiento=" + fechaNacimiento + ", licencias="
                + licencias + ", nombres=" + nombres + ", telefono=" + telefono + "]";
    }
}
