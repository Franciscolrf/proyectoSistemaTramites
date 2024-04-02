/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import dtos.PersonaDTO;
import dtos.PlacaDTO;
import dtos.VehiculoDTO;
import java.util.List;

/**
 *
 * @author abelc
 */
public interface IRegistrarPlaca {
   void registrarPLaca(PlacaDTO placaDTO); 
   List<VehiculoDTO> obtenerVehiculosDePersona(PersonaDTO persona);
   void generarPlaca(PlacaDTO placaDTO);
   VehiculoDTO buscarPorNumeroSerie(String numeroSerie);
}
