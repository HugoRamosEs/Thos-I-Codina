
class Punto3D {
	double x;
	double y;
	double z;

	Punto3D() {

	}

	Punto3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public String toString() {
		return "("+x+", "+y+", "+z+")";
	}

	double distancia(Punto3D p) {
		double dist;
		double restax = this.x - p.x;
		double restay = this.y - p.y;
		double restaz = this.z - p.z;
		dist = Math.sqrt(Math.pow(restax, 2) + Math.pow(restay, 2) + Math.pow(restaz, 2));
		return dist;
	}
}

public class E05_DistanciaPuntos3D {

	public static void main(String[] args) {
		/*
		 * 
		 * Programa que calcula la distancia entre dos puntos del espacio donde cada
		 * punto tiene 3 coordenadas : x, y, z. El programa trabaja con objetos del tipo
		 * Punto3D cuyos valores se entran por teclado.
		 * ___________________________________________ Ayuda : d = √ ( x2 - x1 )² + ( y2
		 * - y1 )² + ( z2 - z1 )²
		 * 
		 * Salida del programa: ------------------------------ Entra las coordenadas del
		 * punto A separadas por coma: 0,0,0 Entra las coordenadas del punto B separadas
		 * por coma: 1,1,1
		 * 
		 * La distancia entre los puntos es 1,73
		 * 
		 */
		Punto3D a = new Punto3D(5,1.5,6);
		Punto3D b = new Punto3D(1,-2.1,1);
		
		
		System.out.println("Punto a = "+a);
		System.out.printf("Punto b = %s\n", b);
		
		System.out.println("La distancia entre los puntos a y b es: " +a.distancia(b));
		
	}

}
