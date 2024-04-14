/*
 
Escribe los métodos que faltan :
 
cuentaApariciones : Método que cuenta cuantas veces aparece una cadena dentro de otra
 
*/
 
public class E04_CuentaApariciones {
	
	public static int cuentaApariciones(String frase, String paraula) {
		int contador = 0;
		int posicion = frase.indexOf(paraula);
		while(posicion!=-1) {
			contador++;
			posicion = frase.indexOf(paraula,posicion+1);
		}
		return contador;
	}
 
    public static void main(String[] args) {
 
        String frase = "un dos un tres undos tres un hola";
         
        System.out.println(cuentaApariciones(frase,"")); //muestra 4
 
    }
}