package main;

import java.io.IOException;
import java.util.HashMap;

//import arbreBinari.ArbreBinari;
import llistaDoblementEnllacada.DraftArrayList;
import llistaDoblementEnllacada.Usuari;
import slider.ImageSlider;

public class Main {
	
	//A definir per Pregunta 5
	//Col.leccióEscollida parametres;

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		
		Usuari usuari001=new Usuari("Toni","toni@gmail.com","Pass@001");
		Usuari usuari002=new Usuari("Mònica","monica@gmail.com","Pass@002");
		Usuari usuari003=new Usuari("Ina","ina@gmail.com","Pass@003");
		Usuari usuari004=new Usuari("Anna","anna@gmail.com","Pass@004");
		Usuari usuari005=new Usuari("Marcos","marcos@gmail.com","Pass@005");
		Usuari usuari006=new Usuari("Maria","maria@gmail.com","Pass@006");
		
		HashMap mapDStrings = new HashMap<String,Usuari>();
		mapDStrings.put("USER0001", usuari001);
		mapDStrings.put("USER0002", usuari002);
		mapDStrings.put("USER0003", usuari003);
		mapDStrings.put("USER0004", usuari004);
		mapDStrings.put("USER0005", usuari005);
		mapDStrings.put("USER0006", usuari006);
		
		HashMap mapDIntegers = new HashMap<Integer,Usuari>();
		mapDIntegers.put(1, usuari001);
		mapDIntegers.put(2, usuari002);
		mapDIntegers.put(3, usuari003);
		mapDIntegers.put(4, usuari004);
		mapDIntegers.put(5, usuari005);
		mapDIntegers.put(6, usuari006);
		
		//A definir per Pregunta 3
		DraftArrayList llista00=new DraftArrayList(mapDStrings);
		
		//A definir per Pregunta 3
		DraftArrayList llista01=new DraftArrayList(mapDIntegers);
		
		//A definir per Pregunta 4
//		try {
//			Integer[] arrMissatge = {12, 1, 32, 6, 8, 4, 20};
//			
//			ArbreBinari llista = new ArbreBinari(9);
//			for (Integer cadena:arrMissatge) {
//				llista.inserir(cadena);
//			}
//			
//			System.out.println(llista);
//		} catch (Exception me) {
//			System.out.println("alguna cosa no ha anat be.");
//		}
		
		//A definir per Pregunta 5
		//this.parametres=saxReader.getParametres();
		
		ImageSlider obj = new ImageSlider();

	}

}
