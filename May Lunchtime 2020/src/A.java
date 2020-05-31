import java.io.IOException;
import java.util.Scanner;

public class A {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int t = sc.nextInt();
            while (t > 0) {
                int[] arr = new int[5];
                for (int i = 0; i < 5; i++) {
                    arr[i] = sc.nextInt();
                }
                int p = sc.nextInt();
                int limit = 24 * 5;
                int sum = 0;
                for (int i = 0; i < 5; i++) {
                    sum += arr[i] * p;
                }
                if (sum > limit) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
                t--;
            }
        }
    }
}
