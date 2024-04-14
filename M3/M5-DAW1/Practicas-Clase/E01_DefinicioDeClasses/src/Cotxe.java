
public class Cotxe {
	//ATRIBUTS
	private int color;
	private int any;
	private int kmRecorreguts;
	private String marca;
	private String model;
	private String tipusCombustible;
	private String matricula;
	
	//CONSTRUCTORS
	public Cotxe() {
		
	}
	
	public Cotxe(int color, int any, int kmRecorreguts, String marca, String model, String tipusCombustible, String matricula) {
		this.color = color;
		this.any = any;
		this.kmRecorreguts = kmRecorreguts;
		this.marca = marca;
		this.model = model;
		this.tipusCombustible = tipusCombustible;
		this.matricula = matricula;
	}
	
	// GETTERS I SETTERS
	public int getColor() {
		return color;
	}

	public int getAny() {
		return any;
	}

	public int getKmRecorreguts() {
		return kmRecorreguts;
	}

	public String getMarca() {
		return marca;
	}

	public String getModel() {
		return model;
	}

	public String getTipusCombustible() {
		return tipusCombustible;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public void setAny(int any) {
		this.any = any;
	}

	public void setKmRecorreguts(int kmRecorreguts) {
		this.kmRecorreguts = kmRecorreguts;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setTipusCombustible(String tipusCombustible) {
		this.tipusCombustible = tipusCombustible;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	//METODES
	public String obtenirDades(int color, int any, int kmRecorreguts, String marca, String model, String tipusCombustible, String matricula) {
		String descripcioCompleta = " ";
		//CODI PER OBTENIR LES DADES
		return descripcioCompleta;
	}
	
	public String canviarMatricula(String matricula) {
		String novaMatricula = " ";
		//CODI PER CANVIAR LA MATRICULA
		return novaMatricula;
	}
	
	public int canviarColor(int color) {
		int nouColor = 0;
		//CODI PER CANVIAR EL COLOR
		return nouColor;
	}
	
	public int dataUs(int any) {
		int data = 0;
		//CODI PER CALCULAR ELS ANYS D'US
		return data;
	}
	
	public int reiniciarKm(int kmRecorreguts) {
		kmRecorreguts = 0;
		return kmRecorreguts;
	}

}
