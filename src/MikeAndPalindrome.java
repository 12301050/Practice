import java.util.Scanner;

/**
 * Created by Kafukaaa on 2017/5/2.
 */
public class MikeAndPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char[] ss = s.toCharArray();

        Integer flag = 0;
        for (int i = 0; i < ss.length / 2; i++) {
            if (ss[i] != ss[ss.length - i - 1]) {
                flag++;
            }
        }

        if ((flag == 0 && ss.length % 2 ==0) || flag > 1 ){
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
