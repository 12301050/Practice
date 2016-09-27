import java.util.Scanner;

/**
 * Created by Kafukaaa on 2016/9/27.
 */
public class VityaInTheCountryside {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scanner.nextInt();
    }

    if (n == 1){
      if (a[0] == 15) {
        System.out.println("DOWN");
      }else if (a[0] == 0){
        System.out.println("UP");
      }else {
        System.out.println(-1);
      }
    }else {
      if (a[n-1] == 15){
        System.out.println("DOWN");
      }else if (a[n-1] == 0){
        System.out.println("UP");
      }else if (a[n-1]-a[n-2] > 0) {
        System.out.println("UP");
      }else {
        System.out.println("DOWN");
      }
    }
  }
}
