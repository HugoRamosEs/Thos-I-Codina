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
    
    public void updateTheme(boolean darkMode) {
        this.darkMode = darkMode;
        this.repaint();
    }
    
	public Usuari getUsuari() {
		return this.usuari;
	}
	
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
        g.fillRect(89, 0, this.getWidth() - 10, 1);
        g.fillRect(89, this.getHeight() - 3, this.getWidth() - 10, 1);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.drawImage(this.img, 25, 12, this.img.getWidth(this), this.img.getHeight(this), this);

        g.setFont(Utils.carregarFont("bold", 18));
        g.setColor(nameColor);
        g.drawString(this.usuari.getNick(), 88, 33);

        SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm");
        g.setFont(Utils.carregarFont("plain", 12));
        g.setColor(dateAndHourColor);
        g.drawString(hourFormat.format(this.usuari.getDate_con()), 375, 35);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        g.setFont(Utils.carregarFont("plain", 14));
        g.setColor(dateAndHourColor);
        g.drawString(dateFormat.format(this.usuari.getDate_con()), 88, 53);
    }
}

