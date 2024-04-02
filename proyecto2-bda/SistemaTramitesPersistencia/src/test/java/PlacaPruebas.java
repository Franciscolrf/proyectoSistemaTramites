
import bda.itson.entidadesJPA.Placa;
import dao.PlacaDAO;
import excepciones.PersistenciaException;
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
public class PlacaPruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       PlacaDAO p=new PlacaDAO();
       Placa placa = null; 
       try {
             placa=p.buscarPlacaCodigo("123");
        } catch (PersistenciaException ex) {
            Logger.getLogger(PlacaPruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(placa.getVehiculo().getId());
    }
    
}
