import java.util.Objects;

public class Vaixell extends Throwable implements Comparable {
	private static final long serialVersionUID = -8090821281067967025L;
	private Coordenada coordenada;
	private int tamany;
	private Direccio direccio;
	
	public Vaixell(Coordenada coordenada, int tamany) {
		super();
		this.coordenada = coordenada;
		this.tamany = tamany;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}

	public int getTamany() {
		return tamany;
	}

	public Direccio getDireccio() {
		return direccio;
	}

	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}

	public void setTamany(int tamany) {
		this.tamany = tamany;
	}

	public void setDireccio(Direccio direccio, Coordenada coordenada) {
		this.direccio = direccio;
		this.coordenada = coordenada;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vaixell other = (Vaixell) obj;
		return Objects.equals(coordenada, other.coordenada) && direccio == other.direccio && tamany == other.tamany;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
