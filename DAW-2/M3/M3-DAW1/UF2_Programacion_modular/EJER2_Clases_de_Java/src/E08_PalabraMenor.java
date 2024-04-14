/*
 
Escribe los siguientes metodos que trabajan con Strings
 
menor : Metodo que devuelve la cadena menor alfabéticamente
 
Usar el método compareTo
 
*/

public class E08_PalabraMenor {

	public static String menor(String a, String b) {

		if (a == null || a.length() == 0)
			return b;
		if (b == null || b.length() == 0)
			return a;

		int resultado = a.compareTo(b);
		if (resultado < 0) {
			return a;

		} else {
			return b;
		}
	}

	public static String menor(String array[]) {
		if (array==null) return null;
		if (array.length == 0)
			return null;
		String menor = array[0];
		for (int i = 1; i < array.length; i++) {
			menor = menor(menor, array[i]);
		}
		return menor;

		// OTRA MANERA
		// if (array[i].compareTo(menor) < 0) {
		// menor = array[i];
		// }
		// }
		// return menor;

	}

	public static void main(String[] args) {

		String a = "array";
		String b = "operator";
		System.out.println(menor(a, b)); // muestra string menor

		String[] palabras = { "operator", "array", "method", "class" };
		System.out.println(menor(palabras)); // muestra string menor

	}

}
