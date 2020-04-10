import java.util.Scanner;

public class COVIDLQ {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t > 0) {
                int n = sc.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
                boolean flag = false;
                int start = -6;
                for (int i = 0; i < n; i++) {
                    if (arr[i] == 1) {
                        int diff = i - start;
                        if (diff < 6) {
                            flag = true;
                            break;
                        } else {
                            start = i;
                        }
                    }
                }
                if (flag) System.out.println("NO");
                else System.out.println("YES");
                t--;
            }
        }
    }

}
