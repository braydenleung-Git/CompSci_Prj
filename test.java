import javax.swing.*;
import java.awt.*;

public class test{
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
    }

}