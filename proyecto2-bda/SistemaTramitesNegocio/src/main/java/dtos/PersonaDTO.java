/**
 * PersonaDTO.java
 *
 * Clase creada en Abril de 2024
 */
package dtos;

import java.util.Calendar;

/**
 * Clase que representa los datos de una persona. Esta clase se utiliza para
 * transferir datos de personas entre las capas del sistema.
 *
 * @author abelc
 *
 */
public class PersonaDTO {

    /**
     * Identificador único de la persona.
     */
    private Long id;

    /**
     * RFC (Registro Federal de Contribuyentes) de la persona.
     */
    private String RFC;

    /**
     * Fecha de nacimiento de la persona.
     */
    private Calendar fechaNacimiento;

    /**
     * Indica si la persona tiene alguna discapacidad.
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
     * Constructor por defecto de la clase PersonaDTO. Inicializa todos los
     * atributos en sus valores por defecto.
     */
    public PersonaDTO() {
    }

    /**
     * Constructor de la clase PersonaDTO que recibe todos los atributos como
     * parámetros.
     *
     * @param RFC El RFC de la persona.
     * @param fechaNacimiento La fecha de nacimiento de la persona.
     * @param esDiscapacitado Indica si la persona tiene alguna discapacidad.
     * @param telefono El número de teléfono de la persona.
     * @param nombres Los nombres de la persona.
     * @param apellidoPaterno El apellido paterno de la persona.
     * @param apellidoMaterno El apellido materno de la persona.
     */
    public PersonaDTO(String RFC, Calendar fechaNacimiento, boolean esDiscapacitado, String telefono, String nombres, String apellidoPaterno, String apellidoMaterno) {
        this.RFC = RFC;
        this.fechaNacimiento = fechaNacimiento;
        this.esDiscapacitado = esDiscapacitado;
        this.telefono = telefono;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Constructor de la clase PersonaDTO que recibe todos los atributos como
     * parámetros.
     *
     * @param id El identificador único de la persona.
     * @param RFC El RFC de la persona.
     * @param fechaNacimiento La fecha de nacimiento de la persona.
     * @param esDiscapacitado Indica si la persona tiene alguna discapacidad.
     * @param telefono El número de teléfono de la persona.
     * @param nombres Los nombres de la persona.
     * @param apellidoPaterno El apellido paterno de la persona.
     * @param apellidoMaterno El apellido materno de la persona.
     */
    public PersonaDTO(Long id, String RFC, Calendar fechaNacimiento, boolean esDiscapacitado, String telefono, String nombres, String apellidoPaterno, String apellidoMaterno) {
        this.id = id;
        this.RFC = RFC;
        this.fechaNacimiento = fechaNacimiento;
        this.esDiscapacitado = esDiscapacitado;
        this.telefono = telefono;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Método getter para el identificador único de la persona.
     *
     * @return El identificador único de la persona.
     */
    public Long getId() {
        return id;
    }

    /**
     * Método setter para el identificador único de la persona.
     *
     * @param id El identificador único de la persona a establecer.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método getter para el RFC de la persona.
     *
     * @return El RFC de la persona.
     */
    public String getRFC() {
        return RFC;
    }

    /**
     * Método setter para el RFC de la persona.
     *
     * @param RFC El RFC de la persona a establecer.
     */
    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    /**
     * Método getter para la fecha de nacimiento de la persona.
     *
     * @return La fecha de nacimiento de la persona.
     */
    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Método setter para la fecha de nacimiento de la persona.
     *
     * @param fechaNacimiento La fecha de nacimiento de la persona a establecer.
     */
    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Método getter para indicar si la persona tiene alguna discapacidad.
     *
     * @return true si la persona tiene alguna discapacidad, false de lo
     * contrario.
     */
    public boolean isEsDiscapacitado() {
        return esDiscapacitado;
    }

    /**
     * Método setter para indicar si la persona tiene alguna discapacidad.
     *
     * @param esDiscapacitado true si la persona tiene alguna discapacidad,
     * false de lo contrario.
     */
    public void setEsDiscapacitado(boolean esDiscapacitado) {
        this.esDiscapacitado = esDiscapacitado;
    }

    /**
     * Método getter para el número de teléfono de la persona.
     *
     * @return El número de teléfono de la persona.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Método setter para el número de teléfono de la persona.
     *
     * @param telefono El número de teléfono de la persona a establecer.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Método getter para los nombres de la persona.
     *
     * @return Los nombres de la persona.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Método setter para los nombres de la persona.
     *
     * @param nombres Los nombres de la persona a establecer.
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Método getter para el apellido paterno de la persona.
     *
     * @return El apellido paterno de la persona.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Método setter para el apellido paterno de la persona.
     *
     * @param apellidoPaterno El apellido paterno de la persona a establecer.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Método getter para el apellido materno de la persona.
     *
     * @return El apellido materno de la persona.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno de la persona.
     *
     * @param apellidoMaterno El apellido materno de la persona a establecer.
     */

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

}
