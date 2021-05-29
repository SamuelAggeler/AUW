package CE.Week13;

import java.util.*;

public class CityPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] x_array = new long[n];
        long[] y_array = new long[n];

        for (int i = 0; i < n; i++) {
            x_array[i] = scanner.nextLong();
            y_array[i] = scanner.nextLong();
        }

        // Output using Out.java class
        System.out.println(distanceboth(x_array, y_array, n));
    }

    static long distanceboth(long x[], long y[], int n) {
        return distancesum(x, n) + distancesum(y, n);
    }

    static long distancesum(long arr[], long n) {
        Arrays.sort(arr);

        long result = 0;
        long total = 0;
        for (int i = 0; i < n; i++) {
            result += (arr[i] * i - total);
            total += arr[i];
        }
        return result;
    }
}
