import java.util.Scanner;

/**
 * Created by Kafukaaa on 2016/8/31.
 */
public class ChrisAndMagicSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[][] a = new  long[n+1][n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scanner.nextLong();
            }
        }

        long result;
        if (n == 1){
            result = 3;
            System.out.println(result);
        }else {
            long sum;
            int flag = 0, x = 0, y = 0;
            for (int i = 0; i < n; i++) {
                sum = 0;
                for (int j = 0; j < n; j++) {
                    sum = sum + a[i][j];
                    if (a[i][j] == 0) {
                        x = i;
                        y = j;
                        flag++;
                    }
                }
                a[i][n] = sum;
            }
            if (x != 0) {
                a[x][y] = a[0][n] - a[x][n];
                a[x][n] = a[0][n];
            } else {
                a[x][y] = a[1][n] - a[x][n];
                a[x][n] = a[1][n];
            }
            result = a[x][y];
            if (result <= 0 || flag > 1){
                result = -1;
                System.out.println(result);
            }else {
                long amount = a[x][n];
                for (int i = 0; i < n; i++) {
                    if (a[i][n] != amount) {
                        result = -1;
                        i = n - 1;
                        System.out.println(result);
                    }
                }
                if (result >= 0) {
                    for (int i = 0; i < n; i++) {
                        sum = 0;
                        for (int j = 0; j < n; j++) {
                            sum = sum + a[j][i];
                        }
                        a[n][i] = sum;
                    }
                    for (int i = 0; i < n; i++) {
                        if (a[n][i] != amount) {
                            result = -1;
                            i = n - 1;
                            System.out.println(result);
                        }
                    }
                    if (result >= 0) {
                        sum = 0;
                        for (int i = 0; i < n; i++) {
                            sum = sum + a[i][i];
                        }
                        a[n][n] = sum;
                        if (a[n][n] != amount){
                            result = -1;
                            System.out.println(result);
                        }else {
                            sum = 0;
                            for (int i = n - 1; i >= 0; i--) {
                                sum = sum + a[n - 1 - i][i];
                            }
                            if (sum !=  amount) {
                                result = -1;
                                System.out.println(result);
                            }else {
                                System.out.println(result);
                            }
                        }
                    }
                }
            }
        }
    }
}
