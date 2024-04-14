/**
 * PlacaDTO.java
 *
 * Clase creada en Abril de 2024
 */
package dtos;

import java.util.Calendar;

/**
 * Clase que representa un objeto de transferencia de datos (DTO) para una
 * Placa.
 *
 * @author abelc
 *
 */
public class PlacaDTO {

    private Long id;
    private String codigo;
    private double costo;
    private Calendar fechaRecepcion;
    private String estado;
    private Calendar fechaExpedicion;
    private VehiculoDTO vehiculo;

    /**
     * Constructor vacío de la clase PlacaDTO.
     */
    public PlacaDTO() {
    }

    /**
     * Método que obtiene el identificador único de la placa.
     *
     * @return El identificador único de la placa.
     */
    public Long getId() {
        return id;
    }

    /**
     * Método que establece el identificador único de la placa.
     *
     * @param id El identificador único de la placa.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método que obtiene el código de la placa.
     *
     * @return El código de la placa.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Método que establece el código de la placa.
     *
     * @param codigo El código de la placa.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Método que obtiene el costo de la placa.
     *
     * @return El costo de la placa.
     */
    public double getCosto() {
        return costo;
    }

    /**
     * Método que establece el costo de la placa.
     *
     * @param costo El costo de la placa.
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }

    /**
     * Método que obtiene la fecha de recepción de la placa.
     *
     * @return La fecha de recepción de la placa.
     */
    public Calendar getFechaRecepcion() {
        return fechaRecepcion;
    }

    /**
     * Método que establece la fecha de recepción de la placa.
     *
     * @param fechaRecepcion La fecha de recepción de la placa.
     */
    public void setFechaRecepcion(Calendar fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    /**
     * Método que obtiene el estado de la placa.
     *
     * @return El estado de la placa.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Método que establece el estado de la placa.
     *
     * @param estado El estado de la placa.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método que obtiene la fecha de expedición de la placa.
     *
     * @return La fecha de expedición de la placa.
     */
    public Calendar getFechaExpedicion() {
        return fechaExpedicion;
    }

    /**
     * Método que establece la fecha de expedición de la placa.
     *
     * @param fechaExpedicion La fecha de expedición de la placa.
     */
    public void setFechaExpedicion(Calendar fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    /**
     * Método que obtiene el vehículo asociado a la placa.
     *
     * @return El vehículo asociado a la placa.
     */
    public VehiculoDTO getVehiculo() {
        return vehiculo;
    }

    /**
     * Método que establece el vehículo asociado a la placa.
     *
     * @param vehiculo El vehículo asociado a la placa.
     */
    public void setVehiculo(VehiculoDTO vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Método que retorna una representación en forma de cadena del objeto
     * PlacaDTO.
     *
     * @return Representación en forma de cadena del objeto PlacaDTO.
     */
    @Override
    public String toString() {
        return "PlacaDTO{" + "id=" + id + ", codigo=" + codigo + ", costo=" + costo + ", fechaRecepcion=" + fechaRecepcion + ", estado=" + estado + ", fechaExpedicion=" + fechaExpedicion + ", vehiculo=" + vehiculo + '}';
    }
}
