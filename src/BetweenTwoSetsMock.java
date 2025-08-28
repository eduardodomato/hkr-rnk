import java.util.List;

public class BetweenTwoSetsMock {

    /*
        Find all numbers that are multiple of all values in a
        And also divisors (Factors) of all numbers in b
     */

    // Returns the Greatest Common Divisor (GCD) of n1 and n2 using recursion
    int getGCD(int n1, int n2) {
        if (n2 == 0) { // Base case: if n2 is 0, n1 is the GCD
            return n1;
        }
        return getGCD(n2, n1 % n2); // Recursive call with n2 and remainder of n1/n2
    }

    // Returns the Lowest Common Multiple (LCM) of n1 and n2
    int getLCM(int n1, int n2) {
        if (n1 == 0 || n2 == 0) // If either number is 0, LCM is 0
            return 0;
        else {
            int gcd = getGCD(n1, n2); // Find GCD of n1 and n2
            return Math.abs(n1 * n2) / gcd; // Calculate LCM using GCD
        }
    }

    // Returns the count of integers that are multiples of all elements in a and divisors of all elements in b
    public int getTotalX(List<Integer> a, List<Integer> b) {
        int result = 0; // Initialize result counter

        // Get LCM of all elements in list a
        int lcm = a.get(0); // Start with the first element
        for (Integer integer : a) {
            lcm = getLCM(lcm, integer); // Update LCM with each element
        }

        // Get GCD of all elements in list b
        int gcd = b.get(0); // Start with the first element
        for (Integer integer : b) {
            gcd = getGCD(gcd, integer); // Update GCD with each element
        }

        // Count multiples of lcm that exactly divide the gcd
        int multiple = 0; // Start with 0
        while (multiple <= gcd) { // Loop until multiple exceeds gcd
            multiple += lcm; // Increment by lcm each time

            if (gcd % multiple == 0) // Check if multiple divides gcd exactly
                result++; // If yes, increment result
        }

        return result; // Return the final count
    }


    public int getTotalXFunctional(List<Integer> a, List<Integer> b) {
        // Inline GCD lambda
        java.util.function.BiFunction<Integer, Integer, Integer> gcd = (x, y) -> {
            while (y != 0) {
                int temp = y;
                y = x % y;
                x = temp;
            }
            return x;
        };

        java.util.function.BiFunction<Integer, Integer, Integer> lcm = (x, y) -> x * y / gcd.apply(x, y);

        int lcmA = a.stream().reduce((x, y) -> lcm.apply(x, y)).orElse(0);
        int gcdB = b.stream().reduce((x, y) -> gcd.apply(x, y)).orElse(0);

        return (int) java.util.stream.IntStream.rangeClosed(1, gcdB / lcmA)
                .map(i -> i * lcmA)
                .filter(i -> gcdB % i == 0)
                .count();
    }

}
