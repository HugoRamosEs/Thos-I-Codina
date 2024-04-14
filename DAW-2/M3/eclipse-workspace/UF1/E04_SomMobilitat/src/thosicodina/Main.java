package thosicodina;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		LocalDate dataInici = LocalDate.of(2023, 10, 5);
		LocalDate dataInici2 = LocalDate.of(2023, 10, 8);
		LocalDate dataFinal = LocalDate.of(2023, 10, 7);
		
		Soci soci = new Soci("Hugo", "Ramos", "12345678C", "B");
		Soci soci2 = new Soci("Manuel", "Ramos", "12345678B", "B");
		Soci soci3 = new Soci("Mario", "Ramos", "12345678B", "A1");
		Cotxe cotxe = new Cotxe(1, "Cirera, Mataró", 350.20, "AAA 0001", "Electric", 15000);
		Ocupacio ocupacio = new Ocupacio(soci, cotxe);
		Reserva reserva = new Reserva(ocupacio, dataInici, dataFinal);
		Reserva reserva2 = new Reserva(ocupacio, dataInici2, dataFinal);
		
		soci.alquilarVehicle(cotxe, reserva, ocupacio);
		soci.alquilarVehicle(cotxe, reserva2, ocupacio);
		soci2.alquilarVehicle(cotxe, reserva, ocupacio);
		soci3.alquilarVehicle(cotxe, reserva, ocupacio);
	}
}
