import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

/*
  
 Llegeix una data del teclat i una quantitat de dies ( des de 1 fins a 1000 ). 
 Mostra la data resultant si sumen els dies indicats i 
 la data resultant si restem els dies indicats.
  
 */

public class E07_Rango {

	public LocalDate sumaDias(LocalDate fecha, long dias) {
		LocalDate dia = null;
		while (dias >= 1 && dias <=1000) {
			dia =  fecha.plusDays(dias);
		}
		return dia;
	}

	public LocalDate restaDias(LocalDate fecha, long dias) {
		LocalDate dia = null;
		while (dias >= 1 && dias <=1000) {
			dia = fecha.minusDays(dias);
		}
		return dia;
	}

	public static void main(String[] args) throws IOException {
		E02_DiasVida leer = new E02_DiasVida();
		E07_Rango programa = new E07_Rango();
		LocalDate fecha = leer.leerFecha("Introduce una fecha: ");

		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce una cantidad de dias: ");
		long dias = entrada.nextLong();

		System.out.println("Suma: " +programa.sumaDias(fecha, dias));
		System.out.println("Resta: " +programa.restaDias(fecha, dias));
	}
}
