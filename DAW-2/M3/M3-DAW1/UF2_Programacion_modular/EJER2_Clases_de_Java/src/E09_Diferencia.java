import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class E09_Diferencia {
	
	public long restaDias(LocalDate fecha, LocalDate actual) {
		long dias = ChronoUnit.DAYS.between(fecha, actual);
		dias = Math.abs(dias);
		return dias;
	}
	
	public static void main(String[] args) throws IOException {
		E02_DiasVida leer = new E02_DiasVida();
		E09_Diferencia programa = new E09_Diferencia();
		
		LocalDate fecha = leer.leerFecha("Introduce una fecha: ");
		LocalDate actual = LocalDate.now();
		
		System.out.println("Dias: " +programa.restaDias(fecha, actual));
	}
}
