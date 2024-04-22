package ConnectFour;
import java.util.Scanner;

public class ConnectFour {
    private char[][] grid;
//when turn is 0, player R is playing
//when turn is 1, player Y is playing
    private int turn = 0;
    private int row;
    private int col;
    
    public ConnectFour(){
        turn = 0;
    }
      
        Scanner input = new Scanner(System.in);
      //Set up the grid, let players take turns, after every turn, check for a winner
      //Once there is a winner or the grid is filled, the game should end. 
    
      public void PlayGame(){
        SetUpGrid();
        DisplayGrid();
      

        while(true){
            System.out.print("What column would you like to put your piece? (0-6): ");
            col = input.nextInt();
            row = SelectRow(col);
            if(PlacePiece(row, col)){
                if(CheckWinner(row, col) != ' '){
                    if(CheckWinner(row, col) == 'R'){
                        DisplayGrid();
                        System.out.println("First player won!");
                    }
                    if(CheckWinner(row, col) == 'Y'){
                        DisplayGrid();
                        System.out.println("Second player won!");
                    }
                    return;
                }
                DisplayGrid();
            }
        }
        
      }
      
      
      
        /*Description: Initializes the board variable to have "empty spaces"
          using the space character in a 6x7 grid.
        */
        private void SetUpGrid(){
            this.grid = new char[][]{
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            };
        }
    
        /*Description: place an R or a Y if the grid is still empty at that location 
         * Precondition: 2D array has been initialized, player submits a column number
         * from 0 to 6 
         * Postcondition: True is returned if the space was available, and the board is updated. False if the space was 
         * not available, and the board is unchanged. 
        */
        
