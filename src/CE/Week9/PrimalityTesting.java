package CE.Week9;

import java.util.Scanner;
import java.math.BigInteger;
import java.util.Random;

public class PrimalityTesting {
    private static final int NUM_ITER = 100; // Number of iterations of the algorithm
    private static final BigInteger ZERO = BigInteger.ZERO;
    private static final BigInteger ONE = BigInteger.ONE;
    private static final BigInteger TWO = new BigInteger("2");
    private static final BigInteger THREE = new BigInteger("3");
    private static final BigInteger FOUR = new BigInteger("4");

    public static void main(String[] args) {
        // Create a new Scanner object for reading the input
        Scanner sc = new Scanner(System.in);

        // Read the number of test cases to follow
        int t = sc.nextInt();

        // Iterate over the test cases and solve the problem
        for (int i = 0; i < t; i++) {
            testCase(sc);
        }
    }

    public static void testCase(Scanner sc) {
        // Read the next number and convert it to type BigInteger
        String s = sc.next();
        BigInteger n = new BigInteger(s);

        // If for any iterations the algorithm returns that the number is not a
        // prime then it surely is not a prime
        if (!isPrime(n, NUM_ITER)) {
            System.out.println("no");
        // If for all iterations the algorithm returns that the number is a
        // prime then it probably is a prime
        } else {
            System.out.println("yes");
        }
    }

    public static boolean isPrime(BigInteger n, int k) {
        // If n is one, zero, or four then its not a prime
        if (n.compareTo(ONE) <= 0 || n.equals(FOUR)) return false;
        // If n is three then it is a prime
        if (n.compareTo(THREE) <= 0) return true;

        // Write n - 1 as 2^s * d by factoring powers of 2 from n - 1
        // We keep this s implicitly in the number of steps needed to reach
        // to n - 1 from our final value of d, by multiplying it with 2
        BigInteger d = n.subtract(ONE);
        while (d.mod(TWO).equals(ZERO)) {
            d = d.divide(TWO);
        }

        // Do the Miller Rabin test for k iterations
        for (int i = 0; i < k; i++) {
            if (!millerRabin(d, n)) {
                return false;
            }
        }

        return true;
    }

    public static boolean millerRabin(BigInteger d, BigInteger n) {
        // Find a random number between 2 and n - 2
        BigInteger a = getRandom(TWO, n.subtract(TWO));
        // Quick modular exponentiation a^d (mod n)
        BigInteger x = a.modPow(d, n);

        // If the result of the exponentiation is 1 or n - 1 then stop and do
        // another iteration
        if (x.equals(ONE) || x.equals(n.subtract(ONE))) {
            return true;
        }

        // For s times raise x to the power of two and do the same check as
        // before
        // Recall: s is implicitly stored in the number of times we need to
        //         multiply d by two in order to reach n - 1
        while (!d.equals(n.subtract(ONE))) {
            x = x.modPow(TWO, n);
            d = d.multiply(TWO);
            
            // If x == 1 then the number is not a prime
            if (x.equals(ONE)) return false;
            // If x == n - 1 then stop and do another iteration
            if (x.equals(n.subtract(ONE))) return true;
        }

        // The number is not a prime
        return false;
    }

    // Returns a uniformly at random BigInteger between lb and ub
    private static BigInteger getRandom(BigInteger lb, BigInteger ub) {
        Random rand = new Random();
        BigInteger res;
        do {
            res = new BigInteger(ub.bitLength(), rand);
        } while (res.compareTo(lb) < 0 || res.compareTo(ub) >= 0);
        
        return res;
    }
}