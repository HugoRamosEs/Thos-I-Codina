package pregunta06;

public class ConfigDB {
	private String dsn;
	private String host;
	private String myweb;
	private String appuser;
	private String contrasenya;
	
	public ConfigDB(String dsn, String host, String myweb, String appuser, String contrasenya) {
		super();
		this.dsn = dsn;
		this.host = host;
		this.myweb = myweb;
		this.appuser = appuser;
		this.contrasenya = contrasenya;
	}

	public String getDsn() {
		return this.dsn;
	}

	public String getHost() {
		return this.host;
	}

	public String getMyweb() {
		return this.myweb;
	}

	public String getAppuser() {
		return this.appuser;
	}

	public String getContrasenya() {
		return this.contrasenya;
	}

	public void setDsn(String dsn) {
		this.dsn = dsn;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setMyweb(String myweb) {
		this.myweb = myweb;
	}

	public void setAppuser(String appuser) {
		this.appuser = appuser;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	
}
