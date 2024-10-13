
package ejemplos2024;
import java.util.Scanner;

/**
 *
 * @author diosdado
 */
public class Prog08 {
    
    
    public static void main(String[] args) {
        
        // Clase Scanner para petición de datos de entrada
        Scanner teclado= new Scanner (System.in);
        
        // Variables de entrada
        int primerNumero, segundoNumero;
        
        // Variables de salida
        int suma, resta, producto, cociente;
        
        
        // Lectura del primer número   
        System.out.print ("Introduzca primer número: ");
        primerNumero = teclado.nextInt();
        
        // Lectura del segundo número   
        System.out.print ("Introduzca segundo número: ");
        segundoNumero = teclado.nextInt();
        
        // Calculamos la suma (procesamiento)
        suma = primerNumero + segundoNumero;
        producto = primerNumero * segundoNumero;
        resta = primerNumero - segundoNumero;
        cociente = primerNumero / segundoNumero;
        
        // Mostramos por pantalla la suma   
        System.out.print ("Suma: ");
        System.out.println ( suma );
        
        System.out.print ("Producto: ");
        System.out.println ( producto );

        System.out.print ("Resta: ");
        System.out.println ( resta );

        System.out.print ("Cociente: ");
        System.out.println ( cociente );
        
        
    }
    
    
    
}
