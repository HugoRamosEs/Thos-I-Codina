import java.io.*;
 
public class E07_Votacion {
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
 
        System.out.print("Entra número de candidatos: ");
        int numCandidatos = Integer.parseInt(entrada.readLine());
        System.out.print("Entra número de votantes: ");
        int numVotantes = Integer.parseInt(entrada.readLine());
 
        int[] votos = new int[numCandidatos];
        
        for (int i = 1; i <= numVotantes; i++) {
            boolean correcto = false;
            while (!correcto) {
                try {
 
                    System.out.printf("Votante %d, entra tu voto (1-%d):", i, numCandidatos);
                    int candidatoVotado = Integer.parseInt(entrada.readLine());
                    if (candidatoVotado >= 1 && candidatoVotado <= numCandidatos) {
                        votos[candidatoVotado - 1]++;
                        correcto = true;
                    }
                    else {
                        System.out.println("Voto inválido.");
                    }
                } catch (Exception e) {
                    System.out.println("Voto inválido.");
                }
            }
        }
        System.out.println("\nResultados:");
        System.out.println("------------------");
        for (int i = 0; i < numCandidatos; i++) {
            System.out.printf("Candidato %d: %d votos.\n", i + 1, votos[i]);
        }
    }
}
