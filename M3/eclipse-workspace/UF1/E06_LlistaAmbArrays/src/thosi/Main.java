package thosi;

public class Main {
	public static void main(String[] args) {
		Llista llista = new Llista();
		
		// ENTERS
		Enter e1 = new Enter(12);
		Enter e2 = new Enter(40);
		Enter e3 = new Enter(24);
		Enter e4 = new Enter(33);
		
		// DECIMALS
		Decimal d1 = new Decimal(1.11);
		Decimal d2 = new Decimal(1.1);
		Decimal d3 = new Decimal(79.14);
		Decimal d4 = new Decimal(42.57);
		
		// LLETRES
		Lletra ll1 = new Lletra('i');
		Lletra ll2 = new Lletra('a');
		Lletra ll3 = new Lletra('u');
		Lletra ll4 = new Lletra('l');
		
		// NO COMPARABLE
		NoComparable a = new NoComparable(3); // --> Aquesta clase no implementa Comparable.
		
		// ADD
		llista.add(e3);
		llista.add(e1);
		llista.add(e2);
		llista.add(e4);
//		llista.add(d1);
//		llista.add(d2);
		llista.add(d3);
//		llista.add(d4);
		llista.add(ll1);
		llista.add(ll2);
//		llista.add(ll3);
//		llista.add(ll4);
//		llista.add(a)
		
		// REMOVE I CLEAR
		llista.remove(e3);
//		llista.clear();
		
		// isIN
//		System.out.println(llista.isIn(e2));
		
		// RESULTAT
		System.out.println(llista);
	}
}
