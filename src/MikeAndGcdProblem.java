import java.util.Scanner;

/**
 * Created by Kafukaaa on 2017/5/2.
 */
public class MikeAndGcdProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        Integer[] s = new Integer[n];
        for (int i = 0; i < n; i++) {
            s[i] = scanner.nextInt();
        }

        Integer result = 0;
        Integer flag = gcd(s[0], s[1]);
        for (int i = 2; i < n; i++) {
            flag = gcd(s[i], flag);
        }
        if (flag > 1) {
            System.out.println("YES");
            System.out.println(0);
            System.exit(0);
        }

        for (int i = 0; i < n - 1; i++) {
            if (s[i] % 2 == 1 && s[i + 1] % 2 == 1) {
                s[i] = 2;
                s[i + 1] = 2;
                result++;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            if ((s[i] % 2 == 0 && s[i + 1] % 2 == 1) || s[i] % 2 == 1 && s[i + 1] % 2 == 0) {
                s[i] = 2;
                s[i + 1] = 2;
                result += 2;
            }
        }
        System.out.println("YES");
        System.out.println(result);
    }

    private static Integer gcd(Integer a, Integer b) {
        if (a % b == 0) {
            return Math.abs(b);
        } else {
            return gcd(b, a % b);
        }
    }
}
