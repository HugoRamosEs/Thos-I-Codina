package chat.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

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
			sqle.printStackTrace();
		} finally {
			if (missatges.size() > 0) {
				System.out.println("Missatges mostrats!");
			}
		}
		
		return missatges;
	}
	
	public void send(Missatge m) {
		boolean sent = false;
		try {
			String sql = "{call send(?)}";
			this.cstmt = this.mysql.prepareCall(sql);
			this.cstmt.setString(1, m.getMessage());
			this.cstmt.execute();
			sent = true;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			if (sent) {
				System.out.println("Missatge enviat!");
			}
		}
	}
}
