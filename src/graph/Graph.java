package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private int V;
    private List<List<Integer>> adj;

    public Graph(int vertices) {
        V = vertices;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v);
    }

    public List<Integer> getAdj(int v) {
        return adj.get(v);
    }

    public int getVertices() {
        return V;
    }
}
