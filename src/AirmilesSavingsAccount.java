public class AirmilesSavingsAccount extends Account {
    // ------------------------------------------------------------ variable initialization
    private int airmiles;

    // ------------------------------------------------------------ constructor method
    public AirmilesSavingsAccount(String name, double initialDeposit, double accountFee) {
        super(name, initialDeposit, accountFee);
        airmiles = 10;
        while (initialDeposit >= 30.00) {
            initialDeposit -= 30;
            airmiles++;
        }
    }

    // ------------------------------------------------------------ gets/sets
    public int getAirmiles() {
        return airmiles;
    }
    
    // ------------------------------------------------------------ public methods
    public void deposit(double amount, String description) {
        super.deposit(amount, description);
        while (amount >= 30.00) {
            amount -= 30;
            airmiles++;
        }
    }
}