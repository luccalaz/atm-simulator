public class App {
    public static void main(String[] args) {
        Window window = new Window();

        Model model = new Model();
        MainMenu mainMenu = new MainMenu(model);
        CreateAccount createAccount = new CreateAccount(model);
        ChangeAccount changeAccount = new ChangeAccount(model);
        DeleteAccount deleteAccount = new DeleteAccount(model);
        Deposit deposit = new Deposit(model);
        Withdraw withdraw = new Withdraw(model);
        Controller controller = new Controller(model, window, mainMenu, createAccount, changeAccount, deleteAccount, deposit, withdraw);
    }
}