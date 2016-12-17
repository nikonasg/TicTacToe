/**
 * A class to simulate a Tic Tac Toe board
 * @author Tim Gianitsos tim.gianitsos@utexas.edu
 * @version 1.0
 */
public class TicTacToeBoard {
	
	private static final int squareSize = 2;
	private final int rows;
	private char[][] board;

	/**
	 * Creates a TicTacToeBoard with the specified number of rows/columns
	 * @param rows the number of rows to make the board (since boards have 
	 * the same number of rows and columns, the number of columns is also 
	 * equal to the parameter)
	 */
	public TicTacToeBoard(int rows) {
		this.rows = rows;

		if (squareSize % 2 == 1) {
			board = new char[squareSize * rows][squareSize * rows + rows];
			for (int r = 0; r < board.length - 1; r++) {
				for (int c = 0; c < board[r].length - 1; c++) {
					if ((c + 1) % (squareSize + 1) != 0) {
						if ((r + 1) % squareSize != 0)
							board[r][c] = ' ';
						else
							board[r][c] = '_';
					}
					else
						board[r][c] = '|';
				}
				board[r][board[r].length - 1] = '\n';
			}
			//solves the fence-post problem
			for (int c = 0; c < board[board.length - 1].length - 1; c++) {
				if ((c + 1) % (squareSize + 1) != 0)
					board[board.length - 1][c] = ' ';
				else
					board[board.length - 1][c] = '|';
			}
			board[board.length - 1][board[board.length - 1].length - 1] = '\n';
		}
		else { //SQUARE_SIZE % 2 == 0 
			board = new char[squareSize * rows][(squareSize + 1) * rows + rows];
			for (int r = 0; r < board.length - 1; r++) {
				for (int c = 0; c < board[r].length - 1; c++) {
					if ((c + 1) % (squareSize + 2) != 0) {
						if ((r + 1) % squareSize != 0)
							board[r][c] = ' ';
						else
							board[r][c] = '_';
					}
					else
						board[r][c] = '|';
				}
				board[r][board[r].length - 1] = '\n';
			}
			//solves the fence-post problem
			for (int c = 0; c < board[board.length - 1].length - 1; c++) {
				if ((c + 1) % (squareSize + 2) != 0)
					board[board.length - 1][c] = ' ';
				else
					board[board.length - 1][c] = '|';
			}
			board[board.length - 1][board[board.length - 1].length - 1] = '\n';
		}
	}

	/**
	 * Prints a character representation of this TicTacToeBoard
	 */
	public void printBoard() {
		for (char[] r: board) {
			System.out.print(r);
		}
		System.out.println();
	}

	/**
	 * Puts the character at the specificed row and column
	 * @param row the row to put the value into
	 * @param column the column to put the value into
	 * @param c the character to put at the specified row and column
	 */
	public void makeMove(int row, int column, char c) {
		if (board.length % 2 == 1) {
			board[row * squareSize + (squareSize - 1) / 2]
					[column * (squareSize + 1) + (squareSize - 1) / 2] = c;
		}
		else {
			board[row * squareSize + squareSize / 2 - 1]
					[column * (squareSize + 2) + squareSize / 2] = c;
		}
	}

	/**
	 * Gets the character at the specificed row and column
	 * @param row the row to get the value from
	 * @param column the column to get the value from
	 * @return the character at the specified row and column
	 */
	public char getCharacter(int row, int column) {
		if (board.length % 2 == 1) {
			return board[row * squareSize + (squareSize - 1) / 2]
					[column * (squareSize + 1) + (squareSize - 1) / 2];
		}
		else {
			return board[row * squareSize + squareSize / 2 - 1]
					[column * (squareSize + 2) + squareSize / 2];
		}
	}
}
