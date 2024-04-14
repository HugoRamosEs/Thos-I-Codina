package pregunta02;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Operacions {	
	
	public static void transferir (String idOrigen, String idDesti, double quantitat) throws Exception {
		Compte origen;
		Compte desti;
		Connection conn;
		
		DataBase database = new DataBase();			
		
		database.startTransaction();
		
		try {
			origen = database.find(idOrigen);
			if (origen == null)
				throw new Exception("No existeix " + idOrigen);
			origen.setBalance (origen.getBalance() - quantitat);
			database.store(origen);
			desti = database.find(idDesti);
				
			if (desti == null)
				throw new Exception("No existeix " + idDesti);
			desti.setBalance(desti.getBalance()+quantitat);
			database.store(desti);
			
			database.commit();
		} catch (Exception error) {		
			database.rollBack();
			throw new Exception(error);
		}
	}

	
}
