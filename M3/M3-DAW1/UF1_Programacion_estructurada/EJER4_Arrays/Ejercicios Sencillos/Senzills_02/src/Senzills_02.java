
public class Senzills_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int valors[]= new int [202];
		int inicio = 100;
		
		for(int i = 100; i<valors.length; i++) {
			valors[i] = inicio;
			inicio++;
		}
		
		for(int i = 100; i<valors.length; i++) {
			System.out.print(valors[i] + " ");
		}
		
	}

}
