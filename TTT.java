import java.util.*; 
class TTT extends Game{
   
   
   //attributes
   String board[][]; 
   String symbol = "O";
   
   
   //constructor
   TTT(){
      board = initializeBoard();
      instructions();
   }
   
   
   //instructions
   public void instructions(){
      System.out.println("Get three of the same symbols in a row! Don't put your symbol in a box that's already taken!");
   }
   
   
   //gets
   //String getSymbol(){
     // return(symbol);
   //}
   
   public String reportWinner(){
      if (isWinner() == true){
         return("Congratulations " + symbol +", you won!");
         }
      else{
         return("Sorry, no one won.");
         }
         }
   
   
   //take turn
   public void takeTurn(){
      togglePlayer();
      Scanner input = new Scanner(System.in);
      int row = 0;
      int col = 0; 
      do { 
         System.out.println("What row do you want [1-3]? ");
         row = input.nextInt()-1; 
         System.out.println("What column do you want? [1-3]");
         col = input.nextInt()-1; 
         System.out.println(row + " " + col); 
      } while( ! validInput(row, col));  
      board[row][col] = symbol; 
   }
   
   
   //valid input
   private boolean validInput(int r, int c){
      if(r<0 || r > 2 || c< 0 || c>2){
         System.out.println("no such row or col: pick rows/ cols between 1 and 3"); 
         return(false); 
      }
      else if (!board[r][c].equals(" ")){
         System.out.println("space aready taken"); 
         return(false); }
      return(true); 
   }
   
   
    //initialize board
   private String [][] initializeBoard(){
      String [][] b = {{" "," "," "},{" "," "," "},{" "," "," "}}; 
   //       String [][] b = {{" "," "," "},{" ","X"," "},{" "," ","X"}}; 
   //      String [][] b = {{" ","X","O"},{"O","O","X"},{"X","O","X"}}; 
   
      return (b); 
   }


   //toggle the player
   private void togglePlayer(){
      if(symbol.equals("O"))
         symbol = "X";
      else
         symbol = "O";
      System.out.println("Ok, " + symbol + ", it's your turn\n");  
   }
   
   
   boolean isFull(){
      for(int r = 0;r<3;r++)
         for(int c = 0; c<3;c++)
            if(board[r][c].equals(" "))
               return(false);
      
      return(true);          
   
   }
   
   public void printBoard(){
   //int r =0;
   //int c =0; 
      for(int r=0;r<3;r++){
         for(int c=0;c<3;c++){
            if(board[r][c] == null)
               System.out.print(" ");
            else
               System.out.print(board[r][c]);
            if(c<2)
               System.out.print("|");  
         }
         if(r<2)
            System.out.println("\n-+-+-");      
         else
            System.out.println(); 
      }
         
   }
   
   boolean isWinner(){
      // win by row: 
      for(int r=0;r<3;r++)
         if(!board[r][0].equals(" ") && board[r][0].equals(board[r][1]) && board[r][0].equals(board[r][2]))
            return(true);
      
            // win by column
      for (int c =0;c<3;c++)
         if(!board[0][c].equals(" ") && board[0][c].equals(board[1][c]) && board[0][c].equals(board[2][c]))
            return(true);  
       
      if (!board[1][1].equals(" ")){ // try diagonal      
         if (board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]))
            return(true);
         
         else if (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]))
            return (true);
      } 
      return (false); 
   }// iswinner
  
     
     public boolean status(){
      if (isFull() == true || isWinner() == true){
               return(true);
      }
      return(false);          
   }
   
   
}// class