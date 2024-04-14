import java.util.Scanner;

class fraccion{
	int numerador;
	int denominador;
	
	fraccion( ){
		
	}
	
	fraccion(int n, int d){
		numerador = n;
		denominador = d;
	}
	
	fraccion(String data){
		String[] parts = data.split("/");
		numerador = Integer.parseInt(parts[0]);
		denominador = Integer.parseInt(parts[1]);
	}
	
	public String toString() {
		return (numerador+"/"+denominador);
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
	
}

public class E03_SimplificaFraccion_metodos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 
		Programa que define la clase Fraccion con campos para el numerador y el denominador.
		Primero crea un objeto Fraccion con el valor de sus campos entrados por teclado.
		 
		Luego simplifica la fracción dividiendo cada campo por el mcd de ambos y
		muestra el resultado final.
		 
		Ayuda:
		------
		Si tenemos una cadena en la forma "3/4" y queremos dividirla en
		trozos utilizando un carácter como separador se puede utilizar el
		método split de esta forma:
		 
		String s = "3/4";
		String[] partes = s.split("/"); //en este caso la barra hace de separador
		 
		El array 'partes' contendrá las dos cadenas separadas
		 
		 
		Salida del programa:
		------------------------------
		Entra la fracción : 6/10
		 
		La fracción simplificada es 3/5
		 
		Crea métodos en la class Fraccion para resolver los càlculos
		 
		 */
		
	    Scanner entrada = new Scanner (System.in);
	    System.out.println("Introduce la fraccion: ");
	    fraccion frac = new fraccion(entrada.nextLine());
		
	    frac.simplificaFraccion();
	       
	    System.out.println("La fraccion simplificada es " + frac);
	}

}
