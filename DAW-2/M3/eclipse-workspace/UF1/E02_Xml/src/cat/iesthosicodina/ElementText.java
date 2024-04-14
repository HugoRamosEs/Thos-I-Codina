package cat.iesthosicodina;

public class ElementText extends Element{
	private String text; 

	public ElementText(String contingut) {
		this.tag = null;
		this.atributs = null;
		this.text = contingut;
	}

	@Override
	public String toString() {
		return this.text;
	}
	
	
}
