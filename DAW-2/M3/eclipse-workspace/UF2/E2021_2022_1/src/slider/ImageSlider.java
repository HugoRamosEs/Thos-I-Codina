package slider;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import org.xml.sax.SAXException;

import about.Dialeg;
import sax.Arxiu;
import sax.SAX;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

class Imageslider extends JFrame implements ActionListener {
//	private Diapo colImatges[];
	private ArrayList<Arxiu> colImatges;

	private JLabel etiqueta, titol;
	private JButton btnStop, btnStart;
	private int i, l1;
	private JPanel pnlImatges;

	// About
	JMenuBar barra;
	JMenu programa;
	JMenuItem sobre, sortir;

	// Timer
	private javax.swing.Timer timer;

	public Imageslider() throws FileNotFoundException, SAXException, IOException {

		this.barra = new JMenuBar();
		this.programa = new JMenu("About");

		this.sobre = new JMenuItem("About...");
		this.sobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Dialeg d = new Dialeg();
				d.show();
			}
		});
		this.sortir = new JMenuItem("Exit");
		this.sortir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				System.exit(0);
			}
		});
		this.programa.add(this.sobre);
		this.programa.addSeparator();
		this.programa.add(this.sortir);

		this.barra.add(this.programa);
		this.setJMenuBar(this.barra);

		this.setLayout(new BorderLayout());
		//this.setSize(800, 700);
		this.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width, java.awt.Toolkit.getDefaultToolkit().getScreenSize().height-50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel p = new JPanel(new FlowLayout());
		btnStop = new JButton(" ");
		btnStop.setIcon(new ImageIcon("src/slider/imgs/Stop.png"));

		btnStart = new JButton(" ");
		btnStart.setIcon(new ImageIcon("src/slider/imgs/Start.png"));

		p.add(btnStop);
		p.add(btnStart);
		add(p, BorderLayout.SOUTH);
		btnStop.addActionListener(this);
		btnStart.addActionListener(this);
		
		SAX saxParser = new SAX("src/slider/config.xml");
		saxParser.run();
		this.colImatges = saxParser.getDiapo();
		
		System.out.println(colImatges.get(0).getPath());

		if (!colImatges.isEmpty()) {
		    etiqueta = new JLabel("", JLabel.CENTER);
		    add(etiqueta, BorderLayout.CENTER);
		    etiqueta.setIcon(new ImageIcon(this.resize(arxiuToBufferedImage(colImatges.get(0)), 20, 20)));
		    

		    titol = new JLabel(colImatges.get(0).getDescripcio(), JLabel.CENTER);
		    titol.setFont(new Font("Purisa", Font.PLAIN, 25));
		    titol.setForeground(new Color(255, 0, 0));
		    add(titol, BorderLayout.NORTH);

		    this.temporitzador();

		    setVisible(true);
		} else {
		    System.out.println("La lista colImatges está vacía.");
		    }
		}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnStop) {
			this.timer.stop();
		} else if (e.getSource() == btnStart) {
			this.timer.start();
		} else {
			i = i + 1;
			etiqueta.setIcon(new ImageIcon(this.resize(arxiuToBufferedImage(colImatges.get(i)), 20, 20)));
			titol.setText(colImatges.get(i).getDescripcio());
		}
	}

	public void temporitzador() {
		this.timer = new javax.swing.Timer(1500, this);
	}
	
	public BufferedImage resize(BufferedImage originalImage, int newWidth, int newHeight) {
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
        g.dispose();

        return resizedImage;
    }
	
	// BufferedImage originalImage = ...; // Aquí carga tu imagen original
//    int newWidth = 200;
//    int newHeight = 200;
	//  BufferedImage resizedImage = resize(originalImage, newWidth, newHeight);

	public static BufferedImage arxiuToBufferedImage(Arxiu arxiu) {
		BufferedImage bufferedImage = null;
		try {
			File file = new File(arxiu.getPath());
			bufferedImage = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bufferedImage;
	}
}