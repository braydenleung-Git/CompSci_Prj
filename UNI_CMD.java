/*
 * This class was created so that we can store universal commandz that every 
 * class can call. Ex: readLine(), readInt() etc.
 */

import java.util.*;

public class UNI_CMD
{
    
  /**
   * This method yada yada
   * @param
   * @return
   */
  public static int readInt(String question) 
  {
    Scanner myObj = new Scanner(GUI.userInput);
    System.out.println(question);
    String input = myObj.nextLine();
    if(input.equals("") || input.equals(" "))
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
   * @return
   */
  public static String readLine(String question)
  {
    Scanner myObj = new Scanner(GUI.userInput);
    System.out.println(question);
    return myObj.nextLine();
  }

  /**
   *
   * @param question
   * @return
   */
  public static String readLine_GUI(String question){
    Scanner input =  new Scanner(GUI.userInput);
    System.out.println(question);
    return input.nextLine();
  }

  /**
   *
   * @param question
   * @return
   */
  public static int readInt_GUI(String question)
  {
    Scanner myObj = new Scanner(GUI.userInput);
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
     * @return
     */
  public static void ui_Line(String input)
  {
    for(int x =0; x<input.length();x++)  
    {
      System.out.print("=");
    }
    System.out.println();
  }
  
  /**
   * This method yada yada
   * @param
   * @return
   */
  public static void flush(int amount)
  {
    for(int x =0; x< amount; x++)
    {
      System.out.println();
    }
  }
}