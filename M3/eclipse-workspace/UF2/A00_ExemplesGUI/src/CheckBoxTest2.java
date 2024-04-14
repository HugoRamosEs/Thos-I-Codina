

import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CheckBoxTest2 extends JFrame implements ItemListener{
  
	private JButton b;
	private JCheckBox chk1;
	private JCheckBox chk2;
	private JCheckBox chk3;
    private JLabel l;
  
    public CheckBoxTest2() {
        
    	super("Ejemplo1302 Checkbox");
        
        Container cp = getContentPane();
        cp.setPreferredSize(new Dimension(150,300));
        
        GridLayout bLay = new GridLayout(8,2,5,5);
        
        cp.setLayout(bLay);
        
        chk1 = new JCheckBox("Seleccionado", true);
        chk2 = new JCheckBox("Deseleccionado", false);
        chk3 = new JCheckBox("Deseleccionado", false);
        cp.add(chk1);
        cp.add(chk2);
        cp.add(chk3);
        
        b=new JButton("Ver marcados");
        cp.add(b);
        
        l = new JLabel("");
        cp.add(l);

        b = new JButton("Estado de Checkboxes");
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                b_clic(e);
            }
        });
   
        chk1.addItemListener(this);
        pack();
        setVisible(true);
    }
    
    void b_clic(ActionEvent e) {
        l.setText("marcados: ");
        if (chk1.isSelected()) l.setText(l.getText() + "chk1 ");
        if (chk2.isSelected()) l.setText(l.getText() + "chk2 ");
        if (chk3.isSelected()) l.setText(l.getText() + "chk3 ");
    }
    
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange()==ItemEvent.DESELECTED)
            chk1.setText("Deseleccionado");
        if (e.getStateChange()==ItemEvent.SELECTED)
            chk1.setText("Seleccionado");
    }
    
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CheckBoxTest2();
			}
		});
	}
}