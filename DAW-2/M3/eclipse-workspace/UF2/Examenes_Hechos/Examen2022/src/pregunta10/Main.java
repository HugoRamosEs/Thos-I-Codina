package pregunta10;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main {

    private JFrame frame;
    private JLabel imageLabel;
    private Timer timer;
    private int currentImageIndex;
    private String[] imageFiles = { "src/img/1.jpg", "src/img/2.jpg", "src/img/3.jpg", "src/img/4.jpg" };

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
        frame.setBounds(100, 100, 600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear JPanel amb LayoutManager FlowLayout per centrar les imatges
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        frame.getContentPane().add(panel);

        // Crear JLabel per mostrar la imatge
        imageLabel = new JLabel();
        panel.add(imageLabel);

        // Inicialitzar el temporitzador per canviar la imatge cada 5 segons
        timer = new Timer(5000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showNextImage();
            }
        });
        timer.start();

        // Carregar la primera imatge
        showNextImage();
    }

    /**
     * Carregar i mostrar la següent imatge dels arxius d'imatges
     */
    private void showNextImage() {
        if (currentImageIndex >= imageFiles.length) {
            currentImageIndex = 0; // Reiniciar al principi si s'ha arribat al final
        }

        // Carregar la imatge i redimensionar-la
        ImageIcon icon = new ImageIcon(imageFiles[currentImageIndex]);
        Image image = icon.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);

        // Establir la imatge a la JLabel
        imageLabel.setIcon(icon);

        // Incrementar l'índex per a la següent crida
        currentImageIndex++;
    }
}
