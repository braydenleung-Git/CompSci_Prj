public class Grid
{
  public int[][] grid;
  public Grid()
  {
    grid = new int[][]{
        {0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0},
    };
  }

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