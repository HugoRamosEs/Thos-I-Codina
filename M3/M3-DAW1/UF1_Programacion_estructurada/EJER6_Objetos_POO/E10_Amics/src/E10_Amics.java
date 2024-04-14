/*
 
Programa que gestiona les dades dels aniversaris dels nostres amics.
El programa disposa d'aquestes dades inicialitzades en el codi font.
De cada amic guardem el seu nom i la seva data de naixement.
El programa ha de disposar d'una classe apropiada per les dates.
A més ha de disposar d'un array amb els noms dels mesos.
 
El programa ha de :
- primer, llistar els amics agrupats pel mes en que fan anys, mostrant
  el nom del mes i nom i data de naixement de cada amic.
- després, demanar un nom i mostrar la seva data de naixement
 
Sortida del programa
------------------------------------------------------------------------
 
 
Gener
----------------------
 
Febrer
----------------------
 
Març
----------------------
  10/03/1994 Joan
 
Abril
----------------------
 
Maig
----------------------
 
Juny
----------------------
 
Juliol
----------------------
 
Agost
----------------------
  19/08/1999 Arnau
 
Setembre
----------------------
 
Octubre
----------------------
 
Novembre
----------------------
  29/11/1990 Isa
 
Desembre
----------------------
 
 
Entra un nom : Isa
 
Data de naixement : 29/11/1990
 
 
 
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

class amigo{
	String nombre;
	Fecha nacimiento;
	
	amigo(String nombre, Fecha nacimiento){
		this.nombre = nombre;
		this.nacimiento = nacimiento;
	}
	
	amigo (String nombre, String nacimiento) {
        this.nombre=nombre;
        this.nacimiento=new Fecha(nacimiento);
    }
	
    public String toString() {
        return (nombre+" "+nacimiento);
    }
    
}


public class E10_Amics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		amigo[] amigos = {
			new amigo("Joan", new Fecha("10/3/1994")), 
			new amigo("Isa", new Fecha("29/11/1990")), 
			new amigo("Arnau", new Fecha("19/8/1999")),
			new amigo("Agamenón", new Fecha("4/2/1989")), 
			new amigo("Anacleto", new Fecha("31/3/1990")), 
			new amigo("Carpanta", new Fecha("11/3/1988")),
			new amigo("Otilio", new Fecha("5/8/1995")), 
			new amigo("Mortadelo", new Fecha("29/2/1992")), 
			new amigo("Timoteo", new Fecha("23/7/1994"))
        };
 
        String[] meses = {"Gener","Febrer","Març","Abril","Maig","Juny","Juliol","Agost","Setembre","Octubre","Novembre","Desembre"};
		
        for (int m = 0; m<meses.length; m++) {
        	System.out.println(meses[m]);
        	System.out.println("--------------------------");
        	
        	for(int a=0; a<amigos.length; a++) {
        		if (amigos[a].nacimiento.mes==m+1) {
        			System.out.println(amigos[a]);
        		}
        	}
        }
        
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce un nombre (Primera letra en mayúsculas): ");
        String nombre = entrada.next();
        
        boolean encontrado = false;
        for (int i = 0; i<amigos.length; i++) {
        	if (amigos[i].nombre.equals(nombre)) {
        		System.out.print("Fecha de nacimiento: " +amigos[i].nacimiento);
        		encontrado = true;
        	}
        }
        
        if (!encontrado) {
        	System.out.println("No existe");
        }
        
//        static String llegirNom() throws IOException {
//        	 
//            BufferedReader entrada = new BufferedReader(
//                new InputStreamReader(System.in));
//             
//            String n;
//            do {
//                System.out.println("Entra un nom:");
//                n=entrada.readLine();
//            } while (n.length()==0);
//             
//            return n;
//        }
        
	}

}
