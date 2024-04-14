import java.io.*;
 
public class E07_TrianguloRectangulo {
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in));
 
        System.out.print("Escribe el primer lado : ");
        double a = Double.parseDouble(entrada.readLine());
 
        System.out.print("Escribe el segundo lado : ");
        double b = Double.parseDouble(entrada.readLine());
 
        System.out.print("Escribe el tercer lado : ");
        double c = Double.parseDouble(entrada.readLine());
        
        if (a*a == b*b + c*c || b*b == a*a + c*c || c*c == a*a + b*b) {
        	System.out.println("Es un triangulo rectangulo");
        }else {
        	System.out.println("No es un triangulo rectangulo");
        }
    }
}