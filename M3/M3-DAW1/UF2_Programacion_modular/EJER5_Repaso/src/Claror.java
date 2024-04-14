
public class Claror {
	
	double claror (char [][] array) {
		double espais = 0;
		for (int f = 0; f<array.length; f++) {
			for (int c = 0; c<array[f].length; c++) {
				if(array[f][c] == ' ') {
					espais ++;
				}
			}
		}
		return espais / (array.length * array[0].length) * 100;
	}
	
	public static void main(String[] args) {
		Claror programa = new Claror();
		
		char array[][]= {
				{'*', '*', ' ', ' ', '*'},
				{' ', '*', '*', ' ', ' '},
				{'*', '*', '*', '*', '*'},
				{' ', ' ', ' ', ' ', '*'}
		};
		
		System.out.println(programa.claror(array));
	}

}
