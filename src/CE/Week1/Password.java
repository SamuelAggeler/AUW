package CE.Week1;

import java.util.*;

public class Password {



    public static void testCase() {
        // Input using In.java class
        int n = In.readInt();
        HashMap<String, ArrayList<String>> directed1 = new HashMap<String, ArrayList<String>>();
        HashMap<String, ArrayList<String>> directed2 = new HashMap<String, ArrayList<String>>();
        HashMap<String, ArrayList<String>> undirected  = new HashMap<String, ArrayList<String>>();
        ArrayList<String> edges = new ArrayList<>();
        
        String [] arr = new String[n];
        
        for(int i=0; i < n; i++) {
          arr[i] = In.readWord();
          String indeg = arr[i].substring(0,2);
          String outdeg = arr[i].substring(1,3);


       
  
        if(!directed1.containsKey(indeg)) {  //add indeg of first directed Graph

          directed1.put(indeg, new ArrayList<>());
          edges.add(indeg);                 //add edges to edges list 
         }
         
         directed1.get(indeg).add(outdeg);     // add succsessor to adj list
         
         
        if (!directed1.containsKey(outdeg)) {    //add outegdes to first directed Graph
        directed1.put(outdeg, new ArrayList<>());
        edges.add(outdeg);
        }


        if(!directed2.containsKey(outdeg)) {  // check second graph contains outedge

        directed2.put(outdeg, new ArrayList<>());
        
         }
         
        directed2.get(outdeg).add(indeg); //
         
        if (!directed2.containsKey(indeg)) { // check second graph contains inedge
        directed2.put(indeg, new ArrayList<>());

        }

        if(!undirected.containsKey(indeg)) { // check for both directions

        undirected.put(indeg, new ArrayList<>());

        }
        undirected.get(indeg).add(outdeg); 
          
        if(!undirected.containsKey(outdeg)) {
        undirected.put(outdeg, new ArrayList<>());
        }
        
        undirected.get(outdeg).add(indeg);
        }
        
            HashSet<String> visited = new HashSet<>();
            
            DFS(undirected, edges, visited);
            if (visited.size() != edges.size()) {
            Out.println("no");
            return;
            }
            if (euler(undirected, directed1, directed2)) {
            Out.println("yes");
            return;
            }
            Out.println("no");
    
    }
    
    static void DFS(HashMap<String, ArrayList<String>> direction, List<String> edges, HashSet<String> visited) {
      
      Vector<Boolean> vis = new Vector<Boolean>(edges.size());
      
      visited.add(edges.get(0));
      Stack<String> stack = new Stack<>();
      stack.push(edges.get(0));
      
      while(!stack.empty()) {
        
        String k = stack.peek();
        stack.pop();
        
        if(!visited.contains(k)) {
          visited.add(k);
        }
        
        Iterator<String> itr = direction.get(k).iterator();
        
        while(itr.hasNext()) {
          String v = itr.next();
          if(!visited.contains(v))
          stack.push(v);
        }
      }
    }
    
    static boolean euler(HashMap<String, ArrayList<String>> direction, HashMap<String, ArrayList<String>> in, HashMap<String, ArrayList<String>> out) {
      int counter = 0;
      
      for (String i : direction.keySet()) {
        
        if(in.get(i).size() != out.get(i).size()) {
          counter++;
          if(Math.abs(in.get(i).size() - out.get(i).size()) != 1) {
            return false;
          }
        }
      }
      return counter == 0 || counter == 1 || counter == 2;
    }
    
}


