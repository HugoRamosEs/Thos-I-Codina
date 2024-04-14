package sax;

public class Frase {
	private String text;
	private Tema tema;
	private Autor autor;
	
	public String getText() {
		return text;
	}
	public Tema getTema() {
		return tema;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setText(String text) {
		this.text = text;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	public String toString() {
		return this.text;
	}
}
