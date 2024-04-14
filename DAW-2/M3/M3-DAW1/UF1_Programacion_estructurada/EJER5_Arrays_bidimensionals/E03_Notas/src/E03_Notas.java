import java.io.*;

public class E03_Notas {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		/*
		 * 
		 * Utiliza un array de dos dimensiones con las notas de 4 alumnos en 3 examenes.
		 * Cada fila corresponde a un alumno y cada columna a un examen. Establece estos
		 * valores en el código del programa. El programa debe calcular :
		 * 
		 * - la nota media de cada alumno - la nota mayor indicando alumno y examen
		 * correspondientes - la nota media más alta y que alumno la ha conseguido - la
		 * nota media de cada examen
		 * 
		 * (Para facilitar el ejercicio suponemos que los valores más altos no estan
		 * repetidos)
		 * 
		 * Salida del programa
		 * ----------------------------------------------------------------------- La
		 * nota media del alumno 1 es 7,00 La nota media del alumno 2 es 5,00 La nota
		 * media del alumno 3 es 5,67 La nota media del alumno 4 es 6,67 La media más
		 * alta es 7,00 y la ha conseguido el alumno 1 La nota más alta es 9,00 y la ha
		 * conseguido el alumno 3 en el examen 3 La media del examen 1 es 5,75 La media
		 * del examen 2 es 5,50 La media del examen 3 es 7,00
		 * 
		 */

		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

		int alumnos = 4;
		int examenes = 3;
		double[][] notas = { { 7, 6, 8 }, { 5, 4, 6 }, { 3, 5, 9 }, { 8, 7, 5 } };

		double suma;
		double mesGran = 0;
		int alGran = 0;
		int exGran = 0;
		double mediaGran = 0;
		int alMedGran = 0;
		double sumacol;

		for (int i = 0; i < notas.length; i++) {
			suma = 0;
			for (int j = 0; j < notas[i].length; j++) {
				suma = suma + notas[i][j];
				if (notas[i][j] > mesGran) {
					mesGran = notas[i][j];
					alGran = i + 1;
					exGran = j + 1;
				}
			}
			double media = suma / notas[i].length;
			if (media > mediaGran) {
				mediaGran = media;
				alMedGran = i + 1;
			}
			System.out.printf("La nota media del alumno" + " %d es %.2f\n", i + 1, media);
		}

		for (int j = 0; j < notas[0].length; j++) {
			sumacol = 0;
			for (int i = 0; i < notas.length; i++) {
				sumacol = sumacol + notas[i][j];
			}
			double mediacol = sumacol / notas.length;
			System.out.printf("La nota media del examen" + " %d es %.2f\n", j + 1, mediacol);
		}
		System.out.printf("La media más alta és %.2f y la ha conseguido" + " alumno %d\n", mediaGran, alMedGran);
		System.out.printf("La nota más alta és %.2f y la ha conseguido" + " alumno %d en el examen %d\n", mesGran,
				alGran, exGran);

	}

}
