package eventos;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;


public class Teclas extends JFrame implements KeyListener{
    BorderLayout borde = new BorderLayout();
    JLabel mensaje = new JLabel("Para comenzar pulse una tecla cualquiera:");
   
    JLabel tecla = new JLabel("");
    public Teclas(){
        super("Demostración de KeyListener");
        setSize(350,100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(this);
        setLayout(borde);
        add(mensaje, BorderLayout.NORTH);
       
        add(tecla, BorderLayout.WEST);
        setVisible(true);
    }
    public static void main(String[] dario){
        new Teclas();
    }
    public void keyTyped(KeyEvent e) {
            tecla.setText("Tecla Pulsada = '" + e.getKeyChar() + "'");
    }
    public void keyPressed(KeyEvent e) {
       
    }
    public void keyReleased(KeyEvent e) {
       
    }
}