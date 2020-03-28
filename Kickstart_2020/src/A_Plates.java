import java.util.*;

public class A_Plates {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; ++t) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int p = sc.nextInt();
            List<Node> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                Node dummyHead = new Node(0);
                Node start = dummyHead;
                for (int j = 0; j < k; j++) {
                    int value = sc.nextInt();
                    Node curr = new Node(value);
                    dummyHead.next = curr;
                    dummyHead = dummyHead.next;
                }
                list.add(start.next);
            }
            Comparator<Node> cmp = new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o2.val - o1.val;
                }
            };
            PriorityQueue<Node> pq = new PriorityQueue<>(cmp);
            for (Node node : list) {
                pq.add(node);
            }
            int max = 0;
            for (int i = 0; i < p; i++) {
                Node top = pq.remove();
                max += top.val;
                if (top.next != null) {
                    pq.add(top.next);
                }
            }
            System.out.println("Case #" + t + ": " + max);
        }
    }

    static class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
        }
    }

}
