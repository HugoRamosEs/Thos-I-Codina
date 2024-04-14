/*
 
Implementar el método quitaAcentos de diferentes maneras y comparar 
el tiempo de ejecución de cada implementación.
 
 
*/
 
public class E09_QuitaAcentos {
		
	public static char quitaAcento(char c) {
		char[] vocalesAcentuadas = {'á', 'é', 'í', 'ó', 'ú'};
		char[] vocales = {'a', 'e', 'i', 'o', 'u'};
		
		for (int i=0; i<vocalesAcentuadas.length; i++) {
			if(c == vocalesAcentuadas[i]) {
				return vocales[i];
			}
		}
		return c;
	}	
	
	public static String quitaAcentos1(String text) {
		String resultat = "";
		
		for (int i=0; i<text.length(); i++) {
			char equivalent = quitaAcento(text.charAt(i));
			resultat = resultat + equivalent;
		}
		return resultat;
	}
	
	public static String quitaAcentos2(String text) {
		StringBuilder resultat = new StringBuilder(text);
		
		for (int i=0; i<resultat.length(); i++) {
			char c = resultat.charAt(i);
			char equivalent = quitaAcento(c);
			if(c != equivalent) {
				resultat.setCharAt(i, equivalent);
				//array[i]=equivalent;
			}
		}
		return resultat.toString();
	}
	
	public static String quitaAcentos3(String text) {
		text = text.replace('á', 'a');
		text = text.replace('é', 'e');
		text = text.replace('í', 'i');
		text = text.replace('ó', 'o');
		text = text.replace('ú', 'u');
		return text;
	}
		
    public static void main(String[] args) {
    	
        String s = "áéíóú";
        int veces = 5000000;
         
        StringBuilder sb = new StringBuilder();
         
        for(int i=0; i<veces; i++){
            sb.append(s);
        }
        String texto = sb.toString();
        System.out.println( "original: \n"+texto.substring(0, 80) );
         
        //Medir y mostrar cuanto tarda en ejecutarse este método
        
        System.out.printf
		( "+-----------------------------------------------------+\n"
		+ "+           		 METODO 1                     +\n"
		+ "+-----------------------------------------------------+\n");
         
        long t1 = System.currentTimeMillis();
        
        String resultado = quitaAcentos1(texto.substring(0,20000));
         
        long t2 = System.currentTimeMillis();
         
        System.out.println(resultado.substring(0, 80) ); 
         
        System.out.println("Tiempo 1: " + (t2-t1));
        
        System.out.printf
		( "+-----------------------------------------------------+\n"
		+ "+           		 METODO 2                     +\n"
		+ "+-----------------------------------------------------+\n");
        
        t1 = System.currentTimeMillis();
        
        resultado = quitaAcentos2(texto);
         
        t2 = System.currentTimeMillis();
         
        System.out.println(resultado.substring(0, 80) ); 
         
        System.out.println("Tiempo 2: " + (t2-t1));
        
        System.out.printf
		( "+-----------------------------------------------------+\n"
		+ "+           		 METODO 3                     +\n"
		+ "+-----------------------------------------------------+\n");
        
        t1 = System.currentTimeMillis();
        
        resultado = quitaAcentos3(texto);
         
        t2 = System.currentTimeMillis();
         
        System.out.println(resultado.substring(0, 80) ); 
         
        System.out.println("Tiempo 3: " + (t2-t1));
 
    }
 
}
