import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BFS {

    private Queue<Integer> q;
    private boolean[] visited;
    private int[] d, p;

    public BFS(Graph g, int s) {
        this.q = new ArrayDeque<>();
        this.visited = new boolean[g.V()];
        this.d = new int[g.V()];
        this.p = new int[g.V()];
        bfs(g, s);
    }

    private void bfs(Graph g, int s) {
        q.add(s);
        visited[s] = true;
        p[s] = -1;
        while (!q.isEmpty()) {
            int v = q.remove();
            for (int u : g.adj(v)) {
                if (!visited[u]) {
                    visited[u] = true;
                    q.add(u);
                    d[u] = d[v] + 1;
                    p[u] = v;
                }
            }
        }
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> stack = new Stack<>();
        for (int u = v; u != -1; u = p[u]) {
            stack.push(u);
        }
        return stack;
    }

    private void printShortestPath(int s) {
        Stack<Integer> stack = (Stack<Integer>) pathTo(s);
        if (stack == null) {
            System.out.println("No path!");
        } else {
            System.out.print("Path for " + s + ": ");
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
            System.out.println();
        }
    }

    private boolean hasPathTo(int v) {
        return visited[v];
    }

    private int distTo(int v) {
        return d[v];
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8 + 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(5, 8);
        graph.addEdge(6, 7);
        graph.addEdge(7, 8);
        BFS b = new BFS(graph, 1);
        for (int i = 1; i < graph.V(); i++) {
            b.printShortestPath(i);
        }
    }
}
