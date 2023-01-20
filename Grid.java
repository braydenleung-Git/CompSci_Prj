//This class creates a grid object and replaces them with player objects
//Hanna and Brayden collaborated on this class (Hanna initialized it and Brayden added to it and debugged it)

public class Grid
{
    public static final int VERTICAL_SIZE = 6 ;
    public static final int HORIZONTAL_SIZE = 7;
    public static final String COLOR_RED = "\033[0;31m";
    public static final String COLOR_YELLOW = "\033[0;33m";
    public static final String COLOR_RESET = "\033[0m";
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
        //int player = grid [0][0];
        int count = 0;
        if(grid[0][0]!=0)
        {
            System.out.println("Error this column hs been filled, please choose another one");

            return 0;
        }
        else {
            //the line below is to verify wether the code ran this part or not
            //System.out.println("2");
            for(int x = 0; x<VERTICAL_SIZE; x++)
            {

                if(grid[x][input-1]!= 0 )
                {
                    x--;
                    grid[x][input-1] = player_ID;
                    break;
                }
                else if( x ==VERTICAL_SIZE-1){
                    grid[x][input-1] = player_ID;
                    break;
                }
            }
            System.out.println("You have placed your dot in column "+ input);
            UNI_CMD.readLine("Press [Enter] to proceed");
            System.out.println("Count :"+count);
            return 1;
        }
    }

    /**
     * This method sorts the id between players and return their corrisponding color and character
     * @param input
     * @return
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