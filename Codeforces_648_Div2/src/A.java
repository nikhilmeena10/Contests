import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class A {
    //after reading editorial
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        Print printer = new Print();
        int t = fs.nextInt();
        while (t > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            int[][] matrix = new int[n][m];
            Set<Integer> row = new HashSet<>();
            Set<Integer> col = new HashSet<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = fs.nextInt();
                    if (matrix[i][j] == 1) {
                        row.add(i);
                        col.add(j);
                    }
                }
            }
            int min = Math.min(n - row.size(), m - col.size());
            if (min % 2 == 0) printer.println("Vivek");
            else printer.println("Ashish");
            /*int n = fs.nextInt();
            int m = fs.nextInt();
            int[][] matrix = new int[n][m];
            Map<Integer, Boolean> row = new HashMap<>();
            Map<Integer, Boolean> col = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = fs.nextInt();
                    if (matrix[i][j] == 1) {
                        row.put(i, true);
                        col.put(j, true);
                    }
                }
            }
            int count = 0;
            Set<Integer> rowz = new HashSet<>();
            Set<Integer> colz = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (row.containsKey(i)) {
                    continue;
                }
                for (int j = 0; j < m; j++) {
                    if (col.containsKey(j)) {
                        continue;
                    }
                    if (colz.contains(j)) continue;
                    if (rowz.contains(i)) break;
                    count++;
                    colz.add(j);
                    rowz.add(i);
                }
            }
            if (count % 2 == 0) printer.println("Vivek");
            else printer.println("Ashish");*/
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
