import java.util.ArrayList;

public class Model {
    public final static byte SAVINGS_ACCOUNT = 0;
    public final static byte AIRMILES_SAVINGS_ACCOUNT = 1;

    public final static double SAVINGS_ACCOUNT_FEE = 0.5;
    public final static double AIRMILES_SAVINGS_ACCOUNT_FEE = 0.75;

    public final static byte ERROR = 0;
    public final static byte SUCCESS = 1;

    private ArrayList<Account> accounts;
    private int selectedAccount;

    public Model() {
        accounts = new ArrayList<>();
    }

    public Account getSelectedAccount() {
        return accounts.get(selectedAccount);
    }

    public String[] getAccountNames() {
        ArrayList<String> accountNames = new ArrayList<>();
        accounts.forEach(account -> {
            accountNames.add(account.getName());
        });
        return accountNames.toArray(new String[accountNames.size()]);
    }

    public void selectAccount(int index) {
        selectedAccount = index;
    }

    public void createAccount(byte accountType, String name, double initialDeposit) {
        if (accountType == SAVINGS_ACCOUNT) {
            accounts.add(new SavingsAccount(name, initialDeposit, SAVINGS_ACCOUNT_FEE));
        }
        if (accountType == AIRMILES_SAVINGS_ACCOUNT) {
            accounts.add(new AirmilesSavingsAccount(name, initialDeposit, AIRMILES_SAVINGS_ACCOUNT_FEE));
        }
        selectedAccount = accounts.size() - 1;
    }

    public void deleteAccount() {
        accounts.remove(selectedAccount);
        selectedAccount = 0;
    }

    public void save() {
        FileManager.getInstance().save("saveData.dat", accounts);
    }

    @SuppressWarnings("unchecked")
    public void load() {
        accounts = (ArrayList<Account>) FileManager.getInstance().load("saveData.dat");
        if (accounts == null) accounts = new ArrayList<>();
    }
}
