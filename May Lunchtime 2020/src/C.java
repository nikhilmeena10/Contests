import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String tline = buf.readLine();
        if (tline == null) System.exit(0);
        int t = Integer.parseInt(tline);
        while (t > 0) {
            String line = buf.readLine();
            if (line == null) break;
            int n = Integer.parseInt(line);
            String a = buf.readLine();
            String b = buf.readLine();
            if (a.equals(b)) {
                System.out.println(0);
                t--;
                continue;
            }
            int[] acount = new int[26];
            int[] bcount = new int[26];
            Set<Character> diff = new HashSet<>();
            boolean br = false;
            for (int i = 0; i < n; i++) {
                char ac = a.charAt(i);
                acount[ac - 'a']++;
                char bc = b.charAt(i);
                bcount[bc - 'a']++;
                if (ac < bc) {
                    br = true;
                    break;
                }
                if (ac != bc) {
                    diff.add(bc);
                }
            }
            if (br) {
                System.out.println(-1);
            } else {
                br = false;
                for (int i = 0; i < 26; i++) {
                    if (bcount[i] != 0 && acount[i] == 0) {
                        br = true;
                        break;
                    }
                }
                if (br) {
                    System.out.println(-1);
                } else {
                    System.out.println(diff.size());
                    List<Character> list = new ArrayList<>(diff);
                    Collections.sort(list);
                    char[] acarr = a.toCharArray();
                    for (int i = list.size() - 1; i >= 0; i--) {
                        char ch = list.get(i);
                        List<Integer> pl = new ArrayList<>();
                        for (int j = 0; j < acarr.length; j++) {
                            if (acarr[j] >= ch && b.charAt(j) <= ch) {
                                pl.add(j);
                                acarr[j] = ch;
                            }
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append(pl.size());
                        sb.append(" ");
                        for (int p : pl) {
                            sb.append(p);
                            sb.append(" ");
                        }
                        String ps = sb.toString();
                        System.out.println(ps);
                    }
                }
            }
            t--;
        }

    }
}
