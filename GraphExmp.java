package DataStructures.Graph;

import java.util.*;
class GraphExmp {
 Map<Integer, List<Integer>> adjacencyList;
 public GraphExmp() {
     this.adjacencyList = new HashMap<>();
 }
 public void addVertex(int vertex) {
     adjacencyList.put(vertex, new LinkedList<>());
 }
 public void addEdge(int vertex1, int vertex2) {
     if (!adjacencyList.containsKey(vertex1)) {
         addVertex(vertex1);
     }
     adjacencyList.get(vertex1).add(vertex2);
     if (!adjacencyList.containsKey(vertex2)) {
         addVertex(vertex2);
     }
     adjacencyList.get(vertex2).add(vertex1);
 }
 public void removeVertex(int vertex) {
     List<Integer> neighbors = adjacencyList.get(vertex);
     for (Integer neighbor : neighbors) {
         adjacencyList.get(neighbor).remove(Integer.valueOf(vertex)); 
     }
     adjacencyList.remove(vertex);
 }
 public void removeEdge(int vertex1, int vertex2) {
     if (adjacencyList.containsKey(vertex1) && adjacencyList.containsKey(vertex2)) {
         adjacencyList.get(vertex1).remove(Integer.valueOf(vertex2));
         adjacencyList.get(vertex2).remove(Integer.valueOf(vertex1));
     }
 }
 public boolean hasEdge(int vertex1, int vertex2) {
     if (adjacencyList.containsKey(vertex1) && adjacencyList.containsKey(vertex2)) {
         return adjacencyList.get(vertex1).contains(vertex2);
     }
     return false;
 }
 public boolean hasVertex(int vertex) {
     return adjacencyList.containsKey(vertex);
 }
 public void dfs(int startVertex) {
     Set<Integer> visited = new HashSet<>();
     dfsRecursive(startVertex, visited);
 }

 private void dfsRecursive(int vertex, Set<Integer> visited) {
     visited.add(vertex);
     System.out.print(vertex + " ");

     for (Integer neighbor : adjacencyList.get(vertex)) {
         if (!visited.contains(neighbor)) {
             dfsRecursive(neighbor, visited);
         }
     }
 }
 public void bfs(int startVertex) {
     Set<Integer> visited = new HashSet<>();
     Queue<Integer> queue = new LinkedList<>();

     visited.add(startVertex);
     queue.offer(startVertex);

     while (!queue.isEmpty()) {
         int vertex = queue.poll();
         System.out.print(vertex + " ");

         for (Integer neighbor : adjacencyList.get(vertex)) {
             if (!visited.contains(neighbor)) {
                 visited.add(neighbor);
                 queue.offer(neighbor);
             }
         }
     }
 }
}
