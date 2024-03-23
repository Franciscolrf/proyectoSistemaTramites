/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package otros;

import java.util.Random;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 *
 * @author abelc
 * Clase que proporciona métodos para generar datos aleatorios relacionados con personas.
 */
public class GeneradorNombres {

    // Listas de nombres masculinos y femeninos
    private static final String[] nombresMasculinos = {"Juan", "Luis", "Pedro", "Carlos", "José"};
    private static final String[] nombresFemeninos = {"María", "Ana", "Laura", "Elena", "Sofía"};

    // Listas de apellidos paternos y maternos
    private static final String[] apellidosPaternos = {"González", "Rodríguez", "López", "Martínez", "Pérez"};
    private static final String[] apellidosMaternos = {"Gómez", "Fernández", "Díaz", "Martín", "Ruiz"};

    private Random random;

    /**
     * Constructor de la clase Generadores.
     */
    public GeneradorNombres() {
        this.random = new Random();
    }

    /**
     * Genera un nombre completo concatenando un nombre masculino y uno femenino.
     * @return Un nombre completo generado aleatoriamente.
     */
    public String generarNombre() {
        String nombre;
        String nombre1;
        String nombre2;
        
        // Se elige aleatoriamente si se usará un nombre masculino o femenino
        if (random.nextBoolean()) {
            nombre1 = nombresMasculinos[random.nextInt(nombresMasculinos.length)];
            nombre2 = nombresMasculinos[random.nextInt(nombresMasculinos.length)];
        } else {
            nombre1 = nombresFemeninos[random.nextInt(nombresFemeninos.length)];
            nombre2 = nombresFemeninos[random.nextInt(nombresFemeninos.length)];
        }

        while (nombre1.equals(nombre2)) {
            if (random.nextBoolean()) {
                nombre2 = nombresMasculinos[random.nextInt(nombresMasculinos.length)];
            } else {
                nombre2 = nombresFemeninos[random.nextInt(nombresFemeninos.length)];
            }
        }

        nombre = nombre1 + " " + nombre2;
        return nombre;
    }

    /**
     * Genera un apellido paterno aleatorio.
     * @return Un apellido paterno generado aleatoriamente.
     */
    public String generarApellidoPaterno() {
        String apPaterno = apellidosPaternos[random.nextInt(apellidosPaternos.length)];
        return apPaterno;
    }

    /**
     * Genera un apellido materno aleatorio.
     * @return Un apellido materno generado aleatoriamente.
     */
    public String generarApellidoMaterno() {
        String apMaterno = apellidosMaternos[random.nextInt(apellidosMaternos.length)];
        return apMaterno;
    }

    /**
     * Retorna la primera vocal encontrada en un apellido dado.
     * @param apellido El apellido del cual se desea obtener la primera vocal.
     * @return La primera vocal encontrada en el apellido.
     */
    public String obtenerPrimeraVocal(String apellido) {
        for (int i = 0; i < apellido.length(); i++) {
            char c = apellido.charAt(i);
            if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                return String.valueOf(c);
            }
        }
        return "";
    }

    /**
     * Genera una fecha de nacimiento aleatoria dentro de un rango de años especificado.
     * @param añoInicial El año inicial del rango.
     * @param añoFinal El año final del rango.
     * @return Un objeto Calendar que representa una fecha de nacimiento generada aleatoriamente.
     */
    public Calendar generarFechaAleatoria(int añoInicial, int añoFinal) {
        int año = añoInicial + random.nextInt(añoFinal - añoInicial + 1);
        int mes = random.nextInt(12) + 1; 
        int dia = random.nextInt(Month.of(mes).length(true)) + 1;

        LocalDate fechaLocal = LocalDate.of(año, mes, dia);
        int añoCalendar = fechaLocal.getYear();
        int mesCalendar = fechaLocal.getMonthValue();
        int diaCalendar = fechaLocal.getDayOfMonth();

        return new GregorianCalendar(añoCalendar, mesCalendar - 1, diaCalendar);
    }

    /**
     * Genera un número de teléfono aleatorio.
     * @return Un número de teléfono generado aleatoriamente.
     */
    public String generarNumeroTelefono() {
        // Se generan tres bloques de números aleatorios y se concatenan
        String lada = String.format("%03d", random.nextInt(1000));
        String bloque1 = String.format("%03d", random.nextInt(1000));
        String bloque2 = String.format("%04d", random.nextInt(10000));
        return lada + bloque1 + bloque2;
    }

    /**
     * Genera un valor booleano aleatorio.
     * @return Un valor booleano generado aleatoriamente.
     */
    public Boolean generarBooleanoAleatorio() {
    
        return random.nextInt(2) == 1;
    }
}