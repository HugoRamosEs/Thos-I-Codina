package pregunta2;

/**
 * @author toni
 * Intercace ElementOrdenable.
 * Qualsevol objecte que s'hagi d'emmagatzemar en l'estructura ArbreBinari ha de
 * ser filla d'ElementOrdenable, per tant haurà d'implementar el mètode majorQue
 * per poder comparar dos objectes del mateix tipus, i així tenir un criteri
 * d'ordenació
 */
interface ElementOrdenable {
	public boolean menorQue(ElementOrdenable e);
}