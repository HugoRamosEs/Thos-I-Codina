package chat.vista;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;

import chat.model.objectes.Usuari;

public class UsuariView extends Canvas {
    private static final long serialVersionUID = 1L;
    private Usuari usuari;
    private boolean darkMode;
    private Image img;

    public UsuariView(Usuari usuari, boolean darkMode) {
        this.usuari = usuari;
        this.darkMode = darkMode;
        this.img = Toolkit.getDefaultToolkit().getImage(ChatView.class.getResource("/chat/vista/resources/avatar_49px.png"));
        init();
    }

    private void init() {
        this.setPreferredSize(new Dimension(428, 75));
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
    	if (this.darkMode) {
    		g.setColor(new Color(49, 56, 61));
        	g.fillRect(89, 0, this.getWidth() - 10, 1);
        	g.fillRect(89, this.getHeight() - 3, this.getWidth() - 10, 1);
            
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g.drawImage(this.img, 25, 12, this.img.getWidth(this), this.img.getHeight(this), this);

            Font nameFont = new Font("Arial", Font.PLAIN, 18);
            g.setFont(nameFont);
            g.setColor(new Color(233, 237, 239));
            g.drawString(this.usuari.getNick(), 88, 33);

            SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            Font hourFont = new Font("Arial", Font.PLAIN, 12);
            g.setFont(hourFont);
            g.setColor(new Color(134, 150, 160));
            g.drawString(hourFormat.format(this.usuari.getDate_con()), 375, 35);

            Font dateFont = new Font("Arial", Font.PLAIN, 14);
            g.setFont(dateFont);
            g.drawString(dateFormat.format(this.usuari.getDate_con()), 88, 53);
    	} else {
    		g.setColor(new Color(209, 215, 219));
        	g.fillRect(89, 0, this.getWidth() - 10, 1);
        	g.fillRect(89, this.getHeight() - 3, this.getWidth() - 10, 1);
            
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g.drawImage(this.img, 25, 12, this.img.getWidth(this), this.img.getHeight(this), this);

            Font nameFont = new Font("Arial", Font.PLAIN, 18);
            g.setFont(nameFont);
            g.setColor(new Color(17, 27, 33));
            g.drawString(this.usuari.getNick(), 88, 33);

            SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            Font hourFont = new Font("Arial", Font.PLAIN, 12);
            g.setFont(hourFont);
            g.setColor(new Color(135, 148, 156));
            g.drawString(hourFormat.format(this.usuari.getDate_con()), 375, 35);

            Font dateFont = new Font("Arial", Font.PLAIN, 14);
            g.setFont(dateFont);
            g.drawString(dateFormat.format(this.usuari.getDate_con()), 88, 53);
    	}
    }
}

