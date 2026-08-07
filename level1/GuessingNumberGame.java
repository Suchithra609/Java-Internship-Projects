package level1;
import java.util.Random;
import java.util.Scanner;
public class GuessingNumberGame {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        Random random = new Random();
	        int randomNumber = random.nextInt(100) + 1;
	        int maxAttempts = 5;
	        boolean guessedCorrectly = false;
	        System.out.println("===== Number Guessing Game =====");
	        System.out.println("Guess a number between 1 and 100");
	        System.out.println("You have " + maxAttempts + " attempts.");
	        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
	            System.out.print("\nAttempt " + attempt + ": Enter your guess: ");
	            if (!sc.hasNextInt()) {
	                System.out.println("Invalid input! Please enter a number.");
	                sc.next();
	                attempt--;
	                continue;
	            }
	            int guess = sc.nextInt();
	            if (guess < 1 || guess > 100) {
	                System.out.println("Please enter a number between 1 and 100.");
	                attempt--;
	                continue;
	            }
	            if (guess == randomNumber) {
	                System.out.println("Congratulations! You guessed the correct number.");
	                guessedCorrectly = true;
	                break;
	            }
	            else if (guess > randomNumber) {
	                System.out.println("Too high! Try a smaller number.");
	            }
	            else {
	                System.out.println("Too low! Try a bigger number.");
	            }
	        }
	        if (!guessedCorrectly) {
	            System.out.println("\nGame Over!");
	            System.out.println("The correct number was: " + randomNumber);
	        }
	        sc.close();
	    }
	}
