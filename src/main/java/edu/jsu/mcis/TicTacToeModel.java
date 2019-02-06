package edu.jsu.mcis;

public class TicTacToeModel {
    
    private Mark[][] board; /* Game board */
    private boolean xTurn;  /* True if X is current player */
    private int width;      /* Size of game board */
    
    /* ENUM TYPE DEFINITIONS */
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a TIE,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("TIE"), 
        NONE("NONE");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        this(TicTacToe.DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create board (width x width) as a 2D Mark array */
        
        board = new Mark[width][width];

        /* Initialize board by filling every square with empty marks */
        for(int i = 0; i<this.getWidth(); i++){
            
            for(int j = 0; j<this.getWidth(); j++){
                board[i][j]= Mark.EMPTY;
            }
        }

        // INSERT YOUR CODE HERE
        
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Use "isValidSquare()" to check if the specified location is in range,
           and use "isSquareMarked()" to see if the square is empty!  If the
           specified location is valid, make a mark for the current player, then
           toggle "xTurn" from true to false (or vice-versa) to switch to the
           other player before returning TRUE.  Otherwise, return FALSE. */
        
        // INSERT YOUR CODE HERE
         if(isValidSquare(row, col)){
			if(!isSquareMarked(row, col)){
				if(xTurn){
					board[row][col]= Mark.X;
                    xTurn = false;
				}else{
					board[row][col]= Mark.O;
                    xTurn = true;
				}
				return true;
			}

		}
        return false; // remove this line later!
        

        
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return TRUE if the specified location is within the bounds of the board */
        
        // INSERT YOUR CODE HERE
        if(row < width && col < width && row >= 0 && col >= 0){
			return true;
		}
        return false; 
        
        
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return TRUE if the square at specified location is marked */
        
        // INSERT YOUR CODE HERE
        if(board[row][col] == Mark.EMPTY ){
			return false;
		}
        return true; 
            
    }

	
    public Mark getMark(int row, int col) {
        
        /* Return the mark from the square at the specified location */
        return this.board[row][col];

        // INSERT YOUR CODE HERE

            
    }
	
    public Result getResult() {
        
        /* Call "isMarkWin()" to see if X or O is the winner, if the game is a
           TIE, or if the game is not over.  Return the corresponding Result
           value */
        
        // INSERT YOUR CODE HERE
        Mark currentMark = null;
		
		currentMark = Mark.X;
		if(isMarkWin(currentMark))
			return Result.X;
		
		currentMark = Mark.O;
		if(isMarkWin(currentMark))
			return Result.O;
		

		if(isTie())
			return Result.TIE;

        return Result.NONE; // remove this line later!
        
    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
    
        // INSERT YOUR CODE HERE
        boolean matchFound = false;
		//Check horizontal
		for(int row = 0; row < width; row++){

			for(int col = 0; col < width; col++){
				// might need toString it
				if(board[row][col] == mark){
					matchFound = true;
				}else{
					matchFound = false;
					break;
				}
			}
			if(matchFound)
				return true;
		}
		
		//Check Vertical
		for(int col = 0; col < width; col++){	
			for(int row = 0; row < width; row++){
				if(board[row][col] == mark){
					matchFound = true;
				}else{
					matchFound = false;
					break;
				}
			}

			if(matchFound)
				return true;
		}
		
		//Check Diag this way \
		for(int rowCol = 0; rowCol < width; rowCol++){
				if(board[rowCol][rowCol] == mark){
					matchFound = true;
				}else{
					matchFound = false;
					break;
				}
		}

		if(matchFound)
			return true;

		//Check Diag this way /
		for(int rowCol = 0; rowCol < width; rowCol++){
				int lastElement = width - 1;
				if(board[rowCol][lastElement - rowCol] == mark){
					matchFound = true;
				}else{
					matchFound = false;
					break;
				}
		}

        return matchFound; // remove this line later!

    }

	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */
        
        // INSERT YOUR CODE HERE
        for(int i = 0; i < width; i ++){
			for(int j= 0; j < width; j++){
				// might need toString it
				if(board[i][j] == Mark.EMPTY){
					return false;
					
				}	
			}	
		}

        return true; 
        
    }

    public boolean isGameover() {
        
        /* Return TRUE if the game is over */
        
        return (Result.NONE != getResult());
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
    @Override
    public String toString() {
        
        StringBuilder output = new StringBuilder("  ");
        
        /* Output the board contents as a string (see examples) */

        
        
        for (int i = 0; i < this.getWidth(); i++){
            //system.out.print(i);
            output.append(i);

        }

        output.append("\n");

        for(int i = 0 ; i < this.getWidth(); i++){
            output.append(i+" "); 

            for (int j = 0; j < this.getWidth(); j++){
            Mark aMark = this.getMark(i,j);
            output.append(aMark.toString());
            }
            output.append("\n");
        }
        // INSERT YOUR CODE HERE
        
        return output.toString();
        
    }
    
}
