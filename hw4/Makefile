default: cpsc2150/connectX/GameBoard.java cpsc2150/connectX/Connect4Game.java cpsc2150/connectX/IGameBoard.java cpsc2150/connectX/GameBoardMem.java cpsc2150/connectX/AbsGameBoard.java
	javac cpsc2150/connectX/GameBoard.java cpsc2150/connectX/Connect4Game.java cpsc2150/connectX/IGameBoard.java cpsc2150/connectX/GameBoardMem.java cpsc2150/connectX/AbsGameBoard.java

run: cpsc2150/connectX/GameBoard.class cpsc2150/connectX/Connect4Game.class cpsc2150/connectX/IGameBoard.class cpsc2150/connectX/GameBoardMem.class cpsc2150/connectX/AbsGameBoard.java
	java cpsc2150/connectX.Connect4Game

test: cpsc2150/connectX/TestGameBoard.java cpsc2150/connectX/TestGameBoardMem.java cpsc2150/connectX/GameBoard.java cpsc2150/connectX/Connect4Game.java cpsc2150/connectX/IGameBoard.java cpsc2150/connectX/GameBoardMem.java cpsc2150/connectX/AbsGameBoard.java
	javac -cp .:/usr/share/java/junit4.jar cpsc2150/connectX/TestGameBoard.java cpsc2150/connectX/TestGameBoardMem.java cpsc2150/connectX/GameBoard.java cpsc2150/connectX/Connect4Game.java cpsc2150/connectX/IGameBoard.java cpsc2150/connectX/GameBoardMem.java cpsc2150/connectX/AbsGameBoard.java

testGB: cpsc2150/connectX/TestGameBoard.class cpsc2150/connectX/GameBoard.class cpsc2150/connectX/Connect4Game.class cpsc2150/connectX/IGameBoard.class cpsc2150/connectX/GameBoardMem.class cpsc2150/connectX/AbsGameBoard.java
	java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore cpsc2150.connectX.TestGameBoard

testGBMem: cpsc2150/connectX/TestGameBoardMem.class cpsc2150/connectX/GameBoard.class cpsc2150/connectX/Connect4Game.class cpsc2150/connectX/IGameBoard.class cpsc2150/connectX/GameBoardMem.class cpsc2150/connectX/AbsGameBoard.java
	java -cp .:/usr/share/java/junit4.jar org.junit.runner.JUnitCore cpsc2150.connectX.TestGameBoardMem

clean:
	rm -f *.class


