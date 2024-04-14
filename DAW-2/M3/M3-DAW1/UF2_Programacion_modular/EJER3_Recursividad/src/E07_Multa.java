/*
Donada la següent definició recursiva, crea un mètode amb identificador 
multa que realitzi el mateix càlcul. 
 
Definició recursiva de multa(capital, any), 
retorna la quantitat de multa que l’agència tributaria calcula segons 
el capital i l'any d'inici de l'activitat evasora.
  
multa(capital, any):
   si any < 2011  retorna multa(capital, 2011)
   si any > 2015 retorna 0
   si capital < 0 retorna 1000;
   en altre cas retorna multa(capital, any+1)+capital/100
  
Exemple:
capital: 299999  any:2013  retorna 8999.97 
 
*/
import java.util.Scanner;

public class E07_Multa {
	
	public static double multa(double capital, double any) {
		if(any<2011) {
			return multa(capital,any);
		}
		
		else if(any>2015){
			return 0;
		}
		
		else if(capital < 0) {
			return 1000;
		}
		
		else {
			return multa(capital, any+1)+capital/100;
		}
	}
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce el capital: ");
		int capital = entrada.nextInt();
		
		System.out.println("Introduce el año: ");
		int any = entrada.nextInt();
		
		double resultat = multa(capital, any);
		
		System.out.println("Resultat: " +resultat);
	}

}
