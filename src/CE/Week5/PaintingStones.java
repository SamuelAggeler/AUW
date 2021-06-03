package CE.Week5;

public class PaintingStones {
    public static void main(String[] args) {
        // Uncomment this line if you want to read from a file
         In.open("public/test3.in");
         Out.compareTo("public/test3.out");

        int t = In.readInt();
        for (int i = 0; i < t; i++) {
            testCase();
        }
        
        // Uncomment this line if you want to read from a file
        // In.close();
    }

    public static void testCase() {
        // Input using In.java class
        int b = In.readInt();
        int w = In.readInt();
        int total = b + w;
        int question = In.readInt();
        
        if(question == 1) {
          
          
          double prb = (double) b / total;
          double prc = (double) (b+1) / total; 
          double prbb = b * prb;
          double prwb = w * prc;
          double total1 = prbb + prwb;
          
          
          Out.println(total1 / total);
        }
        
        if(question == 2) {
          
          double prb = (double) b / total;
          double prc = (double) (b+1) / total; 
          double prbb = b * prb;
          double prwb = w * prc;
          double total1 = prbb + prwb;
          double returntest = 1- (prb*b / total1);
          
          
        Out.println(returntest);  
        }
        
        if(question ==3) {
          
        long factorialw = Algorithms.fact(w);
        double totalw = Math.pow(total,w);
        double test3 = (double) factorialw / totalw ;
        double test1 = factorialw / totalw;
       
        double prb = (double) b / total;
        double top =  factorialw / totalw;
        double sum = 0;
        
        for(int i=1; i < w+1; i++) {
          double test = test3 * (total-i)/total;
          sum = sum + test;
        }
        
        double result = sum + top;
       
        Out.println(result);
        }
        
        // Output using Out.java class
        
    }
}
