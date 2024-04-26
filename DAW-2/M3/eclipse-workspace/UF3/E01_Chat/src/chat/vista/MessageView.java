package chat.vista;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import chat.model.interfaces.ThemeUpdatable;
import chat.model.objectes.Message;

/**
 * Classe que representa un missatge en la vista del xat.
 * 
 * @version 1.0
 * @author Hugo
 */
public class MessageView extends Canvas implements ThemeUpdatable {
	/**
	 * Serial version UID.
	 */
    private static final long serialVersionUID = 1L;
    
    /**
     * Missatge a mostrar.
     */
    private Message missatge;
    
	/**
	 * Indica si el mode fosc està activat.
	 */
    private boolean darkMode;
    
    /*
     * Indica si el missatge és del propi usuari conectat, es a dir, tú mateix.
     */
    private boolean isOwner;
    
	/**
	 * Imatge del "tick" del missatge.
	 */
    private Image img;
    
	/**
	 * Constructor que crea una instancia de la vista del missatge.
	 * 
	 * @param missatge Missatge a mostrar.
	 * @param darkMode Indica si el mode fosc està activat.
	 * @param isOwner Indica si el missatge és del propi usuari conectat.
	 */
    public MessageView(Message missatge, boolean darkMode, boolean isOwner) {
        this.missatge = missatge;
        this.darkMode = darkMode;
        this.isOwner = isOwner;
        init();
    }
    
	/**
	 * Mètode que inicialitza de la vista del missatge.
	 */
    private void init() {
        this.setPreferredSize(new Dimension(510, 140));
        this.setVisible(true);
    }
    
    /**
     * Mètode que dibuixa el text del missatge en varies línies. Realitza un salt de línia automàticament
     * quan el text arriba a la màxima amplada.
     * 
     * @param g Gràfics.
     * @param text Text a mostrar.
     * @param x Posició x.
     * @param y Posició y.
     * @param maxWidth Màxima amplada.
     */
    private void drawStringMultiLine(Graphics g, String text, int x, int y, int maxWidth) {
        FontMetrics metrics = g.getFontMetrics();
        int lineHeight = metrics.getHeight();
        String[] words = text.split("\\s+");
        StringBuilder line = new StringBuilder();
        int currentWidth = 0;

        for (String word : words) {
            char[] chars = word.toCharArray();
            for (char c : chars) {
                int charWidth = metrics.charWidth(c);
                if (currentWidth + charWidth <= maxWidth) {
                    line.append(c);
                    currentWidth += charWidth;
                } else {
                    g.drawString(line.toString(), x, y);
                    line = new StringBuilder(String.valueOf(c));
                    y += lineHeight;
                    currentWidth = charWidth;
                }
            }
            line.append(" ");
            currentWidth += metrics.charWidth(' ');
        }
        g.drawString(line.toString(), x, y);
    }
    
    /**
     * Mètode que pinta el missatge en la vista.
     * 
     * @param g Gràfics.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Color backgroundColor;
        Color textColor;
        Color timeColor;

        if (this.darkMode) {
            backgroundColor = this.isOwner ? new Color(0, 92, 75) : new Color(32, 44, 51);
            textColor = new Color(216, 221, 224);
            timeColor = new Color(134, 150, 160);
            this.img = Toolkit.getDefaultToolkit().getImage(ChatView.class.getResource("/chat/vista/resources/tick-oscuro_20px.png"));
        } else {
            backgroundColor = this.isOwner ? new Color(217, 253, 211) : new Color(255, 255, 255);
            textColor = new Color(17, 27, 33);
            timeColor = new Color(144, 156, 164);
            this.img = Toolkit.getDefaultToolkit().getImage(ChatView.class.getResource("/chat/vista/resources/tick-claro_20px.png"));
        }

        g.setColor(backgroundColor);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        g.setFont(Utils.loadFont("bold", 16));
        g.setColor(textColor);
        g.drawString(this.missatge.getNick(), 10, 22);

        g.setFont(Utils.loadFont("plain", 14));
        g.setColor(textColor);
        drawStringMultiLine(g, this.missatge.getMessage(), 10, 42, getWidth() - 15);

        g.setFont(Utils.loadFont("plain", 12));
        g.setColor(timeColor);
        g.drawString(this.missatge.getTs().toString().substring(11, 16), getWidth() - 70, this.getHeight() - 7);
        
        g.drawImage(this.img, 480, 118, this.img.getWidth(this), this.img.getHeight(this), this);
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
