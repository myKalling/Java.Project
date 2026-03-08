import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentManager {
    private List<Student> students = new ArrayList<>();

    public boolean addStudent(Student student) {
        if (findById(student.getStudentId()) != null) {
            return false; // duplicate ID
        }
        students.add(student);
        return true;
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student findById(String id) {
        for (Student s : students) {
            if (s.getStudentId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    public List<Student> findByLastName(String lastName) {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getLastName().equalsIgnoreCase(lastName)) {
                result.add(s);
            }
        }
        return result;
    }

    public boolean updateStudent(String id, String newFirstName, String newLastName, Double newGpa) {
        Student s = findById(id);
        if (s == null) {
            return false;
        }
        if (newFirstName != null && !newFirstName.trim().isEmpty()) {
            s.setFirstName(newFirstName);
        }
        if (newLastName != null && !newLastName.trim().isEmpty()) {
            s.setLastName(newLastName);
        }
        if (newGpa != null) {
            s.setGpa(newGpa);
        }
        return true;
    }

    public boolean removeStudent(String id) {
        Student s = findById(id);
        if (s == null) {
            return false;
        }
        return students.remove(s);
    }

    public void sortById() {
        students.sort(Comparator.comparing(Student::getStudentId, String.CASE_INSENSITIVE_ORDER));
    }

    public void sortByLastNameThenFirstName() {
        students.sort(Comparator
                .comparing(Student::getLastName, String.CASE_INSENSITIVE_ORDER)
                .thenComparing(Student::getFirstName, String.CASE_INSENSITIVE_ORDER));
    }

    public double computeAverageGpa() {
        if (students.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (Student s : students) {
            sum += s.getGpa();
        }
        return sum / students.size();
    }

    // Recursive method: counts how many students have GPA >= threshold.
    // Base case: index == students.size() → no more students to check.
    // Recursive case: check current student, then recurse on next index.
    public int countStudentsAboveThreshold(double threshold) {
        return countStudentsAboveThresholdRecursive(threshold, 0);
    }

    private int countStudentsAboveThresholdRecursive(double threshold, int index) {
        if (index == students.size()) {
            return 0; // base case: no more students
        }
        int countForThis = students.get(index).getGpa() >= threshold ? 1 : 0;
        return countForThis + countStudentsAboveThresholdRecursive(threshold, index + 1);
    }
}