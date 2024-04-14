package figuras.figuras2D;

public class Pentagon extends PoligonRegular {

	public Pentagon(int longCostat) throws Exception {
		super(5, longCostat);
	}
	
	@Override
	public String toString() {
		return "Pentagon [costat=" + super.getLongCostats() + "]";
	}
}
