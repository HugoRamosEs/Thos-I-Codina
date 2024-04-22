package chat.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import chat.model.exceptions.ChatInvalidArgumentException;
import chat.model.objectes.Usuari;

public class UsuariModel extends Model {
	private Connection mysql;
	private CallableStatement cstmt;
	
	public UsuariModel() {
		this.mysql = MySQLModel.getInstance().getConn();
		this.cstmt = null;
	}
	
	public boolean connect(Usuari u) {
		boolean connected = false;
		try {
			if (u.getNick().length() < 0 || u.getNick().length() > 50 || u.getNick().equals("Escriu un nom d'usuari...")) {
				throw new ChatInvalidArgumentException("Has d'introduir un nom vàlid!");
			}
			String sql = "{call connect(?)}";
			this.cstmt = this.mysql.prepareCall(sql);
			this.cstmt.setString(1, u.getNick());
			this.cstmt.execute();
			connected = true;
		} catch (ChatInvalidArgumentException ciae) {
			JOptionPane.showMessageDialog(null, ciae.getMessage(), "Error d'argument", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, sqle.getMessage(), "Error amb la base de dades", JOptionPane.ERROR_MESSAGE);
		} finally {
			if (connected) {
				System.out.println("Usuari " + u.getNick() + " connectat!");
			}
		}
		
		return connected;
	}
	
	public ArrayList<Usuari> getConnectedUsers() {
		ArrayList<Usuari> usuaris = new ArrayList<Usuari>();
	    try {
	        String sql = "{call getConnectedUsers()}";
	        this.cstmt = this.mysql.prepareCall(sql);
	        ResultSet rs = this.cstmt.executeQuery();
			while (rs.next()) {
				String nick = rs.getString("nick");
				Timestamp date_con = rs.getTimestamp("date_con");
				Usuari u = new Usuari(nick, date_con);
				usuaris.add(u);
			}
	        rs.close();
	        super.printToConsole(usuaris, "Usuaris");
	    } catch (SQLException sqle) {
	    	JOptionPane.showMessageDialog(null, sqle.getMessage(), "Error amb la base de dades", JOptionPane.ERROR_MESSAGE);
	    } finally {
	    	if (usuaris.size() > 0) {
	    		System.out.println("Usuaris connectats mostrats!");
	    	}
	    }
	    
		return usuaris;
	}
	
	public boolean disconnect() {
		boolean disconnected = false;
		try {
			String sql = "{call disconnect()}";
			this.cstmt = this.mysql.prepareCall(sql);
			this.cstmt.execute();
			disconnected = true;
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, sqle.getMessage(), "Error amb la base de dades", JOptionPane.ERROR_MESSAGE);
		} finally {
			if (disconnected) {
				System.out.println("Usuari desconnectat!");
			}
		}
		
		return disconnected;
	}
}
