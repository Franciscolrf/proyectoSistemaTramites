package bda.itson.dtos;

import java.util.Calendar;

import otros.Generadores;
import otros.GeneradorVehiculos;

public class pruebasGen {
    public static void main(String[] args) {
        Generadores generadorPersonas = new Generadores();

        System.out.println("----- Generación de personas -----");
        for (int i = 0; i < 5; i++) {
            String nombre = generadorPersonas.generarNombre();
            String apellidoPaterno = generadorPersonas.generarApellidoPaterno();
            String apellidoMaterno = generadorPersonas.generarApellidoMaterno();
            String primeraVocal = generadorPersonas.obtenerPrimeraVocal(apellidoPaterno);
            Calendar fechaNacimiento = generadorPersonas.generarFechaAleatoria(1950, 2003);
            String telefono = generadorPersonas.generarNumeroTelefono();
            boolean esDiscapacitado = generadorPersonas.generarBooleanoAleatorio();
            
            System.out.println("Nombre: " + nombre + ", Apellido Paterno: " + apellidoPaterno +
                    ", Apellido Materno: " + apellidoMaterno + ", Primera Vocal: " + primeraVocal +
                    ", Fecha de Nacimiento: " + fechaNacimiento.getTime() +
                    ", Teléfono: " + telefono + ", Es Discapacitado: " + esDiscapacitado);
        }

        System.out.println("\n----- Generación de vehículos -----");
        for (int i = 0; i < 5; i++) {
            String marca = GeneradorVehiculos.generarMarca();
            String modelo = GeneradorVehiculos.generarModelo(marca);
            String numeroSerie = GeneradorVehiculos.generarNumeroSerie();
            String estado = GeneradorVehiculos.generarEstado();
            String color = GeneradorVehiculos.generarColor();
            String linea = GeneradorVehiculos.generarLinea(marca, modelo);
            String tipoVehiculo = GeneradorVehiculos.generarTipoVehiculo();
            System.out.println("Marca: " + marca + ", Modelo: " + modelo + ", Número de serie: " + numeroSerie
                    + ", Estado: " + estado + ", Color: " + color + ", Línea: " + linea + ", Tipo de vehículo: "
                    + tipoVehiculo);
        }
    }
}
