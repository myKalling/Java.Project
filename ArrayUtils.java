public class ArrayUtils {

    /*
    
    Pasted information from project.
    
    */

    /*  
    Algorithn for sumOfEvents:
    1. Check in the inputt array is null. If it is, return 0.
    2. Initialize a variable sum to 0.
    3. Loop through each element in the array
    4. For each element, check if the element is even
    5. If the element is even, add it to sum
    6. After the loop completed, return the sum
    */

    /*  
    Algorithn for countOccurences:
    1. Check in the inputt array is null. If it is, return 0.
    2. Initialize a variable count to 0.
    3. Loop through each element in the array
    4. For each element, check if the element is equal to the target value
    5. If it is equal, increment the count by 1
    6. After the loop completed, return the count
    */



    Run | Debug
    public static void main(String[] args) throws Exception{
    System.out.println(sumOfEvents(new int[]{1, 2, 3, 4, 5, 6})); // Expected Output: 12
    System.out.println(countOccurences(new int[]{2, 2, 2}, 2)); // Expected Output: 3

    // Additional test cases
    System.out.println(sumOfEvents(new int[]{10, 15, 20, 25, 30})); // Expected Output: 70
    System.out.println(countOccurences(new int[]{1, 2, 3, 4, 5}, 3)); // Expected Output: 1

    }
}

