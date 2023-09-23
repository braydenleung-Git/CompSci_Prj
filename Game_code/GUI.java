//This class creates the beginning GUI in our game. Brayden created this class.

//set up all the prerequisites for the class
package Game_code;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.io.*;
import java.nio.charset.StandardCharsets;


public class GUI {

  public static String Player1_Name = "Player 1";
  public static String Player2_Name = "Player 2";
  public static boolean GUI_Triggered = false;
  public static boolean GUI_Input_Confirmed = false;
  public static final Object lock = new Object();
  public static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  public static JFrame frame = new JFrame("Connect 4, By Brayden & Hanna");
  public static final JPanel main_Panel = new JPanel(new CardLayout());
  private static final JPanel username_Layout = new JPanel();
  private static final JPanel console_Layout = new JPanel();
  public static String userInput = "";
  public static Dimension console_frame_Size = new Dimension();
  public static Dimension titlescreen_frame_Size = new Dimension();
  public static JTextField console_Input = new JTextField();

  public static JTextPane console_Output = new JTextPane();

  //Font library, Each font variable must be declared with public visibility first
  public static Font HelvetciaNeue_Cond_B_05 = null;
  public static Font Impact = null;
  public static Font PTMono_Regular_02 = null;
  public static Font SplineSansMono_VF_wght = null;
  public static Font Arial_Unicode = null;
  public static Font Nanum_Gothic_Coding_B = null;
  public static Font Nanum_Gothic_Coding_R = null;

  public static void main(String[] args) {

    //Set that when the user clicks cross button, it will kill the code
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setup_Fonts();
    setup_Username_Layout();
    setup_Console_Layout();
    //Adds the username_Layout to the main layout
    main_Panel.add(username_Layout, "Username");
    main_Panel.add(console_Layout, "Console");
    main_Panel.setLocation(frame.getHeight() / 2, frame.getWidth() / 2);
    //add the main_panel(one that allow switching scene) to the JFrame
    frame.add(main_Panel, BorderLayout.CENTER);
    frame.pack();
    titlescreen_frame_Size.setSize(frame.getWidth(),frame.getHeight());
    //set the position of the frame to center of the screen
    frame.setLocation((screenSize.width / 2) - (frame.getWidth() / 2), (screenSize.height / 2) - (frame.getHeight() / 2));
    frame.setResizable(false);
    frame.setVisible(true);
  }

