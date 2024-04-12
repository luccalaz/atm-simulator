import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class MainMenu extends JPanel {
    private Model model;
    private JLabel selectedAccountLabel;
    private JLabel accountBalanceLabel;
    private JScrollPane transactionsScroll;
    private JTextArea transactionsArea;
    private JButton changeAccountButton;
    private JButton deleteAccountButton;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton saveAndQuitButton;

    public MainMenu(Model myModel) {
        model = myModel;
        setLayout(new MigLayout("", "[grow][grow]", "[]20[]20[][][]"));

        // Account info
        selectedAccountLabel = new JLabel("Savings Account");
        selectedAccountLabel.setFont(new Font("Arial", Font.BOLD, 15));
        accountBalanceLabel = new JLabel("Airmiles: 10  |  $0,00");
        accountBalanceLabel.setFont(new Font("Arial", Font.BOLD, 15));

        // Transactions
        transactionsArea = new JTextArea();
        transactionsArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        transactionsArea.setFont(new Font("Arial", Font.PLAIN, 12));
        transactionsArea.setEditable(false);
        transactionsScroll = new JScrollPane(transactionsArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Buttons
        changeAccountButton = new JButton("Change Account");
        deleteAccountButton = new JButton("Delete Account");
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        saveAndQuitButton = new JButton("Save & Quit");

        // Layout
        add(selectedAccountLabel, "cell 0 0");
        add(accountBalanceLabel, "cell 1 0, alignx right");
        add(transactionsScroll, "cell 0 1, height 200, span, grow");
        add(changeAccountButton, "cell 0 2, width 200, alignx center");
        add(deleteAccountButton, "cell 0 3, width 200, alignx center");
        add(depositButton, "cell 1 2, width 200, alignx center");
        add(withdrawButton, "cell 1 3, width 200, alignx center");
        add(saveAndQuitButton, "cell 0 4, span, width 400, alignx center");

        transactionsArea.setText("No transactions yet.");
    }

    public void update() {
        selectedAccountLabel.setText(model.getSelectedAccount().getName());

        if (model.getSelectedAccount() instanceof SavingsAccount) {
            System.out.println("Savings");
            accountBalanceLabel.setText("$" + String.format("%.2f", model.getSelectedAccount().getBalance()));
        } else if (model.getSelectedAccount() instanceof AirmilesSavingsAccount) {
            System.out.println("Airmiles");
            AirmilesSavingsAccount selectedAccount = (AirmilesSavingsAccount) model.getSelectedAccount();
            accountBalanceLabel.setText("Airmiles: " + selectedAccount.getAirmiles() + "  |  $" + String.format("%.2f", model.getSelectedAccount().getBalance()));
        }

        transactionsArea.setText(model.getSelectedAccount().getTransactions());
        if (model.getSelectedAccount().getTransactions().length() == 0) transactionsArea.setText("No transactions yet.");
    }

    public void addChangeAccountListener(ActionListener changeAccountListener) {
        changeAccountButton.addActionListener(changeAccountListener);
    }

    public void addDeleteAccountListener(ActionListener deleteAccountListener) {
        deleteAccountButton.addActionListener(deleteAccountListener);
    }

    public void addDepositListener(ActionListener depositListener) {
        depositButton.addActionListener(depositListener);
    }

    public void addWithdrawListener(ActionListener withdrawListener) {
        withdrawButton.addActionListener(withdrawListener);
    }

    public void addSaveListener(ActionListener saveListener) {
        saveAndQuitButton.addActionListener(saveListener);
    }
}