package barquitos;

import java.util.Objects;

public abstract class Nau extends Throwable implements Comparable {
	private static final long serialVersionUID = 1L;
	private Coordenada coordenada;
	private Direccio direccio;
	private int ocupacio;
	
	public Nau(Coordenada coordenada, Direccio direccio, int ocupacio) {
		super();
		this.coordenada = coordenada;
		this.direccio = direccio;
		this.ocupacio = ocupacio;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}

	public Direccio getDireccio() {
		return direccio;
	}

	public int getOcupacio() {
		return ocupacio;
	}

	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}

	public void setDireccio(Direccio direccio) {
		this.direccio = direccio;
	}

	public void setOcupacio(int ocupacio) {
		this.ocupacio = ocupacio;
	}
	
	@Override
	public String toString() {
		return "[coordenada=" + this.coordenada + ", direccio=" + this.direccio + ", ocupacio=" + this.ocupacio + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nau other = (Nau) obj;
		return Objects.equals(this.coordenada, other.getCoordenada()) && this.direccio == other.getDireccio() && this.ocupacio == other.getOcupacio();
	}

	@Override
	public int compareTo(Object obj) {
		if (this == obj)
			return 0;
		if (obj == null)
			throw new NullPointerException();
		if (getClass() != obj.getClass())
			throw new ClassCastException();
		Nau other = (Nau) obj;
		return 0;
	}
}
