public class CheckingAccount extends Account {
    private static final double TRANSACTION_FEE = 0.50;
    private InterestStrategy feeStrategy;

    public CheckingAccount(String owner, double balance) {
        super(owner, balance);
    }

    @Override
    public boolean withdraw(double amount) {
        double totalDebit = amount + TRANSACTION_FEE;
        if (totalDebit <= balance) {
            balance -= totalDebit;
            System.out.println(owner + " withdrew $" + amount + " (+ $" + TRANSACTION_FEE + " fee). New balance: $" + balance);
            return true;
        } else {
            System.out.println("Withdrawal failed. Insufficient funds for withdrawal + fee.");
            return false;
        }
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount); // No fee on deposits
    }

    @Override
    public void applyMonthlyFees() {
        // Checking account fees are applied per transaction
        System.out.println(owner + "'s monthly fees already applied per transaction.");
    }

    @Override
    public void displayAccountInfo() {
        System.out.println("[CHECKING] " + owner + " | Balance: $" + balance + " | Fee per transaction: $" + TRANSACTION_FEE);
    }
}