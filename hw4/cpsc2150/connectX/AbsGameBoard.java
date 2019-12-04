package cpsc2150.connectX;

public abstract class AbsGameBoard implements IGameBoard {
    /**
     * returns a well-formatted string of the gameboard
     * @pre - must have a gameBoard object made
     * @post - returns well formatted string of the current game board
     * @return - string of current gameboard
     */
    public String toString(){
        String board = "|";
        //spacing for double digits
        if(getNumColumns() > 9){
            board += " ";
        }
        //filling in top row values
        for(int i = 0; i < getNumColumns(); i++){
            board += i;
            board += "|";
            if((getNumColumns() > 9) && (i < 9)){
                board += " ";
            }
        }
        board += "\n";

        int i = 0;
        int j = 0;

        //fill in gameBoard values
        for(i = 0; i < getNumRows(); i++){
            for(j = 0; j < getNumColumns(); j++) {
                board += ("|");
                if (whatsAtPos(i, j) == '\u0000'){
                    board += " ";
                }
                board += whatsAtPos(i, j);

                if(getNumColumns() > 9){
                    board += " ";
                }

                if (j == (getNumColumns() - 1)) {
                    board += "|";
                }
            }
            board += "\n";
        }

        return board;
    }

}



