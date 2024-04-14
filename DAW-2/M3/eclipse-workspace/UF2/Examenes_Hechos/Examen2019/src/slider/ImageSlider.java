package slider;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import sax.SAX;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class Imageslider extends JFrame implements ActionListener {
	private BufferedImage collecioDimatges[];
	private JLabel etiqueta;
	private JButton btnLeft, btnRight;
	private int i, l1;
	private JPanel pnlImatges;

	public Imageslider() throws MyException {
		setLayout(new BorderLayout());
		setSize(800, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel p = new JPanel(new FlowLayout());
		btnLeft = new JButton();
		btnLeft.setIcon(new ImageIcon("src/slider/imgs/previous.png"));
		
		btnRight = new JButton();
		btnRight.setIcon(new ImageIcon("src/slider/imgs/next.png"));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu archivoMenu = new JMenu("Archivo");
		
		menuBar.add(archivoMenu);
		
		JMenuItem aboutMenuItem = new JMenuItem("Acerca de", KeyEvent.VK_B);
		aboutMenuItem.addActionListener(e -> mostrarVentanaAcercaDe());
		archivoMenu.add(aboutMenuItem);
		
		p.add(btnLeft);
		p.add(btnRight);
		add(p, BorderLayout.SOUTH);

		btnLeft.addActionListener(this);
		btnRight.addActionListener(this);
		try {
            SAX saxParser = new SAX();
            saxParser.run();
            
           String imagePath = saxParser.getImagePath();
           ArrayList<String>  imageRutes = saxParser.getImageRutes();

           int totalImages = imageRutes.size();
           collecioDimatges = new BufferedImage[totalImages];

            for (int i = 0; i < totalImages; i++) {
            	// Después de cargar la imagen desde el archivo en tu código
            	BufferedImage originalImage = ImageIO.read(new File(imagePath + imageRutes.get(i)));
            	collecioDimatges[i] = resizeImage(originalImage);

            }
			
//			collecioDimatges[0] = ImageIO.read(new File("src/slider/imgs/1.jpg"));			
//			collecioDimatges[1] = ImageIO.read(new File("src/slider/imgs/2.jpg"));
//			collecioDimatges[2] = ImageIO.read(new File("src/slider/imgs/3.jpg"));
//			collecioDimatges[3] = ImageIO.read(new File("src/slider/imgs/4.jpg"));
//			collecioDimatges[4] = ImageIO.read(new File("src/slider/imgs/5.jpg"));
//		collecioDimatges[5] = ImageIO.read(new File("src/slider/imgs/6.jpg"));
//			collecioDimatges[6] = ImageIO.read(new File("src/slider/imgs/7.jpg"));
		} catch (Exception e) {
			// Llança una nova excepció personalitzada (MyException)
			throw new MyException("1001", "Error loading images");
		}
		etiqueta = new JLabel("", JLabel.CENTER);
		add(etiqueta, BorderLayout.CENTER);
		etiqueta.setIcon(new ImageIcon(collecioDimatges[0]));

		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == btnLeft) {
				if (i == 0) {
					JOptionPane.showMessageDialog(null, "This is First Image");
				} else {
					i = i - 1;
					etiqueta.setIcon(new ImageIcon(collecioDimatges[i]));
				}
			}
			if (e.getSource() == btnRight) {
				if (i == collecioDimatges.length - 1) {
					JOptionPane.showMessageDialog(null, "This is Last Image");
				} else {
					i = i + 1;
					etiqueta.setIcon(new ImageIcon(collecioDimatges[i]));
				}
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
			// Captura l'excepció i mostra un missatge d'error
			JOptionPane.showMessageDialog(null, "Array index out of bounds: " + ex.getMessage());
		}
	}
	
	private void mostrarVentanaAcercaDe() {
		JFrame aboutFrame = new JFrame("Acerca de");
		aboutFrame.setSize(300, 200);
		aboutFrame.setLocationRelativeTo(pnlImatges);

		JLabel label = new JLabel("(c) Slider images v1.0");
		label.setHorizontalAlignment(JLabel.CENTER);

		aboutFrame.getContentPane().add(label);
		aboutFrame.setVisible(true);
	}
	
	   private BufferedImage resizeImage(BufferedImage originalImage) {
	        int newWidth = getWidth();
	        int newHeight = getHeight();

	        Image resultingImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
	        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);

	        Graphics2D g2d = resizedImage.createGraphics();
	        g2d.drawImage(resultingImage, 0, 0, null);
	        g2d.dispose();

	        return resizedImage;
	    }
}