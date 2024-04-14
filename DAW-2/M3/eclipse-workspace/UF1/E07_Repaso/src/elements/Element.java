package elements;

import java.util.Objects;

public abstract class Element implements Comparable {
	private int protons;
	private int neutrons;
	private int electrons;
	
	public Element(int protons, int neutrons, int electrons) {
		super();
		this.protons = protons;
		this.neutrons = neutrons;
		this.electrons = electrons;
	}
	
	public Element(int neutrons) {
		this(0, neutrons, 0);
	}

	public int getProtons() {
		return protons;
	}

	public int getNeutrons() {
		return neutrons;
	}

	public int getElectrons() {
		return electrons;
	}

	public void setProtons(int protons) {
		this.protons = protons;
	}

	public void setNeutrons(int neutrons) {
		this.neutrons = neutrons;
	}

	public void setElectrons(int electrons) {
		this.electrons = electrons;
	}

	@Override
	public String toString() {
		return "[protons=" + this.protons + ", neutrons=" + this.neutrons + ", electrons=" + this.electrons + "]";
	}

	@Override
	public int compareTo(Object obj) {
		if (this == obj)
			return 0;
		if (obj == null)
			throw new NullPointerException();
		if (getClass() != obj.getClass())
			throw new ClassCastException();
		Element other = (Element) obj;
		if (this.protons < other.getNeutrons()) {
			return -1;
		}
		if (this.neutrons > other.getNeutrons()) {
			return 1;
		}
		return 0;
	}
}
