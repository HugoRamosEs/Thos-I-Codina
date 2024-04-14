package Calculs;
/*
 
En este programa se define la clase Fecha con campos para el dia, mes y año.
Se entra por teclado dos fechas y el programa dice cual es la fecha menor.
 
Salida del programa:
------------------------------
 
Entra la primera fecha :
Dia : 15
Mes : 3
Año : 2005
 
Entra la segunda fecha :
Dia : 20
Mes : 2
Año : 2005
 
La fecha menor es 20/02/2005
 
*/

import java.util.Scanner;

public class Fecha{
	
	int dia;
	int mes;
	int año;
	
	public Fecha(int d, int m, int a){
		dia = d;
		mes = m;
		año = a;
	}
	
	public Fecha(String data){
		String partes[]=data.split("/");
		dia=Integer.parseInt(partes[0]);
		mes=Integer.parseInt(partes[1]);
		año=Integer.parseInt(partes[2]);
	}

	public boolean esMenor(Fecha f) {
		if (this.año<f.año) return true;
		else if (this.año>f.año) return false;
		else if (this.mes<f.mes) return true;
		else if (this.mes>f.mes) return false;
		else if (this.dia<f.dia) return true;
		else return false;
	}
	
	public String toString() {
		return dia+"/"+mes+"/"+año;
	}
}