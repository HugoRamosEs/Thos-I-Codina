import java.util.Scanner;

public class AR_584 {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		System.err.println("Introduce los casos: ");
		int casos = entrada.nextInt();
		
		int aguante;
		int encendidos;
		int horas;
		
		for (int i=0; i<casos; i++) {
			System.err.println("Introduce las horas de aguante, numero de encendidos, horas de encendido: ");
			aguante = entrada.nextInt();
			encendidos = entrada.nextInt();
			horas = entrada.nextInt();
			
			if ((aguante / encendidos == horas) && (encendidos * horas >= aguante)){
				System.out.println("AMBAS");
			}
			
			else if (encendidos * horas >= aguante) {
            	System.out.println("HORAS");
            }
                 
            else {
            	System.out.println("ENCENDIDOS");
            }
		}
	}
}
