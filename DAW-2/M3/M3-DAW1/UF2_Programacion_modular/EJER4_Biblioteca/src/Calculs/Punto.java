package Calculs;

public class Punto {
	double x;
	double y;
	
	public Punto(){
		
	}
	
	public Punto(double x, double y){
		this.x=x;
		this.y=y;
	}
	
	public String toString() {
		return "("+x+", "+y+")";
	}
	
	public double distancia (Punto p) {
		double d;
		double restax = this.x - p.x;
		double restay = this.y - p.y;
		d = Math.sqrt(Math.pow(restax, 2) + Math.pow(restay, 2));
		return d;
	}
	
}
