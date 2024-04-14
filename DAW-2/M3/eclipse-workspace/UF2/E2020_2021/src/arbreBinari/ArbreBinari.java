//package arbreBinari;
//
//import main.MyException;
//
///**
// * @author toni
// * Class ArbreBinari
// * Estructura d'emmagatzemament d'objectes del tipus Comparable, o qualsevol
// * de les seves classes filles (StringOrdenable, SencerOrdenable.... o totes 
// * aquelles que volguem definir.
// * Té com propietats la dada a enmagatzemar (Comparable) i dos apuntadors per
// * martenir l'estructura d'ordenació.
// */
//public class ArbreBinari {
//	private Comparable dada;
//	private ArbreBinari arbre_dreta;
//	private ArbreBinari arbre_esquerra;
//	
//	/**
//	 * @param e
//	 * Constructor 
//	 */
//	public ArbreBinari(Comparable e){
//		this.dada = e;
//		this.arbre_dreta = null;
//		this.arbre_esquerra = null;
//	}
//
//	
//	/**
//	 * @return Retorna l'ArbreBinari que penja a l'esquerra (valors més petits que l'arrel)
//	 */
//	public ArbreBinari esquerra() {  
//		return this.arbre_esquerra;
//	}
//
//	/**
//	 * @return Retorna l'ArbreBinari que penja a la dreta (valors més grans que l'arrel)
//	 */
//	public ArbreBinari dreta() { 
//		return this.arbre_dreta;
//	}
//	
//	/**
//	 * @param e
//	 * Segon procediment recursiu d'inserció d'un element.
//	 * Es fonamenta en el constructor amb paràmetre.
//	 * @throws MyException 
//	 */
//	public void inserir(Comparable e) throws MyException{
//		if (e==null) {
//			throw new MyException("Error Codi 002");
//		}
//
//		if (this.dada.compareTo(e) == 1){
//			if (arbre_esquerra == null){
//				ArbreBinari novaBranca = new ArbreBinari(e);
//				arbre_esquerra = novaBranca;
//			} else {
//				arbre_esquerra.inserir(e);
//			}
//		} else {
//			if (arbre_dreta == null){
//				ArbreBinari novaBranca = new ArbreBinari(e);
//				arbre_dreta = novaBranca;
//			} else {
//				arbre_dreta.inserir(e);
//			}
//		}
//	}
//	
//	
//	public void inserirIteratiu(Comparable e){
//		if (e==null) {
//			throw new NullPointerException();
//		}
//		
//		if (this.dada == null) {
//			this.dada = e;
//		} else {
//			ArbreBinari novaBranca = new ArbreBinari(e);
//			ArbreBinari aux = this;
//			boolean posicioTrobada = false;
//
//			while (!posicioTrobada){
//				if (e.compareTo(aux.getDada())==-1){
//					if (aux.esquerra() == null){
//						posicioTrobada = true;
//						aux.arbre_esquerra = novaBranca;
//					} else {
//						aux = aux.esquerra();
//					}
//				} else {
//					if (aux.dreta() == null){
//						posicioTrobada = true;
//						aux.arbre_dreta = novaBranca;
//					} else {
//						aux = aux.dreta();
//					}
//				}
//			}
//		}
//	}
//	
//    public ArbreBinari find(Comparable e) {
//    	if (e==null) {
//			throw new MyException("Error Codi 004");
//		}
//
//    	ArbreBinari response;
//    	
//        if (this.dada.equals(e)) {
//            response = this;
//        } else if (this.dada.compareTo(e) == 1) {
//            if (this.arbre_esquerra != null) {
//                response = this.arbre_esquerra.find(e);
//            } else {
//                response = null;
//            }
//        } else {
//            if (this.arbre_dreta != null) {
//                response = this.arbre_dreta.find(e);
//            } else {
//            	response = null;
//            }
//        }
//        return response;
//    }
//
//	
//	// Busca el node més gran de la branca.
//	public ArbreBinari trobarArbreAnterior() {
//	    if (this.esquerra() == null) {
//	        return this;
//	    } else {
//	        return this.esquerra().trobarArbreAnterior();
//	    }
//	}
//	
//	//Busca el node més petit de la branca
//	public ArbreBinari trobarArbreSeguent() {
//	    if (this.dreta() == null) {
//	        return this;
//	    } else {
//	        return this.dreta().trobarArbreSeguent();
//	    }
//	}
//	
//	public ArbreBinari delete(Comparable e) throws MyException    {
//		if (this.find(e) == null) {
//			throw new MyException("Error Codi 005");
//		}
//		
//	    ArbreBinari response = this;
//	    if (this.dada.compareTo(e) == 1) {
//	    	this.arbre_esquerra = this.arbre_esquerra.delete(e);
//	    } else if (this.dada.compareTo(e) == -1) {
//	        this.arbre_dreta = this.arbre_dreta.delete(e);
//	    } else {
//	        if (this.arbre_esquerra != null && this.arbre_dreta != null) {
//	            ArbreBinari temp = this;
//	            ArbreBinari maxDeLEsquerra = this.arbre_esquerra.trobarArbreAnterior();
//	            this.dada = maxDeLEsquerra.getDada();
//	            temp.arbre_esquerra = temp.arbre_esquerra.delete(maxDeLEsquerra.getDada());
//	        } else if (this.arbre_esquerra != null) {
//	            response = this.arbre_esquerra;
//	        } else if (this.arbre_dreta != null) {
//	            response = this.arbre_dreta;
//	        } else {
//	            response = null;
//	        }
//	    }
//	    return response;
//	}
//	
//	/* És un mètode anàlog a toString */
//	public int size(){
//		int tamany = 0;
//		if (arbre_esquerra != null) {
//			tamany += arbre_esquerra.size();
//		}
//		tamany += 1;
//		if (arbre_dreta != null){
//			tamany += arbre_dreta.size();
//		}
//		return tamany;		
//	}
//	
//	
//
//	/**
//	 * Getter
//	 * @return dada de tipus Comparable o compatible.
//	 */
//	public Comparable getDada() {
//		return dada;
//	}
//
//	/* (non-Javadoc)
//	 * @see java.lang.Object#toString()
//	 * Recorro recursivament l'estructura ArbreBinari per generar una cadema amb 
//	 * els elements en forma d'string
//	 */
//	public String toString(){
//		String result = "";
//		if (arbre_esquerra != null) {
//			result += arbre_esquerra.toString();
//		}
//		result += dada.toString() + " - ";
//		if (arbre_dreta != null){
//			result += arbre_dreta.toString();
//		}
//		return result;		
//	}
//	
//}
