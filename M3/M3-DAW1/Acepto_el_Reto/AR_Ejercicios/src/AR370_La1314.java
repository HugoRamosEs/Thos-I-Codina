import java.io.*;

public class AR370_La1314 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader tec=new BufferedReader(new InputStreamReader(System.in));
		
		int a = 0;
		int b = 0;
		int resta = 0;
		
		System.err.println("Indica el número de casos: ");
		int casos=Integer.parseInt(tec.readLine());

		for (int i = 0; i < casos; i++) {
			System.err.println("Indica a y b: ");
			String linia = tec.readLine();
			String parts[]=linia.split("-");
			a = Integer.parseInt(parts[0]);
			b = Integer.parseInt(parts[1]);

			int min = Math.min(a, b);

			resta = a - b;
			if (min % 2 == 0) {
				if (resta == 1 || resta == -1) {
					System.out.println("SI");
				}else {
					System.out.println("NO");
				}
			}else {
				System.out.println("NO");
			}
		}
	}
}
