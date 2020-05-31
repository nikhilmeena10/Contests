import java.io.*;
import java.util.StringTokenizer;

public class B {

    //after seeing editorial
    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        Print printer = new Print();
        int t = fs.nextInt();
        while (t > 0) {
            String s = fs.nextToken();
            int total_ones = 0, total_zeros = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') total_ones++;
                else total_zeros++;
            }
            int ans = s.length();
            ans = Math.min(total_ones, total_zeros);
            int ones_so_far = 0, zeros_so_far = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') ones_so_far++;
                else zeros_so_far++;
                ans = Math.min(ans, zeros_so_far + total_ones - ones_so_far);
                ans = Math.min(ans, ones_so_far + total_zeros - zeros_so_far);
            }
            printer.println(ans);
            t--;
        }
        printer.close();
    }

//    public static void main(String[] args) throws IOException {
//        FastScanner fs = new FastScanner();
//        Print printer = new Print();
//        int t = fs.nextInt();
//        while (t > 0) {
//            String s = fs.nextToken();
//            char[] ca = s.toCharArray();
//            int tb = s.length(), count = 0, start = 0, mbs = 0, mbe = s.length() - 1;
//            while (tb > 2) {
//                for (int i = 1; i < s.length(); i++) {
//                    if (ca[i] != ca[i - 1]) {
//                        tb++;
//                        if ((i - start + 1) < (mbe - mbs + 1)) {
//                            mbe = i - 1;
//                            mbs = start;
//                        }
//                        start = i;
//                    }
//                }
//                for (int i = mbs; i <= mbe; i++) {
//                    if (ca[i] == '0') ca[i] = '1';
//                    else ca[i] = '0';
//                    count++;
//                }
//            }
//            printer.println(count);
//            t--;
//        }
//        printer.close();
//    }

//    public static void main(String[] args) throws IOException {
//        FastScanner fs = new FastScanner();
//        Print printer = new Print();
//        int n = fs.nextInt();
//        for (int i = 0; i < n; i++) {
//            String s = fs.nextToken();
//            LinkedList<Chunk> ll = new LinkedList<>();
//            PriorityQueue<Chunk> pq = new PriorityQueue<>(new Comparator<Chunk>() {
//                @Override
//                public int compare(Chunk o1, Chunk o2) {
//                    int l1 = o1.end - o1.start + 1;
//                    int l2 = o2.end - o2.start + 1;
//                    if (l1 < l2) return -1;
//                    else if (l1 > l2) return 1;
//                    else return 0;
//                }
//            });
//            int start = 0;
//            for (int i = 1; i < s.length(); i++) {
//                if (s.charAt(i) != s.charAt(i - 1)) {
//                    //chunk finished
//                    Chunk chunk = new Chunk(start, i - 1);
//                    ll.add(chunk);
//                    pq.add(chunk);
//                }
//            }
//            int count = 0;
//            while (pq.size() > 2) {
//                Chunk minC = pq.remove();
//                int mcs = minC.start;
//                int mce = minC.end;
//                int mci = ll.indexOf(minC);
//                if (mcs == 0) {
//                    Chunk mcn = ll.get(mci + 1);
//
//                }
//            }
//        }
//        printer.close();
//    }

//    private static class Chunk {
//        int start, end;
//
//        public Chunk(int s, int e) {
//            start = s;
//            end = e;
//        }
//    }

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
