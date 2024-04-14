/**
 * Conversiones.java
 *
 * Clase creada en Abril de 2024
 */
package tablas;

import dtos.LicenciaDTO;
import dtos.PersonaDTO;
import dtos.PlacaDTO;
import dtos.VehiculoDTO;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import negocio.RegistrarLicencia;
import interfaces.IRegistrarLicencia;

/**
 *
 * Clase para realizar conversiones de distintos tipos de datos y facilitar la
 * modularidad del código. Proporciona métodos para convertir listas de objetos
 * DTO en modelos de tabla para su visualización en GUI. Utiliza un formato de
 * fecha específico ("dd-MM-yyyy") para formatear las fechas.
 *
 * @author abelc
 */
public class Conversiones {

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public Conversiones() {

    }

    /**
     * Convierte una lista de objetos PersonaDTO en un DefaultTableModel para
     * mostrar en una tabla.
     *
     * @param listaPersonas La lista de personas a convertir.
     * @return DefaultTableModel con los datos de las personas.
     */
    public DefaultTableModel personasTableModel(List<PersonaDTO> listaPersonas) {
        String[] columnas = {"Nombres", "Apellido Paterno", "Apellido Materno", "Teléfono", "RFC", "Discapacidad", "Fecha de Nacimiento"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String discapacitado;
        for (PersonaDTO persona : listaPersonas) {
            Object[] fila = {
                persona.getNombres(),
                persona.getApellidoPaterno(),
                persona.getApellidoMaterno(),
                persona.getTelefono(),
                persona.getRFC(),
                discapacitado = (persona.isEsDiscapacitado()) ? "Si" : "No",
                dateFormat.format(persona.getFechaNacimiento().getTime()), // Convertir Calendar a String en formato "dd-MM-yyyy"
            };
            modelo.addRow(fila);
        }

        return modelo;
    }

    /**
     * Convierte una lista de objetos PersonaDTO en un DefaultTableModel para
     * mostrar en una tabla, incluyendo información sobre la licencia activa de
     * cada persona.
     *
     * @param listaPersonas La lista de personas a convertir.
     * @return DefaultTableModel con los datos de las personas y su estado de
     * licencia.
     */
    public DefaultTableModel personasModuloPlacasTableModel(List<PersonaDTO> listaPersonas) {
        IRegistrarLicencia licencia = new RegistrarLicencia();
        String[] columnas = {"Nombres", "Apellido Paterno", "Apellido Materno", "Teléfono", "RFC", "Discapacidad", "Fecha de Nacimiento", "Licencia"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        String discapacitado;
        String licenciaActiva;
        for (PersonaDTO persona : listaPersonas) {
            Object[] fila = {
                persona.getNombres(),
                persona.getApellidoPaterno(),
                persona.getApellidoMaterno(),
                persona.getTelefono(),
                persona.getRFC(),
                discapacitado = (persona.isEsDiscapacitado()) ? "Si" : "No",
                dateFormat.format(persona.getFechaNacimiento().getTime()),
                licenciaActiva = (licencia.verificarLicenciaActiva(persona)) ? "Si" : "No"
            };
            modelo.addRow(fila);
        }

        return modelo;
    }

    /**
     * Convierte una lista de objetos VehiculoDTO en un DefaultTableModel para
     * mostrar en una tabla.
     *
     * @param listaVehiculos La lista de vehículos a convertir.
     * @return DefaultTableModel con los datos de los vehículos.
     */
    public DefaultTableModel vehiculosTableModel(List<VehiculoDTO> listaVehiculos) {
        String[] columnas = {"Numero de serie", "Estado", "Color", "Modelo", "Marca", "Linea", "Tipo"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        for (VehiculoDTO vehiculo : listaVehiculos) {
            Object[] fila = {
                vehiculo.getNumeroSerie(),
                vehiculo.getEstado(),
                vehiculo.getColor(),
                vehiculo.getModelo(),
                vehiculo.getMarca(),
                vehiculo.getLinea(),
                vehiculo.getTipoVehiculo()
            };
            modelo.addRow(fila);
        }
        return modelo;
    }

    /**
     * Convierte una lista de objetos PlacaDTO en un DefaultTableModel para
     * mostrar en una tabla.
     *
     * @param listaPlacas La lista de placas a convertir.
     * @return DefaultTableModel con los datos de las placas.
     */
    public DefaultTableModel placasTableModel(List<PlacaDTO> listaPlacas) {
        String[] columnas = {"Código", "Costo", "Fecha Expedición", "Fecha Recepción", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        for (PlacaDTO placa : listaPlacas) {
            Object[] fila = {
                placa.getCodigo(),
                placa.getCosto(),
                dateFormat.format(placa.getFechaExpedicion().getTime()),
                placa.getFechaRecepcion() != null ? dateFormat.format(placa.getFechaRecepcion().getTime()) : "No vencida",
                placa.getEstado()
            };
            modelo.addRow(fila);
        }
        return modelo;
    }

    /**
     * Convierte una lista de objetos LicenciaDTO en un DefaultTableModel para
     * mostrar en una tabla.
     *
     * @param listaLicencias La lista de licencias a convertir.
     * @return DefaultTableModel con los datos de las licencias.
     */
    public DefaultTableModel licenciasTableModel(List<LicenciaDTO> listaLicencias) {
        String[] columnas = {"Costo", "Fecha de Expedición", "Fecha de Vencimiento", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        for (LicenciaDTO licencia : listaLicencias) {
            String estado = licencia.getEstadoActual() == LicenciaDTO.estadoDTO.EXPIRADA ? "Expirada" : "No expirada";
            Object[] fila = {
                licencia.getCosto(),
                dateFormat.format(licencia.getFechaExpedicion().getTime()),
                licencia.getFechaVencimiento() != null ? dateFormat.format(licencia.getFechaVencimiento().getTime()) : "Licencia vigente",
                estado
            };
            modelo.addRow(fila);
        }
        return modelo;
    }

    /**
     * Convierte listas de objetos LicenciaDTO y PlacaDTO en un
     * DefaultTableModel para mostrar en una tabla.
     *
     * @param listaLicencias La lista de licencias a convertir.
     * @param listaPlacas La lista de placas a convertir.
     * @return DefaultTableModel con los datos de las licencias y placas.
     */
    public DefaultTableModel tramitesTableModel(List<LicenciaDTO> listaLicencias, List<PlacaDTO> listaPlacas) {
        String[] columnas = {"Trámite", "Costo", "Fecha de Expedición/Recepción", "Fecha de Vencimiento", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); // Se define el formato de fecha
        for (LicenciaDTO licencia : listaLicencias) {
            String estado = licencia.getEstadoActual() == LicenciaDTO.estadoDTO.EXPIRADA ? "Expirada" : "No expirada";
            Object[] fila = {
                "Licencia",
                licencia.getCosto(),
                dateFormat.format(licencia.getFechaExpedicion().getTime()),
                licencia.getFechaVencimiento() != null ? dateFormat.format(licencia.getFechaVencimiento().getTime()) : "Licencia vigente",
                estado
            };
            modelo.addRow(fila);
        }
        for (PlacaDTO placa : listaPlacas) {
            Object[] fila = {
                "Placa",
                placa.getCosto(),
                dateFormat.format(placa.getFechaExpedicion().getTime()),
                placa.getFechaRecepcion() != null ? dateFormat.format(placa.getFechaRecepcion().getTime()) : "Placa vigente",
                placa.getEstado()
            };
            modelo.addRow(fila);
        }

        return modelo;
    }
}
