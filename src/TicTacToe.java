import java.util.Scanner;

public class TicTacToe
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String gameBoard[] = new String[9];
        String activePlayer = "X";
        int playerMove = 0;
        int playerSpace = 0;
        int turnCounter = 0;
        boolean validMove = false;
        boolean gameOver = false;
        boolean playAgain = false;


        do
        {
            clearBoard(gameBoard);
            activePlayer = "X";
            turnCounter = 0;
            do
            {
                printBoard(gameBoard);
                do
                {
                    //playerMove is the user input, playerSpace is the array index.
                    playerMove = SafeInput.getRangedInt(input, "Player " + activePlayer + ", please enter the number of the space you would like to play", 1, 9);
                    playerSpace = playerMove - 1;
                    validMove = validMoveCheck(gameBoard, playerMove);
                }
                while (!validMove);

                gameBoard[playerSpace] = activePlayer;
                turnCounter++;

                if (turnCounter > 4)
                {
                    gameOver = gameEndings(gameBoard, activePlayer);
                }

                if(!gameOver)
                {
                    if (activePlayer.equals("X"))
                    {
                        activePlayer = "O";
                    }
                    else
                    {
                        activePlayer = "X";
                    }
                }
            }
            while (!gameOver);

            System.out.println("Player " + activePlayer + " has won!");
        }
        while (playAgain);
    }

    private static void clearBoard(String[] gameBoard)
    {
        for (int x = 0; x < gameBoard.length; x++)
        {
            int spaceNumber = x + 1;
            String spaceName = "" + spaceNumber;
            gameBoard[x]= spaceName;
        }
    }

    private static void printBoard(String[] gameBoard)
    {
        for (int x = 0; x < 3; x++)
        {
            int leftColumn = (x * 3);
            int middleColumn = (x * 3) + 1;
            int rightColumn = (x * 3) + 2;
            System.out.printf("%1s|%1s|%1s\n", gameBoard[leftColumn], gameBoard[middleColumn], gameBoard[rightColumn]);
            if(x < 2)
            {
                System.out.print("-+-+-\n");
            }
        }
    }
    private static boolean validMoveCheck(String[] gameBoard, int move)
    {
        boolean legalMove = false;
        String spaceName = "" + move;

        //playerMove, which is loaded to move, is the array address and not the user entry.
        if(spaceName.equals(gameBoard[move - 1]))
        {
            legalMove = true;
        }
        else
        {
            legalMove = false;

            //This converts the move back into the user entry when printing.
            System.out.println("Space " + (move) + " has already been claimed.");
        }
        return legalMove;
    }

    private static boolean gameEndings (String[] gameBoard, String player)
    {
        boolean gameEnded = false;


        for (int x = 0; x < 3; x++)
        {
            //Check horizontal win
            if (gameBoard[(x * 3)].equals(player) && gameBoard[(x * 3) + 1].equals(player) && gameBoard[(x * 3) + 2].equals(player))
            {
                gameEnded = true;
            }
            //Check vertical win
            else if(gameBoard[x].equals(player) && gameBoard[(x + 3)].equals(player) && gameBoard[(x + 6)].equals(player))
            {
                gameEnded = true;
            }
        }
        return gameEnded;
    }
}