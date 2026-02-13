public class RecursionPractice {
    // Recursive method to calculate factorial of a number
    public static int factorial(int n) {
        
        if (n==0) {
            return 1; // base case: factorial of 0 is 1
        } 
        
        return n * factorial(n - 1); // recursive case: n! = n * (n-1)!
        // return (n == 0) ? 1 : n * factorial(n - 1);

    }
    
    // Recursive method to calculate the sum of an array

        /*
        sumArray(int[] arr, int index)
        Write a recursive method that returns the total sum of the array. The base case happens when index reaches the end of the array. The recursive case adds the current element to the sum of the rest: arr[index] + sumArray(arr, index + 1). 
         */

    public static int sumArray(int[] arr, int index) {
        
        if (index == arr.length) {
            return 0; // base case: when index reaches the end of the array,return 0
        }
        return arr[index] + sumArray(arr, index + 1); // recursive case: add current element to sum of the rest

        // return (index == arr.length) ? 0 : arr[index] + sumArray(arr, index + 1);

    }

    // Method to calculate the nth Fibinacci number

    /* 
    Write a recursive method that returns the nth Fibonacci number. 
    Use base cases for n == 0 and n == 1. 
    The recursive case should return fibonacci(n - 1) + fibonacci(n - 2).
     */

    public static int fibonacci(int n) {
        
        if (n == 0) {
            return 0; // base case: fibonacci(0) is 0
        } 
        if (n == 1) {
            return 1; // base case: fibonacci(1) is 1
        }
        return fibonacci(n - 1) + fibonacci(n - 2); // recursive case: fibonacci(n) = fibonacci(n-1) + fibonacci(n-2)

        // return (n == 0) ? 0 : (n == 1) ? 1 : fibonacci(n - 1) + fibonacci(n - 2);
       
    }





    public static void main(String[] args) {
        // Test the recursive method here
        /* 
        Call factorial(5) and print the result.
        Call sumArray using an array like {2, 4, 6, 8}.
        Call fibonacci(7) and print the result.
         */

        // Test factorial
        int factResult = factorial(5);
        System.out.println("Factorial of 5 is: " + factResult);

        // Test sumArray
        int[] array = {2, 4, 6, 8};
        int sumResult = sumArray(array, 0);
        System.out.println("Sum of the array {2, 4, 6, 8}: " + sumResult);

        // Test fibonacci
        int fibResult = fibonacci(7);
        System.out.println("7th Fibonacci number: " + fibResult);

    }
}
