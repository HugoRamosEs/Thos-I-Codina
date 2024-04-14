package figures;

public class Main {

	public static void main(String[] args) {
		Figura[] figures = new Figura[6];
		
		figures[0] = new Cercle(1);
		figures[1] = new Corona(2,1);
		figures[2] = new PoligonRegular(5,4);
		figures[3] = new Rectangle(2,3);
		figures[4] = new Quadrat(3);
		figures[5] = new Pentagon(4);
		
		for (int i=0; i<figures.length; i++) {
			System.out.println(figures[i].getClass().getSimpleName());
		    System.out.println("Area: " + String.format("%.2f", figures[i].calculaArea()));
		    System.out.println("Perimetre: " + String.format("%.2f", figures[i].calculaPerimetre()));
		    System.out.println();
		}
	}
}

