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
 */
public class Generadores {

    private static final String[] nombresMasculinos = {"Juan", "Luis", "Pedro", "Carlos", "José"};
    private static final String[] nombresFemeninos = {"María", "Ana", "Laura", "Elena", "Sofía"};
    private static final String[] apellidosPaternos = {"González", "Rodríguez", "López", "Martínez", "Pérez"};
    private static final String[] apellidosMaternos = {"Gómez", "Fernández", "Díaz", "Martín", "Ruiz"};
    private Random random;

    public Generadores() {
        this.random = new Random();
    }

    public String generarNombre() {
        String nombre;
        String nombre1;
        String nombre2;
        if (random.nextBoolean()) {
            nombre1 = nombresMasculinos[random.nextInt(nombresMasculinos.length)];
            nombre2 = nombresMasculinos[random.nextInt(nombresMasculinos.length)];
            nombre = nombre1 + " " + nombre2;
        } else {
            nombre1 = nombresFemeninos[random.nextInt(nombresFemeninos.length)];
            nombre2 = nombresFemeninos[random.nextInt(nombresFemeninos.length)];
            nombre = nombre1 + " " + nombre2;
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

    public String generarApellidoPaterno() {
        String apPaterno = apellidosPaternos[random.nextInt(apellidosPaternos.length)];
        return apPaterno;
    }

    public String generarApellidoMaterno() {
        String apMaterno = apellidosMaternos[random.nextInt(apellidosMaternos.length)];
        return apMaterno;
    }

    public String obtenerPrimeraVocal(String apellido) {
        for (int i = 0; i < apellido.length(); i++) {
            char c = apellido.charAt(i);
            if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                return String.valueOf(c);
            }
        }
        return "";
    }

    public Calendar generarFechaAleatoria(int añoInicial, int añoFinal) {
        Random random = new Random();

        int año = añoInicial + random.nextInt(añoFinal - añoInicial + 1);
        int mes = random.nextInt(12) + 1; // Se agrega 1 ya que los meses en java.time.Month van de 1 a 12
        int dia = random.nextInt(Month.of(mes).length(true)) + 1;

        LocalDate fechaLocal = LocalDate.of(año, mes, dia);

        int añoCalendar = fechaLocal.getYear();
        int mesCalendar = fechaLocal.getMonthValue();
        int diaCalendar = fechaLocal.getDayOfMonth();

        return new GregorianCalendar(añoCalendar, mesCalendar - 1, diaCalendar);
    }

    public String generarNumeroTelefono() {
        Random random = new Random();
        String lada = String.format("%03d", random.nextInt(1000));
        String bloque1 = String.format("%03d", random.nextInt(1000));
        String bloque2 = String.format("%04d", random.nextInt(10000));
        return lada + bloque1 + bloque2;
    }

    public Boolean generarBooleanoAleatorio() {
        Random random = new Random();
        int opcion = random.nextInt(2);

        if (opcion == 0) {
            return false;
        } else {
            return true;
        }
    }
}
