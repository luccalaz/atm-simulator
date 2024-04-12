import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class ChangeAccount extends JPanel {
    private Model model;
    private JLabel pageLabel;
    private JLabel accountSelectLabel;
    private JComboBox<String> accountSelectDropdown;
    private JButton createAccountButton;
    private JButton okButton;
    private JButton cancelButton;

    public ChangeAccount(Model myModel) {
        model = myModel;
        setLayout(new MigLayout("", "[][]", "[]10[][]10[][]"));

        // Page label
        pageLabel = new JLabel("Change Account");
        pageLabel.setFont(new Font("Arial", Font.BOLD, 15));

        // Account selection
        accountSelectLabel = new JLabel("Select account:");
        accountSelectDropdown = new JComboBox<>();
        accountSelectDropdown.setSize(100, 0);

        // Buttons
        createAccountButton = new JButton("Create New Account");
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");

        // Layout
        add(pageLabel, "cell 0 0");
        add(accountSelectLabel, "cell 0 1");
        add(accountSelectDropdown, "cell 0 2");
        add(createAccountButton, "cell 0 3, width 207");
        add(okButton, "cell 0 4, width 100, split");
        add(cancelButton, "cell 1 4, width 100, split 2");
    }

    public void setAccounts(String[] accounts) {
        accountSelectDropdown.removeAllItems();
        for (String account: accounts) {
            accountSelectDropdown.addItem(account);
        }
    }

    public int getSelectedAccount() {
        return accountSelectDropdown.getSelectedIndex();
    }

    public void addCreateAccountListener(ActionListener createAccountListener) {
        createAccountButton.addActionListener(createAccountListener);
    }

    public void addOkListener(ActionListener okListener) {
        okButton.addActionListener(okListener);
    }
    
    public void addCancelListener(ActionListener cancelListener) {
        cancelButton.addActionListener(cancelListener);
    }
}