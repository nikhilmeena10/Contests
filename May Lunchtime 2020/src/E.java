import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class E {

    //after understanding editorial
    public static void main(String[] args) throws IOException {
        //FastScanner fs = new FastScanner();
        Print printer = new Print();
        Scanner fs = new Scanner(System.in);
        while (fs.hasNext()) {
            int t = fs.nextInt();
            while (t > 0) {
                int n = fs.nextInt();
                List<Integer> pos = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    int val = fs.nextInt();
                    if (val == 1) pos.add(i);
                }
                if (pos.size() == 0) {
                    printer.println(0);
                } else if (pos.size() == 1) {
                    printer.println(-1);
                } else {
                    int ans = n;
                    for (int i = 0; i < 3; i++) {
                        int calc = solvedp(pos, n);
                        ans = Math.min(ans, calc);
                        pos.add(pos.remove(0) + n);
                    }
                    printer.println(ans);
                }
                t--;
            }
        }
        printer.close();
    }

    private static int solvedp(List<Integer> list, int N) {
        int n = list.size();
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = N;
        //(int) 1e6;
        for (int i = 2; i <= n; i++) {
            dp[i] = list.get(i - 1) - list.get(i - 2) + dp[i - 2];
            if (i >= 3) dp[i] = Math.min(dp[i], list.get(i - 1) - list.get(i - 3) + dp[i - 3]);
        }
        return dp[n];
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
