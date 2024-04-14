package thosi;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		try {
			Stack miStack = new Stack();
			Queue miQueue = new Queue();
			
			System.out.println("*********STACK*********");
			miStack.push(new String("S1"));
			miStack.push(new String("S2"));
			miStack.push(new String("S3"));
			System.out.println("Push: " + miStack);
			System.out.println("Search: " + miStack.search(new String("S2")));
			System.out.println("isEmpty: " + miStack.isEmpty());
			System.out.println("Peek: " + miStack.peek());
			miStack.pop();
			System.out.println("Pop: " + miStack);
			
			System.out.println("\n*********QUEUE*********");
			miQueue.add(new String("Q1"));
			miQueue.add(new String("Q2"));
			miQueue.add(new String("Q3"));
			System.out.println("Add: " + miQueue);
			System.out.println("Element: " + miQueue.element());
			miQueue.offer(new String("Q4"));
			miQueue.offer(new String("Q5"));
			System.out.println("Offer: " + miQueue);
			System.out.println("Peek: " + miQueue.peek());
			miQueue.poll();
			System.out.println("Poll: " + miQueue);
			miQueue.remove();
			System.out.println("Remove: " + miQueue);
		} catch (IllegalArgumentException ia) {
			JOptionPane.showMessageDialog(null, "Argument invàlid.", "ERROR IllegalArgumentException",
					JOptionPane.ERROR_MESSAGE);
		} catch (IllegalStateException is) {
			JOptionPane.showMessageDialog(null, "Queue plena.", "ERROR IllegalStateException",
					JOptionPane.ERROR_MESSAGE);	
		} catch (EmptyStackException em) {
			JOptionPane.showMessageDialog(null, "Stack buit.", "ERROR EmptyStackException",
					JOptionPane.ERROR_MESSAGE);
		} catch (ClassCastException c) {
			JOptionPane.showMessageDialog(null, "Diferencia de clases.", "ERROR ClassCastException",
					JOptionPane.ERROR_MESSAGE);
		} catch (NullPointerException n) {
			JOptionPane.showMessageDialog(null, "No poden haber nulls.", "ERROR NullPointerException",
					JOptionPane.ERROR_MESSAGE);	
		} catch (NoSuchElementException ns) {
			JOptionPane.showMessageDialog(null, "Queue buida.", "ERROR NoSuchElementException",
					JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Contacta amb l'administrador.", "ERROR Fatal",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
