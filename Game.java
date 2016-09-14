import java.util.*; 

abstract class Game{
   
   protected String name="Generic"; 

   abstract public void printBoard();
   
   abstract public void instructions();
   
   abstract public void takeTurn();
   
   abstract public boolean status();
   
   abstract public String reportWinner();
   
   
   

}