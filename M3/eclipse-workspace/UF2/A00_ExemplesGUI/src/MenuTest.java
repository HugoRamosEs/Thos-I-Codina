import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MenuTest extends JFrame {

	private Color[] colorValues = { Color.black, Color.blue, Color.red,
			Color.green };

	private JRadioButtonMenuItem[] colorItems, fonts;
	private JCheckBoxMenuItem[] styleItems;
	private JLabel displayLabel;
	private ButtonGroup fontGroup, colorGroup;
	private int style;

	public MenuTest() {

		super("Using JMenus");

		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');

		JMenuItem aboutItem = new JMenuItem("About...");
		aboutItem.setMnemonic('A');

		aboutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(MenuTest.this,
						"This is an example\nof using menus", "About",
						JOptionPane.PLAIN_MESSAGE);
			}
		});

		fileMenu.add(aboutItem);

		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.setMnemonic('x');

		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				dispose();
			}
		});

		fileMenu.add(exitItem);

		

		JMenu formatMenu = new JMenu("Format");
		formatMenu.setMnemonic('r');

		String colors[] = { "Black", "Blue", "Red", "Green" };

		JMenu colorMenu = new JMenu("Color");
		colorMenu.setMnemonic('C');

		colorItems = new JRadioButtonMenuItem[colors.length];
		colorGroup = new ButtonGroup();
		ItemHandler itemHandler = new ItemHandler();
		for (int count = 0; count < colors.length; count++) {
			colorItems[count] = new JRadioButtonMenuItem(colors[count]);

			colorMenu.add(colorItems[count]);
			colorGroup.add(colorItems[count]);

			colorItems[count].addActionListener(itemHandler);
		}

		colorItems[0].setSelected(true);

		formatMenu.add(colorMenu);
		formatMenu.addSeparator();

		String fontNames[] = { "Serif", "Monospaced", "SansSerif" };

		JMenu fontMenu = new JMenu("Font");
		fontMenu.setMnemonic('n');

		fonts = new JRadioButtonMenuItem[fontNames.length];
		fontGroup = new ButtonGroup();

		for (int count = 0; count < fonts.length; count++) {
			fonts[count] = new JRadioButtonMenuItem(fontNames[count]);

			fontMenu.add(fonts[count]);
			fontGroup.add(fonts[count]);

			fonts[count].addActionListener(itemHandler);
		}

		fonts[0].setSelected(true);

		fontMenu.addSeparator();

		String styleNames[] = { "Bold", "Italic" };

		styleItems = new JCheckBoxMenuItem[styleNames.length];
		StyleHandler styleHandler = new StyleHandler();

		for (int count = 0; count < styleNames.length; count++) {
			styleItems[count] = new JCheckBoxMenuItem(styleNames[count]);

			fontMenu.add(styleItems[count]);

			styleItems[count].addItemListener(styleHandler);
		}

		formatMenu.add(fontMenu);
		
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(fileMenu);
		bar.add(formatMenu);

		displayLabel = new JLabel("Sample Text", SwingConstants.CENTER);
		displayLabel.setForeground(colorValues[0]);
		displayLabel.setFont(new Font("TimesRoman", Font.PLAIN, 72));

		getContentPane().setBackground(Color.cyan);
		getContentPane().add(displayLabel, BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MenuTest();
			}
		});
	}

	private class ItemHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			for (int count = 0; count < colorItems.length; count++) {

				if (colorItems[count].isSelected()) {
					displayLabel.setForeground(colorValues[count]);
					break;
				}
			}

			for (int count = 0; count < fonts.length; count++) {

				if (event.getSource() == fonts[count]) {
					displayLabel.setFont(new Font(fonts[count].getText(),
							style, 72));
					break;
				}
			}

			repaint();
		}

	}

	private class StyleHandler implements ItemListener {

		public void itemStateChanged(ItemEvent e) {
			style = 0;

			if (styleItems[0].isSelected())
				style += Font.BOLD;

			if (styleItems[1].isSelected())
				style += Font.ITALIC;

			displayLabel.setFont(new Font(displayLabel.getFont().getName(),
					style, 72));

			repaint();
		}

	}

}
