/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author abelc Esta clase representa un objeto de transferencia de datos (DTO)
 * para los vehículos. Contiene información sobre las características de un
 * vehículo y su propietario.
 *
 */
public class VehiculoDTO {
    // Campos que representan las características de un vehículo

    /**
     * Identificador único del vehículo
     */
    private Long id;

    /**
     * Número de serie del vehículo
     */
    private String numeroSerie;

    /**
     * Estado del vehículo (Nuevo, Usado, etc.)
     */
    private String estado;

    /**
     * Color del vehículo
     */
    private String color;

    /**
     * Modelo del vehículo
     */
    private String modelo;

    /**
     * Marca del vehículo
     */
    private String marca;

    /**
     * Línea del vehículo
     */
    private String linea;

    /**
     * Tipo de vehículo (Automóvil, Camioneta, etc.)
     */
    private String tipoVehiculo;

    // Campo para representar al propietario del vehículo
    /**
     * Información del propietario del vehículo
     */
    private PersonaDTO propietario;

    // Constructor vacío
    /**
     * Constructor por defecto de la clase VehiculoDTO. Inicializa todos los
     * campos en sus valores por defecto.
     */
    public VehiculoDTO() {
    }

    // Constructor completo
    /**
     * Constructor que inicializa todos los campos de la clase VehiculoDTO.
     *
     * @param id Identificador único del vehículo.
     * @param numeroSerie Número de serie del vehículo.
     * @param estado Estado del vehículo (Nuevo, Usado, etc.).
     * @param color Color del vehículo.
     * @param modelo Modelo del vehículo.
     * @param marca Marca del vehículo.
     * @param linea Línea del vehículo.
     * @param tipoVehiculo Tipo de vehículo (Automóvil, Camioneta, etc.).
     * @param propietario Información del propietario del vehículo.
     */
    public VehiculoDTO(Long id, String numeroSerie, String estado, String color, String modelo, String marca,
            String linea, String tipoVehiculo, PersonaDTO propietario) {
        this.id = id;
        this.numeroSerie = numeroSerie;
        this.estado = estado;
        this.color = color;
        this.modelo = modelo;
        this.marca = marca;
        this.linea = linea;
        this.tipoVehiculo = tipoVehiculo;
        this.propietario = propietario;
    }

    // Constructor sin el campo de identificación (id)
    /**
     * Constructor que inicializa todos los campos de la clase VehiculoDTO
     * excepto el identificador único.
     *
     * @param numeroSerie Número de serie del vehículo.
     * @param estado Estado del vehículo (Nuevo, Usado, etc.).
     * @param color Color del vehículo.
     * @param modelo Modelo del vehículo.
     * @param marca Marca del vehículo.
     * @param linea Línea del vehículo.
     * @param tipoVehiculo Tipo de vehículo (Automóvil, Camioneta, etc.).
     */
    public VehiculoDTO(String numeroSerie, String estado, String color, String modelo, String marca, String linea,
            String tipoVehiculo) {
        this.numeroSerie = numeroSerie;
        this.estado = estado;
        this.color = color;
        this.modelo = modelo;
        this.marca = marca;
        this.linea = linea;
        this.tipoVehiculo = tipoVehiculo;
    }

    /**
     * Método getter para obtener el ID del vehículo.
     *
     * @return El ID del vehículo.
     */
    public Long getId() {
        return id;
    }

    /**
     * Método setter para establecer el ID del vehículo.
     *
     * @param id El ID del vehículo a establecer.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método getter para obtener el número de serie del vehículo.
     *
     * @return El número de serie del vehículo.
     */
    public String getNumeroSerie() {
        return numeroSerie;
    }

    /**
     * Método setter para establecer el número de serie del vehículo.
     *
     * @param numeroSerie El número de serie del vehículo a establecer.
     */
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    /**
     * Método getter para obtener el estado del vehículo.
     *
     * @return El estado del vehículo.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Método setter para establecer el estado del vehículo.
     *
     * @param estado El estado del vehículo a establecer.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método getter para obtener el color del vehículo.
     *
     * @return El color del vehículo.
     */
    public String getColor() {
        return color;
    }

    /**
     * Método setter para establecer el color del vehículo.
     *
     * @param color El color del vehículo a establecer.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Método getter para obtener el modelo del vehículo.
     *
     * @return El modelo del vehículo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Método setter para establecer el modelo del vehículo.
     *
     * @param modelo El modelo del vehículo a establecer.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Método getter para obtener la marca del vehículo.
     *
     * @return La marca del vehículo.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Método setter para establecer la marca del vehículo.
     *
     * @param marca La marca del vehículo a establecer.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Método getter para obtener la línea del vehículo.
     *
     * @return La línea del vehículo.
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Método setter para establecer la línea del vehículo.
     *
     * @param linea La línea del vehículo a establecer.
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * Método getter para obtener el tipo de vehículo.
     *
     * @return El tipo de vehículo.
     */
    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    /**
     * Método setter para establecer el tipo de vehículo.
     *
     * @param tipoVehiculo El tipo de vehículo a establecer.
     */
    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    /**
     * Método getter para obtener el propietario del vehículo.
     *
     * @return El propietario del vehículo.
     */
    public PersonaDTO getPropietario() {
        return propietario;
    }

    /**
     * Método setter para establecer el propietario del vehículo.
     *
     * @param propietario El propietario del vehículo a establecer.
     */
    public void setPropietario(PersonaDTO propietario) {
        this.propietario = propietario;
    }

    
}
