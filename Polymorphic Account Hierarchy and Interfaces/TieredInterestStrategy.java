public class TieredInterestStrategy implements InterestStrategy {
    // Higher balances earn higher rates
    @Override
    public double calculate(double balance) {
        double rate;
        if (balance >= 10000) {
            rate = 0.05; // 5% annually
        } else if (balance >= 5000) {
            rate = 0.03; // 3% annually
        } else {
            rate = 0.01; // 1% annually
        }
        return balance * rate / 12; // monthly interest
    }

    public String getName() {
        return "Tiered Interest (1-5% based on balance)";
    }
}