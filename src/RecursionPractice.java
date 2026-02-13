public class RecursionPractice {
    // Recursive method to calculate factorial of a number
    public static int factorial(int n) {
        
        if (n==0) {
            return 1; // base case: factorial of 0 is 1
        } 
        
        return n * factorial(n - 1); // recursive case: n! = n * (n-1)!
        // return (n == 0) ? 1 : n * factorial(n - 1);

    }     
        


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


        int n = 5;
        System.out.println("Factorial of " + n + " is: " + factorial(n));
    }
}
