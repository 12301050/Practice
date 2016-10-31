import java.util.Scanner;

/**
 * Created by Kafukaaa on 2016/8/29.
 */
public class UncowedForces {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] m = new int[5];
        int[] w = new int[5];

        for (int i = 0; i < 5; i++) {
            m[i] = scanner.nextInt();
        }
        for (int i = 0; i < 5; i++) {
            w[i] = scanner.nextInt();
        }

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int result = 0;
        for (int i = 0; i < 5; i++) {
            result = (int)(result + Math.max(0.3*500*(i+1),500*(i+1)-m[i]*2*(i+1)-50*w[i]));
        }
        result = result+100*a-50*b;
        System.out.println(result);
    }
}
