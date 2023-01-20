//This class creates a grid object and replaces them with player objects
//Hanna and Brayden collaborated on this class (Hanna initialzed it and Brayden added to it and debugged it) 

public class Grid
{
    public static final int VERTICAL_SIZE = 6 ;
    public static final int HORIZONTAL_SIZE = 7;
  //Initializing grid object
  public Player[][] grid;
  
  //Constructor 
  public Grid()
  {
    grid = new Player[VERTICAL_SIZE][HORIZONTAL_SIZE];
    for(int x= 0;x<VERTICAL_SIZE;x++)
    {
      for(int i=0; i< HORIZONTAL_SIZE; i++)
        {
          
        }
    }
  }

  public void checkValidSpot(int input, int player_ID)
  {
    Player player = grid [0][0];
    for(int x =0; x<6; x++)
    {
        if(! grid[x][input].equals(" "))
        {
            x--;
            player = grid[x][input];
            player.change_ID(player_ID);
            break;
        }
    }
  }

  
  /** This method takes the grid object and prints it out. It does not have any parameters
  * or returns.
  */
  public void print()
  {
    for(int i = 0; i < grid.length; i++)
    {
      for(int j = 0; j < grid[0].length; j++)
      {
        System.out.print(grid[i][j] + " ");
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