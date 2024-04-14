package pregunta09;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class Main {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main window = new Main();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Main() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear la barra de menú
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        // Menú A
        JMenu menuA = new JMenu("Menú A");
        menuBar.add(menuA);

        // Primer element del Menú A amb combinació de tecles
        JMenuItem menuAItem1 = new JMenuItem("Primer element del Menú A");
        menuAItem1.setAccelerator(KeyStroke.getKeyStroke("control shift K"));
        menuA.add(menuAItem1);

        // Segon element del Menú A
        JMenuItem menuAItem2 = new JMenuItem("Segon element del Menú A");
        menuA.add(menuAItem2);

        // Menú B
        JMenu menuB = new JMenu("Menú B");
        menuBar.add(menuB);

        // Elements del Menú B
        JMenuItem menuBItem1 = new JMenuItem("Primer element del Menú B");
        JMenuItem menuBItem2 = new JMenuItem("Segon element del Menú B");
        JMenuItem menuBItem3 = new JMenuItem("Tercer element del Menú B");

        // Afegir els elements al Menú B
        menuB.add(menuBItem1);
        menuB.add(menuBItem2);
        menuB.add(menuBItem3);

        // Afegir un separador
        menuB.addSeparator();

        // About amb combinació de tecles
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.setAccelerator(KeyStroke.getKeyStroke("control shift A"));
        menuB.add(aboutItem);

        // Sortir amb combinació de tecles
        JMenuItem exitItem = new JMenuItem("Sortir");
        exitItem.setAccelerator(KeyStroke.getKeyStroke("control alt F"));
        menuB.add(exitItem);

        // Acció per a l'item Sortir
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
