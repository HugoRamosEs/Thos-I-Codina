package pregunta3;

public class Canso {
	private String titol;
	private String artista;
	private String album;
	private String durada;
	private String genere;
	private String llansament;
	private String productor;
	private String lletra;

	public Canso(String titol, String artista, String album, String durada, String genere, String llansament,
			String productor, String lletra) {
		super();
		this.titol = titol;
		this.artista = artista;
		this.album = album;
		this.durada = durada;
		this.genere = genere;
		this.llansament = llansament;
		this.productor = productor;
		this.lletra = lletra;
	}

	public String getTitol() {
		return titol;
	}

	public String getArtista() {
		return artista;
	}

	public String getAlbum() {
		return album;
	}

	public String getDurada() {
		return durada;
	}

	public String getGenere() {
		return genere;
	}

	public String getLlansament() {
		return llansament;
	}

	public String getProductor() {
		return productor;
	}

	public String getLletra() {
		return lletra;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public void setDurada(String durada) {
		this.durada = durada;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public void setLlansament(String llansament) {
		this.llansament = llansament;
	}

	public void setProductor(String productor) {
		this.productor = productor;
	}

	public void setLletra(String lletra) {
		this.lletra = lletra;
	}

	@Override
	public String toString() {
		return "Canso [titol=" + titol + ", artista=" + artista + ", album=" + album + ", durada=" + durada
				+ ", genere=" + genere + ", llansament=" + llansament + ", productor=" + productor + ", lletra="
				+ lletra + "]";
	}
}
