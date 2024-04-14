/*
   
Cálculo del área de una corona circular.
Los valores de los radios se entran por teclado.
   
Instrucciones:
Desde el método que calcula el área de la corona se debe llamar a
otro método que calcule el área de un círculo, ya que el área de una
corona circular es el área del 'círculo mayor' menos el área del
'círculo menor'.
   
   
Salida del programa
----------------------------------------
Escribe el radio interior : 6
Escribe el radio exterior : 9
El area es 141,37
   
*/

import java.io.*;

class Cercle {
    /**
     * radi del cercle
     */
    double radi;
     
    /**
     * Constructor, assigna al cercle el radi indicat
     * @param r  radi del cercle
     */
    Cercle(double r) {
        radi=r;
    }
     
    public String toString() {
        return "radi:"+radi;
    }
     
    /**
     * Calcula l'àrea del cercle segons Pi*radi^2
     * @return l'àrea calculada
     */
    double area() {
        return Math.PI*Math.pow(radi, 2);
    }
}
 
/**
 * Defineix una Corona Circular
 *
 */
class Corona {
    /**
     * Cercle intern
     */
    Cercle petit;
    /**
     * Cercle extern
     */
    Cercle gran;
     
    /**
     * Assigna els cercles a la Corona
     * @param p  intern petit
     * @param g  extern gran
     */
    Corona(Cercle p, Cercle g) {
        petit=p;
        gran=g;
    }
     
    public String toString() {
        return "cercle gran "+gran+" cercle petit "+petit;
    }
     
    /**
     * Calcula l'àrea de la Corona
     * @return el valor obtingut
     */
    double area() {
        return gran.area()-petit.area();
    }
}


public class E04_AreaCoronaCircular {
	
//	public double areaCirculoMayor (double rMayor) {
//		double aMayor = 0;
//		aMayor = Math.pow(aMayor, 2) * Math.PI;
//		return aMayor;
//	}
//	
//	public double areaCirculoMenor (double rMenor) {
//		double aMenor = 0;
//		aMenor = Math.pow(aMenor, 2) * Math.PI;
//		return aMenor;
//	}
	
    public static void main(String[] args) throws IOException {
    	   
        BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in));
   
        System.out.print("Escribe el radio interior : ");
        double radioInt = Double.parseDouble(entrada.readLine());
   
        System.out.print("Escribe el radio exterior : ");
        double radioExt = Double.parseDouble(entrada.readLine());
         
        Cercle petit=new Cercle(radioInt);
        Cercle gran=new Cercle(radioExt);
                
        Corona corCircular=new Corona(petit, gran);
 
        double area=corCircular.area();
 
        System.out.printf("El area es %.2f\n",area);
    }
}
