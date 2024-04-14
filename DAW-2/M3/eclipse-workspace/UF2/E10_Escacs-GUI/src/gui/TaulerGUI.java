package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import joc.*;
import peces.*;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

public class TaulerGUI {
	private JFrame frame;
	private Tauler tauler;
	private MyColor torn;
	private Posicio posicioIniSeleccionada;
	private JLabel[][] lbl;
	private JLabel lbl_torn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaulerGUI window = new TaulerGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws InvalidMovementException
	 */
	public TaulerGUI() throws InvalidMovementException {
		this.frame = new JFrame();
		this.tauler = new Tauler();
		this.torn = MyColor.BLANC;
		this.lbl_torn = new JLabel();
		this.posicioIniSeleccionada = null;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws InvalidMovementException
	 */
	private void initialize() throws InvalidMovementException {
		this.frame.setTitle("Escacs");
		this.frame.setBounds(100, 100, 1280, 720);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setIconImage(Toolkit.getDefaultToolkit().getImage(TaulerGUI.class.getResource("/img/torre_b.png")));
		this.frame.setResizable(false);

		this.tauler.crearPartida();

		JPanel pnl_center = new JPanel();
		pnl_center.setBorder(new EmptyBorder(0, 300, 15, 300));
		this.lbl = generarTauler(pnl_center);
		
		this.lbl_torn.setText("Torn: Blanques");
		this.lbl_torn.setHorizontalAlignment(JLabel.CENTER);
		this.lbl_torn.setPreferredSize(new Dimension(200, 30));
		this.lbl_torn.setFont(new Font("Arial", Font.BOLD, 18));
	    this.frame.getContentPane().add(lbl_torn, BorderLayout.NORTH);
		
		this.frame.getContentPane().add(pnl_center);
		actualitzarTauler();
		this.tauler.imprimirTauler();

		this.frame.setVisible(true);
	}

	private JLabel[][] generarTauler(JPanel pnl_center) {
		pnl_center.setLayout(new GridLayout(8, 8));
		JLabel[][] lbl = new JLabel[8][8];

		for (int j = 7; j >= 0; j--) {
			for (int i = 0; i < lbl[j].length; i++) {
				lbl[i][j] = new JLabel();
				lbl[i][j].setOpaque(true);
				final int iF = i;
				final int jF = j;
				lbl[i][j].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							mourePeca(iF, jF);
							actualitzarTauler();
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,"Posa't en contacte amb l'administrador", "Problema irresoluble", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				pnl_center.add(lbl[i][j]);
			}
		}
		return lbl;
	}

	private void actualitzarTauler() {
		boolean casellaBlanca = false;
		for (int j = 7; j >= 0; j--) {
			for (int i = 0; i < this.lbl[j].length; i++) {
				if ((i + j) % 2 == 0) {
					casellaBlanca = false;
				} else {
					casellaBlanca = true;
				}
				Peca peca = this.tauler.getPeca(new Posicio(i, j));
				if (peca != null) {
					this.lbl[i][j].setHorizontalAlignment(JLabel.CENTER);
					this.lbl[i][j].setVerticalAlignment(JLabel.CENTER);
					this.lbl[i][j].setIcon(new ImageIcon(
							TaulerGUI.class.getResource("/img/" + peca.getClass().getSimpleName().toLowerCase() + "_"
									+ peca.getEquip().toString().toLowerCase().charAt(0) + ".png")));
				} else {
					this.lbl[i][j].setIcon(null);
				}

				if (casellaBlanca) {
					this.lbl[i][j].setBackground(Color.WHITE);
				} else {
					this.lbl[i][j].setBackground(Color.BLACK);
				}
				
				this.lbl[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
				casellaBlanca = !casellaBlanca;
			}
		}

		if (this.posicioIniSeleccionada != null) {
			boolean[][] movimentsPosibles = this.tauler.getPeca(this.posicioIniSeleccionada).movimentsPosibles(this.tauler);
			for (int j = 7; j >= 0; j--) {
				for (int i = 0; i < movimentsPosibles[j].length; i++) {
					if (movimentsPosibles[i][j] == true) {
						this.lbl[i][j].setBackground(new Color(242, 173, 173));
						this.lbl[i][j].setBorder(BorderFactory.createLineBorder(Color.RED, 2));
					}
				}
			}
		}
	}

	private void mourePeca(int i, int j) {
		try {
			if (this.posicioIniSeleccionada == null) {				
				if (this.tauler.getPeca(new Posicio(i, j)) == null) {
					throw new InvalidMovementException("A001", "No hi ha peça en aquest escac del tauler");
				}
				if (this.tauler.getPeca((new Posicio(i, j))).getEquip() != this.torn) {
					throw new WrongTurnException();
				}
				if (!this.tauler.getPeca((new Posicio(i, j))).hihaMovimentsPosibles(this.tauler)) {
					throw new InvalidMovementException("A002", "Amb aquesta peça no hi ha moviments possibles, escull una altre");
				}
				
				this.posicioIniSeleccionada = new Posicio(i, j);
			} else {
				boolean[][] movimentsPosibles = this.tauler.getPeca(this.posicioIniSeleccionada).movimentsPosibles(this.tauler);

				if (movimentsPosibles[i][j]) {
					this.tauler.mouPeca(posicioIniSeleccionada, new Posicio(i, j));
					posicioIniSeleccionada = null;
					actualitzarTauler();
					this.tauler.imprimirTauler();
					if (this.torn == MyColor.BLANC) {
						this.torn = MyColor.NEGRE;
						this.lbl_torn.setText("Torn: Negres");
					} else {
						this.torn = MyColor.BLANC;
						this.lbl_torn.setText("Torn: Blanques");
					}
					// JOptionPane.showMessageDialog(null,"Moviment realitzat... " , "Ok...", JOptionPane.INFORMATION_MESSAGE);
				} else {
					throw new InvalidMovementException("A003", "Posició incorrecte. Si us plau, tria una peça de nou...");
				}
			}
		} catch (InvalidMovementException ime) {
			JOptionPane.showMessageDialog(null, ime.getMessage(), "Noooo.....", JOptionPane.ERROR_MESSAGE);
			this.posicioIniSeleccionada = null;
		} catch (WrongTurnException wte) {
			JOptionPane.showMessageDialog(null, "No és el teu torn.... ", "Noooo.....", JOptionPane.ERROR_MESSAGE);
			this.posicioIniSeleccionada = null;
		}
	}
}
