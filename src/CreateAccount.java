import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class CreateAccount extends JPanel {
    private Model model;
    private JLabel pageLabel;
    private JLabel accountNameLabel;
    private JTextField accountNameText;
    private JLabel accountTypeLabel;
    private JComboBox<String> accountTypeDropdown;
    private JLabel initialBalanceLabel;
    private JTextField initialBalanceText;
    private JButton okButton;
    private JButton cancelButton;

    TextFieldValidator accountNameCheck;
    TextFieldValidator initialBalanceCheck;

    public CreateAccount(Model myModel) {
        model = myModel;
        setLayout(new MigLayout("", "[][]", "[]10[][]10[][]10[][]20[]"));

        // Page label
        pageLabel = new JLabel("Create Account");
        pageLabel.setFont(new Font("Arial", Font.BOLD, 15));

        // Account name
        accountNameLabel = new JLabel("Account name:");
        accountNameText = new JTextField(20);

        // Initial balance
        initialBalanceLabel = new JLabel("Initial balance:");
        initialBalanceText = new JTextField(10);

        // Account type
        String accountTypes[] = {"Savings Account", "Airmiles Savings Account"};
        accountTypeLabel = new JLabel("Account type:");
        accountTypeDropdown = new JComboBox<>(accountTypes);

        // Buttons
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");

        // Layout
        add(pageLabel, "cell 0 0");
        add(accountNameLabel, "cell 0 1");
        add(accountNameText, "cell 0 2");
        add(initialBalanceLabel, "cell 0 3");
        add(initialBalanceText, "cell 0 4");
        add(accountTypeLabel, "cell 0 5");
        add(accountTypeDropdown, "cell 0 6");
        add(okButton, "cell 0 7, split");
        add(cancelButton, "cell 1 7, split 2");
    }

    public boolean validateFields() {
        accountNameCheck = new TextFieldValidator(accountNameText, "^[A-Za-z ]{1,20}$", Color.RED);
        initialBalanceCheck = new TextFieldValidator(initialBalanceText, "^(?!0+(\\.00?)?$)\\d+(\\.\\d{1,2})?$", Color.RED);
        accountNameCheck.reset();
        accountNameCheck.check();
        initialBalanceCheck.reset();
        initialBalanceCheck.check();
        return accountNameCheck.check() && initialBalanceCheck.check();
    }

    public String getAccountName() {
        return accountNameText.getText();
    }

    public double getInitialBalance() {
        return Double.parseDouble(initialBalanceText.getText());
    }

    public byte getAccountType() {
        return (byte) accountTypeDropdown.getSelectedIndex();
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public void reset() {
        accountNameText.setText("");
        initialBalanceText.setText("");
        accountTypeDropdown.setSelectedIndex(0);
        cancelButton.setEnabled(true);
    }

    public void addOkListener(ActionListener okListener) {
        okButton.addActionListener(okListener);
    }
    
    public void addCancelListener(ActionListener cancelListener) {
        cancelButton.addActionListener(cancelListener);
    }
}