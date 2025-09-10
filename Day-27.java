import java.util.*;

class Graph {
    private int V;                    
    private List<List<Integer>> adj;  

    Graph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

   
    void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    int shortestPath(int start, int end) {
        if (start == end) return 0;

        int[] dist = new int[V];           
        Arrays.fill(dist, -1);            
        Queue<Integer> q = new LinkedList<>();

        dist[start] = 0;
        q.add(start);

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int neighbor : adj.get(node)) {
                if (dist[neighbor] == -1) {      
                    dist[neighbor] = dist[node] + 1;
                    q.add(neighbor);

                  
                    if (neighbor == end) {
                        return dist[neighbor];
                    }
                }
            }
        }

        return -1;  
    }
}

public class ShortestPathUnweighted {
    public static void main(String[] args) {
        // Example 1
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 3);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);
        System.out.println(g1.shortestPath(0, 4)); 

        // Example 2
        Graph g2 = new Graph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        System.out.println(g2.shortestPath(0, 2));  

        // Example 3
        Graph g3 = new Graph(4);
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        System.out.println(g3.shortestPath(2, 3));  
    }
}
