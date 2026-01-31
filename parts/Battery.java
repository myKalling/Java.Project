package parts;

public class Battery {
    // capacity in kWh and voltage
    private double capacity;
    private double voltage;

    // Constructor
    public Battery(double capacity, double voltage) {
        setCapacity(capacity);
        setVoltage(voltage);
    }

    // Getters
    public double getCapacity() {
        return capacity;
    }

    public double getVoltage() {
        return voltage;
    }

    // Setters
    public void setCapacity(double capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Battery capacity must be a positive number.");
        }
        this.capacity = capacity;
    }

    public void setVoltage(double voltage) {
        if (voltage <= 0) {
            throw new IllegalArgumentException("Battery voltage must be a positive number.");
        }
        this.voltage = voltage;
    }

    @Override
    public String toString() {
        return "Battery{capacity=" + capacity + ", voltage=" + voltage + "}";
    }
    
}
