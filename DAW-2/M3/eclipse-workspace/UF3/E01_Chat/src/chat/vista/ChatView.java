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
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;

import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.Timer;

import chat.model.*;
import chat.model.interfaces.ThemeUpdatable;
import chat.model.objectes.*;

import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ItemEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * Vista principal de l'aplicació. Implementa els mètodes de les interfícies MouseListener i KeyListener.
 * 
 * @version 1.0
 * @author Hugo
 */
public class ChatView extends JFrame implements MouseListener, KeyListener {
	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Camps de text de la finestra.
	 */
	private JTextField textField_message;
	private JTextField textField_user;
	
	/**
	 * JPanels de la finestra.
	 */
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
	
	/**
	 * JSplitPane que separa els missatges finestra.
	 */
	private JSplitPane pnl_center_center_center;
	
	/**
	 * JScrollPane de la finestra, per pujar o baixar els panels.
	 */
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	
	/**
	 * JLabels de la finestra.
	 */
	private JLabel lbl_3;
	private JLabel lbl_usuaris;
	private JLabel lbl_center_center;
	
	/**
	 * Botons de la finestra.
	 */
	private JButton btn_enviar;
	private JButton btn_connection;
	
	/**
	 * Barra de menú de la finestra amb els submenús.
	 */
	private JMenuBar menuBar_1;
	private JMenu mnMen_1;
	private JMenuItem mntm_about;
	private JCheckBoxMenuItem chckbxmntm_1;
	private JSeparator separator_1;
	private JMenuItem mntm_sortir;
	
	/**
	 * Models de l'aplicació.
	 */
	private UserModel userModel;
	private MessageModel messageModel;
	
	/**
	 * Col·leccions de dades de l'aplicació.
	 */
	private HashMap<String, User> users;
	private ArrayList<Message> messages;
	
	/**
	 * Variables de control de l'aplicació.
	 */
	private Timer timer;
	private boolean connectedUser;
	private boolean darkMode;
	private String userNick;
	private int pnl_users_height;
	private int pnl_messages_height;
	private int numMessages;
	private int numUsers;
	
	/**
	 * Constructor que crea una instancia de la vista del xat.
	 */
	public ChatView() {
		this.userModel = new UserModel();
		this.messageModel = new MessageModel();
		this.users = new HashMap<String, User>();
		this.messages = new ArrayList<Message>();
		
		this.connectedUser = false;
		this.darkMode = false;
		this.userNick = "";
		this.pnl_users_height = 0;
		this.pnl_messages_height = 0;
		this.numMessages = 0;
		this.numUsers = 0;
		
		init();
	}
	
	/**
	 * Mètode que inicialitza de la vista del xat.
	 */
	private void init() {
		generateWindow();
		addComponents();
		addUsersViews();
		addUsersToLabel();
		addTimer();
		changeTheme();
		this.setVisible(true);
	}
	
	// MÉTODES CONTROLADORS
	
	/**
	 * Mètode que conecta l'usuari al xat i realitza les modificacions adients a la vista.
	 */
	public void connect() {
		this.userNick = this.textField_user.getText();
		User u = new User(this.userNick);
		boolean connected = this.userModel.connect(u);
		
		if (connected) {
			this.textField_user.setText("Escriu un nom d'usuari...");
			this.textField_user.setEnabled(false);
			this.btn_enviar.addMouseListener(this);
			this.connectedUser = true;
			this.textField_message.setEnabled(true);
			this.btn_connection.setText("Desconectar-se");
			refresh();
		}
	}
	
	/**
	 * Mètode que desconnecta l'usuari del xat i realitza les modificacions adients a la vista.
	 */
	public void disconnect() {
	    boolean disconnected = this.userModel.disconnect();
	    if (disconnected) {
	    	this.pnl_center_center_center_west.removeAll();
	    	this.pnl_center_center_center_east.removeAll();
	        this.textField_message.setText("Escriu un missatge...");
	        this.textField_message.setEnabled(false);
	        this.btn_enviar.removeMouseListener(this);
	        this.connectedUser = false;
	        this.textField_user.setEnabled(true);
	        this.pnl_messages_height = 0;
			this.numMessages = 0;
	        this.btn_connection.setText("Conectar-se");
	        refresh();
	    }
	}
	
	/**
	 * Mètode que envia un missatge recollit del textField i actualitza la vista del xat.
	 */
	public void send() {
		Message m = new Message(this.textField_message.getText());
		boolean sent = this.messageModel.send(m);
		if (sent) {
			this.textField_message.setText("");
		    // moveScrollToBottom();
		}
	}
	
