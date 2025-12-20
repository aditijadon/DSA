package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GraphOps {
    public void dfs(Graph graph, int start){
        int V = graph.getVertices();
        boolean[] visited = new boolean[V];
        dfsUtil(graph, start, visited);
        System.out.println();
    }

    public void dfsUtil(Graph graph, int v, boolean[] visited){
        visited[v] = true;
        System.out.print(v + " ");
        for (int neighbor : graph.getAdj(v)) {
            if (!visited[neighbor]) {
                dfsUtil(graph, neighbor, visited);
            }
        }
    }

    public void bfs(Graph graph, int start){
        int V = graph.getVertices();
        boolean[] visited = new boolean[V]; // Track visited vertices
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.print(curr + " ");
            for (int neighbor : graph.getAdj(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public boolean hasCycleBfsUndirected(Graph graph){
        int V = graph.getVertices();
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];
        Arrays.fill(parent, -1);
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (detectCycleBfsUndirected(graph, i, visited, parent)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean detectCycleBfsUndirected(Graph graph, int start, boolean[] visited, int[] parent){
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            for (int neighbor : graph.getAdj(vertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    parent[neighbor] = vertex;
                } else if (parent[vertex] != neighbor) {
                    return true;
                }
            }
        }
        return false;
    }

//        public boolean detectCycleDfsUndirected(){
//
//    }
//
//    public boolean detectCycleBfsDirected(){
//
//    }
//
//    public boolean detectCycleDfsDirected(){
//
//    }
//    public int findNumberOfIslands(){
//
//    }
}
