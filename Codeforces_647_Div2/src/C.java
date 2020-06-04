import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        Print printer = new Print();
        int t = fs.nextInt();
        while (t > 0) {
            long n = fs.nextLong();
            int nbits = (int) (Math.log(n) / Math.log(2) + 1);
            long ans = 0L;
            BigInteger bi = new BigInteger("0");
            while (nbits >= 0) {
                long num = 1L << (nbits - 1);
                if ((n & num) != 0L) {
                    ans += nbits + Math.pow(2, nbits) - (nbits - 1L) - 2L;
                    BigInteger powo = (new BigInteger("2")).pow(nbits);
                    BigInteger sub1 = new BigInteger(Integer.toString(nbits - 1));
                    BigInteger sub2 = new BigInteger("2");
                    bi = bi.add(new BigInteger(Integer.toString(nbits)));
                    bi = bi.add(powo);
                    bi = bi.subtract(sub1);
                    bi = bi.subtract(sub2);
                }
                nbits--;
            }
            //printer.println(ans);
            printer.println(bi);
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
