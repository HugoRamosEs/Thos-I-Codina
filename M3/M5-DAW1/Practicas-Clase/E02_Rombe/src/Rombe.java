
public class Rombe {
	// ATRIBUTS
	private double diagonalMayor;
	private double diagonalMenor;
	private double x;
	private double y;
	
	// CONSTRUCTORS
	public Rombe(double diagonalMayor, double diagonalMenor, double x, double y) {
		this.diagonalMayor = diagonalMayor;
		this.diagonalMenor = diagonalMenor;
		this.x = x;
		this.y = y;
		
	}
	
	// MÉTODES
	public boolean estaDins(double x, double y) {
		
		// MOURE EL ROMBE AL CENTRE DE L'EIX (0,0)
		this.x = 0;
		this.y = 0;
		
		// MOURE EL PUNT A LA POSICIO RELATIVA A L'EIX (0,0)
		x = x - this.x;
		y = y - this.y;

		// TRANSFORMACIÓ A VALORS ABSOLUTS
		double absolutX = Math.abs(x);
		double absolutY = Math.abs(y);
		
		// CREACIÓ DE PUNTS
		Punt a = new Punt (0,0);
		Punt d = new Punt (diagonalMenor / 2, 0);
		Punt e = new Punt (0, diagonalMayor / 2);
		
		// CÀLCUL
		double w1 = (e.x * (a.y - absolutY) + e.y * (absolutX - a.x)) / (d.x * e.y - d.y * e.x);
		double w2 = (absolutY - a.y - w1 * d.y) / e.y;

		// CONDICIÓ I RESULTAT
		boolean pointInTriangle = (w1 >= 0.0) && (w2 >= 0.0) && ((w1 + w2) <= 1.0);
		
		if(pointInTriangle) {
			System.out.println("El punt esta dins del rombe.");
			return true;
		}
		else {
			System.out.println("El punt no esta dins del rombe.");
			return false;
		}
		
	}
	
	// GETTERS I SETTERS
	public double getDiagonalMayor() {
		return diagonalMayor;
	}

	public double getDiagonalMenor() {
		return diagonalMenor;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setDiagonalMayor(double diagonalMayor) {
		this.diagonalMayor = diagonalMayor;
	}

	public void setDiagonalMenor(double diagonalMenor) {
		this.diagonalMenor = diagonalMenor;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}
	
}