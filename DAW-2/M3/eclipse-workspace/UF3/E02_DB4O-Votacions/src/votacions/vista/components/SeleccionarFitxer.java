package votacions.vista.components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import votacions.vista.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

public class SeleccionarFitxer extends JDialog {
    private static final long serialVersionUID = 1L;
    private JTextField textField;

    public SeleccionarFitxer(JFrame parent) {
        super(parent, "Fitxer", true);
        this.textField = new JTextField(20);
        
        setLocationRelativeTo(parent);
        setResizable(false);
        afegirComponents();
        centrar();
    }

    private void centrar() {
        Dimension parentSize = getParent().getSize();
        Dimension dialogSize = getSize();
        int x = (parentSize.width - dialogSize.width) / 2;
        int y = (parentSize.height - dialogSize.height) / 2;
        setLocation(getParent().getX() + x, getParent().getY() + y);
    }
    
    public void afegirComponents() {
        JPanel pnl_1 = new JPanel(new GridLayout(5, 1, 5, 5));
        pnl_1.setBackground(new Color(38, 27, 19));
        pnl_1.setBorder(new EmptyBorder(10, 20, 10, 20));
        getContentPane().add(pnl_1);

        JLabel lbl_1 = new JLabel("SELECCIONA UN FITXER CSV", SwingConstants.CENTER);
	    lbl_1.setForeground(new Color(149, 148, 148));
	    lbl_1.setFont(carregarFont("bold", 18));
	    pnl_1.add(lbl_1, BorderLayout.CENTER);

        JPanel pnl_2 = new JPanel(new GridLayout(1, 2, 5, 10));
        pnl_2.setBackground(new Color(38, 27, 19));
        
        JButton btn_1 = new JButton("Importar...");
        btn_1.setForeground(Color.WHITE);
        btn_1.setFont(carregarFont("plain", 13));
        btn_1.setBackground(new Color(149, 148, 148));
        btn_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc_1 = new JFileChooser();
                int valor = fc_1.showOpenDialog(SeleccionarFitxer.this);
                if (valor == JFileChooser.APPROVE_OPTION) {
                    textField.setText(fc_1.getSelectedFile().getPath());
                }
            }
        });

        JButton btn_2 = new JButton("OK");
        btn_2.setFont(carregarFont("plain", 13));
        btn_2.setForeground(Color.WHITE);
        btn_2.setBackground(new Color(149, 148, 148));
        btn_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JLabel lbl_2 = new JLabel("Aquesta acció pot demorar uns segons...");
        lbl_2.setForeground(Color.RED);
        lbl_2.setFont(carregarFont("plain", 12));
        lbl_2.setVerticalAlignment(SwingConstants.BOTTOM);
        
        JLabel lbl_3 = new JLabel("No es preocupi si l'aplicació queda aturada.");
        lbl_3.setForeground(Color.RED);
        lbl_3.setFont(carregarFont("plain", 12));
        lbl_3.setVerticalAlignment(SwingConstants.TOP);
        
        this.textField.setFont(carregarFont("plain", 14));
        this.textField.setBackground(new Color(149, 148, 148));
        this.textField.setForeground(Color.WHITE);

        pnl_1.add(lbl_1);
        pnl_1.add(this.textField);
        pnl_1.add(pnl_2);
        pnl_1.add(lbl_2);
        pnl_1.add(lbl_3);
        
        pnl_2.add(btn_1);
        pnl_2.add(btn_2);
        pack();
    }
    
    public int estilFont(String estil) {
	    switch (estil.toLowerCase()) {
	        case "plain":
	            return Font.PLAIN;
	        case "bold":
	            return Font.BOLD;
	        case "italic":
	            return Font.ITALIC;
	        case "bolditalic":
	            return Font.BOLD | Font.ITALIC;
	        default:
	            return Font.PLAIN;
	    }
	}
	
	public Font carregarFont(String estil, int tamany) {
        try (InputStream is = View.class.getResourceAsStream("/votacions/vista/recursos/minecraftia.ttf")) {
            return Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(estilFont(estil), tamany);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            return new Font("Arial", estilFont(estil), tamany);
        }
    }

    public String getRuta() {
        return textField.getText();
    }
}
