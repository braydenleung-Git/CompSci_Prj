//This class controls the player id and is used to run the grid properly and
//assign players to theri objects. 
//Brayden and Hanna collaborated on this class. (They both added a seperate peices of code, and Brayden mainly edited it and changed it.)

public class Player
{
 //Brayden
  public static final int DEFAULT_ID = 0;
  private int player_ID = 0;
  private String player_Name = null;

  public Player(int id, String name)
  {
    player_ID = id;
    player_Name = name;
  }
  public int getPlayer_ID(){
    //System.out.println(player_ID);
    return player_ID;
  }
  public int change_ID(int input)
  {
    return 0;
  }
}