import java.util.Scanner;

/**
 * Created by Kafukaaa on 2017/3/26.
 */
public class NotAfraid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int k = scanner.nextInt();
            int[] v = new int[n+2];
            for (int j = 0; j < n+2; j++) {
                v[j] = 1;
            }
            for (int j = 0; j < k; j++) {
                int a = scanner.nextInt();
                if (v[Math.abs(a)+1] != (-1)*(Math.abs(a)+1)*(Math.abs(a)+1)){
                    if (a < 0 && v[Math.abs(a)+1] != (-1)*(Math.abs(a)+1)) {
                        v[-a+1] = v[-a+1] * (a-1);
                    } else if (a > 0 && v[Math.abs(a)+1] != (Math.abs(a)+1)){
                        v[a+1] = v[a+1] * (a+1);
                    }
                }
            }

            int flag = 0;
            for (int j = 2; j < n+2; j++) {
                if (v[j] == -j*j*1){
                    flag++;
                }
            }
            if (flag == 0){
                System.out.println("YES");
                System.exit(0);
            }
        }
        System.out.println("NO");
    }
}
