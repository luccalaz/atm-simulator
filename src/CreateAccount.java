import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class CreateAccount extends JPanel {
    // ------------------------------------------------------------ variable initialization
    private Model model;
    private JLabel pageLabel;
    private JLabel accountNameLabel;
    private JTextField accountNameText;
    private JLabel accountTypeLabel;
    private JComboBox<String> accountTypeDropdown;
    private JLabel initialBalanceLabel;
    private JTextField initialBalanceText;
    private JLabel errorLabel;
    private JButton okButton;
    private JButton cancelButton;
    private TextFieldValidator accountNameCheck;
    private TextFieldValidator initialBalanceCheck;

    // ------------------------------------------------------------ constructor method
    public CreateAccount(Model myModel) {
        model = myModel;
        setLayout(new MigLayout("", "[][]", "[]10[][]10[][]10[][]10[][]"));

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

        // Error label
        errorLabel = new JLabel(" ");
        errorLabel.setForeground(Color.RED);

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
        add(errorLabel, "cell 0 7");
        add(okButton, "cell 0 8, split");
        add(cancelButton, "cell 1 8, split 2");

        // Initialize validators
        accountNameCheck = new TextFieldValidator(accountNameText, "^[A-Za-z ]{1,20}$", Color.RED);
        initialBalanceCheck = new TextFieldValidator(initialBalanceText, "^(?!0+(\\.00?)?$)\\d{1,10}(\\.\\d{1,2})?$", Color.RED);
    }

    // ------------------------------------------------------------ gets/sets
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

    // ------------------------------------------------------------ public methods
    public boolean validateFields() {
        accountNameCheck.reset();
        initialBalanceCheck.reset();
        errorLabel.setText(" ");
        if (!accountNameCheck.check()) errorLabel.setText("Invalid account name.");
        if (!initialBalanceCheck.check()) errorLabel.setText("Invalid initial balance.");
        if (!accountNameCheck.check() && !initialBalanceCheck.check()) errorLabel.setText("Invalid input.");
        return accountNameCheck.check() && initialBalanceCheck.check();
    }

    public void reset() {
        errorLabel.setText(" ");
        accountNameCheck.reset();
        initialBalanceCheck.reset();
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