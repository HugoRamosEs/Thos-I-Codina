import java.util.Scanner;

public class E02_BuscaPalabra {

	public static void main(String[] args) {
		boolean encontrada = false;
		
		String palabras[] = {"mesa", "camion", "palabra", "escandalo", "raton"};
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce una palabra: ");
		String palabra = entrada.next();
		
		for (int i=0; i<palabras.length; i++) {
			String recuento = palabras[i];
			if (recuento.equals(palabra)) {
				encontrada=true;
				System.out.println("Has acertado");
			}
		}
		if(!encontrada) {
			System.out.println("Has fallado");
		}
	}
}
