package chat.vista;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

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

    @Override
    public void paint(Graphics g) {
        super.paint(g);
		if (this.darkMode) {
			if (this.isOwner) {
				g.setColor(new Color(0, 92, 75));
				g.fillRect(0, 0, getWidth(), getHeight());
			} else {
				g.setColor(new Color(32, 44, 51));
		        g.fillRect(0, 0, getWidth(), getHeight());
			}

	        Font fontName = new Font("Arial", Font.BOLD, 16);
	        g.setFont(fontName);
	        g.setColor(new Color(216, 221, 224));
	        g.drawString(this.missatge.getNick(), 10, 22);

	        Font fontMsg = new Font("Arial", Font.PLAIN, 14);
	        g.setFont(fontMsg);
	        g.setColor(new Color(216, 221, 224));
	        int msgHeight = drawStringMultiLine(g, this.missatge.getMessage(), 10, 45, getWidth() - 15);

	        Font fontHour = new Font("Arial", Font.PLAIN, 12);
	        g.setFont(fontHour);
	        g.setColor(new Color(134, 150, 160));
	        g.drawString(this.missatge.getTs().toString().substring(11, 16), getWidth() - 45, 40 + msgHeight + 10);
	        
	        int newHeight = 40 + msgHeight + 5 + 15;
	        this.setPreferredSize(new Dimension(getWidth(), newHeight));
	        this.revalidate();
		} else {
			if (this.isOwner) {
				g.setColor(new Color(217, 253, 211));
				g.fillRect(0, 0, getWidth(), getHeight());
			} else {
				g.setColor(new Color(255, 255, 255));
		        g.fillRect(0, 0, getWidth(), getHeight());
			}

	        Font fontName = new Font("Arial", Font.BOLD, 16);
	        g.setFont(fontName);
	        g.setColor(new Color(17, 27, 33));
	        g.drawString(this.missatge.getNick(), 10, 22);

	        Font fontMsg = new Font("Arial", Font.PLAIN, 14);
	        g.setFont(fontMsg);
	        g.setColor(new Color(17, 27, 33));
	        int msgHeight = drawStringMultiLine(g, this.missatge.getMessage(), 10, 45, getWidth() - 15);

	        Font fontHour = new Font("Arial", Font.PLAIN, 12);
	        g.setFont(fontHour);
	        g.setColor(new Color(144, 156, 164));
	        g.drawString(this.missatge.getTs().toString().substring(11, 16), getWidth() - 45, 40 + msgHeight + 10);
	        
	        int newHeight = 40 + msgHeight + 5 + 15;
	        this.setPreferredSize(new Dimension(getWidth(), newHeight));
	        this.revalidate();
		}
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
}
