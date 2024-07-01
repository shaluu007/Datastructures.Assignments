package DataStructures.Algorithms;

import java.util.Arrays;
public class FloyadWarshallAlgorithm {
	    static final int INF = 9999999;
	    public static void floydWarshall(int[][] graph, int V) {
	        int[][] dist = new int[V][V];
	        for (int i = 0; i < V; i++) {
	            for (int j = 0; j < V; j++) {
	                dist[i][j] = graph[i][j];
	            }
	        }
	        for (int k = 0; k < V; k++) {
	            for (int i = 0; i < V; i++) {
	                for (int j = 0; j < V; j++) {
	                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
	                        dist[i][j] = dist[i][k] + dist[k][j];
	                    }
	                }
	            }
	        }
	        printSolution(dist, V);
	    }
	    public static void printSolution(int[][] dist, int V) {
	        System.out.println("The shortest distances between every pair of vertices:");
	        for (int i = 0; i < V; i++) {
	            for (int j = 0; j < V; j++) {
	                if (dist[i][j] == INF) {
	                    System.out.print("INF\t");
	                } else {
	                    System.out.print(dist[i][j] + "\t");
	                }
	            }
	            System.out.println();
	        }
	    }

	    public static void main(String[] args) {
	        int[][] graph = {
	            {0, INF, -2, INF},
	            {4, 6, 3, INF},
	            {INF, INF, 0, 2},
	            {INF, -7, INF, 0}
	        };
	        
	        int V = graph.length;
	        floydWarshall(graph, V);
	    }
	}
