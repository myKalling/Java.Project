package parts;

public class Engine {
    //horsepower and type
    private int horsepower;
    private String type; //gasoline, diesel, electric, hybrid

    //Constructor
    public Engine(int horsepower, String type) {
    
    }
    
    //Getters
    public int getHorsepower() {
    return horsepower;

    }
    public String getType() {
        return type;
    }

    //Setters

    //Engine horsepower must be a positive number
    public void setHorsepower(int horsepower) {
        if (horsepower <= 0) {
            throw new IllegalArgumentException("Horsepower must be a positive number.");
        }
        this.horsepower = horsepower;
    }

    public void setType(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Engine type cannot be null or empty.");
        }
        this.type = type;
    }

}