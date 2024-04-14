package thosi;

public class Angle {
	private int grau;
	private int minut;
	private int segon;
	
	public Angle(int grau, int minut, int segon) {
		this.grau = grau;
		this.minut = minut;
		this.segon = segon;
	}
	
	public void normalitzar() {
	    if (this.segon >= 60) {
	        this.minut += this.segon / 60;
	        this.segon %= 60;
	    } 
	    if (this.segon < 0) {
	    	int mARestar = Math.abs(this.segon / 60) + 1;
	    	this.minut -= mARestar;
	    	this.segon = 60 + this.segon % 60;
	    }

	    if (this.minut >= 60) {
	        this.grau += this.minut / 60;
	        this.minut %= 60;
	    } 
	    if (this.minut < 0) {
	    	int hARestar = Math.abs(this.minut / 60) + 1;
	    	this.grau -= hARestar;
	        this.minut = 60 - Math.abs(this.minut % 60);
	    }

	    if (this.grau > 360) {
	        this.grau %= 360;
	    }
	    if (this.grau < 0) {
	        this.grau = 360 - Math.abs(this.grau % 360);
	    }
	}
	
	public int getGrau() {
		return grau;
	}
	public int getMinut() {
		return minut;
	}
	public int getSegon() {
		return segon;
	}
	public void setGrau(int grau) {
		this.grau = grau;
	}
	public void setMinut(int minut) {
		this.minut = minut;
	}
	public void setSegon(int segon) {
		this.segon = segon;
	}
	
	@Override
	public String toString() {
		return String.format("%02d:%02d:%02d", this.grau, this.minut, this.segon);
	}
}
