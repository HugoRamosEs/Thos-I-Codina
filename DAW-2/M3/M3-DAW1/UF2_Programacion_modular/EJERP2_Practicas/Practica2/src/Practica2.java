import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Practica2 {
	/**
	 * Recibe un string con una fecha, la formatea y la verifica.
	 * 
	 * @param mensaje string que se introduce como mensaje, incluye la fecha
	 * @return retorna la fecha verificada, con el formato deseado
	 */
	public LocalDate leerFecha(String mensaje) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			try {
				System.out.print(mensaje);
				String dato = entrada.readLine();
				LocalDate fecha = LocalDate.parse(dato, formatter);
				return fecha;

			} catch (Exception e) {
				System.out.println("Fecha incorrecta");
			}
		}
	}

	/**
	 * Muestra si un producto en el que se introduce su fecha de compra y años de garantia sigue en garantia o no.
	 * 
	 * @param fecha la fecha verificada con el formato deseado, la fecha de compra.
	 * @param anyosGarantia son los años de garantia asignados al producto.
	 * @return retorna si el producto sigue en garantia o no.
	 */
	public boolean teGarantia(LocalDate fecha, long anyosGarantia) {
		LocalDate fechaActual = LocalDate.now();
		long añosPasados = ChronoUnit.YEARS.between(fecha, fechaActual);

		if (añosPasados < anyosGarantia) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Censura palabras malsonantes o delicadas de una frase. Estas son censuradas con asteriscos.
	 * 
	 * @param frase la frase que se introduce para ser verficidada.
	 * @param paraules son las palabras que se deben censurar.
	 * @return retorna un la frase modificada, donde tapa las palabras que se deben censurar por asteriscos.
	 */

	public static String controlLlenguatge(String frase, String[] paraules) {
		String resultat = "";
		String fraseSplit[] = frase.split(" ");
		for (int i = 0; i < fraseSplit.length; i++) {
			for (int j = 0; j < paraules.length; j++) {
				if (paraules[j].equals(fraseSplit[i])) {
					resultat = frase.replace(paraules[j], "*");
				}
			}
		}
		return resultat;
	}
	
//	public static String adress(StringBuilder sb) {
//        int pos = sb.lastIndexOf("@");
//        return sb.substring(pos+1);
//    } 
	
	/**
	 * El metodo debe detectar las palabras que incluyen @ para determinar que es un email. De mostrar un contador de las palabras y cambiar estos
	 * emails a minusculas y eliminar su dominio.
	 * 
	 * @param sb se trata de un StringBuilder que incluye una frase con emails.
	 * @return retorna el StringBuilder que incluye la frase con los emails modificados y un contador.
	 */
	public int canviEmails(StringBuilder sb) {
		int contador = 0;
		String sub = "@";
		
		int pos = sb.indexOf(sub);
		while ( pos >= 0 ){
            contador++;
            pos = sb.indexOf(sub,pos+1);
        }
		
		return contador;
		
//		String resultado="";
//		String frase = adress(sb);
//		int posicion = sb.lastIndexOf("@");
//		if(posicion<0) {
//			resultado = frase;
//		}else {
//			resultado = frase.substring(0,posicion);
//		}
//		String completo = "Contador: " +contador+ " / Frase: " +resultado;
//		
//        return completo;
    }
	
	/**
	 * Determina si la cadena de numeros es ascendente o no.
	 * 
	 * @param historic es un array de doubles que contiene los numeros a comparar.
	 * @return retorna si se cumple la cadena ascendente, es decir, si es ascendente un true y sino un false.
	 */
	public static boolean preusAugmenten(double[] historic) {
		for (int i = 0; i < historic.length; i++) {
			if (historic[i] < historic[i + 1]) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Practica2 programa = new Practica2();
		Scanner entrada = new Scanner(System.in);

		System.out.printf
		( "+-----------------------------------------------------+\n"
		+ "+                     EJERCICIO 1                     +\n"
		+ "+-----------------------------------------------------+\n");
		
		LocalDate fecha = programa.leerFecha("Introduce una fecha: ");
		programa.teGarantia(fecha, 0);
		DateTimeFormatter fmtFecha = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		
		System.out.println("Introduce los años de garantia: ");
		long anyos = entrada.nextLong();
		
		System.out.println("Fecha comprada " +fecha.format(fmtFecha)+ " años garantia " +anyos+ " --> " +programa.teGarantia(fecha, anyos));
		
		System.out.printf
		( "+-----------------------------------------------------+\n"
		+ "+                     EJERCICIO 2                     +\n"
		+ "+-----------------------------------------------------+\n");
		
		String frase = "Almenys 6 morts i 81 ferits en un atemptat amb bomba al centre d'Istanbul";
		String[] paraules = {"crisi", "atemptat", "bomba", "mort", "Trump"};
		
		System.out.println(controlLlenguatge(frase, paraules));
		
		System.out.printf
		( "+-----------------------------------------------------+\n"
		+ "+                     EJERCICIO 3                     +\n"
		+ "+-----------------------------------------------------+\n");
		
		String texto="S’ha d’enviar el missatge ALERTA a COLOMBO@gmail.com o a TENIENTE.colombo@gmail.COM";
		StringBuilder sb = new StringBuilder(texto);
		
		System.out.println("Contador: " +programa.canviEmails(sb));

		System.out.printf
		( "+-----------------------------------------------------+\n"
		+ "+                     EJERCICIO 4                     +\n"
		+ "+-----------------------------------------------------+\n");

		double[] historic = {45.7, 48.9, 48.9, 50.25, 55.32, 55.33, 55.67, 57.0};
		System.out.println(preusAugmenten(historic));

	}

}
