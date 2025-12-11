import java.util.Random;
import java.util.Scanner;
import java.util.SortedMap;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        /*
         * O'yinni n marta oynaydigan qilamiz(for)
         * Yakuniy natijani chiqaraydigan qilamiz --> 2 ta galaba 1 ta durang 1 mag'lubiyat
         * */
        // randomSonlarni generatsiya qilib beradi

        Random random = new Random();
        final String ROCK = "ROCK";
        final String PAPER = "PAPER";
        final String SCISSORS = "SCISSORS";
        final String DRAW = "DRAW";
        final String WIN = "WIN";
        final String LOSE = "LOSE";
        final String INVALID_CHOICE_NUMBER = "Invalid Choice Number";
        int victoryCount = 0;
        int loseCount = 0;
        int drawCount = 0;



         int i = 1;

        while (true) {

            System.out.println("Current attempt is " + i);
            // compyuterni random tanlashini qilish
            // random son generatsiya qilish
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

            // player choice
            String playerChoice = "";
            System.out.print("Enter the numbers in this range[0-2] ");
            int playerChoiceNumber = input.nextInt();
            playerChoice = switch (playerChoiceNumber) {
                case 0 -> ROCK;
                case 1 -> PAPER;
                case 2 -> SCISSORS;
                default -> INVALID_CHOICE_NUMBER;
            };

            if (playerChoice.equals(INVALID_CHOICE_NUMBER)) {
                System.out.println("You have picked an invalid choice.");
                return;
            }

            String result = "";
            if (playerChoice.equals(ROCK)) {
                if (computerChoice.equals(SCISSORS)) {
                    result = WIN;
                    victoryCount++;
                } else if (computerChoice.equals(PAPER)) {
                    result = LOSE;
                    loseCount++;
                } else {

                    result = DRAW;
                    drawCount++;
                }
            } else if (playerChoice.equals(SCISSORS)) {
                if (computerChoice.equals(PAPER)) {
                    result = WIN;
                    victoryCount++;
                } else if (computerChoice.equals(ROCK)) {
                    result = LOSE;
                    loseCount++;
                } else {
                    result = DRAW;
                    drawCount++;
                }
            } else {
                if (computerChoice.equals(ROCK)) {
                    result = WIN;
                    victoryCount++;
                } else if (computerChoice.equals(SCISSORS)) {
                    result = LOSE;
                    loseCount++;
                } else {
                    result = DRAW;
                    drawCount++;
                }
            }
            // paper uchun natija qismini logikasini yozish


            System.out.println("Computer choice is " + computerChoice);
            System.out.println("Player choice is " + playerChoice);
            System.out.println("Result is " + result);
            System.out.println("------------------  Live result table -----------------");
            System.out.println("WC - " + victoryCount + " LC - " + loseCount + " DC - " + drawCount);
            System.out.println("------------------------------------------------------");

            System.out.print("Want to continue ... (1 - Yes, 0 - No) ");
            System.out.println("------------------------------------------");
            System.out.println();
            System.out.println();

            System.out.println("------------------------------------------");
            int continueGame = input.nextInt();
            if(continueGame == 0){
                break;
            }




            // rock vs rock = draw; rock vs scissors = win; rock vs paper = lose;
        }

         if(victoryCount > loseCount){
             System.out.println("CONGRATULATIONS🎉🎉🎉🎉. You win");
         }else if(victoryCount == loseCount){
             System.out.println("DRAWWWWWWWWWW");
         }else{
             System.out.println("OOPSSSSS! You lose😥😥😥😥😥");
         }

    }

}
