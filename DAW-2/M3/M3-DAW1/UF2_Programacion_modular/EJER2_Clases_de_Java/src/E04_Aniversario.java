/*
 
Completa el programa implementando los métodos que faltan
 
*/
 
import java.io.*;
import java.time.*;
import java.time.format.*;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
 
 
public class E04_Aniversario {
	
	public LocalDate proximoCumple (LocalDate fechaNac) {
		LocalDate ahora = LocalDate.now();
		long años = ChronoUnit.YEARS.between(fechaNac, ahora);
		LocalDate cumple = fechaNac.plusYears(años+1);
		return cumple;
	}
	
	public String formatea (LocalDate cumple) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
		String proxCumple = cumple.format(format);
		return proxCumple;
	}
	
	public String diaSemana (LocalDate cumple) {
		String diaSemana = cumple.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("ca","CA"));
		return diaSemana;
	}
 
    public static void main(String[] args) throws Exception {
 
        E04_Aniversario programa=new E04_Aniversario();
        E02_DiasVida leer = new E02_DiasVida();
         
        LocalDate fechaNac = leer.leerFecha("Entra tu fecha de nacimiento (dd/mm/aaaa) : "); //con validación
        LocalDate cumple = programa.proximoCumple(fechaNac);
 
        System.out.println( "Tu próximo cumpleaños será el " + programa.formatea(cumple));
        System.out.println( "El día de la semana será : " + programa.diaSemana(cumple) );
 
    }
 
}
