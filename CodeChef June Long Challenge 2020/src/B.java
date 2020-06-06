import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int t = sc.nextInt();
            while (t > 0) {
                String s = sc.next();
                int count = 0;
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (c == 'x') {
                        if (i + 1 < s.length() && s.charAt(i + 1) == 'y') {
                            count++;
                            i++;
                        }
                    } else if (c == 'y') {
                        if (i + 1 < s.length() && s.charAt(i + 1) == 'x') {
                            count++;
                            i++;
                        }
                    }
                }
                System.out.println(count);
                t--;
            }
        }
    }
}
