/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package otros;

import java.util.Random;

/**
 *
 * @author abelc
 */
public class Generadores {

    private static final String[] nombres = {"Juan", "María", "Luis", "Ana", "Pedro", "Laura", "Carlos", "Elena", "José", "Sofía"};
    private static final String[] apellidosPaternos = {"González", "Rodríguez", "López", "Martínez", "Pérez"};
    private static final String[] apellidosMaternos = {"Gómez", "Fernández", "Díaz", "Martín", "Ruiz"};
      private Random random;
    public Generadores() {
        Random random = new Random();
    }

    public String generarNombre() {
        String nombre;
        String nombre1 = nombres[random.nextInt(nombres.length)];
        String nombre2 = nombres[random.nextInt(nombres.length)];
        nombre = nombre1 + " " + nombre2;
        return nombre;
    }
    
    public String generarApellidoPaterno(){
    String apPaterno=apellidosPaternos[random.nextInt(nombres.length)];
    return apPaterno;
    }
      public String generarApellidoMaterno(){
    String apMaterno=apellidosMaternos[random.nextInt(nombres.length)];
    return apMaterno;
    }
}
