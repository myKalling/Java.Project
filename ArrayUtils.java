public class ArrayUtils {

    /*
    Create a utility class to analyze integer arrays. Implement the following methods:

    sumOfEvens(int[] nums): Return the sum of all even numbers in the array.
    countOccurrences(int[] nums, int target): Return how many times the target value appears in the array.
    Examples:

    sumOfEvens([1, 2, 3, 4, 5, 6]) = 12
    countOccurrences([2, 2, 2], 2) = 3
    Edge cases: empty array, null array, single element, negative numbers, all equal elements.
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

    public static int sumOfEvens(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                sum += num;
            }
        }
        return sum;
    }


    /*  
    Algorithn for countOccurences:
    1. Check in the inputt array is null. If it is, return 0.
    2. Initialize a variable count to 0.
    3. Loop through each element in the array
    4. For each element, check if the element is equal to the target value
    5. If it is equal, increment the count by 1
    6. After the loop completed, return the count
    */

    public static int countOccurences(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        for (int num : nums) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }

    /*
    Algorithm for testEmptyArray:
    1. Create an empty integer array: new int[]{}
    2. Check if the input array is null or has length 0. If true, return 0.
    3. Initialize a variable sum to 0.
    4. Loop through each element in the array (loop will not execute for empty array).
    5. If any element exists and is even, add it to sum (this block will not execute).
    6. After the loop completes, verify sum equals 0 and return the result.
    */

    public static int EmptyArray() {
        int[] nums = {};
        if (nums == null || nums.length == 0) {
            int sum = 0;
            for (int num : nums) {
                if (num % 2 == 0) {
                    sum += num;
                }
            }
            if (sum == 0) {
                System.out.println("✓ Empty Array PASSED - sumOfEvens({}) = " + sum);
                return sum;
            } else {
                System.out.println("✗ Empty Array FAILED - Expected 0, got " + sum);
                return -1;
            }
        } else {
            System.out.println("✗ Empty Array FAILED - Array is not empty");
            return -1;
        }
    }

    /*
    Algorithm for NullArray:
    1. Check if the input array is null or has length 0. If true, return 0.
    2. Initialize a variable sum to 0.
    3. Check if array is not null before looping (to prevent NullPointerException).
    4. Loop through each element in the array (loop will not execute for null array).
    5. If any element exists and is even, add it to sum (this block will not execute).
    6. After the loop completes, verify sum equals 0 and return the result.
    */

    public static int NullArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            int sum = 0;
            if (nums != null) {
                for (int num : nums) {
                    if (num % 2 == 0) {
                        sum += num;
                    }
                }
            }
            if (sum == 0) {
                System.out.println("✓ Null Array PASSED - sumOfEvens(null) = " + sum);
                return sum;
            } else {
                System.out.println("✗ Null Array FAILED - Expected 0, got " + sum);
                return -1;
            }
        } else {
            System.out.println("✗ Null Array FAILED - Array is not null");
            return -1;
        }
    }

    /*
    Algorithm for SingleElement:
    1. Check if the input array is null or has length 0. If false, proceed with processing.
    2. Initialize a variable sum to 0.
    3. Loop through each element in the array (loop will execute once for single element).
    4. If the element is even, add it to sum.
    5. After the loop completes, verify sum equals 2 and return the result.
    */

    public static int SingleElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            System.out.println("✗ Single Element FAILED - Array is empty or null");
            return -1;
        } else {
            int sum = 0;
            for (int num : nums) {
                if (num % 2 == 0) {
                    sum += num;
                }
            }
            if (sum == 2) {
                System.out.println("✓ Single Element PASSED - sumOfEvens({2}) = " + sum);
                return sum;
            } else {
                System.out.println("✗ Single Element FAILED - Expected 2, got " + sum);
                return -1;
            }
        }
    }

    /*
    Algorithm for NegativeNumbers:
    1. Check if the input array is null or has length 0. If false, proceed with processing.
    2. Initialize a variable sum to 0.
    3. Loop through each element in the array (loop will execute for each negative number).
    4. If the element is even (negative even numbers are still even), add it to sum.
    5. After the loop completes, verify sum equals -12 and return the result.
    */

    public static int NegativeNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            System.out.println("✗ Negative Numbers FAILED - Array is empty or null");
            return -1;
        } else {
            int sum = 0;
            for (int num : nums) {
                if (num % 2 == 0) {
                    sum += num;
                }
            }
            if (sum == -12) {
                System.out.println("✓ Negative Numbers PASSED - sumOfEvens({-2, -4, -6}) = " + sum);
                return sum;
            } else {
                System.out.println("✗ Negative Numbers FAILED - Expected -12, got " + sum);
                return -1;
            }
        }
    }

    /*
    Algorithm for AllEqualElements:
    1. Check if the input array is null or has length 0. If false, proceed with processing.
    2. Initialize a variable sum to 0.
    3. Loop through each element in the array (loop will execute for each equal element).
    4. If the element is even, add it to sum (all elements are the same and even).
    5. After the loop completes, verify sum equals 6 and return the result.
    */

    public static int AllEqualElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            System.out.println("✗ All Equal Elements FAILED - Array is empty or null");
            return -1;
        } else {
            int sum = 0;
            for (int num : nums) {
                if (num % 2 == 0) {
                    sum += num;
                }
            }
            if (sum == 6) {
                System.out.println("✓ All Equal Elements PASSED - sumOfEvens({2, 2, 2}) = " + sum);
                return sum;
            } else {
                System.out.println("✗ All Equal Elements FAILED - Expected 6, got " + sum);
                return -1;
            }
        }
    }

    

    
    
    public static void main(String[] args) throws Exception{
    System.out.println(sumOfEvens(new int[]{1, 2, 3, 4, 5, 6})); // Expected Output: 12
    System.out.println(countOccurences(new int[]{2, 2, 2}, 2)); // Expected Output: 3

    // Additional test cases (empty array, null array, single element, negative numbers, all equal elements)
    System.out.println(sumOfEvens(new int[]{})); // Expected Output: 0
    System.out.println(sumOfEvens(null)); // Expected Output: 0
    System.out.println(sumOfEvens(new int[]{-2, -4, -6})); // Expected Output: -12
    System.out.println(countOccurences(new int[]{}, 1)); // Expected Output: 0
    System.out.println(countOccurences(null, 1)); // Expected Output: 0
    System.out.println(countOccurences(new int[]{5}, 5)); // Expected Output: 1
    System.out.println(countOccurences(new int[]{-1, -1, -1}, -1)); // Expected Output: 3
    System.out.println(NullArray(null));
    System.out.println(SingleElement(new int[]{2}));
    System.out.println(NegativeNumbers(new int[]{-2, -4, -6}));
    System.out.println(AllEqualElements(new int[]{2, 2, 2}));
    }
}

