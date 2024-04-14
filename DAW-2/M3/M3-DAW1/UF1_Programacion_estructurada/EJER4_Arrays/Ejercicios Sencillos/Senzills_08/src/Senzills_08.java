
public class Senzills_08 {

	public static void main(String[] args) {
		String alumnes[] = {"Martina", "Neus", "Angelica", "Lluis", "Clara", "Eloy"};
		int notes[]=  {         4,       7,        3,        8,        9,      2   };
		
		int aprovats=0;
		System.out.println("Aprovats: ");
		for (int i=0; i<notes.length; i++) {
			if(notes[i]>=5) {
				System.out.println(alumnes[i]);
				aprovats++;
			}
		}
		System.out.println("Han aprovat: " +aprovats);
		System.out.println("-----------");
		int suspensos=0;
		System.out.println("Suspensos: ");
		for (int i=0; i<notes.length; i++) {
			if(notes[i]<5) {
				System.out.println(alumnes[i]);
				suspensos++;
			}
		}
		System.out.println("Han suspés: " +suspensos);
	}
}
