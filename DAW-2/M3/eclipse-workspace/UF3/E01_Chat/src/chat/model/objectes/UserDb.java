package chat.model.objectes;

/**
 * Classe que representa a l'usuari que realitza la connexió amb la base de dades.
 * 
 * @version 1.0
 * @author Hugo
 */
public class UserDb {
	/**
	 * Host de la base de dades.
	 */
	private String host;
	
	/**
	 * Usuari de la base de dades.
	 */
	private String user;
	
	/**
	 * Contrasenya de la base de dades.
	 */
	private String password;
	
	/**
	 * Nom de la base de dades.
	 */
	private String db;
	
	/**
	 * Constructor que crea una instancia de l'usuari de la base de dades amb el
	 * host, l'usuari, la contrasenya i el nom de la base de dades.
	 * 
	 * @param host Host de la base de dades.
	 * @param user Usuari de la base de dades.
	 * @param password Contrasenya de la base de dades.
	 * @param db Nom de la base de dades.
	 */
	public UserDb(String host, String user, String password, String db) {
		this.host = host;
		this.user = user;
		this.password = password;
		this.db = db;
	}

	/**
	 * Getter que retorna el host de la base de dades.
	 * 
	 * @return Host de la base de dades.
	 */
	public String getHost() {
		return host;
	}
	
	/**
	 * Getter que retorna l'usuari de la base de dades.
	 * 
	 * @return Usuari de la base de dades.
	 */
	public String getUser() {
		return user;
	}
	
	/**
	 * Getter que retorna la contrasenya de la base de dades.
	 * 
	 * @return Contrasenya de la base de dades.
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Getter que retorna el nom de la base de dades.
	 * 
	 * @return Nom de la base de dades.
	 */
	public String getDb() {
		return db;
	}
	
	/**
	 * Setter que modifica el host de la base de dades.
	 * 
	 * @param host Host de la base de dades.
	 */
	public void setHost(String host) {
		this.host = host;
	}
	
	/**
	 * Setter que modifica l'usuari de la base de dades.
	 * 
	 * @param user Usuari de la base de dades.
	 */
	public void setUser(String user) {
		this.user = user;
	}
	
	/**
	 * Setter que modifica la contrasenya de la base de dades.
	 * 
	 * @param password Contrasenya de la base de dades.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Setter que modifica el nom de la base de dades.
	 * 
	 * @param db Nom de la base de dades.
	 */
	public void setDb(String db) {
		this.db = db;
	}
}
