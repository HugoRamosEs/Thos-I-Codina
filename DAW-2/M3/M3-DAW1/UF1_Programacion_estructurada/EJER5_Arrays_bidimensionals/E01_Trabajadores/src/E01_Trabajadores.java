import java.util.Scanner;

public class E01_Trabajadores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 
		Crea un array de dos dimensiones para guardar las horas trabajadas por 3 trabajadores
		durante los 5 días laborables de una semana. Estos datos se entran por teclado.
		Posteriormente, el programa debe mostra la tabla por pantalla y calcular :
		- el sueldo de cada trabajador teniendo en cuenta que la hora se paga a 20 euros
		- la suma de todos los sueldos
		 
		 
		Salida del programa
		---------------------------
		Entra las horas del trabajador 1
		Dia 1 : 5
		Dia 2 : 7
		Dia 3 : 6
		Dia 4 : 8
		Dia 5 : 8
		Entra las horas del trabajador 2
		Dia 1 : 7
		Dia 2 : 6
		Dia 3 : 6
		Dia 4 : 7
		Dia 5 : 7
		Entra las horas del trabajador 3
		Dia 1 : 8
		Dia 2 : 8
		Dia 3 : 8
		Dia 4 : 7
		Dia 5 : 8
		 
		               Lunes   Martes  Mierc.  Jueves  Viernes Sueldo
		Trabajador 1       5       7       6       8       8    680
		Trabajador 2       7       6       6       7       7    660
		Trabajador 3       8       8       8       7       8    780
		 
		El sueldo total es 2120
		 
		 
		 */
		
		int trabajadores = 3;
        int dias = 5;
        int precioHora = 20;
        int dia = 0;
        int sueldo = 0;
        int sueldoTotal = 0;
        int numT = 0;
        
        int horas[][] = new int [trabajadores][dias];
        
        Scanner entrada = new Scanner(System.in);
        
        for (int i=0; i<trabajadores; i++) {
        	numT= i+1;
        	System.out.println("Introduce las horas para el trabajador " +numT+ ":");
        	dia = 0;
        		for (int j=0; j<dias; j++) {
        			dia++;
        			System.out.printf("Dia %d: ", dia);
        			horas[i][j] = entrada.nextInt();
        	}
        }
        System.out.println("-----------------------------------------------------------------");
        System.out.println("               Lunes   Martes  Mierc.  Jueves  Viernes Sueldo");
    	for (int i=0; i<trabajadores; i++) {
    		numT = 0;
    		numT= i+1;
    		System.out.print("Trabajador " + numT);
    		sueldo = 0;
    		for (int j=0; j<dias; j++) {
    			sueldo = sueldo + (20*horas[i][j]); 
    			System.out.printf("%8d",horas[i][j]);
    		}
    		System.out.println("     " + sueldo);
    		sueldoTotal = sueldo + sueldoTotal;
    		
    	}
    	System.out.println("-----------------------------------------------------------------");
    	System.out.println("El sueldo total es: " +sueldoTotal);
	}	
}
