package chat.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.JOptionPane;

import chat.model.exceptions.ChatInvalidArgumentException;
import chat.model.objectes.User;

public class UserModel extends Model {
	private Connection mysql;
	private CallableStatement cstmt;
	
	public UserModel() {
		this.mysql = MySQLModel.getInstance().getConn();
		this.cstmt = null;
	}
	
	public boolean connect(User u) {
		boolean connected = false;
		try {
			String nick = u.getNick().trim();
			if (nick.isEmpty() || nick.length() > 50 || nick.equals("Escriu un nom d'usuari...")) {
				throw new ChatInvalidArgumentException("Has d'introduir un nom vàlid!");
			}
			String sql = "{call connect(?)}";
			this.cstmt = this.mysql.prepareCall(sql);
			this.cstmt.setString(1, nick);
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
	
	public HashMap<String, User> getConnectedUsers() {
	    HashMap<String, User> users = new HashMap<String, User>();
	    try {
	        String sql = "{call getConnectedUsers()}";
	        this.cstmt = this.mysql.prepareCall(sql);
	        ResultSet rs = this.cstmt.executeQuery();
	        while (rs.next()) {
	            String nick = rs.getString("nick");
	            Timestamp date_con = rs.getTimestamp("date_con");
	            User u = new User(nick, date_con);
	            users.put(nick, u);
	        }
	        rs.close();
	        super.printToConsole(users.values(), "Usuaris");
	    } catch (SQLException sqle) {
	        JOptionPane.showMessageDialog(null, sqle.getMessage(), "Error amb la base de dades", JOptionPane.ERROR_MESSAGE);
	    } finally {
	        if (!users.isEmpty()) {
	            System.out.println("Usuaris connectats mostrats!");
	        }
	    }
	    
	    return users;
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
