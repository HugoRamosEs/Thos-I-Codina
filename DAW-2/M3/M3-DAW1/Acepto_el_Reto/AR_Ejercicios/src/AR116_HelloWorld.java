import java.util.Scanner;

public class AR116_HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner(System.in);
		System.err.println("Indica cuantos mensajes hay que emitir: ");
		int mensajes = entrada.nextInt();
		
		for (int i=0; i<mensajes; i++) {
			System.out.println("Hola mundo.");
		}
	}

}