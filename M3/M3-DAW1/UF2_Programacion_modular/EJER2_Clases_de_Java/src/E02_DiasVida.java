/*
 
Completa el programa implementando los métodos que faltan
 
*/
 
import java.io.*;
import java.time.*;
import java.time.format.*;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
 
public class E02_DiasVida {
	
	public LocalDate leerFecha(String missatge) throws IOException {
		Scanner entrada = new Scanner(System.in);
		// DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy") --> Modifica las fechas que son invalidas, para que sean validas.
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
		
		do {
			try {
				System.out.println(missatge);
				String data = entrada.nextLine();
				LocalDate resData = LocalDate.parse(data, format);
				// entrada.close() --> cierra el teclado para que no salga subrayado en amarillo.
				return resData;
			}catch (Exception e){
				System.out.println("Data invàlida");
			}
		}while(true);
	}
		
		
//		METODO ALTERNATIVO DE LEER FECHA
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		LocalDate fech = null;
//		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		boolean fechaValida = false;
//		
//		while(!fechaValida) {
//			try {
//				System.out.println(missatge);
//				fech = LocalDate.parse(br.readLine(), formato);
//			}catch (Exception e) {
//		            System.out.println("Fecha inválida.");
//		        }
//		}
//		return fech;
	
	
	public long diasVividos(LocalDate dataNaix) throws IOException {
		LocalDate avui = LocalDate.now();
		long dias  = ChronoUnit.DAYS.between(dataNaix, avui); // Por defecto es long, pero para poner en int, hay que ponerlo en el metodo y luego poner (int dias = (int) Chrono...
		return dias;
	}

 
    public static void main(String[] args) throws Exception {
 
        E02_DiasVida programa=new E02_DiasVida();
         
        LocalDate fechaNac = programa.leerFecha("Entra tu fecha de nacimiento (dd/mm/aaaa): "); // con validación
        
        // System.out.println(fechaNac); --> prueba (la classe java_time corrige automaticamente). 
        System.out.println( "Días vividos : " + programa.diasVividos(fechaNac) );
    }
}

