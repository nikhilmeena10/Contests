import java.io.IOException;
import java.util.Scanner;

public class B {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int t = sc.nextInt();
            while (t > 0) {
                int n = sc.nextInt();
                int[] a = new int[n];
                int[] b = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = sc.nextInt();
                }
                for (int i = 0; i < n; i++) {
                    b[i] = sc.nextInt();
                }
                long w = 0;
                int xa = 0, xb = 0;
                for (int i = 0; i < n; i++) {
                    if (xa == xb) {
                        if (a[i] == b[i]) {
                            w += a[i];
                        }
                    }
                    xa += a[i];
                    xb += b[i];
                }
                System.out.println(w);
                t--;
            }
        }
    }
}
