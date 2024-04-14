package pregunta02;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class DataBase {
	private String url;
	private String userName;
	private String password;
	
	private Connection conn;
	
	public DataBase() throws Exception {
		this.url = "jdbc:mysql://127.0.0.1/myweb";
		this.userName = "appuser";
		this.password = "TiC.123456";
		
	
			if (this.conn == null) {
				Class.forName("com.mysql.jdbc.Driver");
				this.conn = DriverManager.getConnection(this.url,this.userName, this.password);				
			}

	}
	
	public void startTransaction() { }
	public void commit() { }
	public void rollBack() { }
	public Compte find(String id) {
		return new Compte(id,new Client());
	}
	public void store(Compte ct) { }
	public void disconect () { }

}
