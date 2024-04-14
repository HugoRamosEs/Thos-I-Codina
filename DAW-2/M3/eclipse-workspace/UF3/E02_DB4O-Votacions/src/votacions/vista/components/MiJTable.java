package votacions.vista.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import votacions.vista.View;

public class MiJTable extends JTable {
    private static final long serialVersionUID = 1L;

    public MiJTable() {
        super();
        setForeground(Color.WHITE);
        setBackground(new Color(64, 64, 64));
        setSelectionForeground(Color.WHITE);
        setSelectionBackground(new Color(128, 128, 128));
        setFont(carregarFont("plain", 16));
        setRowHeight(40);
        
        JTableHeader header = getTableHeader();
        header.setForeground(Color.WHITE);
        header.setBackground(new Color(96, 96, 96));
        header.setFont(carregarFont("bold", 16));
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

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component component = super.prepareRenderer(renderer, row, column);
        component.setForeground(Color.WHITE);
        component.setBackground(row % 2 == 0 ? new Color(128, 128, 128) : new Color(144, 144, 144));
        ((JComponent) component).setBorder(new EmptyBorder(10, 10, 10, 10));
        return component;
    }
}
