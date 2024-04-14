package acercaDE;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

// Fem servir JDialeg per personalitzar-la
public class Dialeg extends JDialog{
	private JLabel programa;
	private JLabel autor;
	private	JLabel derechos;
	private	JLabel direccion;
	private	JLabel telefono;
	private JButton aceptar;
	private JLabel logo;

	private JPanel principal;
	private JPanel info;
	private JPanel boton;
	private JPanel logotip;

	public Dialeg(){
		super(new Frame(), "Acerca de...", true);
		
		this.programa = new JLabel("La meva calcularora en JAVA", JLabel.CENTER);
		this.autor = new JLabel("DESENVOLUPADA PER: Toni Aguilar", JLabel.CENTER);
		this.derechos = new JLabel("(c) Thos i Codina", JLabel.CENTER);
		this.direccion = new JLabel("Riera de Cirera, 57 - 08304, Mataró", JLabel.CENTER);
		this.telefono = new JLabel("Telèfon: 937 414 203", JLabel.CENTER);

		this.logo = new JLabel("");
		this.logo.setIcon(new ImageIcon("src/img/logo.png"));
		
		this.aceptar = new JButton("Aceptar");

		// Panels per emmagatzemar els nostres components
		this.principal = new JPanel(new BorderLayout());
		this.info = new JPanel(new GridLayout(7, 1));
		this.boton = new JPanel(new FlowLayout());
		this.logotip = new JPanel(new FlowLayout());
		this.logotip.setBackground(Color.RED);

 		//Afegim al panel INFO les tres etiquetes que hem crat
		
		info.add(programa);
		info.add(autor);
		info.add(derechos);
		info.add(direccion);
		info.add(telefono);

		//Afegim el botó
		boton.add(aceptar);
		
		//Afefim el logo
		logotip.add(logo);

		//Afegim al panel principal, els panels info i boto que contenen tots els pomponents
		principal.add("North", logotip);
		principal.add("Center", info);
		principal.add("South", boton);

		//Afegim al panell principal el quadre de diàleg
		getContentPane().add(principal);

		//ajustem el tamany en funció del nombre de components
		pack();
		setResizable(false);

 

		//Centrem el diàleg a la pantalla
		Dimension pantalla, cuadro;
		pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		cuadro = this.getSize();
		this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);

		//Afegim l'event al botó

		aceptar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});
	}

 

}
 