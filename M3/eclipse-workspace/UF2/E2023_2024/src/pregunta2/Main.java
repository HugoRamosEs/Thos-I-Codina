package pregunta2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] lletres = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","X","Y","Z"};
		
		DNI aux = new DNI("1A");		
		ArbreBinari arbre = new ArbreBinari(aux) ;
		
		for (int i=2; i<10; i++) {
			aux = new DNI(i+lletres[(i-1)%lletres.length]);		
			arbre.inserir(aux);
		}
		
		aux = new DNI("A1");		
		ArbreBinari arbreB = new ArbreBinari(aux) ;
		
		for (int i=2; i<10; i++) {
			aux = new DNI(lletres[(i-1)%lletres.length]+i);		
			arbreB.inserir(aux);
		}
		
		arbre.inserir(arbreB);
		
		System.out.println(arbre);
	}

}
