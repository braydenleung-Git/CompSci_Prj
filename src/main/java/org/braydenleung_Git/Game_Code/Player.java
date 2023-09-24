//This class controls the player id and is used to run the grid properly and assigns players to their objects.
//Brayden and Hanna collaborated on this class. (They both added seperate peices of code, and Brayden edited it.)
package org.braydenleung_Git.Game_Code;

public class Player
{
  public static final int DEFAULT_ID = 0;
  private final int player_ID ;
  private final String player_Name;

  //Constructor
  public Player(int id, String name)
  {
    player_ID = id;
    player_Name = name;
  }

  /**
   * This method gets the player id of a player.
   * @return Player's ID
   */
  public int getPlayer_ID()
  {
    return player_ID;
  }

  /**
   * this return Player's Name.
   * @return Player's Name
   */
  public String getName(){
    return player_Name;
  }

}