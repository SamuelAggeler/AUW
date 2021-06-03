package CE.Week7;

public class WinterSeason {
    public static void main(String[] args) {
        // Uncomment this line if you want to read from a file
        In.open("public/sample.in");
        Out.compareTo("public/sample.out");

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
        int k = In.readInt();
        
        double[] prob = new double[n+1];
        double[][] dp = new double[k+1][n+1];
        dp[0][0] = 1;
        
        
        for(int i=1; i <= n; i++){
          prob[i] = In.readDouble();
        }
        
        for(int i=1; i <= n; i++) {
          dp[0][i] = dp[0][i-1] * (1-prob[i]);
        }
        

        
        for(int i=1; i <=k; i++) {
          for(int j=i-1; j >= 0; j--) {
            dp[i][j] = 0;
          }
        }
        
        for(int i=1; i <= k; i++) {
          for(int j=i; j <= n; j++) {
            dp[i][j] = (dp[i-1][j-1]*prob[j]) + (dp[i][j-1] * (1-prob[j]));
          }
        }
        

        
        double sum = 1;

        for(int i=0; i <k; i++) {
          sum = sum - dp[i][n];
        }
        Out.println(sum);
    }
}
