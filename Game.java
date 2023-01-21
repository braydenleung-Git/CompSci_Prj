import java.util.*;
//This class is the main file. It contains the information on how the game will actually run
//Brayden and Hanna collaborated on this class. They both added seperate peices of code, and edited and changed different parts of the code.

/*
    To Do list:
    - add indicator to indicate which player's turn
    - setup a working gui window with layout change
    - merge gui and the game
    - test game via gui
    - a more dramatic celerbration
    - a play again option/Winner scene
 */
public class Game
{
    //creates the game grid
    static Grid grid = new Grid();



    //Main run method
    public static void main(String[] args)
    {
        Player player1 = new Player(1,"test 1");
        Player player2 = new Player(2,"test 2");
        while(true){
            playerMove(player1);
            if(checkWin(player1.getPlayer_ID())) {
                System.out.println("Player 1 Wins!");
                break;
            }
            playerMove(player2);
            if(checkWin(player1.getPlayer_ID())) {
                System.out.println("Player 2 Wins!");
                break;
            }
        }
    }
    public static void playerMove(Player player)
    {
        int status = 0;
        //we created the loop so that if there is an error during validating player move, we can loop it to
        while(status == 0){
            UNI_CMD.flush(100);
            grid.print();
            int input = UNI_CMD.readInt("\nWhich column would you like to fill? ");
            status = grid.checkValidSpot(input, player.getPlayer_ID()); //This is used to break the loop
            //grid[][yada - 1] = '';
        }
    }

    /**
    * This method yada yada
    * @param
    * @return boolean value of whether there was a winner or not.
    */
    public static boolean checkWin(int player_ID){
        int x_Increment = 0;
        int y_Increment = 0;
        if(Grid.lastVertical != 7 &&  Grid.returnValue(1,y_Increment)== player_ID){
            for(int x=1; x<=2;x++)
            {
                x_Increment += x;
                if(x_Increment + Grid.lastVertical<=6 && Grid.returnValue(x_Increment,y_Increment) != player_ID){
                    return false;
                }
            }
        }
        else if(Grid.lastHorizontal != 6 && Grid.returnValue(x_Increment,1) != 0){
            return false;
        }
        else if (Grid.lastVertical != 0) {
            return false;
        }
        else if (Grid.lastHorizontal != 0) {
            return false;
        }
        else{
            return false;
        }
        //If one of the condition was valid, it will return true as a valid win
        return true;
    }
}