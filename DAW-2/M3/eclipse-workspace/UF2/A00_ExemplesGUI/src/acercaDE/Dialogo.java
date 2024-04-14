package acercaDE;
/* LA SIGUIENTE APLICACION EN JAVA, MUESTRA UNA VENTANA CON JAVA - SWING,

   TIENE UN MENU Y MUESTRA COMO IMPLEMENTAR UNA CLASE PROPIA QUE

   HEREDE DE LA CLASE JDialog (TAMBIEN DE JAVA - SWING) PARA CREAR UN

   DIALOGO ACERCA DE...

*/

 

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

 

//PRIMERO CREAMOS UNA CLASE QUE HERE DE LA CLASE JDialog

class Dialogo extends JDialog{

	//AHORA CREAMOS LOS COMPONENTES QUE NECESITAMOS

	JLabel programa = new JLabel("Mi Programa en JAVA", JLabel.CENTER);

	JLabel autor = new JLabel("DESARROLLADO POR: Jose Miguel Galea Yrausquin", JLabel.CENTER);

	JLabel derechos = new JLabel("2002, Derechos Reservados", JLabel.CENTER);

 

	JButton aceptar = new JButton("Aceptar");

 

	//AHORA HACEMOS LOS PANELES QUE NECESITAMOS PARA ACOMODAR NUESTROS COMPONENTES

	JPanel principal = new JPanel(new BorderLayout());

	JPanel info = new JPanel(new GridLayout(3, 1));

	JPanel boton = new JPanel(new FlowLayout());

 

 

	//CONSTRUCTOR DE LA CLASE

	public Dialogo(){

		super(new Frame(), "Acerca de...", true);

 

		//AGREGAMOS AL PANEL info, LAS TRES ETIQUETAS QUE CREAMOS

		info.add(programa);

		info.add(autor);

		info.add(derechos);

 

		//AGREGAMOS AL PANEL boton, EL BOTON QUE CREAMOS

		boton.add(aceptar);

 

		//AHORA AGREGAMOS AL PANEL principal, LOS PANELES info, boton

		//QUE A SU VEZ CONTIENEN A TODOS LOS COMPONENTES

		principal.add("Center", info);

		principal.add("South", boton);

 

		//AGREGAMOS EL PANEL PRINCIPAL AL CUADRO DE DIALOGO

		getContentPane().add(principal);

 

		//ACOMODAMOS EL TAMA¥O DEL DIALOGO DE ACUERDO AL NUMERO DE COMPONENTES QUE TIENE

		pack();

 

		//INDICAMOS QUE NO PUEDAN CAMBIAR EL TAMA¥O DEL DIALOGO CON EL MOUSE

		setResizable(false);

 

		//CENTRAMOS EL DIALOGO EN LA PANTALLA

		Dimension pantalla, cuadro;

		pantalla = Toolkit.getDefaultToolkit().getScreenSize();

		cuadro = this.getSize();

 

		this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);

 

 

		//LE AGREGAMOS EL EVENTO AL BOTON

		aceptar.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent evt){

				dispose();

			}

		});

 

	}//FIN DEL CONSTRUCTOR DE LA CLASE Dialogo

 

}//FIN DE LA CLASE Dialogo

 