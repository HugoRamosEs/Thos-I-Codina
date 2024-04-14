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

public class E02_Descuento {

	double calculaPrecio(double precio, double dto) {
		double pf=0;
		pf = precio - ((precio*dto)/100);
		pf = pf*100;
		pf = Math.round(pf);
		pf = pf/100;
		return pf;
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		E02_Descuento programa=new E02_Descuento();
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Precio inicial: ");
		double pi = entrada.nextDouble();	
		
		System.out.println("Descuento (%): ");
		double desc = entrada.nextDouble();
		
		double pf = programa.calculaPrecio(pi,desc);
		System.out.println(+pf);
	}

}
