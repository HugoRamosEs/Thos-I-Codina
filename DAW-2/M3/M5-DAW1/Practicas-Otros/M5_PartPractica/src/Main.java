
public class Main {
	public static void main(String[] args) throws Exception {
		// PREGUNTA 6
		GestorEsdeveniments gestor = new GestorEsdeveniments();
		FocusEsdeveniment focusEsdeveniment = new FocusEsdeveniment();
		MouseEsdeveniment mouseEsdeveniment = new MouseEsdeveniment();
		TeclaEsdeveniment teclaEsdeveniment = new TeclaEsdeveniment();
		TextEsdeveniment textEsdeveniment = new TextEsdeveniment();
		EntradaEsdeveniment entradaEsdeveniment = new EntradaEsdeveniment();
		ComponentEsdeveniment componentEsdeveniment = new ComponentEsdeveniment();
		AccioEsdeveniment accioEsdeveniment = new AccioEsdeveniment();
		
		gestor.add(focusEsdeveniment);
		gestor.add(mouseEsdeveniment);
		gestor.add(teclaEsdeveniment);
		gestor.add(textEsdeveniment);
		gestor.add(entradaEsdeveniment);
		gestor.add(componentEsdeveniment);
		gestor.add(accioEsdeveniment);
		
		// PREGUNTA 7
		Event evento = new TeclaEsdeveniment();
		
		TeclaEsdeveniment teclaEs = (TeclaEsdeveniment) new Event();
		
		// PREGUNTA 8	
		gestor.mostrarEsdevenimentsPendents();
	}
}
