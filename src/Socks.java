import java.util.Scanner;

/**
 * Created by Kafukaaa on 16/10/31.
 */
public class Socks {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int k = scanner.nextInt();
    int[] times = new int[n];
    int[] l = new int[m];
    int[] r = new int[m];

    int[] socks = new int[n];
    for (int i = 0; i < n; i++) {
      socks[i] = scanner.nextInt()-1;
    }

    int result = 0;
    for (int i = 0; i < m; i++) {
      l[i] = scanner.nextInt()-1;
      r[i] = scanner.nextInt()-1;
    }

    for (int i = 0; i < m; i++) {

    }
    System.out.println(result);

  }
}
