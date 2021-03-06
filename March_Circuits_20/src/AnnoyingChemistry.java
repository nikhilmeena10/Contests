import java.io.*;
import java.util.StringTokenizer;

//https://www.hackerearth.com/problem/algorithm/annoying-chemistry-f5fb9556/description/
class AnnoyingChemistry {
    public static void main(String args[]) throws Exception {
        FastScanner fs = new FastScanner();
        long x = fs.nextLong();
        long y = fs.nextLong();
        long p = fs.nextLong();
        long q = fs.nextLong();
        long b1 = p * y;
        long b2 = q * x;
        long b3 = (b1 * x) / p;
        long g = gcd(gcd(b1, b2), b3);
        b1 /= g;
        b2 /= g;
        b3 /= g;
        System.out.println(b1 + " " + b2 + " " + b3);
    }

    public static long gcd(long a, long b) {
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
}
