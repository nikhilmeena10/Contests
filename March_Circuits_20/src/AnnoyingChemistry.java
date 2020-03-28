import java.io.*;
import java.util.StringTokenizer;

class AnnoyingChemistry {
    public static void main(String args[]) throws Exception {
        FastScanner fs = new FastScanner();
        int x = fs.nextInt();
        int y = fs.nextInt();
        int p = fs.nextInt();
        int q = fs.nextInt();
        int z = p + q;
        z = -z;
        int p1 = gcd(x, y);
        int a1 = x / p1, b1 = y / p1;
        long[] s1 = xgcd(a1, b1);
        long u0 = s1[1] * z / s1[0];
        long v0 = s1[2] * z / s1[0];
        long[] s2 = xgcd(z, p1);
        int z0 = 0, t0 = 0;
        int x0 = 0, y0 = 0;
        //General soln
        int k, m; //any values in Z
        while (true) {
            int ten = 10;
            for (k = -ten; k <= ten; k++) {
                for (m = -ten; m <= ten; m++) {
                    long xs = b1 * k - u0 * m;
                    long ys = -a1 * k - v0 * m;
                    if (xs <= 0 || ys <= 0) continue;
                    long zs = p1 * m;
                    if (zs * p == x * xs && zs * q == y * ys) {
                        System.out.println(xs + " " + ys + " " + zs);
                        System.exit(0);
                    }
                }
            }
            ten *= 10;
            if (ten >= 1000) break;
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
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
