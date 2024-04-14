/*
 
Un aula de ordenadores con 3 filas de mesas y 4 ordenadores por fila se
utiliza por un grupo de 12 alumnos que siempre se sientan en el mismo
sitio.
 
Escribe un programa que utilize un array bidimensional donde se guarden
los nombres de los alumnos, de manera que su posición en el array se
corresponda con su posición en el aula. Este array se inicializa en el
código.
 
El usuario del programa tiene que poder entrar un nombre de alumno y
obtener la fila y el ordenador que tiene asignado. La pregunta se repite
hasta que el usuari introduce una cadena vacía.
 
Salida del del programa :
----------------------------------------------------
Entra el nombre de un alumno : Lucia Cases
Este alumno no existe.
 
Entra el nombre de un alumne : Anna Cuesta
Anna Cuesta tiene asignado el ordenador 2 de la fila 1.
 
Entra el nombre de un alumno :
 
Fin del programa.
 
 */

import java.io.*;

public class E02_Aula {

	public static void main(String[] args) throws Exception {

		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

		String[][] aula = { { "Angels Ruiz", "Anna Cuesta", "Francesc Sánchez", "Isaac Gisbert" },
				{ "Albert Clos", "Pau Codillo", "Maria Lisboa", "Luz Ramirez" },
				{ "Carles Serrat", "Daniel Santos", "Oscar Aparici", "Carmen Lopez" } };
		
		boolean cont = true;
		
		while(cont) {
			System.out.println("Entra el nombre de un alumno: ");
			String nombre = entrada.readLine();
			
			if (nombre.equals("")) {
				cont = false;
			} else {
				int fila=0;
				int ordenador=0;
				boolean encontrado = false;
				
				for (int i = 0; i < aula[0].length && !encontrado; i++) {
					for (int j = 0; j < aula.length && !encontrado; j++) {
						if(nombre.equals(aula[i][j])) {
							fila = i;
							ordenador = j;
							encontrado=true;
						}
					}
				}
				if(!encontrado) {
					System.out.println("El alumno no existe");
				}else {
					System.out.println("El alumno " +nombre+ " tiene asignado el ordenador " +(ordenador+1)+ " y está en la fila " +(fila+1));
				}
			}
		}
		System.out.println("Fin del programa.");
	}
}