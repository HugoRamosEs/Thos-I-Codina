import java.util.Scanner;

public class E03_Factura {

	public static void main(String[] args) {
		double importeDescuento;
		double importeIva;
		
		Scanner teclat = new Scanner(System.in);
		System.out.println("Introduce el importe: ");
		double importe = teclat.nextDouble();
		
		importeIva = (importe + (importe*0.21));
		
		if (importeIva>300) {
			importeDescuento = importeIva - (importeIva*0.05);
			System.out.println("El importe (€) con descuento  es de:" +importeDescuento);
		}
		else {
			System.out.println("El importe (€) es de: " +importeIva);
		}

	}

}
