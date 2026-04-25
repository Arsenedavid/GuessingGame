import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {

        // Génération du nombre secret entre 1 et 100
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1;

        // Initialisation des variables
        int maxAttempts = 10;
        int attemptCount = 0;
        boolean hasWon = false;

        Scanner keyboard = new Scanner(System.in);

        System.out.println("=== Jeu de Devinettes ===");
        System.out.println("Devinez un nombre entre 1 et 100.");
        System.out.println("Vous avez " + maxAttempts + " essais.");
        System.out.println("=========================");

        // Boucle principale : 10 essais maximum
        while (attemptCount < maxAttempts) {

            int remaining = maxAttempts - attemptCount;
            System.out.print("Essai " + (attemptCount + 1) + "/" + maxAttempts
                    + " (" + remaining + " restants) → ");

            int userGuess = keyboard.nextInt();
            attemptCount++;

            if (userGuess < secretNumber) {
                System.out.println("Trop petit ! Essayez plus grand.\n");

            } else if (userGuess > secretNumber) {
                System.out.println("Trop grand ! Essayez plus petit.\n");

            } else {
                System.out.println("\n Félicitations ! Vous avez trouvé le nombre "
                        + secretNumber + " en " + attemptCount + " essai(s) !");
                hasWon = true;
                break;
            }
        }

        // Fin de partie
        if (!hasWon) {
            System.out.println("\n Vous avez perdu ! Le nombre secret était : " + secretNumber);
        }

        keyboard.close();
    }
}