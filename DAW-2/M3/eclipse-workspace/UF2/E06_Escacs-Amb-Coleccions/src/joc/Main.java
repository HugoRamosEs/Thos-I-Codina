package joc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.swing.JOptionPane;

import peces.*;

public class Main {
	
	/*
	 * EXPLICACIÓN DE LA COLECCION ESCOGIDA
	 * La coleccion que he escogido para realizar el ejercicio ha sido HashSet. Las razones son las siguientes:
	 * - HashSet garantiza que cada elemento, es decir, que cada pieza sea unica debido a que tendrá una referencia única, cosa que considero esencial para la lógica del ajedrez. 
	 * 		Esto permite que al realizar operaciones de insercion o eliminacion de piezas sin que existan duplicados.
	 * 
	 * - HashSet utiliza una tabla de Hash interna para almacenar elementos, permitiendo un tiempo de busqueda constante O(1). Considero que esta caracteristica beneficia el tiempo 
	 * 		de busqueda para comprovar que una pieza existe en la posicion indicada. Soy consciente de que existen otras alternativas como TreeSet que ofrecen busquedas más ràpidas, 
	 * 		pero a su vez realentiza bastante la insercion de elementos debido a las operaciones extra que debe realizar. Por este motivo me he decantado por HashSet, al ser una 
	 * 		alternativa más equilibrada en ambos sentidos. Otra posible alternativa sería ArrayList, pero esta coleccion posee una búsqueda secuencial, y penalizaria al rendimiento 
	 * 		de la aplicacion, ya que deberia iterar por todas las piezas hasta encontrar la que necesita, cosa que HashSet no hace. En resumen, he priorizado un equilibro entre insercion, 
	 * 		eliminacion y busqueda de elementos, ya que considero que para implementar la lógica del ajedrez es necesaria la màxima fluidez y rápidez posible en estos aspectos.
	 * 
	 * - HashSet no posee un orden de insercion de elementos, cosa que beneficia tambien a la lógica del ajedrez porque no es necesario un orden de insercion. Esto elimina la necesidad de 
	 * 		otras colecciones que si mantiene un orden de insercion como por ejemplo LinkedHashSet, que pese a ser parecia a HashSet, esta posee un orden de insercion de los elementos, 
	 * 		provocando una mayor lentitud a la hora de realizar operaciones como eliminar, insertar o buscar elementos, ya que debe comprovar primero el orden de insercion.
	 * 
	 * - HashSet no implementa búsquedas por clave-valor, a diferencia de HashMap. La elección de HashSet en lugar de HashMap se debe a que consideré innecesario iterar sobre los elementos 
	 * 		con sus claves, lo cual podría aumentar el consumo de memoria de manera innecesaria. Por otro lado HashSet es más simple que HashMap, cosa que ayuda a que el codigo sea más fácil
	 * 		de entender.
	 * 
	 * 
	 * COLECCION PARA LAS PIEZAS FUERA DEL TABLERO
	 * La coleccion que he escogido para realizar el ejercicio ha sido LinkedList. Las razones son las siguientes:
	 * - LinkedList permite la insercion y eliminación en cualquier posicion de la lista, esto es beneficioso para las operaciones de añadir o retirar piezas de fuera del tablero durante la partida.
	 * 
	 * - LinkedList guarda el orden de insercion, por lo que puede ser util para saber, más bien rastrear, que piezas han sido retiradas del tablero.
	 * 
	 * - LinkedList es una estructura de lista dinamica, con lo que no tiene un tamaño fijo. Esto es util ya que permite adaptar su cantidad segun se vayan añadiendo o eliminando piezas a la 
	 * 		lista durante la partida.
	 * 
	 * - LinkedList posee una busqueda de elementos secuencial, esto puede ser util para realizar operaciones, como por ejemplo mostrar solo los peones que han sido retirados u otras operaciones
	 * 		que requieran de un orden especifico.
	 * 
	 */

