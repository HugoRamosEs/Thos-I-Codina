package chat.model.objectes;

import java.sql.Timestamp;

public class Missatge {
	private int id_message;
	private String nick;
	private String message;
	private Timestamp ts;
	
	public Missatge(String message) {
		this.message = message;
	}
	
	public Missatge(String nick, String message, Timestamp ts) {
		this.nick = nick;
		this.message = message;
		this.ts = ts;
	}
	
	public Missatge(int id_message, String nick, String message, Timestamp ts) {
		this.id_message = id_message;
		this.nick = nick;
		this.message = message;
		this.ts = ts;
	}
	
	public int getId_message() {
		return id_message;
	}
	public String getNick() {
		return nick;
	}
	public String getMessage() {
		return message;
	}
	public Timestamp getTs() {
		return ts;
	}
	public void setId_message(int id_message) {
		this.id_message = id_message;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setTs(Timestamp ts) {
		this.ts = ts;
	}
	
	@Override
	public String toString() {
		return "Missatge: [id_message: " + this.id_message
				+ ", nick: " +  this.nick
				+ ", message: " + this.message
				+ ", ts: " + this.ts
				+ "]";
	}
}
