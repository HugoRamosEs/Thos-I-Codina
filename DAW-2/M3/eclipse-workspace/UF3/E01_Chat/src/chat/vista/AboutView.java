package chat.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Finestra de diàleg amb informació sobre l'aplicació.
 * 
 * @version 1.0
 * @author Hugo
 */
public class AboutView extends JDialog {
	/**
	 * Serial version UID.
	 */
    private static final long serialVersionUID = 1L;
    
	/**
	 * Constructor de la finestra de diàleg.
	 * 
	 * @param frame Finestra principal de l'aplicació.
	 */
    public AboutView(JFrame frame) {
        super(frame, "About", true);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setSize(265, 300);
        this.setLocationRelativeTo(frame);
        this.setResizable(false);
        addComponents();
        this.setVisible(true);
    }
    
    /**
     * Afegeix els components a la finestra de diàleg.
     */
    public void addComponents() {
        JLabel lbl_aBackground = new JLabel("");
        lbl_aBackground.setIcon(new ImageIcon(AboutView.class.getResource("/chat/vista/resources/whatsapp-green_265px.jpg")));
        lbl_aBackground.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_aBackground.setLayout(new BorderLayout());
        getContentPane().add(lbl_aBackground);

        JLabel lbl_aImg = new JLabel("");
        lbl_aImg.setIcon(new ImageIcon(AboutView.class.getResource("/chat/vista/resources/app-logo_128px.png")));
        lbl_aImg.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_aBackground.add(lbl_aImg, BorderLayout.CENTER);

        JPanel pnl_sAbout = new JPanel(new GridLayout(4, 1));
        pnl_sAbout.setOpaque(false);
        lbl_aBackground.add(pnl_sAbout, BorderLayout.SOUTH);

        JLabel lbl_a1 = new JLabel("CHAT");
        lbl_a1.setFont(Utils.loadFont("bold", 24));
        lbl_a1.setForeground(Color.WHITE);
        lbl_a1.setHorizontalAlignment(SwingConstants.CENTER);
        pnl_sAbout.add(lbl_a1);

        JLabel lbl_a2 = new JLabel("Versió 1.0");
        lbl_a2.setFont(Utils.loadFont("plain", 14));
        lbl_a2.setForeground(Color.WHITE);
        lbl_a2.setHorizontalAlignment(SwingConstants.CENTER);
        pnl_sAbout.add(lbl_a2);

        JLabel lbl_a3 = new JLabel("© Hugo Ramos (2024)");
        lbl_a3.setFont(Utils.loadFont("plain", 14));
        lbl_a3.setForeground(Color.WHITE);
        lbl_a3.setHorizontalAlignment(SwingConstants.CENTER);
        pnl_sAbout.add(lbl_a3);
    }
}