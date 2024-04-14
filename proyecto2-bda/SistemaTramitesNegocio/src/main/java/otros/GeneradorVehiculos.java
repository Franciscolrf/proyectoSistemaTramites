/**
 * GeneradorVehiculos.java
 *
 * Clase creada en Abril de 2024
 */
package otros;

import dtos.VehiculoDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 *
 * Clase para generar vehiculos aleatorios y persistirlos en la base de datos
 *
 * @author abelc
 */
public class GeneradorVehiculos {

    // Objeto Random para generar valores aleatorios
    private static final Random random = new Random();
    // Conjunto para almacenar los números de serie generados
    private static final Set<String> numerosSerieGenerados = new HashSet<>();
    // arreglo de colores
    private static final String[] colores = {"Negro", "Blanco", "Gris", "Azul", "Rojo", "Plateado", "Verde",
        "Blanco perla", "Amarillo", "Naranja"};
    // arreglo de marcas
    private static final String[] marcas = {"Toyota", "Hyundai", "Honda", "Chevrolet", "Kia"};
    private static final Map<String, String[]> modelosPorMarca = new HashMap<>();

    static {
        modelosPorMarca.put("Toyota", new String[]{"Corolla", "Camry", "Avalon", "Prius", "Mirai", "Yaris", "C-HR",
            "RAV4", "Highlander", "4Runner", "Sequoia", "Land Cruiser", "Tacoma", "Tundra"});
        modelosPorMarca.put("Hyundai", new String[]{"Accent", "Elantra", "Sonata", "Veloster", "Kona", "Tucson",
            "Santa Fe", "Palisade", "Nexo"});
        modelosPorMarca.put("Honda",
                new String[]{"Civic", "Accord", "Fit", "HR-V", "CR-V", "Passport", "Pilot", "Ridgeline", "Clarity"});
        modelosPorMarca.put("Chevrolet", new String[]{"Spark", "Sonic", "Malibu", "Camaro", "Corvette", "Trax",
            "Equinox", "Blazer", "Traverse", "Tahoe", "Suburban", "Colorado", "Silverado", "Bolt EV"});
        modelosPorMarca.put("Kia", new String[]{"Rio", "Forte", "Optima", "Stinger", "Soul", "Niro", "Sportage",
            "Seltos", "Sorento", "Telluride", "Carnival"});
    }

    private static final Map<String, Map<String, String[]>> lineasPorModeloYMarca = new HashMap<>();

    static {
        // Toyota
        Map<String, String[]> modelosToyota = new HashMap<>();
        modelosToyota.put("Corolla", new String[]{"Sedán"});
        modelosToyota.put("Camry", new String[]{"Sedán"});
        modelosToyota.put("Avalon", new String[]{"Sedán"});
        modelosToyota.put("Prius", new String[]{"Híbrido"});
        modelosToyota.put("Mirai", new String[]{"Híbrido"});
        modelosToyota.put("Yaris", new String[]{"Hatchback"});
        modelosToyota.put("C-HR", new String[]{"SUV"});
        modelosToyota.put("RAV4", new String[]{"SUV"});
        modelosToyota.put("Highlander", new String[]{"SUV"});
        modelosToyota.put("4Runner", new String[]{"SUV"});
        modelosToyota.put("Sequoia", new String[]{"SUV"});
        modelosToyota.put("Land Cruiser", new String[]{"SUV"});
        modelosToyota.put("Tacoma", new String[]{"Camioneta"});
        modelosToyota.put("Tundra", new String[]{"Camioneta"});
        lineasPorModeloYMarca.put("Toyota", modelosToyota);

        // Hyundai
        Map<String, String[]> modelosHyundai = new HashMap<>();
        modelosHyundai.put("Accent", new String[]{"Sedán"});
        modelosHyundai.put("Elantra", new String[]{"Sedán"});
        modelosHyundai.put("Sonata", new String[]{"Sedán"});
        modelosHyundai.put("Veloster", new String[]{"Hatchback"});
        modelosHyundai.put("Kona", new String[]{"SUV"});
        modelosHyundai.put("Tucson", new String[]{"SUV"});
        modelosHyundai.put("Santa Fe", new String[]{"SUV"});
        modelosHyundai.put("Palisade", new String[]{"SUV"});
        modelosHyundai.put("Nexo", new String[]{"Hidrógeno"});
        lineasPorModeloYMarca.put("Hyundai", modelosHyundai);

        // Honda
        Map<String, String[]> modelosHonda = new HashMap<>();
        modelosHonda.put("Civic", new String[]{"Sedán"});
        modelosHonda.put("Accord", new String[]{"Sedán"});
        modelosHonda.put("Fit", new String[]{"Hatchback"});
        modelosHonda.put("HR-V", new String[]{"SUV"});
        modelosHonda.put("CR-V", new String[]{"SUV"});
        modelosHonda.put("Passport", new String[]{"SUV"});
        modelosHonda.put("Pilot", new String[]{"SUV"});
        modelosHonda.put("Ridgeline", new String[]{"Camioneta"});
        modelosHonda.put("Clarity", new String[]{"Híbrido"});
        lineasPorModeloYMarca.put("Honda", modelosHonda);

        // Chevrolet
        Map<String, String[]> modelosChevrolet = new HashMap<>();
        modelosChevrolet.put("Spark", new String[]{"Hatchback"});
        modelosChevrolet.put("Sonic", new String[]{"Sedán"});
        modelosChevrolet.put("Malibu", new String[]{"Sedán"});
        modelosChevrolet.put("Camaro", new String[]{"Coupé"});
        modelosChevrolet.put("Corvette", new String[]{"Deportivo"});
        modelosChevrolet.put("Trax", new String[]{"SUV"});
        modelosChevrolet.put("Equinox", new String[]{"SUV"});
        modelosChevrolet.put("Blazer", new String[]{"SUV"});
        modelosChevrolet.put("Traverse", new String[]{"SUV"});
        modelosChevrolet.put("Tahoe", new String[]{"SUV"});
        modelosChevrolet.put("Suburban", new String[]{"SUV"});
        modelosChevrolet.put("Colorado", new String[]{"Camioneta"});
        modelosChevrolet.put("Silverado", new String[]{"Camioneta"});
        modelosChevrolet.put("Bolt EV", new String[]{"Eléctrico"});
        lineasPorModeloYMarca.put("Chevrolet", modelosChevrolet);

        // Kia
        Map<String, String[]> modelosKia = new HashMap<>();
        modelosKia.put("Rio", new String[]{"Sedán"});
        modelosKia.put("Forte", new String[]{"Sedán"});
        modelosKia.put("Optima", new String[]{"Sedán"});
        modelosKia.put("Stinger", new String[]{"Sedán"});
        modelosKia.put("Soul", new String[]{"Hatchback"});
        modelosKia.put("Niro", new String[]{"Híbrido"});
        modelosKia.put("Sportage", new String[]{"SUV"});
        modelosKia.put("Seltos", new String[]{"SUV"});
        modelosKia.put("Sorento", new String[]{"SUV"});
        modelosKia.put("Telluride", new String[]{"SUV"});
        modelosKia.put("Carnival", new String[]{"Minivan"});
        lineasPorModeloYMarca.put("Kia", modelosKia);

    }

