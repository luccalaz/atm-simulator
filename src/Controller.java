import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Controller {
    private Model model;
    private MainMenu mainMenu;
    private CreateAccount createAccount;
    private ChangeAccount changeAccount;
    private DeleteAccount deleteAccount;
    private Deposit deposit;
    private Withdraw withdraw;

    public Controller(Model myModel, View view) {
        model = myModel;

        // set up main menu
        mainMenu = new MainMenu();
        mainMenu.addChangeAccountListener((ActionEvent e) -> {
            changeAccount.setAccounts(model.getAccountNames());
            view.switchPanel(changeAccount);
        });
        mainMenu.addDeleteAccountListener((ActionEvent e) -> {
            deleteAccount.setAccountName(model.getSelectedAccount().getName());
            view.switchPanel(deleteAccount);
        });
        mainMenu.addDepositListener((ActionEvent e) -> {
            view.switchPanel(deposit);
        });
        mainMenu.addWithdrawListener((ActionEvent e) -> {
            view.switchPanel(withdraw);
        });
        mainMenu.addSaveListener((ActionEvent e) -> {
            System.out.println("save");
        });

        // set up create account
        createAccount = new CreateAccount();
        createAccount.addOkListener((ActionEvent e) -> {
            model.accounts = new ArrayList<>();
            System.out.println(model.accounts == null);
            if (createAccount.validateFields()) {
                System.out.println("pass");
                model.createAccount(createAccount.getAccountType(), createAccount.getAccountName(), createAccount.getInitialBalance());
                createAccount.getCancelButton().setEnabled(true);
                mainMenu.setAccountName(model.getSelectedAccount().getName());
                mainMenu.setAccountBalance(model.getSelectedAccount().getBalance(), -1);
                mainMenu.setTransactions(model.getSelectedAccount().getTransactions());
                view.switchPanel(mainMenu);
            }
        });
        createAccount.addCancelListener((ActionEvent e) -> {
            view.switchPanel(mainMenu);
        });

        changeAccount = new ChangeAccount();
        changeAccount.addCancelListener((ActionEvent e) -> {
            System.out.println("cancel");
            view.switchPanel(mainMenu);
        });
        deleteAccount = new DeleteAccount();
        deposit = new Deposit();
        withdraw = new Withdraw();

        if (model.load() == Model.ERROR) {
            createAccount.getCancelButton().setEnabled(false);
            view.switchPanel(createAccount);
        } else {
            view.switchPanel(mainMenu);
        }
    }
}
