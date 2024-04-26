package chat.model.objectes;

import java.sql.Timestamp;

/**
 * Classe que representa un missatge del xat.
 * 
 * @version 1.0
 * @author Hugo
 */
public class Message {
	/**
	 * Id del missatge.
     */
	private int id_message;
	
	/**
	 * Nick de l'usuari que ha enviat el missatge.
	 */
	private String nick;
	
	/**
	 * Contigunt del missatge.
	 */
	private String message;
	
	/**
	 * Data i hora en la que s'ha enviat del missatge.
	 */
	private Timestamp ts;
	
	/**
	 * Constructor que crea una instancia de missatge amb el contigut.
	 * 
	 * @param message Contingut del missatge.
	 */
	public Message(String message) {
		this.message = message;
	}
	
	/**
	 * Constructor que crea una instancia de missatge amb el nick i el missatge.
	 * 
	 * @param nick Nick de l'usuari que ha enviat el missatge.
	 * @param message Contingut del missatge.
	 * @param ts Data i hora en la que s'ha enviat del missatge.
     */ 
	public Message(String nick, String message, Timestamp ts) {
		this.nick = nick;
		this.message = message;
		this.ts = ts;
	}
	
	/**
	 * Constructor que crea una instancia de missatge amb el id, el nick, el
	 * missatge i la data i hora.
	 * 
	 * @param id_message Id del missatge.
	 * @param nick Nick de l'usuari que ha enviat el missatge.
	 * @param message Contingut del missatge.
	 * @param ts Data i hora en la que s'ha enviat del missatge.
	 */
	public Message(int id_message, String nick, String message, Timestamp ts) {
		this.id_message = id_message;
		this.nick = nick;
		this.message = message;
		this.ts = ts;
	}
	
	/**
	 * Getter que retorna l'id del missatge.
	 * 
	 * @return Id del missatge.
	 */
	public int getId_message() {
		return id_message;
	}
	
	/**
	 * Getter que retorna el nick de l'usuari que ha enviat el missatge.
	 * 
	 * @return Nick de l'usuari que ha enviat el missatge.
	 */
	public String getNick() {
		return nick;
	}
	
	/**
	 * Getter que retorna el contingut del missatge.
	 * 
	 * @return Contingut del missatge.
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * Getter que retorna la data i hora en la que s'ha enviat del missatge.
	 * 
	 * @return Data i hora en la que s'ha enviat del missatge.
	 */
	public Timestamp getTs() {
		return ts;
	}
	
	/**
	 * Setter que modifica l'id del missatge.
	 * 
	 * @param id_message Id del missatge.
	 */
	public void setId_message(int id_message) {
		this.id_message = id_message;
	}
	
	/**
	 * Setter que modifica el nick de l'usuari que ha enviat el missatge.
	 * 
	 * @param nick Nick de l'usuari que ha enviat el missatge.
	 */
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	/**
	 * Setter que modifica el contingut del missatge.
	 * 
	 * @param message Contingut del missatge.
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * Setter que modifica la data i hora en la que s'ha enviat del missatge.
	 * 
	 * @param ts Data i hora en la que s'ha enviat del missatge.
	 */
	public void setTs(Timestamp ts) {
		this.ts = ts;
	}
	
	/**
	 * Mètode que retorna una cadena de caràcters amb la informació del missatge.
	 * 
	 * @return Cadena de caràcters amb la informació del missatge.
	 */
	@Override
	public String toString() {
		return "Message: [id_message: " + this.id_message
				+ ", nick: " +  this.nick
				+ ", message: " + this.message
				+ ", ts: " + this.ts
				+ "]";
	}
}
