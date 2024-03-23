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
public class PersonaDTO {
   int id;
   private String RFC;
    private Calendar fechaNacimiento;
    private boolean esDiscapacitado;
    private String telefono;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;

    public PersonaDTO() {
    }

    public PersonaDTO(String RFC, Calendar fechaNacimiento, boolean esDiscapacitado, String telefono, String nombres, String apellidoPaterno, String apellidoMaterno) {
        this.RFC = RFC;
        this.fechaNacimiento = fechaNacimiento;
        this.esDiscapacitado = esDiscapacitado;
        this.telefono = telefono;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    public PersonaDTO(int id, String RFC, Calendar fechaNacimiento, boolean esDiscapacitado, String telefono, String nombres, String apellidoPaterno, String apellidoMaterno) {
        this.id = id;
        this.RFC = RFC;
        this.fechaNacimiento = fechaNacimiento;
        this.esDiscapacitado = esDiscapacitado;
        this.telefono = telefono;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isEsDiscapacitado() {
        return esDiscapacitado;
    }

    public void setEsDiscapacitado(boolean esDiscapacitado) {
        this.esDiscapacitado = esDiscapacitado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
    
    
}
