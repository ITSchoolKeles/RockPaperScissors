import java.util.Random;
import java.util.Scanner;
import java.util.SortedMap;

public class RockPaperScissors {

    private static Random random = new Random();
     private static final String ROCK = "ROCK";
     private static final String PAPER = "PAPER";
     private static final String SCISSORS = "SCISSORS";
     private static final String DRAW = "DRAW";
     private static final String WIN = "WIN";
     private static final String LOSE = "LOSE";
     private static final String INVALID_CHOICE_NUMBER = "Invalid Choice Number";
    private static int victoryCount = 0;
    private static int loseCount = 0;
    private static int drawCount = 0;

    public static void main(String[] args) {
         int i = 1;

        while (true) {
            System.out.println("Current attempt is " + i);

           String computerChoice = computerChoice();

           String playerChoice = playerChoice();

            if (playerChoice.equals(INVALID_CHOICE_NUMBER)) {
                System.out.println("You have picked an invalid choice.");
                return;
            }
            String result = finalResult(playerChoice, computerChoice);

            info(playerChoice, computerChoice, result);

            int continueGame = continueTheGame();
            if(continueGame == 0){
                break;
            }
            i++;
        }
        finalResultInfo();
    }
    public static String computerChoice(){
        int generatedRanNumber = random.nextInt(0, 3);
        // random raqamni tanlovga moslash
        String computerChoice = "";
        switch (generatedRanNumber) {
            case 0:
                computerChoice = ROCK;
                break;
            case 1:
                computerChoice = PAPER;
                break;
            case 2:
                computerChoice = SCISSORS;
                break;
        }
        return computerChoice;
    }
    public static String playerChoice(){
        Scanner scannerForInt = new Scanner(System.in);
        System.out.print("Enter the numbers in this range[0-2] ");
        int playerChoiceNumber = scannerForInt.nextInt();
        return   switch (playerChoiceNumber) {
            case 0 -> ROCK;
            case 1 -> PAPER;
            case 2 -> SCISSORS;
            default -> INVALID_CHOICE_NUMBER;
        };
    }
    public static String resultForPlayerChoiceRock(String computerChoice){
        if (computerChoice.equals(SCISSORS)) {
            victoryCount++;
            return WIN;
        } else if (computerChoice.equals(PAPER)) {
            loseCount++;
             return LOSE;
        } else {
            drawCount++;
             return DRAW;
        }
    }
    public static String resultForPlayerChoiceScissors(String computerChoice){
        if (computerChoice.equals(PAPER)) {
            victoryCount++;
            return WIN;
        } else if (computerChoice.equals(ROCK)) {
            loseCount++;
           return LOSE;
        } else {
            drawCount++;
            return  DRAW;
        }
    }
    public static String resultForPlayerChoicePaper(String computerChoice){
        if (computerChoice.equals(ROCK)) {
            victoryCount++;
            return WIN;
        } else if (computerChoice.equals(SCISSORS)) {
            loseCount++;
            return LOSE;
        } else {
            drawCount++;
            return DRAW;

        }
    }

    public static void info(String playerChoice, String computerChoice, String result){
        System.out.println("Computer choice is " + computerChoice);
        System.out.println("Player choice is " + playerChoice);
        System.out.println("Result is " + result);
        System.out.println("------------------  Live result table -----------------");
        System.out.println("WC - " + victoryCount + " LC - " + loseCount + " DC - " + drawCount);
        System.out.println("------------------------------------------------------");
    }
    public static void finalResultInfo(){
        if(victoryCount > loseCount){
            System.out.println("CONGRATULATIONS🎉🎉🎉🎉. You win");
        }else if(victoryCount == loseCount){
            System.out.println("DRAWWWWWWWWWW");
        }else{
            System.out.println("OOPSSSSS! You lose😥😥😥😥😥");
        }
    }
    public static int continueTheGame(){
        Scanner scannerForInt = new Scanner(System.in);
        System.out.print("Want to continue ... (1 - Yes, 0 - No) ");
        return scannerForInt.nextInt();
    }
    public static String finalResult(String playerChoice, String computerChoice){
        if (playerChoice.equals(ROCK))
            return resultForPlayerChoiceRock(computerChoice);
        else if (playerChoice.equals(SCISSORS))
            return resultForPlayerChoiceScissors(computerChoice);
        else return   resultForPlayerChoicePaper(computerChoice);
    }

}
