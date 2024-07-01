package DataStructures.Graph;

import java.util.List;
import java.util.Map;

public class Main1 {
	 public static void main(String[] args) {
	     GraphExmp graph = new GraphExmp();
	     graph.addVertex(0);
	     graph.addVertex(1);
	     graph.addVertex(2);
	     graph.addVertex(3);
	     graph.addVertex(4);
	     graph.addEdge(0, 1);
	     graph.addEdge(0, 2);
	     graph.addEdge(1, 3);
	     graph.addEdge(2, 4);
	     graph.addEdge(3, 4);
	     System.out.println("Graph:");
	     System.out.println("Vertices: " + graph.adjacencyList.keySet());
	     System.out.println("Edges:");
	     for (Map.Entry<Integer, List<Integer>> entry : graph.adjacencyList.entrySet()) {
	         int vertex = entry.getKey();
	         List<Integer> neighbors = entry.getValue();
	         for (int neighbor : neighbors) {
	             if (vertex < neighbor) { 
	                 System.out.println(vertex + " -- " + neighbor);
	             }
	         }
	     }
	     System.out.println();
	     graph.removeEdge(1, 3);
	     graph.removeVertex(2);
	     System.out.println("Graph after removal:");
	     System.out.println("Vertices: " + graph.adjacencyList.keySet());
	     System.out.println("Edges:");
	     for (Map.Entry<Integer, List<Integer>> entry : graph.adjacencyList.entrySet()) {
	         int vertex = entry.getKey();
	         List<Integer> neighbors = entry.getValue();
	         for (int neighbor : neighbors) {
	             if (vertex < neighbor) {
	                 System.out.println(vertex + " -- " + neighbor);
	             }
	         }
	     }
	     System.out.println();
	     System.out.println("Does edge 0 -- 1 exist? " + graph.hasEdge(0, 1));
	     System.out.println("Does edge 1 -- 3 exist? " + graph.hasEdge(1, 3));
	     System.out.println("Does vertex 2 exist? " + graph.hasVertex(2));
	     System.out.println();
	     System.out.println("DFS traversal starting from vertex 0:");
	     graph.dfs(0);
	     System.out.println();
	     System.out.println("BFS traversal starting from vertex 0:");
	     graph.bfs(0);
	     System.out.println();
	 }
}
