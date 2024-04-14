import java.io.*;
 
public class E06_Dado {
 
    public static void main(String args[]) {
 
        int contador = 0;
         
        //Bucle que calcula 100 aleatorios
 
        for (int i=1;i<=100;i++) {
            int dado = (int)( 1 + Math.random()*6);
            System.out.println("Lanzamiento " + i + " --> " + dado);
            if ( dado == 1 ) {
                contador++;
            }
        }
 
        //Mostrar las veces que ha salido el 1
         
        System.out.println("El 1 ha salido " + contador + " veces.");
    }
}