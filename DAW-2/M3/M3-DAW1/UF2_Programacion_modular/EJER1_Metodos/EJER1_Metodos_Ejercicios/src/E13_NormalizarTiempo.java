/*
 
Normalizar un tiempo entrado por teclado para que el valor de los
minutos y de los segundos esté entre 0 y 59.
 
Utilizar una clase Tiempo con campos para las horas, minutos y segundos.
 
Escribe los métodos que faltan.
 
 
Salida del programa
---------------------------------------------------
Entra un tiempo (hh:mm:ss) : 2:65:92
El tiempo normalizado es : 03:06:32
 
*/

import java.io.*;
import java.util.Scanner;

class Tiempo {

	int hora;
	int minutos;
	int segundos;

	Tiempo() {

	}

	Tiempo(int h, int m, int s) {
		hora = h;
		minutos = m;
		segundos = s;
	}

	Tiempo(String divhora) {
		String partes[] = divhora.split(":");
		hora = Integer.parseInt(partes[0]);
		minutos = Integer.parseInt(partes[1]);
		segundos = Integer.parseInt(partes[2]);
	}

	public String toString() {
		return hora + ":" + minutos + ":" + segundos;
	}

	public Tiempo normalizar() {

		Tiempo tN = new Tiempo();

		if (segundos >= 60) {
			minutos += segundos / 60;
			segundos = segundos % 60;
		}
		if (minutos >= 60) {
			hora += minutos / 60;
			minutos = minutos % 60;
		}

		return tN;
	}
}

public class E13_NormalizarTiempo {

	public static void main(String[] args) throws IOException {

		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Entra un tiempo (hh:mm:ss) : ");
		String tiempo = entrada.readLine();

		Tiempo t = new Tiempo(tiempo);

		t.normalizar();

		System.out.println("El tiempo normalizado es : " + t);
	}

}
