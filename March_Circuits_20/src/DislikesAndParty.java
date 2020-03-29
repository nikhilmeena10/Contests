import java.io.*;
import java.util.*;

//https://www.hackerearth.com/problem/algorithm/dislikes-and-party-567b9605/description/
class DislikesAndParty {
    public static void main(String args[]) throws Exception {
        FastScanner fs = new FastScanner();
        long n = fs.nextLong();
        long total = n * n;
        Map<Long, Set<Long>> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            long k = fs.nextLong();
            for (int j = 0; j < 9; j++) {
                long m = fs.nextLong();
                if (map.containsKey(k)) {
                    Set<Long> list = map.get(k);
                    list.add(m);
                    map.put(k, list);
                } else {
                    Set<Long> list = new HashSet<>();
                    list.add(m);
                    map.put(k, list);
                }
                if (map.containsKey(m)) {
                    Set<Long> list = map.get(m);
                    list.add(k);
                    map.put(m, list);
                } else {
                    Set<Long> list = new HashSet<>();
                    list.add(k);
                    map.put(m, list);
                }
            }
        }
        int count = 0;
        for (Map.Entry<Long, Set<Long>> entry : map.entrySet()) {
            count += entry.getValue().size();
        }
        total -= count;
        total -= n;
        System.out.println(total / 2);
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
