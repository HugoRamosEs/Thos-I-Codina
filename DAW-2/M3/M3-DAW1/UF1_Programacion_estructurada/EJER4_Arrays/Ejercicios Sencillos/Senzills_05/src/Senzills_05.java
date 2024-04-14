
public class Senzills_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int valors[] = {1,3,2,8,4,5,2};
		int sumapar = 0;
		int sumaimpar = 0;
		
		for(int i = 0; i<valors.length; i= i+2) {
			sumapar = sumapar + valors[i];
		}
		
		for(int j = 1; j<valors.length; j= j+2) {
			sumaimpar = sumaimpar + valors[j];
		}
		
		System.out.println("La suma de valors pars es " +sumapar+ " y la suma dels valors impars es " +sumaimpar);
	}
}
