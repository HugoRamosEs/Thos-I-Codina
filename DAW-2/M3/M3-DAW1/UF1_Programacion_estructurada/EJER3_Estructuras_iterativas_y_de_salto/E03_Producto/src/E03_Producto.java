import java.io.*;
 
public class E03_Producto {
 
    public static void main(String args[]) throws IOException {
 
        BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in));
 
         
        System.out.print("Entra el valor de n : ");
        int n = Integer.parseInt(entrada.readLine());
 
        //Calculo del producto mediante una multiplicacion
 
        double prod1 = n * 0.1;
 
        System.out.printf ("El producto de %d por 0.1 es %.16f\n",n,prod1);
 
        //Calculo del producto mediante sumas repetidas
 
        double prod2 = 0;
        for ( int i=0; i<n; i++) {
            prod2 = prod2 + 0.1;
        }
 
        System.out.printf ("La suma de %d veces 0.1 es   %.16f\n",n,prod2);
 
        if (prod1 == prod2)
            System.out.println ("Los resultados son iguales.");
        else
            System.out.println ("Los resultados son diferentes.");
    }
}
