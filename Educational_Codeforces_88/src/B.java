import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        Print printer = new Print();
        int t = fs.nextInt();
        while (t > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            int x = fs.nextInt();
            int y = fs.nextInt();
            char[][] matrix = new char[n][m];
            for (int i = 0; i < n; i++) {
                String line = fs.nextToken();
                for (int j = 0; j < line.length(); j++) {
                    matrix[i][j] = line.charAt(j);
                }
            }
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int cont = 0;
                for (int j = 0; j < m; j++) {
                    while ((j < m - 1) && (matrix[i][j] == '.') && (matrix[i][j] == matrix[i][j + 1])) {
                        cont++;
                        j++;
                    }
                    if (matrix[i][j] == '.') cont++;
                    if (cont != 0) {
                        list.add(cont);
                        cont = 0;
                    }
                }
            }
            int ans = 0;
            for (int len : list) {
                if (2 * x < y) {
                    ans += x * len;
                } else {
                    ans += y * (len / 2);
                    ans += x * (len % 2);
                }
            }
            printer.println(ans);
            t--;
        }
        printer.close();
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
