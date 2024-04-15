import javax.swing.*;

public class Window extends JFrame {
    // ------------------------------------------------------------ constructor method
    public Window() {
        // Set up JFrame
        setTitle("ATM Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    // ------------------------------------------------------------ public methods
    public void switchPanel(JPanel panel) {
        getContentPane().removeAll();
        getContentPane().add(panel);
        getContentPane().revalidate();
        getContentPane().repaint();  
    }

    // ------------------------------------------------------------ main method
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