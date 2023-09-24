//This class was created so that we can store universal commands that every class can call. Ex: readLine(), readInt() etc. This was needed because these commands were not already in replits database, like they were in codehs' databse.
//Separate commands and docs were added by Brayden and Hanna. Some edits were made and some debugging was required.

import java.util.concurrent.CountDownLatch;

public class UNI_CMD
{
  /**
   * This method gets a response from a string question or statement in a GUI setting. (aka the scanner input)
   * @param question, the string that this is called on
   * @return String, a string object that the user inputs after reading the question or statement
   */
  public static String readLine_GUI(String question)
  {
    CountDownLatch latch = new CountDownLatch(1);
    new Thread(() -> {
      System.out.println(question);
      synchronized(GUI.lock){
        GUI.GUI_Triggered = true;
        while (!GUI.GUI_Input_Confirmed) {
          try {
            GUI.lock.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
      latch.countDown();
    }).start();
    try {
      //This tells the method that, if the latch is not "close" or  =0, it would not run the next line of code
      latch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    GUI.GUI_Input_Confirmed = false;
    GUI.GUI_Triggered = false;
    return GUI.userInput;
  }

  /**
   * This method prints out a question or statement and expects an int as a response to it. It assigns the response to the ints name. This is in a GUI setting (hence the scanner being involved.)
   * @param question, the int that this is called on.
   * @return int, a number that the user inputs after reading the question or statement.
   */
  public static int readInt_GUI(String question)
  {
    CountDownLatch latch = new CountDownLatch(1);
    new Thread(() -> {
      System.out.println(question);
      synchronized(GUI.lock){
        GUI.GUI_Triggered = true;
        while(!GUI.GUI_Input_Confirmed){
          try {
            GUI.lock.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        latch.countDown();
      }
    }).start();
    try {
      //This tells the method that, if the latch is not "close" or  =0, it would not run the next line of code
      latch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    GUI.GUI_Input_Confirmed = false;
    GUI.GUI_Triggered = false;
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