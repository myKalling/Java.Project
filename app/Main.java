package app;

import java.util.Scanner;
import parts.Engine;
import parts.Wheel;
import parts.Battery;

public class Main {
    public static void main(String[] args) {
        // Precondition: Scanner is created and ready to read user input
        Scanner scanner = new Scanner(System.in);
        Engine engine = null;
        Wheel[] wheels = null;
        Battery battery = null;

        // Get Engine information
        // Precondition: engine is null
        // Postcondition: engine is a valid Engine object or program exits
        System.out.println("=== Creating Engine ===");
        while (engine == null) {
            try {
                System.out.print("Enter horsepower (positive number): ");
                int horsepower = Integer.parseInt(scanner.nextLine());
                
                System.out.print("Enter engine type (gasoline, diesel, electric, hybrid): ");
                String type = scanner.nextLine();
                
                engine = new Engine(horsepower, type);
                System.out.println("Engine created: " + engine.toString() + "\n");
            } catch (NumberFormatException e) {
                System.out.println("Error: Horsepower must be a valid integer.\n");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + "\n");
            }
        }

        // Get Wheel information
        // Precondition: wheels is null
        // Postcondition: wheels is a non-empty Wheel array with valid objects
        System.out.println("=== Creating Wheels ===");
        while (wheels == null) {
            try {
                System.out.print("Enter number of wheels: ");
                int wheelCount = Integer.parseInt(scanner.nextLine());
                
                if (wheelCount <= 0) {
                    System.out.println("Error: Number of wheels must be positive.\n");
                    continue;
                }
                
                wheels = new Wheel[wheelCount];
                for (int i = 0; i < wheelCount; i++) {
                    System.out.print("Enter size for wheel " + (i + 1) + ": ");
                    int size = Integer.parseInt(scanner.nextLine());
                    
                    System.out.print("Enter type for wheel " + (i + 1) + ": ");
                    String type = scanner.nextLine();
                    
                    wheels[i] = new Wheel(size, type);
                }
                System.out.println("Wheels created successfully.\n");
            } catch (NumberFormatException e) {
                System.out.println("Error: Input must be a valid number.\n");
                wheels = null;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + "\n");
                wheels = null;
            }
        }

        // Get Battery information
        // Precondition: battery is null
        // Postcondition: battery is a valid Battery object
        System.out.println("=== Creating Battery ===");
        while (battery == null) {
            try {
                System.out.print("Enter battery capacity (kWh): ");
                double capacity = Double.parseDouble(scanner.nextLine());
                
                System.out.print("Enter battery type (Lithium-ion, Lead-acid, etc.): ");
                String type = scanner.nextLine();
                
                battery = new Battery(capacity, type);
                System.out.println("Battery created: " + battery.toString() + "\n");
            } catch (NumberFormatException e) {
                System.out.println("Error: Capacity must be a valid number.\n");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + "\n");
            }
        }

        // Assemble Car and display results
        // Precondition: engine, wheels, and battery are all valid objects
        // Postcondition: Car is created and displayed to user, Scanner is closed
        System.out.println("=== Assembling Car ===");
        try {
            Car car = new Car(engine, wheels, battery);
            System.out.println("\n✓ Car successfully assembled!");
            System.out.println("\nCar Details:");
            System.out.println(car.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("Error assembling car: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
