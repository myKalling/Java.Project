package parts;

public class Wheel {
    // size or pressure
    private double size;
    private double pressure;

    // Constructor
    public Wheel(double size, double pressure) {
        setSize(size);
        setPressure(pressure);
    }

    // Getters
    public double getSize() {
        return size;
    }

    public double getPressure() {
        return pressure;
    }

    // Setters
    public void setSize(double size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Wheel size must be a positive number.");
        }
        this.size = size;
    }

    public void setPressure(double pressure) {
        if (pressure < 0) {
            throw new IllegalArgumentException("Wheel pressure cannot be negative.");
        }
        this.pressure = pressure;
    }

    @Override
    public String toString() {
        return "Wheel{size=" + size + ", pressure=" + pressure + "}";
    }


}