	/**
	 * Mètode que afegeix un timer per anar refrescant la vista del xat.
	 */
	public void addTimer() {
		this.timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refresh();
            }
        });
        this.timer.start();
	}
	
	/**
	 * Mètode que afegeix i elimina les vistes del usuaris al panel d'usuaris.
	 */
	public void addUsersViews() {
	    this.users = this.userModel.getConnectedUsers();
	    for (User u : this.users.values()) {
	    	boolean added = false;
	    	for (Component component : this.pnl_west_center_center.getComponents()) {
	            if (component instanceof UserView) {
	                UserView userView = (UserView) component;
	                if (userView.getUser().getNick().equals(u.getNick())) {
	                	added = true;
	                    break;
	                }
	            }
	        }
	    	
	    	if (!added) {
	    		UserView uv = new UserView(u, this.darkMode);
		        this.pnl_west_center_center.add(uv);
		        this.pnl_users_height += uv.getPreferredSize().height + (this.numUsers < 9 ? 6 : 0);
		        moveScrollToBottom(this.scrollPane_1);
	    	}
	    }

	    for (Component component : this.pnl_west_center_center.getComponents()) {
	        if (component instanceof UserView) {
	            UserView userView = (UserView) component;
	            if (!this.users.containsKey(userView.getUser().getNick())) {
	                this.pnl_west_center_center.remove(component);
	                this.pnl_users_height -= userView.getPreferredSize().height + (this.numUsers < 9 ? 6 : 0);
	            }
	        }
	    }

	    recalculatePnlHeights();
	}
	
	
	/**
	 * Mètode que afegeix les vistes dels missatges emmagatzemats a la base de dades al panel de missatges.
	 */
	public void addMissatgeViews() {
	    this.messages = this.messageModel.getMessages();
	    for (Message m : this.messages) {
	        MessageView mv;
	        JLabel lbl = new JLabel();
	        if (m.getNick().equals(this.userNick)) {
	            mv = new MessageView(m, this.darkMode, true);
	            this.pnl_center_center_center_west.add(mv);
	            lbl.setPreferredSize(new Dimension(mv.getPreferredSize().width, mv.getPreferredSize().height));
	            lbl.setBorder(null);
	            this.pnl_center_center_center_east.add(lbl);
	            this.numMessages++;
	            moveScrollToBottom(this.scrollPane_2);
	        } else {
	            mv = new MessageView(m, this.darkMode, false);
	            this.pnl_center_center_center_east.add(mv);
	            lbl.setPreferredSize(new Dimension(mv.getPreferredSize().width, mv.getPreferredSize().height));
	            lbl.setBorder(null);
	            this.pnl_center_center_center_west.add(lbl);
	            this.numMessages++;
	            moveScrollToBottom(this.scrollPane_2);
	        }
	        
	        this.pnl_messages_height += mv.getPreferredSize().height + (this.numMessages < 6 ? 9 : 5);
	    }

	    recalculatePnlHeights();
	}
	
	// MÉTODES VISUALS
	
	/**
	 * Mètode que genera la finestra principal de l'aplicació.
	 */
	private void generateWindow() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) (screenSize.getWidth() - 1600) / 2;
		int y = (int) (screenSize.getHeight() - 900) / 2;
		this.setBounds(x, y, 1600, 900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Chat");
		this.getContentPane().setLayout(new BorderLayout(0, 0));
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(ChatView.class.getResource("/chat/vista/resources/app-logo_128px.png")));
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	boolean disconnected;
				if (connectedUser) {
					disconnected = userModel.disconnect();
					if (disconnected) {
						MySQLModel.close();
						dispose();
					}
				} else {
					MySQLModel.close();
					dispose();
				}
            }
        });
	}
	
	/**
	 * Mètode que afegeix els components a la finestra principal de l'aplicació.
	 */
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
	    
	    this.btn_connection = new JButton("Conectar-se");
		this.btn_connection.setFont(Utils.loadFont("bold", 16));
		this.btn_connection.setForeground(new Color(17, 27, 33));
	    this.btn_connection.setBackground(new Color(37, 211, 102));
	    this.btn_connection.setBorder(null);
	    this.btn_connection.addMouseListener(this);
	    this.pnl_west_north_center.add(this.btn_connection);
	    
	    JPanel pnl_west_center = new JPanel();
	    pnl_west_center.setBackground(new Color(17, 27, 33));
	    this.pnl_west.add(pnl_west_center, BorderLayout.CENTER);
	    pnl_west_center.setLayout(new BorderLayout(0, 0));

	    this.pnl_west_center_center = new JPanel();
	    this.pnl_west_center_center.setBackground(new Color(17, 27, 33));

	    this.scrollPane_1 = new JScrollPane(this.pnl_west_center_center);
	    this.scrollPane_1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    this.scrollPane_1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    this.scrollPane_1.setOpaque(false);
	    this.scrollPane_1.setBorder(null);
	    this.scrollPane_1.getVerticalScrollBar().setPreferredSize(new Dimension(13, 0));
	    this.scrollPane_1.getVerticalScrollBar().setBackground(new Color(240, 242, 245));
	    this.scrollPane_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	    pnl_west_center.add(this.scrollPane_1, BorderLayout.CENTER);
		
		this.textField_user = new JTextField();
	    this.textField_user.setBackground(new Color(32, 43, 51));
	    this.textField_user.setBorder(new EmptyBorder(0, 10, 0, 10));
	    this.textField_user.setPreferredSize(new Dimension(10, 10));
	    this.textField_user.setForeground(new Color(233, 237, 239));
	    this.textField_user.setFont(Utils.loadFont("plain", 16));
	    this.textField_user.setText("Escriu un nom d'usuari...");
	    this.textField_user.addKeyListener(this);
	    this.textField_user.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textField_user.getText().isEmpty()) {
					textField_user.setText("Escriu un nom d'usuari...");
					textField_user.setFont(Utils.loadFont("plain", 16));
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if (textField_user.getText().equals("Escriu un nom d'usuari...")) {
					textField_user.setText("");
					textField_user.setFont(Utils.loadFont("plain", 16));
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
	    lbl_2.setIcon(new ImageIcon(ChatView.class.getResource("/chat/vista/resources/grupo-avatar_41px.png")));
	    this.pnl_center_north_west.add(lbl_2);
	    
	    this.pnl_center_north_center = new JPanel();
	    this.pnl_center_north_center.setBorder(new EmptyBorder(8, 0, 8, 0));
	    this.pnl_center_north_center.setBackground(new Color(32, 43, 51));
	    pnl_center_north.add(this.pnl_center_north_center, BorderLayout.CENTER);
	    this.pnl_center_north_center.setLayout(new GridLayout(2, 1, 0, 0));
	    
	    this.lbl_3 = new JLabel("Chat");
	    this.lbl_3.setBorder(new EmptyBorder(0, -1, 0, 0));
	    this.lbl_3.setFont(Utils.loadFont("bold", 18));
	    this.lbl_3.setForeground(new Color(233, 237, 239));
	    this.pnl_center_north_center.add(this.lbl_3);
	    
	    this.lbl_usuaris = new JLabel("");
	    this.lbl_usuaris.setFont(Utils.loadFont("plain", 12));
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
	    this.textField_message.setFont(Utils.loadFont("plain", 16));
	    this.textField_message.setText("Escriu un missatge...");
	    this.textField_message.addKeyListener(this);
	    this.textField_message.addFocusListener(new FocusAdapter() {
	    	@Override
	    	public void focusLost(FocusEvent e) {
	    		if (textField_message.getText().isEmpty()) {
	    		    textField_message.setText("Escriu un missatge...");
	    		    textField_message.setFont(Utils.loadFont("plain", 16));
	    		}
	    	}
	    	@Override
	    	public void focusGained(FocusEvent e) {
				if (textField_message.getText().equals("Escriu un missatge...")) {
					textField_message.setText("");
					textField_message.setFont(Utils.loadFont("plain", 16));
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
	    FlowLayout flowLayout = (FlowLayout) this.pnl_center_center_center_east.getLayout();
	    flowLayout.setAlignment(FlowLayout.LEFT);
	    this.pnl_center_center_center_east.setBorder(null);
	    this.pnl_center_center_center_east.setOpaque(false);

	    this.pnl_center_center_center_west = new JPanel();
	    FlowLayout flowLayout_1 = (FlowLayout) this.pnl_center_center_center_west.getLayout();
	    flowLayout_1.setAlignment(FlowLayout.RIGHT);
	    this.pnl_center_center_center_west.setBorder(null);
	    this.pnl_center_center_center_west.setOpaque(false);

	    this.pnl_center_center_center = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	    this.pnl_center_center_center.setOpaque(false);
	    this.pnl_center_center_center.setResizeWeight(0.5);
	    this.pnl_center_center_center.setEnabled(false);
	    this.pnl_center_center_center.setDividerSize(0);
	    this.pnl_center_center_center.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 35));
	    this.pnl_center_center_center_east.setOpaque(false);
	    this.pnl_center_center_center_west.setOpaque(false);

	    this.pnl_center_center_center.setLeftComponent(this.pnl_center_center_center_east);
	    this.pnl_center_center_center.setRightComponent(this.pnl_center_center_center_west);

	    this.scrollPane_2 = new JScrollPane(this.pnl_center_center_center);
	    this.scrollPane_2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    this.scrollPane_2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    this.scrollPane_2.setOpaque(false);
	    this.scrollPane_2.setBorder(null);
	    this.scrollPane_2.getViewport().setOpaque(false);
	    this.scrollPane_2.getVerticalScrollBar().setPreferredSize(new Dimension(13, 0));
	    this.scrollPane_2.getVerticalScrollBar().setBackground(new Color(240, 242, 245));
	    this.lbl_center_center.add(this.scrollPane_2, BorderLayout.CENTER);

	    this.menuBar_1 = new JMenuBar();
	    this.menuBar_1.setBackground(new Color(255, 255, 255));
	    this.menuBar_1.setBorder(new EmptyBorder(0, 12, 0, 12));
		this.setJMenuBar(this.menuBar_1);
		
		this.mnMen_1 = new JMenu("Menú");
		this.mnMen_1.setFont(Utils.loadFont("bold", 14));
		this.mnMen_1.setForeground(new Color(233, 237, 239));
		this.mnMen_1.setBorder(null);
		this.menuBar_1.add(mnMen_1);
		
		this.mntm_about = new JMenuItem("About");
		this.mntm_about.setPreferredSize(new Dimension(160, 30));
		this.mntm_about.setBackground(new Color(255, 255, 255));
		this.mntm_about.setForeground(new Color(17, 27, 33));
		this.mntm_about.setFont(Utils.loadFont("plain", 14));
		this.mntm_about.setAccelerator(KeyStroke.getKeyStroke("control A"));
		this.mntm_about.setBorder(null);
		this.mntm_about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutView about = new AboutView(ChatView.this);
			}
		});
		this.mnMen_1.add(this.mntm_about);
		
		this.chckbxmntm_1 = new JCheckBoxMenuItem("Tema Oscur");
		this.chckbxmntm_1.setPreferredSize(new Dimension(160, 30));
		this.chckbxmntm_1.setBackground(new Color(255, 255, 255));
		this.chckbxmntm_1.setForeground(new Color(17, 27, 33));
		this.chckbxmntm_1.setFont(Utils.loadFont("plain", 14));
		this.chckbxmntm_1.setAccelerator(KeyStroke.getKeyStroke("control T"));
		this.chckbxmntm_1.setBorder(null);
		this.chckbxmntm_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				darkMode = chckbxmntm_1.isSelected();
				changeTheme();
			}
		});
		this.mnMen_1.add(this.chckbxmntm_1);
		
		this.separator_1 = new JSeparator();
		this.mnMen_1.add(this.separator_1);
		
		this.mntm_sortir = new JMenuItem("Sortir");
		this.mntm_sortir.setPreferredSize(new Dimension(160, 30));
		this.mntm_sortir.setBackground(new Color(255, 255, 255));
		this.mntm_sortir.setForeground(new Color(17, 27, 33));
		this.mntm_sortir.setFont(Utils.loadFont("plain", 14));
		this.mntm_sortir.setAccelerator(KeyStroke.getKeyStroke("control Q"));
		this.mntm_sortir.setBorder(new EmptyBorder(0, 16, 0, 0));
		this.mntm_sortir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disconnect();
				dispose();
				System.exit(0);
			}
		});
		
		this.mnMen_1.add(this.mntm_sortir);
		this.mnMen_1.getPopupMenu().setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
	}
	
	/**
	 * Mètode que actualitza la label posicionada al panel superior amb els noms dels usuaris conectats al xat.
	 */
	public void addUsersToLabel() {
	    StringBuilder sb = new StringBuilder();
	    for (User u : this.users.values()) {
	        if (!u.getNick().equals(this.userNick)) {
	            if (sb.length() > 0) {
	                sb.append(", ");
	            }
	            sb.append(u.getNick());
	        }
	    }

	    if (this.connectedUser) {
	        if (sb.length() > 0) {
	            sb.append(", ");
	        }
	        sb.append("Tú");
	    }

	    this.lbl_usuaris.setText(sb.toString());
	}
	
	/**
	 * Mètode que canvia el tema de tota l'aplicació.
	 */
	public void changeTheme() {
		if (this.darkMode) {
			this.pnl_west.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(49, 56, 61)));
			this.pnl_west_north_west.setBackground(new Color(32, 43, 51));
			this.pnl_west_north_center.setBackground(new Color(32, 43, 51));
			this.pnl_center_north_west.setBackground(new Color(32, 43, 51));
			this.pnl_center_north_center.setBackground(new Color(32, 43, 51));
			this.pnl_west_center_north.setBackground(new Color(17, 27, 33));
			this.pnl_west_center_center.setBackground(new Color(17, 27, 33));
			this.btn_connection.setBackground(new Color(0, 185, 144));
			this.btn_connection.setForeground(new Color(32, 43, 51));
			this.pnl_center_bottom.setBackground(new Color(32, 43, 51));
			this.textField_user.setForeground(new Color(233, 237, 239));
			this.textField_user.setBackground(new Color(32, 43, 51));
			this.textField_message.setBackground(new Color(42, 57, 66));
		    this.textField_message.setForeground(new Color(233, 237, 239));
		    this.lbl_center_center.setIcon(new ImageIcon(ChatView.class.getResource("/chat/vista/resources/whatsapp_1388px.png")));
		    this.btn_enviar.setBackground(new Color(32, 43, 51));
		    this.btn_enviar.setIcon(new ImageIcon(ChatView.class.getResource("/chat/vista/resources/enviar_64px.png")));
		    this.lbl_3.setForeground(new Color(233, 237, 239));
		    this.lbl_usuaris.setForeground(new Color(134, 150, 160));
		    this.menuBar_1.setBackground(new Color(42, 57, 66));
		    this.mnMen_1.setForeground(new Color(233, 237, 239));
		    this.mntm_about.setBackground(new Color(42, 57, 66));
		    this.mntm_about.setForeground(new Color(233, 237, 239));
		    this.chckbxmntm_1.setBackground(new Color(42, 57, 66));
		    this.chckbxmntm_1.setForeground(new Color(233, 237, 239));
		    this.mntm_sortir.setBackground(new Color(42, 57, 66));
		    this.mntm_sortir.setForeground(new Color(233, 237, 239));
		    this.mnMen_1.getPopupMenu().setBorder(BorderFactory.createLineBorder(new Color(233, 237, 239), 3));
		    this.scrollPane_1.getVerticalScrollBar().setBackground(new Color(32, 43, 51));
		    this.scrollPane_2.getVerticalScrollBar().setBackground(new Color(32, 43, 51));
		    updateThemeForCanvas(this.pnl_center_center_center_east);
			updateThemeForCanvas(this.pnl_center_center_center_west);
			updateThemeForCanvas(this.pnl_west_center_center);
		} else {
			this.pnl_west.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(209, 215, 219)));
			this.pnl_west_north_west.setBackground(new Color(240, 242, 245));
			this.pnl_west_north_center.setBackground(new Color(240, 242, 245));
			this.pnl_center_north_west.setBackground(new Color(240, 242, 245));
			this.pnl_center_north_center.setBackground(new Color(240, 242, 245));
			this.pnl_west_center_north.setBackground(new Color(255, 255, 255));
			this.pnl_west_center_center.setBackground(new Color(255, 255, 255));
			this.btn_connection.setBackground(new Color(37, 211, 102));
			this.btn_connection.setForeground(new Color(255, 255, 255));
			this.pnl_center_bottom.setBackground(new Color(240, 242, 245));
			this.textField_user.setBackground(new Color(240, 242, 245));
			this.textField_user.setForeground(new Color(59, 74, 84));
			this.textField_message.setBackground(new Color(255, 255, 255));
		    this.textField_message.setForeground(new Color(59, 74, 84));
			this.lbl_center_center.setIcon(new ImageIcon(ChatView.class.getResource("/chat/vista/resources/whatsapp-white_1388px.png")));
			this.btn_enviar.setBackground(new Color(240, 242, 245));
			this.btn_enviar.setIcon(new ImageIcon(ChatView.class.getResource("/chat/vista/resources/enviar-white_64px.png")));
			this.lbl_3.setForeground(new Color(17, 27, 33));
			this.lbl_usuaris.setForeground(new Color(112, 128, 138));
			this.menuBar_1.setBackground(new Color(255, 255, 255));
			this.mnMen_1.setForeground(new Color(17, 27, 33));
			this.mntm_about.setBackground(new Color(255, 255, 255));
			this.mntm_about.setForeground(new Color(17, 27, 33));
			this.chckbxmntm_1.setBackground(new Color(255, 255, 255));
			this.chckbxmntm_1.setForeground(new Color(17, 27, 33));
			this.mntm_sortir.setBackground(new Color(255, 255, 255));
			this.mntm_sortir.setForeground(new Color(17, 27, 33));
			this.mnMen_1.getPopupMenu().setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
			this.scrollPane_1.getVerticalScrollBar().setBackground(new Color(240, 242, 245));
			this.scrollPane_2.getVerticalScrollBar().setBackground(new Color(240, 242, 245));
			updateThemeForCanvas(this.pnl_center_center_center_east);
			updateThemeForCanvas(this.pnl_center_center_center_west);
			updateThemeForCanvas(this.pnl_west_center_center);
		}
	}
	
	/**
	 * Mètode que actualitza el tema els canvas (UserViews i MessageViews) del panels.
	 * 
	 * @param panel Panell a actualitzar.
	 */
	private void updateThemeForCanvas(Container panel) {
	    Component[] components = panel.getComponents();
	    for (Component component : components) {
	        if (component instanceof ThemeUpdatable) {
	            ((ThemeUpdatable) component).updateTheme(this.darkMode);
	        }
	    }
	}
	
	/**
	 * Mètode que recalcula les alçades dels panels on estan situats els canvas.
	 */
	private void recalculatePnlHeights() {
		this.pnl_west_center_center.setPreferredSize(new Dimension(400, this.pnl_users_height));
        this.pnl_west_center_center.revalidate();
        this.pnl_west_center_center.repaint();
		
		this.scrollPane_2.setPreferredSize(new Dimension(510, this.pnl_messages_height));
		this.scrollPane_2.revalidate();
		this.scrollPane_2.repaint();
		
		this.pnl_center_center_center.setPreferredSize(new Dimension(510, this.pnl_messages_height));
		this.pnl_center_center_center.revalidate();
		this.pnl_center_center_center.repaint();
	    
		this.pnl_center_center_center_west.setPreferredSize(new Dimension(510, this.pnl_messages_height));
	    this.pnl_center_center_center_west.revalidate();
	    this.pnl_center_center_center_west.repaint();
	    
	    this.pnl_center_center_center_east.setPreferredSize(new Dimension(510, this.pnl_messages_height));
	    this.pnl_center_center_center_east.revalidate();
	    this.pnl_center_center_center_east.repaint();
	}
	
	/**
	 * Mètode que mou la barra de scroll cap avall quan hi ha un nou missatge o es conecta un nou usuari.
	 * 
	 * @param scrollPane JScrollPane a moure.
	 */
	private void moveScrollToBottom(JScrollPane scrollPane) {
		int targetValue = scrollPane.getVerticalScrollBar().getMaximum();
		Timer timer = new Timer(1, new ActionListener() {
			int currentValue = scrollPane.getVerticalScrollBar().getValue();

			@Override
			public void actionPerformed(ActionEvent e) {
				if (currentValue < targetValue) {
					currentValue += 1;
					scrollPane.getVerticalScrollBar().setValue(currentValue);
				} else {
					((Timer) e.getSource()).stop();
				}
			}
		});
		
		timer.start();
	}
	
	/**
	 * Mètode que refresca la vista de l'aplicació per aplicar els nous canvis.
	 */
	private void refresh() {
        addUsersViews();
        addUsersToLabel();
        
		if (this.connectedUser) {
			addMissatgeViews();
		}
		
		recalculatePnlHeights();
	}
	
	// MÉTODES IMPLEMENTATS
	
	/**
	 * Mètode que s'executa quan es fa click amb el ratolí.
	 * 
	 * @param e Event del ratolí.
     */
	@Override
	public void mouseClicked(MouseEvent e) {
	    if (e.getSource() == this.btn_connection) {
	        if (!this.connectedUser) {
	            this.connect();
	        } else {
	            this.disconnect();
	        }
	    } else if (e.getSource() == this.btn_enviar) {
	    	this.send();
	    }
	}
	
	/**
	 * Mètode que s'executa quan es prem una tecla.
	 * 
	 * @param e Event de la tecla premuda.
     */
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (this.textField_user.isEnabled()) {
				this.connect();
			} else if (this.textField_message.isEnabled()) {
				this.send();
			}
		}
	}
	
	// MÉTODES IMPLEMENTATS PERÒ NO UTILITZATS
	
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
	
}
