public class SavingsAccount extends Account {
    private static final int WITHDRAWAL_LIMIT = 3;
    private int withdrawalsThisMonth;
    private InterestStrategy interestStrategy;
    private static final double EXCESS_WITHDRAWAL_FEE = 5.0;

    public SavingsAccount(String owner, double balance, InterestStrategy interestStrategy) {
        super(owner, balance);
        this.interestStrategy = interestStrategy;
        this.withdrawalsThisMonth = 0;
    }

    @Override
    public boolean withdraw(double amount) {
        if (withdrawalsThisMonth >= WITHDRAWAL_LIMIT) {
            System.out.println("Monthly withdrawal limit (" + WITHDRAWAL_LIMIT + ") exceeded.");
            return false;
        }
        withdrawalsThisMonth++;
        return super.withdraw(amount);
    }

    public void applyInterest() {
        double interest = interestStrategy.calculate(balance);
        balance += interest;
        System.out.println(owner + " earned $" + String.format("%.2f", interest) + " interest. New balance: $" + balance);
    }

    @Override
    public void applyMonthlyFees() {
        int excessWithdrawals = Math.max(0, withdrawalsThisMonth - WITHDRAWAL_LIMIT);
        double totalFees = excessWithdrawals * EXCESS_WITHDRAWAL_FEE;
        if (totalFees > 0) {
            balance -= totalFees;
            System.out.println(owner + " charged $" + totalFees + " for excess withdrawals.");
        }
        withdrawalsThisMonth = 0; // reset for next month
    }

    public void setInterestStrategy(InterestStrategy strategy) {
        this.interestStrategy = strategy;
    }

    @Override
    public void displayAccountInfo() {
        System.out.println("[SAVINGS] " + owner + " | Balance: $" + balance + " | Strategy: " + interestStrategy.getClass().getSimpleName());
    }
}