import java.util.*; 
class Sudoku extends Game{
   
   
   //attributes
   static final int R=9;
   static final int C=9; 
   int board[][];
   
   
   //constructor
   Sudoku(){
      board = initializeBoard();
      instructions();
   }

   //get
      public String reportWinner(){
      if (isWinner() == true){
         return("Congratulations you won!");
         }
      else{
         return("Sorry, you did not win.");
         }
         }
   
   
   
   
   public void instructions(){
      System.out.println("Welcome to a game of Sudoku!\nYou must get the numbers 1-9 in every row and column without any repeats\nGOOD LUCK!");
   }
      
      
   public void takeTurn(){
   // gets the row and column number from player, 
   // until player picks a legal and free cell (validateInput)
   // if so, places number on board
      Scanner sc = new Scanner(System.in); 
      int row=-1, col = -1, guess = -1; 
      do{
         System.out.println("Enter the number you want to put on the board");
         guess = sc.nextInt(); 
         System.out.println("Enter the row [1-9]");
         row = sc.nextInt()-1;
         System.out.println("Enter the column [1-9]");
         col= sc.nextInt()-1;
      }while(! validInput(row,col,guess));
      board[row][col] = guess; 
   }
  
   
   //checks for valid input
   private boolean validInput(int r, int c, int g){
      if ( r < 2 && r>=0 && c<2 && c>=0 && g > 0 && g <=9 && board[r][c] == -1)
         return(true); 
      else{
         System.out.println("Invalid input; try again"); 
         return(false); 
      }
   }
   
   
   //initializing the board
   static int [][] initializeBoard(){
     // int [ ][ ] b = {{-1,2},{2,-1}};   
      /*int [] [] b = { { -1,-1,-1, 2,-1,-1, -1, 4,6},
         {5,6,2, -1,-1,-1, -1,8, -1},
         {7,-1,-1, -1,-1,-1, -1,5,-1},      
         {3,-1,-1, -1,-1,9, -1,6,1}, 
         {-1,7,-1, 3,-1,5, -1,2,-1}, 
         {1,9,-1, 4,-1,-1, -1,-1,3}, 
         {-1,4,-1, -1,-1,-1, -1,-1,2}, 
         {-1,5,-1, -1,-1,-1, 8,3,4}, 
         {8,1,-1, -1,-1,2, -1,-1,-1}}; 
   */
   
      int [] [] b= {{-1,-1,-1, -1,-1,-1, -1,-1,-1}, 
                     {-1,-1,-1, -1,-1,-1, -1,-1,-1}, 
                     {-1,-1,-1, -1,-1,-1, -1,-1,-1}, 
                     {-1,-1,-1, -1,-1,-1, -1,-1,-1}, 
                     {-1,-1,-1, -1,-1,-1, -1,-1,-1}, 
                     {-1,-1,-1, -1,-1,-1, -1,-1,-1}, 
                     {-1,-1,-1, -1,-1,-1, -1,-1,-1}, 
                     {-1,-1,-1, -1,-1,-1, -1,-1,-1}, 
                     {-1,-1,-1, -1,-1,-1, -1,-1,-1}};
         
         
         /*{-1,-1,1,2,5,7,3,4,6},
         {5,6,2,9,3,4,1,8,7},
         {7,3,4,1,6,8,2,5,9},     
         {3,2,5,8,7,9,4,6,1},
         {4,7,6,3,1,5,9,2,8},
         {1,9,8,4,2,6,5,7,3},
         {6,4,9,5,8,3,7,1,2},
         {2,5,7,6,9,1,8,3,4},
         {8,1,3,7,4,2,6,9,5}};*/
   //stub: returns an almost-finished board
      return (b); 
   }

   
   boolean isFull(){ 
      for(int r=0;r<R;r++){
         for(int c = 0;c<C;c++){
            if(board[r][c] == -1)
               return(false); 
         }
      }
      return(true);          
   }
 
 

   public void printBoard(){       
      for(int r=0;r<R;r++){
         System.out.print("|");
         for(int c = 0;c<C;c++){         
            if(board[r][c] == -1)
               System.out.print(" ");
            else
               System.out.print(board[r][c]);
            if(c%3==2)
               System.out.print("|");
         
         }
         if(r%3==2)
            System.out.print("\n|===+===+===|");
         System.out.println(); 
      }
   }
   
   boolean isWinnerBackUp(){
      int [] [] bSoln= { { 9,8,1, 2,5,7, 3, 4,6},
         {5,6,2,9,3,4,1,8,7},
         {7,3,4,1,6,8,2,5,9},     
         {3,2,5,8,7,9,4,6,1},
         {4,7,6,3,1,5,9,2,8},
         {1,9,8,4,2,6,5,7,3},
         {6,4,9,5,8,3,7,1,2},
         {2,5,7,6,9,1,8,3,4},
         {8,1,3,7,4,2,6,9,5}};
      for(int r=0;r<R;r++){
         for(int c = 0;c<C;c++){
            if(board[r][c] != bSoln[r][c])
               return(false);
         }
      }
      return(true);          
   }
   
   
   
   boolean isWinner(){
   
      for(int r=0;r<R;r++){
      // ok by rows
         boolean [] check = new boolean [9];
         for(int c = 0;c<C;c++){
            check[ board[r][c]-1] = true;  
         }
         if( !allNumbersThere(check))
            return(false); 
      }
      
      
      // ok columns
      for(int c=0;c<C;c++){
      // ok by columns
         boolean [] check = new boolean [9];
         for(int r = 0;r<R;r++){
            check[ board[r][c]-1] = true;  
         }
         if( !allNumbersThere(check))
            return(false); 
      }
   
      // ok 3x3 block
      int blockSize = 9; 
      for(int rowCorner =0;rowCorner < blockSize; rowCorner+=3){
         for(int colCorner =0;colCorner < blockSize; colCorner+=3){ 
            if(!checkThisBlock(rowCorner, colCorner))
               return(false); 
         }
      }
   
      return(true);          
   }// iswinner
   
   
   
   boolean checkThisBlock(int rCrn, int cCrn){
      boolean [] check = new boolean [9];
         // check over the countXcount block cornered by count, count
      for(int r=rCrn;r<rCrn + 3;r++){
            //for(cocount =0;colCount<3; colCount ++)
         for(int c =cCrn ;c<cCrn + 3;c++){
            check[ board[r][c]-1] = true;  
         }
      }
      if( !allNumbersThere(check))
         return(false); 
   
      return(true); 
   } 
   
   
   
   boolean allNumbersThere(boolean [] c){
   
      for(int i=0;i<c.length;i++)
         if(c[i] == false)
            return(false); 
      
      return(true); 
   }
 
 
     public boolean status(){
      if (isFull() == true){
         return(true);
      }
      return(false);          
   }
   
  
}