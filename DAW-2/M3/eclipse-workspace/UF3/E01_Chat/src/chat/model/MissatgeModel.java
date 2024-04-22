package chat.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import chat.model.exceptions.ChatInvalidArgumentException;
import chat.model.objectes.Missatge;

public class MissatgeModel extends Model {
	private Connection mysql;
	private CallableStatement cstmt;
	
	public MissatgeModel() {
		this.mysql = MySQLModel.getInstance().getConn();
		this.cstmt = null;
	}
	
	public ArrayList<Missatge> getMessages() {
		ArrayList<Missatge> missatges = new ArrayList<Missatge>();
		try {
			String sql = "{call getMessages()}";
			this.cstmt = this.mysql.prepareCall(sql);
			ResultSet rs = this.cstmt.executeQuery();
			while (rs.next()) {
				String nick = rs.getString("nick");
				String message = rs.getString("message");
				Timestamp ts = rs.getTimestamp("ts");
				Missatge m = new Missatge(nick, message, ts);
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
	
	public boolean send(Missatge m) {
		boolean sent = false;
		try {
			if (m.getMessage().length() < 0 || m.getMessage().length() > 255 || m.getMessage().equals("Escriu un missatge...")) {
				throw new ChatInvalidArgumentException("Has d'introduir un missatge vàlid!");
			}
			String sql = "{call send(?)}";
			this.cstmt = this.mysql.prepareCall(sql);
			this.cstmt.setString(1, m.getMessage());
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
