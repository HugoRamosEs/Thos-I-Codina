/*
 
Programa que realiza un examen tipo test con N preguntas.
Para ello debe contar con un array de N objetos del tipo Pregunta.
 
La clase Pregunta debe contar con los siguientes campos :
- el texto,
- un array de opciones de respuesta
- y el número de la opción correcta.
 
El programa realiza las preguntas por orden mostrando el texto y las opciones ,
lee y comprueba la respuesta del usuario y al final muestra la puntuación final
( relación entre las preguntas acertadas y el número de preguntas )
 
Salida del programa
-------------------------------
 
PREGUNTA 1
 
¿Que significan las siglas JDK?
 
1. Java Dinamic Kit
2. Java Development Kit
3. Java Diabolic Kitch
4. Jamon De Kocodrilo
 
Entra tu respuesta : 1
 
Respuesta errónea, la respuesta correcta es Java Development Kit
 
PREGUNTA 2
....
....
 
Has acertado 4 de 6 preguntas.
Nota final : 6,67
 
*/

import java.util.Scanner;

class Pregunta{
	String texto;
	String respuestas[];
	int opcionCorrecta;
	
	Pregunta (){
		
	}
	
	Pregunta(String e, String r1, String r2, String r3, String r4, int opcionCorrecta){
		texto = e;
		respuestas=new String[4];
		respuestas[0]=r1;
		respuestas[1]=r2;
		respuestas[2]=r3;
		respuestas[3]=r4;
		this.opcionCorrecta = opcionCorrecta;
	}
	
}

public class E12_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner(System.in);
		
		Pregunta[] test = {
				new Pregunta ("¿Que significan las siglas JDK?", 
                        "Java Dinamic Kit","Java Development Kit",
                        "Java Diabolic Kitch","Jamon De Kocodrilo",
                        2),
				new Pregunta("¿Que mostrará esta instrucción: System.out.printf(\"%.1d\",1/4); ?",
                        "0.25","0.2","Se producirá una excepción",
                        "1/4", 3) 
		};
		
		int aciertos = 0;
		
		for (int i=0; i<test.length; i++) {
			Pregunta p = test[i];
			System.out.printf("\nPREGUNTA %d\n\n",i+1);
            System.out.println(p.texto);
            System.out.println();
            for (int j=0; j<p.respuestas.length; j++) {
            	System.out.println((j+1) + ". " + 
                        p.respuestas[j] );
            }
            
            System.out.println("Introduce una respuesta: ");
            int respuesta = entrada.nextInt();
            
            if (respuesta==p.opcionCorrecta) {
            	System.out.println("Respuesta Correcta");
            	aciertos++;
            }else {
            	System.out.println("Respuesta Incorrecta" +p.respuestas[p.opcionCorrecta -1]);
            }
            
            double nota = 10 * (double)aciertos/test.length;
            System.out.println("Has acertado " +aciertos+ " preguntas");
            System.out.println("Nota final: " +nota);
		}
	}
}
