public abstract class Account {
    protected String owner;
    protected double balance;

    public Account(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(owner + " deposited $" + amount + ". New balance: $" + balance);
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(owner + " withdrew $" + amount + ". New balance: $" + balance);
            return true;
        } else {
            System.out.println("Withdrawal failed. Insufficient funds.");
            return false;
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getOwner() {
        return owner;
    }

    // Hook method for subclasses to apply their own behaviors
    public abstract void applyMonthlyFees();

    public abstract void displayAccountInfo();
}