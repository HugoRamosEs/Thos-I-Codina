package ong;

public class Adreca {
	private String carrer;
	private String numero;
	private String escala;
	private String pis;
	private String porta;
	private String codiPostal;
	private String poblacio;
	private String provincia;
	private String pais;
	
	public Adreca(String carrer, String numero, String escala, String pis, String porta, String codiPostal,
			String poblacio, String provincia, String pais) {
		this.carrer = carrer;
		this.numero = numero;
		this.escala = escala;
		this.pis = pis;
		this.porta = porta;
		this.codiPostal = codiPostal;
		this.poblacio = poblacio;
		this.provincia = provincia;
		this.pais = pais;
	}

	public String getCarrer() {
		return carrer;
	}

	public String getNumero() {
		return numero;
	}

	public String getEscala() {
		return escala;
	}

	public String getPis() {
		return pis;
	}

	public String getPorta() {
		return porta;
	}

	public String getCodiPostal() {
		return codiPostal;
	}

	public String getPoblacio() {
		return poblacio;
	}

	public String getProvincia() {
		return provincia;
	}

	public String getPais() {
		return pais;
	}

	public void setCarrer(String carrer) {
		this.carrer = carrer;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setEscala(String escala) {
		this.escala = escala;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public void setPorta(String porta) {
		this.porta = porta;
	}

	public void setCodiPostal(String codiPostal) {
		this.codiPostal = codiPostal;
	}

	public void setPoblacio(String poblacio) {
		this.poblacio = poblacio;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return carrer + ", " + numero + ", esc " + escala + ", " + pis + ", "
				+ porta + "\n" + codiPostal + ", " + poblacio + " ( " + provincia
				+ ") \n" + pais ;
	}
	
	
	
	
}
