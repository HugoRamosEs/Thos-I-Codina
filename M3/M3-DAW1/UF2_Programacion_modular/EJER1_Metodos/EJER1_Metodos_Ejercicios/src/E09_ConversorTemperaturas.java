import java.util.Scanner;

public class E09_ConversorTemperaturas {
	
	public int menu() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Variables del problema:\n"
				+ "-----------------------\n"
				+ "1.Fahrenheit a Celsius\n"
				+ "2.Celsius a Fahrenheit\n"
				+ "3.Salir\n"
				+ "Elige: ");
		int opcion = entrada.nextInt();
		return opcion;
	}
	
	public double farCel(double num) {
		double celConver = 0;
		celConver = ((num * 9)/5) + 32;
		return celConver;
	}
	
	public double celFar(double num) {
		double farConver = 0;
		farConver = ((num - 32)*5) / 9;
		return farConver;
	}
	
	public double validarEntrada(Scanner numero) {
		while(!numero.hasNextDouble()) {
			System.out.println("Entrada no numerica, intentalo de nuevo: ");
			numero.next();
		}
		return numero.nextDouble();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		E09_ConversorTemperaturas programa = new E09_ConversorTemperaturas();
    	int opcion;
    	
    	Scanner entrada = new Scanner(System.in);
    	
    	do {
    		opcion = programa.menu();
    		
    		if (opcion==1) {
    			System.out.println("Entra los grados Celcius: ");
    			double numero = programa.validarEntrada(entrada);
    			System.out.println("Los grados farenheith: " +programa.farCel(numero));
    		}
    		
    		if (opcion==2) {
    			System.out.println("Entra los farenheith: ");
    			double numero = programa.validarEntrada(entrada);;
    			System.out.println("Los grados Celcius: " +programa.celFar(numero));
    		}
    		
    		if(opcion==3) {
    			System.out.println("Programa finalizado");
    		}
    		
    	} while (opcion!=3);
    	
	}
}
