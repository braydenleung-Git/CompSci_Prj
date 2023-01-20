import java.util.*;
//This class is the main file. It contains the information on how the game will actually run
//Brayden and Hanna collaborated on this class. They both added seperate peices of code, and edited and changed
//different parts of the code.

public class Game
{
  //creates the game grid
  static Grid grid = new Grid();

  //Main run method
  public static void main(String[] args)
  {
    grid.print();
   // while(true)
    {
      //playerMove(player1);
    }
  }

 // grid[4-1][5-1] = 'a';
  
  public void playerMove(Player player)
  {
    //int yada = readInt("\nWhich column would you like to fill? ");
    
    //grid[][yada - 1] = '';
  }

public void processMove(Player player)
{
    
}
  /**
  * This method yada yada
  * @param 
  * @ return
  */
  public static int readInt(String question) {
    Scanner myObj = new Scanner(System.in);
    System.out.println(question);
    String input = myObj.nextLine();
    if(input.equals(""))
    {
      return 0;
    }
    else
    {
      return Integer.parseInt(input);
    }
  }

  /**
  * This method yada yada
  * @param 
  * @ return
  */
  public static void ui_Line(String input){
    for(int x =0; x< input.length();x++);  {
      System.out.print("=");
    }
    System.out.println();
  }
  
  /**
  * This method yada yada
  * @param
  * @return 
  */
  public static void checkWin()
  {
    
  }
}