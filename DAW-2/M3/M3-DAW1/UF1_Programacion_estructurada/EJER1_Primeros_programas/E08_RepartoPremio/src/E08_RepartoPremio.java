import java.io.*;
 
class E08_RepartoPremio {
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in));
 
        System.out.print("Escribe la aportación de la primera persona : ");
        double ap1 = Double.parseDouble(entrada.readLine());
 
        System.out.print("Escribe la aportación de la segunda persona : ");
        double ap2 = Double.parseDouble(entrada.readLine());
 
        System.out.print("Escribe la aportación de la tercera persona : ");
        double ap3 = Double.parseDouble(entrada.readLine());
 
        System.out.print("Escribe el importe del premio obtenido: ");
        double premio = Double.parseDouble(entrada.readLine());
        double pr = premio / (ap1+ap2+ap3);
 
        System.out.printf("La parte correspondiente a la primera persona es %.2f euros\n",pr * ap1);
        System.out.printf("La parte correspondiente a la segunda persona es %.2f euros\n",pr * ap2);
        System.out.printf("La parte correspondiente a la tercera persona es %.2f euros\n",pr * ap3);
    }
}
