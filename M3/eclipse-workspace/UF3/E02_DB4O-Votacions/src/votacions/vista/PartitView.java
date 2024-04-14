package votacions.vista;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import votacions.controlador.PrincipalController;
import votacions.model.objectes.Partit;
import votacions.vista.components.MiJTable;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;

public class PartitView extends View {
	private static final long serialVersionUID = 1L;
	private MiJTable tbl_1;
	private JButton btn_1;

	public PartitView(ArrayList<Partit> partits) {
		this.tbl_1 = new MiJTable();
		this.btn_1 = new JButton();
		
		this.btn_1.addKeyListener(this);
		this.btn_1.addMouseListener(this);
		
		init(partits);
	}

	private void init(ArrayList<Partit> partits) {
		super.generarFinestra(1280, 720, "Votacions - Partits");
		super.afegirMenu();
		afegirComponents(partits);
		mostrarPartits(partits);
	}

    public void afegirComponents(ArrayList<Partit> partits) {
    	JLabel lbl_fons = new JLabel();
  	    lbl_fons.setIcon(new ImageIcon(PrincipalView.class.getResource("/votacions/vista/recursos/minecraft.jpg")));
  	    lbl_fons.setHorizontalAlignment(SwingConstants.CENTER);
  	    lbl_fons.setVerticalAlignment(SwingConstants.CENTER);
  	    lbl_fons.setLayout(new BorderLayout());
  	    getContentPane().add(lbl_fons);
    	
    	JPanel pnl_north = new JPanel();
    	pnl_north.setOpaque(false);
        pnl_north.setBorder(new EmptyBorder(20, 20, 20, 20));
        lbl_fons.add(pnl_north, BorderLayout.NORTH);
        pnl_north.setLayout(new BorderLayout(0, 0));

        JLabel lbl_1 = new JLabel("PARTITS", SwingConstants.CENTER);
	    lbl_1.setForeground(new Color(149, 148, 148));
	    lbl_1.setFont(super.carregarFont("bold", 40));
	    lbl_1.setBorder(new EmptyBorder(0, -62, 0, 0));
	    pnl_north.add(lbl_1, BorderLayout.CENTER);
        
        pnl_north.add(this.btn_1, BorderLayout.WEST);

        JPanel pnl_center = new JPanel(new BorderLayout());
        pnl_center.setOpaque(false);
        pnl_center.setBorder(new EmptyBorder(0, 20, 20, 20));
        lbl_fons.add(pnl_center, BorderLayout.CENTER);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("NOM");
        model.addColumn("SIGLES");
        
        JLabel lbl_2 = new JLabel("Total Partits: " + partits.size());
        lbl_2.setFont(carregarFont("bold", 20));
        lbl_2.setForeground(Color.WHITE);
        lbl_2.setBorder(new EmptyBorder(0, 0, 10, 0));
        pnl_center.add(lbl_2, BorderLayout.NORTH);
        this.tbl_1.setModel(model);

        JScrollPane scrollPane_1 = new JScrollPane(this.tbl_1);
        scrollPane_1.setBackground(new Color(96, 96, 96));
        pnl_center.add(scrollPane_1, BorderLayout.CENTER);
        
        this.btn_1.setIcon(new ImageIcon(PrincipalView.class.getResource("/votacions/vista/recursos/tornar40.png")));
		this.btn_1.setBackground(new Color(149, 148, 148));
        
    }

    public void mostrarPartits(ArrayList<Partit> partits) {
        DefaultTableModel model = (DefaultTableModel) this.tbl_1.getModel();
        model.setRowCount(0);
        for (Partit partit : partits) {
            model.addRow(new Object[]{partit.getNom(), partit.getSigles()});
        }
    }

    @Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == this.btn_1) {
			PrincipalController.tornar(this);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			PrincipalController.tornar(this);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
}
