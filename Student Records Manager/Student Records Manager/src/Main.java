import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentManager manager = new StudentManager();

    public static void main(String[] args) {
        // Seed some example records for testing
        manager.addStudent(new Student("S001", "Alice", "Smith", 3.5));
        manager.addStudent(new Student("S002", "Bob", "Johnson", 2.8));
        manager.addStudent(new Student("S003", "Carol", "Williams", 3.9));

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    handleAddStudent();
                    break;
                case 2:
                    handleListStudents();
                    break;
                case 3:
                    handleSearchById();
                    break;
                case 4:
                    handleSearchByLastName();
                    break;
                case 5:
                    handleUpdateStudent();
                    break;
                case 6:
                    handleRemoveStudent();
                    break;
                case 7:
                    handleSortMenu();
                    break;
                case 8:
                    handleStatistics();
                    break;
                case 9:
                    System.out.println("Exiting. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose a number from the menu.");
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("===== Student Records Manager =====");
        System.out.println("1. Add student");
        System.out.println("2. List all students");
        System.out.println("3. Search by Student ID");
        System.out.println("4. Search by Last Name");
        System.out.println("5. Update a student");
        System.out.println("6. Remove a student");
        System.out.println("7. Sort students");
        System.out.println("8. Compute statistics");
        System.out.println("9. Quit");
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String line = scanner.nextLine();
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        }
    }

    private static double readDouble(String prompt, double min, double max) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine();
            try {
                double value = Double.parseDouble(line.trim());
                if (value < min || value > max) {
                    System.out.println("Value must be between " + min + " and " + max + ".");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        }
    }

    private static String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine();
            if (line != null && !line.trim().isEmpty()) {
                return line.trim();
            }
            System.out.println("Input cannot be empty. Please try again.");
        }
    }

    private static void handleAddStudent() {
        System.out.println("--- Add Student ---");
        String id = readNonEmptyString("Student ID: ");
        String firstName = readNonEmptyString("First Name: ");
        String lastName = readNonEmptyString("Last Name: ");
        double gpa = readDouble("GPA (0.0 - 4.0): ", 0.0, 4.0);

        Student s = new Student(id, firstName, lastName, gpa);
        boolean added = manager.addStudent(s);
        if (added) {
            System.out.println("Student added successfully.");
        } else {
            System.out.println("A student with that ID already exists. Student not added.");
        }
    }

    private static void handleListStudents() {
        System.out.println("--- List All Students ---");
        List<Student> all = manager.getAllStudents();
        if (all.isEmpty()) {
            System.out.println("No students in the list.");
        } else {
            for (Student s : all) {
                System.out.println(s);
            }
        }
    }

    private static void handleSearchById() {
        System.out.println("--- Search by Student ID ---");
        String id = readNonEmptyString("Enter Student ID: ");
        Student s = manager.findById(id);
        if (s == null) {
            System.out.println("Student not found.");
        } else {
            System.out.println("Found: " + s);
        }
    }

    private static void handleSearchByLastName() {
        System.out.println("--- Search by Last Name ---");
        String lastName = readNonEmptyString("Enter Last Name: ");
        List<Student> result = manager.findByLastName(lastName);
        if (result.isEmpty()) {
            System.out.println("No students found with last name: " + lastName);
        } else {
            for (Student s : result) {
                System.out.println(s);
            }
        }
    }

    private static void handleUpdateStudent() {
        System.out.println("--- Update Student ---");
        String id = readNonEmptyString("Enter Student ID to update: ");
        Student existing = manager.findById(id);
        if (existing == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Current record: " + existing);
        System.out.println("Press Enter to skip a field and leave it unchanged.");

        System.out.print("New First Name (or Enter to keep '" + existing.getFirstName() + "'): ");
        String newFirst = scanner.nextLine();
        if (newFirst.trim().isEmpty()) {
            newFirst = null;
        }

        System.out.print("New Last Name (or Enter to keep '" + existing.getLastName() + "'): ");
        String newLast = scanner.nextLine();
        if (newLast.trim().isEmpty()) {
            newLast = null;
        }

        Double newGpa = null;
        System.out.print("New GPA (0.0 - 4.0) or Enter to keep " + existing.getGpa() + ": ");
        String gpaInput = scanner.nextLine();
        if (!gpaInput.trim().isEmpty()) {
            try {
                double gpa = Double.parseDouble(gpaInput.trim());
                if (gpa < 0.0 || gpa > 4.0) {
                    System.out.println("Invalid GPA range. GPA will not be changed.");
                } else {
                    newGpa = gpa;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid GPA input. GPA will not be changed.");
            }
        }

        boolean updated = manager.updateStudent(id, newFirst, newLast, newGpa);
        if (updated) {
            System.out.println("Student updated: " + manager.findById(id));
        } else {
            System.out.println("Update failed.");
        }
    }

    private static void handleRemoveStudent() {
        System.out.println("--- Remove Student ---");
        String id = readNonEmptyString("Enter Student ID to remove: ");
        boolean removed = manager.removeStudent(id);
        if (removed) {
            System.out.println("Student removed.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void handleSortMenu() {
        System.out.println("--- Sort Students ---");
        System.out.println("1. Sort by ID");
        System.out.println("2. Sort by Last Name, then First Name");
        int choice = readInt("Choose sort option: ");
        if (choice == 1) {
            manager.sortById();
            System.out.println("Students sorted by ID.");
        } else if (choice == 2) {
            manager.sortByLastNameThenFirstName();
            System.out.println("Students sorted by last name, then first name.");
        } else {
            System.out.println("Invalid sort option.");
        }
    }

    private static void handleStatistics() {
        System.out.println("--- Statistics ---");
        double avg = manager.computeAverageGpa();
        System.out.printf("Average GPA: %.2f%n", avg);

        double threshold = readDouble("Enter GPA threshold to count students above: ", 0.0, 4.0);
        // Uses recursive method in StudentManager
        int countAbove = manager.countStudentsAboveThreshold(threshold);
        System.out.println("Number of students with GPA >= " + threshold + ": " + countAbove);
    }
}