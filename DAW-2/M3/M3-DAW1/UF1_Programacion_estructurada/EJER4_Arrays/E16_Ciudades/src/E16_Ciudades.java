import java.io.*;
 
public class E16_Ciudades {
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in));
 
        String[] ciudades = {
            "Albacete","Barcelona","Valencia","Segovia","Madrid",
            "Pamplona","Orense","Tarragona","Cuenca","Granada" };
 
        int numCiudades = ciudades.length;
 
        while (numCiudades > 0) {
            System.out.print("\nCiudades : \n");
            for (int i=0; i<numCiudades; i++) {
                System.out.printf("%2d - %s\n",i+1,ciudades[i]);
            }
            int j = 0;
            boolean correcto = false;
            while(!correcto){
                try{
                    System.out.print("\nElige una ciudad : ");
                    j = Integer.parseInt(entrada.readLine());
                    if (j>=1 && j<=numCiudades){
                        correcto = true;
                    }else{
                        System.out.println("Valor invalido");
                    }
                }catch(Exception e){
                    System.out.println("Entrada invalida");
                }
            }
 
            for (int i=j; i<numCiudades; i++) {
                ciudades[i-1] = ciudades[i];
            }
            numCiudades--;
        }
        System.out.println("Ya no quedan ciudades.");
    }
}