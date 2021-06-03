package CE.Week6;
import java.util.*;


public class IslandTribes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bear = scanner.nextInt();
        int hunter = scanner.nextInt();
        int ninja = scanner.nextInt();
        scanner.close();

        double result1 = probofsurv(bear, hunter, ninja);
        double result2 = probofsurv(hunter, ninja, bear);
        double result3 = probofsurv(ninja, bear, hunter);

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

    }

    static double probofsurv(int bear, int hunter, int ninja) {

        double[][][] dp = new double[101][101][101];

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                for(int m = 0; m < 101; m++) {
                    dp[i][j][m] = 2;
                }
            }
        }



        if(bear < 0) {
            return 1.0;
        }
        if(hunter < 0) {
            return 1.0;
        }
        if(ninja < 0) {
            return 1.0;
        }

        if(dp[bear][hunter][ninja] != 2) {
            return dp[bear][hunter][ninja];
        }
        
        double bearhunter = (double)(bear*hunter);
        double bearninja = (double)(bear*ninja);
        double ninjahunter = (double)(ninja * hunter);

        dp[bear][hunter][ninja] = bearhunter / (double) (bearhunter + bearninja + ninjahunter) * probofsurv(bear -1, hunter, ninja)
        + bearninja / (double) (bearhunter + bearninja + ninjahunter) * probofsurv(bear, hunter, ninja -1)
        + ninjahunter / (double) (bearhunter + bearninja + ninjahunter) * probofsurv(bear, hunter-1, ninja);
        
        return dp[bear][hunter][ninja];
    }
}
