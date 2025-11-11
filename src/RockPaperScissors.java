import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // randomSonlarni generatsiya qilib beradi
        Random random = new Random();
        final String ROCK = "ROCK";
        final String PAPER = "PAPER";
        final String SCISSORS = "SCISSORS";
        final String DRAW = "DRAW";
        final String WIN = "WIN";
        final String LOSE = "LOSE";
        final String INVALID_CHOICE_NUMBER = "Invalid Choice Number";

        // compyuterni random tanlashini qilish
            // random son generatsiya qilish
        int generatedRanNumber = random.nextInt(0, 3);
        // random raqamni tanlovga moslash
        String computerChoice = "";
        switch (generatedRanNumber) {
            case 0: computerChoice = ROCK; break;
            case 1: computerChoice = PAPER; break;
            case 2: computerChoice = SCISSORS; break;
        }

    // player choice
        String playerChoice = "";
        System.out.print("Enter the numbers in this range[0-2] ");
        int playerChoiceNumber = input.nextInt();
        playerChoice = switch (playerChoiceNumber){
            case 0 ->  ROCK;
            case 1 ->  PAPER;
            case 2 ->  SCISSORS;
            default -> INVALID_CHOICE_NUMBER;
        };

        if(playerChoice.equals(INVALID_CHOICE_NUMBER)){
            System.out.println("You have picked an invalid choice.");
            return;
        }

        String result = "";
        if(playerChoice.equals(ROCK)){
            if(computerChoice.equals(SCISSORS)){
                result = WIN;
            }else if(computerChoice.equals(PAPER)){
                result = LOSE;
            }else {
                result = DRAW;
            }
        }else if(playerChoice.equals(SCISSORS)){
            if(computerChoice.equals(PAPER)){
                result = WIN;
            }else if(computerChoice.equals(ROCK)){
                result = LOSE;
            }else {
                result = DRAW;
            }
        }
        // paper uchun natija qismini logikasini yozish



        System.out.println("Computer choice is " + computerChoice);
        System.out.println("Player choice is " + playerChoice);
        System.out.println("Result is " + result);
        // rock vs rock = draw; rock vs scissors = win; rock vs paper = lose;



        //
        // 0 --> rock
        // 1 --> paper
        // 2 --> scissors


    }
}
