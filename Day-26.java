import java.util.*;

public class DetectCycleUndirectedGraph {

    private boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
        
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited, adj)) {
                    return true;
                }
            }
          
            else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle(int V, int[][] edges) {
       
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];

        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adj)) return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        DetectCycleUndirectedGraph obj = new DetectCycleUndirectedGraph();

        // Example 1
        int V1 = 5;
        int[][] edges1 = {{0,1},{1,2},{2,3},{3,4},{4,0}};
        System.out.println(obj.hasCycle(V1, edges1)); 

        // Example 2
        int V2 = 3;
        int[][] edges2 = {{0,1},{1,2}};
        System.out.println(obj.hasCycle(V2, edges2));

        // Example 3
        int V3 = 4;
        int[][] edges3 = {{0,1},{1,2},{2,0}};
        System.out.println(obj.hasCycle(V3, edges3)); 
    }
}
