package slider;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageSlider extends JFrame implements ActionListener {
	private BufferedImage collecioDimatges[];
	private JLabel etiqueta;
	private JButton btnLeft, btnRight;
	private int i, l1;
	private JPanel pnlImatges;

	public ImageSlider() {
		setLayout(new BorderLayout());
		setSize(1000, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel pnlLeft = new JPanel(new FlowLayout());
		JPanel pnlRight = new JPanel(new FlowLayout());
		btnLeft = new JButton("");
		btnLeft.setIcon(new ImageIcon("src/imgs/leftArrow.png"));
		btnRight = new JButton("");
		btnRight.setIcon(new ImageIcon("src/imgs/rightArrow.png"));
		pnlLeft.add(btnLeft);
		pnlRight.add(btnRight);
		add(pnlLeft, BorderLayout.WEST);
		add(pnlRight, BorderLayout.EAST);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu AboutMenu = new JMenu("About");
		
		menuBar.add(AboutMenu);
		
		JMenuItem copyrightMenuItem = new JMenuItem("Copyright", KeyEvent.VK_B);
		copyrightMenuItem.addActionListener(e -> mostrarVentanaCopyright());
		AboutMenu.add(copyrightMenuItem);
		
		btnLeft.addActionListener(this);
		btnRight.addActionListener(this);

		JButton btnNewButton = new JButton("Alataque");
		add(btnNewButton, BorderLayout.SOUTH);
		MyWindow mywindow = new MyWindow();
		btnNewButton.addActionListener(e -> mywindow.setVisible(true));
		
		try {
			collecioDimatges = new BufferedImage[18];
			collecioDimatges[0] = resizeImage(ImageIO.read(new File("src/imgs/1.jpg")));
			collecioDimatges[1] = resizeImage(ImageIO.read(new File("src/imgs/2.jpg")));
			collecioDimatges[2] = resizeImage(ImageIO.read(new File("src/imgs/3.jpg")));
			collecioDimatges[3] = resizeImage(ImageIO.read(new File("src/imgs/4.jpg")));
			collecioDimatges[4] = resizeImage(ImageIO.read(new File("src/imgs/5.jpg")));
			collecioDimatges[5] = resizeImage(ImageIO.read(new File("src/imgs/6.jpg")));
			collecioDimatges[6] = resizeImage(ImageIO.read(new File("src/imgs/7.jpg")));
			collecioDimatges[7] = resizeImage(ImageIO.read(new File("src/imgs/8.jpg")));
			collecioDimatges[8] = resizeImage(ImageIO.read(new File("src/imgs/9.jpg")));
			collecioDimatges[9] = resizeImage(ImageIO.read(new File("src/imgs/10.gif")));
			collecioDimatges[10] = resizeImage(ImageIO.read(new File("src/imgs/11.gif")));
			collecioDimatges[11] = resizeImage(ImageIO.read(new File("src/imgs/12.jpg")));
			collecioDimatges[12] = resizeImage(ImageIO.read(new File("src/imgs/13.jpg")));
			collecioDimatges[13] = resizeImage(ImageIO.read(new File("src/imgs/14.jpeg")));
			collecioDimatges[14] = resizeImage(ImageIO.read(new File("src/imgs/15.jpg")));
			collecioDimatges[15] = resizeImage(ImageIO.read(new File("src/imgs/16.jpg")));
			collecioDimatges[16] = resizeImage(ImageIO.read(new File("src/imgs/17.jpeg")));

		} catch (IOException e) {
			throw new MyException("AA03", "Error loading images");
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
//	           JOptionPane.showMessageDialog(null,"This is First Image");
					throw new MyException("AA02", "This is the first image");
				} else {
					i = i - 1;
					etiqueta.setIcon(new ImageIcon(collecioDimatges[i]));
				}
			}
			if (e.getSource() == btnRight) {
				if (i == collecioDimatges.length - 1) {
//	           JOptionPane.showMessageDialog(null,"This is LastImage");
					throw new MyException("AA01", "This is the last image");
				} else {
					i = i + 1;
					etiqueta.setIcon(new ImageIcon(collecioDimatges[i]));
				}
			}
		} catch (MyException ex) {
			// Tractament de l'excepció MyException
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace(); // Imprimir la pila d'excepcions
		}
	}
	
	private void mostrarVentanaCopyright() {
		JFrame aboutFrame = new JFrame("Copyright");
		aboutFrame.setSize(300, 200);
		aboutFrame.setLocationRelativeTo(pnlImatges);

		JLabel label = new JLabel("(c) Slider images v1.0");
		label.setHorizontalAlignment(JLabel.CENTER);

		aboutFrame.getContentPane().add(label);
		aboutFrame.setVisible(true);
	}
	
	 private BufferedImage resizeImage(BufferedImage originalImage) {
	        int newWidth = 800;
	        int newHeight = 533;

	        Image resultingImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
	        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);

	        Graphics2D g2d = resizedImage.createGraphics();
	        g2d.drawImage(resultingImage, 0, 0, null);
	        g2d.dispose();

	        return resizedImage;
	    }
}