package operacions;

public class Main {

	public static void main(String[] args) throws Exception {
		/*
		 * PREGUNTA 6
		 * El metode de Object de getClass() no es pot redefinir.
		 */
		
		int[] valors = new int[2];
			valors[0] = 1;
			valors[1] = 5;
		Suma suma = new Suma(valors);
		
		int[] valors2 = new int[1];
			valors2[0] = 1;
		Sinus sinus = new Sinus(valors2);	
		
		System.out.println(suma.opera());
		System.out.println(Suma.opera(3, 4));
		System.out.println("--------------------------------");
		System.out.println(sinus.opera());
		System.out.println(Sinus.opera(0.5));
	}
}
