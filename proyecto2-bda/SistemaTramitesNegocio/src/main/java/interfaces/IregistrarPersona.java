/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import dtos.PersonaDTO;
import java.util.List;

/**
 *
 * @author abelc
 */
public interface IregistrarPersona {
    public boolean registroMasivo(List<PersonaDTO> personas);
    public List<PersonaDTO> generarlista(int cantidad);
    
}
