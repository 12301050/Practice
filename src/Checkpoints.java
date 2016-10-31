import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Kafukaaa on 2016/8/26.
 */
public class Checkpoints {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        Arrays.sort(array);
        int result,result1,result2,result3,result4;
        if (n == 1){
            result = 0;
        }else {
            if (a <= array[0]) {
                result = array[n - 2] - a;
            } else if (a >= array[n - 1]) {
                result = a - array[1];
            } else {
                result1 = Math.abs(array[n - 1] - array[1]) + Math.abs(array[n - 1] - a);
                result2 = Math.abs(array[n - 1] - array[1]) + Math.abs(array[1] - a);
                result3 = Math.abs(array[n - 2] - array[0]) + Math.abs(array[n - 2] - a);
                result4 = Math.abs(array[n - 2] - array[0]) + Math.abs(array[0] - a);
                result =Math.min(Math.min(result1,result2),Math.min(result3,result4));
            }
        }
        System.out.println(result);
    }
}