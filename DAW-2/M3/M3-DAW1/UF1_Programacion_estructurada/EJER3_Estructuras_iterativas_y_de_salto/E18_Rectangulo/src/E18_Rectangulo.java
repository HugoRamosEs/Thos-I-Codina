import java.util.Scanner;

public class E18_Rectangulo {

	public static void main(String[] args) {
		
		int i = 0;
		int j = 0;
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce un valor para la base: ");
		int base = entrada.nextInt();
		
		Scanner entrada1 = new Scanner(System.in);
		System.out.println("Introduce un valor para la altura: ");
		int altura = entrada1.nextInt();
		
		while(i<altura) {
			while(j<base) {
				System.out.print("*");
				j++;
		}
			System.out.println();
			j=0;
			i++;
					
		}
	}
}
