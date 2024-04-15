import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class Withdraw extends JPanel {
    // ------------------------------------------------------------ variable initialization
    private Model model;
    private JLabel pageLabel;
    private JLabel amountLabel;
    private JTextField amountText;
    private JLabel descriptionLabel;
    private JTextField descriptionText;
    private JLabel errorLabel;
    private JButton okButton;
    private JButton cancelButton;
    private TextFieldValidator amountCheck;
    private TextFieldValidator descriptionCheck;

    // ------------------------------------------------------------ constructor method
    public Withdraw(Model myModel) {
        model = myModel;
        setLayout(new MigLayout("", "[][]", "[]10[][]10[][]10[][]"));

        // Page label
        pageLabel = new JLabel("Withdraw");
        pageLabel.setFont(new Font("Arial", Font.BOLD, 15));

        // Amount
        amountLabel = new JLabel("Amount:");
        amountText = new JTextField(10);

        // Description
        descriptionLabel = new JLabel("Transaction Description:");
        descriptionText = new JTextField(20);

        // Buttons
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");

        // Error label
        errorLabel = new JLabel(" ");
        errorLabel.setForeground(Color.RED);

        // Layout
        add(pageLabel, "cell 0 0");
        add(amountLabel, "cell 0 1");
        add(amountText, "cell 0 2");
        add(descriptionLabel, "cell 0 3");
        add(descriptionText, "cell 0 4");
        add(errorLabel, "cell 0 5");
        add(okButton, "cell 0 6, split");
        add(cancelButton, "cell 1 6, split 2");

        // initialize validators
        amountCheck = new TextFieldValidator(amountText, "^(?!0+(\\.00?)?$)\\d+(\\.\\d{1,2})?$", Color.RED);
        descriptionCheck = new TextFieldValidator(descriptionText, "^[A-Za-z ]{1,27}$", Color.RED);
    }

    // ------------------------------------------------------------ gets/sets
    public double getAmount() {
        return Double.parseDouble(amountText.getText());
    }

    public String getDescription() {
        return descriptionText.getText();
    }

    // ------------------------------------------------------------ public methods
    public boolean validateFields() {
        errorLabel.setText(" ");
        amountCheck.reset();
        descriptionCheck.reset();
        if (!amountCheck.check()) errorLabel.setText("Invalid amount.");
        if (!descriptionCheck.check()) errorLabel.setText("Invalid description.");
        if (!amountCheck.check() && !descriptionCheck.check()) errorLabel.setText("Invalid input.");
        return amountCheck.check() && descriptionCheck.check();
    }

    public void reset() {
        errorLabel.setText(" ");
        amountCheck.reset();
        descriptionCheck.reset();
        amountText.setText("");
        descriptionText.setText("");
    }

    public void addOkListener(ActionListener okListener) {
        okButton.addActionListener(okListener);
    }
    
    public void addCancelListener(ActionListener cancelListener) {
        cancelButton.addActionListener(cancelListener);
    }
}