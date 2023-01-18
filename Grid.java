//This class creates a grid object and replaces them with player objects
//Hanna and Brayden collaborated on this class (Hanna initialzed it and Brayden debugged it and changed it) 
public class Grid
{

  //Initializing grid object
  public char[][] grid;
  
  //Constructor 
  public Grid()
  {
    grid = new char[][]{
        {'□','□','□','□','□','□','□'},
        {'□','□','□','□','□','□','□'},
        {'□','□','□','□','□','□','□'},
        {'□','□','□','□','□','□','□'},
        {'□','□','□','□','□','□','□'},
        {'□','□','□','□','□','□','□'}
        
  
    };
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
  }  
}