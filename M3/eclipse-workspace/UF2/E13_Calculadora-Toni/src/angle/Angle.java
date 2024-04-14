/*
  Defineix una classe Temps, segons el diseny UML, tenint en compte quins mètodes han de ser estàtics.
  Temps
 	hores:int
	minuts:int
	segons:int
		
	Temps( )
	Temps(String)
	Temps(int,int,int)
	suma(Temps):Temps
	suma(int,int,int):Temps
	suma(String,int):Temps
	suma(Temps,Temps):Temps
	resta(Temps):Temps
	resta(int,int,int):Temps
	resta(String,int):Temps
	resta(Temps,Temps):Temps
	toString( ):String
 */

package angle;

public class Angle {
	private int hora;
	private int minut;
	private int segon;
	
	public Angle() throws CalculadoraException{
		this.setHora(0);
		this.setMinut(0);
		this.setSegon(0);
	}
	public Angle(int hora, int minut, int segon) throws CalculadoraException {
		this.setHora(hora);
		this.setMinut(minut);
		this.setSegon(segon);
	}
	public Angle(Angle param) {
		this.hora = param.getHora();
		this.minut = param.getMinut();
		this.segon = param.getSegon();	
	}
	public Angle(String param) throws CalculadoraException {
		// Verifico el numero de dos punts que arriben:
	    int posicion, contador = 0;
	    int[] posicions = new int[2];
        
	    //se busca la primera vez que aparece
        posicion = param.indexOf(":");		    
        while (posicion != -1) { 			//mentre es trobi caracter
        	posicions[contador] = posicion;
            contador++;           			//contem
            //segueixo buscant a partir de la posició seguent
            posicion = param.indexOf(":", posicion + 1);
        }
		
		setHora(0);
		setMinut(0);
		setSegon(0);
		
		switch (contador) {
		case 0:
			if (!param.isEmpty()) {
				setSegon(Integer.valueOf(param));
			}
			break;
		case 1:
			if (!param.substring(0, posicions[0]).isEmpty()) {
				setMinut(Integer.valueOf(param.substring(0, posicions[0])));
			}
			if (!param.substring(posicions[0]+1).isEmpty()) {
				setSegon(Integer.valueOf(param.substring(posicions[0]+1)));
			}
			break;
		case 2:
			if (!param.substring(0, posicions[0]).isEmpty()) {
				setHora(Integer.valueOf(param.substring(0, posicions[0])));
			}
			if (!param.substring(posicions[0]+1,posicions[1]).isEmpty()) {
				setMinut(Integer.valueOf(param.substring(posicions[0]+1,posicions[1])));
			}
			if (!param.substring(posicions[1]+1).isEmpty()) {
				setSegon(Integer.valueOf(param.substring(posicions[1]+1)));
			}
			break;
		}
	}
	
	
	public int getHora() {
		return hora;
	}
	public void setHora(int hora) throws CalculadoraException {
		if (hora >= 0) {
			this.hora = hora%360;
		} else {
			this.hora = 360+hora%360;
		}
	}
	public int getMinut() {
		return minut;
	}
	public void setMinut(int param) throws CalculadoraException{
		int hores = (int)Math.floor(param/60);
		int minuts = param%60;
	
		if (minuts < 0) {
			minuts += 60;
			hores -= 1;
		}
		
		this.setHora(this.hora + hores);
		this.minut = minuts;					
	}
	public int getSegon() {
		return segon;
	}
	public void setSegon(int param) throws CalculadoraException {
		int minuts = (int)Math.floor(param/60);
		int segons = param%60;

		if (segons < 0) {
			segons += 60;
			minuts -=1;
		}
		this.setMinut(this.minut + minuts);
		this.segon = segons;
	}
	
	@Override
	public String toString() {
		return String.format("%02d",hora) + ":" + String.format("%02d",minut) + ":" + String.format("%02d",segon);
	}
	
	public Angle suma (Angle param) throws CalculadoraException{
		//Opció equivalent a tt=t1+t2
		return new Angle (this.getHora()+param.getHora(), this.getMinut()+param.getMinut(), this.getSegon()+param.getSegon());
		//Opció equibalent a tt+=t2
		/*
		this.setHora(this.hora + param.getHora());
		this.setMinut(this.minut + param.getMinut());
		this.setSegon(this.segon + param.getSegon());
		return this;
		*/
	}
	
	
	public Angle suma (int pHora, int pMinut, int pSegon) throws CalculadoraException{
		//Opció equivalent a tt=t1+t2
		return new Angle (this.getHora()+pHora, this.getMinut()+pMinut, this.getSegon()+pSegon);
		//Opció equibalent a tt+=t2
		/*
		this.setHora(this.hora + pHora);
		this.setMinut(this.minut + pMinut);
		this.setSegon(this.segon + pSegon);
		return this;
		*/
	}
	
	public Angle suma (String param) throws NumberFormatException, CalculadoraException{
		String cadena[] = param.split(":");
		//Opció equivalent a tt=t1+t2
		return new Angle (this.getHora()+Integer.parseInt(cadena[0]), this.getMinut()+Integer.parseInt(cadena[1]), this.getSegon()+Integer.parseInt(cadena[2]));
		//Opció equibalent a tt+=t2
		/*
		this.setHora(this.hora + Integer.parseInt(cadena[0]));
		this.setMinut(this.minut + Integer.parseInt(cadena[1]);
		this.setSegon(this.segon + Integer.parseInt(cadena[2]));
		return this;
		*/

	}
	
	public static Angle suma (Angle param1 , Angle param2) throws CalculadoraException{
		return new Angle (param1.getHora()+param2.getHora(), param1.getMinut()+param2.getMinut(), param1.getSegon()+param2.getSegon());
	}
	
	public Angle resta (Angle param) throws CalculadoraException{
		//Opció equivalent a tt=t1-t2
		return new Angle (this.getHora()-param.getHora(), this.getMinut()-param.getMinut(), this.getSegon()-param.getSegon());
		//Opció equibalent a tt+=t2
		/*
		this.setHora(this.hora - param.getHora());
		this.setMinut(this.minut - param.getMinut());
		this.setSegon(this.segon - param.getSegon());
		return this;
		*/
	}
	
	public Angle resta (int pHora, int pMinut, int pSegon) throws CalculadoraException{
		//Opció equivalent a tt=t1-t2
		return new Angle (this.getHora()-pHora, this.getMinut()-pMinut, this.getSegon()-pSegon);
		//Opció equibalent a tt-=t2
		/*
		this.setHora(this.hora - pHora);
		this.setMinut(this.minut - pMinut);
		this.setSegon(this.segon - pSegon);
		return this;
		*/
	}
	
	public Angle resta (String param) throws NumberFormatException, CalculadoraException{
		String cadena[] = param.split(":");
		//Opció equivalent a tt=t1-t2
		return new Angle (this.getHora()-Integer.parseInt(cadena[0]), this.getMinut()-Integer.parseInt(cadena[1]), this.getSegon()-Integer.parseInt(cadena[2]));
		//Opció equibalent a tt-=t2
		/*
		this.setHora(this.hora - Integer.parseInt(cadena[0]));
		this.setMinut(this.minut - Integer.parseInt(cadena[1]);
		this.setSegon(this.segon - Integer.parseInt(cadena[2]));
		return this;
		*/
	}
	public static Angle resta (Angle param1 , Angle param2) throws CalculadoraException{
		return new Angle (param1.getHora()-param2.getHora(), param1.getMinut()-param2.getMinut(), param1.getSegon()-param2.getSegon());
	}

}
