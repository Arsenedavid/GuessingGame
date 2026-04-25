import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class GuessingGameFile {

    public static void main(String[] args) {

        // Génération du nombre secret
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1;

        int maxAttempts = 10;
        int attemptCount = 0;
        boolean hasWon = false;

        System.out.println("=== Mode Fichier - Jeu de Devinettes ===");
        System.out.println("Lecture des devinettes depuis : guesses.txt");
        System.out.println("=========================================\n");

        try {
            // Ouverture du fichier
            File file = new File("guesses.txt");
            Scanner fileScanner = new Scanner(file);

            // Lecture ligne par ligne
            while (fileScanner.hasNextLine() && attemptCount < maxAttempts) {

                String line = fileScanner.nextLine().trim();

                if (line.isEmpty()) continue;

                int userGuess = Integer.parseInt(line);
                attemptCount++;

                System.out.print("Essai " + attemptCount + " → Devinette : " + userGuess + " → ");

                if (userGuess < secretNumber) {
                    System.out.println("Trop petit !");

                } else if (userGuess > secretNumber) {
                    System.out.println("Trop grand !");

                } else {
                    System.out.println("Correct !");
                    System.out.println("\n Gagné ! Nombre " + secretNumber
                            + " trouvé en " + attemptCount + " essai(s) !");
                    hasWon = true;
                    break;
                }
            }

            fileScanner.close();

        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        if (!hasWon) {
            System.out.println("\n Perdu ! Le nombre secret était : " + secretNumber);
        }
    }
}