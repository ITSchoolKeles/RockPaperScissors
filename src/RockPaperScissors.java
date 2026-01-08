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
    private static final String[][] HISTORY = new String[3][10];
    private static int currentAttempt = 0;// player choice, computer choice, result  recording
    public static void main(String[] args) {
  while (true) {
            displayMainMenu();
            Scanner input = new Scanner(System.in);
            int menuChoice = input.nextInt();
            if (menuChoice == 1) {
                playGame();
            } else if (menuChoice == 2) {
                displayHistory();
            } else {
                System.out.println("You exit the program ➡️➡️➡️");
                System.exit(0);
            }
            if(currentAttempt == 10) break;
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
    public static void displayHistory(){
         for(int i = 0; i < currentAttempt; i++){
             System.out.println("----------------------------------------------");
             System.out.println("Attempt " + (i +1) );
             System.out.println("Player choice -> " + HISTORY[0][i] );
             System.out.println("Computer choice -> " + HISTORY[1][i] );
             System.out.println("Result -> " + HISTORY[2][i] );
         }
    }
    public static void displayMainMenu(){
        System.out.println("1.Play the game ");
        System.out.println("2.See the whole history");
        System.out.println("3.See history by attempt number");
        System.out.println("0.Quit the game ");
        System.out.print("Choose the menu --> ");
    }
    public static void playGame(){
            System.out.println("Current attempt is " + (currentAttempt+1));

            String computerChoice = computerChoice();
            HISTORY[1][currentAttempt] = computerChoice;

            String playerChoice = playerChoice();
            HISTORY[0][currentAttempt] = playerChoice;


            if (playerChoice.equals(INVALID_CHOICE_NUMBER)) {
                System.out.println("You have picked an invalid choice.");
                return;
            }
            String result = finalResult(playerChoice, computerChoice);
            HISTORY[2][currentAttempt] = result;
            currentAttempt ++;

            info(playerChoice, computerChoice, result);

            int continueGame = continueTheGame();
            if (continueGame == 0) {
                return;
            }
        }
    }