  /**
   * This method is used to set up the username "Card" so that it make switching between "cards possible
   */
  public static void setup_Username_Layout() {


    JPanel username = new JPanel();
    //This is used to set up the left side(text) of the username layout
    JPanel left_Side = new JPanel();
    left_Side.setLayout(new BoxLayout(left_Side, BoxLayout.Y_AXIS));
    JLabel player1_L = new JLabel("Player 1:");
    player1_L.setFont(HelvetciaNeue_Cond_B_05.deriveFont(25f));
    JLabel player2_L = new JLabel("Player 2:");
    player2_L.setFont(HelvetciaNeue_Cond_B_05.deriveFont(25f));
    left_Side.add(player1_L);
    left_Side.add(player2_L);
    username.add(left_Side);

    //This is used to set up the right side (text field) of the username layout
    JPanel right_Side = new JPanel();
    right_Side.setLayout(new BoxLayout(right_Side, BoxLayout.Y_AXIS));
    JTextField player1_T = new JTextField("Insert your name");
    player1_T.setFont(HelvetciaNeue_Cond_B_05.deriveFont(20f));
    player1_T.setSize(250, 25);
    //line below is for experimental purpose, not supposed to be implemented to code
    //player1_T.setMaximumSize(new Dimension(250/**(1+(username_Layout.getWidth()/25))*/,30/**(1+(username_Layout.getHeight()/25))*/));

    JTextField player2_T = new JTextField("Insert your name");
    player2_T.setFont(HelvetciaNeue_Cond_B_05.deriveFont(20f));
    player2_T.setSize(250, 25);
    //line below is for experimental purpose, not supposed to be implemented to code
    //player2_T.setMaximumSize(new Dimension(250/**(1+(username_Layout.getWidth()/25))*/,30/**(1+(username_Layout.getHeight()/25))*/));

    right_Side.add(player1_T);
    right_Side.add(player2_T);
    username.add(right_Side);

    //This adds image to the panel
    ImageIcon icon = new ImageIcon("Resource/Connect 4 Icon.png");
    Image icon_Image = (icon.getImage()).getScaledInstance((int) (icon.getIconHeight() * (0.30)), (int) (icon.getIconWidth() * (0.30)), Image.SCALE_SMOOTH);
    icon = new ImageIcon(icon_Image);
    JLabel game_Icon_TitleScreen = new JLabel(icon);
    game_Icon_TitleScreen.setSize((frame.getWidth() / 100), (frame.getHeight() / 100));


    //This adds a button to start the game
    JButton start_Button = new JButton("Click to Start Game");
    start_Button.setFont(Impact.deriveFont(24f));
    start_Button.addActionListener(e -> {

      new Thread(()-> {
        //System.out.println("2");
        //This is used for turning the text input that the user put in the text box as the player name, by default it is set to "Player 1"
        if (!player1_T.getText().equals("Insert your name")) {
          Player1_Name = player1_T.getText();
        }
        //This is used for turning the text input that the user put in the text box as the player name, by default it is set to "Player 2"
        if (!player2_T.getText().equals("Insert your name")) {
          Player2_Name = player2_T.getText();
        }

        CardLayout cl = (CardLayout) (main_Panel.getLayout());
        cl.show(main_Panel, "Console");
        main_Panel.setBackground(Color.BLACK);
        frame.setBackground(Color.black);
        frame.setSize(console_frame_Size);
        frame.setLocation((screenSize.width / 2) - (frame.getWidth() / 2), (screenSize.height / 2) - (frame.getHeight() / 2));
        //System.out.println("Player one's name:" + Player1_Name);
        //System.out.println("Player two's name:" + Player2_Name);
        //UNI_CMD.readLine_GUI("Start Game? [Enter]");
        //System.out.println("test");
        //Note: if the application freeze, causation is from extended-state of the frame, run the extended within the game class to resolve
      }).start();
      Thread Game_T = new Thread(Game::run_Game);
      Game_T.start();
    });


    //This adds the panels together as one
    username_Layout.setLayout(new BorderLayout());
    username_Layout.add(game_Icon_TitleScreen, BorderLayout.NORTH);
    username_Layout.add(username, BorderLayout.CENTER);
    username_Layout.add(start_Button, BorderLayout.AFTER_LAST_LINE);
  }

  /**
   * This method is used to set up the console "Card" so that it makes switching between "cards" possible
   */
  public static void setup_Console_Layout() {
    console_Layout.setLayout(new BorderLayout());
    console_Layout.setBackground(Color.BLACK);
    //Set up console output to text area
    console_Output.setEditable(false);
    console_Output.setFont(Nanum_Gothic_Coding_B);
    StyledDocument doc = console_Output.getStyledDocument();
    SimpleAttributeSet normal_Text = new SimpleAttributeSet();
    console_Output.setBackground(Color.BLACK);
    StyleConstants.setForeground(normal_Text, Color.white);
    console_Output.setFont(Nanum_Gothic_Coding_B.deriveFont(20f));

    //this setup the output of the console
    PrintStream output = new PrintStream(new OutputStream() {
      @Override
      public void write(byte[] b, int off, int len) {
        String text = new String(b, off, len, StandardCharsets.UTF_8);
        try {
          doc.insertString(doc.getLength(), text, normal_Text);
        } catch (BadLocationException e) {
          throw new RuntimeException(e);
        }
        // Automatically scroll down console
        console_Output.setCaretPosition(doc.getLength());
      }
      @Override
      public void write(int b) {
        write(new byte[]{(byte) b}, 0, 1);
      }
    });
    System.setOut(output);
    System.setErr(output);

    console_frame_Size.setSize(screenSize.getWidth(), (screenSize.getHeight() - 25));


    JScrollPane console_Output_Scroll = new JScrollPane(console_Output);
    console_Output_Scroll.setBackground(Color.BLACK);
    console_Layout.add(console_Output_Scroll, BorderLayout.CENTER);


    //This creates a new thread so that, when the action is triggered,
    //GUI.lock.wait(); will not wait the same thread this listener is set on,
    //preventing the gui to froze
    new Thread(() -> {
      //System.out.println("1");
      //Set up console input to the text field
      console_Input.addActionListener(e -> {
        //This is to prevent accidental activation
        if(GUI_Triggered){
          userInput = console_Input.getText();
          if (userInput.equals("")) {
            userInput = "◽";
          }
          //this mirrors the user input to console output
          try {
            doc.insertString(doc.getLength(),"\n" + console_Input.getText(), normal_Text);
          } catch (BadLocationException a) {
            throw new RuntimeException(a);
          }
        }
        console_Input.setText("");
        synchronized(lock) {
          GUI_Input_Confirmed = true;
          lock.notifyAll();
        }
      });
    }).start();

    console_Input.setBackground(Color.decode("#4f4f4f"));
    console_Input.setForeground(Color.white);
    console_Input.setFont(PTMono_Regular_02.deriveFont(20f));
    console_Layout.add(console_Input, BorderLayout.SOUTH);

  }

