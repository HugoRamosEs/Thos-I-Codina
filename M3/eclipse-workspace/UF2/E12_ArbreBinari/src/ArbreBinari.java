/**
 * @author toni
 * Class ArbreBinari
 * Estructura d'emmagatzemament d'objectes del tipus ElementOrdenable, o qualsevol
 * de les seves classes filles (StringOrdenable, SencerOrdenable.... o totes 
 * aquelles que volguem definir.
 * Té com propietats la dada a enmagatzemar (ElementOrdenable) i dos apuntadors per
 * martenir l'estructura d'ordenació.
 */
public class ArbreBinari {
	private ElementOrdenable dada;
	private ArbreBinari arbre_dreta;
	private ArbreBinari arbre_esquerra;
	
	/**
	 * Constructor vuit
	 */
	public ArbreBinari(){
		this.dada = null;
		this.arbre_dreta = null;
		this.arbre_esquerra = null;
	}
	/**
	 * @param e
	 * Constructor 
	 */
	public ArbreBinari(ElementOrdenable e){
		this.dada = e;
		this.arbre_dreta = null;
		this.arbre_esquerra = null;
	}

	
	/**
	 * @return Retorna l'ArbreBinari que penja a l'esquerra (valors més petits que l'arrel)
	 */
	public ArbreBinari esquerra() {  
		return this.arbre_esquerra;
	}

	/**
	 * @return Retorna l'ArbreBinari que penja a la dreta (valors més grans que l'arrel)
	 */
	public ArbreBinari dreta() { 
		return this.arbre_dreta;
	}
	/**
	 * @return Retorna l'arrel
	 */
	public ElementOrdenable obtenirElemetArrel() {
		return this.dada;
	}
	
	/**
	 * @param e
	 * Primer procediment recursiu d'inserció d'un element.
	 * Es fonamenta en el constructor vuit.
	 */
	public void inserir (ElementOrdenable e) {
		if (e==null) {
			throw new NullPointerException();
		}
		if (dada == null) {
			dada = e;
		} else {
			if (e.menorQue(dada)) {
				if (arbre_esquerra == null) {
					arbre_esquerra = new ArbreBinari();
				}
				arbre_esquerra.inserir(e);
			} else {
				if (arbre_dreta == null) {
					arbre_dreta = new ArbreBinari();
				}
				arbre_dreta.inserir(e);
			}
		}
	}
	
	
	/**
	 * @param e
	 * Segon procediment recursiu d'inserció d'un element.
	 * Es fonamenta en el constructor amb paràmetre.
	 */
	public void inserirAlternatiu(ElementOrdenable e){
		if (e==null) {
			throw new NullPointerException();
		}

		if (e.menorQue(dada)){
			if (arbre_esquerra == null){
				ArbreBinari novaBranca = new ArbreBinari(e);
				arbre_esquerra = novaBranca;
			} else {
				arbre_esquerra.inserirAlternatiu(e);
			}
		} else {
			if (arbre_dreta == null){
				ArbreBinari novaBranca = new ArbreBinari(e);
				arbre_dreta = novaBranca;
			} else {
				arbre_dreta.inserirAlternatiu(e);
			}
		}
	}
	
	/**
	 * @param e
	 * Procediment iteratiu d'inserció d'un element.
	 * Només fa servir bucles.
	 */
	public void inserirIteratiu(ElementOrdenable e){
		if (e==null) {
			throw new NullPointerException();
		}
		
		if (this.dada == null) {
			this.dada = e;
		} else {
			ArbreBinari novaBranca = new ArbreBinari(e);
			ArbreBinari aux = this;
			boolean posicioTrobada = false;

			while (!posicioTrobada){
				if (e.menorQue(aux.obtenirElemetArrel())){
					if (aux.esquerra() == null){
						posicioTrobada = true;
						aux.arbre_esquerra = novaBranca;
					} else {
						aux = aux.esquerra();
					}
				} else {
					if (aux.dreta() == null){
						posicioTrobada = true;
						aux.arbre_dreta = novaBranca;
					} else {
						aux = aux.dreta();
					}
				}
			}
		}
	}
	
    public ArbreBinari find(ElementOrdenable e) {
    	if (e==null) {
			throw new NullPointerException();
		}

    	ArbreBinari response;
    	
        if (e.equals(this.dada)) {
            response = this;
        } else if (e.menorQue(this.dada)) {
            if (this.arbre_esquerra != null) {
                response = this.arbre_esquerra.find(e);
            } else {
                response = null;
            }
        } else {
            if (this.arbre_dreta != null) {
                response = this.arbre_dreta.find(e);
            } else {
            	response = null;
            }
        }
        return response;
    }

	
	// Busca el node més gran de la branca.
	public ArbreBinari trobarArbreAnterior() {
	    if (this.esquerra() == null) {
	        return this;
	    } else {
	        return this.esquerra().trobarArbreAnterior();
	    }
	}
	
	//Busca el node més petit de la branca
	public ArbreBinari trobarArbreSeguent() {
	    if (this.dreta() == null) {
	        return this;
	    } else {
	        return this.dreta().trobarArbreSeguent();
	    }
	}
	
	public ArbreBinari delete(ElementOrdenable e) throws NullPointerException  {
		if (this.find(e) == null) {
			throw new NullPointerException();
		}
		
	    ArbreBinari response = this;
	    if (e.menorQue(this.dada)) {
	    	this.arbre_esquerra = this.arbre_esquerra.delete(e);
	    } else if (this.dada.menorQue(e)) {
	        this.arbre_dreta = this.arbre_dreta.delete(e);
	    } else {
	        if (this.arbre_esquerra != null && this.arbre_dreta != null) {
	            ArbreBinari temp = this;
	            ArbreBinari maxDeLEsquerra = this.arbre_esquerra.trobarArbreAnterior();
	            this.dada = maxDeLEsquerra.obtenirElemetArrel();
	            temp.arbre_esquerra = temp.arbre_esquerra.delete(maxDeLEsquerra.obtenirElemetArrel());
	        } else if (this.arbre_esquerra != null) {
	            response = this.arbre_esquerra;
	        } else if (this.arbre_dreta != null) {
	            response = this.arbre_dreta;
	        } else {
	            response = null;
	        }
	    }
	    return response;
	}
	
	/* És un mètode anàlog a toString */
	public int size(){
		int tamany = 0;
		if (arbre_esquerra != null) {
			tamany += arbre_esquerra.size();
		}
		tamany += 1;
		if (arbre_dreta != null){
			tamany += arbre_dreta.size();
		}
		return tamany;		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * Recorro recursivament l'estructura ArbreBinari per generar una cadema amb 
	 * els elements en forma d'string
	 */
	public String toString(){
		String result = "";
		if (arbre_esquerra != null) {
			result += arbre_esquerra.toString();
		}
		result += dada.toString() + " - ";
		if (arbre_dreta != null){
			result += arbre_dreta.toString();
		}
		return result;		
	}
	
}
