package pregunta10;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class ImageResizer {
	private int width;
    private int height;

    public ImageResizer(int targetWidth, int targetHeight) {
        this.width = targetWidth;
        this.height = targetHeight;
    }

    public BufferedImage resize(BufferedImage bufferedImage) {
        int originalWidth = bufferedImage.getWidth();
        int originalHeight = bufferedImage.getHeight();

        BufferedImage resizedImage = new BufferedImage(this.width, this.height, bufferedImage.getType());
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.drawImage(bufferedImage, 0, 0, this.width, this.height, 0, 0, originalWidth, originalHeight, null);
        graphics2D.dispose();

        return resizedImage;
    }

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
