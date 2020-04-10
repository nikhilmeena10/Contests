import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CARSELL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t > 0) {
                int n = sc.nextInt();
                Integer[] arr = new Integer[n];
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = sc.nextInt();
                }
                Arrays.sort(arr, Collections.reverseOrder());
                long sum = 0;
                long mod = 1000000007;
                for (int i = 0; i < n; i++) {
                    if (arr[i] - i > 0) {
                        sum = (sum % mod + arr[i] % mod - i % mod) % mod;
                    } else {
                        break;
                    }
                }
                System.out.println(sum);
                t--;
            }
        }
    }
}

//import java.util.HashSet;
//import java.util.NoSuchElementException;
//import java.util.Scanner;
//import java.util.Set;
//
//public class CARSELL {
//
//    public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextInt()) {
//            int t = sc.nextInt();
//            while (t > 0) {
//                int n = sc.nextInt();
//                IndexMinPQ<Integer> pq = new IndexMinPQ<>(n);
//                Set<Integer> indices = new HashSet<>();
//                for (int i = 0; i < n; i++) {
//                    int num = sc.nextInt();
//                    pq.insert(i, num);
//                    indices.add(i);
//                }
//                long sum = 0;
//                long mod = 1000000007;
//                while (!pq.isEmpty() && pq.minKey() > 0) {
//                    int minKey = pq.minKey();
//                    int index = pq.delMin();
//                    sum = ((sum % mod) + (minKey % mod)) % mod;
//                    indices.remove(index);
//                    for (int i : indices) {
//                        int key = pq.keyOf(i);
//                        pq.changeKey(i, key - 1);
//                    }
//                }
//                System.out.println(sum);
//                t--;
//            }
//        }
//    }
//
//    static class IndexMinPQ<Key extends Comparable<Key>> {
//
//        private int maxN;
//        private int n;
//        private int[] pq;  //PQ of given indexes --> comparision based on key however
//        private int[] qp;  //store index of given index
//        private Key[] keys;  //store key for given index
//
//        public IndexMinPQ(int maxN) {
//            if (maxN < 0) throw new IllegalArgumentException();
//            this.maxN = maxN;
//            n = 0;
//            keys = (Key[]) new Comparable[maxN + 1];
//            pq = new int[maxN + 1];
//            qp = new int[maxN + 1];
//            for (int i = 0; i <= maxN; i++) {
//                qp[i] = -1;
//            }
//        }
//
//        public boolean isEmpty() {
//            return n == 0;
//        }
//
//        public boolean contains(int i) {
//            validateIndex(i);
//            return qp[i] != -1;
//        }
//
//        public int size() {
//            return n;
//        }
//
//        public void insert(int i, Key key) {
//            validateIndex(i);
//            if (contains(i)) throw new IllegalArgumentException("index is already in the priority queue");
//            n++;
//            qp[i] = n;
//            pq[n] = i;
//            keys[i] = key;
//            swim(n);
//        }
//
//        public int minIndex() {
//            if (n == 0) throw new NoSuchElementException("Priority Queue underflow");
//            return pq[1];
//        }
//
//        public Key minKey() {
//            if (n == 0) throw new NoSuchElementException("Priority Queue underflow");
//            return keys[pq[1]];
//        }
//
//        public int delMin() {
//            if (n == 0) throw new NoSuchElementException("Priority Queue underflow");
//            int min = pq[1];
//            exch(1, n--);
//            sink(1);
//            assert min == pq[n + 1];
//            qp[min] = -1;
//            keys[min] = null;
//            pq[n + 1] = -1;
//            return min;
//        }
//
//        public Key keyOf(int i) {
//            validateIndex(i);
//            if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
//            else return keys[i];
//        }
//
//        public void changeKey(int i, Key key) {
//            validateIndex(i);
//            if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
//            keys[i] = key;
//            swim(qp[i]);
//            sink(qp[i]);
//        }
//
//        public void decreaseKey(int i, Key key) {
//            validateIndex(i);
//            if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
//            if (keys[i].compareTo(key) == 0) {
//                throw new IllegalArgumentException("calling decreaseKey() with a key equal to the key in the priority queue");
//            }
//            if (keys[i].compareTo(key) < 0) {
//                throw new IllegalArgumentException("calling decreaseKey() with a key strictly greater than the key in the priority queue");
//            }
//            keys[i] = key;
//            swim(qp[i]);
//        }
//
//        public void increaseKey(int i, Key key) {
//            validateIndex(i);
//            if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
//            if (keys[i].compareTo(key) == 0) {
//                throw new IllegalArgumentException("calling increaseKey() with a key equal to the key in the priority queue");
//            }
//            if (keys[i].compareTo(key) > 0) {
//                throw new IllegalArgumentException("calling increaseKey() with a key strictly lesser than the key in the priority queue");
//            }
//            keys[i] = key;
//            sink(qp[i]);
//        }
//
//        public void delete(int i) {
//            validateIndex(i);
//            if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
//            int index = qp[i];
//            exch(index, n--);
//            swim(index);
//            sink(index);
//            keys[i] = null;
//            qp[i] = -1;
//        }
//
//        private void validateIndex(int i) {
//            if (i < 0) throw new IllegalArgumentException("index is negative: " + i);
//            if (i >= maxN) throw new IllegalArgumentException("index >= capacity: " + i);
//        }
//
//        private boolean greater(int i, int j) {
//            return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
//        }
//
//        private void exch(int i, int j) {
//            int swap = pq[i];
//            pq[i] = pq[j];
//            pq[j] = swap;
//            qp[pq[i]] = i;
//            qp[pq[j]] = j;
//        }
//
//        private void swim(int k) {
//            while (k > 1 && greater(k / 2, k)) {
//                exch(k, k / 2);
//                k = k / 2;
//            }
//        }
//
//        private void sink(int k) {
//            while (2 * k <= n) {
//                int j = 2 * k;
//                if (j < n && greater(j, j + 1)) j++;
//                if (!greater(k, j)) break;
//                exch(k, j);
//                k = j;
//            }
//        }
//
//        public static void main(String[] args) {
//            // insert a bunch of strings
//            String[] strings = {"it", "was", "the", "best", "of", "times", "it", "was", "the", "worst"};
//
//            IndexMinPQ<String> pq = new IndexMinPQ<String>(strings.length);
//            for (int i = 0; i < strings.length; i++) {
//                pq.insert(i, strings[i]);
//            }
//
//            // delete and print each key
//            while (!pq.isEmpty()) {
//                int i = pq.delMin();
//                System.out.println(i + " " + strings[i]);
//            }
//            System.out.println();
//
//            // reinsert the same strings
//            for (int i = 0; i < strings.length; i++) {
//                pq.insert(i, strings[i]);
//            }
//        }
//    }
//
//}