    // Para la futura implementación de otros vehiculos.
    private static final String[] tiposVehiculo = {"Automovil", "Motocicleta", "Camion", "Autobus", "Trailer", "Tractocamion"};

    /**
     * Método para generar la marca del vehículo.
     *
     * @return la marca generada
     */
    public static String generarMarca() {
        return marcas[random.nextInt(marcas.length)];
    }

    /**
     * Método para generar el modelo del vehículo.
     *
     * @param marca la marca del vehículo
     * @return el modelo generado
     */
    public static String generarModelo(String marca) {
        String[] modelos = modelosPorMarca.get(marca);
        if (modelos != null && modelos.length > 0) {
            return modelos[random.nextInt(modelos.length)];
        } else {
            return "Modelo no especificado";
        }
    }

    /**
     * Método para generar la línea del vehículo.
     *
     * @param marca la marca del vehículo
     * @param modelo el modelo del vehículo
     * @return la línea generada
     */
    public static String generarLinea(String marca, String modelo) {
        Map<String, String[]> lineasPorModelo = lineasPorModeloYMarca.get(marca);
        if (lineasPorModelo != null) {
            String[] lineas = lineasPorModelo.get(modelo);
            if (lineas != null && lineas.length > 0) {
                return lineas[random.nextInt(lineas.length)];
            }
        }
        return "Línea no especificada";
    }

    /**
     * Método para generar un número de serie aleatorio para un vehículo. El
     * número de serie consiste en 8 caracteres que varían entre números y
     * letras.
     *
     * @return el número de serie generado
     */
    public static String generarNumeroSerie() {
        String numeroSerie;
        do {
            numeroSerie = generarNumeroSerieAleatorio();
        } while (!numerosSerieGenerados.add(numeroSerie)); // Intenta agregar el número de serie al conjunto y repite si
        // ya existe

        return numeroSerie;
    }

    // Método privado para generar un número de serie aleatorio
    private static String generarNumeroSerieAleatorio() {
        StringBuilder numeroSerie = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            char caracter;
            if (random.nextBoolean()) { // Generar un número
                caracter = (char) (random.nextInt(10) + '0');
            } else { // Generar una letra mayúscula
                caracter = (char) (random.nextInt(26) + 'A');
            }
            numeroSerie.append(caracter);
        }
        return numeroSerie.toString();
    }

    /**
     * Método para generar el estado del vehículo (Nuevo o Usado).
     *
     * @return el estado generado
     */
    public static String generarEstado() {
        return random.nextBoolean() ? "Nuevo" : "Usado";
    }

    /**
     * Método para generar el color del vehículo.
     *
     * @return el color generado
     */
    public static String generarColor() {
        return colores[random.nextInt(colores.length)];
    }

    /**
     * Método para generar el tipo de vehículo.
     *
     * @return el tipo de vehículo generado
     */
    public static String generarTipoVehiculo() {
        return "Automovil";
    }

    /**
     * Genera una lista de vehículos DTO con la cantidad especificada.
     *
     * @param cantidad La cantidad de vehículos a generar.
     * @return Una lista de vehículos DTO generados.
     */
    public List<VehiculoDTO> generarVehiculos(int cantidad) {
        List<VehiculoDTO> vehiculos = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            String marca = GeneradorVehiculos.generarMarca();
            String modelo = GeneradorVehiculos.generarModelo(marca);
            String linea = GeneradorVehiculos.generarLinea(marca, modelo);
            String numeroSerie = GeneradorVehiculos.generarNumeroSerie();
            String estado = GeneradorVehiculos.generarEstado();
            String color = GeneradorVehiculos.generarColor();
            String tipoVehiculo = GeneradorVehiculos.generarTipoVehiculo();

            VehiculoDTO vehiculo = new VehiculoDTO(null, numeroSerie, estado, color, modelo, marca, linea, tipoVehiculo, null);
            vehiculos.add(vehiculo);
        }
        return vehiculos;
    }
}
