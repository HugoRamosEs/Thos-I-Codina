import java.util.Scanner;

public class E06_Letras {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce una frase: ");
		String frase = entrada.next();
		int valLetra[] = new int [256];
		
		for(int i=0; i<frase.length(); i++) {
			char caracter = frase.charAt(i);
			int codigo = caracter;
			valLetra[codigo]++;
		}
		
		System.out.println("Apariciones de cada caracter: ");
		for (int codigo=0; codigo<valLetra.length; codigo++) {
			if(valLetra[codigo]>0) {
				char caracter = (char)codigo;
				System.out.println(caracter+ " : " +valLetra[codigo]);
			}
		}
	}
}
