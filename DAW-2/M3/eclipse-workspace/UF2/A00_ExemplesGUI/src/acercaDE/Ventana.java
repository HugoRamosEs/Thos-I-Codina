package acercaDE;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Ventana extends JFrame{

	//CREAMOS LA BARRA QUE CONTENDRA EL MENU

	JMenuBar barra = new JMenuBar();

 

	//CREAMOS EL MENU Y SUS OPCIONES

	JMenu programa = new JMenu("Programa");

	JMenuItem acerca = new JMenuItem("Acerca de...");

	JMenuItem salir = new JMenuItem("Salir");

 

	Ventana(){

		//LE COLOCAMOS UN NOMBRE A LA VENTANA

		super("Ventana en JAVA - SWING");

 

		//AGREGAMOS LA BARRA DE MENUS, JUNTO CON SUS MENUS Y OPCIONES

		setJMenuBar(barra);

		barra.add(programa);

 

		programa.add(acerca);

		programa.addSeparator();

		programa.add(salir);

 

		//ESTABLECEMOS EL ACCESO DIRECTO (Mediante ALT + (tecla)) PARA EL MENU Programa

		programa.setMnemonic('P'); //ALT + P

 

		//ESTABLECEMOS EL TAMA¥O DE LA VENTANA

		this.setSize(500, 500);

 

		setResizable(false);

 

		//AHORA CENTRAMOS LA VENTANA EN LA PANTALLA

		Dimension pantalla, cuadro;

		pantalla = Toolkit.getDefaultToolkit().getScreenSize();

		cuadro = this.getSize();

		this.setLocation(((pantalla.width - cuadro.width)/2), (pantalla.height - cuadro.height)/2);

 

		//LE COLOCAMOS TOOLTIPS A LAS OPCIONES DEL MENU

		acerca.setToolTipText("Muestra un Dialogo Acerca de...");

		salir.setToolTipText("Sale del Programa");

 

		//AHORA LE AGREGAMOS LOS EVENTOS A LAS OPCIONES DEL MENU

 

		//PRIMERO A LA OPCION QUE MUESTRA EL CUADRO DE DIALOGO Acerca de...

		acerca.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent evt){

				//INSTANCIAMOS LA CLASE QUE CREAMOS LLAMADA Dialogo

				Dialogo d = new Dialogo();

				//MOSTRAMOS ESE DIALOGO

				d.show();

			}

		});

 

		//AHORA EL EVENTO DE LA OPCION Salir

		salir.addActionListener(new ActionListener(){

		public void actionPerformed(ActionEvent evt){

			System.exit(0);

			}

		});

 

	}//FIN DEL CONSTRUCTOR DE LA CLASE Ventana

 

	//PROCEDIMIENTO PRINCIPAL

	public static void main(String g[]){

	Ventana p = new Ventana();

		p.show();

 

		//EL SIGUIENTE CODIGO PERMITE CERRAR LA VENTANA

		p.addWindowListener(new WindowAdapter(){

			public void windowClosing(WindowEvent evt){

				System.exit(0);

			}

		});

	}//FIN DEL PROCEDIMIENTO PRINCIPAL
}
 

