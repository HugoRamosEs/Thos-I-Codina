/*

Escribir un método que quite los espacios del inicio y del final de un 
texto así como los grupos de espacios repetidos dejando solo un espacio
por grupo.

*/

public class E10_QuitaEspaciosRepetidos {

    public static void main(String[] args) {

        String frase3 = "  un  dos      tres ";
        System.out.println( "["+quitaEspRep(frase3)+"]" );  //muestra :un dos tres
        System.out.println( "["+quitaEspRep2(frase3)+"]" ); //muestra :un dos tres
        System.out.println( "["+quitaEspRep3(frase3)+"]" ); //muestra :un dos tres
    }

    /**
     * Crea un nuevo String con un único espacio entre palabras
     * @param s String a tratar 
     * @return El nuevo String con los espacios correctos
     */
    public static String quitaEspRep(String s) {

        s = s.trim(); //quitamos espacios de los extremos

        while ( s.contains("  ") ) {
            s = s.replace("  "," ");
        }
        return s;
    }
    
    /**
     * Crea un nuevo String con un único espacio entre palabras
     * @param s String a tratar 
     * @return El nuevo String con los espacios correctos
     */
    public static String quitaEspRep2(String s) {

        s = s.trim(); //quitamos espacios de los extremos
        // Obtiene las partes separadas por espacios
        String partes[]=s.split(" ");
        String res="";
        for (int i=0; i<partes.length; i++) {
            if (partes[i].length()>0) {
            	// Solo cuenta las partes con longitud!=0
            	res=res+partes[i]+" ";
            }
        }
        return res.trim();
    }
    
    /**
     * Crea un nuevo String con un único espacio entre palabras
     * @param s String a tratar 
     * @return El nuevo String con los espacios correctos
     */
    public static String quitaEspRep3(String s) {

        StringBuilder sb = new StringBuilder(s);

        //Eliminamos espacios repetidos
        
        for(int i= sb.length()-1; i>0; i--) {
        	// Si tenemos un espacio seguido de otro
            if (sb.charAt(i)==' ' && sb.charAt(i-1)==' '){
            	// Se borra el segundo espacio
                sb.deleteCharAt(i);
            }
        }
        
        //Eliminamos espacios del inicio y del final si los hay

        if(sb.charAt(0)==' ') sb.deleteCharAt(0);
        if(sb.charAt(sb.length()-1)==' ') sb.deleteCharAt(sb.length()-1);
        
        return sb.toString();
    }

}