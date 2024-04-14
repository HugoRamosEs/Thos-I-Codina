package thosi;

import java.util.Arrays;

public class Llista {
	private Comparable[] objectes;
	
	public Llista() {
		this.objectes = new Comparable[0];
	}

	public void add(Comparable o) {
		if (this.objectes.length == 0) {
			Comparable[] tmp = new Comparable[this.objectes.length + 1];
			tmp[0] = o;
			this.objectes = tmp;
		}else {
			if (this.objectes[0].getClass() == o.getClass()) {
	            Comparable[] tmp = new Comparable[this.objectes.length + 1];
	            int j = 0;
	            for (int i = 0; i < this.objectes.length; i++) {
	                if (o.compareTo(this.objectes[i]) < 0) {
	                    break;
	                }
	                j = i + 1;
	                tmp[i] = this.objectes[i];
	            }
	            tmp[j] = o;
	            for (int i = j; i < this.objectes.length; i++) {
	                tmp[i + 1] = this.objectes[i];
	            }
	            this.objectes = tmp;
			}
		}
	}
	
	public boolean isIn(Comparable o) {
	    for (int i = 0; i < this.objectes.length; i++) {
	        if (o.equals(this.objectes[i])) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public void remove(Comparable o) {
	    int pos = -1;
	    if (isIn(o)) {
	        for (int i = 0; i < this.objectes.length; i++) {
	            if (o.equals(this.objectes[i])) {
	                pos = i;
	            }
	        }
	        if (pos != -1) {
	            Comparable[] tmp = new Comparable[this.objectes.length - 1];
	            int j = 0;
	            for (int i = 0; i < this.objectes.length; i++) {
	                if (i != pos) {
	                    tmp[j] = this.objectes[i];
	                    j++;
	                }
	            }
	            this.objectes = tmp;
	        }
	    }
	}
	
	public void clear() {
		this.objectes = new Comparable[0];
	}

	public Comparable[] getObjectes() {
		return objectes;
	}

	public void setObjectes(Comparable[] objectes) {
		this.objectes = objectes;
	}

	@Override
	public String toString() {
		return "Llista: " + Arrays.toString(this.objectes);
	}
	
}