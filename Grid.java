//This class creates a grid object and replaces them with player objects
//Hanna and Brayden collaborated on this class (Hanna initialized it and Brayden added to it and debugged it). It went through major changes along the way.

public class Grid
{
  //These lines of code create the grid and seperate objects
  public static final int VERTICAL_SIZE = 6 ;
  public static final int HORIZONTAL_SIZE = 7;
  public static final String COLOR_RED = "\033[0;31m";
  public static final String COLOR_YELLOW = "\033[0;33m";
  public static final String COLOR_RESET = "\033[0m";
  public static int lastVertical =0;
  public static int lastHorizontal =0;
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
   * This method is used to return the value at the position that is on the 2D Array
   * @return
   */
  /* //disabled because is not needed for now.
  public static int returnValue(){
      return grid[lastVertical][lastHorizontal];
  }*/

  /**
   * This method is used to return the value at the postion that is on the 2D Array, but with added increment
   * @param increment_X
   * @param increment_Y
   * @return int
   */
  public static int returnValue(int increment_X, int increment_Y){
    return grid[lastVertical+increment_X][lastHorizontal+increment_Y];
  }
  
  /**
   * This method yada yada
   * @param input
   * @param player_ID
   * @return int
   */
  public int checkValidSpot(int input, int player_ID)
  {
      //int player = grid [0][0];
      int count = 0;
      if(input > HORIZONTAL_SIZE || grid[0][input-1]!=0)
      {
          System.out.println("ERROR: Invalid input. Please try again:");
          UNI_CMD.readLine("Press [Enter] to proceed");
          return 0;
      }
      else {
          //the line below is to verify whether the code ran this part or not
          //System.out.println("2");
          for(int x = 0; x<VERTICAL_SIZE; x++)
          {
              if(grid[x][input-1]!= 0 )
              {
                  x--;
                  grid[x][input-1] = player_ID;
                  lastVertical = x;
                  lastHorizontal = input-1;
                  break;
              }
              else if( x == VERTICAL_SIZE-1){
                  grid[x][input-1] = player_ID;
                  lastVertical = x;
                  lastHorizontal = input-1;
                  break;
              }
          }
          System.out.println("You have placed your dot in column "+ input);
          UNI_CMD.readLine("Press [Enter] to proceed");
          //System.out.println("Count :"+count);
          return 1;
      }
  }

  /**
   * This method sorts the id between players and return their corrisponding colour and character
   * @param input
   * @return string
   */
  private String sort_ID(int input)
  {
    if(input == 1)
    {
        return COLOR_RED+"➊"+COLOR_RESET;
    }
    else if (input == 2)
    {
        return COLOR_YELLOW+"➋"+COLOR_RESET;
    }
    return "□";
  }

  /**
   * This method takes the grid object and prints it out. It does not have any parameters
   * or returns.
   */
  public void print()
  {
    for(int i = 0; i < grid.length; i++)
    {
      for(int j = 0; j < grid[0].length; j++)
      {
        System.out.print(sort_ID(grid[i][j]) + " ");
      }
      System.out.println();
    }
    String column_id ="";
    for(int x = 0 ; x < grid[0].length; x++)
    {
      column_id += (x+1) +" ";
    }
    System.out.println(column_id);
}
}