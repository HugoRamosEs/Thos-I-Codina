
import java.util.Scanner;
import java.io.*;

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
	
	public String toString() {
		return dia+"/"+mes+"/"+año;
	}
}

class Loto{
	int numero;
	int serie;
	Fecha dia_sorteig;
	double preu;
	
	Loto(){
		
	}
	
	Loto(int n, int s, Fecha f, double p){
		numero = n;
		serie = s;
		dia_sorteig = f;
		preu = p;
	}
	
	Loto(int n, int s, String f, double p){
		numero = n;
		serie = s;
		dia_sorteig = new Fecha(f);
		preu = p;
	}
	
	public String toString() {
		return ("Loto: " +numero+ ", " +serie+ ", " +dia_sorteig+ ", " +preu);
	}
}

class exercici4{
	static int millorArea(int[][]territori) {
		
		int suma = 0;
		for(int i=0; i<territori.length; i++) {
			for(int j=0; j<territori[i].length; j++) {
				suma = suma + territori[i][j];
			}
			
		}
		return suma;
	}
}



public class Practica_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner(System.in);
		
		//EXERCICI 1
		
		String[] regals = {"monopoly","pilota","manual de java","bicicleta","abric"};
		double[] preus = {49.90,       15.35,         195,          69.99,    12};		
		
		String regalsComprar;
		
		System.out.print("Entra un preu: ");
        double preu = entrada.nextDouble();
        
        for (int i=0; i<preus.length;i++) {
        	if(preus[i]<=preu) {
        		System.out.println(regals[i]);
        	}
        }
        
        //EXERCICI 2
        
       String cgpj[]={"Carlos Lesmes Serrano","Rafael Fernández Valverde","Vicente Guilarte Gutierrez",
        	"Álvaro Cuesta Martínez","José Antonio Ballestero Pascual","Gerardo Martínez Tristán",
        	"Enrique Lucas Murillo de la Cueva","Clara Martínez de Careaga García","Juan Martínez Moya",
        	"Roser Bach Fabregó","Nuria Díaz Abad","Rafael Mozo Muelas","Wenceslao Francisco Olea Godoy",
        	"Carmen Llombart Pérez","Pilar Sepúlveda García de la Torre","María Concepción Sáez Rodríguez",
        	"Juan Manuel Fernández Martínez","María Victoria Cinto Lapuente","María del Mar Cabrejas Guijarro",
        	"José María Macías Castaño","María Ángeles Carmona Vergara","José Luis de Benito y Benítez de Lugo"};
		
       int posicion = (int) (Math.random() * cgpj.length);
       
       System.out.println("Entra el nou jutge: ");
       String nou_jutge = entrada.next();
       String antic_jutge = "";
       
       for (int i=0; i<cgpj.length; i++) {
    	   antic_jutge = cgpj[posicion];
       }
       
       System.out.println("Se elimina: " +antic_jutge);
       System.out.println("---------------------------");
       System.out.println("Nova llista: ");
       
       for (int i=0; i<cgpj.length; i++) {
    	   antic_jutge=nou_jutge;
    	   System.out.println(cgpj[i]);
       }
        
        //EXERCICI 3
        
		Loto[]lotos = {
				new Loto (1, 1, new Fecha("25/1/2011"), 6.90),
				new Loto (2, 1, new Fecha("30/4/2011"), 4.90),
				new Loto (5, 3, new Fecha("12/8/2011"), 2.75),
				new Loto (8, 6, new Fecha("11/11/2011"), 10.75),
		};
		
		System.out.print("Entra un numero de loto: ");
        int numero = entrada.nextInt();
        
        int correcto = -1;
        for (int i=0; i<lotos.length; i++) {
			if(numero == lotos[i].numero) {
				correcto = i;
			}
		}
        if (correcto!=-1) {
			System.out.println("El loto amb el numero " +lotos[correcto].numero+ " te un preu de " +lotos[correcto].preu);
		}else {
			System.out.println("Número no disponible");
		}
        
      //EXERCICI 4
        
		int[][] territori = { 
                { 0, 0, 0, 0, 3, 2, 1, 0 },
                { 0, 0, 0, 0, 0, 3, 1, 1 },
                { 0, 0, 0, 0, 1, 0, 1, 0 },
                { 0, 5, 0, 0, 0, 0, 0, 0 },
                { 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 3, 0, 2 },
                { 3, 0, 0, 0, 4, 2, 2, 0 },
                { 0, 2, 0, 1, 0, 2, 0, 2 }
        };
        
        System.out.println(exercici4.millorArea(territori));
       
	}
}
