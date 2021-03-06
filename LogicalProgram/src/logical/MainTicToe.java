package logical;
import java.util.Scanner;
 class TicTacTOe {
    int _row=3;
  char _board[][]=new char[_row][_row]; 
  public void makeBoard(){
   for (int i = 0; i <_row; i++) {
    for (int j = 0; j < _row; j++) {
     _board[i][j]='o';
    }

   }
  }
  boolean isValid(int r,int c){
   return((r>=0&&r<_row)&&(c>=0&&c<_row));
  }
  boolean isFill(int r,int c){
   return(_board[r][c]!='o');
  }
  public boolean gamePlay(int r ,int c,int playerNo){
   if (!(isValid(r,c))) {
    System.out.println("Enter Correct index");
    return true ;
   }
   if (isFill(r,c)) {
    System.out.println("This index already fill");
    return true;
   }
   if (playerNo==1) {
    _board[r][c]='*';
   } else {
          _board[r][c]='+';
   }
   return false;
  }

  boolean horizontalAndVerticalMatch(char ch,int n){
   // for row and col math
        boolean flag=true;
    for (int i = 0; i < _row; i++) {
         flag=true;
       for (int j = 0; j < _row; j++) {
        System.out.println("i="+i+"j="+j);
        char ch1=(n==1)?_board[i][j]:_board[j][i];
             if (ch1!=ch) {
              System.out.println("y");
      flag=false;
      break;
     }
      } 
       if (flag) {
        return flag;
    }
    }
   return flag; 
  }
  boolean majorDiagonal(char ch){
   return((_board[0][0]==ch)&&(_board[1][1]==ch)&&(_board[2][2]==ch));
  }
  boolean minorDiagonal(char ch){
   return((_board[2][0]==ch)&&(_board[1][1]==ch)&&(_board[0][2]==ch));
  }
  public boolean isGameOver(int PlayerNo){
   char ch;
   if (PlayerNo==1) {
     ch='*';
   } else {
     ch='+';
   }
   return(horizontalAndVerticalMatch(ch,1)||horizontalAndVerticalMatch(ch,2)||majorDiagonal(ch)||minorDiagonal(ch));
  }
  public void display(){
   for (int i = 0; i <_row; i++) {
    for (int j = 0; j < _row; j++) {
     System.out.print("     "+_board[i][j]);
    }
    System.out.println("");
   }
  } 

  }




  public class MainTicToe extends TicTacTOe {
   public static void main(String[] args) {
   TicTacTOe obj=new TicTacTOe();
   obj.makeBoard();
   obj.display();
   int r,c;
   Scanner input=new Scanner(System.in);
   while(true){
    boolean flag=true;
    while(flag){
     System.out.println("Player 1");
     System.out.println("enter row");
     r=input.nextInt();
     System.out.println("enter col");
     c=input.nextInt();
     flag=obj.gamePlay(r,c,1);
    }
    if (obj.isGameOver(1)) {
     obj.display();
     System.out.println("Player 1 Win Game");   
     break;
    }
    System.out.println("============");
    obj.display();
    flag=true;
    while(flag){
    System.out.println("Player 2");
    System.out.println("enter row");
    r=input.nextInt();
    System.out.println("enter col");
    c=input.nextInt();
    flag=obj.gamePlay(r,c,2);
    }
    if (obj.isGameOver(2)) {
     obj.display();
     System.out.println("Player 2 Win Game");   
     break;
    }
    System.out.println("============");
    obj.display();
   }
  }
  }