/*

 Programa que calcula el resultado de una operacion aritmética introducida
 por el usuario en forma de cadena, por ejemplo "14 + 23", o "45 * 11".
 Esta cadena debe validarse y en caso de que no sea correcta mostrar un
 mensaje de error.

 Utilizar métodos

 */

import java.io.*;
import java.util.Scanner;

public class E07_Calculadora {
	
	public double calcula(double val1, double val2, char oper) throws Exception {
		double resultado = 0;
		char operador = oper;
		if (operador == '+'){
			resultado = val1 + val2;
		}
		
		if (operador == '-'){
			resultado = val1 - val2;
		}
		
		if (operador == '*'){
			resultado = val1 * val2;
		}
		
		if (operador == '/'){
			resultado = val1 / val2;
		}
		
		if(operador != '+' && operador != '-' && operador != '*' && operador != '/'){
			throw new Exception("Operador incorrecte");
		}
		
		return resultado;
	}
	
	public double evalua(String expresion) throws Exception {
		String partes[]=expresion.split(" ");
		double val1 = Double.parseDouble(partes[0]);
		char operador = partes[1].charAt(0);
		double val2 = Double.parseDouble(partes[2]);
		return calcula(val1,val2, operador);
	}
	
    public static void main(String args[]) {
        
        E07_Calculadora programa=new E07_Calculadora();

        BufferedReader entrada = new BufferedReader(
        new InputStreamReader(System.in));

        while (true){

            try{

                System.out.print("Entra una expresión: ");
                String expresion = entrada.readLine();
                double resultado = programa.evalua(expresion);
                System.out.printf("El resultado es : %.2f\n",resultado);
                return;

            }catch(Exception e){
                System.out.println("ERROR: " + e.getMessage());
            }

        }
    }

}