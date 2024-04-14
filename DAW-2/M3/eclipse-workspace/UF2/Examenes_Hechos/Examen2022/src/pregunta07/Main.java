package pregunta07;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

    private JFrame frame;

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

    public Main() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelBotones = new JPanel();
        frame.getContentPane().add(panelBotones, BorderLayout.SOUTH);

        JButton btnBlue = new JButton("Blue");
        btnBlue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                frame.getContentPane().setBackground(Color.BLUE);
                panelBotones.setBackground(Color.BLUE);
            }
        });
        panelBotones.add(btnBlue);

        JButton btnRed = new JButton("Red");
        btnRed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                frame.getContentPane().setBackground(Color.RED);
                panelBotones.setBackground(Color.RED);
            }
        });
        panelBotones.add(btnRed);
    }
}
