package about;

import java.awt.*;
import java.awt.event.*;
import java.io.InputStream;
import java.util.Arrays;

import javax.swing.*;

public class Dialeg extends JDialog {
	private static final long serialVersionUID = 1L;
	JLabel programa, autor, drets;
	JButton aceptar;
	JPanel principal, info, boto;

	public Dialeg() {
		super(new Frame(), "About...", true);

		this.setSize(400, 200);

		this.programa = new JLabel("El meu programa", JLabel.CENTER);
		this.autor = new JLabel("Toni Aguilar", JLabel.CENTER);
		this.drets = new JLabel("2022, Examen M03 UF5", JLabel.CENTER);
	

		this.aceptar = new JButton("OK");

		this.principal = new JPanel(new BorderLayout());
		this.info = new JPanel(new GridLayout(3, 1));
		this.boto = new JPanel(new FlowLayout());

		this.info.add(this.programa);
		this.info.add(this.autor);
		this.info.add(this.drets);

		this.boto.add(this.aceptar);

		this.principal.add(this.info, BorderLayout.CENTER);
		this.principal.add(this.boto, BorderLayout.SOUTH);

		this.getContentPane().add(this.principal);

		// CENTREM ELS DIALEG A LA PANTALLA
		Dimension pantalla, cuadro;
		pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		cuadro = this.getSize();

		this.setLocation(((pantalla.width - cuadro.width) / 2), (pantalla.height - cuadro.height) / 2);

		// AFEGIM EVENT AL BOTO
		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dispose();
			}
		});

	}
}
