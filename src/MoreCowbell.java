import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Kafukaaa on 2016/8/30.
 */
public class MoreCowbell {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = scanner.nextInt();
        }

        int result = 0;
        if (n == 1 || n <= k){
            result = s[n-1];
        }else if (n == 2*k){
            int[] a = new int[k];
            for (int i = 0; i < k; i++) {
                a[i] = s[i]+s[n-1-i];
            }
            Arrays.sort(a);
            result = a[k-1];
        }else if (k < n && n < 2*k){
            int[] b = new int[k];
            for (int i = 0; i < n-k; i++) {
                b[i] = s[i] + s[2*n-2*k-1-i];
            }
            for (int i = 0; i < 2*k-n; i++) {
                b[n-k+i] = s[2*n-2*k+i];
            }
            Arrays.sort(b);
            result = b[k-1];
        }
        System.out.println(result);
    }
}
