import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Kafukaaa on 16/9/17.
 */
public class FliyaAndHomework {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scanner.nextInt();
    }
    if (n <= 2){
      System.out.println("YES");
    }else {
      Arrays.sort(a);
      int flag = 1;
      for (int i = 1; i < n-1; i++) {
        if (a[i] != a[0] && a[i] != a[n-1]){
          if ((a[0] + a[n-1]) % 2 == 1 || a[i] != (a[0] + a[n-1])/2){
            flag = 0;
          }
        }
      }
      if (flag == 1){
        System.out.println("YES");
      }else {
        System.out.println("NO");
      }
    }
  }
}
