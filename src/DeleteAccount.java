import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class DeleteAccount extends JPanel {
    private Model model;
    private JLabel pageLabel;
    private JLabel questionLabel;
    private JButton yesButton;
    private JButton noButton;

    public DeleteAccount(Model myModel) {
        model = myModel;
        setLayout(new MigLayout("", "[][]", "[]10[][]"));

        // Page label
        pageLabel = new JLabel("Delete Account");
        pageLabel.setFont(new Font("Arial", Font.BOLD, 15));

        // Delete question
        questionLabel = new JLabel("");

        // Buttons
        yesButton = new JButton("Yes");
        noButton = new JButton("No");

        // Layout
        add(pageLabel, "cell 0 0");
        add(questionLabel, "cell 0 1");
        add(yesButton, "cell 0 2, split");
        add(noButton, "cell 1 3, split 2");
    }

    public void setAccountName(String name) {
        questionLabel.setText("Delete " + name + "?");
    }

    public void addYesListener(ActionListener yesListener) {
        yesButton.addActionListener(yesListener);
    }
    
    public void addNoListener(ActionListener noListener) {
        noButton.addActionListener(noListener);
    }
}