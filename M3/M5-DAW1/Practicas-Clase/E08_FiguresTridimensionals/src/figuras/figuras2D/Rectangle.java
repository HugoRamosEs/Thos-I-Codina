package figuras.figuras2D;

public class Rectangle extends PoligonIrregular{
	private int costatCurt;
	private int costatLlarg;
	
	public Rectangle(int costat1, int costat2) throws Exception {
		super();
		if (costat1 >=0 && costat2 >=0) {
			if (costat1<costat2) {
				this.costatCurt = costat1;
				this.costatLlarg = costat2;
			} else {
				this.costatCurt = costat2;
				this.costatLlarg = costat1;
			}
		} else {
			throw new Exception ("Dades errónies");
		}
	}
	
	public double calculaPerimetre () {
		return 2 * (this.costatCurt + this.costatLlarg);
	}
	
	public double calculaArea(){
		return this.costatCurt * this.costatLlarg;
	}
	
	// Getters and Setters
	public int getCostatCurt() {
		return costatCurt;
	}

	public void setCostatCurt(int costatCurt) {
		this.costatCurt = costatCurt;
	}

	public int getCostatLlarg() {
		return costatLlarg;
	}

	public void setCostatLlarg(int costatLlarg) {
		this.costatLlarg = costatLlarg;
	}

	@Override
	public String toString() {
		return "Rectangle [costatCurt=" + costatCurt + ", costatLlarg="	+ costatLlarg + "]";
	}
	
	
	

	
	

}
