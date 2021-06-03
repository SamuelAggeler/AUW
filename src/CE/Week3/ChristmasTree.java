package CE.Week3;
import java.util.*;

public class ChristmasTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

      int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            testCase(sc);
        }
    }

    public static void testCase(Scanner sc) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> G = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            G.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            G.get(u).add(v);
            G.get(v).add(u);
        }

        // Stores the colour of each vertex
        int colour[] = new int[n];
        for (int i = 0; i < n; i++) {
            colour[i] = -1;
        }

        // Do BFS and check for bipartiteness, i.e. 2-colouring
        LinkedList<Integer> queue = new LinkedList<Integer>();
        // The graph might not be connected so we need to run a BFS from every
        // (unvisited) vertex
        for (int i = 0; i < n; i++) {
            if (colour[i] != -1) continue;

            queue.clear();
            queue.add(i);
            colour[i] = 0;
            while (queue.size() != 0) {
                int curr = queue.poll();
            
                for (int neighbour : G.get(curr)) {
                    // If the neighbour has the same colour then the graph is
                    // not bipartite
                    if (colour[neighbour] == colour[curr]) {
                        System.out.println("no");
                        return;
                    }

                    if (colour[neighbour] == -1) {
                        // Assign the opposite colour to the neighbour
                        colour[neighbour] = 1 - colour[curr];
                        queue.add(neighbour);
                    }
                }
            }
        }

        System.out.println("yes");
    }
}
