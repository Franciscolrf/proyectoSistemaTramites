/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablas;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author abelc
 */
public class Tabla {
     private String titulo;
    private DefaultTableModel modeloTabla;

    /**
     * Constructor sin parametros
     */
    public Tabla() {
    }

    /**
     * Constructor que inicializa los atributos de la clase
     *
     * @param titulo Titulo de la tabla
     * @param modeloTabla Objeto TableModel con los datos de la tabla.
     */
    public Tabla(String titulo, DefaultTableModel modeloTabla) {
        this.titulo = titulo;
        this.modeloTabla = modeloTabla;
    }
/**
 * Regresa el titulo de la tabla
 * @return titulo
 */
    public String getTitulo() {
        return titulo;
    }
/**
 * Establece el titulo de la tabla
 * @param titulo 
 */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
/**
 * Regresa los datos de la tabla
 * @return modeloTabla
 */
    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }
/**
 * Establece los datos de la tabla
 * @param modeloTabla 
 */
    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }
}


