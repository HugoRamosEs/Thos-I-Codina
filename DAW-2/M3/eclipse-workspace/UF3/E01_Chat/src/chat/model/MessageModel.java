package chat.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import chat.model.exceptions.ChatInvalidArgumentException;
import chat.model.objectes.Message;

/**
 *  Justificació de la col.lecció utilitzada: Utilitzo ArrayList perque es la col.lecció més senzilla i eficient per iterar.
 *  Em permet afegir, eliminar i obtenir elements de forma senzilla, agant el seu index.
 */

/**
 * Classe model que gestiona els procediments emmagatzemats dels missatges.
 */
public class MessageModel extends Model {
	/**
	 * Connexió a la base de dades.
     */
	private Connection mysql;
	
	/**
	 * CallableStatement per cridar els procediments emmagatzemats.
	 */
	private CallableStatement cstmt;
	
	/**
	 * Constructor per crear una instancia de MessageModel.
	 */
	public MessageModel() {
		this.mysql = MySQLModel.getInstance().getConn();
		this.cstmt = null;
	}
	
	/**
	 * Mètode que crida al procediment que obté tots els missatges de la base de dades. Posteriorment, els emmagatzema a un ArrayList.
	 * 
	 * @return ArrayList amb tots els missatges.
	 */
	public ArrayList<Message> getMessages() {
		ArrayList<Message> missatges = new ArrayList<Message>();
		try {
			String sql = "{call getMessages()}";
			this.cstmt = this.mysql.prepareCall(sql);
			ResultSet rs = this.cstmt.executeQuery();
			while (rs.next()) {
				String nick = rs.getString("nick");
				String message = rs.getString("message");
				Timestamp ts = rs.getTimestamp("ts");
				Message m = new Message(nick, message, ts);
				missatges.add(m);
			}
	        rs.close();
	        super.printToConsole(missatges, "Missatges");
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, sqle.getMessage(), "Error amb la base de dades", JOptionPane.ERROR_MESSAGE);
		} finally {
			if (missatges.size() > 0) {
				System.out.println("Missatges mostrats!");
			}
		}
		
		return missatges;
	}
	
	/**
	 * Mètode que crida al procediment que envia un missatge a la base de dades.
	 * 
	 * @param m Missatge a enviar.
	 * @return True si s'ha enviat, false si no.
	 */
	public boolean send(Message m) {
		boolean sent = false;
		try {
			String msg = m.getMessage().trim();
			if (msg.isEmpty() || msg.length() > 255 || msg.equals("Escriu un missatge...")) {
				throw new ChatInvalidArgumentException("Has d'introduir un missatge vàlid!", "MSG01");
			}
			String sql = "{call send(?)}";
			this.cstmt = this.mysql.prepareCall(sql);
			this.cstmt.setString(1, msg);
			this.cstmt.execute();
			sent = true;
		} catch (ChatInvalidArgumentException ciae) {
			JOptionPane.showMessageDialog(null, ciae.getMessage(), "Error d'argument", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, sqle.getMessage(), "Error amb la base de dades", JOptionPane.ERROR_MESSAGE);
		} finally {
			if (sent) {
				System.out.println("Missatge enviat!");
			}
		}
		
		return sent;
	}
}
