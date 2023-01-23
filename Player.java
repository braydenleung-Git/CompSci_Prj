//This class controls the player id and is used to run the grid properly and assigns players to their objects. 
//Brayden and Hanna collaborated on this class. (They both added seperate peices of code, and Brayden edited it.)

public class Player
{
  public static final int DEFAULT_ID = 0;
  private int player_ID = 0;
  private String player_Name = null;

  //Constructor
  public Player(int id, String name)
  {
    player_ID = id;
    player_Name = name;
  }

  /**
  *This method gets the player id of a player.
  */
  public int getPlayer_ID()
  {
    //System.out.println(player_ID);
    return player_ID;
  }

  /**
  * This method changes the id of a grid array. 
  * @param input, the change depends on this
  * @return int, the new id of the grid spot
  */
  public int change_ID(int input)
  {
    return 0;
  }
}