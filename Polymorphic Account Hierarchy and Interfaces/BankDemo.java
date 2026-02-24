import java.util.ArrayList;

public class BankDemo {
    public static void main(String[] args) {
        System.out.println("=== BANK ACCOUNT SYSTEM DEMO ===\n");

        // Create strategy instances
        SimpleInterestStrategy simpleInterest = new SimpleInterestStrategy(0.02);
        TieredInterestStrategy tieredInterest = new TieredInterestStrategy();

        // Create accounts with different strategies
        SavingsAccount savingsAccount = new SavingsAccount("Alice", 5000, simpleInterest);
        CheckingAccount checkingAccount = new CheckingAccount("Bob", 3000);

        System.out.println("--- Initial Account Information ---");
        savingsAccount.displayAccountInfo();
        checkingAccount.displayAccountInfo();
        System.out.println();

        // Demonstrate polymorphism: use ArrayList<Account>
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(savingsAccount);
        accounts.add(checkingAccount);

        System.out.println("--- Polymorphic Operations ---");
        // Both account types respond appropriately to the same methods
        for (Account account : accounts) {
            account.deposit(500);
        }
        System.out.println();

        for (Account account : accounts) {
            account.withdraw(100);
        }
        System.out.println();

        // Demonstrate Strategy Pattern: Simple Interest
        System.out.println("--- Applying Simple Interest Strategy ---");
        savingsAccount.applyInterest();
        System.out.println();

        // Demonstrate Strategy Swapping at Runtime
        // OPEN/CLOSED PRINCIPLE: We can add new strategies without modifying Account classes.
        // New behavior is injected at runtime, allowing the account to remain closed for modification
        // but open for extension through new strategy implementations.
        System.out.println("--- Switching to Tiered Interest Strategy ---");
        savingsAccount.setInterestStrategy(tieredInterest);
        savingsAccount.applyInterest();
        System.out.println();

        // More transactions to show different behaviors
        System.out.println("--- Additional Transactions ---");
        savingsAccount.withdraw(200);
        savingsAccount.withdraw(300);
        checkingAccount.withdraw(500);
        System.out.println();

        // Apply monthly fees
        System.out.println("--- Applying Monthly Fees ---");
        savingsAccount.applyMonthlyFees();
        checkingAccount.applyMonthlyFees();
        System.out.println();

        // Final account info
        System.out.println("--- Final Account Information ---");
        savingsAccount.displayAccountInfo();
        checkingAccount.displayAccountInfo();
        System.out.println("\nFinal Balances:");
        System.out.println("Alice: $" + savingsAccount.getBalance());
        System.out.println("Bob: $" + checkingAccount.getBalance());
    }
}