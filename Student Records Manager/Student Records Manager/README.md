# Student Records Manager

## Project Description
This Java program is a menu-based console application designed to manage student records, demonstrating core computer science concepts including object-oriented programming (OOP), data structures, algorithms, recursion, and input validation. Users can perform various operations such as adding, viewing, searching, updating, and removing student records stored in an ArrayList. The application includes at least one recursive method for educational purposes and ensures data integrity through validation checks like preventing duplicate IDs and handling invalid inputs.

## How to Run the Program
1. Ensure you have Java installed on your system (JDK 8 or higher recommended).
2. Navigate to the project root directory in your terminal.
3. Compile the source files: `javac -d bin src/*.java`
4. Run the program: `java -cp bin Main`
5. Follow the on-screen menu to interact with the application.

## List of Features Implemented
- Add a student (with duplicate ID prevention)
- List all students
- Search by Student ID
- Search by Last Name
- Update a student's information (first name, last name, and/or GPA)
- Remove a student
- Sort students (by ID or by last name then first name)
- Compute statistics (average GPA and count of students above a GPA threshold using recursion)

## Where Recursion is Used and Why
Recursion is used in the `StudentManager.countStudentsAboveThresholdRecursive` method to count how many students have a GPA at or above a specified threshold. It recursively traverses the ArrayList of students by index: the base case occurs when the index reaches the size of the list (no more students to check), returning 0; the recursive case checks the current student's GPA, adds 1 if it meets the threshold, and calls itself with the next index. This demonstrates recursive traversal over a data structure to compute a meaningful statistic, showcasing foundational computer science concepts in a practical context.
- Update a student’s name or GPA and confirm the change by listing or searching.
- Remove an existing student and confirm they no longer appear in the list.
- Enter invalid menu input (e.g., letters instead of a number) and confirm the program re-prompts without crashing.
