package sax;

public class Arxiu {
	private String path;
	private String descripcio;
	
	public Arxiu(String path, String descripcio) {
		super();
		this.path = path;
		this.descripcio = descripcio;
	}

	public String getPath() {
		return path;
	}

	public String getDescripcio() {
		return descripcio;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}
	
	
}
