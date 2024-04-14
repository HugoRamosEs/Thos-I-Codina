import java.awt.*;
import java.awt.event.*;

import javax.swing.*; 

public class ToolBarTest extends JFrame {

    public ToolBarTest() {
    	
        super("ToolBar Test");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // create icons
        ImageIcon loadIcon = new ImageIcon("img/load.gif");
        ImageIcon saveIcon = new ImageIcon("img/save.gif");
        ImageIcon subscribeIcon = new ImageIcon("img/subscribe.gif");
        ImageIcon unsubscribeIcon = new ImageIcon("img/unsubscribe.gif");
        
        // create buttons
        JButton load = new JButton("Load", loadIcon); 
        JButton save = new JButton("Save", saveIcon);
        JButton subscribe = new JButton("Subscribe", subscribeIcon);
        JButton unsubscribe = new JButton("Unsubscribe", unsubscribeIcon);
        
        // add buttons to toolbar
        JToolBar bar = new JToolBar();
        bar.add(load);
        bar.add(save);
        bar.add(subscribe);
        bar.add(unsubscribe);
        
        // create menu
        JMenuItem j1 = new JMenuItem("Load");
        JMenuItem j2 = new JMenuItem("Save");
        JMenuItem j3 = new JMenuItem("Subscribe");
        JMenuItem j4 = new JMenuItem("Unsubscribe");
       
        JMenu menu = new JMenu("Feeds");
        
        menu.add(j1);
        menu.add(j2);
        menu.addSeparator();
        menu.add(j3);
        menu.add(j4);
        
        JMenuBar menubar = new JMenuBar();   
        menubar.add(menu);
       
        JTextArea edit = new JTextArea(8, 40);
        JScrollPane scroll = new JScrollPane(edit);
        BorderLayout bord = new BorderLayout();
        setLayout(bord);
        add("North", bar);
        add("Center", scroll);
        setJMenuBar(menubar);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ToolBarTest();
			}
		});
	}
}
