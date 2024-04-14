import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

class Restriccio{
	 LocalDate data;
	 double hora_inici;
	 double hora_final;
	 double limit_litres;
	 
	 Restriccio(){
		 
	 }
	 
	 Restriccio(String data, double hora_inici, double hora_final, double limit_litres){
	     DateTimeFormatter formato = DateTimeFormatter.ofPattern("d/M/uuuu");
	     LocalDate fecha = LocalDate.parse(data,formato);
		 
		 this.data = fecha;
		 this.hora_inici = hora_inici;
		 this.hora_final = hora_final;
		 this.limit_litres = limit_litres;
	 }
	 
	 /**
	  * El metode calcula la mitjana de llitres totals (limit_litres) entre les hores de funcionament (hora_final - hora_inicial).
	  * 
	  * @return la mitjana dels llitres totals entre les hores d'us.
	  */
	 
	 public double litresHora () {
		 double media = this.limit_litres / (this.hora_final - this.hora_inici);
		 return media;
	 }
	 
	 public String toString() {
		 return "Restricció: "+this.data+" / "+this.hora_inici+" / "+this.hora_final+" / "+this.limit_litres;
	 }
	 
}

public class Practica3 {
	/**
	 * Aquest metode es un metode recursiu que aplica la funció recursiva doble creada per Wilhelm Ackermann.
	 * 
	 * @param m valor minim.
	 * @param n valor maxim.
	 * @return el nombre de memoria utilitzada.
	 */
	public static int ackermann(int m, int n) {
		int num = 0;
		
		if(m==0) {
			num = n+1;
		}
		
		if(m>0 && n==0) {
			num = ackermann(m-1, 1); 
		}
		
		if(m>0 && n>0) {
			num = ackermann(m-1, ackermann(m, n-1));
		}
		
		return num;
	}
	
	/**
	 * El metode calcula l'edat mitjana de edats introduides per l'usuari, comparat amb la data d'avui.
	 * 
	 * @param dates String de dates introduides per l'usuari per calcular la media.
	 * @return l'edat mitjana de totes les edats comparada amb la data d'avui.
	 */
	public long edatPromedi(String [] dates) {
		 long anys = 0;
		 long any = 0;
		 int contador = 0;
		 
		 for (int i=0; i<dates.length; i++) {
			 DateTimeFormatter formato = DateTimeFormatter.ofPattern("d/M/uuuu");
		     LocalDate fecha = LocalDate.parse(dates[i],formato);
		     LocalDate actual = LocalDate.now();
		     
		     any = ChronoUnit.YEARS.between(fecha, actual);
		     anys = anys + any;
		     contador++;
		 }

		 return anys / contador;
	}
	
	/**
	 * El metode, donada un array de frases y una paraula, calcula quantes vegades apareix i a més la canvia a majuscula.
	 * 
	 * @param frases array que conté les frases introduides per l'usuari
	 * @param paraula paraula a modificar, per posar-la en majuscules i contarla.
	 * @return l'array amb la paraula modificada a majuscula i el nombre de vegades que surt.
	 */
	
	public int canvia(String [] frases, String paraula) {
		int contador = 0;
		String majuscula = "";
		
		for (int i=0; i<frases.length; i++) {
			for (int j=0; j<frases[i].length(); j++) {
				if (frases[j].equalsIgnoreCase(paraula)) {
					majuscula = paraula.toUpperCase();
					frases[j] = paraula.replaceAll(paraula, majuscula);
					contador ++;
				}
			}
		}
		return contador;
	}
	
	public static void main(String[] args) {
		Practica3 programa = new Practica3();
		Scanner entrada = new Scanner(System.in);
		
		System.out.printf
		( "+-----------------------------------------------------+\n"
		+ "+                     EJERCICIO 1                     +\n"
		+ "+-----------------------------------------------------+\n");
		
		System.out.println(ackermann(2, 4));
		System.out.println(ackermann(3, 10));
		//System.out.println(ackermann(3, 14));
		
		System.out.printf
		( "+-----------------------------------------------------+\n"
		+ "+                     EJERCICIO 2                     +\n"
		+ "+-----------------------------------------------------+\n");
		
		Restriccio villarriba =new Restriccio("12/05/2023", 10, 16, 125);
		double litres = villarriba.litresHora(); // retorna 21
		System.out.println(litres);
		Restriccio villabajo = new Restriccio("13/05/2023", 0, 10, 0);
		litres = villabajo.litresHora(); // retorna 0
		System.out.println(litres);
		
		System.out.printf
		( "+-----------------------------------------------------+\n"
		+ "+                     EJERCICIO 3                     +\n"
		+ "+-----------------------------------------------------+\n");
		
		String[] dates = {"12/10/2000", "2/03/1998", "6/08/2007", "17/05/2001"};
		
		System.out.println(programa.edatPromedi(dates));
		
		System.out.printf
		( "+-----------------------------------------------------+\n"
		+ "+                     EJERCICIO 4                     +\n"
		+ "+-----------------------------------------------------+\n");
		
		String[] frases = 
				{"El talento gana partidos, pero el trabajo en equipo y la inteligencia gana campeonatos.",
				"A veces cuando se pierde, se GANA.",
				"No se puede ganar una guerra como tampoco se puede ganar un terremoto.",
				"La pérdida de unos, es la ganancia de otros."};
		
		System.out.println("Introduce el String a modificar: ");
		String palabra = entrada.nextLine();
		
		System.out.println(programa.canvia(frases, palabra));

	}

}
