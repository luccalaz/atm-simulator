public class AirmilesSavingsAccount extends Account {
    private String report;
    private int airmiles;

    public AirmilesSavingsAccount(String desc, double initialDeposit, double accountFee) {
        super(desc, initialDeposit, accountFee);
        airmiles = 10;
        while (initialDeposit >= 30.00) {
            initialDeposit -= 30;
            airmiles++;
        }
    }

    public void deposit(double amount, String description) {
        super.deposit(amount, description);
        while (amount >= 30.00) {
            amount -= 30;
            airmiles++;
        }
    }

    public int getAirmiles() {
        return airmiles;
    }

    public String getReport() {
        report = "Account Type: Airmiles Savings Account\n";
        report += "Account Description: " + super.getDescription() + "\n";
        report += "Current Airmiles: " + getAirmiles() + "\n";
        report += "Current Balance: " + super.getBalance() + "\n";
        report += super.getTransactions();
        return report;
    }
}