import java.util.Scanner;

/**
 * Created by dell on 2016/8/26.
 */
public class Juicer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int d = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int amount = 0,count = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] <= b){
                amount = amount + a[i];
                if (amount > d){
                    amount = 0;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
