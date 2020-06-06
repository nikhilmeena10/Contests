import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int t = sc.nextInt();
            while (t > 0) {
                int n = sc.nextInt();
                int k = sc.nextInt();
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    int p = sc.nextInt();
                    if (p > k) {
                        sum += p - k;
                    }
                }
                System.out.println(sum);
                t--;
            }
        }
    }
}
