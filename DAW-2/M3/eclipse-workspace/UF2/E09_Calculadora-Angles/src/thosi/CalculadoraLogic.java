package thosi;

import javax.swing.JOptionPane;

public class CalculadoraLogic {
	private String entrada;
	private String operador;
	private Angle angle1;
	private Angle angle2;
	private Angle angleResultat;

	public CalculadoraLogic(String entrada) {
		this.entrada = entrada;
		this.operador = "";
		this.angle1 = new Angle(0, 0, 0);
		this.angle2 = new Angle(0, 0, 0);
		this.angleResultat = new Angle(0, 0, 0);
	}

	public boolean convertirString() {
		String[] parts = this.entrada.split("\\+|-");
		
		if (this.entrada.length() > 17) {
			JOptionPane.showMessageDialog(null, "Tamany d'entrada exedit, només es permeten 2 paràmetres amb format correcte per operar.", "OPERACIÓ NO SUPORTADA", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		if (parts.length > 1) {
			this.operador = this.entrada.substring(parts[0].length(), parts[0].length() + 1);
			String[] part1 = parts[0].split(":");
			switch (part1.length) {
			case 3:
				this.angle1.setGrau(Integer.parseInt(part1[0]));
				this.angle1.setMinut(Integer.parseInt(part1[1]));
				this.angle1.setSegon(Integer.parseInt(part1[2]));
				break;
			case 2:
				this.angle1.setMinut(Integer.parseInt(part1[0]));
				this.angle1.setSegon(Integer.parseInt(part1[1]));
				break;
			case 1:
				this.angle1.setSegon(Integer.parseInt(part1[0]));
				break;
			default:
				JOptionPane.showMessageDialog(null, "Format del primer paràmetre incorrecte. Els formats correctes son:\n"
						+ "- GG:MM:SS\n"
						+ "- MM:SS\n"
						+ "- SS", "PARÀMETRE INCORRECTE", JOptionPane.ERROR_MESSAGE);
				return false;
			}

			String[] part2 = parts[1].split(":");
			switch (part2.length) {
			case 3:
				this.angle2.setGrau(Integer.parseInt(part2[0]));
				this.angle2.setMinut(Integer.parseInt(part2[1]));
				this.angle2.setSegon(Integer.parseInt(part2[2]));
				break;
			case 2:
				this.angle2.setMinut(Integer.parseInt(part2[0]));
				this.angle2.setSegon(Integer.parseInt(part2[1]));
				break;
			case 1:
				this.angle2.setSegon(Integer.parseInt(part2[0]));
				break;
			default:
				JOptionPane.showMessageDialog(null, "Format del segon paràmetre incorrecte. Els formats correctes son:\n"
						+ "- GG:MM:SS\n"
						+ "- MM:SS\n"
						+ "- SS", "PARÀMETRE INCORRECTE", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}else {
			String[] part = this.entrada.split(":");
			switch (part.length) {
			case 3:
				this.angleResultat.setGrau(Integer.parseInt(part[0]));
				this.angleResultat.setMinut(Integer.parseInt(part[1]));
				this.angleResultat.setSegon(Integer.parseInt(part[2]));
				break;
			case 2:
				this.angleResultat.setMinut(Integer.parseInt(part[0]));
				this.angleResultat.setSegon(Integer.parseInt(part[1]));
				break;
			case 1:
				this.angleResultat.setSegon(Integer.parseInt(part[0]));
				break;
			default:
				JOptionPane.showMessageDialog(null, "Format del paràmetre incorrecte. Els formats correctes son:\n"
						+ "- GG:MM:SS\n"
						+ "- MM:SS\n"
						+ "- SS", "PARÀMETRE INCORRECTE", JOptionPane.ERROR_MESSAGE);
				return false;
			}	
		}
		return true;
	}

	public String opera() {
		if (this.convertirString()) {
			switch (this.operador) {
			case "+":
				this.angleResultat.setGrau(this.angle1.getGrau() + this.angle2.getGrau());
				this.angleResultat.setMinut(this.angle1.getMinut() + this.angle2.getMinut());
				this.angleResultat.setSegon(this.angle1.getSegon() + this.angle2.getSegon());
				this.angleResultat.normalitzar();
				break;
			case "-":
				this.angleResultat.setGrau(this.angle1.getGrau() - this.angle2.getGrau());
				this.angleResultat.setMinut(this.angle1.getMinut() - this.angle2.getMinut());
				this.angleResultat.setSegon(this.angle1.getSegon() - this.angle2.getSegon());
				this.angleResultat.normalitzar();
				break;
			case "":
				this.angleResultat.normalitzar();
				break;
			default:
				JOptionPane.showMessageDialog(null, "El signe d'operació introduit es invàlid.", "OPERACIÓ NO SUPORTADA", JOptionPane.ERROR_MESSAGE);
			}
			return this.angleResultat.toString();
		}else {
			return "";
		}
	}
}
