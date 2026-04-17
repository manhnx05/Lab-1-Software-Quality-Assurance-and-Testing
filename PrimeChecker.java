public class PrimeChecker {
    /**
     * Checks if a number is prime.
     * 
     * Requirement:
     * 1. At least 1 loop: uses a for loop.
     * 2. At least 1 branch: uses an if statement.
     */
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        // Loop to check for divisors
        for (int i = 2; i <= Math.sqrt(n); i++) {
            // Branching logic to check divisibility
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("--- Java Prime Number Analyzer ---");
        int[] testNumbers = {2, 3, 4, 10, 13, 17, 20, 23, 25};

        for (int num : testNumbers) {
            if (isPrime(num)) {
                System.out.printf("| %2d | is a PRIME number.   |%n", num);
            } else {
                System.out.printf("| %2d | is NOT a prime number.|%n", num);
            }
        }
        System.out.println("----------------------------------");
    }
}
