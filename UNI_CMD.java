//This class was created so that we can store universal commands that every class can call. Ex: readLine(), readInt() etc. This was needed because these commands were not already in replits database, like they were in codehs' databse. 
//Separate commands and docs were added by Brayden and Hanna. Some edits were made and some debugging was required.

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

public class UNI_CMD
{
    
  /**
   * This method prints out a question or statment and expects an int as a response to it. It assings the respons to the ints name.
   * @param question, the int that this is called on.
   * @return int, a number that the user inputs after reading the question or statment.
   */

  public static int readInt(String question)
  {
    Scanner myObj = new Scanner(System.in);
    System.out.println(question);
    String input = myObj.nextLine();
    char input_c = input.charAt(0);
    if(Character.isDigit(input_c))
    {

      return Character.getNumericValue(input_c);
    }
    else
    {
        return 0;

    }
  }

  /**
   * This method prints out a question or statment and expects a string object as a response to it. It assings the response to the strings name. This is from the text console. 
   * @param question, the string that this is called on.
   * @return String, a string object that the user inputs after reading the question or statment.
   */
  public static String readLine(String question) {
    Scanner myObj = new Scanner(System.in);
    System.out.println(question);
    return myObj.nextLine();

  }

    /**
   * This method gets a response from a string question or statment in a GUI setting. (aka the scanner input)
   * @param question, the string that this is called on
   * @return String, a string object that the user inputs after reading the question or statement
   */
  public static String readLine_GUI(String question)
  {
    System.out.println(question);
    while (GUI.GUI_Triggered = false)
    {
      
    }
    if(GUI.userInput.equals("◽"))
    {
      return " ";
    }
    else
    {
      return GUI.userInput;
    }
  }

  /**
   * This method prints out a question or statment and expects an int as a response to it. It assings the response to the ints name. This is in a GUI setting (hence the scanner being involved.)
   * @param question, the int that this is called on.
   * @return int, a number that the user inputs after reading the question or statment.
   */
  public static int readInt_GUI(String question)
  {

    System.out.println(question);
    while (GUI.userInput.equals("")) {
    }
    if(GUI.userInput.equals("◽"))
    {
      return 0;
    }
    else
    {
      return Integer.parseInt(GUI.userInput);
    }
  }
  
  /**
     * This method takes a string and checks its length, and prints out the exact amount of equal signs for the strings length. It's is based on text length.  
     * @param input, the string it is breaking down into ui lines
     */
  public static void ui_Line(String input)
  {
    for(int x =0; x<input.length();x++)  
    {
      System.out.print("=");
    }
    //prints out the input again after the ui line
    System.out.println();
  }
  
  /**
   * This method 'flushes' the console board. It puts down an amount of lines inbetween the played grids so that the grid always appears fresh and you don't have a bunch of grids one after another. 
   * @param amount, the number of lines you will flush
   */
  public static void flush(int amount)
  {
    for(int x =0; x< amount; x++)
    {
      System.out.println();
    }
  }
}