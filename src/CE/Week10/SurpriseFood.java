package CE.Week10;

public class SurpriseFood {
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
        int m = In.readInt();
        int[] prepedmeals = new int[n];
        for(int i=0; i < n; i++) {
          prepedmeals[i] = In.readInt();
        }
        //for(int i=0; i < prepedmeals.length; i++) {
          //System.out.println(prepedmeals[i]);
        //}
        
        int[][] listofdishes = new int[m+1][n];
        for(int i=1; i <= m; i++) {
          int lengthlist = In.readInt();
          for(int j=0; j < lengthlist; j++) {
            listofdishes[i][j] = In.readInt();
          }
          for(int k=lengthlist; k < n; k++){
            listofdishes[i][k] = -100;
          }
        }

        int total = n+m+1;
        Graph graph = new Graph(total+1);
        for(int i=1; i <= n; i++) { //source to dishes
          graph.addEdge(0,i,prepedmeals[i-1]);
        }
        for(int i=n+1; i < total; i++) { //clients to sink
          graph.addEdge(i,total,1);
        }
        
        for(int dishes=0; dishes < n; dishes++){
          for(int i=1; i <= m; i++) {
            for(int j=0; j < n; j++) {
              if(listofdishes[i][j] == dishes) {
                graph.addEdge(dishes+1,n+i,prepedmeals[dishes]);
            }
          }
        }
      }
        
        
        if(graph.computeMaximumFlow(0,total) < m){
          Out.println("no");
        } else {
          Out.println("yes");
        }

    }
}
