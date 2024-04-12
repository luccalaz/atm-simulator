import javax.swing.*;

public class View extends JFrame {
    private Model model;

    public View(Model myModel) {
        model = myModel;

        // Set up JFrame
        setTitle("ATM Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setResizable(false);
        setVisible(true);
    }

    public void switchPanel(JPanel panel) {
        this.removeAll();
        this.add(panel);
    }
}
