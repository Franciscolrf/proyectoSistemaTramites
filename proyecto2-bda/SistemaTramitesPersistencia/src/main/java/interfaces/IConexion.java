/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import javax.persistence.EntityManager;

/**
 *
 * @author abelc
 */
public interface IConexion {

    /**
     * Obtiene una instancia de EntityManager para interactuar con la base de datos.
     *
     * @return La instancia de EntityManager.
     */
    EntityManager getEntityManager();

    /**
     * Cierra la conexión.
     */
    void close();
}
