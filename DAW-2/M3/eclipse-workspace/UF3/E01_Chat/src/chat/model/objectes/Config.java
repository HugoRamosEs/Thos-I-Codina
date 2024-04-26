package chat.model.objectes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * Classe que agafa les dades de configuració d'un fitxer i crea un objecte amb aquestes dades per realitzar la
 * connexió de la base de dades amb l'aplicació.
 * 
 * @version 1.0
 * @author Hugo
 */
public class Config {
	/**
	 * Ruta del fitxer de configuració.
	 */
	private static final String CONFIG_FILE = "src/chat/docs/config.json";
	
	/**
	 * Objecte UserDb amb les dades de configuració.
	 */
	private UserDb userDb;
	
	/**
	 * Instància única de la classe.
	 */
	private static Config _instance;
	
	/**
	 * Constructor que llegeix el fitxer de configuració i crea una instancia de
	 * UserDb amb les dades llegides.
	 */
	private Config() {
		try {
			File file = new File(CONFIG_FILE);
			BufferedReader br = new BufferedReader(new FileReader(file));
			StringBuilder jsonString = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				jsonString.append(line);
			}
			br.close();

			String[] parts = jsonString.toString().split("\"");
			String host = parts[3];
			String user = parts[7];
			String password = parts[11];
			String db = parts[15];

			this.userDb = new UserDb(host, user, password, db);

			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "Error d'entrada/sortida.", "Error amb CSV", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Mètode que retorna una instància de la classe. Si no existeix, en crea una,
	 * si no, retorna la existent.
	 * 
	 * @return Instància de la classe.
	 */
	public static Config getInstance() {
		if (_instance == null) {
			_instance = new Config();
		}
		return _instance;
	}
	
	/**
	 * Getter que retorna l'objecte UserDb amb les dades de configuració.
	 * 
	 * @return Objecte UserDb amb les dades de configuració.
	 */
	public UserDb getUserDb() {
		return userDb;
	}
	
	/**
	 * Mètode que bloqueja el métode clone de Object.
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Aquest objecte no es pot clonar.");
	}
}