  /**
   * This method is to change the color of a certain text that is going to be printed in console output
   * @param input text input
   */
  public static void altTextColour(String input, Color color){
    SimpleAttributeSet coloredText = new SimpleAttributeSet();
    StyleConstants.setForeground(coloredText, color);

    StyledDocument doc = console_Output.getStyledDocument();
    try {
      doc.insertString(doc.getLength(), input, coloredText);
    } catch (BadLocationException e) {
      throw new RuntimeException(e);
    }
  }
  /**
   * This method is used to import the font used in the program.
   * Note: Only one that are imported are count towards "Font", varies by file name.
   */
public static void return_TitleScreen(){
  CardLayout cl = (CardLayout) (main_Panel.getLayout());
  cl.show(GUI.main_Panel, "Username");
  frame.setSize(GUI.titlescreen_frame_Size);
  frame.setLocation((screenSize.width / 2) - (frame.getWidth() / 2), (screenSize.height / 2) - (frame.getHeight() / 2));
  StyledDocument doc = console_Output.getStyledDocument();
  try {
    doc.remove(0, doc.getLength());
  } catch (BadLocationException e){
    e.printStackTrace();
  }
}
  public static void setup_Fonts() {
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    try {

      //Load the font file
      //HelveticaNeue-CondensedBold-05
      File HelvetciaNeue_Cond_B_05_File = new File("./Resource/Fonts/HelveticaNeue/HelveticaNeue-CondensedBold-05.ttf");
      HelvetciaNeue_Cond_B_05 = Font.createFont(Font.TRUETYPE_FONT, HelvetciaNeue_Cond_B_05_File);
      ge.registerFont(HelvetciaNeue_Cond_B_05);
    } catch (IOException | FontFormatException e) {
      e.printStackTrace();
    }
    try {
      //Impact
      File Impact_File = new File("./Resource/Fonts/Impact.ttf");
      Impact = Font.createFont(Font.TRUETYPE_FONT, Impact_File);
      ge.registerFont(Impact);
    } catch (IOException | FontFormatException e) {
      e.printStackTrace();
    }
    try {
      //PTMono-Regular-02
      File PTMono_Regular_02_File = new File("./Resource/Fonts/PTMono/PTMono-Regular-02.ttf");
      PTMono_Regular_02 = Font.createFont(Font.TRUETYPE_FONT, PTMono_Regular_02_File);
      ge.registerFont(PTMono_Regular_02);
    } catch (IOException | FontFormatException e) {
      e.printStackTrace();
    }
    try {
      //SplineSansMono-VariableFont_wght
      File SplineSansMono_VF_wght_File = new File("./Resource/Fonts/SplineSans/SplineSansMono-VariableFont_wght.ttf");
      SplineSansMono_VF_wght = Font.createFont(Font.TRUETYPE_FONT, SplineSansMono_VF_wght_File);
      ge.registerFont(SplineSansMono_VF_wght);

    } catch (IOException | FontFormatException e) {
      e.printStackTrace();
    }
    try {
      //Arial Unicode
      File Arial_Unicode_File = new File("./Resource/Fonts/Arial Unicode.ttf");
      Arial_Unicode = Font.createFont(Font.TRUETYPE_FONT, Arial_Unicode_File);
      ge.registerFont(Arial_Unicode);

    } catch (IOException | FontFormatException e) {
      e.printStackTrace();
    }
    try {
      //NanumGothicCoding-Bold
      File Nanum_Gothic_Coding_B_File = new File("./Resource/Fonts/Nanum_Gothic_Coding/NanumGothicCoding-Bold.ttf");
      Nanum_Gothic_Coding_B = Font.createFont(Font.TRUETYPE_FONT, Nanum_Gothic_Coding_B_File);
      ge.registerFont(Nanum_Gothic_Coding_B);

    } catch (IOException | FontFormatException e) {
      e.printStackTrace();
    }
    try {
      //NanumGothicCoding-Regular
      File Nanum_Gothic_Coding_R_File = new File("./Resource/Fonts/Nanum_Gothic_Coding/NanumGothicCoding-Regular.ttf");
      Nanum_Gothic_Coding_R = Font.createFont(Font.TRUETYPE_FONT, Nanum_Gothic_Coding_R_File);
      ge.registerFont(Nanum_Gothic_Coding_R);

    } catch (IOException | FontFormatException e) {
      e.printStackTrace();
    }
  }
}



