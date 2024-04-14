package chat.model.objectes;

import java.sql.Timestamp;

public class Usuari {
	private String nick;
	private String user_host;
	private Timestamp date_con;
	private int last_read;
	
	public Usuari(String nick) {
		this.nick = nick;
	}
	
	public Usuari(String nick, Timestamp date_con) {
		this.nick = nick;
		this.date_con = date_con;
	}
	
	public Usuari(String nick, String user_host, Timestamp date_con, int last_read) {
		this.nick = nick;
		this.user_host = user_host;
		this.date_con = date_con;
		this.last_read = last_read;
	}

	public String getNick() {
		return nick;
	}
	public String getUser_host() {
		return user_host;
	}
	public Timestamp getDate_con() {
		return date_con;
	}
	public int getLast_read() {
		return last_read;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public void setUser_host(String user_host) {
		this.user_host = user_host;
	}
	public void setDate_con(Timestamp date_con) {
		this.date_con = date_con;
	}
	public void setLast_read(int last_read) {
		this.last_read = last_read;
	}

	@Override
	public String toString() {
		return "Usuari: [nick: " + this.nick 
				+ ", user_host: " +  this.user_host 
				+ ", date_con: " + this.date_con 
				+ ", last_read: " + this.last_read 
				+ "]";
	}
}
