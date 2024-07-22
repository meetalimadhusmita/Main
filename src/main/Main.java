import java.util.*;
class Main {
  public static void main(String[] args) {
    char[][] board = new char[3][3];
    for(int row = 0; row<board.length;row++){
      for(int col=0; col<board[row].length;col++){
        board[row][col]=' '; //Insert spaces initially because board is empty before the game starts
      }
    } 
    char player = 'X'; //Let's assume it begins w/ player X
    boolean gameOver = false; // gameOver will be true when all 9 bricks will be filled
    Scanner scanner = new Scanner(System.in);

    while(!gameOver){
        printBoard(board);
        System.out.println("Player " + player + ", enter: ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        if(board[row][col] == ' '){
            board[row][col] = player; // X/O
            gameOver = haveWon(board, player);
            if(gameOver){
              System.out.println("Player " + player + " has won!");
            }
            else{
              player = player=='X'?'O' : 'X'; //Switch players
            }
          }
        else{
          System.out.println("Invalid move. Try again!");
      }
    }
  }

  public static boolean haveWon(char[][] board, char player){
    //CHECKING FOR ROWS
    for(int row = 0; row < board.length; row++){
      if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
        return true;
      }
    }
    //CHECKING FOR COLUMNS
    for(int col = 0; col < board.length; col++){
      if(board[0][col] == player && board[1][col] == player && board[2][col] == player){
        return true;
      }
    }

    //CHECKING FOR DIAGONALS
    if(board[0][0] == player && board[1][1] == player && board[2][2]==player){
        return true;
    }
    if(board[0][2] == player && board[1][1] == player && board[2][0]==player){
      return true;
    }
    return false;
  }

   public static void printBoard(char[][] board){
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        System.out.print(board[row][col] + " | ");
      }
        System.out.println();
    }
  }
}