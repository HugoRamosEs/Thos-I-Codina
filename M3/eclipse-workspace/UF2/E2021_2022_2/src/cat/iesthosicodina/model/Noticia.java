package cat.iesthosicodina.model;

import java.util.Date;

public class Noticia {
	private Integer id;
	private String titol;
	private Date data;
	private String text;
	private String enllac;
	private String clau;
	private String ambit;
	private String entitat;
	private String paraules;
	
	public Noticia() {
	}

	public Noticia(Integer id, String titol, Date data, String text, String enllac, String clau, String ambit,
			String entitat, String paraules) {
		this.id = id;
		this.titol = titol;
		this.data = data;
		this.text = text;
		this.enllac = enllac;
		this.clau = clau;
		this.ambit = ambit;
		this.entitat = entitat;
		this.paraules = paraules;
	}
	public Integer getId() {
		return id;
	}
	public String getTitol() {
		return titol;
	}
	public Date getData() {
		return data;
	}
	public String getText() {
		return text;
	}
	public String getEnllac() {
		return enllac;
	}
	public String getClau() {
		return clau;
	}
	public String getAmbit() {
		return ambit;
	}
	public String getEntitat() {
		return entitat;
	}
	public String getParaules() {
		return paraules;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setTitol(String titol) {
		this.titol = titol;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public void setText(String text) {
		this.text = text;
	}
	public void setEnllac(String enllac) {
		this.enllac = enllac;
	}
	public void setClau(String clau) {
		this.clau = clau;
	}
	public void setAmbit(String ambit) {
		this.ambit = ambit;
	}
	public void setEntitat(String entitat) {
		this.entitat = entitat;
	}
	public void setParaules(String paraules) {
		this.paraules = paraules;
	}

	@Override
	public String toString() {
		return "Noticia [id=" + id + ", titol=" + titol + "]";
	}

}
