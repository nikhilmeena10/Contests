//https://discuss.codechef.com/t/trediff-editorial/67092

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String tline = buf.readLine();
        if (tline == null) System.exit(0);
        int t = Integer.parseInt(tline);
        while (t > 0) {
            String line = buf.readLine();
            if (line == null) break;
            String[] l1 = line.split("\\s+");
            int n = Integer.parseInt(l1[0]);
            int q = Integer.parseInt(l1[1]);
            int[] arr = new int[n];
            List<Integer>[] adj = new ArrayList[n];
            String[] l2 = buf.readLine().split("\\s+");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(l2[i]);
                adj[i] = new ArrayList<>();
            }
            for (int i = 0; i < n - 1; i++) {
                String[] l3 = buf.readLine().split("\\s+");
                int u = Integer.parseInt(l3[0]) - 1;
                int v = Integer.parseInt(l3[1]) - 1;
                adj[u].add(v);
                adj[v].add(u);
            }
            int[] parent = new int[n];
            int[] depth = new int[n];
            //let zero be root
            parent[0] = -1;
            depth[0] = 0;
            Stack<Integer> stack = new Stack<>();
            boolean[] visited = new boolean[n];
            stack.push(0);
            visited[0] = true;
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
            int[] check = new int[101];
            for (int i = 0; i < q; i++) {
                String[] l4 = buf.readLine().split("\\s+");
                int a = Integer.parseInt(l4[0]) - 1;
                int b = Integer.parseInt(l4[1]) - 1;
                //int climb = 0;
                Arrays.fill(check, 0);
                boolean ex = false;
                if (depth[a] > depth[b]) {
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
                } else if (depth[a] < depth[b]) {
                    while (depth[a] < depth[b]) {
                        if (check[arr[b]] > 0) {
                            ex = true;
                            break;
                        }
                        check[arr[b]]++;
                        b = parent[b];
                    }
                    if (a == b) {
                        if (check[arr[b]] > 0) {
                            ex = true;
                        }
                        check[arr[b]]++;
                    }
                }
                if (ex) {
                    System.out.println(0);
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
                    if (ex) System.out.println(0);
                    else {
                        int min = 200, prev = -1;
                        for (int j = 1; j <= 100; j++) {
                            if (check[j] > 0) {
                                if (prev != -1) min = Math.min(min, j - prev);
                                prev = j;
                            }
                        }
                        System.out.println(min);
                    }
                }
            }
            t--;
        }
    }
}
