
// Importación de clases y paquetes
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * <p>
 * Programa para...</p>
 *
 * @author profe
 */
public class PruebaIntervaloFechas {

    private static final DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");

    /**
     * Programa principal
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //----------------------------------------------
        //          DeclaraciÃ³n de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        // Variables de salida
        // Variables auxiliares
        // Clase Scanner para peticiÃ³n de datos
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("TRABAJO CON INTERVALOS DE FECHAS");
        System.out.println("--------------------------------");
        System.out.println();

        // Creamos fechas de prueba;
        LocalDate f1 = LocalDate.of(2019, 9, 1);
        LocalDate f2 = LocalDate.of(2019, 10, 1);
        LocalDate f3 = LocalDate.of(2020, 1, 1);
        LocalDate f4 = LocalDate.of(2020, 1, 15);
        LocalDate f5 = LocalDate.of(2020, 2, 15);
        LocalDate[] arrayFechas = {f1, f2, f3, f4, f5};
        IntervaloFechas[] arrayIntervalos = new IntervaloFechas[5];
        IntervaloFechas intervalo = null;

        // Intento de crear intervalos inválidos
        System.out.println("------------------------------------------------------");
        System.out.println("PRUEBAS DE INTENTO DE CREACIÓN DE INTERVALOS INVÁLIDOS");
        System.out.println();

        System.out.printf("Intentando crear intervalo entre %s y %s.\n",
                null, formatoFecha.format(arrayFechas[0]));
        try {
            intervalo = new IntervaloFechas(null, arrayFechas[0]);
            System.out.printf("Correcto. Intervalo creado: %s\n", intervalo);
            System.out.printf("Número de días: %s\n", intervalo.getNumDias());
        } catch (IllegalArgumentException ex) {
            System.out.printf("Error: %s\n", ex.getMessage());
        } finally {
            System.out.println();
        }

        System.out.printf("Intentando crear intervalo entre %s y %s.\n",
                formatoFecha.format(arrayFechas[0]), null);
        try {
            intervalo = new IntervaloFechas(arrayFechas[0], null);
            System.out.printf("Correcto. Intervalo creado: %s\n", intervalo);
            System.out.printf("Número de días: %s\n", intervalo.getNumDias());
        } catch (IllegalArgumentException ex) {
            System.out.printf("Error: %s\n", ex.getMessage());
        } finally {
            System.out.println();
        }

        System.out.printf("Intentando crear intervalo entre %s y %s.\n",
                formatoFecha.format(arrayFechas[1]),
                formatoFecha.format(arrayFechas[0]));
        try {
            intervalo = new IntervaloFechas(arrayFechas[1], arrayFechas[0]);
            System.out.printf("Correcto. Intervalo creado: %s\n", intervalo);
            System.out.printf("Número de días: %s\n", intervalo.getNumDias());
        } catch (IllegalArgumentException ex) {
            System.out.printf("Error: %s\n", ex.getMessage());
        } finally {
            System.out.println();
        }

        // Intento de crear intervalos válidos
        System.out.println("----------------------------------------------------");
        System.out.println("PRUEBAS DE INTENTO DE CREACIÓN DE INTERVALOS VÁLIDOS");
        System.out.println();
        for (int i = 0; i < arrayFechas.length - 1; i++) {
            System.out.printf("Intentando crear intervalo entre %s y %s.\n",
                    formatoFecha.format(arrayFechas[i]),
                    formatoFecha.format(arrayFechas[i + 1]));
            try {
                arrayIntervalos[i] = new IntervaloFechas(arrayFechas[i], arrayFechas[i + 1]);
                System.out.printf("Correcto. Intervalo creado: %s\n", arrayIntervalos[i]);
                System.out.printf("Número de días: %s\n", arrayIntervalos[i].getNumDias());
            } catch (IllegalArgumentException ex) {
                System.out.printf("Error: %s\n", ex.getMessage());
            } finally {
                System.out.println();
            }
        }
        // Creamos un array donde la fecha de inicio y de fin coincidan (debería funcionar)
        LocalDate fechaEjercicio = LocalDate.of(2020, 5, 14);
        System.out.printf("Intentando crear intervalo entre %s y %s.\n",
                formatoFecha.format(fechaEjercicio),
                formatoFecha.format(fechaEjercicio));
        arrayIntervalos[4] = new IntervaloFechas(fechaEjercicio, fechaEjercicio);
        System.out.printf("Correcto. Intervalo creado: %s\n", arrayIntervalos[4]);
        System.out.printf("Número de días: %s\n", arrayIntervalos[4].getNumDias());
        System.out.println();

        // Creación de un intervalo con el constructor sin parámetros
        System.out.println("-------------------------------------------------------");
        System.out.println("CREACIÓN DE INTERVALO CON EL CONSTRUCTOR SIN PARÁMETROS");
        System.out.println();
        System.out.printf("Intentando crear intervalo para este año.\n");
        intervalo = new IntervaloFechas();
        System.out.printf("Correcto. Intervalo aleatorio creado: %s\n", intervalo);
        System.out.printf("Número de días: %s\n", intervalo.getNumDias());
        System.out.println();

        // Intento de crear intervalos aleatorios inválidos
        System.out.println("-----------------------------------------------------------------");
        System.out.println("PRUEBAS DE INTENTO DE CREACIÓN DE INTERVALOS ALEATORIOS INVÁLIDOS");
        System.out.println();
        System.out.printf("Intentando crear intervalo aleatorio entre %s y %s.\n",
                null, formatoFecha.format(arrayFechas[0]));
        try {
            intervalo = IntervaloFechas.random(null, arrayFechas[0]);
            System.out.printf("Correcto. Intervalo aleatorio creado: %s\n", intervalo);
            System.out.printf("Número de días: %s\n", intervalo.getNumDias());
        } catch (IllegalArgumentException ex) {
            System.out.printf("Error: %s\n", ex.getMessage());
        } finally {
            System.out.println();
        }

        System.out.printf("Intentando crear intervalo aleatorio entre %s y %s.\n",
                formatoFecha.format(arrayFechas[0]), null);
        try {
            intervalo = IntervaloFechas.random(arrayFechas[0], null);
            System.out.printf("Correcto. Intervalo aleatorio creado: %s\n", intervalo);
            System.out.printf("Número de días: %s\n", intervalo.getNumDias());
        } catch (IllegalArgumentException ex) {
            System.out.printf("Error: %s\n", ex.getMessage());
        } finally {
            System.out.println();
        }

        System.out.printf("Intentando crear intervalo aleatorio entre %s y %s.\n",
                formatoFecha.format(arrayFechas[1]),
                formatoFecha.format(arrayFechas[0]));
        try {
            intervalo = IntervaloFechas.random(arrayFechas[1], arrayFechas[0]);
            System.out.printf("Correcto. Intervalo aleatorio creado: %s\n", intervalo);
            System.out.printf("Número de días: %s\n", intervalo.getNumDias());
        } catch (IllegalArgumentException ex) {
            System.out.printf("Error: %s\n", ex.getMessage());
        } finally {
            System.out.println();
        }

        // Intento de crear intervalos válidos
        System.out.println("---------------------------------------------------------------");
        System.out.println("PRUEBAS DE INTENTO DE CREACIÓN DE INTERVALOS ALEATORIOS VÁLIDOS");
        System.out.println();
        for (int i = 0; i < arrayFechas.length - 1; i++) {
            System.out.printf("Intentando crear intervalo aleatorio entre %s y %s.\n",
                    formatoFecha.format(arrayFechas[i]),
                    formatoFecha.format(arrayFechas[i + 1]));
            try {
                intervalo = IntervaloFechas.random(arrayFechas[i], arrayFechas[i + 1]);
                System.out.printf("Correcto. Intervalo aleatorio creado: %s\n", intervalo);
                System.out.printf("Número de días: %s\n", intervalo.getNumDias());
            } catch (IllegalArgumentException ex) {
                System.out.printf("Error: %s\n", ex.getMessage());
            } finally {
                System.out.println();
            }
        }
        // Creamos un array donde la fecha de inicio y de fin coincidan (debería funcionar)
        System.out.printf("Intentando crear intervalo aleatorio entre %s y %s.\n",
                formatoFecha.format(fechaEjercicio),
                formatoFecha.format(fechaEjercicio));
        intervalo = IntervaloFechas.random(fechaEjercicio, fechaEjercicio);
        System.out.printf("Correcto. Intervalo aleatorio creado: %s\n", intervalo);
        System.out.printf("Número de días: %s\n", intervalo.getNumDias());
        System.out.println();

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        //System.out.println();
        //System.out.println("PROCESAMIENTO");
        //System.out.println("-------------");

        // Clasificamos las citas por fecha en un map
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("PRUEBAS DE USO DE LOS MÉTODOS");
        System.out.println("-----------------------------");
        System.out.printf("Intervalo: %s\n", arrayIntervalos[0]);
        System.out.printf("Fecha de inicio: %s\n", formatoFecha.format(arrayIntervalos[0].getInicio()));
        System.out.printf("Fecha de fin: %s\n", formatoFecha.format(arrayIntervalos[0].getFin()));
        System.out.printf("Número de días: %s\n", arrayIntervalos[0].getNumDias());
        System.out.println();
        System.out.printf("La fecha %s está dentro del intervalo: %s\n",
                formatoFecha.format(arrayFechas[0].minusDays(1)),
                arrayIntervalos[0].estaDentroDelIntervalo(arrayFechas[0].minusDays(1)));
        System.out.printf("La fecha %s está dentro del intervalo: %s\n",
                formatoFecha.format(arrayFechas[0]),
                arrayIntervalos[0].estaDentroDelIntervalo(arrayFechas[0]));
        System.out.printf("La fecha %s está dentro del intervalo: %s\n",
                formatoFecha.format(arrayFechas[0].plusDays(1)),
                arrayIntervalos[0].estaDentroDelIntervalo(arrayFechas[0].plusDays(1)));
        System.out.printf("La fecha %s está dentro del intervalo: %s\n",
                formatoFecha.format(arrayFechas[1].minusDays(1)),
                arrayIntervalos[0].estaDentroDelIntervalo(arrayFechas[1].minusDays(1)));
        System.out.printf("La fecha %s está dentro del intervalo: %s\n",
                formatoFecha.format(arrayFechas[1]),
                arrayIntervalos[0].estaDentroDelIntervalo(arrayFechas[1]));
        System.out.printf("La fecha %s está dentro del intervalo: %s\n",
                formatoFecha.format(arrayFechas[1].plusDays(1)),
                arrayIntervalos[0].estaDentroDelIntervalo(arrayFechas[1].plusDays(1)));
        System.out.println();

        System.out.printf("La fecha %s está fuera del intervalo: %s\n",
                formatoFecha.format(arrayFechas[0].minusDays(1)),
                arrayIntervalos[0].estaFueraDelIntervalo(arrayFechas[0].minusDays(1)));
        System.out.printf("La fecha %s está fuera del intervalo: %s\n",
                formatoFecha.format(arrayFechas[0]),
                arrayIntervalos[0].estaFueraDelIntervalo(arrayFechas[0]));
        System.out.printf("La fecha %s está fuera del intervalo: %s\n",
                formatoFecha.format(arrayFechas[0].plusDays(1)),
                arrayIntervalos[0].estaFueraDelIntervalo(arrayFechas[0].plusDays(1)));
        System.out.printf("La fecha %s está fuera del intervalo: %s\n",
                formatoFecha.format(arrayFechas[1].minusDays(1)),
                arrayIntervalos[0].estaFueraDelIntervalo(arrayFechas[1].minusDays(1)));
        System.out.printf("La fecha %s está fuera del intervalo: %s\n",
                formatoFecha.format(arrayFechas[1]),
                arrayIntervalos[0].estaFueraDelIntervalo(arrayFechas[1]));
        System.out.printf("La fecha %s está fuera del intervalo: %s\n",
                formatoFecha.format(arrayFechas[1].plusDays(1)),
                arrayIntervalos[0].estaFueraDelIntervalo(arrayFechas[1].plusDays(1)));
        System.out.println();

        System.out.printf("La fecha %s está después del intervalo: %s\n",
                formatoFecha.format(arrayFechas[0].minusDays(1)),
                arrayIntervalos[0].estaDespuesDelIntervalo(arrayFechas[0].minusDays(1)));
        System.out.printf("La fecha %s está después del intervalo: %s\n",
                formatoFecha.format(arrayFechas[0]),
                arrayIntervalos[0].estaDespuesDelIntervalo(arrayFechas[0]));
        System.out.printf("La fecha %s está después del intervalo: %s\n",
                formatoFecha.format(arrayFechas[0].plusDays(1)),
                arrayIntervalos[0].estaDespuesDelIntervalo(arrayFechas[0].plusDays(1)));
        System.out.printf("La fecha %s está después del intervalo: %s\n",
                formatoFecha.format(arrayFechas[1].minusDays(1)),
                arrayIntervalos[0].estaDespuesDelIntervalo(arrayFechas[1].minusDays(1)));
        System.out.printf("La fecha %s está después del intervalo: %s\n",
                formatoFecha.format(arrayFechas[1]),
                arrayIntervalos[0].estaDespuesDelIntervalo(arrayFechas[1]));
        System.out.printf("La fecha %s está después del intervalo: %s\n",
                formatoFecha.format(arrayFechas[1].plusDays(1)),
                arrayIntervalos[0].estaDespuesDelIntervalo(arrayFechas[1].plusDays(1)));
        System.out.println();

        System.out.printf("La fecha %s está antes del intervalo: %s\n",
                formatoFecha.format(arrayFechas[0].minusDays(1)),
                arrayIntervalos[0].estaAntesDelIntervalo(arrayFechas[0].minusDays(1)));
        System.out.printf("La fecha %s está antes del intervalo: %s\n",
                formatoFecha.format(arrayFechas[0].plusDays(1)),
                arrayIntervalos[0].estaAntesDelIntervalo(arrayFechas[0].plusDays(1)));
        System.out.printf("La fecha %s está antes del intervalo: %s\n",
                formatoFecha.format(arrayFechas[1].minusDays(1)),
                arrayIntervalos[0].estaAntesDelIntervalo(arrayFechas[1].minusDays(1)));
        System.out.printf("La fecha %s está antes del intervalo: %s\n",
                formatoFecha.format(arrayFechas[1]),
                arrayIntervalos[0].estaAntesDelIntervalo(arrayFechas[1]));
        System.out.printf("La fecha %s está antes del intervalo: %s\n",
                formatoFecha.format(arrayFechas[1].plusDays(1)),
                arrayIntervalos[0].estaAntesDelIntervalo(arrayFechas[1].plusDays(1)));
        System.out.println();
        System.out.println();

        System.out.printf("Intervalo: %s\n", arrayIntervalos[4]);
        System.out.printf("Fecha de inicio: %s\n", formatoFecha.format(arrayIntervalos[4].getInicio()));
        System.out.printf("Fecha de fin: %s\n", formatoFecha.format(arrayIntervalos[4].getFin()));
        System.out.printf("Número de días: %s\n", arrayIntervalos[4].getNumDias());
        System.out.println();

        System.out.println();
        System.out.println("Fin del programa. Bye!");

    }

}
