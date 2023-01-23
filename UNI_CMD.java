//This class was created so that we can store universal commands that every class can call. Ex: readLine(), readInt() etc. This was needed because these commands were not already in replits database, like they were in codehs' databse. 
//Seperate commands and docs were added by Brayden and Hanna. Some edits were made and some debugging was required. 

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
   * This method prints out a question or statment and expects a string object as a response to it. It assings the response to the strings name. This is from the text console. 
   * @param question, the string that this is called on.
   * @return String, a string object that the user inputs after reading the question or statment.
   */
  public static String readLine(String question)
  {
    Scanner myObj = new Scanner(System.in);
    System.out.println(question);
    String text =  myObj.nextLine();
    return text;
  }

  /**
     * This method takes a string and checks its length, and based on text length prints out that amount of equal signs
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
   * This method takes a integer and prints out the exact amount of equal signs
   * @param input Number of equal signs
   */
  public static void ui_Line(int input)
  {
    for(int x =0; x<input;x++)
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