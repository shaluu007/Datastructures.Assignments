package DataStructures.Algorithms;

import java.util.Arrays;

public class BellmanFordAlgorithm {

    static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    int V, E;
    Edge[] edges;

    BellmanFordAlgorithm(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[e];
    }

    void bellmanFord(int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = edges[j].src;
                int v = edges[j].dest;
                int weight = edges[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }
        for (int j = 0; j < E; ++j) {
            int u = edges[j].src;
            int v = edges[j].dest;
            int weight = edges[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }
        printSolution(dist, src);
    }

    void printSolution(int[] dist, int src) {
        System.out.println("Vertex Distance from Source (" + src + "):");
        for (int i = 0; i < V; ++i)
            System.out.println("Vertex " + i + " : Distance = " + dist[i]);
    }

    public static void main(String[] args) {
        int V = 5;
        int E = 6; 
        BellmanFordAlgorithm graph = new BellmanFordAlgorithm(V, E);
        graph.edges[0] = new Edge(0, 1, 5);
        graph.edges[1] = new Edge(0, 2, 4);
        graph.edges[2] = new Edge(1, 3, 3);
        graph.edges[3] = new Edge(2, 1, -6);
        graph.edges[4] = new Edge(2, 3, 2);
        graph.edges[5] = new Edge(3, 4, 3);

        int src = 0;
        graph.bellmanFord(src);
    }
}
