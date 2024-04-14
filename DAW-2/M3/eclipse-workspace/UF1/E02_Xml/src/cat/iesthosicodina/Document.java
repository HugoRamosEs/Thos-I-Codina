package cat.iesthosicodina;

public class Document {
	private String proleg;	//opcional
	private Element cos;
	
	public Document(String proleg, Element cos) {
		this.proleg = proleg;
		this.cos = cos;
	}
	public String getProleg() {
		return proleg;
	}
	public Element getCos() {
		return cos;
	}
	public void setProleg(String proleg) {
		this.proleg = proleg;
	}
	public void setCos(Element cos) {
		this.cos = cos;
	}
	@Override
	public String toString() {
		String resultat = (this.proleg==null) ? "" : this.proleg + "\n";
		resultat += this.cos;
		return resultat;
	}
	
	
	
	
}
