/*
Programa que muestra el crecimiento de una inversión a interés compuesto.
El usuario entra el capital inicial, la tasa de interés anual y el plazo
en años.
El programa muestra una tabla con tres columnas y una fila por cada año.
En la primera columna aparece el número del año, en la segunda los intereses
generados en ese año y en la tercera el capital acumulado.
 
 
Salida del programa
--------------------------------------------
Entra el capital inicial : 8000
Entra la tasa de interés anual : 4.5
Entra el número de años : 5
 
+-----+-------------+-------------------+
| AÑO |  INTERESES  | CAPITAL ACUMULADO |
+-----+-------------+-------------------+
|   1 |      360,00 |          8.360,00 |
|   2 |      376,20 |          8.736,20 |
|   3 |      393,13 |          9.129,33 |
|   4 |      410,82 |          9.540,15 |
|   5 |      429,31 |          9.969,46 |
+-----+-------------+-------------------+
Capital final :    9969,46
 
Ayuda:
System.out.printf ("| %3d | %,11.2f | %,17.2f |\n",i,interes,capital);
*/
 
 
 
import java.io.*;
 
public class E11_Intereses {
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader entrada = new BufferedReader(
            new InputStreamReader(System.in));
         
        System.out.print("Entra el capital inicial : ");
        double capital = Double.parseDouble(entrada.readLine());
 
        System.out.print("Entra la tasa de interés anual : ");
        double tasa = Double.parseDouble(entrada.readLine());
 
        System.out.print("Entra el número de años : ");
        int años = Integer.parseInt(entrada.readLine());
        
    }
}