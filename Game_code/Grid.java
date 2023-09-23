//This class creates a grid object and replaces them with player objects
//Hanna and Brayden collaborated on this class (Hanna initialized it and Brayden added to it and debugged it). It went through major changes along the way.
package Game_code;

import java.awt.*;

public class Grid
{
  //These lines of code create the grid and seperate objects
  public static final int VERTICAL_SIZE = 6 ;
  public static final int HORIZONTAL_SIZE = 7;
  public static int lastVertical = 0;
  public static int lastHorizontal = 0;
  //Initializing grid object
  public static int[][] grid;

  //Constructor
  public Grid()
  {
    grid = new int[VERTICAL_SIZE][HORIZONTAL_SIZE];
    for(int v= 0; v<VERTICAL_SIZE; v++)
    {
      for(int h=0; h< HORIZONTAL_SIZE; h++)
        {
           grid[v][h] = Player.DEFAULT_ID;
        }
    }
  }

  /**
   * This method is used to return the value at the position that is on the 2D Array, but with added increment
   * @param increment_Y the vertical increment
   * @param increment_X the horizontal increment
   * @return int the player ID stored in that position
   */
  public static int returnValue(int increment_Y, int increment_X)
  {
    return grid[lastVertical+increment_Y][lastHorizontal+increment_X];
  }
  
  /**
   * This method checks to see if the spot player wants to put an object down upon is open.
   * @param player_ID, the object they put is dependent on their player id.
   * @return int, what the spots player_ID is
   */
  public int checkValidSpot(int player_ID)
  {
    if(Game.input <= 0 || Game.input > HORIZONTAL_SIZE || grid[0][Game.input-1]!=0)
    {
      System.out.println("\nERROR: Invalid input. Please try again:");
      UNI_CMD.readLine_GUI("Press [Enter] to proceed");
      return 0;
    }
    else 
    {
      //Game.input = Column #, x = Vertical Position of the placement
      for(int x = 0; x<VERTICAL_SIZE; x++)
      {
        //if the space at x is not empty, Dot will be placed above the dot
        if(grid[x][Game.input-1]!= 0 )
        {
          x--;
          grid[x][Game.input-1] = player_ID;
          lastVertical = x;
          lastHorizontal = Game.input-1;
          break;
        }
        //if the vertical placement is equals to bottom(VERTICAL_SIZE-1), Dot will be placed
        else if( x == VERTICAL_SIZE-1)
        {
          grid[x][Game.input-1] = player_ID;
          lastVertical = x;
          lastHorizontal = Game.input-1;
          break;
        }
      }
      System.out.println("\nYou have placed your dot in column "+ Game.input);
      Game.input = 0 ;
      UNI_CMD.readLine_GUI("Press [Enter] to proceed");
      return 1;
    }
  }

  /**
   * This method sorts the id between players and return their corresponding colour and object character
   * @param input, what the id is
   * @return string, the grid object or player object
   */
  private String sort_ID(int input)
  {
    if(input == 1)
    {
      GUI.altTextColour("➊", Color.RED);
      return null;
    }
    else if (input == 2)
    {
      GUI.altTextColour("➋",Color.YELLOW);
      return null;
    }
    return "□";
  }

  /**
   * This method takes the grid object and prints it out as well as the column numbers. It does not have any parameters or returns.
   */
  public void print()
  {
    for(int i = 0; i < grid.length; i++)
    {
      for(int j = 0; j < grid[0].length; j++)
      {
        //GUI.altTextColor() taken over the printing part,
        //therefore when the grid is null(certain ID) it would just print the spacers
        if(sort_ID(grid[i][j]) == null){
          System.out.print(" ");
        }
        else {
          System.out.print(sort_ID(grid[i][j]) + " ");
        }
      }
      System.out.println();
    }
    String column_id ="";
    for(int x = 0 ; x < grid[0].length; x++)
    {
      column_id += (x+1) +"  ";
    }
    System.out.println(column_id);
    UNI_CMD.ui_Line(column_id);
  }
}