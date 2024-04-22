package chat.vista;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import chat.model.objectes.Missatge;

public class MissatgeView extends Canvas {
    private static final long serialVersionUID = 1L;
    private Missatge missatge;
    private boolean darkMode;
    private boolean isOwner;

    public MissatgeView(Missatge missatge, boolean darkMode, boolean isOwner) {
        this.missatge = missatge;
        this.darkMode = darkMode;
        this.isOwner = isOwner;
        init();
    }

    private void init() {
        this.setPreferredSize(new Dimension(428, 95));
        this.setVisible(true);
    }
    
    private int drawStringMultiLine(Graphics g, String text, int x, int y, int maxWidth) {
        FontMetrics metrics = g.getFontMetrics();
        int lineHeight = metrics.getHeight();
        String[] words = text.split("\\s+");
        StringBuilder line = new StringBuilder();
        int totalHeight = 0;
        
        for (String word : words) {
            if (metrics.stringWidth(line.toString() + " " + word) < maxWidth) {
                line.append(word).append(" ");
            } else {
                g.drawString(line.toString(), x, y + totalHeight);
                totalHeight += lineHeight;
                line = new StringBuilder(word + " ");
            }
        }
        g.drawString(line.toString(), x, y + totalHeight);
        totalHeight += lineHeight;
        
        return totalHeight;
    }
    
    public void updateTheme(boolean darkMode) {
        this.darkMode = darkMode;
        this.repaint();
    }

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
        } else {
            backgroundColor = this.isOwner ? new Color(217, 253, 211) : new Color(255, 255, 255);
            textColor = new Color(17, 27, 33);
            timeColor = new Color(144, 156, 164);
        }

        g.setColor(backgroundColor);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        g.setFont(Utils.carregarFont("bold", 16));
        g.setColor(textColor);
        g.drawString(this.missatge.getNick(), 10, 22);

        g.setFont(Utils.carregarFont("bold", 14));
        g.setColor(textColor);
        int msgHeight = drawStringMultiLine(g, this.missatge.getMessage(), 10, 45, getWidth() - 15);

        g.setFont(Utils.carregarFont("bold", 12));
        g.setColor(timeColor);
        g.drawString(this.missatge.getTs().toString().substring(11, 16), getWidth() - 45, 40 + msgHeight + 10);

        int newHeight = 40 + msgHeight + 5 + 15;
        this.setPreferredSize(new Dimension(this.getWidth(), newHeight));
        this.revalidate();
    }
}
