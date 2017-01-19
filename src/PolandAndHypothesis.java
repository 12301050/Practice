import java.util.Scanner;

/**
 * Created by Kafukaaa on 2017/1/19.
 */
public class PolandAndHypothesis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        if (n == 1){
            System.out.println(3);
        }else if (n == 2) {
            System.out.println(4);
        }else {
            System.out.println(n - 2);
        }
    }
}
