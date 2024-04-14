import java.util.Scanner;

public class E03_Sumas {

	public static void main(String[] args) {
		int valores100[] = new int [100];
		boolean caracterCorrecto = false;
		
		while(!caracterCorrecto) {
			try{
				Scanner entrada = new Scanner(System.in);
				System.out.println("Introduce un numero entre 0 y 100:" );
				caracterCorrecto = true;
				int numero = entrada.nextInt();
				if(numero <= valores100.length) {
					for (int i=1; i<=numero; i++) {
						valores100[i] = valores100[i-1] + i;
						System.out.print(valores100[i-1] +". ");
					}		
				} 
				if (numero>valores100.length || numero<0){
					caracterCorrecto=false;
					System.out.println("Valor invalido!");
				}
			}catch(Exception e) {
				caracterCorrecto=false;
				System.out.println("Caracter invalido!");
			}
		}
	}
}
