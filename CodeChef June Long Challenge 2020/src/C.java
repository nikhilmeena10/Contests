import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int t = sc.nextInt();
            while (t > 0) {
                int n = sc.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
                boolean canSell = true;
                int n5 = 0, n10 = 0, n15 = 0;
                for (int i = 0; i < n; i++) {
                    int val = arr[i];
                    if (val == 5) n5++;
                    else if (val == 10) {
                        if (n5 == 0) {
                            canSell = false;
                            break;
                        } else {
                            n10++;
                            n5--;
                        }
                    } else if (val == 15) {
                        if (n5 == 0 && n10 == 0) {   //no 5s, no 10s
                            canSell = false;
                            break;
                        } else if (n5 == 0) {   //only 10s
                            n10--;
                            n15++;
                        } else if (n10 == 0) {   //only 5s
                            if (n5 < 2) {
                                canSell = false;
                                break;
                            } else {
                                n5--;
                                n5--;
                                n15++;
                            }
                        } else {    //both 5s and 10s
                            n10--;
                            n15++;
                        }
                    }
                }
                String ans = canSell ? "YES" : "NO";
                System.out.println(ans);
                t--;
            }
        }
    }
}
