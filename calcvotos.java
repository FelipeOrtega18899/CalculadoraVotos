mkdir proyectootos
cd proyectovotos
git init

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalculadoraVotos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> urna = new HashMap<>();
        int totalVotos = 0;

        System.out.println("--- Sistema de Conteo de Votos ---");
        System.out.println("Ingrese el numero del candidato (o '0' para finalizar):");

        while (true) {
            int voto = sc.nextInt();
            if (voto == 0) break;

            urna.put(voto, urna.getOrDefault(voto, 0) + 1);
            totalVotos++;
        }

        if (totalVotos == 0) {
            System.out.println("No se registraron votos.");
        } else {
            System.out.println("\n--- RESULTADOS ---");
            System.out.println("Total de votos: " + totalVotos);
            
            for (Map.Entry<Integer, Integer> entry : urna.entrySet()) {
                int candidato = entry.getKey();
                int votosCandidato = entry.getValue();
                double porcentaje = ((double) votosCandidato / totalVotos) * 100;
                
                System.out.printf("Candidato %d: %d votos (%.2f%%)%n", 
                                  candidato, votosCandidato, porcentaje);
            }
        }
        sc.close();
    }
}