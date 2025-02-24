import java.util.Scanner;

public class ConnectFour {
    private static final int ROWS = 6;
    private static final int COLS = 7;
    private char[][] board;
    private char currentPlayer;

    // Constructor: Initializes the board and sets the starting player.
    public ConnectFour() {
        board = new char[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = ' ';
            }
        }
        currentPlayer = 'X';
    }

    // Displays the game board
    public void displayBoard() {
        // TODO: Implement this method

    	// prints out column numbers
    	System.out.println(" 0 1 2 3 4 5 6 ");
    	//prints out line with dashes
    	System.out.println("----------------");
    	
    	//for loop that prints out the column separator lines and board state
    	for(int h = 0; h < ROWS; h++) {
    		System.out.print("|"); //vertical separator
    		for(int j = 0; j < COLS; j ++) {
    			System.out.print(board[h][j] + "|"); // our updated line and vertical separator
    		}
        	System.out.println();
    	}
    	//prints out line with dashes
    	System.out.println("----------------");
    }

    // Handles player moves
    public boolean makeMove(int column) {
    	//*****LOOK INTO THIS
    	
    	//pieces need to drop to bottom
    	// check if column is full
    	// if column is less than 0
    	// or column is larger than columns
    	if(column < 0 || column > COLS) {
    		//returns false b/c that's not possible
    		return false;
    	}
    	// for loop to go through every row of the column
    	// i-- because it has to go from bottom (6th row) to top (0th row)
    	// normal connect 4 game- gravity brings piece to bottom
    	for(int i = ROWS - 1; i >= 0; i--) {
    		// if space is empty
    		if(board[i][column] == ' ') {
    			// our player marks their spot (X or O)
    			board[i][column] = currentPlayer;
    			return true;
    		}
    	}
    	
    	//this returns false if we go through the entire row
        return false;
    }

    // Checks if there is a winner
    public boolean checkWinner() {
        // TODO: Implement this method
    	// if winner return true
    	// check through
    	
    	for(int i = 0; i < ROWS; i ++) {
    		for(int j = 0; j < COLS; j ++) {
    			char current = board[i][j];
    			if(current != ' ') {
    				//checks horizontal win
    				//makes sure j + 3 is in range
    				if (j + 3 < COLS &&
    						current == board[i][j + 1] &&
    						current == board[i][j + 2] &&
    						current == board[i][j + 3]) {
    					return true;
    				}
    				//checks vertical win
    				// makes sure i + 3 is in range
    				
    				if (i + 3 < ROWS &&
    						current == board[i + 1][j] &&
    						current == board[i + 2][j] &&
    						current == board[i + 3][j] ) {
    					return true;
    				}
    				//diagonal check going up to left
    				// makes sure in range for i and j
    				if (i + 3 < ROWS && j + 3 < COLS &&
    						current == board[i + 1][j + 1] &&
    						current == board[i + 2][j + 2] &&
    						current == board[i + 3][j + 3]) {
    					return true;
    				}
    				
    				//diagonal check going down to right
    				if (i - 3 < ROWS && j + 3 >= 0 &&
    						current == board[i - 1][j + 1] &&
    						current == board[i - 2][j + 2] &&
    						current == board[i - 3][j + 3]) {
    					return true;
    				}
    			}

    		}
    	}
		return false; // because no winner was found in loop
		}
    		

    // Checks if the board is full
    public boolean isBoardFull() {
        // TODO: Implement this method
    	// check top row (for loop)
    	// goes through 0-6 in board
    	for(int j = 0; j < 6; j++)
	    	if(board[0][j] == ' ') {
	    		//if the space IS empty, it returns true
	    		return true;
	    	}
	    
    	// if we go through all of these and they are all taken, returns false
    	// this is because the board fills from top to bottom (gravity)
    	// so if the top is completely filled, then we know that the board is filled
        return false;
    }

    // Switches to the other player
    public char switchPlayer() {
        // TODO: Implement this method
    	if(currentPlayer == 'X') {
    		currentPlayer = 'O';
    	}
    	else {
    		currentPlayer = 'X';
    	}
    	
        return ' ';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConnectFour game = new ConnectFour();

        System.out.println("Welcome to Connect Four!");
        game.displayBoard();

        //TODO: Implement the game loop here
        //sets winCheck to false (not true until game is won)
        boolean winCheck = false;
        //sets boardFull to true (false when board is full)
        boolean boardFull = true;
        //while winCheck is false and boardFull is true, loop will run
        while(!winCheck && boardFull) {
        	//tells player who's turn it is
        	System.out.println("It is " + game.currentPlayer + "'s turn");
        	//asks them to enter where they want to place their piece
        	System.out.print("Enter the column to place your piece in: ");
        	//scans for integer
        	int column = scanner.nextInt();
        	//makes move with column integer above
        	game.makeMove(column);
        	//displays board afterwards
        	game.displayBoard();
        	
        	//checks our booleans that make the loop run
        	// will stop if either are swapped (if wincheck is true or boardfull is false)
        	winCheck = game.checkWinner();
        	boardFull = game.isBoardFull();
        	
        	//this switches our player before the next run of the loop
        	// the if statement is so that the output of the winning player is correct
        	if(!winCheck && boardFull) {
        		game.switchPlayer();
        	}
        }
        
        //if the board was full, prints out that it was a draw
        if(boardFull == false) {
        	System.out.println("Nobody wins. Draw.");
        }
        //if there was a winner, print out who the winner was
        else {
            System.out.println("Congrats! " + game.currentPlayer + " wins!");
        }
        
        //closes our scanner
        scanner.close();
    }
}