        private int SelectRow(int col){
            for(int r = grid.length - 1; r >= 0; r--){
                if(grid[r][col] == ' '){
                    return r;
                }
            }
            return -1;
        }
    
    
        private boolean PlacePiece(int row, int col){
            boolean available = true;
            
            while(available == false){
                for(int i = 0; i < 6; i++){
                    col = i;
                    if(grid[row][col] == ' '){
                        available = true;
                    }
                    else{
                        available = false;
                    }
                    
                }
            }
            
            if(turn == 0 && available == true){
                grid[row][col] = 'R';
                turn = 1;
            }
            else if(turn == 1 && available == true){
                grid[row][col] = 'Y';
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
            for(int r = 0; r < grid.length; r++){
                for(int c = 0; c < grid[0].length; c++){
                    if(grid[r][c] != ' '){
                        filled = false;
                    }
                }
            }
            if(filled){
                return 't';
            }
            
            return ' ';
        }
    
        //in the column place, check all 7 spaces to see if they match for whoevers turn it was
        //Return the character of the winner, R or Y, if there is one, otherwise return a " "
        private char CheckVertical(int row, int col){
            int count = 1; 
            char charToMatch = grid[row][col];
    
            int currentRow = row;
            int currentCol = col;
    
            while(currentRow + 1 < grid.length && grid[currentRow + 1][currentCol] == charToMatch){
                currentRow++;
                count++;
            }
    
            currentRow = row;
            currentCol = col;
            
            //While loop checks for three things, first is that I am not already on the bottom row
            //Second is that we are not already on the farthest left column
            //Third is that the next character matches the start piece
            //If all those things work out, then we should increase our counter and check the NEXT spot
    
            while(currentRow - 1 >= 0 && grid[currentRow - 1][currentCol] == charToMatch){
                currentRow--;
                count++;
            }
    
            //check if count is greater than or equal to 3, if so, turn player is winner
            //otherwise, there is no winner this turn
            //return either the charToMatch or ' '
            if(count >= 4){
                return charToMatch;
            }
            else{
                return ' ';
            }
        }
    
        private char CheckHorizontal(int row, int col){
            int count = 1; 
            char charToMatch = grid[row][col];
    
            int currentRow = row;
            int currentCol = col;
    
            while(currentCol + 1 < grid[0].length && grid[currentRow][currentCol + 1] == charToMatch){
                currentCol++;
                count++;
            }
    
            currentRow = row;
            currentCol = col;
            
            //While loop checks for three things, first is that I am not already on the bottom row
            //Second is that we are not already on the farthest left column
            //Third is that the next character matches the start piece
            //If all those things work out, then we should increase our counter and check the NEXT spot
    
            while(currentCol - 1 >= 0 && grid[currentRow][currentCol - 1] == charToMatch){
                currentCol--;
                count++;
            }
    
            //check if count is greater than or equal to 3, if so, turn player is winner
            //otherwise, there is no winner this turn
            //return either the charToMatch or ' '
            if(count >= 4){
                return charToMatch;
            }
            else{
                return ' ';
            }
        }
    
        //using the ROW and COLUMN of a placed piece, check down-left and up-right until we either 
        //reach the end of the board, or we run into a piece that doesn't match the placed one. Then, if 
        //count is 3 (or greater, I guess) return that character. If count is less than 3, return ' '.
        private char CheckUpRightDiagonal(int row, int col){
            int count = 1; 
            char charToMatch = grid[row][col];
    
            int currentRow = row;
            int currentCol = col;
    
            while((currentRow + 1 < grid.length && currentCol - 1 >= 0) && grid[currentRow + 1][currentCol - 1] == charToMatch){
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
    
            while((currentRow - 1 >= 0 && currentCol + 1 < grid[0].length) && grid[currentRow - 1][currentCol + 1] == charToMatch){
                currentRow--;
                currentCol++;
                count++;
            }
    
            //check if count is greater than or equal to 3, if so, turn player is winner
            //otherwise, there is no winner this turn
            //return either the charToMatch or ' '
            if(count >= 4){
                return charToMatch;
            }
            else{
                return ' ';
            }
        }
    
        private char CheckDownRightDiagonal(int row, int col){
            int count = 1; 
            char charToMatch = grid[row][col];
    
            int currentRow = row;
            int currentCol = col;
    
            while((currentRow - 1 >= 0 && currentCol - 1 >= 0) && grid[currentRow - 1][currentCol - 1] == charToMatch){
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
    
            while((currentRow + 1 < grid.length && currentCol + 1 < grid[0].length) && grid[currentRow + 1][currentCol + 1] == charToMatch){
                currentRow++;
                currentCol++;
                count++;
            }
    
            //check if count is greater than or equal to 3, if so, turn player is winner
            //otherwise, there is no winner this turn
            //return either the charToMatch or ' '
            if(count >= 4){
                return charToMatch;
            }
            else{
                return ' ';
            }
        }
    
        private void DisplayGrid(){
            System.out.println(" " + grid[0][0] + " | " + grid[0][1] + " | " + grid[0][2] + " | " + grid[0][3] + " | " + grid[0][4] + " | " + grid[0][5] + " | " + grid[0][6]);
            System.out.println("---------------------------");
            System.out.println(" " + grid[1][0] + " | " + grid[1][1] + " | " + grid[1][2] + " | " + grid[1][3] + " | " + grid[1][4] + " | " + grid[1][5] + " | " + grid[1][6]);
            System.out.println("---------------------------");
            System.out.println(" " + grid[2][0] + " | " + grid[2][1] + " | " + grid[2][2] + " | " + grid[2][3] + " | " + grid[2][4] + " | " + grid[2][5] + " | " + grid[2][6]);
            System.out.println("---------------------------");
            System.out.println(" " + grid[3][0] + " | " + grid[3][1] + " | " + grid[3][2] + " | " + grid[3][3] + " | " + grid[3][4] + " | " + grid[3][5] + " | " + grid[3][6]);
            System.out.println("---------------------------");
            System.out.println(" " + grid[4][0] + " | " + grid[4][1] + " | " + grid[4][2] + " | " + grid[4][3] + " | " + grid[4][4] + " | " + grid[4][5] + " | " + grid[4][6]);
            System.out.println("---------------------------");
            System.out.println(" " + grid[5][0] + " | " + grid[5][1] + " | " + grid[5][2] + " | " + grid[5][3] + " | " + grid[5][4] + " | " + grid[5][5] + " | " + grid[5][6]);
            System.out.println("---------------------------");
        }
    }
