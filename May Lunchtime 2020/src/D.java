import java.io.IOException;
import java.util.*;

public class D {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int t = sc.nextInt();
            while (t > 0) {
                int n = sc.nextInt();
                int q = sc.nextInt();
                Graph g = new Graph(n + 1);
                Map<Integer, Integer> nv = new HashMap<>();
                Map<Integer, Map<Integer, List<Integer>>> paths = new HashMap<>();
                for (int i = 1; i <= n; i++) {
                    nv.put(i, sc.nextInt());
                }
                for (int i = 1; i <= n - 1; i++) {
                    g.addEdge(sc.nextInt(), sc.nextInt());
                }
                for (int i = 1; i <= n; i++) {
                    BFS bfs = new BFS(g, i);
                    Map<Integer, List<Integer>> m2 = new HashMap<>();
                    for (int j = 1; j != i && j <= n; j++) {
                        List<Integer> pathi = (ArrayList<Integer>) bfs.pathTo(j);
                        m2.put(j, pathi);
                    }
                    paths.put(i, m2);
                }
                while (q > 0) {
                    int u = sc.nextInt();
                    int v = sc.nextInt();
                    List<Integer> pl = paths.get(u).get(v);
                    Collections.sort(pl);
                    int minDiff = Integer.MAX_VALUE;
                    for (int i = 0; i < pl.size() - 1; i++) {
                        int fi = pl.get(i);
                        int se = pl.get(i + 1);
                        if ((se - fi) < minDiff) {
                            minDiff = se - fi;
                        }
                    }
                    System.out.println(minDiff);
                    q--;
                }
                t--;
            }
        }
    }
}
