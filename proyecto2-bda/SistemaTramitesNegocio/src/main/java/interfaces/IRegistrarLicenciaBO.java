/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import bda.itson.entidadesJPA.Licencia;

import dtos.LicenciaDTO;
import dtos.PersonaDTO;
import java.util.List;

/**
 *
 * @author fabri
 */
public interface IRegistrarLicenciaBO {

    void registrarLicencia(LicenciaDTO licencia);

    List<PersonaDTO> buscarPersonas(String buscarParametro);
    void asignarValoresLicencia(LicenciaDTO licenciaDTO);
}
