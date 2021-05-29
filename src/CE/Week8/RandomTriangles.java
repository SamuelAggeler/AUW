package CE.Week8;
import java.util.*;


public class RandomTriangles {
    int triangles;
    double prob;



    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RandomTriangles test = new RandomTriangles();
        test.triangles = scanner.nextInt();
        test.prob = scanner.nextDouble();
        scanner.close();
        System.out.println(test.prob() + "" + test.var());

    }


    public double prob() {
        return 0.0;
    }

    public double var() {
        return 0.0;
    }

}
