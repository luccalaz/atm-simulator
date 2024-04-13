public class App {
    public static void main(String[] args) {
        // initialize window (JFrame)
        Window window = new Window();

        // initialize model
        Model model = new Model();

        // initialize views
        MainMenu mainMenu = new MainMenu(model);
        CreateAccount createAccount = new CreateAccount(model);
        ChangeAccount changeAccount = new ChangeAccount(model);
        DeleteAccount deleteAccount = new DeleteAccount(model);
        Deposit deposit = new Deposit(model);
        Withdraw withdraw = new Withdraw(model);

        // initialize controller
        new Controller(model, window, mainMenu, createAccount, changeAccount, deleteAccount, deposit, withdraw);
    }
}