import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        game();
    }

    public static void game() {
        //ask number of rounds
        Scanner sc = new Scanner(System.in);
        System.out.println("How many rounds would you like to play?");
        int rounds;
        try {
            rounds = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException ex) {
            System.out.println("not a number");
            return;
        }
        if (!(1<=rounds && rounds<=10)) {
            System.out.println("needs to be between 1 and 10");
            return;
        }

        //play games
        int draws = 0;
        int userWins = 0;
        int userLosses = 0;

        for (int i = 1; i <= rounds; i++) {
            System.out.println("Round " + i);

            //ask for user choice
            boolean isValid = false;
            String stringChoice = "";
            while (!isValid) {
                System.out.println("Enter your choice (0 = Rock, 1 = Paper, 2 = Scissors): ");
                stringChoice = sc.nextLine();
                if (stringChoice.equals("0") || stringChoice.equals("1") || stringChoice.equals("2")) {
                    isValid = true;
                } else {
                    System.out.println("Not valid input");
                }
            }
            int userChoice = Integer.parseInt(stringChoice);

            //generate computer choice
            Random rng = new Random();
            String[] choices = {"Rock", "Paper", "Scissors"};
            int compChoice = rng.nextInt(2);
            System.out.println("Computer chose " + choices[compChoice]);

            //determine outcome
            if (userChoice == compChoice) {
                System.out.println("It's a draw");
                draws ++;
            } else if ((userChoice+1)%3 == compChoice) {
                System.out.println("You lost");
                userLosses ++;
            } else {
                System.out.println("You won!");
                userWins++;
            }
        }

        //report total result
        System.out.println("Overall Result: ");
        System.out.println("Wins = " + userWins + ", Losses = "+ userLosses + ", Draws = " + draws);

        if (userWins == userLosses) {
            System.out.println("DRAW");
        } else if (userWins < userLosses) {
            System.out.println("LOSS");
        } else {
            System.out.println("WIN");
        }

        //ask if want to play again
        System.out.println("Would you like to play again? (yes/no)");
        String response = sc.nextLine();
        if (response.equals("yes")) {
            game();
        } else {
            System.out.println("Thanks for playing!");
        }
    }
}
