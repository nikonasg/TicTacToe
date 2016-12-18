import java.util.Scanner;

public class TicTacToe {
    //Initiates game
    public static void main(String[] args) { 
        printIntro();
        Scanner scan = new Scanner(System.in);
        String player1 = getName(scan, true);
        String player2 = getName(scan, false);
        TicTacToeBoard board = new TicTacToeBoard(3);
        play(scan, player1, player2, board);
    }

    //Prints the intro to the game
    static void printIntro() {
        System.out.println("Welcome to Tic Tac Toe!");
    }

    //Obtains the name of the player from the Scanner. If isPlayerOne is true 
    //then the player your asking for the name is player one. Otherwise 
    //it is player two
    static String getName(Scanner scan, boolean isPlayerOne) {
        System.out.println("Enter your name player " + (isPlayerOne ? "1": "2"));
        String name = scan.nextLine();
        return name;
    }

    //Repeatedly asks the players for their moves. If someone gets a tic tac toe, finish the game
    static void play(Scanner scan, String player1, String player2, TicTacToeBoard board) {
        board.printBoard();
        boolean gameOver = false;
        //Need to store info about which players turn it is
        //That info is going to correspond to 'X' and 'O'
        boolean isPlayerOne = true;
        int turn = 0;
        while(!gameOver && turn < board.rows * board.rows){
            System.out.println((isPlayerOne ? player1: player2) + ", it is your turn!");
            int row = getMove(scan, true, board);
            int col = getMove(scan, false, board);
            char character = board.getCharacter(row - 1,  col - 1);
            while(character != ' '){
                System.out.println("hey you," + (isPlayerOne ? player1: player2)+", that space is already takened. ask again or the diabetes will set in. P.S. suns like hepititas");
                row = getMove(scan, true, board);
                col = getMove(scan, false, board);
                character = board.getCharacter(row - 1, col - 1);
            }
            boolean win = board.makeMove(row - 1, col - 1, (isPlayerOne ? 'X': 'O'));
            board.printBoard();
            gameOver = false;
            isPlayerOne = (!isPlayerOne);
            if(win == true){
                isPlayerOne = (!isPlayerOne);
                System.out.println("You have won player " + (isPlayerOne ? player1: player2) + "!");
                gameOver = true;
                
            }
            turn ++;
            
        }
        if (!gameOver && turn < board.rows * board.rows + 1){
            System.out.println("It's a tie player " + player1 + " and player " + player2 +"!");
        }
        
    }
    
    //If askForRow is true ask for the row, ask for the column otherwise
    static int getMove(Scanner scan, boolean askForRow, TicTacToeBoard board){
        System.out.println("Enter the " + (askForRow ? "row": "column"));
        int move = scan.nextInt();
        scan.nextLine();
        while(move < 0 || move > board.rows){
            System.out.println("Dat numero is outa the bounds. ask again or the diabetes will set in. P.S. suns like hepititas");
            System.out.println("Enter the " + (askForRow ? "row": "column"));
            move = scan.nextInt();
            scan.nextLine();
        }
        return move;
    }


}
