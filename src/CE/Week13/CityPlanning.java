package CE.Week13;

import java.util.*;

public class CityPlanning {
    public static void main(String[] args) {
        // Uncomment this line if you want to read from a file
         In.open("public/test2.in");
         Out.compareTo("public/test2.out");

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
        long[] x_array = new long[n];
        long[] y_array = new long[n];
        
        for(int i=0; i < n; i++) {
          x_array[i] = In.readLong();
          y_array[i] = In.readLong();   
        }
          Arrays.sort(x_array);
          Arrays.sort(y_array);
          
          long total1 = 0;
          long total2 = 0;
          long sum1 = 0;
          long sum2 = 0;
          
        for (int i=0; i < n; i++) {
          total1 = total1 + (x_array[i] * i - sum1);
          total2 = total2 + (y_array[i] * i - sum2);
          sum1 = sum1  + x_array[i];
          sum2 = sum2  + y_array[i];
        }
        
        // Output using Out.java class
        Out.println(total1 + total2);
    }
}
