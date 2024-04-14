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
import java.util.*;

public class Descuento {
	
	public double calculaPrecio(double precio, double dto) {
		double pFinal = precio - (precio * 3 / 100);
		return pFinal;
	}
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		Descuento programa = new Descuento();
		
		System.out.println("Introduce un precio: ");
		double precio = entrada.nextDouble();
		
		System.out.println("Introduce un descuento: ");
		double dto = entrada.nextDouble();
		
		System.out.println(programa.calculaPrecio(precio, dto));
	}

}
