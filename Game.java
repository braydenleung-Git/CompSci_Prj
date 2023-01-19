import java.util.*;

//This class is the main file. It contains the information on how the game will actually run
//Brayden and Hanna collaborated on this class. They both added seperate peices of code, and edited and changed
//different parts of the code.

public class Game
{
  //creates the game grid
  static Grid grid = new Grid();
  
  public static void main(String[] args)
  {
    grid.print();
    //System.out.println("");
    int player1 = readInt("\nWhich column would you like to fill? ");
    
    
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