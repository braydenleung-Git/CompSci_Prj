import java.util.*;

//This class is the main file. It contains the information on how the game will actually run
//Hanna and Brayden collaborated on this class. They both added seperate peices of code, and edited and changed different parts of the code.

/*
    To Do list:
    - setup a working gui window with layout change
    - merge gui and the game
    - test game via gui
    - a play again option/Winner scene
 */

public class Game
{
  //creates the game grid
  static Grid grid = new Grid();

  //Main run method
  public static void main(String[] args)

  //public static void run_Game()
  {
    //shows some rules before the game begins
    UNI_CMD.flush(100);
    System.out.println("Welcome to Connect Four! \n \nRules of the game:");
    System.out.println("1) There are 7 columns. You will take turns dropping your circles down one by one. \n2) To win you must have four of your coins in a row. /n3) This can be done vertically, horizontally, or diagonally.");
    UNI_CMD.readLine("\nPress [Enter] to proceed");

    
    Player player1 = new Player(1, GUI.Player1_Name);
    Player player2 = new Player(2, GUI.Player2_Name);
    UNI_CMD.flush(100);
    grid.print();
    while(true)
    {
      playerMove(player1);
      if(checkWin(player1.getPlayer_ID()))
      {
        System.out.println("\nPLAYER 1 WINS!!!");
        break;
      }
      playerMove(player2);
      if(checkWin(player2.getPlayer_ID())) 
      {
        System.out.println("\nPLAYER 2 WINS!!!");
        break;
      }
    }
  }
  
  public static void playerMove(Player player)
  {
    int status = 0;
    //we created the loop so that if there is an error during validating player move, we can loop it to
    while(status == 0)
    {
      //UNI_CMD.flush(100);
      //grid.print();
      int input = UNI_CMD.readInt("\nPlayer: " + player.getPlayer_ID() + "\nWhich column would you like to fill? ");
      //This is used to break the loop
      status = grid.checkValidSpot(input, player.getPlayer_ID()); 
      UNI_CMD.flush(100);
      grid.print();
    }
  }

  
  /**
  * This method yada yada
  * @param
  * @return boolean value of whether there was a winner or not.
  */ 
  public static boolean checkWin(int player_ID)
  {
    if(checkHorizontal(player_ID) || checkVertical(player_ID) || checkDiagonal(player_ID))
    {
      return true;
    }
    return false;
  }

  //checks for a vertical win
  public static boolean checkVertical(int player_ID)
  {
    int count = 1;
    int initial_y = Grid.lastVertical;
    int y = initial_y;
    
    while (y < 5)
    {
      y++;
      int delta_y = y - initial_y;
      int content = Grid.returnValue(delta_y, 0);
      if (content == player_ID)
      {
        count++;
      }
      else 
      {
        break;
      }
    }
    if(count >= 4)
    {
      return true;
    }
    return false;
  }

  
  //checks horizontal win
  public static boolean checkHorizontal(int player_ID)
  { 
    int count = 1;
    int initial_x = Grid.lastHorizontal;
    int x = initial_x;
    
  
    while (x > 0)
    {
      x--;
      int delta_x = x - initial_x;
      int content = Grid.returnValue(0, delta_x);
      if (content == player_ID) 
      {
        count++;
      }
      else 
      {
        break;
      }
    }
    x = initial_x;
    while (x < 6)
    {
      x++;
      int delta_x = x - initial_x;
      int content = Grid.returnValue(0, delta_x);
      if (content == player_ID)
      {
        count++;
      }
      else 
      {
        break;
      }
    }
    if(count >= 4)
    {
      return true;
    }
    return false;
  }

  //checks diagonal win
  public static boolean checkDiagonal(int player_ID)
  {
    int count = 1;
    int initial_x = Grid.lastHorizontal;
    int inital_y = Grid.lastVertical;
    int x = initial_x;
    int y = inital_y;

    //top left, up
    while (x > 0 && y > 0)
    {
      x--;
      y--;
      int delta_x = x - initial_x;
      int delta_y = y - inital_y;
      int content = Grid.returnValue(delta_y, delta_x);
      if (content == player_ID)
      {
        count++;
      }
      else 
      {
        break;
      }
    }

    //bottom right, down
    x = initial_x;
    y = inital_y;
    while (x < 6 && y < 5)
    {
      x++;
      y++;
      int delta_x = x - initial_x;
      int delta_y = y - inital_y;
      int content = Grid.returnValue(delta_y, delta_x);
      if (content == player_ID)
      {
        count++;
      }
      else 
      {
        break;
      }
    }
    if(count >= 4)
    {
      return true;
    }

    count = 1;
    //bottom left, down
    x = initial_x;
    y = inital_y;
    while (x > 0 && y < 5)
    {
      x--;
      y++;
      int delta_x = x - initial_x;
      int delta_y = y - inital_y;
      int content = Grid.returnValue(delta_y, delta_x);
      if (content == player_ID)
      {
        count++;
      }
      else 
      {
        break;
      }
    }

    //top right, up
    x = initial_x;
    y = inital_y;
    while (x < 6 && y > 0)
    {
      x++;
      y--;
      int delta_x = x - initial_x;
      int delta_y = y - inital_y;
      int content = Grid.returnValue(delta_y, delta_x);
      if (content == player_ID)
      {
        count++;
      }
      else 
      {
        break;
      }
    }
    x = initial_x;
    y = inital_y;
    
    if(count >= 4)
    {
      return true;
    }
    return false;
  }
  
  /**
    //This if statement of code checks to see if the inputted value is out of bounds
    if(Grid.lastVertical != 6 && Grid.returnValue(1,y_Increment)== player_ID)
    {
      for(int x=1; x<=2;x++)
      {
        x_Increment += x;
        if(x_Increment + Grid.lastVertical<=6 && Grid.returnValue(x_Increment,y_Increment) != player_ID){ 
          return false;
        }
        else if(x == 2)
        {
          return true;
        }
      }
    }
    else if(Grid.lastHorizontal != 6 && Grid.returnValue(x_Increment,1) != 0){
      return false;
    }
    else if (Grid.lastVertical != 0) {
      return false;
    }
    else if (Grid.lastHorizontal != 0) {
      return false;
    }
    else{
      return false;
    }
    //If one of the condition was valid, it will return true as a valid win
    return false;
    }
  */
}