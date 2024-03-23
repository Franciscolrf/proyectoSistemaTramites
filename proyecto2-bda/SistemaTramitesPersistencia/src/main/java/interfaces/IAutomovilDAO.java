/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import bda.itson.entidadesJPA.Automovil;

/**
 * Interfaz de la clase AutomovilDAO
 * @author ID145
 */
public interface IAutomovilDAO {
    
    /**
     * Método que agrega un automovil
     * @param automovil
     * @return
     */
    public Automovil agregar (Automovil automovil);

    /**
     * Método para consultar una automovil por su id.
     * @param idAutomovil
     * @return
     */
    public Automovil consultar(Long idAutomovil);
}
