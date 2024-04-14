
public class Senzills_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String nombres[] = new String [6];
		nombres[0] = "Angel";
		nombres[1] = "Cuesta";
		nombres[2] = "Eva";
		nombres[3] = "López";
		nombres[4] = "Pol";
		nombres[5] = "Castro";
		
		String nombre = " " + 0;
		String apellido =" " + 0;
		
		for (int i = 0; i<nombres.length; i=i+2) {
			System.out.println("nombre: "+nombres[i]+ " " +nombres[i+1]);
		}

		
	}

}
