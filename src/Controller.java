import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Controller {
    Model model;
    Window window;
    MainMenu mainMenu;
    CreateAccount createAccount;
    ChangeAccount changeAccount;
    DeleteAccount deleteAccount;
    Deposit deposit;
    Withdraw withdraw;

    public Controller(Model myModel, Window myWindow, MainMenu myMainMenu, CreateAccount myCreateAccount, ChangeAccount myChangeAccount, DeleteAccount myDeleteAccount, Deposit myDeposit, Withdraw myWithdraw) {
        model = myModel;
        window = myWindow;
        mainMenu = myMainMenu;
        createAccount = myCreateAccount;
        changeAccount = myChangeAccount;
        deleteAccount = myDeleteAccount;
        deposit = myDeposit;
        withdraw = myWithdraw;

        // set up main menu
        mainMenu.addChangeAccountListener((ActionEvent e) -> {
            changeAccount.setAccounts(model.getAccountNames());
            window.switchPanel(changeAccount);
        });
        mainMenu.addDeleteAccountListener((ActionEvent e) -> {
            deleteAccount.setAccountName(model.getSelectedAccount().getName());
            window.switchPanel(deleteAccount);
        });
        mainMenu.addDepositListener((ActionEvent e) -> {
            window.switchPanel(deposit);
        });
        mainMenu.addWithdrawListener((ActionEvent e) -> {
            window.switchPanel(withdraw);
        });
        mainMenu.addSaveListener((ActionEvent e) -> {
            model.save();
            window.dispose();
        });

        // set up create account
        createAccount.addOkListener((ActionEvent e) -> {
            if (createAccount.validateFields()) {
                model.createAccount(createAccount.getAccountType(), createAccount.getAccountName(), createAccount.getInitialBalance());
                createAccount.reset();
                mainMenu.update();
                window.switchPanel(mainMenu);
            }
        });
        createAccount.addCancelListener((ActionEvent e) -> {
            createAccount.reset();
            window.switchPanel(mainMenu);
        });

        changeAccount.addOkListener((ActionEvent e) -> {
            model.selectAccount(changeAccount.getSelectedAccount());
            mainMenu.update();
            window.switchPanel(mainMenu);
        });
        changeAccount.addCancelListener((ActionEvent e) -> {
            window.switchPanel(mainMenu);
        });
        changeAccount.addCreateAccountListener((ActionEvent e) -> {
            window.switchPanel(createAccount);
        });

        deleteAccount.addYesListener((ActionEvent e) -> {
            model.deleteAccount();
            if (model.getAccountNames().length == 0) {
                createAccount.getCancelButton().setEnabled(false);
                window.switchPanel(createAccount);
            } else {
                mainMenu.update();
                window.switchPanel(mainMenu);
            }
        });
        deleteAccount.addNoListener((ActionEvent e) -> {
            window.switchPanel(mainMenu);
        });

        deposit.addOkListener((ActionEvent e) -> {
            if (deposit.validateFields()) {
                model.getSelectedAccount().deposit(deposit.getAmount(), deposit.getDescription());
                deposit.reset();
                mainMenu.update();
                window.switchPanel(mainMenu);
            }
        });
        deposit.addCancelListener((ActionEvent e) -> {
            deposit.reset();
            window.switchPanel(mainMenu);
        });

        withdraw.addOkListener((ActionEvent e) -> {
            if (withdraw.validateFields()) {
                model.getSelectedAccount().withdraw(withdraw.getAmount(), withdraw.getDescription());
                withdraw.reset();
                mainMenu.update();
                window.switchPanel(mainMenu);
            }
        });
        withdraw.addCancelListener((ActionEvent e) -> {
            withdraw.reset();
            window.switchPanel(mainMenu);
        });

        model.load();

        if (model.getAccountNames().length == 0) {
            createAccount.getCancelButton().setEnabled(false);
            window.switchPanel(createAccount);
        } else {
            mainMenu.update();
            window.switchPanel(mainMenu);
        }
    }
}
