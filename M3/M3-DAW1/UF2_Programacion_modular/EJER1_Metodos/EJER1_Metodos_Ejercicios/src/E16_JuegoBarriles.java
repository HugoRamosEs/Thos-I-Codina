/*
 
Programa que realiza el juego de los 3 barriles.
 
Dicho juego comienza con 3 barriles de 8, 5 y 3 litros de capacidad
respectivamente, de los cuales el primero está lleno y los otros
dos vacíos.
 
El objetivo es conseguir 4 litros en alguno de los barriles sin utilizar
ningún otro recipiente de medida, simplemente vertiendo el contenido de
un barril a otro y realizando el menor número posible de vertidos.
 
Para ello el programa debe contar con un array de 3 objetos de tipo Barril.
La clase Barril debe disponer de los campos capacidad y contenido.
 
Salida por pantalla:
================================
 
Movimientos : 0
 
  +--------+
  |########|
  |########|
  |########|  +--------+
  |########|  |        |
  |########|  |        |  +--------+
  |########|  |        |  |        |
  |########|  |        |  |        |
  |########|  |        |  |        |
  +--------+  +--------+  +--------+
 
Elige el barril de origen : 1
Elige el barril de destino : 2
 
 
Movimientos : 1
 
  +--------+
  |        |
  |        |
  |        |  +--------+
  |        |  |########|
  |        |  |########|  +--------+
  |########|  |########|  |        |
  |########|  |########|  |        |
  |########|  |########|  |        |
  +--------+  +--------+  +--------+
 
Elige el barril de origen :
 
*/
 
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
 
class Barril {
    int capacidad;
    int contenido;
     
    /**
     * Constructor
     * @param cap  capacidad máxima del barril
     * @param cont contenido inicial
     */
    Barril(int cap, int cont) {
        capacidad=cap;
        contenido=cont;
    }
 
    /**
     * Mueve el máximo posible de litros desde el origen
     * hacia el Barril (this)
     * @param origen  barril desde el que se obtienen los litros
     */
    void llenaDesde(Barril origen) {
        int cantidad=origen.contenido;
        int libre=this.capacidad-this.contenido;
         
        int mover;
        if (cantidad<libre) mover=cantidad;
        else mover=libre;
         
        origen.contenido=origen.contenido - mover;
        this.contenido=this.contenido + mover;
    }
}
 
public class E16_JuegoBarriles {
     
    public static void main(String[] args) {
         
        E16_JuegoBarriles programa=new E16_JuegoBarriles();
 
        Barril barriles[]= { new Barril(8,8), new Barril(5,0), new Barril(3,0)};
         
        int moviments=0;
        LocalTime t1=LocalTime.now();
        do {
             programa.dibuixa(barriles);
             int org=(int)programa.llegirNum("Entra Barril origen:(1-3)");
             int dst=(int)programa.llegirNum("Entra Barril destí :(1-3)");
             barriles[dst-1].llenaDesde(barriles[org-1]);
             moviments++;
        } while (!programa.aconseguit(barriles));
        LocalTime t2=LocalTime.now();
         
        programa.dibuixa(barriles);
        System.out.println("Aconseguit !! en "+moviments+" moviments.");
        System.out.println("Has trigat "+ChronoUnit.SECONDS.between(t1, t2)+" segons");
    }
         
    /**
     * Muestra una pregunta por consola y lee un double del teclado
     * 
     * @param pregunta texto a mostrar
     * @return el double leido del teclado
     */
    double llegirNum(String pregunta) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
  
        while (true) {
            try {
                System.out.print(pregunta);
                double valor = Double.parseDouble(entrada.readLine());
                return valor;
            } catch (Exception e) {
                System.out.println("Valor incorrecto.");
            }
        }
    }
 
    /**
     * Mostra per consola l'estat dels barrils de l'array
     * @param barriles array de Barril
     */
    void dibuixa(Barril [] barriles) {
        for (int l=9; l>=0; l--) {
            for (int b=0; b<=2; b++) {
                if (l>barriles[b].capacidad+1) System.out.print("          ");
                else if (l==barriles[b].capacidad+1 || l==0) System.out.print("+--------+");
                else if (l>barriles[b].contenido) System.out.print("|        |");
                else if (l<=barriles[b].contenido)System.out.print("|########|"); 
            }
            System.out.println();
        }
    }
 
    /**
     * Mostra per consola l'estat dels barrils de l'array
     * Fa servir un array abans de fer print.
     * @param barriles array de Barril
     */
    void dibuixa2(Barril [] barriles) {
        // Aquest array serveix per a construir gràficament
        // els barrils, després es fa print de l'array complet.
        String[][] dibuix= {
                {"+--------+"},
                {"|########|"},
                {"|########|"},
                {"|########|","+--------+"},
                {"|########|","|        |"},
                {"|########|","|        |","+--------+"},
                {"|########|","|        |","|        |"},
                {"|########|","|        |","|        |"},
                {"|########|","|        |","|        |"},
                {"+--------+","+--------+","+--------+"}
        };
        // Per cada Barril, modifica l'array
        for (int b=0; b<=2; b++) {
            dibBarril(b, barriles[b], dibuix);
        }
        // Fa print de l'array ja preparat
        for (int f=0;f<dibuix.length; f++) {
            for (int c=0; c<dibuix[f].length; c++) {
                System.out.print(dibuix[f][c]);
            }
            System.out.println();
        }
    }
 
    /**
     * Modifica l'array d'String que es fa servir per 
     * dibuixar els barrils
     * @param n  núm. de barril (columna)
     * @param b  Barril a dibuixar
     * @param dibuix array del què després es farà print
     */
    void dibBarril(int n, Barril b, String dibuix[][]) {
        // f és la fila de l'array
        // l és el litre que dibuixem
        for (int f=1, l=8; l>=1; f++, l--) {
            if (b.capacidad>=l) {
                if (b.contenido>=l) {
                    dibuix[f][n]= "|########|";
                }
                else {
                    dibuix[f][n]= "|        |";
                }
            }
        }
    }
     
    /**
     * Comprova si algun dels barrils té 4 litres.
     * @param barriles array de 3 Barril
     * @return true si s'han aconseguit 4 litres, false en altre cas.
     */
    boolean aconseguit(Barril []barriles) {
 
        return barriles[0].contenido==4 || barriles[1].contenido==4;
 
    }
 
}
