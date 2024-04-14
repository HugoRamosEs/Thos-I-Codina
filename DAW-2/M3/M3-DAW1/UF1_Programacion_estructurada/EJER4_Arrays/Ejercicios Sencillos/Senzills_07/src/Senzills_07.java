
public class Senzills_07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String palabras1[] = new String [3];
		palabras1[0] = "moto";
		palabras1[1] = "azul";
		palabras1[2] = "pequeña";
		
		String palabras2[] = new String [3];
		palabras2[0] = "coche";
		palabras2[1] = "rojo";
		palabras2[2] = "grande";
		
		String palabrasTotales[] = new String [palabras1.length + palabras2.length];
		
		for (int i=0; i<palabras1.length; i++) {
			palabrasTotales[i]=palabras1[i];
		}
		for (int i=0; i<palabras2.length; i++) {
			palabrasTotales[i+palabras1.length]=palabras2[i];
		}
		for (int i=0; i<palabrasTotales.length; i++) {
			System.out.print(palabrasTotales[i] + " ");
		}

	}
}
