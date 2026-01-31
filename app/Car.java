package app;

import parts.Engine;
import parts.Wheel;
import parts.Battery;

public class Car {
    private Engine engine;
    private Wheel[] wheels;
    private Battery battery;

    // Constructor
    public Car(Engine engine, Wheel[] wheels, Battery battery) {
        if (engine == null) {
            throw new IllegalArgumentException("Engine cannot be null.");
        }
        if (wheels == null || wheels.length == 0) {
            throw new IllegalArgumentException("Wheels cannot be null or empty.");
        }
        this.engine = engine;
        this.wheels = wheels;
        this.battery = battery; // Battery can be null for non-electric cars
    }

    // Getters
    public Engine getEngine() {
        return engine;
    }
    
    public Wheel[] getWheels() {
        return wheels;
    }

    public Battery getBattery() {
        return battery;
    }

    // Setters
    public void setEngine(Engine engine) {
        if (engine == null) {
            throw new IllegalArgumentException("Engine cannot be null.");
        }
        this.engine = engine;
    }
    
    public void setWheels(Wheel[] wheels) {
        if (wheels == null || wheels.length == 0) {
            throw new IllegalArgumentException("Wheels cannot be null or empty.");
        }
        this.wheels = wheels;
    }

    public void setBattery(Battery battery) {
        this.battery = battery; // Battery can be null for non-electric cars
    }

    @Override
    public String toString() {
        StringBuilder wheelsStr = new StringBuilder();
        for (Wheel wheel : wheels) {
            wheelsStr.append(wheel.toString()).append(", ");
        }
        // Remove trailing comma and space
        if (wheelsStr.length() > 0) {
            wheelsStr.setLength(wheelsStr.length() - 2);
        }
        return "Car{engine=" + engine.toString() + ", wheels=[" + wheelsStr.toString() + "], battery=" + (battery != null ? battery.toString() : "null") + "}";
    }
}