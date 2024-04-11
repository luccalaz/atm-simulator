import java.util.ArrayList;

public abstract class Account {
    public final static byte SUCCESS = 1;
    public final static byte ERROR = 0;

    private String description;
    private double balance;
    private double fee;
    private String transactionReport;
    private ArrayList<Transaction> transactions;

    public Account(String desc, double initialDeposit, double accountFee) {
        description = desc;
        balance = initialDeposit;
        fee = accountFee;
        transactionReport = "";
        transactions = new ArrayList<>();
    }

    public void deposit(double amount, String description) {
        balance += amount;
        transactions.add(new Transaction(description, amount));
    }

    public byte withdraw(double amount, String description) {
        amount += fee;
        if (balance - amount > 0) {
            balance -= amount;
            transactions.add(new Transaction(description, amount * -1));
            return SUCCESS;
        }
        return ERROR;
    }

    public void setFee(double accountFee) {
        fee = accountFee;
    }

    public double getBalance() {
        return balance;
    }

    public String getDescription() {
        return description;
    }

    public String getTransactions() {
        transactions.forEach(transaction -> {
            transactionReport = transactionReport + transaction.getTransaction() + "\n";
        });
        return transactionReport;
    }
}
