import java.util.Scanner;

public class E20_SumaSegundo {

	public static void main(String[] args) {
		
		Scanner teclat = new Scanner(System.in);
		System.out.println("Introduce la hora valor: ");
		int horas = teclat.nextInt();
		
		Scanner teclat2 = new Scanner(System.in);
		System.out.println("Introduce el minuto valor: ");
		int minutos = teclat2.nextInt();
		
		Scanner teclat3 = new Scanner(System.in);
		System.out.println("Introduce el segundo valor: ");
		int segundos = teclat3.nextInt();
		
		int segundos1 = segundos + 1;
		
		if(segundos1>59) {
			segundos1 = 00;
			minutos = minutos + 1;
			}	
			if(minutos>59) {
				minutos = 00;
				horas = horas + 1;
			}
				if(horas>23) {
					horas = 00;
				}
			System.out.println(+horas +":" +minutos +":" +segundos1);
	}	
}
