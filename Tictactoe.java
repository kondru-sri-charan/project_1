
import java.util.Scanner;
class Tictactoe 
{
    public static void main(String[] args){
        char[][] board = new char[3][3];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                board[i][j]=' ';
            }
        }
        char player = 'X';
        boolean gameOver = false;
        int turns =0;

        Scanner sc = new Scanner(System.in);
        while(!gameOver){
            printBoard(board);
            System.out.println("Player "+player+" enter:");
            int row = sc.nextInt() -1;
            int column = sc.nextInt() -1;
            if(row<0 || row>=3 || column<0 || column>=3){
                System.out.println("Invalid move, Try again!");
            }
            else if(board[row][column]==' '){
                board[row][column]=player;
                turns++;
                gameOver = haveWon(board,player);
                if(gameOver){
                    System.out.println("Player :"+player+" has won!");
                }
                else if(turns==9){
                    System.out.println("It's a draw!");
                    gameOver = true;
                }
                else{
                    player = (player == 'X') ? 'O' : 'X'; // Switch player
                }
            }
            else
            {
                System.out.println("Invalid move, Try again!");
            }
        }
        printBoard(board);
        sc.close();

    }
    public static boolean haveWon(char[][] board,char player){
        //check the rows 
        for(int i=0;i<board.length;i++){
        if(board[i][0]==player && board[i][1]==player && board[i][2]==player){
            return true;
        }}
        //check the columns
        for(int j=0;j<board[0].length;j++){
        if(board[0][j]==player && board[1][j]==player && board[2][j]==player){
            return true;
        }
        } 
        //check the diagonals
        if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
            return true;
        } 
        if(board[0][2]==player && board[1][1]==player && board[2][0]==player){
            return true;
        } 
        return false;
    }
    public static void printBoard(char[][] board){
        System.out.println("-------------");
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                System.out.print(board[i][j]+" | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
}