package chat.model.objectes;

import java.sql.Timestamp;

/**
 * Classe que representa un usuari del xat.
 * 
 * @version 1.0
 * @author Hugo
 */
public class User {
	/**
	 * Nick de l'usuari.
	 */
	private String nick;
	
	/**
	 * Host de l'usuari.
	 */
	private String user_host;
	
	/**
	 * Data i hora en la que s'ha connectat l'usuari.
	 */
	private Timestamp date_con;
	
	/**
	 * Últim missatge llegit per l'usuari.
	 */
	private int last_read;
	
	/**
	 * Constructor que crea una instancia de l'usuari amb el nick.
	 * 
	 * @param nick Nick de l'usuari.
	 */
	public User(String nick) {
		this.nick = nick;
	}
	
	/**
	 * Constructor que crea una instancia de l'usuari amb el nick i la data de
	 * connexió.
	 * 
	 * @param nick Nick de l'usuari.
	 * @param date_con Data i hora en la que s'ha connectat l'usuari.
	 */
	public User(String nick, Timestamp date_con) {
		this.nick = nick;
		this.date_con = date_con;
	}
	
	/**
	 * Constructor que crea una instancia de l'usuari amb el nick, el host, la data
	 * de connexió i l'últim missatge llegit.
	 * 
	 * @param nick Nick de l'usuari.
	 * @param user_host Host de l'usuari.
	 * @param date_con  Data i hora en la que s'ha connectat l'usuari.
	 * @param last_read Últim missatge llegit per l'usuari.
	 */
	public User(String nick, String user_host, Timestamp date_con, int last_read) {
		this.nick = nick;
		this.user_host = user_host;
		this.date_con = date_con;
		this.last_read = last_read;
	}
	
	/**
	 * Getter que retorna el nick de l'usuari.
	 * 
	 * @return Nick de l'usuari.
	 */
	public String getNick() {
		return nick;
	}
	
	/**
	 * Getter que retorna el host de l'usuari.
	 * 
	 * @return Host de l'usuari.
	 */
	public String getUser_host() {
		return user_host;
	}
	
	/**
	 * Getter que retorna la data i hora en la que s'ha connectat l'usuari.
	 * 
	 * @return Data i hora en la que s'ha connectat l'usuari.
	 */
	public Timestamp getDate_con() {
		return date_con;
	}
	
	/**
	 * Getter que retorna l'últim missatge llegit per l'usuari.
	 * 
	 * @return Últim missatge llegit per l'usuari.
	 */
	public int getLast_read() {
		return last_read;
	}
	
	/**
	 * Setter que assigna el nick de l'usuari.
	 * 
	 * @param nick Nick de l'usuari.
	 */
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	/**
	 * Setter que assigna el host de l'usuari.
	 * 
	 * @param user_host Host de l'usuari.
	 */
	public void setUser_host(String user_host) {
		this.user_host = user_host;
	}
	
	/**
	 * Setter que assigna la data i hora en la que s'ha connectat l'usuari.
	 * 
	 * @param date_con Data i hora en la que s'ha connectat l'usuari.
	 */
	public void setDate_con(Timestamp date_con) {
		this.date_con = date_con;
	}
	
	/**
	 * Setter que assigna l'últim missatge llegit per l'usuari.
	 * 
	 * @param last_read Últim missatge llegit per l'usuari.
	 */
	public void setLast_read(int last_read) {
		this.last_read = last_read;
	}
	
	/**
	 * Mètode que retorna un String amb la informació de l'usuari.
	 */
	@Override
	public String toString() {
		return "User: [nick: " + this.nick 
				+ ", user_host: " +  this.user_host 
				+ ", date_con: " + this.date_con 
				+ ", last_read: " + this.last_read 
				+ "]";
	}
}
