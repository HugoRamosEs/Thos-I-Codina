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

class Fecha{
	
	int dia;
	int mes;
	int año;
	
	Fecha(int d, int m, int a){
		dia = d;
		mes = m;
		año = a;
	}
	
	Fecha(String data){
		String partes[]=data.split("/");
		dia=Integer.parseInt(partes[0]);
		mes=Integer.parseInt(partes[1]);
		año=Integer.parseInt(partes[2]);
	}

	boolean esMenor(Fecha f) {
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


public class E02_Fecha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner (System.in);
		
		System.out.println("Entra la primera fecha dd/mm/aa: ");
		Fecha f1 = new Fecha(entrada.nextLine());
		
		System.out.println("Entra la segunda fecha dd/mm/aa: ");
		Fecha f2 = new Fecha(entrada.nextLine());
		
		System.out.println("La fecha menor es ");
			if(f1.esMenor(f2)) {
				System.out.println(f1);
			}
			
			if(f2.esMenor(f1)) {
				System.out.println(f1);
			}
			
			if(f2.esMenor(f1) == f1.esMenor(f2)) {
				System.out.print("ninguna. Son iguales");
			}
	}
}
