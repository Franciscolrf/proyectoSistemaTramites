/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package otros;

import dao.PlacaDAO;
import dtos.PlacaDTO;
import excepciones.PersistenciaException;
import interfaces.IPlacaDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abelc
 */
public class GeneradorPlacas {

    public static final String[] caracteres = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
        "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    public static final String[] digitos = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
    private Random random;
    private final IPlacaDAO placaDAO;

    public GeneradorPlacas() {
        this.random = new Random();
        placaDAO = new PlacaDAO();
    }

    public String generarCodigoPlaca() {
        String codigo;
        boolean codigoExistente = false;

        do {
            codigo = crearCodigoAleatorio();
            try {
                codigoExistente = placaDAO.buscarPlacaCodigo(codigo) != null;
            } catch (PersistenciaException ex) {
                Logger.getLogger(GeneradorPlacas.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (codigoExistente);

        return codigo;
    }

    private String crearCodigoAleatorio() {
        String car = caracteres[random.nextInt(caracteres.length)] + caracteres[random.nextInt(caracteres.length)] + caracteres[random.nextInt(caracteres.length)];
        String dig = digitos[random.nextInt(digitos.length)] + digitos[random.nextInt(digitos.length)] + digitos[random.nextInt(digitos.length)];
        return car + "-" + dig;
    }

    /**
     * metodo que genera placa inactiva con precio de carro usado, se usara solo
     * para la generacion de carros al ingresar personas si el carro es usado
     *
     * @return placaDTO que representa una placa inactiva
     */
    public PlacaDTO generarPlacaPrecioUsado() {
        PlacaDTO placa = new PlacaDTO();
        GeneradorPersonas fechaGenerador = new GeneradorPersonas();
        placa.setCodigo(generarCodigoPlaca());
        placa.setCosto(1000.00);
        placa.setEstado("inactiva");

        Calendar fechaRecepcion = fechaGenerador.generarFechaAleatoria(2015, 2020);
        placa.setFechaRecepcion(fechaRecepcion);
        Calendar fechaExpedicion;
        do {
            fechaExpedicion = fechaGenerador.generarFechaAleatoria(2015, 2020);
        } while (fechaExpedicion.after(fechaRecepcion)); // Asegurar que la fecha de expedición no sea posterior a la de recepción

        placa.setFechaExpedicion(fechaExpedicion);

        return placa;
    }

    /**
     * Metodo que genera las primeras placas registradas para los carros nuevos
     * generados
     *
     * @return placaDTO que representa una placa inactiva
     */
    public PlacaDTO generarPlacaPrecioNuevo() {
        PlacaDTO placa = new PlacaDTO();
        GeneradorPersonas fechaGenerador = new GeneradorPersonas();
        placa.setCodigo(generarCodigoPlaca());
        placa.setCosto(1500.00);
        placa.setEstado("inactiva");
        Calendar fechaRecepcion = fechaGenerador.generarFechaAleatoria(2010, 2014);
        placa.setFechaRecepcion(fechaRecepcion);
        Calendar fechaExpedicion;
        do {
            fechaExpedicion = fechaGenerador.generarFechaAleatoria(2010, 2014);
        } while (fechaExpedicion.after(fechaRecepcion)); // Asegurar que la fecha de expedición no sea posterior a la de recepción

        placa.setFechaExpedicion(fechaExpedicion);

        return placa;
    }

    /**
     * Genera una nueva placa basada en la información proporcionada en el
     * objeto PlacaDTO dado.
     *
     * @param placa El objeto PlacaDTO con la información del vehiculo para
     * determinar el precio.
     * @return Un nuevo objeto PlacaDTO generado.
     */
    public PlacaDTO generarPlaca(PlacaDTO placa) {
        placa.setCodigo(generarCodigoPlaca());
        placa.setEstado("activa");
        Calendar fechaActual = Calendar.getInstance();
        placa.setFechaExpedicion(fechaActual);
        if ("Nuevo".equals(placa.getVehiculo().getEstado())) {
            placa.setCosto(1500.00);
        } else {
            placa.setCosto(1000.00);
        }
        return placa;
    }

    public List<PlacaDTO> generarPlacas() {
        List<PlacaDTO> placasGeneradas = new ArrayList<>();

        PlacaDTO placa1 = generarPlacaPrecioNuevo();
        PlacaDTO placa2 = generarPlacaPrecioNuevo();
        PlacaDTO placa3 = generarPlacaPrecioUsado();
        PlacaDTO placa4 = generarPlacaPrecioUsado();

        placa2.setFechaExpedicion(placa1.getFechaRecepcion());
        placa2.setFechaRecepcion(placa3.getFechaExpedicion());

        Calendar fechaExpedicionPlaca3 = placa3.getFechaExpedicion();
        Calendar fechaRecepcionPlaca4 = (Calendar) fechaExpedicionPlaca3.clone();
        fechaRecepcionPlaca4.add(Calendar.YEAR, 1);

        placa4.setFechaExpedicion(fechaExpedicionPlaca3);
        placa4.setFechaRecepcion(fechaRecepcionPlaca4);

        placasGeneradas.add(placa1);
        placasGeneradas.add(placa2);
        placasGeneradas.add(placa3);
        placasGeneradas.add(placa4);

        return placasGeneradas;
    }
}
