import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class STRNO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t > 0) {
                int x = sc.nextInt();  //number of factors
                int k = sc.nextInt();  //number of prime factors
                int a = x;
                List<Integer> list = new ArrayList<>();
                while (a % 2 == 0) {
                    list.add(2);
                    a /= 2;
                }

                for (int i = 3; i * i <= a; i += 2) {
                    while (a % i == 0) {
                        list.add(i);
                        a /= i;
                    }
                }

                if (a > 2) {
                    list.add(a);
                }

                if (list.size() < k) System.out.println(0);
                else System.out.println(1);

                t--;
            }
        }
    }
}
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//public class STRNO {
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextInt()) {
//            int t = sc.nextInt();
//            while (t > 0) {
//                int x = sc.nextInt();
//                int k = sc.nextInt();
//                int i = 1;
//                while (true) {
//                    int a = i;
//                    int powCount = 0;
//                    Map<Integer, Integer> primePow = new HashMap<>();
//                    while (a % 2 == 0) {
//                        a = a / 2;
//                        powCount++;
//                    }
//                    if (powCount > 0) primePow.put(2, powCount);
//                    for (int j = 3; j * j <= a; j += 2) {
//                        powCount = 0;
//                        while (a % j == 0) {
//                            a = a / j;
//                            powCount++;
//                        }
//                        if (powCount > 0) primePow.put(j, powCount);
//                    }
//                    if (a > 2) {
//                        primePow.put(a, 1);
//                    }
//                    int numberOfFactors = 1;
//                    int primes = 0;
//                    for (Map.Entry<Integer, Integer> entry : primePow.entrySet()) {
//                        int prime = entry.getKey();
//                        int count = entry.getValue();
//                        primes++;
//                        numberOfFactors *= (count + 1);
//                    }
//                    if (numberOfFactors == x && primes == k) {
//                        System.out.println(1);
//                        break;
//                    }
//                    i++;
//                    if (i >= 100000) {
//                        System.out.println(0);
//                        break;
//                    }
//                }
//                t--;
//            }
//        }
//    }
//}
