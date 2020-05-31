import java.io.*;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        Print printer = new Print();
        int t = fs.nextInt();
        while (t > 0) {
            int n = fs.nextInt();
            int x = fs.nextInt();
            int[] arr = new int[n];
            int oc = 0, ec = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = fs.nextInt();
                if (arr[i] % 2 == 0) ec++;
                else oc++;
            }
            if (x % 2 != 0) {
                if (x <= oc) printer.println("Yes");
                else {
                    if (oc % 2 != 0) {
                        printer.println("Yes");
                    } else {
                        if (oc == 0) {
                            printer.println("No");
                        } else {
                            if (ec >= x - oc + 1) {
                                printer.println("Yes");
                            } else {
                                printer.println("No");
                            }
                        }
                    }
                }
            } else {
                if (x < oc) {
                    if (ec >= 1) {
                        printer.println("Yes");
                    } else {
                        printer.println("No");
                    }
                } else {
                    if (oc % 2 != 0) {
                        printer.println("Yes");
                    } else {
                        if (oc == 0) {
                            printer.println("No");
                        } else {
                            if (ec >= x - oc + 1) {
                                printer.println("Yes");
                            } else {
                                printer.println("No");
                            }
                        }
                    }
                }
            }
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
