import java.util.PriorityQueue;
import java.util.Scanner;

public class A_Workout {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; ++t) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            long[] m = new long[n];
            for (int i = 0; i < n; i++) {
                m[i] = sc.nextLong();
            }
            PriorityQueue<Interval> pq = new PriorityQueue<>();
            for (int i = 1; i < n; i++) {
                long d = m[i] - m[i - 1];
                Interval interval = new Interval(d, m[i - 1], m[i]);
                pq.add(interval);
            }
            int count = 0;
            while (!pq.isEmpty() && pq.peek().diff > 1 && count < k) {
                Interval top = pq.remove();
                if (top.diff > 1) {
                    long newi = (top.start + top.end) / 2;
                    pq.add(new Interval(newi - top.start, top.start, newi));
                    pq.add(new Interval(top.end - newi, newi, top.end));
                    count++;
                }
            }
            long ans = pq.peek() == null ? 1 : pq.peek().diff;
            System.out.println("Case #" + t + ": " + ans);
        }
    }

    static class Interval implements Comparable<Interval> {
        long diff;
        long start, end;

        public Interval(long d, long s, long e) {
            diff = d;
            start = s;
            end = e;
        }

        @Override
        public int compareTo(Interval o) {
            if (this.diff < o.diff) return 1;
            else if (this.diff > o.diff) return -1;
            else return 0;
        }
    }

}
