
import java.util.*; 

class Game_driver{


   public static void main(String argv[]){
      boolean gameOver = false;
      
      System.out.println("Would you like to play game 1 (Tic Tac Toe) or game 2 (Sudoku)? Enter 1 or 2");
      Scanner input = new Scanner(System.in); 
      String choice = input.next();
      Game g;
      if (choice.equals("1")){
         g = new TTT();
      }
      else{
         g = new Sudoku();
      }
    
      g.printBoard();
      g.instructions(); 
         
      while(!gameOver){ 
         g.takeTurn(); 
         gameOver = g.status(); 
         g.printBoard(); 
      
         
      }
      System.out.println(g.reportWinner());
   }// main
}
