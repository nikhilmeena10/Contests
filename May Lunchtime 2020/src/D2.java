import java.io.*;
import java.util.*;

public class D2 {

    private static int[] arr;
    private static int[] parent;
    private static int[] depth;
    private static boolean[] visited;
    private static int[] check;
    private static List<Integer>[] adj;

    private static void init(int n) {
        arr = new int[n];
        parent = new int[n];
        depth = new int[n];
        visited = new boolean[n];
        check = new int[101];
        adj = new ArrayList[n];
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        Print printer = new Print();
        int t = fs.nextInt();
        while (t > 0) {
            int n = fs.nextInt();
            init(n);
            int q = fs.nextInt();
            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextInt();
                adj[i] = new ArrayList<>();
            }
            for (int i = 0; i < n - 1; i++) {
                int u = fs.nextInt() - 1;
                int v = fs.nextInt() - 1;
                adj[u].add(v);
                adj[v].add(u);
            }
            Arrays.fill(parent, 0);
            Arrays.fill(depth, 0);
            Arrays.fill(visited, false);
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            visited[0] = true;
            depth[0] = 0;
            parent[0] = -1;
            while (!stack.isEmpty()) {
                int u = stack.pop();
                for (int w : adj[u]) {
                    if (!visited[w]) {
                        visited[w] = true;
                        stack.push(w);
                        parent[w] = u;
                        depth[w] = depth[u] + 1;
                    }
                }
            }
            for (int j = 1; j <= q; j++) {
                int a = fs.nextInt() - 1;
                int b = fs.nextInt() - 1;
                Arrays.fill(check, 0);
                if (depth[a] < depth[b]) {
                    int tmp = a;
                    a = b;
                    b = tmp;
                }
                boolean ex = false;
                while (depth[a] > depth[b]) {
                    if (check[arr[a]] > 0) {
                        ex = true;
                        break;
                    }
                    check[arr[a]]++;
                    a = parent[a];
                }
                if (a == b) {
                    if (check[arr[a]] > 0) {
                        ex = true;
                    }
                    check[arr[a]]++;
                }
                if (ex) {
                    printer.println(0);
                } else {
                    if (a != b) {
                        while (a != b) {
                            if (check[arr[a]] > 0) {
                                ex = true;
                                break;
                            }
                            check[arr[a]]++;
                            a = parent[a];
                            if (check[arr[b]] > 0) {
                                ex = true;
                                break;
                            }
                            check[arr[b]]++;
                            b = parent[b];
                        }
                        if (check[arr[a]] > 0) {
                            ex = true;
                        }
                        check[arr[a]]++;
                    }
                    if (ex) {
                        printer.println(0);
                    } else {
                        int min = 200;
                        int prev = -1;
                        for (int i = 1; i <= 100; i++) {
                            if (check[i] > 0) {
                                if (prev != -1) min = Math.min(min, i - prev);
                                prev = i;
                            }
                        }
                        printer.println(min);
                    }
                }
            }
            t--;
        }
        printer.close();
    }

    static class FastScanner {
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
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

    static class Print {
        private final BufferedWriter bw;

        public Print() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }

}
