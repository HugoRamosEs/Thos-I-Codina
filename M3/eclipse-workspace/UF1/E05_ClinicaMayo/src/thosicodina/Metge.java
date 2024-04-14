package thosicodina;

public class Metge {
	private String nom;

	public Metge(String nom) {
		this.nom = nom;
	}
	
	public String demanarHemogramaEspecific(Hemograma h) {
		Hemograma especific = new Hemograma(h.getPacient(), h.getMetge(), h.getData());
		return especific.toString() 
				+ "+-----------------------------------------------------+\n"
				+ "+                      ESPECIFIC                      +\n"
				+ "+-----------------------------------------------------+\n"
				+ h.toString();
	}
	
	public String demanarHemogramaAnalitic(Eritrocits e, Leucocits l, Trombocits t, Volum vol, Velocitat vel) {
		Analitic analitic = new Analitic(e.getPacient(), e.getMetge(), e.getData());
		return analitic.toString() + e.toString() + l.toString() + t.toString() + vol.toString() + vel.toString();
	}
	
	public String demanarHemogramaBioquimic(Substancies s, Minerals m) {
		Bioquimic bioquimic = new Bioquimic(s.getPacient(), s.getMetge(), s.getData());
		return bioquimic.toString() + s.toString() + m.toString();
	}
	
	public String demanarHemogramaComplet(Eritrocits e, Leucocits l, Trombocits t, Volum vol, Velocitat vel, Substancies s, Minerals m) {
		Analitic analitic = new Analitic(e.getPacient(), e.getMetge(), e.getData());
		return analitic.toString() + e.toString() + l.toString() + t.toString() + vol.toString() + vel.toString() 
		+ "+-----------------------------------------------------+\n"
		+ "+                      BIOQUIMIC                      +\n"
		+ "+-----------------------------------------------------+\n"
		+ s.toString() + m.toString();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Metge: " + this.nom + "\n";
	}
}
