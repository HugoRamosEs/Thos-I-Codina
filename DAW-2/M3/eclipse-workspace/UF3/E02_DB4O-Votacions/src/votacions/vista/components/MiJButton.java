package votacions.vista.components;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.*;

import votacions.vista.View;

public class MiJButton extends JButton {
    private static final long serialVersionUID = 1L;   
    private Image backgroundImage;
    private String buttonText;

    public MiJButton(String text, String estil, int tamanyText) {
        super(text);
        this.buttonText = text;
        this.backgroundImage = new ImageIcon("src/votacions/vista/recursos/minecraft-button.jpg").getImage();
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setForeground(Color.WHITE);
        setFont(carregarFont(estil, tamanyText));
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
    }
    
    public int estilFont(String estil) {
	    switch (estil.toLowerCase()) {
	        case "plain":
	            return Font.PLAIN;
	        case "bold":
	            return Font.BOLD;
	        case "italic":
	            return Font.ITALIC;
	        case "bolditalic":
	            return Font.BOLD | Font.ITALIC;
	        default:
	            return Font.PLAIN;
	    }
	}
    
	public Font carregarFont(String estil, int tamany) {
        try (InputStream is = View.class.getResourceAsStream("/votacions/vista/recursos/minecraftia.ttf")) {
            return Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(estilFont(estil), tamany);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            return new Font("Arial", estilFont(estil), tamany);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
        FontMetrics fm = g.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(buttonText)) / 2;
        int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
        g.setColor(getForeground());
        g.drawString(buttonText, x, y);
    }

    @Override
    public Dimension getPreferredSize() {
        if (backgroundImage != null) {
            return new Dimension(backgroundImage.getWidth(this), backgroundImage.getHeight(this));
        }
        return super.getPreferredSize();
    }

    public void setBackgroundImage(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
        repaint();
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
        repaint();
    }
}