	public static void main(String[] args) {
		try {
			init();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Posa't en contacte amb l'administrador", "problema irresoluble",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void init() throws InvalidMovementException {
		MyColor torn;
		
		// TODO Auto-generated method stub
		Tauler tauler = new Tauler();
		tauler.crearPartida();	
		
		tauler.imprimirTauler();
		
		System.out.println("");
		
		
		
		
		String line = "";
		String[] valors;
		Posicio posicioIniSeleccionada = null;
		Posicio posicioFiSeleccionada = null;
		
		do {
			torn = MyColor.BLANC;
			
			System.out.println("");
			System.out.println("Juguen BLANQUES");
			
			BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
			
			do {
				System.out.println("Selecciona peça a moure (H,V):");
				try {
					line=buffer.readLine();
				
					valors = line.split(",");
					posicioIniSeleccionada = new Posicio(Integer.parseInt(valors[0]), Integer.parseInt(valors[1]));
						
					if (tauler.getPeca(posicioIniSeleccionada) == null) {
						throw new InvalidMovementException("A001", "No hi ha peça en aquest escac del tauler");
//						System.out.println("No hi ha peça en aquest escac del taulell"); 
//						posicioIniSeleccionada = null;
					} else {
						if (tauler.getPeca(posicioIniSeleccionada).getEquip() != torn) {
							throw new WrongTurnException();
//							System.out.println("No és el teu torn.... juguen BLANQUES");
//							posicioIniSeleccionada = null;
						} else {
							if (!tauler.getPeca(posicioIniSeleccionada).hihaMovimentsPosibles(tauler)) {
								throw new InvalidMovementException("A002", "Amb aquesta peça no hi ha moviments possibles, escull una altre" );
//								System.out.println("Amb aquesta peça no hi ha moviments possibles, escull una altre");
//								posicioIniSeleccionada = null;
							} else {
								System.out.println("La peça que vols moure és: " + tauler.getPeca(posicioIniSeleccionada).toString());
						
							}
						}
					}
				} catch (IOException ioe) {
					ioe.printStackTrace();
				} catch (InvalidMovementException ime) {
					JOptionPane.showMessageDialog(null, ime.getMessage(), "Noooo.....", JOptionPane.ERROR_MESSAGE);
					posicioIniSeleccionada = null;
				} catch (WrongTurnException wte) {
					JOptionPane.showMessageDialog(null,"No és el teu torn.... " , "Noooo.....", JOptionPane.ERROR_MESSAGE);
					posicioIniSeleccionada = null;
				} catch (ArrayIndexOutOfBoundsException aiobe) {
					JOptionPane.showMessageDialog(null,"El format ha de ser NumeroHoritzontal , NumeroVertical (p.e. 3,7)\nEls números han de ser de 0 a 7" , "Format incorrecte", JOptionPane.ERROR_MESSAGE);
					posicioIniSeleccionada = null;
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null,"El format ha de ser NumeroHoritzontal , NumeroVertical (p.e. 3,7)" , "Numero incorrecte", JOptionPane.ERROR_MESSAGE);
					posicioIniSeleccionada = null;
				}
			} while (posicioIniSeleccionada == null);
			
			
			do {
				System.out.println("A quina posició vols moure-la (H,V):");
				try {
					line=buffer.readLine();
				
					valors = line.split(",");
					posicioFiSeleccionada = new Posicio(Integer.parseInt(valors[0]), Integer.parseInt(valors[1]));
				
//					if (!tauler.getPeca(posicioIniSeleccionada).movimentsPosibles(tauler)[posicioFiSeleccionada.getX()][posicioFiSeleccionada.getY()] ) {
//						throw new InvalidMovementException("A003", "Posició incorrecte" );
////						System.out.println("posicio incorrecte");
////						posicioFiSeleccionada = null;
//					} else {
//						System.out.println("ok");
//					}
					
					if (!tauler.getPeca(posicioIniSeleccionada).movimentsPosibles(tauler).contains(posicioFiSeleccionada)) {
						throw new InvalidMovementException("A003", "Posició incorrecte" );
//						System.out.println("posicio incorrecte");
//						posicioFiSeleccionada = null;
					} else {
						System.out.println("ok");
					}
				
				} catch (IOException ioe) {
					ioe.printStackTrace();
				} catch (InvalidMovementException ime) {
					JOptionPane.showMessageDialog(null, ime.getMessage(), "Noooo.....", JOptionPane.ERROR_MESSAGE);
					posicioIniSeleccionada = null;
				} catch (ArrayIndexOutOfBoundsException aiobe) {
					JOptionPane.showMessageDialog(null,"El format ha de ser NumeroHoritzontal , NumeroVertical (p.e. 3,7)\nEls números han de ser de 0 a 7" , "Format incorrecte", JOptionPane.ERROR_MESSAGE);
					posicioIniSeleccionada = null;
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null,"El format ha de ser NumeroHoritzontal , NumeroVertical (p.e. 3,7)" , "Numero incorrecte", JOptionPane.ERROR_MESSAGE);
					posicioIniSeleccionada = null;
				}
			} while (posicioFiSeleccionada == null);
			
			
			tauler.mouPeca(posicioIniSeleccionada, posicioFiSeleccionada);
			
			tauler.imprimirTauler();
			
			/*************************************************************************************/
			System.out.println("");
			System.out.println("Juguen NEGRES");
			torn = MyColor.NEGRE;
			
			do {
				System.out.println("Selecciona peça a moure (H,V):");
				try {
					line=buffer.readLine();
				
					valors = line.split(",");
					posicioIniSeleccionada = new Posicio(Integer.parseInt(valors[0]), Integer.parseInt(valors[1]));
					
					if (tauler.getPeca(posicioIniSeleccionada) == null) {
						throw new InvalidMovementException("A004", "No hi ha peça en aquest escac del tauler");

//						System.out.println("No hi ha peça en aquest escac del taulell");
//						posicioIniSeleccionada = null;
					} else {
						if (tauler.getPeca(posicioIniSeleccionada).getEquip() != torn) {
							throw new WrongTurnException();
//							System.out.println("No és el teu torn.... juguen NEGRES");
//							posicioIniSeleccionada = null;
						} else {
							if (!tauler.getPeca(posicioIniSeleccionada).hihaMovimentsPosibles(tauler)) {
								throw new InvalidMovementException("A005", "Amb aquesta peça no hi ha moviments possibles, escull una altre" );
//								System.out.println("Amb aquesta peça no hi ha moviments possibles, escull una altre");
//								posicioIniSeleccionada = null;
							} else {
								System.out.println("La peça que vols moure és: " + tauler.getPeca(posicioIniSeleccionada).toString());
						
							}
						}
					}
				} catch (IOException ioe) {
					ioe.printStackTrace();
				} catch (InvalidMovementException ime) {
					JOptionPane.showMessageDialog(null, ime.getMessage(), "Noooo.....", JOptionPane.ERROR_MESSAGE);
					posicioIniSeleccionada = null;
				} catch (WrongTurnException wte) {
					JOptionPane.showMessageDialog(null,"No és el teu torn.... " , "Noooo.....", JOptionPane.ERROR_MESSAGE);
					posicioIniSeleccionada = null;
				} catch (ArrayIndexOutOfBoundsException aiobe) {
					JOptionPane.showMessageDialog(null,"El format ha de ser NumeroHoritzontal , NumeroVertical (p.e. 3,7)\nEls números han de ser de 0 a 7" , "Format incorrecte", JOptionPane.ERROR_MESSAGE);
					posicioIniSeleccionada = null;
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null,"El format ha de ser NumeroHoritzontal , NumeroVertical (p.e. 3,7)" , "Numero incorrecte", JOptionPane.ERROR_MESSAGE);
					posicioIniSeleccionada = null;
				}
			} while (posicioIniSeleccionada == null);
			
			
			do {
				System.out.println("A quina posició vols moure-la (H,V):");
				try {
					line=buffer.readLine();
				
					valors = line.split(",");
					posicioFiSeleccionada = new Posicio(Integer.parseInt(valors[0]), Integer.parseInt(valors[1]));
				
//					if (!tauler.getPeca(posicioIniSeleccionada).movimentsPosibles(tauler)[posicioFiSeleccionada.getX()][posicioFiSeleccionada.getY()] ) {
//						throw new InvalidMovementException("A006", "Posició incorrecte" );
////					System.out.println("posicio incorrecte");
////					posicioFiSeleccionada = null;
//					} else {
//						System.out.println("ok");
//					}
					
					if (!tauler.getPeca(posicioIniSeleccionada).movimentsPosibles(tauler).contains(posicioFiSeleccionada)) {
						throw new InvalidMovementException("A006", "Posició incorrecte" );
	//					System.out.println("posicio incorrecte");
	//					posicioFiSeleccionada = null;
					} else {
						System.out.println("ok");
					}
				} catch (IOException ioe) {
					ioe.printStackTrace();
				} catch (InvalidMovementException ime) {
					JOptionPane.showMessageDialog(null, ime.getMessage(), "Noooo.....", JOptionPane.ERROR_MESSAGE);
					posicioIniSeleccionada = null;
				} catch (ArrayIndexOutOfBoundsException aiobe) {
					JOptionPane.showMessageDialog(null,"El format ha de ser NumeroHoritzontal , NumeroVertical (p.e. 3,7)\nEls números han de ser de 0 a 7" , "Format incorrecte", JOptionPane.ERROR_MESSAGE);
					posicioIniSeleccionada = null;
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null,"El format ha de ser NumeroHoritzontal , NumeroVertical (p.e. 3,7)" , "Numero incorrecte", JOptionPane.ERROR_MESSAGE);
					posicioIniSeleccionada = null;
				}
			} while (posicioFiSeleccionada == null);
			
			
			tauler.mouPeca(posicioIniSeleccionada, posicioFiSeleccionada);
			
			tauler.imprimirTauler();
		
		} while (true);
	}
}
