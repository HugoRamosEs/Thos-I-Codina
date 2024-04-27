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

/**
 * Justificació de la col.lecció utilitzada: Utilitzo HashMap perque em permet emmagatzemar els usuaris connectats de forma eficient.
 * A més, em permet accedir als usuaris a través de la seva clau, que en aquest cas és el seu nick. D'altra banda em controla el fet
 * de que no es pugui repetir el nick d'un usuari, ja que si es repeteix, el sobreescriu.
 */

/**
 * Classe model que gestiona els procediments emmagatzemats dels usuaris.
 * 
 * @version 1.0
 * @author Hugo
 */
public class UserModel extends Model {
	/**
	 * Connexió a la base de dades.
	 */
	private Connection mysql;
	
	/**
	 * CallableStatement per cridar els procediments emmagatzemats.
	 */
	private CallableStatement cstmt;
	
	/**
	 * Constructor per crear una instancia de UserModel.
	 */
	public UserModel() {
		this.mysql = MySQLModel.getInstance().getConn();
		this.cstmt = null;
	}
	
	/**
	 * Mètode que crida al procediment que connecta un usuari a la base de dades. No confondre amb la connexió a la base de dades.
	 * 
	 * @param u Usuari a connectar.
	 * @return Cert si s'ha connectat, fals si no.
	 */
	public boolean connect(User u) {
		boolean connected = false;
		try {
			String nick = u.getNick().trim();
			if (nick.isEmpty() || nick.length() > 50 || nick.equals("Escriu un nom d'usuari...")) {
				throw new ChatInvalidArgumentException("Has d'introduir un nom vàlid!", "USR01");
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
				System.out.println("User " + u.getNick() + " connected!");
			}
		}
		
		return connected;
	}
	
	/**
	 * Mètode que crida al procediment que obté tots els usuaris connectats de la
	 * base de dades. Posteriorment, els emmagatzema a un HashMap, utilitzant el nick
	 * com a clau.
	 * 
	 * @return HashMap amb tots els usuaris connectats.
	 */
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
	        super.printToConsole(users.values(), "Users");
	    } catch (SQLException sqle) {
	        JOptionPane.showMessageDialog(null, sqle.getMessage(), "Error amb la base de dades", JOptionPane.ERROR_MESSAGE);
	    }
	    
	    return users;
	}
	
	/**
	 * Mètode que crida al procediment que desconnecta un usuari de la base de dades.
	 * 
	 * @return Cert si s'ha desconnectat, fals si no.
	 */
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
				System.out.println("Disconnected user!");
			}
		}
		
		return disconnected;
	}
}
