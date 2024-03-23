
import bda.itson.entidadesJPA.Persona;
import dao.ConexionJPA;
import dao.PersonaDAO;
import excepciones.PersistenciaException;
import interfaces.IConexion;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author abelc
 */
public class pruebaPersonaDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String unidadPersistencia= "bda.itson_SistemaTramitesPersistencia_jar_1.0-SNAPSHOTPU";
        IConexion conexionJPA= new ConexionJPA(unidadPersistencia);
        PersonaDAO daoPrueba= new PersonaDAO(conexionJPA);
        /*
        Insercion solo 1(Solo para probar la entidad jale al 100)
        Persona persona = new Persona();
        persona.setRFC("ABC123");
        persona.setFechaNacimiento(new GregorianCalendar(2000, 1, 22)); // Establecer la fecha de nacimiento
        persona.setEsDiscapacitado(false);
        persona.setTelefono("1234567890");
        persona.setNombres("Juan");
        persona.setApellidoPaterno("Pérez");
        persona.setApellidoMaterno("Gómez");
        try {
            daoPrueba.registrarPersona(persona);
        } catch (PersistenciaException ex) {
            Logger.getLogger(pruebaPersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        /*
        Prueba de insercion masiva
        List<Persona> personas = new ArrayList<>();

        // Crear la primera persona
        Persona persona1 = new Persona();
        persona1.setRFC("ABC124");
        persona1.setFechaNacimiento(new GregorianCalendar(2000, 1, 22)); // Fecha de nacimiento actual
        persona1.setEsDiscapacitado(false);
        persona1.setTelefono("1234567890");
        persona1.setNombres("Juan");
        persona1.setApellidoPaterno("Pérez");
        persona1.setApellidoMaterno("Gómez");
        personas.add(persona1);

        // Crear la segunda persona
        Persona persona2 = new Persona();
        persona2.setRFC("DEF456");
        persona2.setFechaNacimiento(new GregorianCalendar(2000, 1, 22)); // Fecha de nacimiento actual
        persona2.setEsDiscapacitado(true);
        persona2.setTelefono("9876543210");
        persona2.setNombres("María");
        persona2.setApellidoPaterno("González");
        persona2.setApellidoMaterno("López");
        personas.add(persona2);

        // Crear la tercera persona
        Persona persona3 = new Persona();
        persona3.setRFC("GHI789");
        persona3.setFechaNacimiento(new GregorianCalendar(2000, 1, 22)); // Fecha de nacimiento actual
        persona3.setEsDiscapacitado(false);
        persona3.setTelefono("555444333");
        persona3.setNombres("Carlos");
        persona3.setApellidoPaterno("Martínez");
        persona3.setApellidoMaterno("Ruiz");
        personas.add(persona3);
        try {
            daoPrueba.insercionMasivaPersonas(personas);
        } catch (PersistenciaException ex) {
            Logger.getLogger(pruebaPersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        Persona persona=null;
        try {
            persona=daoPrueba.obtenerPersonaRFC("GHI789");
        } catch (PersistenciaException ex) {
            Logger.getLogger(pruebaPersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(persona.getNombres());
        
    }
    
}
