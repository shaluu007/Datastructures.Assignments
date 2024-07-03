package dsa.ufCycleDetection;

import java.util.*;

class DetectCycleUndirectedGraph {
    private int V; 
    private List<int[]> edges;

    public DetectCycleUndirectedGraph(int V) {
        this.V = V;
        edges = new ArrayList<>();
    }

    public void addEdge(int u, int v) {
        edges.add(new int[]{u, v});
    }

    public boolean hasCycle() {
        UnionFind1 uf = new UnionFind1(V);
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            if (uf.find(u) == uf.find(v)) {
                return true;
            }
            
            uf.union(u, v);
        }
        
        return false; 
    }

    public static void main(String[] args) {
        DetectCycleUndirectedGraph graph = new DetectCycleUndirectedGraph(4);
        
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        
        if (graph.hasCycle()) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph does not contain cycle");
        }
    }
}
