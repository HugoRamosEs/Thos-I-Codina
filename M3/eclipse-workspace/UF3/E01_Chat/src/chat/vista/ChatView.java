package chat.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.Timer;

import chat.model.*;
import chat.model.objectes.*;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ChatView extends JFrame implements MouseListener {
	private static final long serialVersionUID = 1L;
	private JTextField textField_message;
	private JTextField textField_user;
	private JPanel pnl_west;
	private JPanel pnl_west_center_center;
	private JPanel pnl_west_north_center;
	private JPanel pnl_west_north_west;
	private JPanel pnl_center_north_center;
	private JPanel pnl_west_center_north;
	private JPanel pnl_center_bottom;
	private JPanel pnl_center_north_west;
	private JPanel pnl_center_center_center_east;
	private JPanel pnl_center_center_center_west;
	private JSplitPane pnl_center_center_center;
	private JLabel lbl_3;
	private JLabel lbl_usuaris;
	private JLabel lbl_center_center;
	private JButton btn_conectar;
	private JButton btn_desconectar;
	private JButton btn_enviar;
	
	private UsuariModel usuariModel;
	private ArrayList<Usuari> usuaris;
	private MissatgeModel missatgeModel;
	private ArrayList<Missatge> missatges;
	private ArrayList<String> usuarisConectats;
	
	private Timer timer;
	private boolean usuariConectat;
	private boolean darkMode;
	private String usuariNick;
	
	public ChatView() {
		this.usuariModel = new UsuariModel();
		this.usuaris = new ArrayList<Usuari>();
		this.missatgeModel = new MissatgeModel();
		this.missatges = new ArrayList<Missatge>();
		this.usuarisConectats = new ArrayList<String>();
		
		this.usuariConectat = false;
		this.darkMode = true;
		this.usuariNick = "";
		
		init();
	}
	
	private void init() {
		generateWindow();
		addComponents();
		addConnectButton();
		addUsuariViews();
		addUsuarisToLabel();
		addTimer();
		changeTheme();
		this.setVisible(true);
//		this.textField_user.requestFocusInWindow();
	}
	
	private void generateWindow() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) (screenSize.getWidth() - 1600) / 2;
		int y = (int) (screenSize.getHeight() - 900) / 2;
		this.setBounds(x, y, 1600, 900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("ChatView");
		this.getContentPane().setLayout(new BorderLayout(0, 0));
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(ChatView.class.getResource("/chat/vista/resources/app-logo_128px.png")));
		
		this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
				if (usuariConectat) {
					disconnect();
				}
				
				MySQLModel.close();
                dispose();
            }
        });
	}
	
	private void addComponents() {
	    JPanel pnl_main = new JPanel();
	    getContentPane().add(pnl_main, BorderLayout.CENTER);
	    pnl_main.setLayout(new BorderLayout());
	    
	    this.pnl_west = new JPanel();
	    this.pnl_west.setPreferredSize(new Dimension(410, 0));
	    this.pnl_west.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(49, 56, 61)));
	    pnl_main.add(this.pnl_west, BorderLayout.WEST);
	    this.pnl_west.setLayout(new BorderLayout(0, 0));
	    
	    JPanel pnl_west_north = new JPanel();
	    pnl_west_north.setPreferredSize(new Dimension(0, 60));
	    this.pnl_west.add(pnl_west_north, BorderLayout.NORTH);
	    pnl_west_north.setLayout(new BorderLayout(0, 0));
	    
	    this.pnl_west_north_west = new JPanel();
	    this.pnl_west_north_west.setBackground(new Color(32, 43, 51));
	    this.pnl_west_north_west.setPreferredSize(new Dimension(75, 0));
	    pnl_west_north.add(this.pnl_west_north_west, BorderLayout.WEST);
	    
	    JLabel lbl_1 = new JLabel("");
	    lbl_1.setBorder(new EmptyBorder(4, 0, 0, 0));
	    lbl_1.setIcon(new ImageIcon(ChatView.class.getResource("/chat/vista/resources/avatar_41px.png")));
	    this.pnl_west_north_west.add(lbl_1);
	    
	    this.pnl_west_north_center = new JPanel();
	    this.pnl_west_north_center.setBorder(new EmptyBorder(15, 100, 15, 17));
	    this.pnl_west_north_center.setBackground(new Color(32, 43, 51));
	    pnl_west_north.add(this.pnl_west_north_center, BorderLayout.CENTER);
	    this.pnl_west_north_center.setLayout(new GridLayout(0, 1, 0, 15));
	    
	    JPanel pnl_west_center = new JPanel();
		pnl_west_center.setBackground(new Color(17, 27, 33));
	    pnl_west.add(pnl_west_center, BorderLayout.CENTER);
	    pnl_west_center.setLayout(new BorderLayout(0, 0));
		
	    this.pnl_west_center_center = new JPanel();
	    this.pnl_west_center_center.setBackground(new Color(17, 27, 33));
		pnl_west_center.add(this.pnl_west_center_center, BorderLayout.CENTER);
		
		this.textField_user = new JTextField();
	    this.textField_user.setBackground(new Color(32, 43, 51));
	    this.textField_user.setBorder(new EmptyBorder(0, 10, 0, 10));
	    this.textField_user.setPreferredSize(new Dimension(10, 10));
	    this.textField_user.setForeground(new Color(233, 237, 239));
	    this.textField_user.setFont(new Font("Dialog", Font.ITALIC, 16));
	    this.textField_user.setText("Escriu un nom d'usuari...");
	    this.textField_user.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textField_user.getText().isEmpty()) {
					textField_user.setText("Escriu un nom d'usuari...");
					textField_user.setFont(new Font("Dialog", Font.ITALIC, 16));
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if (textField_user.getText().equals("Escriu un nom d'usuari...")) {
					textField_user.setText("");
					textField_user.setFont(new Font("Dialog", Font.PLAIN, 16));
				}
			}
		});
		
		this.pnl_west_center_north = new JPanel();
		this.pnl_west_center_north.setBackground(new Color(17, 27, 33));
		this.pnl_west_center_north.setBorder(new EmptyBorder(12, 17, 6, 17));
		this.pnl_west_center_north.setPreferredSize(new Dimension(0, 46));
		pnl_west_center.add(this.pnl_west_center_north, BorderLayout.NORTH);
		this.pnl_west_center_north.setLayout(new BorderLayout(0, 0));
		this.pnl_west_center_north.add(this.textField_user, BorderLayout.CENTER);
	    
	    JPanel pnl_center = new JPanel();
	    pnl_center.setBackground(Color.ORANGE);
	    pnl_main.add(pnl_center, BorderLayout.CENTER);
	    pnl_center.setLayout(new BorderLayout(0, 0));
	    
	    JPanel pnl_center_north = new JPanel();
	    pnl_center_north.setBackground(new Color(32, 43, 51));
	    pnl_center_north.setPreferredSize(new Dimension(0, 60));
	    pnl_center.add(pnl_center_north, BorderLayout.NORTH);
	    pnl_center_north.setLayout(new BorderLayout(0, 0));
	    
	    this.pnl_center_north_west = new JPanel();
	    this.pnl_center_north_west.setPreferredSize(new Dimension(75, 0));
	    this.pnl_center_north_west.setBackground(new Color(32, 43, 51));
	    pnl_center_north.add(this.pnl_center_north_west, BorderLayout.WEST);
	    
	    JLabel lbl_2 = new JLabel("");
	    lbl_2.setBorder(new EmptyBorder(4, 0, 0, 0));
	    lbl_2.setIcon(new ImageIcon(ChatView.class.getResource("/chat/vista/resources/avatar_41px.png")));
	    this.pnl_center_north_west.add(lbl_2);
	    
	    this.pnl_center_north_center = new JPanel();
	    this.pnl_center_north_center.setBorder(new EmptyBorder(8, 0, 8, 0));
	    this.pnl_center_north_center.setBackground(new Color(32, 43, 51));
	    pnl_center_north.add(this.pnl_center_north_center, BorderLayout.CENTER);
	    this.pnl_center_north_center.setLayout(new GridLayout(2, 1, 0, 0));
	    
	    this.lbl_3 = new JLabel("Chat");
	    this.lbl_3.setBorder(new EmptyBorder(0, -1, 0, 0));
	    this.lbl_3.setFont(new Font("Dialog", Font.BOLD, 18));
	    this.lbl_3.setForeground(new Color(233, 237, 239));
	    this.pnl_center_north_center.add(this.lbl_3);
	    
	    this.lbl_usuaris = new JLabel("");
	    this.lbl_usuaris.setFont(new Font("Dialog", Font.PLAIN, 12));
	    this.lbl_usuaris.setForeground(new Color(134, 150, 160));
	    this.pnl_center_north_center.add(this.lbl_usuaris);
	    
	    this.pnl_center_bottom = new JPanel();
	    this.pnl_center_bottom.setBorder(new EmptyBorder(12, 12, 12, 12));
	    this.pnl_center_bottom.setBackground(new Color(32, 43, 51));
	    this.pnl_center_bottom.setPreferredSize(new Dimension(0, 65));
	    pnl_center.add(this.pnl_center_bottom, BorderLayout.SOUTH);
	    this.pnl_center_bottom.setLayout(new BorderLayout(5, 0));
	    
	    this.textField_message = new JTextField();
	    this.textField_message.setBorder(new EmptyBorder(0, 10, 0, 10));
	    this.textField_message.setBackground(new Color(42, 57, 66));
	    this.textField_message.setForeground(new Color(233, 237, 239));
	    this.textField_message.setEnabled(false);
	    this.textField_message.setFont(new Font("Dialog", Font.ITALIC, 16));
	    this.textField_message.setText("Escriu un missatge...");
	    this.textField_message.addFocusListener(new FocusAdapter() {
	    	@Override
	    	public void focusLost(FocusEvent e) {
	    		if (textField_message.getText().isEmpty()) {
	    		    textField_message.setText("Escriu un missatge...");
	    		    textField_message.setFont(new Font("Dialog", Font.ITALIC, 16));
	    		}
	    	}
	    	@Override
	    	public void focusGained(FocusEvent e) {
				if (textField_message.getText().equals("Escriu un missatge...")) {
					textField_message.setText("");
					textField_message.setFont(new Font("Dialog", Font.PLAIN, 16));
				}
	    	}
	    });
	    this.pnl_center_bottom.add(this.textField_message, BorderLayout.CENTER);
	    
	    this.btn_enviar = new JButton("");
	    this.btn_enviar.setBorder(null);
	    this.btn_enviar.setBackground(new Color(32, 43, 51));
	    this.btn_enviar.setIcon(new ImageIcon(ChatView.class.getResource("/chat/vista/resources/enviar_64px.png")));
	    this.pnl_center_bottom.add(this.btn_enviar, BorderLayout.EAST);
	    
	    this.lbl_center_center = new JLabel("");
	    this.lbl_center_center.setIcon(new ImageIcon(ChatView.class.getResource("/chat/vista/resources/whatsapp_1388px.png")));
	    this.lbl_center_center.setLayout(new BorderLayout(0, 0));
	    pnl_center.add(this.lbl_center_center, BorderLayout.CENTER);
	    
	    this.pnl_center_center_center_east = new JPanel();
	    FlowLayout flowLayout = (FlowLayout) pnl_center_center_center_east.getLayout();
	    flowLayout.setAlignment(FlowLayout.LEFT);
	    pnl_center_center_center_east.setBorder(null);
	    this.pnl_center_center_center_east.setOpaque(false);

	    this.pnl_center_center_center_west = new JPanel();
	    FlowLayout flowLayout_1 = (FlowLayout) pnl_center_center_center_west.getLayout();
	    flowLayout_1.setAlignment(FlowLayout.RIGHT);
	    this.pnl_center_center_center_west.setOpaque(false);

	    this.pnl_center_center_center = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, this.pnl_center_center_center_east, this.pnl_center_center_center_west);
	    pnl_center_center_center.setBorder(new EmptyBorder(10, 50, 10, 50));
	    this.pnl_center_center_center.setOpaque(false);
	    this.pnl_center_center_center.setResizeWeight(0.5);
	    this.pnl_center_center_center.setEnabled(false);
	    this.pnl_center_center_center.setDividerSize(0);
	    
	    this.lbl_center_center.add(this.pnl_center_center_center, BorderLayout.CENTER);
	    
	    JMenuBar menuBar_1 = new JMenuBar();
	    menuBar_1.setBorder(new EmptyBorder(0, 12, 0, 12));
		setJMenuBar(menuBar_1);
		
		JMenu mnMen_1 = new JMenu("Menú");
		menuBar_1.add(mnMen_1);
		
		JMenuItem mntm_about = new JMenuItem("About");
		mntm_about.setAccelerator(KeyStroke.getKeyStroke("control A"));
		mnMen_1.add(mntm_about);
		
		JCheckBoxMenuItem chckbxmntm_1 = new JCheckBoxMenuItem("Tema Oscur");
		chckbxmntm_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				darkMode = chckbxmntm_1.isSelected();
				changeTheme();
			}
		});
		mnMen_1.add(chckbxmntm_1);
		
		JSeparator separator_1 = new JSeparator();
		mnMen_1.add(separator_1);
		
		JMenuItem mntm_sortir = new JMenuItem("Sortir");
		mntm_sortir.setAccelerator(KeyStroke.getKeyStroke("control S"));
		mntm_sortir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usuariConectat) {
					disconnect();
				}

				MySQLModel.close();
				dispose();
			}
		});
		mnMen_1.add(mntm_sortir);
	}
	
	private void addConnectButton() {
		this.btn_conectar = new JButton("Conectar-se");
		this.btn_conectar.addMouseListener(this);
		this.btn_conectar.setFont(new Font("Dialog", Font.BOLD, 16));
	    this.btn_conectar.setForeground(new Color(32, 43, 51));
	    this.btn_conectar.setBackground(new Color(0, 185, 144));
	    this.btn_conectar.setBorder(null);
	    this.pnl_west_north_center.add(this.btn_conectar);
	}
	
	private void addDisconnectButton() {
		this.btn_desconectar = new JButton("Desconectar-se");
		this.btn_desconectar.addMouseListener(this);
		this.btn_desconectar.setFont(new Font("Dialog", Font.BOLD, 16));
		this.btn_desconectar.setForeground(new Color(32, 43, 51));
		this.btn_desconectar.setBackground(new Color(0, 185, 144));
		this.btn_desconectar.setBorder(null);
	    this.pnl_west_north_center.add(this.btn_desconectar);
	}
	
	public void changeTheme() {
		if (this.darkMode) {
			this.pnl_west.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(49, 56, 61)));
			this.pnl_west_north_west.setBackground(new Color(32, 43, 51));
			this.pnl_west_north_center.setBackground(new Color(32, 43, 51));
			this.pnl_center_north_west.setBackground(new Color(32, 43, 51));
			this.pnl_center_north_center.setBackground(new Color(32, 43, 51));
			this.pnl_west_center_north.setBackground(new Color(17, 27, 33));
			this.pnl_west_center_center.setBackground(new Color(17, 27, 33));
			this.pnl_center_bottom.setBackground(new Color(32, 43, 51));
			this.textField_user.setForeground(new Color(233, 237, 239));
			this.textField_user.setBackground(new Color(32, 43, 51));
			this.textField_message.setBackground(new Color(42, 57, 66));
		    this.textField_message.setForeground(new Color(233, 237, 239));
		    this.btn_conectar.setForeground(new Color(32, 43, 51));
		    this.btn_conectar.setBackground(new Color(0, 185, 144));
		    this.lbl_center_center.setIcon(new ImageIcon(ChatView.class.getResource("/chat/vista/resources/whatsapp_1388px.png")));
		    this.btn_enviar.setBackground(new Color(32, 43, 51));
		    this.btn_enviar.setIcon(new ImageIcon(ChatView.class.getResource("/chat/vista/resources/enviar_64px.png")));
		    this.lbl_3.setForeground(new Color(233, 237, 239));
		    this.lbl_usuaris.setForeground(new Color(134, 150, 160));
		} else {
			this.pnl_west.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(209, 215, 219)));
			this.pnl_west_north_west.setBackground(new Color(240, 242, 245));
			this.pnl_west_north_center.setBackground(new Color(240, 242, 245));
			this.pnl_center_north_west.setBackground(new Color(240, 242, 245));
			this.pnl_center_north_center.setBackground(new Color(240, 242, 245));
			this.pnl_west_center_north.setBackground(new Color(255, 255, 255));
			this.pnl_west_center_center.setBackground(new Color(255, 255, 255));
			this.pnl_center_bottom.setBackground(new Color(240, 242, 245));
			this.textField_user.setBackground(new Color(240, 242, 245));
			this.textField_user.setForeground(new Color(59, 74, 84));
			this.textField_message.setBackground(new Color(255, 255, 255));
		    this.textField_message.setForeground(new Color(59, 74, 84));
		    this.btn_conectar.setForeground(new Color(255, 255, 255));
		    this.btn_conectar.setBackground(new Color(37, 211, 102));
			this.lbl_center_center.setIcon(new ImageIcon(ChatView.class.getResource("/chat/vista/resources/whatsapp-white_1388px.png")));
			this.btn_enviar.setBackground(new Color(240, 242, 245));
			this.btn_enviar.setIcon(new ImageIcon(ChatView.class.getResource("/chat/vista/resources/enviar-white_64px.png")));
			this.lbl_3.setForeground(new Color(17, 27, 33));
			this.lbl_usuaris.setForeground(new Color(112, 128, 138));
		}
	}
	
	public void addAbout() {
		About about = new About(this);
	}
	
	public void addUsuariViews() {
		this.usuaris = this.usuariModel.getConnectedUsers();
		for (Usuari u : this.usuaris) {
			if (!this.usuarisConectats.contains(u.getNick())) {
				UsuariView uv = new UsuariView(u, this.darkMode);
				this.pnl_west_center_center.add(uv);
				this.usuarisConectats.add(u.getNick());
			}
		}
	}
	
	public void addUsuarisToLabel() {
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < this.usuaris.size(); i++) {
	        Usuari u = this.usuaris.get(i);
	        if (!u.getNick().equals(this.usuariNick)) {
	            sb.append(u.getNick());
	            if (i < this.usuaris.size() - 1) {
	                sb.append(", ");
	            }
	        }
	    }

	    if (this.usuariConectat) {
	        sb.append("Tú");
	    }

	    this.lbl_usuaris.setText(sb.toString());
	}

	public void addMissatgeViews() {
		this.missatges = this.missatgeModel.getMessages();
		for (Missatge m : this.missatges) {
			if (m.getNick().equals(this.usuariNick)) {
				MissatgeView mv = new MissatgeView(m, this.darkMode, true);
				this.pnl_center_center_center_west.add(mv);
			} else {
				MissatgeView mv = new MissatgeView(m, this.darkMode, false);
				this.pnl_center_center_center_east.add(mv);
			}	
		}
	}
	
	public void connect() {
		this.usuariNick = this.textField_user.getText();
		Usuari u = new Usuari(this.usuariNick);
		this.usuariModel.connect(u);
		addDisconnectButton();
		this.textField_user.setText("");
		this.textField_user.setEnabled(false);
		this.pnl_west_north_center.remove(this.btn_conectar);
		this.usuariConectat = true;
		this.textField_message.setEnabled(true);
		this.btn_enviar.addMouseListener(this);
		refresh();
	}
	
	public void disconnect() {
		this.usuariModel.disconnect();
		this.pnl_west_north_center.remove(this.btn_desconectar);
		addConnectButton();
		this.textField_user.setText("");
		this.textField_message.setEnabled(false);
		this.btn_enviar.removeMouseListener(this);
		this.usuariConectat = false;
		this.textField_user.setEnabled(true);
		
		this.pnl_center_center_center_east.removeAll();
		this.pnl_center_center_center_west.removeAll();
		this.pnl_center_center_center_east.revalidate();
		this.pnl_center_center_center_east.repaint();
		this.pnl_center_center_center_west.revalidate();
		this.pnl_center_center_center_west.repaint();
		this.pnl_west_center_center.removeAll();
		this.pnl_west_center_center.revalidate();
		this.pnl_west_center_center.repaint();
		if (this.usuarisConectats.contains(this.usuariNick)) {
			this.usuarisConectats.remove(this.usuariNick);
		}
	}
	
	public void send() {
		Missatge m = new Missatge(this.textField_message.getText());
		this.missatgeModel.send(m);
		this.textField_message.setText("");
	}
	
	public void addTimer() {
		this.timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refresh();
            }
        });
        this.timer.start();
	}
	
	private void refresh() {
        addUsuariViews();
        addUsuarisToLabel();
        
		if (this.usuariConectat) {
			addMissatgeViews();
			this.pnl_center_center_center_east.revalidate();
			this.pnl_center_center_center_east.repaint();
			this.pnl_center_center_center_west.revalidate();
			this.pnl_center_center_center_west.repaint();
		}

        this.pnl_west_center_center.revalidate();
        this.pnl_west_center_center.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == this.btn_conectar) {
			this.connect();
		} else if (e.getSource() == this.btn_desconectar) {
			this.disconnect();
		} else if (e.getSource() == this.btn_enviar) {
			this.send();
		}
	}
	
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	
}
