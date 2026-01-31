package app;

public class Main {
    public static void main(String[] args) {
        try {
            // Ask user for engine details
            parts.Engine engine = new parts.Engine(250, "V6");

            // Ask user for wheel details
            parts.Wheel wheel1 = new parts.Wheel(18.0, 32.0);
            parts.Wheel wheel2 = new parts.Wheel(18.0, 32.0);
            parts.Wheel wheel3 = new parts.Wheel(18.0, 32.0);
            parts.Wheel wheel4 = new parts.Wheel(18.0, 32.0);
            parts.Wheel[] wheels = {wheel1, wheel2, wheel3, wheel4};

            // Create car
            Car car = new Car(engine, wheels);

            // Display car details
            System.out.println(car);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    
}