//Offline Copy of GPT code (Console)
/*
==========================================================================
public class Console {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Console");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());

    JTextArea console = new JTextArea();
    console.setEditable(false);
    frame.add(console, BorderLayout.PAGE_START);

    // redirect standard output and error streams to the console
    PrintStream out = new PrintStream(new OutputStream() {
        @Override
        public void write(int b) {
            console.append(String.valueOf((char) b));
        }
    });
    System.setOut(out);
    System.setErr(out);

    frame.pack();
    frame.setVisible(true);
  }
} */
//Offline Copy of GPT code (Console_Input)
/*
==================================================================
    JTextField input = new JTextField();
    frame.add(input, BorderLayout.PAGE_END);
    //(mod) the line below is redirecting the use for text inserted, does not represent listener that listen to the input
    String userInput = input.getText();

*/
//Offline Copy of GPT code(Misc)
/*
==================================================================
    public class Console {
        public static void main(String[] args) {
            JFrame frame = new JFrame("Console");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            JTextArea console = new JTextArea();
            console.setEditable(false);
            frame.add(console, BorderLayout.PAGE_START);

            JTextField input = new JTextField();
            frame.add(input, BorderLayout.PAGE_END);

            // redirect standard output and error streams to the console
            PrintStream out = new PrintStream(new OutputStream() {
                @Override
                public void write(int b) {
                    console.append(String.valueOf((char) b));
                }
            });
            System.setOut(out);
            System.setErr(out);

            //Add action listener to the JTextField
            input.addActionListener(e -> {
                String userInput = input.getText();
                console.append("\nUser input: " + userInput);
                // code to process user input
                input.setText("");
            });

            frame.pack();
            frame.setVisible(true);
        }
    }

*/
//Offline Copy of GPT code(Switch Scene)
/*
================================================
  public class SwitchScenes extends JFrame {
      private JPanel cards;
      private JTextField usernameField;
      private JTextArea console;

      public SwitchScenes() {
          super("Switch Scenes");
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setLayout(new BorderLayout());

          // create a JPanel to hold the cards
          cards = new JPanel(new CardLayout());
          add(cards, BorderLayout.CENTER);

          // create the "username" card
          JPanel usernameCard = new JPanel();
          usernameCard.setLayout(new BoxLayout(usernameCard, BoxLayout.Y_AXIS));
          JLabel usernameLabel = new JLabel("Enter your username:");
          usernameField = new JTextField();
          usernameCard.add(usernameLabel);
          usernameCard.add(usernameField);
          cards.add(usernameCard, "username");

          // create the "console" card
          JPanel consoleCard = new JPanel();
          consoleCard.setLayout(new BorderLayout());
          console = new JTextArea();
          console.setEditable(false);
          consoleCard.add(new JScrollPane(console), BorderLayout.CENTER);
          cards.add(consoleCard, "console");

          // create a button to switch to the "console" card
          JButton switchButton = new JButton("Go to console");
          switchButton.addActionListener(e -> {
              String username = usernameField.getText();
              console.append("Username: " + username + "\n");
              CardLayout cl = (CardLayout)(cards.getLayout());
              cl.show(cards, "console");
          });
          add(switchButton, BorderLayout.SOUTH);

          pack();
          setVisible(true);
      }

      public static void main(String[] args) {
          new SwitchScenes();
      }
  }
*/
//Offline Copy of GPT code(add fonts)
/*
===============================================
try {
    // Load the font file
    File fontFile = new File("path/to/font.ttf");
    Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    ge.registerFont(font);

    // Set the font for a JLabel
    JLabel label = new JLabel("Hello World!");
    label.setFont(font.deriveFont(24f));
} catch (IOException | FontFormatException e) {
    e.printStackTrace();
}

 */
