package CE.Week11;
import java.util.*;

public class SlayTheDragon {

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    double n = scanner.nextDouble();
    int f = scanner.nextInt();
    int s = scanner.nextInt();
    int x = scanner.nextInt();
    int y = scanner.nextInt();
    scanner.close();
    double total = f + s;

    double[][] dp = new double[f+1][s+1];
        dp[0][0] = 1;
        
        double sum = 0;
        
        for(int i=1; i <= s; i++) {
          if((i-1)*y < n) {
          dp[0][i] = (double) (s-i+1)/(total-i+1) * dp[0][i-1];
          }
        }
        for(int i=1; i <= f; i++) {
          if((i-1)*x <n){
          dp[i][0] = (double) (f-i+1)/(total-i+1) * dp[i-1][0];
          }
        }
        
        
        for(int i=1; i <= f; i++) {
          for(int j=1; j <= s; j++) {
          if((i*x + y*j) >= n){
            if((((i-1)*x + j*y) < n) && (i*x + (j-1)*y) < n) {
              dp[i][j] = dp[i-1][j] *(f+1-i)/(total-i-j+1) + dp[i][j-1] * (s+1-j)/(total-i-j+1);
              }
              if((((i-1)*x + j*y) >= n) && (i*x + (j-1)*y) < n) {
              dp[i][j] = dp[i][j-1] * (s+1-j)/(total-i-j+1);
              }
              if((((i-1)*x + j*y) < n) && (i*x + (j-1)*y) >= n) {
              dp[i][j] = dp[i-1][j] * (f+1-i)/(total-i-j+1);
              }
             
            }
            if((i*x + y*j) < n) {
            dp[i][j] = dp[i-1][j] * (f+1-i)/(total-i-j+1) + dp[i][j-1] * (s+1-j)/(total-i-j+1);
          }
          }
        }


        for(int i=0; i <= f; i++) {
          for(int j=0; j <= s; j++) {
            if(((i*x + y*j) >= n)) {
              sum = sum + dp[i][j] * (double) (i+j);
            }
          }
        }
        

        if(n > f*x + s*y) {
          System.out.println(-1);
        } else {
            System.out.println(sum);
        }
    }
}


    
