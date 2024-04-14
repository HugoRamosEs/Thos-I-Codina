
import java.util.Scanner;

class fraccion{
	int numerador;
	int denominador;
	
	fraccion(){
		
	}
	
	fraccion(int n, int d){
		numerador = n;
		denominador = d;
	}
	
	fraccion (String frac){
		String partes[]=frac.split("/");
		numerador = Integer.parseInt(partes[0]);
		denominador = Integer.parseInt(partes[1]);
	}
	
	fraccion Suma(fraccion fraccion2) {
		fraccion result = new fraccion();
		result.denominador = denominador*fraccion2.denominador;
		result.numerador = numerador*fraccion2.denominador + denominador*fraccion2.numerador;
		return result;
	}
	
	void simplificaFraccion () {
		int a = numerador;
		int b = denominador;
		
	      while(b>0){
	          
	           if(a>b){
	               a = a - b;
	           }
	           else{
	               b = b - a;
	           }
	       }
	      
	      numerador = numerador / a;
	      denominador = denominador / a;
	}
	
	public String toString() {
		return (numerador+"/"+denominador);
	}

public class E04_SumaFracciones_metodos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 
		Programa que suma dos objetos de tipo Fraccion.
		Los datos necesarios se entran por teclado.
		El resultado debe ser otro objeto de tipo Fraccion.
		Primero se calcula y luego se muestra.
		 
		Ayuda para sumar fracciones:
		-------------------------------------
		 
		num1   num2  num1*den2 + den1*num2
		---- + --- = ---------------------
		den1   den2        den1*den2
		 
		Posteriormente simplificar dividiendo por el mcd
		 
		 
		Salida del programa:
		------------------------------
		Entra la fraccion 1 : 3/4
		Entra la fraccion 2 : 5/6
		La fraccion suma es 19/12
		 
		Crea métodos en la class Fraccion para resolver los càlculos
		 
		 */
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce la primera fraccion: ");
		fraccion frac = new fraccion(entrada.nextLine());
		
		System.out.println("Introduce la segunda fraccion: ");
		fraccion frac2 = new fraccion(entrada.nextLine());
		
		fraccion fracResult = frac.Suma(frac2);
		fracResult.simplificaFraccion();
		System.out.println("Resultado: " + fracResult);

		
		}
	}
}
