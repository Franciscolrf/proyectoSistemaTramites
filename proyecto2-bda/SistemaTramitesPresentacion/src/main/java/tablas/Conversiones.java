/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablas;

import dtos.LicenciaDTO;
import dtos.PersonaDTO;
import dtos.PlacaDTO;
import dtos.VehiculoDTO;
import interfaces.IRegistrarLicenciaBO;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import negocio.RegistrarLicencia;

/**
 *
 * @author abelc
 */
public class Conversiones {

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public Conversiones() {

    }

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

    public DefaultTableModel personasModuloPlacasTableModel(List<PersonaDTO> listaPersonas) {
        IRegistrarLicenciaBO licencia = new RegistrarLicencia();
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
                licenciaActiva = (licencia.personaTieneLicenciaActiva(persona)) ? "Si" : "No"
            };
            modelo.addRow(fila);
        }

        return modelo;
    }

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
