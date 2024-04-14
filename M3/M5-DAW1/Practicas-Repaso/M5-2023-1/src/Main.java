import javax.swing.JLabel;

public class Main {
	public static void main(String[] args) throws Exception {
		// PREGUNTA 6
		GestorEsdeveniment ge = new GestorEsdeveniment();
		MouseEsdeveniment me = new MouseEsdeveniment(new JLabel());
		TeclaEsdeveniment te = new TeclaEsdeveniment(new String());
		
		ge.enqueue(me);
		ge.enqueue(te);
		ge.dequeue();
		
		// FALTARIAN OBJETOS
		
		// PREGUNTA 7
//		Esdeveniment e = new Esdeveniment(new String());
//		e = te;
//		
//		TeclaEsdeveniment te2 = new TeclaEsdeveniment(new String());
//		Esdeveniment e2 = new Esdeveniment(new String());
//		te2 = (TeclaEsdeveniment) e;
		
		
	}
}
