import java.io.*;
import java.util.StringTokenizer;

public class C {
    //after reading editorial
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        Print printer = new Print();
        int tc = fs.nextInt();
        while (tc > 0) {
            int h = fs.nextInt();
            int c = fs.nextInt();
            int t = fs.nextInt();
            if (2 * t <= (h + c)) {
                printer.println(2);
            } else {
                int k = (h - t) / (2 * t - h - c);
                int lhs = Math.abs(((k + 1) * h + k * c - t * (2 * k + 1))) * (2 * k + 3);
                int rhs = Math.abs(((k + 2) * h + (k + 1) * c - (2 * k + 3) * t)) * (2 * k + 1);
                if (lhs <= rhs) {
                    printer.println(2 * k + 1);
                } else {
                    printer.println(2 * k + 3);
                }
            }
            tc--;
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
