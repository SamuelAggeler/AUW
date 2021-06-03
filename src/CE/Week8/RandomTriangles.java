package CE.Week8;
import java.util.*;


public class RandomTriangles {
    public static void main(String[] args) {
        // Uncomment this line if you want to read from a file
        In.open("public/test1.in");
        Out.compareTo("public/test1.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
        
        // Uncomment this line if you want to read from a file
        // In.close();
    }

    public static void testCase() {
        // Input using In.java class
        int n = In.readInt();
        double p = In.readDouble();
        double binom = (double) Algorithms.binom(n, n-3);
        double ex = (double) binom*p*p*p;
        double varianz = 0;

          double firstcase = binom*p*p*p;
          double secondcase = binom*3*(n-3)*p*p*p*p*p;
          double thirdcase = (binom*binom-binom-binom*3*(n-3))*p*p*p*p*p*p;
          varianz = firstcase + secondcase + thirdcase - (ex*ex);
        
        
        // Output using Out.java class
        Out.println(ex + " " + varianz);                                                                                                              
    }

}
