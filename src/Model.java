import java.util.ArrayList;

public class Model {
    public final static byte SAVINGS_ACCOUNT = 0;
    public final static byte AIRMILES_SAVINGS_ACCOUNT = 1;

    public final static double SAVINGS_ACCOUNT_FEE = 0.5;
    public final static double AIRMILES_SAVINGS_ACCOUNT_FEE = 0.75;

    private ArrayList<Account> accounts;
    private int selectedAccount;

    @SuppressWarnings("unchecked")
    public Model() {
        accounts = (ArrayList<Account>) FileManager.getInstance().load("saveData.dat");
        if (accounts == null) accounts = new ArrayList<>();
    }

    public void selectAccount(int index) {
        selectedAccount = index;
    }

    public Account getSelectedAccount() {
        return accounts.get(selectedAccount);
    }

    public void createAccount(byte accountType, String description, double initialDeposit) {
        if (accountType == SAVINGS_ACCOUNT) accounts.add(new SavingsAccount(description, initialDeposit, SAVINGS_ACCOUNT_FEE));
        if (accountType == AIRMILES_SAVINGS_ACCOUNT) accounts.add(new SavingsAccount(description, initialDeposit, AIRMILES_SAVINGS_ACCOUNT_FEE));
        selectedAccount = accounts.size() - 1;
    }

    public void deleteAccount() {
        accounts.remove(selectedAccount);
        selectedAccount = 0;
    }

    public void save() {
        FileManager.getInstance().save("saveData.dat", accounts);
    }
}
