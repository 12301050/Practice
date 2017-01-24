import java.util.Scanner;

/**
 * Created by Kafukaaa on 2017/1/24.
 */
public class HolidayAndEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();

        Integer sum = 0, max = 0, flag = 0;
        for (int i = 0; i < n; i++) {
            flag = scanner.nextInt();
            sum += flag;
            if (flag > max){
                max = flag;
            }
        }

        System.out.println(max*n-sum);
    }
}
