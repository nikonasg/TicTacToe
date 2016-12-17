/**
 * A class to simulate a Tic Tac Toe board
 * @author Tim Gianitsos tim.gianitsos@utexas.edu
 * @version 1.0
 */
public class TicTacToeBoard {
    
    private static final int squareSize = 2;
    public final int rows;
    private char[][] board;

    /**
     * Tests that TicTacToeBoard is functioning correctly
     * @param args arguments from the command line (unused)
     */
    public static void main(String[] args) {
        System.out.println("Board test");
        TicTacToeBoard b = new TicTacToeBoard(3);
        b.printBoard();
        System.out.println(b.makeMove(0, 0, 'X'));
        b.printBoard();
        System.out.println(b.makeMove(1, 1, 'X'));
        b.printBoard();
        System.out.println(b.makeMove(2, 2, 'X'));
        b.printBoard();
        System.out.println("character at 1,1: \"" + b.getCharacter(1,1) + "\"");
        
    }

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
     * Puts the character at the specified row and column
     * @param row the row to put the value into
     * @param column the column to put the value into
     * @param c the character to put at the specified row and column
     * @return true if placing the character was a winning move by filling a row, column or diagonal
     */
    public boolean makeMove(int row, int column, char c) {
        if (board.length % 2 == 1) {
            board[row * squareSize + (squareSize - 1) / 2]
                    [column * (squareSize + 1) + (squareSize - 1) / 2] = c;
        }
        else {
            board[row * squareSize + squareSize / 2 - 1]
                    [column * (squareSize + 2) + squareSize / 2] = c;
        }

        //Check row
        boolean win = true;
        for (int searchRow = row, searchCol = 0; searchCol < rows && win; searchCol++) {
            if (getCharacter(searchRow, searchCol) != c) {
                win = false;
            }
        }
        if (win) {
            return true;
        }
        win = true;

        //Check column
        for (int searchRow = 0, searchCol = column; searchRow < rows && win; searchRow++) {
            if (getCharacter(searchRow, searchCol) != c) {
                win = false;
            }
        }
        if (win) {
            return true;
        }
        win = true;

        //Check downward diagonal
        for (int searchRow = 0, searchCol = 0; searchRow < rows && searchCol < rows && win; searchRow++, searchCol++) {
            if (getCharacter(searchRow, searchCol) != c) {
                win = false;
            }
        }
        if (win) {
            return true;
        }
        win = true;

        //Check upward diagonal
        for (int searchRow = rows - 1, searchCol = 0; searchRow >= 0 && searchCol < rows && win; searchRow--, searchCol++) {
            if (getCharacter(searchRow, searchCol) != c) {
                win = false;
            }
        }
        return win;
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
