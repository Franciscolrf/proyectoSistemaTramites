/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import bda.itson.entidadesJPA.Licencia;
import bda.itson.entidadesJPA.Persona;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author fabri
 */
public interface ILicencia {

    public boolean registrarLicencia(Licencia licencia) throws PersistenciaException;

   public List<Persona> buscarPersonas(String buscarParametro) throws PersistenciaException;
}
