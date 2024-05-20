import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 10;
    private static final int MAX_ROUNDS = 5;
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        for (int round = 1; round <= MAX_ROUNDS; round++) {
            int targetNumber = random.nextInt(MAX_NUM - MIN_NUM + 1) + MIN_NUM;
            int attempts = 0;
            boolean roundWon = false;

            System.out.println("\nRound " + round + ": Guess the number between " + MIN_NUM + " and " + MAX_NUM + ".");

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");
                String input = scanner.nextLine();

                if (isValidNumber(input)) {
                    int userGuess = Integer.parseInt(input);
                    attempts++;

                    if (userGuess == targetNumber) {
                        System.out.println("Congratulations! You guessed the number.");
                        totalScore += (MAX_ATTEMPTS - attempts + 1);
                        roundWon = true;
                        break;
                    } else if (userGuess < targetNumber) {
                        System.out.println("Try again!Too low!");
                    } else {
                        System.out.println("Try again!Too high!");
                    }

                    System.out.println("Attempts left: " + (MAX_ATTEMPTS - attempts));
                } else {
                    System.out.println("Invalid input. Please enter a valid number between " + MIN_NUM + " and " + MAX_NUM + ".");
                }
            }

            if (!roundWon) {
                System.out.println("Out of attempts! The correct number was " + targetNumber + ".");
            }

            System.out.println("Score after round " + round + ": " + totalScore);

            if (round < MAX_ROUNDS) {
                System.out.print("wanna play another round? (yes/no): ");
                String playAgain = scanner.nextLine();
                if (!playAgain.equalsIgnoreCase("yes")) {
                    break;
                }
            }
        }

        System.out.println("Game over! Final score: " + totalScore);
        scanner.close();
    }

    private static boolean isValidNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            return number >= MIN_NUM && number <= MAX_NUM;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
