package cpsc2150.connectX;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestGameBoard {

    private String expected(char[][] arr){
        String expected = "";
        for(int i = 0; i < arr[0].length; i++){
            expected += arr[i][i];
        }

        return expected;
    }

    private GameBoard MakeAGameboard(int rows, int columns, int num){

        GameBoard c4 = new GameBoard(rows, columns, num);
        return c4;
    }


    @Test
    public void checkConstructorRows(){
        IGameBoard c4 = MakeAGameboard(5, 5,5);
        assertTrue(c4.getNumRows() == 5);
    }

    @Test
    public void checkConstructorColumns(){
        IGameBoard c4 = MakeAGameboard(5, 5,5);
        assertTrue(c4.getNumColumns() == 5);
    }

    @Test
    public void checkConstructorNum(){
        IGameBoard c4 = MakeAGameboard(5, 5,5);
        assertTrue(c4.getNumToWin() == 5);
    }

    @Test
    public void checkIfFreeBlank(){
        IGameBoard c4 = MakeAGameboard(5, 5, 5);
        assertTrue(c4.checkIfFree(4));
    }

    @Test
    public void checkIfFreeFullFirstColumn(){
        IGameBoard c4 = MakeAGameboard(5, 5, 5);
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                c4.placeToken('X', j);
            }
        }

        assertFalse(c4.checkIfFree(0));
    }

    @Test
    public void checkIfFreeFullLastColumn(){
        IGameBoard c4 = MakeAGameboard(5, 5, 5);
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                c4.placeToken('X', j);
            }
        }

        assertFalse(c4.checkIfFree(4));
    }


    @Test
    public void checkHorizWinEmpty(){
        IGameBoard c4 = MakeAGameboard(5, 5, 5);
        assertFalse(c4.checkHorizWin(4, 4, 'X'));
    }

    @Test
    public void checkHorizWinTrue(){
        IGameBoard c4 = MakeAGameboard(4, 4, 3);
        for(int i = 0; i < 3; i++) {
            c4.placeToken('X', i);
        }
        assertTrue(c4.checkHorizWin(3, 0, 'X'));
    }

    @Test
    public void checkHorizWinFullFalse(){
        IGameBoard c4 = MakeAGameboard(4, 4, 4);
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(i % 2 == 0){
                    c4.placeToken('O', i);
                } else {
                    c4.placeToken('X', i);
                }
            }
        }
        assertFalse(c4.checkHorizWin(0, 0, 'X'));
    }

    @Test
    public void checkHorizWinFullTrue(){
        IGameBoard c4 = MakeAGameboard(4, 4, 4);
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if((i % 2 == 0) && (j < 3)){
                    c4.placeToken('O', i);
                } else {
                    c4.placeToken('X', i);
                }
            }
        }

        assertTrue(c4.checkHorizWin(0, 0, 'X'));
    }

    @Test
    public void checkHorizWinMiddleBlank(){
        IGameBoard c4 = MakeAGameboard(4, 4, 3);
        c4.placeToken('X', 0);
        c4.placeToken('X', 1);
        c4.placeToken('X', 3);
        assertFalse(c4.checkHorizWin(3, 0, 'X'));
    }


    @Test
    public void checkVertWinEmpty(){
        IGameBoard c4 = MakeAGameboard(4, 4, 4);
        assertFalse(c4.checkVertWin(3,0,'X'));
    }

    @Test
    public void checkVertWinFullFalse(){
        IGameBoard c4 = MakeAGameboard(4, 4, 4);
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(i % 2 == 0){
                    c4.placeToken('O', i);
                } else {
                    c4.placeToken('X', i);
                }
            }
        }
        assertFalse(c4.checkVertWin(0, 0, 'X'));
    }

    @Test
    public void checkVertWinFullTrue() {
        IGameBoard c4 = MakeAGameboard(4, 4, 4);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (j % 2 == 0) {
                    c4.placeToken('O', i);
                } else {
                    c4.placeToken('X', i);
                }
            }
        }
        for(int i = 0; i < 4; i++){
            c4.placeToken('X', 3);
        }

        assertTrue(c4.checkVertWin(3, 3, 'X'));

    }

    @Test
    public void checkVertWinTrue(){
        IGameBoard c4 = MakeAGameboard(4, 4, 3);
        for(int i = 0; i < 3; i++){
            c4.placeToken('X', 0);
            c4.placeToken('O', 1);
        }

        assertTrue(c4.checkVertWin(0, 0, 'X'));
    }

    @Test
    public void checkVertWinSpace(){
        IGameBoard c4 = MakeAGameboard(4, 4, 3);
        c4.placeToken('X', 0);
        c4.placeToken('X', 0);
        c4.placeToken('O', 0);
        c4.placeToken('X', 0);

        assertFalse(c4.checkVertWin(0, 0, 'X'));
    }

    @Test
    public void checkDiagWinEmpty(){
        IGameBoard c4 = MakeAGameboard(4, 4, 4);
        assertFalse(c4.checkDiagWin(0, 0, 'X'));
    }

    @Test
    public void checkDiagWinTrue(){
        IGameBoard c4 = MakeAGameboard(4, 4, 3);
        c4.placeToken('X', 0);
        c4.placeToken('X', 1);
        c4.placeToken('X', 1);
        c4.placeToken('X', 2);
        c4.placeToken('X', 2);
        c4.placeToken('X', 2);

        assertTrue(c4.checkDiagWin(3, 0, 'X'));
    }

    @Test
    public void checkDiagWinFullFalse(){
        IGameBoard c4 = MakeAGameboard(4, 4, 4);
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(i % 2 == 0){
                    c4.placeToken('O', i);
                } else {
                    c4.placeToken('X', i);
                }
            }
        }
        assertFalse(c4.checkDiagWin(0, 0, 'X'));
    }

    @Test
    public void checkDiagWinFullTrue(){
        IGameBoard c4 = MakeAGameboard(4, 4, 4);
        c4.placeToken('X', 0);
        c4.placeToken('X', 1);
        c4.placeToken('X', 1);
        c4.placeToken('X', 2);
        c4.placeToken('X', 2);
        c4.placeToken('X', 2);
        c4.placeToken('X', 3);
        c4.placeToken('X', 3);
        c4.placeToken('X', 3);
        c4.placeToken('X', 3);

        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (c4.checkIfFree(j)) {
                    c4.placeToken('O', j);
                    j--;
                }
            }
        }

        assertTrue(c4.checkDiagWin(3, 0, 'X'));
    }

    @Test
    public void checkDiagWinSpace(){
        IGameBoard c4 = MakeAGameboard(4, 4, 3);
        c4.placeToken('X', 0);
        c4.placeToken('X', 1);
        c4.placeToken('X', 1);

        c4.placeToken('X', 3);
        c4.placeToken('X', 3);
        c4.placeToken('X', 3);
        c4.placeToken('X', 3);

        assertFalse(c4.checkDiagWin(3, 0, 'X'));
    }

    @Test
    public void checkDiagWinReverse(){
        IGameBoard c4 = MakeAGameboard(4, 4, 4);
        c4.placeToken('X', 3);
        c4.placeToken('X', 2);
        c4.placeToken('X', 2);
        c4.placeToken('X', 1);
        c4.placeToken('X', 1);
        c4.placeToken('X', 1);
        c4.placeToken('X', 0);
        c4.placeToken('X', 0);
        c4.placeToken('X', 0);
        c4.placeToken('X', 0);

        assertTrue(c4.checkDiagWin(0, 0, 'X'));
    }

    @Test
    public void checkDiagWinBigBoard(){
        IGameBoard c4 = MakeAGameboard(25, 25, 25);
            for(int i = 0; i < 25; i++){
                for(int j = 0; j < 25; j++){
                    c4.placeToken('X', j);
                }
            }

            assertTrue(c4.checkDiagWin(0, 0, 'X'));
    }

    @Test
    public void checkDiagWinTallNarrowBoard(){
        IGameBoard c4 = MakeAGameboard(3, 100, 3);
        c4.placeToken('X', 0);
        c4.placeToken('X', 1);
        c4.placeToken('X', 1);
        c4.placeToken('X', 2);
        c4.placeToken('X', 2);
        c4.placeToken('X', 2);

        assertTrue(c4.checkDiagWin(3, 0, 'X'));
    }

    @Test
    public void checkTieEmpty(){
        IGameBoard c4 = MakeAGameboard(4, 4, 4);
        assertFalse(c4.checkTie());
    }

    @Test
    public void checkTieTrue(){
        IGameBoard c4 = MakeAGameboard(4, 4, 4);
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(i % 2 == 0){
                    c4.placeToken('O', i);
                } else {
                    c4.placeToken('X', i);
                }
            }
        }
        assertTrue(c4.checkTie());
    }

    @Test
    public void checkTieThreePlayers(){
        IGameBoard c4 = MakeAGameboard(3, 3, 3);

        c4.placeToken('X', 0);
        c4.placeToken('Y', 0);
        c4.placeToken('Z', 0);
        c4.placeToken('X', 2);
        c4.placeToken('Y', 2);
        c4.placeToken('Z', 2);
        c4.placeToken('Z', 1);
        c4.placeToken('Y', 1);
        c4.placeToken('X', 1);

        assertTrue(c4.checkTie());

    }

    @Test
    public void checkTieFalse(){
        IGameBoard c4 = MakeAGameboard(4, 4, 3);
        c4.placeToken('X', 0);
        c4.placeToken('X', 0);
        c4.placeToken('X', 0);

        assertFalse(c4.checkTie());
    }

    @Test
    public void whatsAtPosEmpty(){
        IGameBoard c4 = MakeAGameboard(4, 4, 4);
        char check = '\u0000';
        assertTrue(c4.whatsAtPos(3, 0) == check);
    }

    @Test
    public void whatsAtPos2(){
        IGameBoard c4 = MakeAGameboard(4, 4, 4);
        c4.placeToken('X', 0);
        assertTrue(c4.whatsAtPos(3, 0) == 'X');
    }

    @Test
    public void whatsAtPos3(){
        IGameBoard c4 = MakeAGameboard(4, 4, 4);
        c4.placeToken('X', 0);
        c4.placeToken('Y', 0);
        c4.placeToken('X', 0);
        c4.placeToken('Y', 0);

        assertTrue(c4.whatsAtPos(0, 0) == 'Y');

    }

    @Test
    public void whatsAtPos4(){
        IGameBoard c4 = MakeAGameboard(100, 100, 25);
        c4.placeToken('Q', 99);
        assertTrue(c4.whatsAtPos(99, 99) == 'Q');

    }

    @Test
    public void whatsAtPos5() {
        IGameBoard c4 = MakeAGameboard(100, 100, 25);
        for (int i = 0; i < 100; i++) {
            c4.placeToken('Q', i);
        }
        assertTrue(c4.whatsAtPos(99, 27) == 'Q');
    }

    @Test
    public void whatsAtPos6(){
        IGameBoard c4 = MakeAGameboard(4, 4, 4);
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(i % 2 == 0){
                    c4.placeToken('O', i);
                } else {
                    c4.placeToken('X', i);
                }
            }
        }

        assertTrue(c4.whatsAtPos(0, 3) == 'X');

    }

    @Test
    public void whatsAtPos7(){
        IGameBoard c4 = MakeAGameboard(4, 4, 4);
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                c4.placeToken('X', i);
            }
        }

        assertTrue(c4.whatsAtPos(2, 2) == 'X');

    }

    @Test
    public void placeToken1(){
        IGameBoard c4 = MakeAGameboard(4, 4, 4);
        c4.placeToken('X', 0);
        assertTrue(c4.whatsAtPos(3, 0) == 'X');
    }

    @Test
    public void placeToken2(){
        IGameBoard c4 = MakeAGameboard(4, 4, 4);
        c4.placeToken('X', 3);
        assertTrue(c4.whatsAtPos(3, 3) == 'X');

    }

    @Test
    public void placeToken3(){
        IGameBoard c4 = MakeAGameboard(4, 4, 4);
        for(int i = 0; i < 3; i++){
            c4.placeToken('X', 0);
        }
        c4.placeToken('Y', 0);
        assertTrue(c4.whatsAtPos(0, 0) == 'Y');

    }

    @Test
    public void placeToken4(){
        IGameBoard c4 = MakeAGameboard(4, 4, 4);
        c4.placeToken('X', 0);
        c4.placeToken('Y', 1);
        c4.placeToken('Z', 1);
        assertTrue(c4.whatsAtPos(2, 1) == 'Z');
    }

    @Test
    public void placeToken5(){
        IGameBoard c4 = MakeAGameboard(10, 10, 5);
            c4.placeToken('Y', 9);
            c4.placeToken('X', 9);
            c4.placeToken('Z', 9);

            assertTrue(c4.whatsAtPos(9, 9) == 'Y');
    }
}
