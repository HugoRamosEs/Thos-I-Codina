

public class E15_Rotacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String frase = "¡Bienvenido al divertido mundo de los Arrays!";
		char letras[] = frase.toCharArray();
		int longitud = letras.length;
		
		for (int i=0; i<longitud; i++) {
			System.out.print(letras[i]);
		}
		System.out.println();
		
	//  Bucle que repite la rotación hasta
        //  que la frase queda igual que al inicio
        for(int n=0; n<longitud; n++){
 
            //Rotar
 
            // Guardamos el carácter del principio
            char aux = letras[0];
            //  Mueve cada letra a la posición anterior
            //   i-1   <---   i
            for(int i=1; i<longitud; i++){
                letras[i-1] = letras[i];
            }
            //  al final pone el carácter del principio
            letras[longitud-1] = aux;
 
            //Mostrar
 
            for(int i=0; i<longitud; i++){
                System.out.print(letras[i]);
            }
            System.out.println();
        }
	}
}
