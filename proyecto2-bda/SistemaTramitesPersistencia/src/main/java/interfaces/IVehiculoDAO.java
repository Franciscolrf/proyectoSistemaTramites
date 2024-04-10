/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import bda.itson.entidadesJPA.Persona;
import java.util.List;

import bda.itson.entidadesJPA.Vehiculo;
import excepciones.PersistenciaException;

/**
 * Interfaz de la clase VehiculoDAO
 *
 * @author ID145
 */
public interface IVehiculoDAO {

    /**
     * Método que agrega un Vehiculo
     *
     * @param vehiculo Vehiculo a agregar
     * @return Vehiculo si es agregasp
     */
    public Vehiculo agregar(Vehiculo vehiculo);

    /**
     * Método para consultar un Vehiculo por su id.
     *
     * @param id identificador del vehiculo a consultar
     * @return Vehiculo consultado
     */
    public Vehiculo consultar(Long id);

    /**
     * Método para realizar una inserción masiva de Vehiculos.
     *
     * @param vehiculos Lista de vehiculos a insertar
     * @return lista de vehiculos
     * @throws PersistenciaException excepcion si falla algo en la operacion
     */
    public List<Vehiculo> insercionMasivaVehiculo(List<Vehiculo> vehiculos) throws PersistenciaException;

    /**
     * Consulta los vehículos asociados a una persona.
     *
     * @param persona La persona para la cual se desean consultar los vehículos.
     * @return Lista de vehículos asociados a la persona.
     * @throws PersistenciaException Si hay un error durante la consulta.
     */
    public List<Vehiculo> consultarVehiculosPersona(Persona persona) throws PersistenciaException;

    /**
     * Consulta un vehículo por su número de serie.
     *
     * @param numeroSerie El número de serie del vehículo a consultar.
     * @return El vehículo correspondiente al número de serie proporcionado, o
     * null si no se encuentra ningún vehículo con ese número de serie.
     * @throws PersistenciaException Si hay un error durante la consulta.
     */
    public Vehiculo consultarNumeroSeria(String numeroSerie) throws PersistenciaException;
}
