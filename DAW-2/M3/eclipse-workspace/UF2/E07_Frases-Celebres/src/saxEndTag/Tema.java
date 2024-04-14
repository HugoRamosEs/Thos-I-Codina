package saxEndTag;

public class Tema {
	private String text;
	
	public Tema() {}

	public Tema(String texto) {
		this.text = texto;
	}

	public String getText() {
		return text;
	}

	public void setText(String texto) {
		this.text = texto;
	}

	@Override
	public String toString() {
		return "["+this.text+"]";
	}

	@Override
	public boolean equals(Object obj) {
		Tema t = (Tema)obj;
		return this.text.equals(t.getText());
	}
	
	


}
