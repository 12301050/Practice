import java.util.Scanner;

/**
 * Created by Kafukaaa on 2017/7/26.
 */
public class SashaAndSticks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Long n = scanner.nextLong();
        Long k = scanner.nextLong();
        if (n / k % 2 == 1) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
