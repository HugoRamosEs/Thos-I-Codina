/*
  
Calcula el precio final de un producto después de aplicar un descuento.
El precio inicial y el tanto por ciento de descuento se leen del teclado.
El precio final debe estar redondeado a los céntimos de euro.
  
Crea un método double calculaPrecio(double precio, double dto)
  
Salida del programa
----------------------------------------
Entra el precio inicial : 123.6
Entra el descuento : 3
El precio final es 119.89
  
*/

import java.util.Scanner;
import java.io.*;

public class E02_Descuento {
	
	double calculaPrecio (double precio, double dto) {
		double precioFinal = 0;
		dto = (precio * dto)/100;
		precioFinal = precio - dto;
		precioFinal = Math.round(100 * precioFinal)/100;
		return precioFinal;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		E02_Descuento programa = new E02_Descuento();
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce un precio: ");
		double precio = entrada.nextDouble();
		
		System.out.println("Introduce un descuento: ");
		double dto = entrada.nextDouble();
		
		System.out.println("Precio final: " +programa.calculaPrecio(precio, dto));
	}

}
