import java.io.*;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        Print printer = new Print();
        int n = fs.nextInt();
        while (n > 0) {
            long a = fs.nextLong();
            long b = fs.nextLong();
            if (a == b) {
                printer.println(0);
            } else {
                long gcd = gcd(a, b);
                long ag = a / gcd;
                long bg = b / gcd;
                if (ag > bg) {
                    if (bg != 1) {
                        printer.println(-1);
                    } else {
                        if (ag % 2 != 0) {
                            printer.println(-1);
                        } else {
                            int pow = 0;
                            while (ag % 8 == 0) {
                                ag = ag / 8;
                                pow++;
                            }
                            while (ag % 4 == 0) {
                                ag = ag / 4;
                                pow++;
                            }
                            while (ag % 2 == 0) {
                                ag = ag / 2;
                                pow++;
                            }
                            if (ag != 1) {
                                printer.println(-1);
                            } else {
                                printer.println(pow);
                            }
                        }
                    }
                } else if (ag < bg) {
                    if (ag != 1) {
                        printer.println(-1);
                    } else {
                        if (bg % 2 != 0) {
                            printer.println(-1);
                        } else {
                            int pow = 0;
                            while (bg % 8 == 0) {
                                bg = bg / 8;
                                pow++;
                            }
                            while (bg % 4 == 0) {
                                bg = bg / 4;
                                pow++;
                            }
                            while (bg % 2 == 0) {
                                bg = bg / 2;
                                pow++;
                            }
                            if (bg != 1) {
                                printer.println(-1);
                            } else {
                                printer.println(pow);
                            }
                        }
                    }
                }
            }
            n--;
        }
        printer.close();
    }

    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
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
