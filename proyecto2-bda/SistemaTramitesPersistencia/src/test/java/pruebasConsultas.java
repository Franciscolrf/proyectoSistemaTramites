
import bda.itson.entidadesJPA.Licencia;
import bda.itson.entidadesJPA.Persona;
import bda.itson.entidadesJPA.Placa;
import dao.LicenciaDAO;
import dao.PlacaDAO;
import excepciones.PersistenciaException;
import java.util.Calendar;
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
public class pruebasConsultas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      PlacaDAO placa =new PlacaDAO();
       Persona persona = new Persona();
       LicenciaDAO lic=new LicenciaDAO();
            persona.setId(101L); // Suponiendo que la clase Persona tiene un método setId

            // Crear un rango de fechas del 1 al 3 de abril de 2024
            Calendar fechaInicio = new GregorianCalendar(2024, Calendar.APRIL, 1);
            Calendar fechaFin = new GregorianCalendar(2024, Calendar.APRIL, 3);
     /*
            try {
            List<Placa> placas =placa.consultarPlacasTramitadasPorPersona(persona);
            for (Placa pl : placas) {
                System.out.println(pl.getCodigo()); // Suponiendo que la clase Placa tiene un método getId
            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(pruebasConsultas.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        try {
            List<Licencia> licencias=lic.obtenerLicenciasPorPersona(persona);
            for (Licencia l : licencias) {
                System.out.println(l.getIdLicencia()); // Suponiendo que la clase Placa tiene un método getId
            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(pruebasConsultas.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
