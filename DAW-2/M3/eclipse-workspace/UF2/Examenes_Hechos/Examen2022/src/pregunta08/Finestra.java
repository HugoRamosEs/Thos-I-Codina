package pregunta08;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Finestra extends JFrame implements ActionListener {
	
	public Finestra() throws HeadlessException {
		super();
        setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelBotones = new JPanel();
        getContentPane().add(panelBotones, BorderLayout.SOUTH);

        JButton btnUno = new JButton("1");
        panelBotones.add(btnUno);
        btnUno.addActionListener(this);

        JButton btnDos = new JButton("2");
        panelBotones.add(btnDos);
        btnDos.addActionListener(this);
        
        JButton btnTres = new JButton("3");
        panelBotones.add(btnTres);
        btnTres.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton boton = (JButton) arg0.getSource();
		String btnNombre = boton.getText();
		
		if (btnNombre.equals("1")) {
			setTitle(btnNombre);
		} else if (btnNombre.equals("2")) {
			setTitle(btnNombre);
		} else if (btnNombre.equals("3")) {
			setTitle(btnNombre);
		}
	}

}
