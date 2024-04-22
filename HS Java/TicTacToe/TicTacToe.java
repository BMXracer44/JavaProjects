package TicTacToe;
import java.util.Scanner;

public class TicTacToe{
    private char[][] board;
//when turn is 0, player x is playing
//when turn is 1, player o is playing
    private int turn = 0;
    private int row;
    private int col;

    public TicTacToe(){
        turn = 0;
    }
  
    Scanner input = new Scanner(System.in);
  //set up the board, let players take turns, after every turn, check for a winner or tie
  //Once there is a winner or the board is filled, the game should end. 

  public void PlayGame(){
    SetUpBoard();
    DisplayBoard();

    while(true){
        System.out.print("What row would you like to put your piece? (0-2): ");
        row = input.nextInt();

        System.out.print("What column would you like to put your piece? (0-2): ");
        col = input.nextInt();
        if(PlacePiece(row, col)){
            if(CheckWinner(row, col) != ' '){
                if(CheckWinner(row, col) == 'T'){
                    System.out.println("You tied!");
                }
                if(CheckWinner(row, col) == 'X'){
                    System.out.println("First player won!");
                }
                if(CheckWinner(row, col) == 'O'){
                    System.out.println("Second player won!");
                }
                return;
            }
            DisplayBoard();
        }
    }
    
  }
  
  
  
    /*Description: Initializes the board variable to have "empty spaces"
      using the space character in a 3x3 grid.
    */
    private void SetUpBoard(){
        this.board = new char[][]{
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
    }

    /*Description: place an X or an O if the grid is still empty at that location 
     * Precondition: 2D array has been initialized, player submits a row number from 0 to 2 and a column number
     * from 0 to 2 
     * Postcondition: True is returned if the space was available, and the board is updated. False if the space was 
     * not available, and the board is unchanged. If a piece is placed, 
    */
    



    private boolean PlacePiece(int row, int col){
        boolean available = true;

        if(board[row][col] != ' '){
            available = false;
        }
        if(turn == 0 && available == true){
            board[row][col] = 'X';
            turn = 1;
        }
        else if(turn == 1 && available == true){
            board[row][col] = 'O';
            turn = 0;
        }

        return available;
    }

    private char CheckWinner(int row, int col){
        if(CheckVertical(row, col) != ' '){
            return CheckVertical(row, col);
        }
        if(CheckHorizontal(row, col) != ' '){
            return CheckHorizontal(row, col);
        }
        if(CheckUpRightDiagonal(row, col) != ' '){
            return CheckUpRightDiagonal(row, col);
        }
        if(CheckDownRightDiagonal(row, col) != ' '){
            return CheckDownRightDiagonal(row, col);
        }
        boolean filled = true;
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(board[r][c] == ' '){
                    filled = false;
                }
            }
        }
        if(filled){
            return 't';
        }
        return ' ';
    }

    //in the column place, check all 3 spaces to see if they match for whoevers turn it was
    //Return the character of the winner, X or O, if there is one, otherwise return a " "
    private char CheckVertical(int row, int col){
        char charToMatch = board[row][col];

        for(int r = 0; r < board.length - 1; r++){
            if(board[r][col] != charToMatch){
                return ' ';
            }
        }

        return charToMatch;
    }

    private char CheckHorizontal(int row, int col){
        char charToMatch = board[row][col];

        for(int c = 0; c < board[0].length - 1; c++){
            if(board[row][c] != charToMatch){
                return ' ';
            }
        }

        return charToMatch;
    }

    //using the ROW and COLUMN of a placed piece, check down-left and up-right until we either 
    //reach the end of the board, or we run into a piece that doesn't match the placed one. Then, if 
    //count is 3 (or greater, I guess) return that character. If count is less than 3, return ' '.
    private char CheckUpRightDiagonal(int row, int col){
        int count = 1; 
        char charToMatch = board[row][col];

        int currentRow = row;
        int currentCol = col;

        while((currentRow + 1 < board.length && currentCol - 1 >= 0) && board[currentRow + 1][currentCol - 1] == charToMatch){
            currentRow++;
            currentCol--;
            count++;
        }

        currentRow = row;
        currentCol = col;
        
        //While loop checks for three things, first is that I am not already on the bottom row
        //Second is that we are not already on the farthest left column
        //Third is that the next character matches the start piece
        //If all those things work out, then we should increase our counter and check the NEXT spot

        while((currentRow - 1 >= 0 && currentCol + 1 < board[0].length) && board[currentRow - 1][currentCol + 1] == charToMatch){
            currentRow--;
            currentCol++;
            count++;
        }

        //check if count is greater than or equal to 3, if so, turn player is winner
        //otherwise, there is no winner this turn
        //return either the charToMatch or ' '
        if(count >= 3){
            return charToMatch;
        }
        else{
            return ' ';
        }
    }

    private char CheckDownRightDiagonal(int row, int col){
        int count = 1; 
        char charToMatch = board[row][col];

        int currentRow = row;
        int currentCol = col;

        while((currentRow - 1 >= 0 && currentCol - 1 >= 0) && board[currentRow - 1][currentCol - 1] == charToMatch){
            currentRow--;
            currentCol--;
            count++;
        }

        currentRow = row;
        currentCol = col;
        
        //While loop checks for three things, first is that I am not already on the top row
        //Second is that we are not already on the farthest left column
        //Third is that the next character matches the start piece
        //If all those things work out, then we should increase our counter and check the NEXT spot

        while((currentRow + 1 < board.length && currentCol + 1 < board[0].length) && board[currentRow + 1][currentCol + 1] == charToMatch){
            currentRow++;
            currentCol++;
            count++;
        }

        //check if count is greater than or equal to 3, if so, turn player is winner
        //otherwise, there is no winner this turn
        //return either the charToMatch or ' '
        if(count >= 3){
            return charToMatch;
        }
        else{
            return ' ';
        }
    }

    private void DisplayBoard(){
        System.out.println(" " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("   |   |   ");
        System.out.println("---|---|---");
        System.out.println("   |   |   ");
        System.out.println(" " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("   |   |   ");
        System.out.println("---|---|---");
        System.out.println("   |   |   ");
        System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
        System.out.println("   |   |   ");
    }
}
