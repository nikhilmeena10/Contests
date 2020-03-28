import java.util.Arrays;
import java.util.Scanner;

public class A_Allocation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = sc.nextInt();
            int b = sc.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
            }
            Arrays.sort(a);
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (a[j] <= b) {
                    count++;
                    b -= a[j];
                } else {
                    break;
                }
            }
            System.out.println("Case #" + i + ": " + count);
        }
    }

}
