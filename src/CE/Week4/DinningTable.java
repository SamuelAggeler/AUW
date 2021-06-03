package CE.Week4;
import java.util.*;

public class DinningTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
          // Uncomment this line if you want to read from a file
           In.open("public/test1.in");
           Out.compareTo("public/test1.out");
  
          int t = In.readInt();
          for (int i = 0; i < t; i++) {
              testCase();
          }
          
          // Uncomment this line if you want to read from a file
           In.close();
      }
  
     public static void testCase() {
          int people = In.readInt();
          int friendships = In.readInt();
          int bestfriend = In.readInt();
  
          ArrayList<ArrayList<Integer>> G = new ArrayList<ArrayList<Integer>>();
          for (int i = 0; i < people; i++) {
              G.add(new ArrayList<Integer>());
          }
  
          for (int i = 0; i < friendships; i++) {
              int u = In.readInt();
              int v = In.readInt();
              //System.out.println(friendships);
              //System.out.println(u);
              G.get(u).add(v);
              G.get(v).add(u);
          }
          
  
          // Stores the colour of each vertex
          int colour[] = new int[people];
          for (int i = 0; i < people; i++) {
              colour[i] = -1;
          }
  
          // Do BFS and check for bipartiteness, i.e. 2-colouring
          LinkedList<Integer> queue = new LinkedList<Integer>();
          // The graph might not be connected so we need to run a BFS from every
          // (unvisited) vertex
          for (int i = 0; i < people; i++) {
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
                          Out.println("no");
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
          String s = "";
          for(int i=0; i < people; i++) {
            if(colour[i] == colour[bestfriend]) {
              
              s = s + " " + i; 
            }
          }
          
        Out.println(s);
      }
}
