/*
 
Escribe los métodos que faltan
 
capitaliza : Metodo que devuelve la cadena recibida con la inicial en
             mayusculas y el resto en minusculas
 
capitalizaTodo : Metodo que capitaliza todas las palabras de una frase
 
*/
 
 
public class E03_Capitalizar {
	public String capitaliza(String nom) {
		String minus = nom.toLowerCase(); //pasa todo a minusculas
		char majus = Character.toUpperCase(nom.charAt(0));
		
		String resultat = majus + minus.substring(1);
		return resultat + minus;
	}
	
	public String capitalizaTodo(String nombreCompleto) {
		String resultado = " ";
		String palabras[] = nombreCompleto.split(" ");
		for (int i=0; i<nombreCompleto.length(); i++) {
			palabras[i] = capitaliza(palabras[i]);
			resultado = resultado + " " +palabras[i];
		}
		return resultado.trim();
	}
	
 
    public static void main(String[] args) {
    	E03_Capitalizar programa = new E03_Capitalizar();
    	
        String nom = "jUaN";
        System.out.println(programa.capitaliza(nom)); //muestra Juan
 
        String nombreCompleto = "juaN gArciA PeRez";
        System.out.println(programa.capitalizaTodo(nombreCompleto)); //muestra Juan Garcia Perez
        
    }
}
