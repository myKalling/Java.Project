package src;
public class Student {
    private String name;
    private int id;
    private double gpa;

    // Constructor
    public Student(String name, int id, double gpa) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be positive");
        }
        if (gpa < 0.0 || gpa > 4.0) {
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0");
        }

        // Initialize fields
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }

    // toString method
    @Override
    public String toString() {
        return "Student{name='" + name + "', id=" + id + ", gpa=" + gpa + "}";
    }

    // equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // check for reference equality
        if (obj == null || getClass() != obj.getClass()) return false; // check for null and class type
        Student student = (Student) obj;
        return id == student.id; // compare based on id
    }

    // hashcode method
    @Override
    public int hashCode() {
        return Integer.hashCode(id); // generate hashcode based on id
    }

    // Main method for testing
    public static void main(String[] args) {
        Student student = new Student("John Doe", 12345, 3.5);
        System.out.println(student);
    }
}