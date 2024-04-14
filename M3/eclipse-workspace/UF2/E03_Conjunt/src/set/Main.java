package set;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		Set miSet = new Set();
		try {
			System.out.println("AFEGITS:");
			System.out.println("Afegit: " + miSet.add(Integer.valueOf(9)));
			System.out.println("Afegit: " + miSet.add(Integer.valueOf(9)));
			System.out.println("Afegit: " + miSet.add(Integer.valueOf(15)));
			System.out.println("Afegit: " + miSet.add(new String("hola")));
			System.out.println(miSet.toString());
			System.out.println("\nELIMINATS:");
			System.out.println("Eliminat: " + miSet.remove(Integer.valueOf(15)));
			System.out.println(miSet.toString());
			System.out.println("\nALTRES:");
			System.out.println("Size: " + miSet.size());
			System.out.println("Contains: " + miSet.contains(Integer.valueOf(9)));
			StringBuilder sb = new StringBuilder("Array: ");
			Object[] array = miSet.toArray();
			for (int i=0; i<array.length; i++) {
				sb.append(array[i] + ", ");
			}
			System.out.println(sb);
		}catch (IllegalArgumentException i){
			JOptionPane.showMessageDialog(null, "No hi poden haber elements repetits.", "ERROR AL AFEGIR", JOptionPane.ERROR_MESSAGE);
		}catch (UnsupportedOperationException u) {
			JOptionPane.showMessageDialog(null, "Aquesta operació no es pot realitzar.", "OPERACIÓ NO SUPORTADA", JOptionPane.ERROR_MESSAGE);
		}catch (ClassCastException c) {
			JOptionPane.showMessageDialog(null, "No son del mateix tipus.", "ERROR DE CLASSE", JOptionPane.ERROR_MESSAGE);
		}catch (NullPointerException n){
			JOptionPane.showMessageDialog(null, "No s'admeten nulls.", "ERROR DE NULL", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Contacta amb l'administrador.", "ERROR FATAL", JOptionPane.ERROR_MESSAGE);
		}
	}
}
