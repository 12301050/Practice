import java.util.Scanner;

/**
 * Created by Kafukaaa on 2017/1/26.
 */
public class UnfairPoll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        Integer m = scanner.nextInt();
        Integer k = scanner.nextInt();
        Integer x = scanner.nextInt();
        Integer y = scanner.nextInt();

        if (n == 1){
            if (k%(n*m) > 0) {
                System.out.print(k / (n * m) + 1 + " ");
                System.out.print(k / (n * m) + " ");
                if (k%(n*m) > y){
                    System.out.print(k / (n * m) + 1);
                }else {
                    System.out.print(k / (n * m));
                }
            }else {
                System.out.print(k / (n * m) + " ");
                System.out.print(k / (n * m) + " ");
                System.out.print(k / (n * m));
            }
        }else {
            if (k % ((n - 1) * m) > 0) {
                Integer max = k / ((n - 1) * m) + 1;
            }
        }
    }
}
