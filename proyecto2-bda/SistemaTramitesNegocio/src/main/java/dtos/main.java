/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import bda.itson.entidadesJPA.Persona;
import dao.ConexionJPA;
import dao.PersonaDAO;
import excepciones.PersistenciaException;
import interfaces.IConexion;
import interfaces.IRegistrarLicenciaBO;
import java.util.Calendar;
import negocio.RegistrarLicencia;

/**
 *
 * @author fabri
 */
public class main {

    public static void main(String[] args) throws PersistenciaException {
        // falta hacer un metodo que en vez de crear una licdto nomas le pases los datos
        IConexion conexion = new ConexionJPA("bda.itson_SistemaTramitesPersistencia_jar_1.0-SNAPSHOTPU");

        PersonaDAO p = new PersonaDAO(conexion);
        LicenciaDTO l = new LicenciaDTO();
        Calendar calendar = Calendar.getInstance();
        Persona persona = p.obtenerPersonaRFC("aaaa");
        calendar.set(2020, 10, 10);
        l.setFechaVencimiento(calendar);
        l.setPersona(persona);
        IRegistrarLicenciaBO registrar = new RegistrarLicencia();
        registrar.registrarLicencia(l);
    }
}
