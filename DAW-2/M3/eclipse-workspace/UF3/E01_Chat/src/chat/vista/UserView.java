package chat.vista;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;

import chat.model.interfaces.ThemeUpdatable;
import chat.model.objectes.User;

/**
 * Classe que representa un usuari en la vista del xat.
 * 
 * @version 1.0
 * @author Hugo
 */
public class UserView extends Canvas implements ThemeUpdatable {
	/**
	 * Serial version UID.
	 */
    private static final long serialVersionUID = 1L;
    
	/**
	 * Usuari a mostrar.
	 */
    private User user;
    
    /**
     * Indica si el mode fosc està activat.
     */
    private boolean darkMode;
    
    /**
     * Imatge de l'avatar de l'usuari.
     */
    private Image img;
    
	/**
	 * Constructor que crea una instancia de la vista de l'usuari.
	 * 
	 * @param usuari Usuari a mostrar.
	 * @param darkMode Indica si el mode fosc està activat.
	 */
    public UserView(User usuari, boolean darkMode) {
        this.user = usuari;
        this.darkMode = darkMode;
        this.img = Toolkit.getDefaultToolkit().getImage(ChatView.class.getResource("/chat/vista/resources/avatar_49px.png"));
        init();
    }
    
    /**
     * Mètode que inicialitza de la vista de l'usuari.
     */
    private void init() {
        this.setPreferredSize(new Dimension(428, 75));
        this.setVisible(true);
    }
    
    /**
     * Getter que retorna l'usuari al que pertany la vista.
     * 
     * @return Usuari al que pertany la vista.
     */
	public User getUser() {
		return this.user;
	}
	
    /**
     * Mètode que pinta l'usuari en la vista.
     * 
     * @param g Gràfics.
     */
	@Override
    public void paint(Graphics g) {
        Color backgroundColor;
        Color nameColor;
        Color dateAndHourColor;
        Color separatorColor;

        if (this.darkMode) {
            backgroundColor = new Color(17, 27, 33);
            nameColor = new Color(233, 237, 239);
            dateAndHourColor = new Color(134, 150, 160);
            separatorColor = new Color(49, 56, 61);
        } else {
            backgroundColor = new Color(255, 255, 255);
            nameColor = new Color(17, 27, 33);
            dateAndHourColor = new Color(135, 148, 156);
            separatorColor = new Color(209, 215, 219);
        }
        
        g.setColor(backgroundColor);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        g.setColor(separatorColor);
        g.fillRect(91, 0, this.getWidth() - 10, 1);
        g.fillRect(91, this.getHeight() - 3, this.getWidth() - 10, 1);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.drawImage(this.img, 27, 12, this.img.getWidth(this), this.img.getHeight(this), this);

        g.setFont(Utils.loadFont("bold", 18));
        g.setColor(nameColor);
        g.drawString(this.user.getNick(), 89, 33);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        g.setFont(Utils.loadFont("plain", 14));
        g.setColor(dateAndHourColor);
        g.drawString(dateFormat.format(this.user.getDate_con()), 89, 53);
        
        SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm");
        g.setFont(Utils.loadFont("plain", 12));
        g.setColor(dateAndHourColor);
        g.drawString(hourFormat.format(this.user.getDate_con()), 375, 35);
    }
	
	/** 
     * Mètode implementat de l'interficie `ThemeUpdatable` que actualitza el tema de la vista.
     * 
     * @param darkMode Indica si el mode fosc està activat.
     */
	@Override
    public void updateTheme(boolean darkMode) {
    	this.darkMode = darkMode;
        this.repaint();
    }
}

