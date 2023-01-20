import java.util.*;
//This class is the main file. It contains the information on how the game will actually run
//Brayden and Hanna collaborated on this class. They both added seperate peices of code, and edited and changed
//different parts of the code.

public class Game
{
    //creates the game grid
    static Grid grid = new Grid();



    //Main run method
    public static void main(String[] args)
    {
        grid.print();
        Player player1 = new Player(1,"");
        Player player2 = new Player(2,"");
        while(true){
            playerMove(player1);
            if(checkWin() == true) {
              break;
            }
            playerMove(player2);
            if(checkWin() == true) {
              break;
            }
        }
    }
    public static void playerMove(Player player)
    {
        int status = 0;
        //we created the loop so that if there is an error during validating player move, we can loop it to
        while(status == 0){
            int input = UNI_CMD.readInt("\nWhich column would you like to fill? ");
            status = grid.checkValidSpot(input, player.getPlayer_ID()); //This is used to break the loop,
            //grid[][yada - 1] = '';
        }
    }

    /**
    * This method yada yada
    * @param
    * @return
    */
    public static boolean checkWin()
    {
        return false;
    }
}