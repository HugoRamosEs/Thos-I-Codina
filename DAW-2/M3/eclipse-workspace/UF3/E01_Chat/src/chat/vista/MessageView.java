package chat.vista;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import chat.model.interfaces.ThemeUpdatable;
import chat.model.objectes.Message;

public class MessageView extends Canvas implements ThemeUpdatable {
    private static final long serialVersionUID = 1L;
    private Message missatge;
    private boolean darkMode;
    private boolean isOwner;

    public MessageView(Message missatge, boolean darkMode, boolean isOwner) {
        this.missatge = missatge;
        this.darkMode = darkMode;
        this.isOwner = isOwner;
        init();
    }

    private void init() {
        this.setPreferredSize(new Dimension(510, 140));
        this.setVisible(true);
    }
    
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

        g.setFont(Utils.loadFont("bold", 16));
        g.setColor(textColor);
        g.drawString(this.missatge.getNick(), 10, 22);

        g.setFont(Utils.loadFont("plain", 14));
        g.setColor(textColor);
        drawStringMultiLine(g, this.missatge.getMessage(), 10, 42, getWidth() - 15);

        g.setFont(Utils.loadFont("plain", 12));
        g.setColor(timeColor);
        g.drawString(this.missatge.getTs().toString().substring(11, 16), getWidth() - 42, this.getHeight() - 7);
    }
    
    @Override
    public void updateTheme(boolean darkMode) {
    	this.darkMode = darkMode;
        this.repaint();
    }
}
