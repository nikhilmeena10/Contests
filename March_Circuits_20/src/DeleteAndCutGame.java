import java.io.*;
import java.util.*;

public class DeleteAndCutGame {

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int m = fs.nextInt();
        Graph g = new Graph(n + 1);
        for (int i = 0; i < m; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            g.addEdge(u, v);
        }
        Bridge bridge = new Bridge(g);
        List<List<Integer>> bridges = bridge.getBridgesList();
        int total = bridges.size();
        int a = 0, b = 0;
        for (List<Integer> list : bridges) {
            int u = list.get(0);
            int v = list.get(1);
            g.adj[u].remove((Integer) v);
            g.adj[v].remove((Integer) u);
            ConnectedComponents cc = new ConnectedComponents(g);
            Set<Integer> set = new HashSet<>();
            for (int i : cc.id) {
                set.add(cc.size(i));
            }
            int countOdd = 0;
            for (int i : set) {
                if (i % 2 != 0) {
                    countOdd++;
                }
            }
            if (countOdd > 0) b++;
            else a++;
            g.adj[u].add(v);
            g.adj[v].add(u);
        }
        long totalInv1, totalInv2;
        int total1 = total, total2 = total;
        if (a == 0) {
            System.out.println(0 + " " + 1);
        } else if (b == 0) {
            System.out.println(1 + " " + 0);
        } else {
            //reduce to coprime numbers
            int atg = gcd(a, total);
            if (atg != 1) {
                a = a / atg;
                total1 = total / atg;
            }
            totalInv1 = a * modInv(total1, 1000000007);

            int btg = gcd(b, total);
            if (btg != 1) {
                b = b / btg;
                total2 = total / btg;
            }
            totalInv2 = b * modInv(total2, 1000000007);
            System.out.println(totalInv1 + " " + totalInv2);
        }
    }

    public static long modInv(int a, int m) {

        long[] retvals = xgcd(a, m);
        long gcd = retvals[0];
        if (gcd != 1) {
            //System.out.println("Modular Inverse does not exist");
            return 0;
        } else {
            long x = retvals[1], y = retvals[2];
            x = (x % m + m) % m;
            //System.out.println("The modular inverse is : " + x);
            return x;
        }
    }

    public static long[] xgcd(long a, long b) {
        long[] retvals = {0, 0, 0};
        long aa[] = {1, 0}, bb[] = {0, 1}, q = 0;
        while (true) {
            q = a / b;
            a = a % b;
            aa[0] = aa[0] - q * aa[1];
            bb[0] = bb[0] - q * bb[1];
            if (a == 0) {
                retvals[0] = b;
                retvals[1] = aa[1];
                retvals[2] = bb[1];
                return retvals;
            }
            q = b / a;
            b = b % a;
            aa[1] = aa[1] - q * aa[0];
            bb[1] = bb[1] - q * bb[0];
            if (b == 0) {
                retvals[0] = a;
                retvals[1] = aa[0];
                retvals[2] = bb[0];
                return retvals;
            }
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }

    static class Graph {

        private int V, E;
        private List<Integer>[] adj;

        public Graph(int V) {
            this.V = V;
            this.E = 0;
            adj = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new ArrayList<>();
            }
        }

        public void addEdge(int v, int w) {
            E++;
            adj[v].add(w);
            adj[w].add(v);
        }

        public List<Integer> adj(int v) {
            return adj[v];
        }

        public int degree(int v) {
            return adj[v].size();
        }

        public int V() {
            return V;
        }

        public int E() {
            return E;
        }
    }

    static class Bridge {

        private int bridges;
        private int count;
        private int[] pre;  //pre[v] = order in which dfs examines v --> just an id for each v when doing DFS
        private int[] low;  //low[v] = lowest preorder of any vertex connected to v --> lowest id reachable from v
        private List<List<Integer>> bridgesList;

        public Bridge(Graph G) {
            low = new int[G.V()];
            pre = new int[G.V()];
            Arrays.fill(low, -1);
            Arrays.fill(pre, -1);
            bridgesList = new ArrayList<>();
            for (int v = 0; v < G.V(); v++) {
                if (pre[v] == -1) {
                    dfs(G, v, v);
                }
            }
        }

        public int components() {
            return bridges + 1;
        }

        private void dfs(Graph G, int u, int v) {
            pre[v] = count++;
            low[v] = pre[v];
            for (int w : G.adj(v)) {
                if (pre[w] == -1) {
                    dfs(G, v, w);
                    low[v] = Math.min(low[v], low[w]);
                    if (low[w] > pre[v]) {
                        //System.out.println(v + "-" + w + " is a bridge");
                        List<Integer> bridge = new ArrayList<>();
                        bridge.add(v);
                        bridge.add(w);
                        bridgesList.add(bridge);
                        bridges++;
                    }
                } else if (w != u) {
                    low[v] = Math.min(low[v], pre[w]);
                }
            }
        }

        public List<List<Integer>> getBridgesList() {
            return bridgesList;
        }
    }

    static class ConnectedComponents {

        private boolean[] marked;
        private int[] id;    //id of a connected component
        private int[] size;  //size of connected component with given id
        private int count;   //connected components count

        public ConnectedComponents(Graph G) {
            marked = new boolean[G.V()];
            id = new int[G.V()];
            size = new int[G.V()];
            for (int v = 0; v < G.V(); v++) {
                if (!marked[v]) {
                    dfs(G, v);
                    count++;
                }
            }
        }

        private void dfs(Graph G, int v) {
            marked[v] = true;
            id[v] = count;
            size[count]++;
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    dfs(G, w);
                }
            }
        }

        public int id(int v) {
            validateVertex(v);
            return id[v];
        }

        public int size(int v) {
            validateVertex(v);
            return size[id[v]];
        }

        public int count() {
            return count;
        }

        public boolean connected(int v, int w) {
            validateVertex(v);
            validateVertex(w);
            return id(v) == id(w);
        }

        private void validateVertex(int v) {
            int V = marked.length;
            if (v < 0 || v >= V)
                throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
        }
    }
}
