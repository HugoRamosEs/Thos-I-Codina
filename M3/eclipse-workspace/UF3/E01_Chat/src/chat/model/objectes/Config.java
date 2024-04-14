package chat.model.objectes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Config {
	private static final File CONFIG_FILE = new File("src/chat/docs/config.json");
	private UsuariDb usuariDb;

	private static Config _instance;

	private Config() {
		try {
			File file = CONFIG_FILE;
			BufferedReader br = new BufferedReader(new FileReader(file));
			StringBuilder jsonString = new StringBuilder();
			String linia;
			while ((linia = br.readLine()) != null) {
				jsonString.append(linia);
			}
			br.close();

			String[] parts = jsonString.toString().split("\"");
			String host = parts[3];
			String user = parts[7];
			String password = parts[11];
			String db = parts[15];

			this.usuariDb = new UsuariDb(host, user, password, db);

			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "Error d'entrada/sortida.", "Error amb CSV", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static Config getInstance() {
		if (_instance == null) {
			_instance = new Config();
		}
		return _instance;
	}

	public UsuariDb getUsuariDb() {
		return usuariDb;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Aquest objecte no es pot clonar.");
	}
}
