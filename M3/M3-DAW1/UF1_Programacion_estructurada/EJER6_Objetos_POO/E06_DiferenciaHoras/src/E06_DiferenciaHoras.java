/*
 
Programa que calcula la diferencia entre dos horas introducidas por el usuario.
El programa trabaja con objetos del tipo Tiempo con los campos : horas, minutos y segundos.
Como resultado se debe obtener otro objeto del tipo Tiempo y luego mostrarlo.
 
Salida del programa:
------------------------------
Entra la hora inicial (h:m:s) : 3:20:50
Entra la hora final (h:m:s) : 6:30:10
 
La diferencia es 03:09:20
 
 */

import java.util.Scanner;

class Tiempo{
	
	int hora;
	int minutos;
	int segundos;
	
	Tiempo(){
		
	}
	
	Tiempo(int h, int m, int s){
		hora = h;
		minutos = m;
		segundos = s;
	}
	
	Tiempo(String divhora){
		String partes[]=divhora.split(":");
		hora=Integer.parseInt(partes[0]);
		minutos=Integer.parseInt(partes[1]);
		segundos=Integer.parseInt(partes[2]);
	}
	
	Tiempo diferenciaT(Tiempo tFinal) {
		Tiempo tDif = new Tiempo();
		tDif.hora = tFinal.hora - hora;
		tDif.minutos = tFinal.minutos - minutos;
		tDif.segundos = tFinal.segundos - segundos;
		
		if (tDif.segundos<0) {
            tDif.segundos += 60;
            tDif.minutos--;
        }
        if (tDif.minutos<0) {
            tDif.minutos += 60;
            tDif.hora--;
        }
 
        return tDif;
	}
	
	
	public String toString() {
		return hora+":"+minutos+":"+segundos;
	}
	
}


public class E06_DiferenciaHoras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce la hora inicial: ");
		Tiempo tInicial = new Tiempo(entrada.nextLine());
		
		System.out.println("Introduce la hora final: ");
		Tiempo tFinal = new Tiempo(entrada.nextLine());
		
		Tiempo resultado = tInicial.diferenciaT(tFinal);
		
		System.out.println("La diferencia es: " +resultado);
		
	}

}
