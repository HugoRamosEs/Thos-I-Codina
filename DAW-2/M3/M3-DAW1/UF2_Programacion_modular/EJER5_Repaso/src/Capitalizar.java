/*
 
Escribe los métodos que faltan
 
capitaliza : Metodo que devuelve la cadena recibida con la inicial en
             mayusculas y el resto en minusculas
 
capitalizaTodo : Metodo que capitaliza todas las palabras de una frase
 
*/

public class Capitalizar {
	
	public static String capitaliza(String nombre) {
		char primerCaracter = Character.toUpperCase(nombre.charAt(0));
		String resto = nombre.substring(1).toLowerCase();
		
		return primerCaracter + resto;
	}
	
	public static String capitalizaTodo(String nombreCompleto) {
		String [] partes = nombreCompleto.split(" ");
		String total = "";
		for (int i=0; i<partes.length; i++) {
			total = total + capitaliza(partes[i]) + " ";
		}
		return total;
	}
	
	public static void main(String[] args) {
		String nom = "jUaN";
        System.out.println(capitaliza(nom)); //muestra Juan
 
        String nombreCompleto = "juaN gArciA PeRez";
        System.out.println( capitalizaTodo(nombreCompleto) ); //muestra Juan Garcia Perez
	}
}
