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
}
