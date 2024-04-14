package llistaDoblementEnllacadaCircular;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		try {
			ArrayList miArrayList = new ArrayList();
			//ArrayList miArrayListCap = new ArrayList(5);
			// add(obj).
			miArrayList.add(new String("E1"));
			miArrayList.add(new String("E2"));
			miArrayList.add(new String("E3"));
			miArrayList.add(new String("E2"));
			System.out.println("Add (Obj): " + miArrayList.toString());
			// add(index, obj).
			miArrayList.add(6, new String("E4"));
			System.out.println("Add (Index): " + miArrayList.toString());
			// isEmpty.
			System.out.println("isEmpty: " + miArrayList.isEmpty());
			// contains.
			System.out.println("Contains: " + miArrayList.contains(new String("E1")));
			// get.
			System.out.println("Get: " + miArrayList.get(3));
			// indexOf.
			System.out.println("IndexOf: " + miArrayList.indexOf(new String("E2")));
			// lastIndexOf.
			System.out.println("LastIndexOf: " + miArrayList.lastIndexOf(new String("E2")));
			// remove(index).
			miArrayList.remove(3);
			System.out.println("Remove (Index): " + miArrayList.toString());
			// remove(obj).
			miArrayList.remove(new String("E2"));
			System.out.println("Remove (Obj): " + miArrayList.toString());
			// removeRange.
			miArrayList.removeRange(1,3);
			System.out.println("RemoveRange: " + miArrayList.toString());
			// set.
			miArrayList.set(4, new String("E8"));
			System.out.println("Anterior: " + miArrayList.set(1, new String("E8")) + " / Set: " + miArrayList.toString());
			// subList.
			ArrayList subList = miArrayList.subList(1, 4);
			System.out.println("SubList: " + subList.toString());
			// toArray.
			StringBuilder sb = new StringBuilder("Array: ");
			Object[] array = miArrayList.toArray();
			for (int i=0; i<array.length; i++) {
				sb.append("[" + array[i] + "] ");
			}
			System.out.println(sb);
			// trimToSize.
			System.out.println("trimToSize (Abans): " + miArrayList.getCapacitat());
			miArrayList.trimToSize();
			System.out.println("trimToSize (Despres): " + miArrayList.getCapacitat());
			// clone.
			ArrayList copia = (ArrayList) miArrayList.clone();
			System.out.println("Clone:" + copia.toString());
			// ensureCapacity.
			System.out.println("ensureCapacity (Abans): " + miArrayList.getCapacitat());
			miArrayList.ensureCapacity(20);
			System.out.println("ensureCapacity (Despres): " + miArrayList.getCapacitat());
			// clear.
			miArrayList.clear();
			System.out.println("ArrayList netejada." + miArrayList.toString() + " / isEmpty: " + miArrayList.isEmpty());
		} catch (IllegalArgumentException il) {
			JOptionPane.showMessageDialog(null, "Argument invàlid.", "ERROR IllegalArgumentException",
					JOptionPane.ERROR_MESSAGE);
		} catch (IndexOutOfBoundsException in) {
			JOptionPane.showMessageDialog(null, "Fora de rang.", "ERROR IndexOutOfBoundsException",
					JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Contacta amb l'administrador.", "ERROR Fatal",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
