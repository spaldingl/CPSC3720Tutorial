package cpsc2150.connectX;
import java.util.*;

/**
 * main method where user interacts with game
 * @author - Spalding Latham 2/10/2019
 */
public class Connect4Game {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        boolean gameOver = false;
        boolean validInput = false;
        boolean restart = true;
        int marker = 0;
        GameBoard c4 = new GameBoard();


        while(gameOver == false) {
            //if the game starts over generate new board
            if(restart == true) {
                c4 = new GameBoard();
                System.out.println("|0|1|2|3|4|5|6|");
                System.out.println(c4);
            }
            //reset to false after restart
            validInput = false;
            restart = false;

            /* PLAYER X */

            //validate input for column
            while(validInput == false) {
                System.out.println("Player X, what column do you want to place your marker in?");
                marker = in.nextInt();
                if (marker < 0) {
                    System.out.println("Column cannot be less than 0");
                } else if (marker > 6) {
                    System.out.println("Column cannot be greater than 6");
                } else if (!c4.checkIfFree(marker)) {
                    System.out.println("Column is full");
                } else {
                    validInput = true;
                }
            }
            c4.placeToken('X', marker);
            System.out.println("|0|1|2|3|4|5|6|");
            System.out.println(c4);

            if(c4.checkForWin(marker)) {
                char input = ' ';
                boolean validChar = false;
                System.out.println("Player X Won!");
                //validate input for restart
                while (validChar == false) {
                    System.out.println("Would you like to play again? Y/N");
                    input = in.next().charAt(0);
                    if ((input == 'y') || (input == 'n') || (input == 'Y') || (input == 'N')) {
                        validChar = true;
                    }
                }
                if ((input == 'n') || (input == 'N')) {
                    System.exit(0);
                } else {
                    restart = true;
                }

            }
                if(c4.checkTie()){
                    System.out.println("It's a tie!");
                    char input = ' ';
                    boolean validChar = false;
                    //validate input for restart
                    while(validChar == false) {
                        System.out.println("Would you like to play again? Y/N");
                        input = in.next().charAt(0);
                        if((input == 'y') || (input == 'n') || (input == 'Y') || (input == 'N')){
                            validChar = true;
                        }
                    }
                    if((input == 'n') || (input == 'N')){
                        System.exit(0);
                    } else {
                        restart = true;
                    }
                }

            /* PLAYER O */

            validInput = false;
            while((validInput == false) && (restart == false)) {
                System.out.println("Player O, what column do you want to place your marker in?");
                marker = in.nextInt();
                //validate input for column
                if (marker < 0) {
                    System.out.println("Column cannot be less than 0");
                } else if (marker > 6) {
                    System.out.println("Column cannot be greater than 6");
                } else if (!c4.checkIfFree(marker)) {
                        System.out.println("Column is full");
                    } else {
                    validInput = true;
                }
            }
            c4.placeToken('O', marker);
            System.out.println("|0|1|2|3|4|5|6|");
            System.out.println(c4);
            if(c4.checkForWin(marker)) {
                char input = ' ';
                boolean validChar = false;
                //validate input for restart
                while (validChar == false) {
                    System.out.println("Player O Won!\nWould you like to play again? Y/N");
                    input = in.next().charAt(0);
                    if ((input == 'y') || (input == 'n') || (input == 'Y') || (input == 'N')) {
                        validChar = true;
                    }
                }
                if ((input == 'n') || (input == 'N')) {
                    System.exit(0);
                } else {
                    restart = true;
                }
            }
            if(c4.checkTie()) {
                System.out.println("It's a tie!");
                char input = ' ';
                boolean validChar = false;
                //validate input for restart
                while (validChar == false) {
                    System.out.println("Would you like to play again? Y/N");
                    input = in.next().charAt(0);
                    if ((input == 'y') || (input == 'n') || (input == 'Y') || (input == 'N')) {
                        validChar = true;
                    }
                }
                if ((input == 'n') || (input == 'N')) {
                    System.exit(0);
                } else {
                    restart = true;
                }
            }



        }
    }
}
