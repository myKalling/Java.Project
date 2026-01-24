public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Student Class Test");

        // Create student objects. Are you able to create an instance of the Student class here?
        Student student1 = new Student("Alice", 1, 3.5);
        Student student2 = new Student("Bob", 2, 3.8);
        Student student3 = new Student("Alice", 1, 3.5);

        // toString demonstration. Can you access the toString method of objects above?
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);

        // equals demonstration. Can you access the equals method of objects above?
        System.out.println("student1 equals student2: " + student1.equals(student2));
        System.out.println("student1 equals student3: " + student1.equals(student3));

        // hashCode demonstration. Can you access the hashCode method of objects above?
        System.out.println("student1 hashCode: " + student1.hashCode());
        System.out.println("student2 hashCode: " + student2.hashCode());
        System.out.println("student3 hashCode: " + student3.hashCode());
    }
}