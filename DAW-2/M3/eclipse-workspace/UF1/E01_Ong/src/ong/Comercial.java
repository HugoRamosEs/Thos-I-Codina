package ong;

import java.util.Arrays;

public class Comercial extends Treballador {
	private float incentius;
	private float[] vendes;

	public Comercial(String nom, String cognoms, String dni) {
		super(nom, cognoms, dni);
		// TODO Auto-generated constructor stub
	}

	public float getIncentius() {
		return incentius;
	}

	public float[] getVendes() {
		return vendes;
	}

	public void setIncentius(float incentius) {
		this.incentius = incentius;
	}

	public void setVendes(float[] vendes) {
		this.vendes = vendes;
	}

	@Override
	public String toString() {
		return super.toString() + "Comercial [incentius=" + incentius + ", vendes=" + Arrays.toString(vendes) + "]";
	}


	

}
