
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.io.*;



public class GUI {
  private static JPanel username_Layout =  new JPanel();
public static void main(String[] args)
{
  JFrame frame = new JFrame("Connect 4, By Brayden & Hanna");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  frame.setSize(screenSize);
  frame.setLocationRelativeTo(null);
  JPanel main_Panel =  new JPanel(new CardLayout());
  setup_Username_Layout();

  frame.add(main_Panel,BorderLayout.CENTER);
  main_Panel.add(username_Layout, BorderLayout.CENTER);
  frame.setVisible(true);
}
public static void setup_Username_Layout(){

//This is used to set up the left side(text) of the username layout
  JPanel left_Side = new JPanel();
  left_Side.setLayout(new BoxLayout(left_Side, BoxLayout.Y_AXIS));
  JLabel player1_L = new JLabel("Player 1:");
  player1_L.setFont(new Font("Arial",Font.PLAIN,25));
  JLabel player2_L= new JLabel("Player 2:");
  player2_L.setFont(new Font("Arial",Font.PLAIN,25));
  left_Side.add(player1_L);
  left_Side.add(player2_L);
  username_Layout.add(left_Side);
//This is used to set up the right side (text field) of the username layout
  JPanel right_Side =  new JPanel();
  right_Side.setLayout(new BoxLayout(right_Side,BoxLayout.Y_AXIS));
  JTextField player1_T = new JTextField("insert your name");
  player1_T.setMaximumSize(new Dimension(250,27));
  JTextField player2_T = new JTextField("Insert your name");
  player2_T.setMaximumSize(new Dimension(250,27));
  right_Side.add(player1_T);
  right_Side.add(player2_T);
  username_Layout.add(right_Side);
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

