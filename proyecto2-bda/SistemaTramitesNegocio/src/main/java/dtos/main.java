/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import bda.itson.entidadesJPA.Persona;
import interfaces.IRegistrarLicenciaBO;
import java.util.Calendar;
import java.util.Locale;
import negocio.RegistrarLicencia;

/**
 *
 * @author fabri
 */
public class main {
    public static void main(String[] args) {
        LicenciaDTO l = new LicenciaDTO(10, new Persona(), Calendar.getInstance(Locale.ITALY), Calendar.getInstance(Locale.ITALY), 100, LicenciaDTO.estadoDTO.EXPIRADA);
        IRegistrarLicenciaBO registrar = new RegistrarLicencia();
        registrar.registrarLicencia(l);
    }
}
