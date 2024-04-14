import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/* 
 
Llegeix una data del teclat en format dd/mm/aaaa i 
mostra-la en format aaaa/mm/dd
  
*/
public class E05_CambioFormato {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		E02_DiasVida leer = new E02_DiasVida();
		
		LocalDate fechaNac = leer.leerFecha("Introduce una fecha (dd/mm/aaaa): ");
		
		System.out.println( "La fecha es " + fechaNac.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
	}

}
