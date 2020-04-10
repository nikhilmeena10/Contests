import java.util.Scanner;

public class SQRDSUB {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t > 0) {
                int n = sc.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = Math.abs(sc.nextInt());
                }
                int left = -1;
                boolean found = false;
                int even = 0;
                int right = n;
                long count = 0;
                for (int i = 0; i < n; i++) {
                    int val = arr[i];
                    if (val % 2 == 0) {
                        if (val % 4 == 2) {
                            if (found) {
                                int leftcount = even - left - 1;
                                count += leftcount;
                                int rightcount = i - even - 1;
                                count += rightcount;
                                count += 1;
                                count += ((long) leftcount * (long) rightcount);
                                left = even;
                                even = i;
                                found = true;
                            } else {
                                even = i;
                                found = true;
                            }
                        } else {
                            if (found) {
                                int leftcount = even - left - 1;
                                count += leftcount;
                                int rightcount = i - even - 1;
                                count += rightcount;
                                count += 1;
                                count += ((long) leftcount * (long) rightcount);
                                left = i;
                                found = false;
                            } else {
                                left = i;
                                found = false;
                            }
                        }
                    }
                }
                if (found) {
                    int leftcount = even - left - 1;
                    count += leftcount;
                    int rightcount = n - even - 1;
                    count += rightcount;
                    count += 1;
                    count += ((long) leftcount * (long) rightcount);
                }
                long total = (((long) n) * ((long) (n + 1))) / 2;
                long ans = total - count;
                System.out.println(ans);
                t--;
            }
        }
    }

    /*public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t > 0) {
                int n = sc.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = Math.abs(sc.nextInt());
                }
                int product = 1;
                int mod = 4;
                int count = 0;
                for (int i = 0; i < n; i++) {
                    product = 1;
                    for (int j = i; j < n; j++) {
                        product = ((product % mod) * (arr[j] % mod)) % mod;
                        if (product != 2) count++;

                    }
                }
                System.out.println(count);
                t--;
            }
        }
    }*/

}
