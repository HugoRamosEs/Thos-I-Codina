import java.io.IOException;
import java.util.Scanner;

public class E27_Terror {

	public static void main(String[] args) {
		
		int acabado = 0;
		int no_acabado = 0;
		int salida = 1;
		
		Scanner entrada = new Scanner(System.in);
		
		while(salida !=0) {
			System.out.println("Introduce un valor: ");
			salida = entrada.nextInt();
			
			if(salida==20 || salida==50 || salida==100) {
				no_acabado++;
			}
			else if(salida==140) {
				acabado++;
			}
			else {
				System.out.println("Valor erroneo");
			}
		}
		System.out.println("Han completado el recorrido " +acabado+ ", no han hecho el recorrido " +no_acabado);
	}
}