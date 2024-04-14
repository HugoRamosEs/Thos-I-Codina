package cat.iesthosicodina;

public class ElementSimple extends Element{

	public ElementSimple(String tag) {
		this.tag = tag;
	}
	
	public ElementSimple(String tag, String contingut) {
		this.tag = tag;
		this.setContingut(contingut);
	}
	
	public ElementSimple(String tag, Atribut[] atributs, String contingut) {
		this.tag = tag;
		this.setAtributs(atributs);
		this.setContingut(contingut);
	}	
	
	public void setContingut(String contingut) {
		if (contingut != null) {
			this.contingut = new Element[1];
			this.contingut[0] = new ElementText(contingut);
		}
	}
}
