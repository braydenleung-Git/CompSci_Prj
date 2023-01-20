//This class creates a grid object and replaces them with player objects
//Hanna and Brayden collaborated on this class (Hanna initialized it and Brayden added to it and debugged it)

public class Grid
{
    public static final int VERTICAL_SIZE = 6 ;
    public static final int HORIZONTAL_SIZE = 7;
    public static final String COLOR_RED = "\033[0;31m";
    public static final String COLOR_YELLOW = "\033[0;33m";
    public static final String COLOR_RESET = "\033[0m"
    //Initializing grid object
    public int[][] grid;
  
  //Constructor 
    public Grid()
    {
        grid = new int[VERTICAL_SIZE][HORIZONTAL_SIZE];
        for(int v= 0;v<VERTICAL_SIZE;v++)
        {
          for(int h=0; h< HORIZONTAL_SIZE; h++)
            {
               grid[v][h] = Player.DEFAULT_ID;
            }
        }
    }

    public int checkValidSpot(int input, int player_ID)
    {
        int player = grid [0][0];
        if(grid[0][0]!=0)
        {
            System.out.println("Error this coloumn hs been filled, please choose another one");

            return 0;
        }
        else {
            for(int x =0; x<VERTICAL_SIZE; x++)
            {
                if(grid[x][input]!= 0)
                {
                    x--;
                    player = grid[x][input];
                    player = player_ID;
                    break;
                }

            }
            return 1;
        }
    }

    private String sort_ID(int input)
    {
        if(input == 1)
        {
            return "➊";
        }
        else if (input == 2)
        {
            return "➋";
        }
        return COLOR_RED+"▢";
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