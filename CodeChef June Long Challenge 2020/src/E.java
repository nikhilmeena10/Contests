import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int t = sc.nextInt();
            while (t > 0) {
                int n = sc.nextInt();
                int[][] matrix = new int[n][n];
                int val = 1;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = val;
                        val++;
                    }
                }
                if (n % 2 == 0) {
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (i % 2 != 0) {
                                int tmp = matrix[i][j];
                                matrix[i][j] = matrix[i][j + 1];
                                matrix[i][j + 1] = tmp;
                                j++;
                            }
                        }
                    }
                }
                List<String> list = new ArrayList<>();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        sb.append(matrix[i][j]);
                        sb.append(" ");
                    }
                    list.add(sb.toString().substring(0, sb.length() - 1));
                    sb = new StringBuilder();
                }
                for (String s : list) {
                    System.out.println(s);
                }
                t--;
            }
        }
    }
}
