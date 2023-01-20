/*
import java.awt.*;
import javax.swing.*;
public class GUI {
    
public static void main(String[] args)
{
  JFrame frame = new JFrame("Connect 4, By Brayden & Hanna");
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  frame.setSize(screenSize);
  frame.setLocationRelativeTo(null);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  JPanel panel =  new JPanel();
  panel.setLayout(new FlowLayout());
  JLabel label = new JLabel("Test");
  ImageIcon icon = new ImageIcon("Icon.png");
  frame.setIconImage(icon.getImage());
  frame.add(panel);
  panel.add(label);
  frame.setVisible(true);
}

import java.awt.*;
import java.io.*;
import javax.swing.*;

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






    import java.awt.*;
    import java.io.*;
    import javax.swing.*;

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

*/