import java.util.Scanner;

/*
 
Programa que realiza el juego de los 3 barriles.
 
Dicho juego comienza con 3 barriles de 8, 5 y 3 litros de capacidad
respectivamente, de los cuales el primero está lleno y los otros dos
vacíos.
 
El objetivo es conseguir 4 litros en alguno de los barriles sin utilizar
ningún otro recipiente de medida, simplemente vertiendo el contenido de
un barril a otro.
 
Para realizar el juego el programa debe contar con un array de 3 objetos
del tipo Barril. Esta clase debe disponer de los campos capacidad y contenido.
 
 
Salida del programa :
-------------------------------------
 
Movimientos : 0
 
Barril 1 --> 8 litros
Barril 2 --> 0 litros
Barril 3 --> 0 litros
 
Que barril cogemos ? 1
Que barril llenamos ? 2
 
Movimientos : 1
 
Barril 1 --> 3 litros
Barril 2 --> 5 litros
Barril 3 --> 0 litros
 
Que barril cogemos ? 2
Que barril llenamos ? 3
 
Movimientos : 2
 
Barril 1 --> 3 litros
Barril 2 --> 2 litros
Barril 3 --> 3 litros
 
Que barril cogemos ?
 
.....
 
*/

class Barril {
	int capacidad;
	int contenido;

	Barril() {

	}

	Barril(int cap, int cont) {
		capacidad = cap;
		contenido = cont;
	}

	public String toString() {
		return (capacidad + " ---> " + contenido);
	}

	void traspasoLitros(Barril b) {
		int espacioDestino = b.capacidad - b.contenido;
		if (this.contenido <= espacioDestino) { //Todo el contenido cabe en B
			b.contenido = b.contenido + this.contenido;
			this.contenido = 0;
		} else { //No todo cabe en B
			this.contenido = this.contenido - espacioDestino;
			b.contenido = b.capacidad;
		}
	}

	public class E11_Barriles {

		public static void main(String[] args) {
			// TODO Auto-generated method stub

			Scanner entrada = new Scanner(System.in);
			Barril[] barriles = { new Barril(8, 8), new Barril(5, 0), new Barril(3, 0) };

			do {
				System.out.println("Que barril cogemos?: ");
				int origen = entrada.nextInt();
				System.out.println("Que barril llenamos?: ");
				int destino = entrada.nextInt();

				barriles[origen - 1].traspasoLitros(barriles[destino - 1]);
				
				estadoPartida(barriles);

			} while (barriles[0].contenido != 4 || barriles[1].contenido != 4);
		}

		static void estadoPartida(Barril[] barriles) {
			for (int i = 0; i < barriles.length; i++) {
				System.out.println("Barril: " + (i + 1) + " " + barriles[i]);
			}
		}
	}

}