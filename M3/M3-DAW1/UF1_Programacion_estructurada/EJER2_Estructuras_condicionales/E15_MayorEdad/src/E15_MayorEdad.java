import java.io.*;
 
public class E15_MayorEdad {
 
    public static void main(String[] args) throws Exception {
 
    	boolean mayor;
    	
        BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in));
 
        System.out.println("Entra la fecha actual");
        System.out.print("Dia : ");
        int dia_actual = Integer.parseInt(entrada.readLine());
        System.out.print("Mes : ");
        int mes_actual = Integer.parseInt(entrada.readLine());
        System.out.print("Año : ");
        int año_actual = Integer.parseInt(entrada.readLine());
 
        System.out.println("Entra la fecha de nacimiento");
        System.out.print("Dia : ");
        int dia_nacimiento = Integer.parseInt(entrada.readLine());
        System.out.print("Mes : ");
        int mes_nacimiento = Integer.parseInt(entrada.readLine());
        System.out.print("Año : ");
        int año_nacimiento = Integer.parseInt(entrada.readLine());
        
        int año_definitivo = año_actual - año_nacimiento;
 
        if (año_definitivo>18) {
        	System.out.println("Eres mayor de edad");
        }
        
        if (año_definitivo<18) {
        	System.out.println("Eres menor de edad");
    	}
    
    	if(año_definitivo == 18) {
    		if(mes_nacimiento >= mes_actual) {
    			System.out.println("Eres mayor de edad");
    		}
    		if(mes_nacimiento < mes_actual) {
    			System.out.println("Eres menor de edad");
    		}
    		if(mes_nacimiento == mes_actual) {
    			if(dia_nacimiento >= dia_actual) {
        			System.out.println("Eres mayor de edad");
        		}
        		if(dia_nacimiento < dia_actual) {
        			System.out.println("Eres menor de edad");
        		}
    		}
    		
    	}
	}
}