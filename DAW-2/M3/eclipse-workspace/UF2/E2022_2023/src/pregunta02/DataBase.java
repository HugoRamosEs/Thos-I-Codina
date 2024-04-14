package pregunta02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import pregunta01.CustomCheckedException;

public class DataBase {
	private String url;
	private String userName;
	private String password;
	
	private Connection conn;
	
	public DataBase() throws CustomCheckedException, SQLException, ClassNotFoundException{
		this.url = "jdbc:mysql://127.0.0.1/myweb";
		this.userName = "appuser";
		this.password = "TiC.123456";
		
//		try {
//			if (this.conn == null) {
//				Class.forName("com.mysql.jdbc.Driver");
//				this.conn = DriverManager.getConnection(this.url,this.userName, this.password);				
//			}
//		} catch (Exception e){
//			JOptionPane.showMessageDialog(null, "No s'ha pobut connectar a la base de dades \n" + e.getMessage(), "Error de conexió", JOptionPane.ERROR_MESSAGE); 
//		}
		
		try {
			if (this.conn == null) {
				Class.forName("com.mysql.jdbc.Driver");
				this.conn = DriverManager.getConnection(this.url,this.userName, this.password);				
			}
		} catch (Exception e){
			throw new CustomCheckedException("A002", "No s'ha pobut connectar a la base de dades", e);
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
