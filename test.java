import javax.swing.*;
import java.awt.*;
import java.io.*;

public class test{
    /*
    public static void main(String[] args){
        String text= "-";
        System.out.println(text);
    }*/
    //This is testing the switch scene that ChatGPT provide used to understand how it works
    /*
    public class SwitchScenes extends JFrame {
        private JPanel cards;
        private JTextField usernameField;
        private JTextArea console;
        public SwitchScenes(){
            super("Switch Scenes");
        }
        public void main(String[] args) {

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
    }*/
    //This is testing the console that ChatGPT provide use to understand how it works

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

    //this is a demostration chatGPT about borderlayout in buttons?
    /*
    public static void main(String[] args){

        JFrame frame = new JFrame("My Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize);
        frame.setLayout(new BorderLayout());

        JButton button1 = new JButton("North");
        frame.add(button1, BorderLayout.NORTH);

        JButton button2 = new JButton("West");
        frame.add(button2, BorderLayout.WEST);

        JButton button3 = new JButton("Center");
        frame.add(button3, BorderLayout.CENTER);

        JButton button4 = new JButton("East");
        frame.add(button4, BorderLayout.EAST);

        JButton button5 = new JButton("South");
        frame.add(button5, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }*/

}