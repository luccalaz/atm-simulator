import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class Deposit extends JPanel {
    private Model model;
    private JLabel pageLabel;
    private JLabel amountLabel;
    private JTextField amountText;
    private JLabel descriptionLabel;
    private JTextField descriptionText;
    private JButton okButton;
    private JButton cancelButton;

    private TextFieldValidator amountCheck;
    private TextFieldValidator descriptionCheck;

    public Deposit(Model myModel) {
        model = myModel;
        setLayout(new MigLayout("", "[][]", "[]10[][]10[][]20[]"));

        // Page label
        pageLabel = new JLabel("Deposit");
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

        // Layout
        add(pageLabel, "cell 0 0");
        add(amountLabel, "cell 0 1");
        add(amountText, "cell 0 2");
        add(descriptionLabel, "cell 0 3");
        add(descriptionText, "cell 0 4");
        add(okButton, "cell 0 5, split");
        add(cancelButton, "cell 1 6, split 2");

        // initialize validators
        amountCheck = new TextFieldValidator(amountText, "^(?!0+(\\.00?)?$)\\d+(\\.\\d{1,2})?$", Color.RED);
        descriptionCheck = new TextFieldValidator(descriptionText, "^[A-Za-z ]{1,27}$", Color.RED);
    }

    public boolean validateFields() {
        amountCheck.reset();
        amountCheck.check();
        descriptionCheck.reset();
        descriptionCheck.check();
        return amountCheck.check() && descriptionCheck.check();
    }

    public void reset() {
        amountCheck.reset();
        descriptionCheck.reset();
        amountText.setText("");
        descriptionText.setText("");
    }

    public double getAmount() {
        return Double.parseDouble(amountText.getText());
    }

    public String getDescription() {
        return descriptionText.getText();
    }

    public void addOkListener(ActionListener okListener) {
        okButton.addActionListener(okListener);
    }
    
    public void addCancelListener(ActionListener cancelListener) {
        cancelButton.addActionListener(cancelListener);
    }
}