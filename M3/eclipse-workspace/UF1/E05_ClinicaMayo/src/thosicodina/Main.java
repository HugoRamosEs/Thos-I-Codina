package thosicodina;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		Pacient pacient = new Pacient ("Hugo Ramos Montesinos", Sexe.HOME, 19);
		Metge metge = new Metge ("Borja Ibáñez Cabeza");
		LocalDate data = LocalDate.now();
		Eritrocits e = new Eritrocits (pacient, metge, data, 5.0, 39.7, 14.2);
		Leucocits l = new Leucocits (pacient, metge, data, 7000, 3200, 4800, 120);
		Trombocits t = new Trombocits (pacient, metge, data, 200000);
		Volum vol = new Volum (pacient, metge, data, 90, 27);
		Velocitat vel = new Velocitat (pacient, metge, data, 12);
		Substancies s = new Substancies (pacient, metge, data, 80, 75, 23, 150, 71, 120, 0.7, 0.9, 60, 32, 4.89);
		Minerals m = new Minerals (pacient, metge, data, 8.9, 80, 4.25, 140);
		
		System.out.println("-----------------------ESPECIFIC-----------------------\n");
		System.out.println(metge.demanarHemogramaEspecific(m));
		System.out.println("-----------------------ANALITIC------------------------\n");
		System.out.println(metge.demanarHemogramaAnalitic(e, l, t, vol, vel));
		System.out.println("-----------------------BIOQUIMIC-----------------------\n");
		System.out.println(metge.demanarHemogramaBioquimic(s, m));
		System.out.println("-----------------------COMPLET-------------------------\n");
		System.out.println(metge.demanarHemogramaComplet(e, l, t, vol, vel, s, m));
	}

}
