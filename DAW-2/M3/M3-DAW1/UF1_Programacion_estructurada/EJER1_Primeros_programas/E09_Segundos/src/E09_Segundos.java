import java.io.*;
 
class E09_Segundos {
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in));
 
        //Leer los segundos
 
        System.out.print("Entra la cantidad de segundos : ");
        int total = Integer.parseInt(entrada.readLine());
 
        //Calcular los minutos totales y los segundos restantes
 
        int minutos = total/60;
        int segundos = total%60;
 
        //Calcular las horas totales y los minutos restantes
 
        int horas = minutos/60;
        minutos = minutos%60;
 
        //Mostrar los resultados
 
        System.out.printf( "%d segundos son %d horas, %d minutos y %d segundos",
                            total,horas,minutos,segundos);
    }
}