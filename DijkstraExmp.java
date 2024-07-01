package DataStructures.Algorithms;
import java.util.*;
class Graph {
 private int V;
 private List<List<Edge>> adj; 
 
 class Edge {
     int destination;
     int weight;
     
     public Edge(int dest, int weight) {
         this.destination = dest;
         this.weight = weight;
     }
 }
  public Graph(int V) {
     this.V = V;
     adj = new ArrayList<>(V);
     for (int i = 0; i < V; i++) {
         adj.add(new ArrayList<>());
     }
 }
  public void addEdge(int source, int destination, int weight) {
     Edge edge = new Edge(destination, weight);
     adj.get(source).add(edge);
 }
 
 public int[] dijkstra(int source) {
     int[] dist = new int[V];
     Arrays.fill(dist, Integer.MAX_VALUE);
     dist[source] = 0;
          PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(v -> dist[v]));
     pq.offer(source);
     
     while (!pq.isEmpty()) {
         int u = pq.poll();
             for (Edge edge : adj.get(u)) {
             int v = edge.destination;
             int weight = edge.weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                 dist[v] = dist[u] + weight;
                 pq.offer(v);
             }
         }
     }
     
     return dist;
 }
}

public class DijkstraExmp {
 public static void main(String[] args) {
     int V = 5; 
     int source = 0;
     
     Graph graph = new Graph(V);
     graph.addEdge(0, 1, 2);
     graph.addEdge(0, 3, 1);
     graph.addEdge(1, 2, 3);
     graph.addEdge(1, 3, 2);
     graph.addEdge(3, 4, 4);
     graph.addEdge(2, 4, 5);
     int[] shortestDistances = graph.dijkstra(source);
     System.out.println("Shortest distances from vertex " + source + " to all other vertices:");
     for (int i = 0; i < V; i++) {
         System.out.println("Vertex " + i + ": " + shortestDistances[i]);
     	}
 	}
}
