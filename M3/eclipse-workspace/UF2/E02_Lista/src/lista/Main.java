package lista;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lista miLista = new Lista();
		miLista.add(Integer.valueOf(9));
		miLista.add(Integer.valueOf(10));
		miLista.add(Integer.valueOf(9));
		miLista.add(new String("hola"));
		miLista.add(new String("hola"));
		
		System.out.println("-----------SIZE----------");
		System.out.println(miLista.size());
		
		System.out.println("\n-----------IsIn----------");
		System.out.println(miLista.isIn(Integer.valueOf(9)));
		
		System.out.println("\n---------ToString--------");
		System.out.println(miLista);
		
		System.out.println("\n--------GET_OBJECT-------");
		System.out.println(miLista.get(0));
		
		System.out.println("\n--------GET_INDEX--------");
		System.out.println(miLista.getIndex(Integer.valueOf(9)));
		System.out.println(miLista.getIndex(new String("hola")));
		
		System.out.println("\n------LAST_INDEXof-------");
		System.out.println(miLista.lastIndexOf(Integer.valueOf(9)));
		System.out.println(miLista.lastIndexOf(new String("hola")));
		
		System.out.println("\n------REMOVE_INDEX-------");
		miLista.removeIndex(2);
		System.out.println(miLista);
		
		System.out.println("\n-----------SET-----------");
		miLista.set(new String("adeu"), 2);
		System.out.println(miLista);
		
		System.out.println("\n----------ARRAY----------");
		Object[] array = miLista.toArray();
		for (int i=0; i<array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
