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
        int input = readInt("\nWhich column would you like to fill? ");
        grid.checkValidSpot(input, player.getPlayer_ID());
        //grid[][yada - 1] = '';
    }
    /**
    * This method yada yada
    * @param
    * @ return
    */
    public static int readInt(String question) {
        Scanner myObj = new Scanner(System.in);
        System.out.println(question);
        String input = myObj.nextLine();
        if(input.equals(""))
        {
            return 0;
        }
        else
        {
            return Integer.parseInt(input);
        }
    }

    /**
    * This method yada yada
    * @param
    * @ return
    */
    public static void ui_Line(String input){
        for(int x =0; x< input.length();x++);  {
            System.out.print("=");
        }
        System.out.println();
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