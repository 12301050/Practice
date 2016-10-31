import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Kafukaaa on 16/9/25.
 */
public class InterestingDrink {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] x = new int[n];
    for (int i = 0; i < n; i++) {
      x[i] = scanner.nextInt();
    }

    Arrays.sort(x);
    int max = x[n-1];
    int min = x[0];
    int q = scanner.nextInt();
    for (int i = 0; i < q; i++) {
      int answer = 0;
      int m = scanner.nextInt();
      if (m < min) {
        System.out.println(0);
      } else if (m >= max) {
        System.out.println(n);
      } else {
        int start = 0;
        int end = n-1;
        if (n == 2){
          answer = 1;
        }else {
          while (true) {
            if (start+1 == end) {
              if (m >= x[end]) {
                answer = end+1;
              }else {
                answer = start+1;
              }
              break;
            }else if (m < x[(start + end + 1) / 2]) {
              end = (start+end) / 2;
            }else if (m >= x[(start + end + 1) / 2]){
              start = (start+end)/2;
            }
          }
        }
      }
    }
  }
}

