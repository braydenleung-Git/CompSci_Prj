//set up all the prerequisites for the class
import java.awt.*;
import javax.swing.*;
import java.io.*;

public class GUI {
  public static String Player1_Name = "Player 1";
  public static String Player2_Name = "Player 2";
  private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  private static final JFrame frame = new JFrame("Connect 4, By Brayden & Hanna");
  private static final JPanel main_Panel = new JPanel(new CardLayout());
  private static final JPanel username_Layout = new JPanel();
  private static final JPanel console_Layout= new JPanel();
  public static String userInput = null;


  public static void main(String[] args) {
    //Set that when the user clicks cross button, it will kill the code
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setup_Username_Layout();

    //Adds the username_Layout to the main layout
    main_Panel.add(username_Layout,"Username");
    main_Panel.setLocation(frame.getHeight() / 2, frame.getWidth() / 2);
    main_Panel.add(console_Layout, "Console");
    //add the main_panel(one that allow switching scene) to the JFrame
    frame.add(main_Panel, BorderLayout.CENTER);
    frame.pack();
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
    player1_L.setFont(new Font("Arial", Font.PLAIN, 30/* *(1+(username_Layout.getHeight()/10)) */));
    JLabel player2_L = new JLabel("Player 2:");
    player2_L.setFont(new Font("Arial", Font.PLAIN, 30/* *(1+(username_Layout.getHeight()/10)) */));
    left_Side.add(player1_L);
    left_Side.add(player2_L);
    username.add(left_Side);

    //This is used to set up the right side (text field) of the username layout
    JPanel right_Side = new JPanel();
    right_Side.setLayout(new BoxLayout(right_Side, BoxLayout.Y_AXIS));
    JTextField player1_T = new JTextField("Insert your name");
    //This is used for turning the text input that the user put in the text box as the player name, by default it is set to "Player 1"
    player1_T.addActionListener(e -> {
      if (player1_T.getText() != null) {
        Player1_Name = player1_T.getText();
      }
    });
    player1_T.setFont(new Font("Arial", Font.PLAIN, 25));
    player1_T.setSize(250, 25);
    //line below is for experimental purpose, not supposed to be implemented to code
    //player1_T.setMaximumSize(new Dimension(250/**(1+(username_Layout.getWidth()/25))*/,30/**(1+(username_Layout.getHeight()/25))*/));
    JTextField player2_T = new JTextField("Insert your name");
    //This is used for turning the text input that the user put in the text box as the player name, by default it is set to "Player 2"
    player2_T.addActionListener(e -> {
      if (player2_T.getText() != null) {
        Player2_Name = player2_T.getText();
      }
    });
    player2_T.setFont(new Font("Arial", Font.PLAIN, 25));
    player2_T.setSize(250, 25);
    //line below is for experimental purpose, not supposed to be implemented to code
    //player2_T.setMaximumSize(new Dimension(250/**(1+(username_Layout.getWidth()/25))*/,30/**(1+(username_Layout.getHeight()/25))*/));
    right_Side.add(player1_T);
    right_Side.add(player2_T);
    username.add(right_Side);

    //This adds image to the panel
    ImageIcon icon = new ImageIcon("Connect 4 Icon.png");
    Image icon_Image = (icon.getImage()).getScaledInstance((int) (icon.getIconHeight() * (0.30)), (int) (icon.getIconWidth() * (0.30)), Image.SCALE_SMOOTH);
    icon = new ImageIcon(icon_Image);
    JLabel game_Icon_TitleScreen = new JLabel(icon);
    game_Icon_TitleScreen.setSize((frame.getWidth() / 100), (frame.getHeight() / 100));


    //This adds a button to start the game
    JButton start_Button =  new JButton("Click to Start Game!");
    start_Button.setFont(new Font("Arial", Font.PLAIN, 15));
    start_Button.addActionListener(e -> {
      CardLayout cl = (CardLayout)(main_Panel.getLayout());
      frame.setSize(screenSize);
      frame.setLocation(0,0);
      cl.show(main_Panel, "console");
    });


    //This adds the panels together as one
    username_Layout.setLayout(new BorderLayout());
    username_Layout.add(game_Icon_TitleScreen, BorderLayout.NORTH);
    username_Layout.add(username, BorderLayout.CENTER);
    username_Layout.add(start_Button,BorderLayout.SOUTH);
  }

  /**
   * This method is used to set up the console "Card" so that it makes switching between "cards" possible
   */
  public static void setup_Console_Layout() {

    console_Layout.setLayout(new BorderLayout());

    //Set up console out put to text area
    JTextArea console_Output = new JTextArea();
    console_Output.setEditable(false);
    PrintStream output = new PrintStream(new OutputStream() {
      @Override
      public void write(int b) {
        console_Output.append(String.valueOf((char) b));
      }
    });
    System.setOut(output);
    System.setErr(output);
    console_Output.setBackground(Color.black);
    console_Output.setFont(new Font(""));
    console_Layout.add(console_Output,BorderLayout.PAGE_START);

    //Set up console input to the text field
    JTextField console_Input = new JTextField();
    console_Input.addActionListener(e -> {
      if(console_Input.equals(null))
      {
        userInput = " ";
      }
      else
      {
        userInput = console_Input.getText();
        console_Input.setText("");
      }
    });
    console_Input.setBackground(Color.decode("242424"));
    console_Layout.add(console_Input,BorderLayout.PAGE_END);
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


