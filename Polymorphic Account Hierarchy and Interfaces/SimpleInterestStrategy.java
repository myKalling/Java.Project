public class SimpleInterestStrategy implements InterestStrategy {
    private double rate; // annual rate as decimal (e.g., 0.02 for 2%)

    public SimpleInterestStrategy(double rate) {
        this.rate = rate;
    }

    @Override
    public double calculate(double balance) {
        return balance * rate / 12; // monthly interest
    }

    public String getName() {
        return "Simple Interest (" + (rate * 100) + "%)";
    }
}