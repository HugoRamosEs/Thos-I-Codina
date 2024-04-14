import java.util.Scanner;

public class AR413_ClarasOscuras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int ancho = 0;
		int longitud = 0;
		
		int losasBlancas=0;
		int losasNegras=0;
		int total;
		
		Scanner entrada = new Scanner(System.in);
		System.err.println("Indica el número de casos: ");
		int casos = entrada.nextInt();
		
		for (int i=0; i<casos; i++) {
			System.err.println("Indica el ancho y la longitud: ");
			ancho = entrada.nextInt();
			longitud = entrada.nextInt();
			
			total = ancho * longitud;
			
			if (total%2==0) {
				losasNegras = total / 2;
				losasBlancas = total / 2;
			}
			
			else if (total%2!=0) {
				losasNegras = total / 2;
				losasBlancas = losasNegras + 1;
			}
			
			System.out.println(+losasBlancas+ " " +losasNegras);
		}
	}
}
