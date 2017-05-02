import java.util.Scanner;

/**
 * Created by Kafukaaa on 2017/5/2.
 */
public class MikeAndStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = scanner.next();
        }

        Integer count = 2500;
        for (int i = 0; i < n; i++) {
            Integer count1 = 0;
            for (int j = 0; j < n; j++) {
                String flag = s[j];
                Integer length = flag.length();
                for (int k = 0; k < length; k++) {
                    if (s[i].equals(flag)) {
                        count1 = count1 + k;
                        break;
                    } else {
                        flag = flag.substring(1, length) + flag.substring(0, 1);
                    }
                    if (k == length - 1 && !s[i].equals(flag)) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
            }
            if (count1 < count) {
                count = count1;
            }
        }
        System.out.println(count);
    }
}
