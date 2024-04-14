package esdeveniments;

import javax.swing.JLabel;

public class Main {
	public static void main(String[] args) {
		GestorEsdeveniments gE = new GestorEsdeveniments();
		Mouse me = new Mouse(new String()); // Mouse me = new Mouse(new JLabel());
		Tecla te = new Tecla(new String());
		// FALTAN MÁS OBJETOS POR CREAR...
		
		gE.add(me);
		gE.add(te);
		
		System.out.println(gE.toString());
		
		// PREGUNTA 7
		Esdeveniment e = new Tecla(new String());
		Tecla tE = (Tecla) new Esdeveniment(new String());
	}
}
