import java.util.Scanner;

public class TicTacToe
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String activePlayer;


        boolean playAgain = true;
        String gameBoard[][] = new String[Row][Col];
        gameBoard = new String[3][3];

        do
        {
            clearBoard();
            activePlayer = "X";
            printBoard(gameBoard);
        }
        while(playAgain);
    }

    private static void clearBoard()
    {
        for (int row = 0; row < 3; row++)
        {
            for (int col = 0; col < 3; col++)
            {
                gameBoard[row][col] = " ";
            }
        }
    }

    private static void printBoard(String[][] gameBoard)
    {
        for (int row = 0; row < 3; row++)
        {
            System.out.printf("%1w|%1w|%1w", gameBoard[row][1], gameBoard[row][2], gameBoard[row][3]);
            System.out.print("\n-----");
        }
    }
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String gameBoard[][];
}