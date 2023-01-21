
import java.awt.*;
import javax.swing.*;
import java.io.*;
public class GUI {
    
public static void main(String[] args)
{
  JFrame frame = new JFrame("Connect 4, By Brayden & Hanna");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  frame.setSize(screenSize);
  frame.setLocationRelativeTo(null);
  JPanel main_Panel =  new JPanel();

  frame.setVisible(true);
  System.out.println("test");
}

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

}

