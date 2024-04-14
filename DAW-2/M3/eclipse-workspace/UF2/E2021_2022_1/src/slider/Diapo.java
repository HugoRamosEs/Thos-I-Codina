package slider;

import java.awt.image.BufferedImage;

public class Diapo {
	private String titol;
	private BufferedImage imatge;
	/**
	 * @param titol
	 * @param imatge
	 */
	public Diapo(String titol, BufferedImage imatge) {
		this.titol = titol;
		this.imatge = imatge;
	}
	public String getTitol() {
		return titol;
	}
	public BufferedImage getImatge() {
		return imatge;
	}
	public void setTitol(String titol) {
		this.titol = titol;
	}
	public void setImatge(BufferedImage imatge) {
		this.imatge = imatge;
	}
}
