import java.io.*;
import java.util.StringTokenizer;

public class B {
    //after reading editorial
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        Print printer = new Print();
        int t = fs.nextInt();
        while (t > 0) {
            int n = fs.nextInt();
            int[] arr = new int[n];
            int[] val = new int[n];
            boolean hasZero = false, hasOne = false, isSorted = true;
            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextInt();
                if (i > 0 && arr[i] < arr[i - 1]) {
                    isSorted = false;
                }
            }
            for (int i = 0; i < n; i++) {
                val[i] = fs.nextInt();
                if (val[i] == 0) hasZero = true;
                if (val[i] == 1) hasOne = true;
            }
            if (hasZero && hasOne) {
                printer.println("Yes");
            } else if (isSorted) {
                printer.println("Yes");
            } else {
                printer.println("No");
            }
            /*int n = fs.nextInt();
            int onec = 0, zeroc = 0;
            int[] arr = new int[n];
            int[] arr1 = new int[n];
            for (int i = 0; i < n; i++) {
                int val = fs.nextInt();
                arr[i] = val;
                arr1[i] = val;
            }
            Arrays.sort(arr1);
            int diff = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] != arr1[i]) diff++;
            }
            for (int i = 0; i < n; i++) {
                int val2 = fs.nextInt();
                if (val2 == 1) onec++;
                else zeroc++;
            }
            int min = Math.min(zeroc, onec);
            if (min < diff / 2) {
                printer.println("No");
            } else {
                printer.println("Yes");
            }*/
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
