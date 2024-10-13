
package ejemplos2024;
import java.util.Scanner;

/**
 *
 * @author diosdado
 */
public class Prog07 {
    
    
    public static void main(String[] args) {
        
        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        // Variables de entrada
        int primerNumero, segundoNumero;
        
        // Variables de salida
        int suma;
        
        
        // Lectura del primer número   
        System.out.print ("Introduzca primer número: ");
        primerNumero = teclado.nextInt();
        
        // Lectura del segundo número   
        System.out.print ("Introduzca segundo número: ");
        segundoNumero = teclado.nextInt();
        
        // Calculamos la suma (procesamiento)
        suma = primerNumero + segundoNumero;
        
        // Mostramos por pantalla la suma   
        System.out.print ("Suma: ");
        System.out.println ( suma );
        
        
        
    }
    
    
    
}
