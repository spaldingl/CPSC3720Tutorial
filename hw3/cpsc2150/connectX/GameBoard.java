package cpsc2150.connectX;

/**
 * GameBoard class with functions pertaining to ConnectX
 * @author Spalding Latham 2/10/2019
 * @invariant - 3 < rows < 25
 * @invariant - 3 < columns < 25
 * @invariant - numToWin > 3
 */
public class GameBoard extends AbsGameBoard implements IGameBoard {

    private int rows = 0;
    private int columns = 0;
    private int num = 0;
    private char[][] gameBoard;


    /**
     * Getter function for rows
     *
     * @return - returns rows
     * @pre - 3 <= rows <= 25
     */
    public int getNumRows() {
        return (this.rows);
    }


    /**
     * Getter function for columns
     *
     * @return - returns columns
     * @pre - 3 <= columns <= 25
     */
    public int getNumColumns() {
        return (this.columns);
    }


    /**
     * Getter function for number to win
     *
     * @return - returns number to win
     * @pre - number >= 3
     */
    public int getNumToWin() {
        return (this.num);
    }

    /**
     * Constructor
     * @post - board is empty
     */
    GameBoard(int rows, int columns, int num) {
        this.rows = rows;
        this.columns = columns;
        this.num = num;
        gameBoard = new char[rows][columns];
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
        //variable for what row to place the token is
        int tokenPos = rows - 1;
        for (int i = 0; i < rows; i++) {
            if (gameBoard[i][c] != '\u0000') {
                tokenPos = i - 1;
                break;
            }
        }

        gameBoard[tokenPos][c] = p;
    }

    /**
     * returns the char that is in row r and column c of the game
     * board. If there is no token at the spot it should return a blank space character “ “
     *
     * @param r - row to check
     * @param c - column to check
     * @return - returns O, X, or " " based on whats at the position
     * @pre - 3 <= r,c <= 100
     * @post - returns what token is at that position
     */
    public char whatsAtPos(int r, int c) {
        return gameBoard[r][c];

    }

}