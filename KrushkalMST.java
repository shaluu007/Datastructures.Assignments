package DataStructures.Tree;

import java.util.*;

public class KrushkalMST {

    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    static class Subset {
        int parent, rank;
    }

    int V, E;
    Edge[] edges;
    KrushkalMST(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[E];
        for (int i = 0; i < e; ++i)
            edges[i] = new Edge(0, 0, 0);
    }

    int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }
    void union(Subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
    void krushkalMST() {
        Edge[] result = new Edge[V]; 
        int e = 0; 
        int i = 0; 
        Arrays.sort(edges);
        Subset[] subsets = new Subset[V];
        for (int v = 0; v < V; v++)
            subsets[v] = new Subset();
        for (int v = 0; v < V; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        while (i < V - 1 && e < E) {
            Edge next_edge = edges[e++];
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);
            if (x != y) {
                result[i++] = next_edge;
                union(subsets, x, y);
            }
        }
        System.out.println("Edges in the constructed MST:");
        for (i = 0; i < V - 1; ++i)
            System.out.println(result[i].src + " - " + result[i].dest + ": " + result[i].weight);
    }

    public static void main(String[] args) {
        int V = 4;
        int E = 5;

        KrushkalMST graph = new KrushkalMST(V, E);
        graph.edges[0] = new Edge(0, 1, 10);
        graph.edges[1] = new Edge(0, 2, 6);
        graph.edges[2] = new Edge(0, 3, 5);
        graph.edges[3] = new Edge(1, 3, 15);
        graph.edges[4] = new Edge(2, 3, 4);

        graph.krushkalMST();
    }
}
