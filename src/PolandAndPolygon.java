import java.util.Scanner;

/**
 * Created by Kafukaaa on 2017/1/20.
 */
public class PolandAndPolygon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        Integer k = scanner.nextInt();

        Integer flag = 1, plus = 1;
        Integer times = n - (2*k-1+(n/k)*2-2);
        for (int i = 0; i < n; i++) {
            if (i < n/k){
                flag++;
                System.out.println(flag);
            }else if (i+n/k >= n){
                flag = flag + k*2 - 1;
                System.out.println(flag);
            }else if (plus == k && times > 0){
                flag = flag + plus;
                times--;
                System.out.println(flag);
            }else {
                plus++;
                flag = flag + plus;
                System.out.println(flag);
            }
        }
    }
}
