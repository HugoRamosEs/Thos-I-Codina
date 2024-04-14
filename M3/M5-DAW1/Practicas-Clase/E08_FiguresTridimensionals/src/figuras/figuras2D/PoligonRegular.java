package figuras.figuras2D;

public class PoligonRegular implements Figura {
	private int numCostats;
	private int longCostats;
	
	public PoligonRegular(int numCostats, int longCostats) throws Exception {
		if (numCostats>=3 && longCostats>=0) {
			this.numCostats = numCostats;
			this.longCostats = longCostats;
		} else {
			throw new Exception("Dades erronies");
		}
	}

	public double calculaPerimetre () {
		return this.numCostats * this.longCostats;
	}
	
	public double calculaArea () {
		return (this.numCostats * Math.pow(this.longCostats,2))/( 4*Math.tan(Math.toRadians(180/this.numCostats)));
	}
	
	
	// Getters i setters
	public int getNumCostats() {
		return numCostats;
	}

	public void setNumCostats(int numCostats) {
		this.numCostats = numCostats;
	}

	public int getLongCostats() {
		return longCostats;
	}

	public void setLongCostats(int longCostats) {
		this.longCostats = longCostats;
	}

	@Override
	public String toString() {
		return "PoligonRegular [numCostats=" + numCostats + ", longCostats="
				+ longCostats + "]";
	}
	
	

}
