package chat.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import chat.model.objectes.Config;
import chat.model.objectes.UserDb;

/**
 * Classe model que gestiona la connexió amb la base de dades MySQL.
 * 
 * @version 1.0
 * @author Hugo
 */
public class MySQLModel {
	/**
	 * Objecte UserDb que conté les credencials per a la connexió amb la base de dades.
     */
	private UserDb userDb;
	
	/**
	 * Connexió a la base de dades.
	 */
	private Connection conn;
	
	/**
	 * Instància única de la classe.
	 */
	private static MySQLModel _instance;
	
	/**
	 * Constructor que crea una connexió amb la base de dades.
	 */
	private MySQLModel() {
		try {
			this.userDb = Config.getInstance().getUserDb();
			String url = "jdbc:mysql://" + this.userDb.getHost() + "/" + this.userDb.getDb();
			this.conn = DriverManager.getConnection(url, this.userDb.getUser(), this.userDb.getPassword());
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "No s'ha pogut connectar a la base de dades.", "Error amb la base de dades", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Mètode que retorna una instància de la classe. Si no existeix, en crea una, sinó, retorna la existent.
	 * 
	 * @return Instància de la classe.
	 */
	public static MySQLModel getInstance() {
		if (_instance == null) {
			_instance = new MySQLModel();
		}
		return _instance;
	}
	
	/**
	 * Mètode que tanca la connexió amb la base de dades.
	 */
	public static void close() {
		try {
			_instance.getConn().close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No s'ha pogut desconnectar de la base de dades.", "Error amb la base de dades", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Getter que retorna la connexió amb la base de dades.
	 * 
	 * @return Connexió amb la base de dades.
	 */
	public Connection getConn() {
		return this.conn;
	}
	
	/**
	 * Mètode que bloqueja el métode clone de Object.
	 */
	@Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Aquest objecte no es pot clonar.");
    } 
}
