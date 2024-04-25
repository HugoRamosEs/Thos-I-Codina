package chat.model.objectes;

import java.sql.Timestamp;

public class Message {
	private int id_message;
	private String nick;
	private String message;
	private Timestamp ts;
	
	public Message(String message) {
		this.message = message;
	}
	
	public Message(String nick, String message, Timestamp ts) {
		this.nick = nick;
		this.message = message;
		this.ts = ts;
	}
	
	public Message(int id_message, String nick, String message, Timestamp ts) {
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
		return "Message: [id_message: " + this.id_message
				+ ", nick: " +  this.nick
				+ ", message: " + this.message
				+ ", ts: " + this.ts
				+ "]";
	}
}
