//CercaTrova
import java.util.*;

public class practice{
    public static Scanner input=new Scanner(System.in);
    public static char[][] board=new char[3][3];
    public static int x=0,y=0;
    public static char turn='X';
    public static void main(String []args){
        boolean play=true;
        int move=0;
        while (play){
            move++;
            showBoard(board);
            getRow();
            getColumn();
            //Prevent Same input
            while(board[x][y]=='X' || board[x][y]=='O'){
                System.out.println("Occupied");
                getRow();
                getColumn();
            }
            board[x][y]=turn;
            //Check for win
            if (checkWin()){
                play=false;
                System.out.println("Gameover! Player " + turn + " wins!");
            }
            //Swap turn
            if (turn=='X'){
                turn='O';
            }else{
                turn='X';
            }
            //Check for draw
            if (move>=9){
                System.out.println("Draw");
                break;
            }
        }

    }
    public static void showBoard(char[][]x){
        for (int row=0;row<x.length;row++){
            for(int column=0;column<x[row].length;column++){
                System.out.print(board[row][column]+" | ");
            }
            System.out.println("\n----------");
        }

    }
    public static void getRow(){
        System.out.print("Enter row for "+turn+": ");
        x=input.nextInt()-1;
    }
    public static void getColumn(){
        System.out.print("Enter column for "+turn+": ");
        y=input.nextInt()-1;
    }
    public static boolean checkWin(){
        //check diagonal
        if(board[0][0]==turn && board[0][1]==turn && board[0][2]==turn)
            return true;
        if(board[1][0] == turn && board[1][1] == turn && board[1][2]==turn)
            return true;
        if(board[2][0] == turn && board[2][1] == turn && board[2][2]==turn)
            return true;
        //check vertical
        if(board[0][0]==turn && board[1][0]==turn && board[2][0]==turn)
            return true;
        if(board[0][1] == turn && board[1][1] == turn && board[2][1]==turn)
            return true;
        if(board[0][2] == turn && board[1][2] == turn && board[2][2]==turn)
            return true;
        //check diagnal
        if(board[0][0] == turn && board[1][1] == turn && board[2][2]==turn)
            return true;
        if (board[0][2]==turn && board[1][1]==turn && board[2][0]==turn)
            return true;
        return false;

    }

}