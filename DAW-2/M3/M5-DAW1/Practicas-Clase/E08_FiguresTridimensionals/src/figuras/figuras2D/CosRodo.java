package figuras.figuras2D;

public abstract class CosRodo implements Figura{
	protected int radi;
	
	public CosRodo() {}
	public CosRodo(int radi) throws Exception{
		if (radi >=0) {
			this.radi=radi;
		} else {
			throw new Exception ("Tamany incorrecte");
		}
		
	}
	
	public double calculaArea() {
		return Math.PI*Math.pow(this.radi,2);
	}
	
	public double calculaPerimetre() {
		return 2*Math.PI*this.radi;
	}
	
	// Getters i Setters
	public int getRadi() {
		return radi;
	}

	public void setRadi(int radi) {
		this.radi = radi;
	}

	@Override
	public String toString() {
		return "Cos Rodó [radi=" + radi + "]";
	}
	
	

}
