package cpsc2150.connectX;

import javax.print.DocFlavor;
import java.nio.CharBuffer;
import java.util.*;

/**
 * GameBoardMem class with functions pertaining to ConnectX
 * @author Spalding Latham 3/15/2019
 * @invariant - 3 < rows < 25
 * @invariant - 3 < columns < 25
 * @invariant - numToWin > 3
 */
public class GameBoardMem extends AbsGameBoard implements IGameBoard{

    Map<Integer, List<Character>> gameMap = new HashMap<>();
    int rows = 0;
    int columns = 0;
    int num = 0;

    /**
     * Constructor - initializes rows, columns, and num
     * @param rows - user inputted number of rows
     * @param columns - user inputted number of columns
     * @param num - user inputted number in a row to win
     */
    GameBoardMem(int rows, int columns, int num){
        this.rows = rows;
        this.columns = columns;
        this.num = num;

    }

    /**
     * Getter function for rows
     * @return - returns rows
     * @pre - 3 <= rows <= 25
     * @post - this.rows = rows
     */
    public int getNumRows(){
        return(this.rows);
    }

    /**
     * Getter function for columns
     * @return - returns columns
     * @pre - 3 <= columns <= 25
     * @post - this.columns = columns
     */
    public int getNumColumns(){
        return(this.columns);
    }

    /**
     * Getter function for number to win
     * @return - returns number to win
     * @pre - num >= 3
     * @post - this.num = num
     */
    public int getNumToWin(){
        return(this.num);
    }


    /**
     * places a token p in column c on the game board. The token
     * will be placed in the lowest available row in column c. Cannot be called if column c is full.
     *
     * @param p - character to place
     * @param c - column the user wants to place it in
     * @pre - checkIfFree(c) == true
     * @post -  p will be the placed in the lowest free spot in column c
     */
    public void placeToken(char p, int c) {

        //check if null
        if(gameMap.get(c) == null){
            //if null create a new list to add to value
            List<Character> temp = new ArrayList<>();
            temp.add(p);
            gameMap.put(c, temp);
        } else {
            //if not null just add to list
            gameMap.get(c).add(p);
        }
    }


    /**
     * returns the char that is in row r and column c of the game
     * board. If there is no token at the spot it should return a blank space character “ “
     *
     * @param r - row to check
     * @param c - column to check
     * @return - returns the token in pos r, c
     * @pre - 3 <= r,c <= 100
     * @post - returns what token is at that position
     */
    public char whatsAtPos(int r, int c){
        //start token at null character
        char token = '\u0000';
        if(gameMap.get(c) != null) {
            //use (rows - 1 - r) because first element in list is at bottom of board
            if((rows - 1 - r) < gameMap.get(c).size()) {
                int place = (rows - 1) - r;
                token = gameMap.get(c).get(place);
            }
        }
        return(token);
    }




}
