/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablas;

import dtos.PersonaDTO;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author abelc
 */
public class Conversiones {

    public Conversiones() {
    }

  public DefaultTableModel personasTableModel(List<PersonaDTO> listaPersonas) {
    String[] columnas = {"Nombres", "Apellido Paterno", "Apellido Materno", "Teléfono", "RFC", "Discapacidad","Fecha de Nacimiento"};
    DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    for (PersonaDTO persona : listaPersonas) {
        Object[] fila = {
            persona.getNombres(),
            persona.getApellidoPaterno(),
            persona.getApellidoMaterno(),
            persona.getTelefono(),
            persona.getRFC(),
            persona.isEsDiscapacitado(),
            dateFormat.format(persona.getFechaNacimiento().getTime()), // Convertir Calendar a String en formato "dd-MM-yyyy"
        };
        modelo.addRow(fila);
    }

    return modelo;
}
}
