package joc;

import java.util.Objects;

public class Vaixell extends Throwable implements Comparable<Vaixell>{ // Throwable no se puede implemetar,
																					// porque es una clase, por lo tanto
																					// solo se puede extender.
	private static final long serialVersionUID = 1L; // Esto se pone porque Throwable implementa Serializable.
	private int tamany;
	private Coordenada posicio;
	private Direccio direccio;

	public Vaixell(int tamany) {
		this.tamany = tamany;
	}

	public Vaixell(Coordenada posicio, int tamany) {
		this.posicio = posicio;
	}

	public int getTamany() {
		return tamany;
	}

	public Coordenada getPosicio() {
		return posicio;
	}

	public Direccio getDireccio() {
		return direccio;
	}

	public void setPosicio(Coordenada posicio, Direccio direccio) {
		this.posicio = posicio;
		this.direccio = direccio;
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
		return direccio == other.direccio && Objects.equals(posicio, other.posicio) && tamany == other.tamany;
	}

	@Override
	public int compareTo(Vaixell o) {
		// TODO Auto-generated method stub
		return 0;
	}


}
