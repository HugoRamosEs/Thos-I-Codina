package saxEndTag;

import java.util.ArrayList;
import java.util.List;

public class Frase {
	private String text;
	private ArrayList<Tema> temes;
	
	//constructor
	public  Frase() {
		this.temes = new ArrayList<Tema>();
	}
	public Frase(String texto) {
		this.text = texto;
		this.temes = new ArrayList<Tema>();
	}
	
	//gettes i setters
	public String getTexto() {
		return text;
	}

	public void setTexto(String texto) {
		this.text = texto;
	}

	public List<Tema> getTemas() {
		return temes;
	}
	
	public void setTemes(ArrayList<Tema> temes) {
		this.temes = temes;
	}

	public void addTema(Tema tema) {
		this.temes.add(tema);
	}

	@Override
	public String toString() {
		String retorno = this.text;
		for (Tema a : this.temes) {
			retorno += a.toString();
		}
		return retorno;
	}
	@Override
	public boolean equals(Object obj) {
		Frase f = (Frase)obj;
		return this.text.equals(f.getTexto());
	}

	
}
