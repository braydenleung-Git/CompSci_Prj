package org.braydenleung_Git.Game_Code;//This class is the main file. It contains the information on how the game will actually run
//Hanna and Brayden collaborated on this class. They both added separate pieces of code, and edited and changed different parts.

/*
    To Do list:
 */
public class Game
{
  //creates the game grid
  static Grid grid = new Grid();
  public static int input = 0;
  public static String prompt = "";
  public static String text ="";

  //Main run method
  public static void run_Game()
  {
    //this shows rules before the game begins
    UNI_CMD.flush(50);
    System.out.println("WELCOME TO CONNECT FOUR! \n \nRules of the game: \n");
    UNI_CMD.ui_Line(82);
    System.out.println(
      """
      1) There are 7 columns. You will take turns dropping your circles down one by one.\s
      2) To WIN, you must have FOUR of your coins in a ROW.\s
      3) This can be done vertically, horizontally, or diagonally.\s
      4) To choose a column, TYPE a column number when asked."""
    );
    UNI_CMD.ui_Line(82);
    UNI_CMD.readLine_GUI("\nEnjoy the game! \nPress [Enter] to proceed:");
    UNI_CMD.flush(50);

    Player player1 = new Player(1, GUI.Player1_Name);
    Player player2 = new Player(2, GUI.Player2_Name);
    UNI_CMD.flush(50);
    grid.print();

    while(true){
      playerMove(player1);
      if(checkWin(player1.getPlayer_ID()))
      {
        System.out.println("\n"+ player1.getName().toUpperCase()+" WINS!!!");
        break;
      }
      playerMove(player2);
      if(checkWin(player2.getPlayer_ID())) 
      {
        System.out.println("\n"+player2.getName().toUpperCase()+" WINS!!!");
        break;
      }
    }

    while(true){
      prompt = "Back to main Menu? [Y/N]";
      UNI_CMD.ui_Line(prompt);
      text = UNI_CMD.readLine_GUI(prompt).toUpperCase();
      if(text.equals("Y")) {
        GUI.return_TitleScreen();
        break;
      }
      if(text.equals("N")) {
        System.exit(0);
      }
      prompt = "Error: Invalid input [Enter]";
      UNI_CMD.ui_Line(prompt);
      UNI_CMD.readLine_GUI(prompt);
      UNI_CMD.flush(50);
    }
  }

  /**
  * This method takes the users column input and places the object there by calling on a grid method
  * @param player, the object placed depends on the player
  */ 
  public static void playerMove(Player player)
  {
    int status = 0;
    //we created the loop so that if there is an error during validating player move,
    //we can ask for a correct input again.
    while(status == 0)
    {
      input = UNI_CMD.readInt_GUI( player.getName()+","+ "\nWhich column would you like to fill? ");
      //This is used to break the loop
      status = grid.checkValidSpot(player.getPlayer_ID()); 
      UNI_CMD.flush(50);
      grid.print();
    }
  }
  
  /**
  * This method calls on 3 different check-win methods to check whether the placed object completes a winning strike of four objects
  * @param player_ID, the code looks for the players objects
  * @return boolean, value of whether there was a winner or not.
  */ 
  public static boolean checkWin(int player_ID)
  {
    return checkHorizontal(player_ID) || checkVertical(player_ID) || checkDiagonal(player_ID);
  }

  /**
  * This method checks if the object placed was a vertical win
  * @param player_ID, the code looks for the players objects
  * @return boolean, value of whether there was a vertical connect four or not
  */ 
  public static boolean checkVertical(int player_ID)
  {
    int count = 1;
    int initial_y = Grid.lastVertical;
    int y = initial_y;
    
    while (y < 5)
    {
      y++;
      int delta_y = y - initial_y;
      int content = Grid.returnValue(delta_y, 0);
      if (content == player_ID)
      {
        count++;
      }
      else 
      {
        break;
      }
    }
    return count >= 4;
  }

  
  /**
  * This method checks if the object placed was a horizontal win
  * @param player_ID, the code looks for the players objects
  * @return boolean, value of whether there was a horizontal connect four or not.
  */ 
  public static boolean checkHorizontal(int player_ID)
  { 
    int count = 1;
    int initial_x = Grid.lastHorizontal;
    //This is used to check the points that are on the right side of the token placed by the player
    int x = initial_x;
    while (x > 0)
    {
      x--;
      int delta_x = x - initial_x;
      int content = Grid.returnValue(0, delta_x);
      if (content == player_ID) 
      {
        count++;
      }
      else 
      {
        break;
      }
    }
    //This is used to check the points that are on the left side of the token placed by the player
    x = initial_x;
    while (x < 6)
    {
      x++;
      int delta_x = x - initial_x;
      int content = Grid.returnValue(0, delta_x);
      if (content == player_ID)
      {
        count++;
      }
      else 
      {
        break;
      }
    }
    return count >= 4;
  }

  /**
  * This method checks if the object placed was a diagonal win, going both ways
  * @param player_ID, the code looks for the players objects
  * @return boolean, value of whether there was a diagonal connect four or not.
  */ 
  public static boolean checkDiagonal(int player_ID)
  {
    int count = 1;
    int initial_x = Grid.lastHorizontal;
    int initial_y = Grid.lastVertical;
    int x = initial_x;
    int y = initial_y;
    //checks for top left objects, going up
    while (x > 0 && y > 0)
    {
      x--;
      y--;
      int delta_x = x - initial_x;
      int delta_y = y - initial_y;
      int content = Grid.returnValue(delta_y, delta_x);
      if (content == player_ID)
      {
        count++;
      }
      else 
      {
        break;
      }
    }
    //checks for bottom right objects, going down
    x = initial_x;
    y = initial_y;
    while (x < 6 && y < 5)
    {
      x++;
      y++;
      int delta_x = x - initial_x;
      int delta_y = y - initial_y;
      int content = Grid.returnValue(delta_y, delta_x);
      if (content == player_ID)
      {
        count++;
      }
      else 
      {
        break;
      }
    }
    if(count >= 4)
    {
      return true;
    }
    //checks for bottom left objects, going down
    count = 1;
    x = initial_x;
    y = initial_y;
    while (x > 0 && y < 5)
    {
      x--;
      y++;
      int delta_x = x - initial_x;
      int delta_y = y - initial_y;
      int content = Grid.returnValue(delta_y, delta_x);
      if (content == player_ID)
      {
        count++;
      }
      else 
      {
        break;
      }
    }
    //checks for top right objects, going up
    x = initial_x;
    y = initial_y;
    while (x < 6 && y > 0)
    {
      x++;
      y--;
      int delta_x = x - initial_x;
      int delta_y = y - initial_y;
      int content = Grid.returnValue(delta_y, delta_x);
      if (content == player_ID)
      {
        count++;
      }
      else 
      {
        break;
      }
    }
    return count >= 4;
  }
}