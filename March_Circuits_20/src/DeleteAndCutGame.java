import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/practice-problems/algorithm/delete-and-cut-game-91969de1/description/
//this is causing stackoverflow, not sure why, same as solution below:
//https://www.hackerearth.com/submission/39123300/
class DeleteAndCutGame {

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
        int total = bridge.bridgesList.size();
        int evenBridges = bridge.evenBridges;
        if (total == 0) System.out.println(0 + " " + 0);
        else {
            System.out.println(evenBridges * modInv(total, 1000000007) + " "
                    + (total - evenBridges) * modInv(total, 1000000007));
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
        private int[] size;
        private int evenBridges;
        private List<List<Integer>> bridgesList;

        public Bridge(Graph G) {
            low = new int[G.V()];
            pre = new int[G.V()];
            size = new int[G.V()];
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
            size[v] = 1;
            for (int w : G.adj(v)) {
                if (pre[w] == -1) {
                    dfs(G, v, w);
                    low[v] = Math.min(low[v], low[w]);
                    size[v] += size[w];
                    if (low[w] > pre[v]) {
                        //System.out.println(v + "-" + w + " is a bridge");
                        List<Integer> bridge = new ArrayList<>();
                        bridge.add(v);
                        bridge.add(w);
                        bridgesList.add(bridge);
                        bridges++;
                        if (size[v] % 2 == 0 && (G.V() - size[v]) % 2 == 0) evenBridges++;
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
}
