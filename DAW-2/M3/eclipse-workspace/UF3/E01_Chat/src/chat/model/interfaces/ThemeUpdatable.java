package chat.model.interfaces;

/**
 * Interfície que permet actualitzar el tema de la vista.
 * 
 * @version 1.0
 * @author Hugo
 */
public interface ThemeUpdatable {
	/**
	 * Mètode que actualitza el tema de la vista.
	 * 
	 * @param darkMode Actualitzar al tema oscur o no.
	 */
	void updateTheme(boolean darkMode);
}
