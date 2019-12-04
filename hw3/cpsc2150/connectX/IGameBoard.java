package cpsc2150.connectX;

/**
 * @description Main interface that provides functions for the gameBoard class
 * @author Spalding Latham
 *
 * Defines: IGameBoard interface
 * Constraints: 3 < rows,columns < 25, 3 < numToWin
 * Initialization Ensures: GameBoard functions
 */

public interface IGameBoard {

    /**
     * Getter function for rows
     * @pre - 3 <= rows <= 25
     * @return - returns rows
     */
    public int getNumRows();

    /**
     * Getter function for columns
     * @pre - 3 <= columns <= 25
     * @return - returns columns
     */
    public int getNumColumns();

    /**
     * Getter function for number to win
     * @pre - number >= 3
     * @return - returns number to win
     */
    public int getNumToWin();

    /**
     * returns true if column c is not full, false if it is
     * @param c - column to check if free
     * @pre - c must be a valid column (0-6)
     * @post - if c is a valid column returns true, otherwise false
     * @return - returns true or false
     */
    default boolean checkIfFree(int c){
        boolean flag = false;
        for(int i = 0; i < getNumRows(); i++){
            //if there is a null character then column is open
            if((whatsAtPos(i, c) == '\u0000') || (whatsAtPos(i, c) == ' ')) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     *  returns true if the last token placed (which was placed in column
     * c) resulted in the player getting their specified number in a row horizontally, diagonally, or vertically.
     * Otherwise, it returns false
     * @param c - column of last move
     * @pre - 3 <= c <= 100
     * @post - Will return true if the game was won and false if not
     * @return - returns true or false based on last move
     */
    default boolean checkForWin(int c){
        int r = 0;
        char p;
        for(int i = 0; i < getNumRows(); i++){
            //find the last null character in the column
            if(whatsAtPos(i, c) != '\u0000'){
                r++;
            }
        }
        //the row of the last move
        r = getNumRows() - r;
        p = whatsAtPos(r, c);

        //check for win horizontally          diagonally                      vertically
        if(checkHorizWin(r, c, p) == true || checkDiagWin(r, c, p) == true || checkVertWin(r, c, p) == true){
            return true;
        } else {
            return false;
        }
    }

    /**
     *  places a token p in column c on the game board. The token
     * will be placed in the lowest available row in column c. Cannot be called if column c is full.
     * @param p - character to place
     * @param c - column the user wants to place it in
     * @pre - checkIfFree(c) == true
     * @post -  p will be the placed in the lowest free spot in column c
     */
    public void placeToken(char p, int c);

    /**
     *  returns true if the last token placed
     * (which was placed in row r, column c and player p) resulted in the player getting 4 in a row horizontally.
     * Otherwise, it returns false.
     * @param r - row token is in
     * @param c - column token is in
     * @param p - what token it is
     * @pre - r, c, and p are all valid inputs
     * @post - returns if the game was or was not won horizontally
     * @return - returns true or false if there are 4 of the same token in a row horizontally
     */
    default boolean checkHorizWin(int r, int c, char p){
        int counter = 0;
        boolean horizWin = false;
        for(int i = 0; i < getNumColumns() - (getNumToWin() - 1); i++){
            for(int j = i; j < (i + getNumToWin()); j++){
                if(whatsAtPos(r, j) == p){
                    counter++;
                    //if there are num elements in a row return true
                    if(counter == getNumToWin()){
                        horizWin = true;
                    }
                }
            }
            counter = 0;
        }

        return(horizWin);
    }

    /**
     *  returns true if the last token placed
     * (which was placed in row r, column c and player p) resulted in the player getting 4 in a row vertically.
     * Otherwise, it returns false.
     * @param r - row token is in
     * @param c - column token is in
     * @param p - what token it is
     * @pre - r, c, and p are all valid inputs
     * @post - returns if the game was or was not won vertically
     * @return - returns true or false if there are 4 of the same token in a row vertically
     */
    default boolean checkVertWin(int r, int c, char p){
        int counter = 0;
        boolean vertWin = false;
        for(int i = 0; i < getNumRows() - (getNumToWin() - 1); i++){
            for(int j = i; j < (i + getNumToWin()); j++){
                if(whatsAtPos(j, c) == p){
                    counter++;
                    //if four in a row vertically return true
                    if(counter == getNumToWin()){
                        vertWin = true;
                    }
                }
            }
            counter = 0;
        }

        return(vertWin);
    }

    /**
     *  returns true if the last token placed
     * (which was placed in row r, column c and player p) resulted in the player getting 4 in a row diagonally.
     * Otherwise, it returns false.
     * @param r - row token is in
     * @param c - column token is in
     * @param p - what token it is
     * @pre - r, c, and p are all valid inputs
     * @post - returns if the game was or was not won diagonally
     * @return - returns true or false if there are 4 of the same token in a row diagonally
     */
    default boolean checkDiagWin(int r, int c, char p){
        //counter for the aboveLeft and belowRight
        int diagLeft = 0;
        //counter for the aboveRight and belowLeft
        int diagRight = 0;
        //booleans that change based on if the last check was true or not
        boolean lastWasTrue1 = true;
        boolean lastWasTrue2 = true;
        boolean lastWasTrue3 = true;
        boolean lastWasTrue4 = true;
        boolean diagWin = false;

        for(int i = 0; i < (getNumToWin() - 1); i++){

            //check above and to left
            if(lastWasTrue1 == true) {
                if ((r - (i + 1)) >= 0 && (c - (i + 1)) >= 0) {
                    if (whatsAtPos((r - (i + 1)), (c - (i + 1))) == p) {
                        diagLeft++;
                    } else {
                        lastWasTrue1 = false;
                    }
                }
            } else {
                lastWasTrue1 = false;
            }
            //check below and to the left
            if(lastWasTrue2 == true) {
                if ((r + (i + 1)) < getNumRows() && (c - (i + 1)) >= 0) {
                    if (whatsAtPos((r + (i + 1)),(c - (i + 1))) == p) {
                        diagRight++;
                    } else {
                        lastWasTrue2 = false;
                    }
                } else {
                    lastWasTrue2 = false;
                }
            }
            //check below and to the right
            if(lastWasTrue3 == true) {
                if ((r + (i + 1)) < getNumRows() && (c + (i + 1)) < getNumColumns()) {
                    if (whatsAtPos((r + (i + 1)), (c + (i + 1))) == p) {
                        diagLeft++;
                    } else {
                        lastWasTrue3 = false;
                    }
                }
            } else {
                lastWasTrue3 = false;
            }

            //check above and to right
            if(lastWasTrue4 == true) {
                if ((r - (i + 1)) >= 0 && (c + (i + 1)) < getNumColumns()) {
                    if (whatsAtPos((r - (i + 1)),(c + (i + 1))) == p) {
                        diagRight++;
                    } else {
                        lastWasTrue4 = false;
                    }
                }
            } else {
                lastWasTrue4 = false;
            }
            if((diagRight == (getNumToWin() - 1)) || (diagLeft == (getNumToWin() - 1))){
                diagWin = true;
            }
        }

        return diagWin;
    }

    /**
     *  returns the char that is in row r and column c of the game
     * board. If there is no token at the spot it should return a blank space character “ “
     * @param r - row to check
     * @param c - column to check
     * @pre - r and c must be valid row/column
     * @post - returns what token is at that position
     * @return - returns O, X, or " " based on whats at the position
     */
    char whatsAtPos(int r, int c);



    /**
     *  returns true if the game board results in a tie game, otherwise it returns
     * false.
     * @pre - no previous play has resulted in a win
     * @post - checkTie == true iff [there are no available spaces left on the board]
     * @return - returns true if tie, false if not
     */
    default boolean checkTie(){
        boolean flag = true;
        for(int i = 0; i < getNumRows(); i++){
            for(int j = 0; j < getNumColumns(); j++){
                //if there is a null character game is not over and return false
                if(whatsAtPos(i, j) == '\u0000'){
                    flag = false;
                }
            }
        }

        return flag;
    }


}
