package angle;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

public class RoundedBorder implements Border {
	private int radio;

	public RoundedBorder(int radius) {
		this.radio = radius;
	}

	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		g.drawRoundRect(x, y, width - 1, height - 1, radio, radio);
	}

	@Override
	public Insets getBorderInsets(Component c) {
		return new Insets(this.radio + 1, this.radio + 1, this.radio + 2, this.radio);
	}

	@Override
	public boolean isBorderOpaque() {
		return true;
	}

}
