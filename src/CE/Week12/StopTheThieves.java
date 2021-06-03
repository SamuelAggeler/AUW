package CE.Week12;

import java.util.*;

public class StopTheThieves {
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
        Graph g = new Graph(n);
        for (int i = 0; i < m; i++) {
            int u = In.readInt();
            int v = In.readInt();
            int w = In.readInt();
            if (w == -1) {
                w = 1000000;
            }

            
            g.addEdge(u, v, w);
        }
        if (g.computeMaximumFlow(0, n - 1) >= 1000000) {
            Out.println("no");
        } else {
            Out.println(g.computeMaximumFlow(0, n - 1));
        }

    }
}