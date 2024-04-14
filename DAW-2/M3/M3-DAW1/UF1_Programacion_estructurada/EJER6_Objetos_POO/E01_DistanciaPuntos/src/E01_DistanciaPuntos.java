
class Punto {
	double x;
	double y;
	
	Punto(){
		
	}
	
	Punto(double x, double y){
		this.x=x;
		this.y=y;
	}
	
	public String toString() {
		return "("+x+", "+y+")";
	}
	
	double distancia (Punto p) {
		double d;
		double restax = this.x - p.x;
		double restay = this.y - p.y;
		d = Math.sqrt(Math.pow(restax, 2) + Math.pow(restay, 2));
		return d;
	}
	
}

public class E01_DistanciaPuntos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Punto a = new Punto(5,1.5);
		Punto b = new Punto(1,-2.1);
		Punto c = new Punto(7,5.6);
		
		
		System.out.println("Punto a = "+a);
		System.out.printf("Punto b = %s\n", b);
		System.out.printf("Punto c = %s\n", c);
		
		System.out.println("La distancia entre los puntos a y b es: " +a.distancia(b));
		System.out.println("La distancia entre los puntos b y c es: " +b.distancia(c));
	}

}
