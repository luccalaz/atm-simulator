import javax.swing.*;

public class Window extends JFrame {
    // ------------------------------------------------------------ constructor method
    public Window() {
        // Set up JFrame
        setTitle("ATM Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setResizable(false);
        setVisible(true);
    }

    // ------------------------------------------------------------ public methods
    public void switchPanel(JPanel panel) {
        getContentPane().removeAll();
        getContentPane().add(panel);
        getContentPane().revalidate();
        getContentPane().repaint();  
    }
}
