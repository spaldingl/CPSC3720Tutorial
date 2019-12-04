package cpsc2150.connectX;
import java.util.*;
import java.lang.*;

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
        int rows = 3;
        int columns = 3;
        int num = 0;
        int players = 0;
        ArrayList<Character> playerChars = new ArrayList<Character>();
        IGameBoard c4 = new GameBoard(rows, columns, num);


        while(gameOver == false) {
            //if the game starts over generate new board
            if(restart == true) {
                validInput = false;
                while(validInput == false) {
                    System.out.println("How many players?");
                    players = in.nextInt();
                    if ((players > 10) || (players < 2)) {
                        if (players > 10) {
                            System.out.println("Must be 10 players or fewer");
                        } else {
                            System.out.println("Must be at least 2 players");
                        }
                    } else {
                        for(int i = 1; i <= players; i++){
                            System.out.println("Enter the character to represent player " + i);
                            char token = in.next().charAt(0);
                            if((playerChars.contains(token)) || (playerChars.contains((char)(token - 32)))){
                                System.out.println(token + " is already taken as a player token!");
                                i--;
                            } else {
                                if(token < 97) {
                                    playerChars.add(token);
                                } else if(token <= 122){
                                    token = (char)(token - 32);
                                    playerChars.add(token);
                                }
                            }
                        }
                        validInput = true;
                    }

                }

                validInput = false;

                while(validInput == false) {
                    System.out.println("How many rows should be on the board?");
                    rows = in.nextInt();
                    if(rows < 3){
                        System.out.println("Must have at least 3 rows.");
                    }
                    else if(rows > 100){
                        System.out.println("Can have at most 100 rows");
                    } else {
                        validInput = true;
                    }
                }
                validInput = false;
                while(validInput == false){
                    System.out.println("How many columns should be on the board?");
                    columns = in.nextInt();

                    if(columns < 3){
                        System.out.println("Must have at least 3 columns.");
                    }
                    else if(columns > 100){
                        System.out.println("Can have at most 100 columns");
                    } else {
                        validInput = true;
                    }

                }
                validInput = false;
                while(validInput == false){
                    System.out.println("How many in a row to win?");
                    num = in.nextInt();

                    if(num < 3){
                        System.out.println("Must have at least 3 in a row to win.");
                    }
                    else if(num > 25){
                        System.out.println("Can have at most 25 in a row to win");
                    } else {
                        validInput = true;
                    }
                }
                validInput = false;
                while(validInput == false){
                    System.out.println("Would you like a Fast Game (F/f) or a Memory Efficient Game (M/m)?");
                    char gameSpeed = in.next().charAt(0);
                    if((gameSpeed != 'f') && (gameSpeed != 'F') && (gameSpeed != 'm') && (gameSpeed != 'M')){

                        System.out.println("Please enter F or M");
                    }

                    //initialize 2d array
                    else if((gameSpeed == 'f') || (gameSpeed == 'F')){
                        c4 = new GameBoard(rows, columns, num);
                        validInput = true;
                    }

                    //initialize map
                    else {
                        c4 = new GameBoardMem(rows, columns, num);
                        validInput = true;
                    }
                }

                System.out.println(c4);
            }


            //reset to false after restart
            validInput = false;
            restart = false;



            //validate input for column
            for(int i = 0; i < players; i++) {
                while (validInput == false) {
                    System.out.println("Player " + playerChars.get(i) + ", what column do you want to place your marker in?");
                    marker = in.nextInt();
                    if (marker < 0) {
                        System.out.println("Column cannot be less than 0");
                    } else if (marker > (columns - 1)) {
                        System.out.println("Column cannot be greater than " + (columns - 1));
                    } else if (!c4.checkIfFree(marker)) {
                        System.out.println("Column is full");
                    } else {
                        validInput = true;
                    }
                }
                validInput = false;
                c4.placeToken(playerChars.get(i), marker);
                System.out.println(c4);

                if (c4.checkForWin(marker)) {
                    char input = ' ';
                    boolean validChar = false;
                    System.out.println("Player " + playerChars.get(i) + " Won!");
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
                        playerChars.clear();
                        break;
                    }

                }
                if ((c4.checkTie()) && (restart == false)) {
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
                        playerChars.clear();
                        i = players;
                    }
                }
            }

        }
    }
}
