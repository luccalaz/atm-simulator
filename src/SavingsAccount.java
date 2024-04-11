public class SavingsAccount extends Account {
    private String report;

    public SavingsAccount(String desc, double initialDeposit, double accountFee) {
        super(desc, initialDeposit, accountFee);
    }

    public String getReport() {
        report = "Account Type: Savings Account\n";
        report += "Account Description: " + super.getDescription() + "\n";
        report += "Current Balance: " + super.getBalance() + "\n";
        report += super.getTransactions();
        return report;
    }
}