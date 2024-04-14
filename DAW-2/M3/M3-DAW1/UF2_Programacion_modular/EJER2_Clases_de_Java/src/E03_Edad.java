/*
 
Completa el programa implementando los métodos que faltan
 
*/
 
import java.io.*;
import java.time.*;
import java.time.format.*;
import java.time.temporal.ChronoUnit;
 
 
public class E03_Edad {
	
	public long edad (LocalDate fechaNac) {
		LocalDate ahora = LocalDate.now();
		long edad = ChronoUnit.YEARS.between(fechaNac, ahora);
		return edad;
	}
	
	public boolean esMayorEdad (LocalDate fechaNac) {
		long años = edad(fechaNac);
		if(años<18) {
			return false;
		}else {
			return true;
		}
	}
	
    public static void main(String[] args) throws Exception {
         
        E03_Edad programa=new E03_Edad();
        E02_DiasVida leer = new E02_DiasVida(); // Llama al metodo de leerFecha del E02_DiasVida.
         
        LocalDate fechaNac = leer.leerFecha("Entra tu fecha de nacimiento (dd/mm/aaaa) : "); //con validación (poner leer.leerFecha, que coge el del otro ejercicio).
 
        System.out.println( "Edad : " + programa.edad(fechaNac) + " años");
 
        if( programa.esMayorEdad(fechaNac) ){
          System.out.println( "Eres mayor de edad" );
        }else{
          System.out.println( "Eres menor de edad" );
        }
 
    }
 
}