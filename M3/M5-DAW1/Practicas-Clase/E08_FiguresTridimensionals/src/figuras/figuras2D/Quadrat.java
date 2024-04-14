package figuras.figuras2D;

public class Quadrat extends PoligonRegular{

	public Quadrat(int costat) throws Exception {
		super(4, costat);
	}

	@Override
	public String toString() {
		return "Quadrat [costat=" + super.getLongCostats() + "]";
	}
	
	

}
