import java.io.*;

public class E19_Marco {

	public static void main(String[] args) throws IOException {
		
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Introduce la base: ");
		int base = Integer.parseInt(entrada.readLine());
		
		System.out.println("Introduce la altura: ");
		int altura = Integer.parseInt(entrada.readLine());
		
		for(int i = 1; i<=altura; i++) {
			for(int j = 1; j<=base; j++) {
				if(i==1 || i==altura || j==1 || j==base) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
				}
			System.out.println();
			}
	}
}
