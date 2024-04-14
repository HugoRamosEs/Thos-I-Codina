package chat.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import chat.model.objectes.Config;
import chat.model.objectes.UsuariDb;

public class MySQLModel {
	// private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private UsuariDb usuariDb;
	private Connection conn;
	
	private static MySQLModel _instance;
	
	private MySQLModel() {
		try {
			// Class.forName(MySQL.JDBC_DRIVER);
			this.usuariDb = Config.getInstance().getUsuariDb();
			String url = "jdbc:mysql://" + this.usuariDb.getHost() + "/" + this.usuariDb.getDb();
			this.conn = DriverManager.getConnection(url, this.usuariDb.getUser(), this.usuariDb.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static MySQLModel getInstance() {
		if (_instance == null) {
			_instance = new MySQLModel();
		}
		return _instance;
	}
	
	public static void close() {
		try {
			_instance.getConn().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConn() {
		return this.conn;
	}
	
	@Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Aquest objecte no es pot clonar.");
    } 
}
