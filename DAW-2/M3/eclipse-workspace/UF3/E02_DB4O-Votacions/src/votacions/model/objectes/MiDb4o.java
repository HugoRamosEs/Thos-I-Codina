package votacions.model.objectes;

import java.io.File;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class MiDb4o {
    private static final String DB4OFILENAME = "src/votacions/docs/vots.db4o";
    private ObjectContainer db;
    
    private static MiDb4o _instance;
   
    private MiDb4o() {
        this.db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), MiDb4o.DB4OFILENAME);
    }
    
    public static MiDb4o getInstance() {
        if (_instance == null) {
            _instance = new MiDb4o();
        }
        
        return _instance;
    }
    
    public static void eliminarDb() {
        File db4o = new File(MiDb4o.DB4OFILENAME);
        if (db4o.exists()) {
            db4o.delete();
		}
        
        System.out.println("Base de dades eliminada.");
    }

    public void tancarDb() {
        if (this.db != null) {
        	this.db.close();
        }
    }

    public ObjectContainer getDb() {
        return db;
    }
    
	public static String getDb4oFile() {
		return MiDb4o.DB4OFILENAME;
	}
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Aquest objecte no es pot clonar.");
    }
}   
