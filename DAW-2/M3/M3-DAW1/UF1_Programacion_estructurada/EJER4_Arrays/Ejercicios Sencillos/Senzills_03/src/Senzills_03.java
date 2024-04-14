
public class Senzills_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int valors[] = new int [100];
		
		int dada=0;
		
		for (int i = 0; i<valors.length; i++) {
			valors[i] = dada;
			dada = dada + 2;
		}
			
			for(int i = 0; i<valors.length; i++) {
				System.out.print(valors[i] + " ");
		}
	}
}