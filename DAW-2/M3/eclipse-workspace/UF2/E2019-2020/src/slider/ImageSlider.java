package slider;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import org.xml.sax.SAXException;

import sax.SAX;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

class Imageslider extends JFrame implements ActionListener {
	private BufferedImage collecioDimatges[];
	private JLabel etiqueta;
	private JButton btnLeft, btnRight;
	private int i, l1;
	private JPanel pnlImatges;
	private List<String> fileNames;

	public Imageslider() throws IOException, SAXException {
		setLayout(new BorderLayout());
		setSize(800, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel p = new JPanel(new FlowLayout());
		btnLeft = new JButton("<<");
		btnRight = new JButton(">>");
		p.add(btnLeft);
		p.add(btnRight);
		add(p, BorderLayout.SOUTH);

		btnLeft.addActionListener(this);
		btnRight.addActionListener(this);

		SAX saxHandler = new SAX();
		saxHandler.run();
		this.fileNames = saxHandler.getFileNames();

	   collecioDimatges = new BufferedImage[7]; 
	   collecioDimatges[0] = ImageIO.read(new File("src/slider/imgs/1.jpg"));
	   collecioDimatges[1] = ImageIO.read(new File("src/slider/imgs/2.jpg"));
	   collecioDimatges[2] = ImageIO.read(new File("src/slider/imgs/3.jpg"));
	   collecioDimatges[3] = ImageIO.read(new File("src/slider/imgs/4.jpg"));
	   collecioDimatges[4] = ImageIO.read(new File("src/slider/imgs/5.jpg"));
	   collecioDimatges[5] = ImageIO.read(new File("src/slider/imgs/6.jpg"));
	   collecioDimatges[6] = ImageIO.read(new File("src/slider/imgs/7.jpg"));

	   etiqueta = new JLabel("",JLabel.CENTER); 
	   add(etiqueta,BorderLayout.CENTER);
	   etiqueta.setIcon(new ImageIcon(collecioDimatges[0]));

//		etiqueta = new JLabel("", JLabel.CENTER);
//		add(etiqueta, BorderLayout.CENTER);
//		etiqueta.setIcon(new ImageIcon(fileNames.get(0)));
//
//		setVisible(true);
	}

	public  void actionPerformed(ActionEvent e) {
	   if(e.getSource()==btnLeft) {
	       if(i==0) {
	           JOptionPane.showMessageDialog(null,"This is First Image");
	       } else {
	           i=i-1;
	           etiqueta.setIcon(new ImageIcon(collecioDimatges[i]));
	       }
	   }
	   if(e.getSource()==btnRight) {
	       if(i==collecioDimatges.length-1) {
	           JOptionPane.showMessageDialog(null,"This is LastImage");
	       } else {
	           i=i+1;
	           etiqueta.setIcon(new ImageIcon(collecioDimatges[i]));
	       }
	   }
	}

//	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == btnLeft) {
//			if (i == 0) {
//				JOptionPane.showMessageDialog(null, "This is First Image");
//			} else {
//				i = i - 1;
//				etiqueta.setIcon(new ImageIcon(this.fileNames.get(i)));
//			}
//		}
//		if (e.getSource() == btnRight) {
//			if (i == collecioDimatges.length - 1) {
//				JOptionPane.showMessageDialog(null, "This is LastImage");
//			} else {
//				i = i + 1;
//				etiqueta.setIcon(new ImageIcon(this.fileNames.get(i)));
//			}
//		}
//	}
}