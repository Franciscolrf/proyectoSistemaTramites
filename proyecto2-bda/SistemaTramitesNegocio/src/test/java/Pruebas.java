
import bda.itson.entidadesJPA.Placa;
import static bda.itson.entidadesJPA.Vehiculo_.placas;
import dtos.PlacaDTO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import otros.Conversiones;
import otros.GeneradorPlacas;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author abelc
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorPlacas placas = new GeneradorPlacas();
        List<PlacaDTO> placasDTO = placas.generarPlacas();
        Conversiones conversiones = new Conversiones();
        List<Placa> placasEnt=conversiones.PlacasDTOAPlacas(placasDTO);
        /*SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (PlacaDTO placa : placasDTO) {
            
            Date fechaRecepcionDate = (placa.getFechaRecepcion() != null) ? placa.getFechaRecepcion().getTime() : null;
            Date fechaExpedicionDate = (placa.getFechaExpedicion() != null) ? placa.getFechaExpedicion().getTime() : null;
            String fechaRecepcionStr = (fechaRecepcionDate != null) ? dateFormat.format(fechaRecepcionDate) : "null";
            String fechaExpedicionStr = (fechaExpedicionDate != null) ? dateFormat.format(fechaExpedicionDate) : "null";
            System.out.println(placa.getCodigo());
            System.out.println("Fecha de Expedición: " + fechaExpedicionStr);
            System.out.println("Fecha de Recepción: " + fechaRecepcionStr);
            System.out.println(placa.getEstado());
            
        }*/
        
        /*for (PlacaDTO placaDTO : placasDTO) {
            Placa placa = conversiones.PlacaDTOAPlacaSinVehiculo(placaDTO);
            System.out.println(placa.getCodigo());
        }*/
        for (Placa placasE:placasEnt) {
            System.out.println(placasE.getCodigo());
        }
    }

}
