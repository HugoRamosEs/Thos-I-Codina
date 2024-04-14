package thosicodina;

import java.time.LocalDate;

public class Substancies extends Bioquimic {
	private double glucosa;
	private double triglicerids;
	private double transaminases;
	private double colesterol;
	private double hdl;
	private double ldl;
	private double bilirubina;
	private double creatinina;
	private double fosfatasaAlcalina;
	private double urea;
	private double acidUric;
	
	public Substancies(Pacient pacient, Metge metge, LocalDate data, double glucosa, double triglicerids, double transaminases,
			double colesterol, double hdl, double ldl, double bilirubina, double creatinina, double fosfatasaAlcalina, double urea,
			double acidUric) {
		super(pacient, metge, data);
		this.glucosa = glucosa;
		this.triglicerids = triglicerids;
		this.transaminases = transaminases;
		this.colesterol = colesterol;
		this.hdl = hdl;
		this.ldl = ldl;
		this.bilirubina = bilirubina;
		this.creatinina = creatinina;
		this.fosfatasaAlcalina = fosfatasaAlcalina;
		this.urea = urea;
		this.acidUric = acidUric;
	}

	public double getGlucosa() {
		return glucosa;
	}

	public double getTriglicerids() {
		return triglicerids;
	}

	public double getTransaminases() {
		return transaminases;
	}

	public double getColesterol() {
		return colesterol;
	}

	public double getHdl() {
		return hdl;
	}

	public double getLdl() {
		return ldl;
	}

	public double getBilirubina() {
		return bilirubina;
	}

	public double getCreatinina() {
		return creatinina;
	}

	public double getFosfatasaAlcalina() {
		return fosfatasaAlcalina;
	}

	public double getUrea() {
		return urea;
	}

	public double getAcidUric() {
		return acidUric;
	}

	public void setGlucosa(double glucosa) {
		this.glucosa = glucosa;
	}

	public void setTriglicerids(double triglicerids) {
		this.triglicerids = triglicerids;
	}

	public void setTransaminases(double transaminases) {
		this.transaminases = transaminases;
	}

	public void setColesterol(double colesterol) {
		this.colesterol = colesterol;
	}

	public void setHdl(double hdl) {
		this.hdl = hdl;
	}

	public void setLdl(double ldl) {
		this.ldl = ldl;
	}

	public void setBilirubina(double bilirubina) {
		this.bilirubina = bilirubina;
	}

	public void setCreatinina(double creatinina) {
		this.creatinina = creatinina;
	}

	public void setFosfatasaAlcalina(double fosfatasaAlcalina) {
		this.fosfatasaAlcalina = fosfatasaAlcalina;
	}

	public void setUrea(double urea) {
		this.urea = urea;
	}

	public void setAcidUric(double acidUric) {
		this.acidUric = acidUric;
	}

	@Override
	public String toString() {
		double minTransaminases = super.getPacient().esHome() ? 10 : 7;
		double maxTransaminases = super.getPacient().esHome() ? 40 : 35;
		double minCreatinina = super.getPacient().esHome() ? 0.7 : 0.6;
		double maxCreatinina = super.getPacient().esHome() ? 1.3 : 1.1;
		
		return "GLUCOSA " + this.glucosa + " mg/dL ( 76 - 140 )\n"
				+ "TRIGLICÈRIDS " + this.triglicerids + " mg/dL ( 50 - 150 )\n"
				+ "TRANSAMINASES " + this.transaminases + " UI/L ( " + minTransaminases + " - " + maxTransaminases + " )\n"
				+ "COLESTEROL " + this.colesterol + " mg/dL ( 125 - 200 )\n"
				+ "HDL " + this.hdl + " mg/dL ( 40 - 75 )\n"
				+ "LDL " + this.ldl + " mg/dL ( 100 - 130 )\n"
				+ "BILIRUBINA " + this.bilirubina + " mg/dL ( 0.1 - 1.2 )\n"
				+ "CREATININA " + this.creatinina + " UI/L ( " + minCreatinina + " - " + maxCreatinina + " )\n"
				+ "FOSFATASA ALCALINA " + this.fosfatasaAlcalina + " UI/L ( 44 - 147 )\n"
				+ "UREA " + this.urea + " mg/dL ( 12 - 54 )\n"
				+ "ÀCID ÚRIC " + this.acidUric + " mg/dL ( 3.5 - 7.2 )\n";
	}
}
