import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class MinimumANDxorOR {
    public static void main(String args[]) throws Exception {
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t > 0) {
            int n = fs.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextInt();
            }
            Arrays.sort(arr);
            int ans = Integer.MAX_VALUE;
            for (int i = 1; i < n; i++) {
                ans = Math.min(ans, arr[i] ^ arr[i - 1]);
            }
            System.out.println(ans);
            t--;
        }
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
}
