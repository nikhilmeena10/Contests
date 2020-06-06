import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int t = sc.nextInt();
            while (t > 0) {
                long n = sc.nextLong();
                if (n % 2L != 0) {
                    long ans = n / 2;
                    System.out.println(ans);
                } else {
                    int count = 0;
                    long n1 = n;
                    while (n % 2 == 0) {
                        n = n / 2;
                        count++;
                    }
                    long gr = 2;
                    for (int i = 1; i <= count; i++) {
                        gr *= 2;
                    }
                    long ans = n1 / gr;
                    System.out.println(ans);
                }
                t--;
            }
        }
    }
}
