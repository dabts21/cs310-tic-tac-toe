package edu.jsu.mcis;

import java.util.Scanner;

public class TicTacToeView {
    
    private final Scanner keyboard;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView() {
        
        /* Initialize scanner (for console keyboard) */
        
        keyboard = new Scanner(System.in);
        
    }
	
    public TicTacToeMove getNextMove(boolean isXTurn) {
        
        /* Prompt the player to enter the row and the column of their next move.
           Return as a TicTacToeMove object. */

           if(isXTurn){
               System.out.println("Player 1 (X) Move: ");
               System.out.print("Enter the row and column numbers, seperated by a space: ");
               
           }
            else{
                System.out.println("Player 2 (O) Move: ");
                System.out.print("Enter the row and column numbers, seperated by a space: ");
            }
            String input = keyboard.nextLine();
            String[] parts = input.split(" ");

            int row = -1;
            int col = -1;

            try{
                row = Integer.parseInt(parts[0]);
                col = Integer.parseInt(parts[1]);
            }
            catch(Exception e){

            }
            return new TicTacToeMove(row, col);
            


        // INSERT YOUR CODE HERE


    }

    public void showInputError() {

        System.out.println("Entered location is invalid, already marked, or out of bounds.");

    }

    public void showResult(String r) {

        System.out.println(r + "!");

    }
    
    public void showBoard(String board) {
        
        System.out.println("\n\n" + board);
        
    }
	
}
