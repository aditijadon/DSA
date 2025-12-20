package graph;

public class Driver {
    public static void main(String[] args) {
        Graph graph = new Graph(6); // Graph with 6 vertices
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);

        GraphOps op = new GraphOps();
        System.out.println("----------------- BFS ----------------");
        op.bfs(graph, 0);
        System.out.println("----------------- DFS ----------------");
        op.dfs(graph, 0);
        System.out.println("----------------- Has Cycle? ----------------");
        op.hasCycleBfsUndirected(graph);
    }
}
