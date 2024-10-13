
package ejemplos2024;
import java.util.Scanner;


/**
 *
 * @author diosdado
 */
public class Prog06 {
    
    
    public static void main(String[] args) {
        
        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        // Variables de entrada
        int primerNumero, segundoNumero;
        
        
        
        
        // Lectura del primer número   
        System.out.print ("Introduzca primer número: ");
        primerNumero = teclado.nextInt();
        
        // Lectura del segundo número   
        System.out.print ("Introduzca segundo número: ");
        segundoNumero = teclado.nextInt();
        
        // Calculamos y mostramos por pantalla la suma   
        System.out.print ("Suma: ");
        System.out.println ( primerNumero + segundoNumero );
    }   
    
    
    
}
