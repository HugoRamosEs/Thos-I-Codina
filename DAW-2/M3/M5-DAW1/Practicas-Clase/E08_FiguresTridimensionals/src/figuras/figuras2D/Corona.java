package figuras.figuras2D;

public class Corona extends CosRodo {
	private int radiInterior;
	
	public Corona(int radi1, int radi2) throws Exception {
		if ((radi1 >= 0) && (radi2 >=0)){
			if (radi1 > radi2) {
				this.radi = radi1;
				this.radiInterior = radi2;
			} else {
				this.radi = radi2;
				this.radiInterior = radi1;				
			}
		} else {
			throw new Exception ("Tamany incorrecte");
		}
	}
	
	public double calculaArea() {
		return (super.calculaArea() - Math.PI*Math.pow(this.radiInterior,2));
	}
	
	// Getters i Setters
	public int getRadiExterior() {
		return super.getRadi();
	}

	public void setRadiExterior(int radiExterior) {
		super.setRadi(radiExterior);
	}

	public int getRadiInterior() {
		return this.radiInterior;
	}
	public void setRadiInterior(int radiInterior) {
		this.radiInterior = radiInterior;
	}

	@Override
	public String toString() {
		return "Corona [radiExterior=" + super.getRadi() + ", radiInterior=" + radiInterior + "]";
	}
	
	
	

}
