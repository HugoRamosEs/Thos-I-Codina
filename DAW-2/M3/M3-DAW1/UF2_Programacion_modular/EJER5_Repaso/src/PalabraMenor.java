/*
 
Escribe los siguientes metodos que trabajan con Strings
 
menor : Metodo que devuelve la cadena menor alfabéticamente
 
Usar el método compareTo
 
*/

public class PalabraMenor {

	public static String menor(String a, String b) {
		String menor = "";
		if (a.compareTo(b) < 0) {
			menor = a;
		}

		else if (a.compareTo(b) > 0) {
			menor = b;
		}

		else {
			menor = "Son iguales";
		}
		return menor;
	}

	public static String menor(String[] palabras) {
		String m = palabras[0];
		for (int i = 1; i < palabras.length; i++) {
			m = menor(m, palabras[i]);
		}
		return m;
	}

	public static void main(String[] args) {
		String a = "array";
		String b = "operator";
		System.out.println(menor(a, b)); // muestra string menor

		String[] palabras = { "operator", "array", "method", "class" };
		System.out.println(menor(palabras)); // muestra string menor

	}
}
