import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class ChangeAccount extends JPanel {
    private JLabel pageLabel;
    private JLabel accountSelectLabel;
    private JComboBox<String> accountSelectDropdown;
    private JButton okButton;
    private JButton cancelButton;

    public ChangeAccount(String[] accountNames) {
        setLayout(new MigLayout("", "[][]", "[]10[][]20[]"));

        // Page label
        pageLabel = new JLabel("Change Account");
        pageLabel.setFont(new Font("Arial", Font.BOLD, 15));

        // Account selection
        accountSelectLabel = new JLabel("Select account:");
        accountSelectDropdown = new JComboBox<>(accountNames);

        // Buttons
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");

        // Layout
        add(pageLabel, "cell 0 0");
        add(accountSelectLabel, "cell 0 1");
        add(accountSelectDropdown, "cell 0 2");
        add(okButton, "cell 0 3, split");
        add(cancelButton, "cell 1 3, split 2");
    }

    public void addOkListener(ActionListener okListener) {
        okButton.addActionListener(okListener);
    }
    
    public void addCancelListener(ActionListener cancelListener) {
        okButton.addActionListener(cancelListener);
    }
}