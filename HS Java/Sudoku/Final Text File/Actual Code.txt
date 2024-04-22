package Sudoku;

import java.util.Scanner;
import java.util.*;


public class Sudoku {
    private int[][] actualBoard;
    private int row;
    private int col;
    private int lives = 5;

    private int[][] hardCodedEasy = {{1, 2, 3, 6, 7, 8, 9, 4, 5},
                                    {5, 8, 4, 2, 3, 9, 7, 6, 1},
                                    {9, 6, 7, 1, 4, 5, 3, 2, 8},
                                    {3, 7, 2, 4, 6, 1, 5, 8, 9},
                                    {6, 9, 1, 5, 8, 3, 2, 7, 4},
                                    {4, 5, 8, 7, 9, 2, 6, 1, 3},
                                    {8, 3, 6, 9, 2, 4, 1, 5, 7},
                                    {2, 1, 9, 8, 5, 7, 4, 3, 6},
                                    {7, 4, 5, 3, 1, 6, 8, 9, 2}};

    private int[][] hardCodedMedium = {{7, 5, 9, 1, 8, 2, 4, 6, 3},
                                        {8, 1, 6, 3, 4, 7, 5, 2, 9},
                                        {2, 3, 4, 5, 6, 9, 7, 1, 8},
                                        {9, 6, 7, 2, 5, 8, 3, 4, 1},
                                        {1, 4, 8, 7, 3, 6, 2, 9, 5},
                                        {3, 2, 5, 9, 1, 4, 6, 8, 7},
                                        {5, 8, 2, 6, 7, 1, 9, 3, 4},
                                        {4, 9, 3, 8, 2, 5, 1, 7, 6},
                                        {6, 7, 1, 4, 9, 3, 8, 5, 2}};

    private int[][] hardCodedHard = {{3, 8, 7, 4, 9, 1, 6, 2, 5},
                                    {2, 4, 1, 5, 6, 8, 3, 7, 9},
                                    {5, 6, 9, 3, 2, 7, 4, 1, 8},
                                    {7, 5, 8, 6, 1, 9, 2, 3, 4},
                                    {1, 2, 3, 7, 8, 4, 5, 9, 6},
                                    {4, 9, 6, 2, 5, 3, 1, 8, 7},
                                    {9, 3, 4, 1, 7, 6, 8, 5, 2},
                                    {6, 7, 5, 8, 3, 2, 9, 4, 1},
                                    {8, 1, 2, 9, 4, 5, 7, 6, 3}};

    private boolean[][] checkBoard = {{false, false, false, false, false, false, false, false, false},
                                        {false, false, false, false, false, false, false, false, false},
                                        {false, false, false, false, false, false, false, false, false},
                                        {false, false, false, false, false, false, false, false, false},
                                        {false, false, false, false, false, false, false, false, false},
                                        {false, false, false, false, false, false, false, false, false},
                                        {false, false, false, false, false, false, false, false, false},
                                        {false, false, false, false, false, false, false, false, false},
                                        {false, false, false, false, false, false, false, false, false}};

    Scanner input = new Scanner(System.in);

    public void PlayGame(){
        System.out.println("Welcome to the sudoku game!");
        System.out.println("You have 5 lives.");
        System.out.println("If you guess a number incorrectly, you lose a life!");
        SetUpBoard();


    }

    private void SetUpBoard() {
        
        System.out.print("What difficult would you like (Easy, Medium, Hard): ");
        String difficulty = input.nextLine();
        if(difficulty.equals("Easy")){
             for(int i = 0; i < 36;){
                int row = (int)(Math.random() * 8) + 1;
                int col = (int)(Math.random() * 8) + 1;
                if(checkBoard[row][col] == false){
                    checkBoard[row][col] = true;
                    i++;
                } 
            }
            actualBoard = hardCodedEasy;
        }
        else if(difficulty.equals("Medium")){
            for(int i = 0; i < 27;){
                int row = (int)(Math.random() * 8) + 1;
                int col = (int)(Math.random() * 8) + 1;
                if(checkBoard[row][col] == false){
                    checkBoard[row][col] = true;
                    i++;
                } 
            }
            actualBoard = hardCodedMedium;
        }   
        else if(difficulty.equals("Hard")){
            for(int i = 0; i < 18;){
                int row = (int)(Math.random() * 8) + 1;
                int col = (int)(Math.random() * 8) + 1;
                if(checkBoard[row][col] == false){
                    checkBoard[row][col] = true;
                    i++;
                } 
            }
            actualBoard = hardCodedHard;
        }
        else{
            System.out.println("Invalid entry! ");
            SetUpBoard();
        }
        DisplayBoard();
    } 

    private void DisplayBoard(){
        System.out.println();
        System.out.println("Lives: " + lives);
        System.out.println();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                System.out.print(" ");
                if(j == 0){
                    System.out.print(" ");
                }
                if(checkBoard[i][j] == false){
                    System.out.print(" ");
                }
                else{
                    System.out.print(actualBoard[i][j]);
                }
                if(j == 2 || j == 5){
                    System.out.print(" / ");
                }
                else{
                    System.out.print(" | ");
                }
            }
            System.out.println(" Row: " + (i + 1));
            if(i == 2 || i == 5){

                System.out.println("****|****|****/****|****|****/****|****|****|");

            }
            else{

                System.out.println("----|----|----/----|----|----/----|----|----|");

            }
        }
        System.out.println("Col1 Col2 Col3 Col4 Col5 Col6 Col7 Col8 Col9");
        userInput();        
    }

    public void userInput(){
        if(CheckWin() == false){
            System.out.println();
            System.out.println("What row would you like to put your number into? ");
            String nextInput = input.nextLine();
            try{
                row = Integer.valueOf(nextInput) - 1;
            }
            catch(NumberFormatException e){
                System.out.println("Invalid input! ");
                userInput();
            } 
            System.out.println("What column would you like to put your number into? ");
            nextInput = input.nextLine();
            try{
                col = Integer.valueOf(nextInput) - 1;
            }
            catch(NumberFormatException e){
                System.out.println("Invalid input! ");
                userInput();
            }
            if(row > 8 || col > 8){
                System.out.println("Invalid entry! ");
                userInput();
            }
            System.out.println("What number would you like to put into box " + (row + 1) + ", " + (col + 1));
            nextInput = input.nextLine();
            try{
                int userInput = Integer.valueOf(nextInput);
                if(userInput > 9){
                    System.out.println("Invalid input! ");
                    userInput();
                }
                CheckInput(row, col, userInput);
                DisplayBoard();
            }
            catch(NumberFormatException e){
                System.out.println("Invalid input! ");
                userInput();
            }   
        }
        else{
            System.exit(0);
        }
    }

    public void CheckInput(int row, int col, int userInput){
        if(userInput == actualBoard[row][col]){
            System.out.println();
            System.out.println("Correct! ");
            checkBoard[row][col] = true;
        }
        else{
            System.out.println();
            System.out.println("Wrong input! ");
            lives--;
        }
    }

    public boolean CheckWin(){
        if(lives == 0){
            System.out.println("You lost all your lives and failed Sudoku!");
            return true;
        }
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(checkBoard[i][j] == false){
                    return false;
                }
            }
        }
        System.out.println("Congragulations! You solved this Sudoku puzzle! ");
        return true;
    }

}
