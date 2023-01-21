
import java.awt.*;
import javax.swing.*;
import java.io.*;



public class GUI {
  private static JPanel username_Layout =  new JPanel();
  public static String Player1_Name = "Player 1";
  public static String Player2_Name = "Player 2";
  private static JFrame frame = new JFrame("Connect 4, By Brayden & Hanna");
  public static void main(String[] args)
  {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JPanel main_Panel =  new JPanel(new CardLayout());
    setup_Username_Layout();

    //Adds the username_Layout to the main layout
    main_Panel.add(username_Layout, BorderLayout.CENTER);
    main_Panel.setLocation(frame.getHeight()/2,frame.getWidth()/2);

    //add the main_panel(one that allow switching scene) to the JFrame
    frame.add(main_Panel,BorderLayout.CENTER);
    frame.pack();
    //set the position of the frame to center of the screen
    frame.setLocation((screenSize.width/2)-(frame.getWidth()/2),(screenSize.height/2)-(frame.getHeight()/2));
    frame.setResizable(false);
    frame.setVisible(true);
  }
    /**
     * This method is used to setup the username "card" so that it make switching from the main user interface to the Console
     */
    public static void setup_Username_Layout(){

      JPanel username =  new JPanel();
      //This is used to set up the left side(text) of the username layout
      JPanel left_Side = new JPanel();
      left_Side.setLayout(new BoxLayout(left_Side, BoxLayout.Y_AXIS));
      JLabel player1_L = new JLabel("Player 1:");
      player1_L.setFont(new Font("Arial",Font.PLAIN,30/**(1+(username_Layout.getHeight()/10))*/));
      JLabel player2_L= new JLabel("Player 2:");
      player2_L.setFont(new Font("Arial",Font.PLAIN,30/**(1+(username_Layout.getHeight()/10))*/));
      left_Side.add(player1_L);
      left_Side.add(player2_L);
      username.add(left_Side);

      //This is used to set up the right side (text field) of the username layout
      JPanel right_Side =  new JPanel();
      right_Side.setLayout(new BoxLayout(right_Side,BoxLayout.Y_AXIS));
      JTextField player1_T = new JTextField("Insert your name");
      player1_T.setFont(new Font("Arial",Font.PLAIN,25));
      player1_T.setSize(250, 25);
      //line below is for experimental purpose, not supposed to be implemented to code
      //player1_T.setMaximumSize(new Dimension(250/**(1+(username_Layout.getWidth()/25))*/,30/**(1+(username_Layout.getHeight()/25))*/));
      JTextField player2_T = new JTextField("Insert your name");
      player2_T.setFont(new Font("Arial",Font.PLAIN,25));
      player2_T.setSize(250,25);
      //line below is for experimental purpose, not supposed to be implemented to code
      //player2_T.setMaximumSize(new Dimension(250/**(1+(username_Layout.getWidth()/25))*/,30/**(1+(username_Layout.getHeight()/25))*/));
      right_Side.add(player1_T);
      right_Side.add(player2_T);
      username.add(right_Side);

      //This added image to the panel
      ImageIcon icon =  new ImageIcon("Connect 4 Icon.png");
      Image icon_Image = (icon.getImage()).getScaledInstance((int)(icon.getIconHeight()*(0.30)),(int)(icon.getIconWidth()*(0.30)),Image.SCALE_SMOOTH);
      icon = new ImageIcon(icon_Image);
      JLabel game_Icon_TitleScreen = new JLabel(icon);
      game_Icon_TitleScreen.setSize((frame.getWidth()/100),(frame.getHeight()/100));
      username_Layout.setLayout(new BorderLayout());
      username_Layout.add(game_Icon_TitleScreen, BorderLayout.NORTH);
      username_Layout.add(username,BorderLayout.CENTER);
}


/* offline save of GPT code
//==========================================================================
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
}
//===================================================
    JTextArea console = new JTextArea();
    console.setEditable(false);

        PrintStream out = new PrintStream(new OutputStream() {
            @Override
            public void write(int b) {
                console.append(String.valueOf((char) b));
            }
        });

    System.setOut(out);
    System.setErr(out);

    JTextField input = new JTextField();
    frame.add(input, BorderLayout.PAGE_END);

    String userInput = input.getText();




    //============================================================
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
}

