import java.io.IOException;
import java.time.LocalDate;

/*
  
 Llegeix dues dates del teclat i ordena-les, 
 mostra primer la més antiga i després la més moderna.
  
 */


public class E08_Ordena {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		E02_DiasVida leer = new E02_DiasVida();
		
		LocalDate fecha1 = leer.leerFecha("Introduce la primera fecha: ");
		
		LocalDate fecha2 = leer.leerFecha("Introduce la segunda fecha: ");
		
		if(fecha1.isAfter(fecha2)) {
			System.out.println(fecha2);
			System.out.println(fecha1);
		}else {
			System.out.println(fecha1);
			System.out.println(fecha2);
		}
		
	}

}
