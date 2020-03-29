import java.io.*;
import java.util.StringTokenizer;

//See Google's official solution on the page
//https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ffc7/00000000001d40bb
public class A_Plates {

    //dp[i][j] denotes the maximum sum that can be obtained using the first i stacks
    //when we need to pick j plates in total. Therefore, dp[N][P] would give us the maximum
    //sum using the first N stacks if we need to pick P plates in total

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int T = fs.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            int p = fs.nextInt();
            int[][] stacks = new int[n + 1][k + 1];
            int[][] sum = new int[n + 1][k + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= k; j++) {
                    stacks[i][j] = fs.nextInt();
                    sum[i][j] = stacks[i][j] + sum[i][j - 1];
                }
            }
            int[][] dp = new int[n + 1][p + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= p; j++) {
                    dp[i][j] = 0;
                    for (int x = 0; x <= Math.min(j, k); x++) {
                        dp[i][j] = Math.max(dp[i][j], sum[i][x] + dp[i - 1][j - x]);
                    }
                }
            }
            System.out.println("Case #" + t + ": " + dp[n][p]);
        }
    }


    //Ashish Gupta's solution
    //https://www.youtube.com/watch?v=31tpPqRHthc
    /*static int n, k, p;
    static int[][] a, dp, prefix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; ++t) {
            n = sc.nextInt();
            k = sc.nextInt();
            p = sc.nextInt();
            a = new int[n + 1][k + 1];
            prefix = new int[n + 1][k + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= k; j++) {
                    a[i][j] = sc.nextInt();
                    prefix[i][j] = prefix[i][j - 1] + a[i][j];
                }
            }
            dp = new int[n + 1][p];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j < p; j++) {
                    dp[i][j] = -1;
                }
            }
            int ans = rec(1, 0);
            System.out.println("Case #" + t + ": " + ans);
        }
    }

    private static int rec(int idx, int taken) {
        System.out.println("idx: " + idx + " taken: " + taken);
        if (taken == p) return 0;
        if (idx > n || taken > p) return Integer.MIN_VALUE;
        if (dp[idx][taken] != -1) return dp[idx][taken];
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i <= k; i++) {
            System.out.println("i: " + i);
            System.out.println("prefix[idx][i] " + prefix[idx][i]);
            ans = Math.max(ans, prefix[idx][i] + rec(idx + 1, taken + i));
            System.out.println("ans: " + ans);
        }
        dp[idx][taken] = ans;
        System.out.println("dp[idx][taken]: " + dp[idx][taken]);
        return dp[idx][taken];
    }*/

    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; ++t) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int p = sc.nextInt();
            List<Node> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Node dummyHead = new Node(0);
                Node start = dummyHead;
                for (int j = 0; j < k; j++) {
                    int value = sc.nextInt();
                    Node curr = new Node(value);
                    dummyHead.next = curr;
                    dummyHead = dummyHead.next;
                }
                list.add(start.next);
            }
            Comparator<Node> cmp = new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o2.val - o1.val;
                }
            };
            PriorityQueue<Node> pq = new PriorityQueue<>(cmp);
            for (Node node : list) {
                pq.add(node);
            }
            int max = 0;
            for (int i = 0; i < p; i++) {
                Node top = pq.remove();
                max += top.val;
                if (top.next != null) {
                    pq.add(top.next);
                }
            }
            System.out.println("Case #" + t + ": " + max);
        }
    }

    static class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
        }
    }*/

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

}

