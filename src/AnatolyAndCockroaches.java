import java.util.Scanner;

/**
 * Created by Kafukaaa on 2016/9/27.
 */
public class AnatolyAndCockroaches {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    String cockroaches = scanner.next();

    char[] c = cockroaches.toCharArray();
    int b1 = 0, b2 = 0, r1 = 0, r2 = 0;
    int color1 = 'b', color2 = 'r';
    for (int i = 0; i < n; i++) {
      if (color1 != c[i]) {
        if (c[i] == 'b') {
          b1++;
        } else {
          r1++;
        }
      }
      if (color2 != c[i]){
        if (c[i] == 'b'){
          b2++;
        }else {
          r2++;
        }
      }
      color1 = 'b'+'r' - color1;
      color2 = 'b'+'r' - color2;
    }
    System.out.println(Math.min(Math.max(b1,r1),Math.max(b2,r2)));
  }
}
