/*
 
 Programa que calcula el resultado de una operacion aritmética introducida
 por el usuario en forma de cadena, por ejemplo "14 + 23", o "45 * 11".
 Esta cadena debe validarse y en caso de que no sea correcta mostrar un
 mensaje de error.
 
 Utilizar métodos
 
 */

import java.io.*;

public class E07_Calculadora {
	
    boolean todoDigitos(String operando) {
        for (int i=0; i<operando.length(); i++) {
            if (operando.charAt(i)<'0' || operando.charAt(i)>'9') return false;
        }
        return true;
    }
    
    void error(String mensaje) throws Exception {
        throw new Exception(mensaje);
    }
    
    public double calcular(char operador,double a, double b) throws Exception{
    	 
        double result=0;
        switch(operador){
            case '+': result = a + b; break;
            case '-': result = a - b; break;
            case '*': result = a * b; break;
            case '/': 
                if (b==0) error("División por cero.");
                else result = a / b; 
                break;
            default: error("Operador desconocido.");
        }
        return result;
    }
	
	public double evalua(String expresion) throws Exception{
        String[] partes = expresion.split(" ");
        if (partes.length!=3) error("Faltan parámetros.");
        if (!todoDigitos(partes[0]) || !todoDigitos(partes[2])) error("Operandos incorrectos.");
        if (partes[1].length()!=1) error("Operador desconocido.");
        char op = partes[1].charAt(0);
        double a = Double.parseDouble(partes[0]);
        double b = Double.parseDouble(partes[2]);
        //llamar a calcular
        return calcular(op, a, b);
	}
	
    public static void main(String args[]) {
        
        E07_Calculadora programa=new E07_Calculadora();
 
        BufferedReader entrada = new BufferedReader(
        new InputStreamReader(System.in));
 
        while (true){
            try{
                System.out.print("Entra una expresión : ");
                String expresion = entrada.readLine();
                double resultado = programa.evalua(expresion);
                System.out.printf("El resultado es : %.2f\n",resultado);
                return;
 
            }catch(Exception e){
                System.out.println("ERROR : " + e.getMessage());
            }
        }
    }
}
