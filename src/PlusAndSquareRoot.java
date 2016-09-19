import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Kafukaaa on 2016/9/19.
 */
public class PlusAndSquareRoot {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    long answer, j;

    long x = 2, k = 2, m = 1;
    while (k <= n+1){
      if (x % m == 0) {
        j = k * m;
        answer = j*k - x / m;
        x = j;
        k++;
        System.out.println(answer);
      }
      m ++;
    }
  }
}
