import java.util.Scanner;

public class AR_638 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		System.err.println("Introduce los casos: ");
		int casos = entrada.nextInt();
		
		for (int i=0; i<casos; i++) {
			System.err.println("Entra los comensales: ");
			int c = entrada.nextInt();
			System.err.println("Entra la cantidad de albondigas: ");
			int n = entrada.nextInt();
			
			int r = n / (c-1);
			int min = r;
			int aporp = ((r-1)+n)/c;
			
			if (aporp==r-1 && r-1!=0) {
				min = r-1;
			}
			System.out.println((n+min)+ " " +(n+r));
		}
	}
}
