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
    int answer =0;
    if (n == 1){
      answer = 0;
    }else if (n == 2){
      if (c[0] == c[1]){
        answer = 1;
      }else {
        answer = 0;
      }
    }else if (n%3 == 0){
      for (int i = 0; i < n/3; i++) {
        if ((c[i*3-3] == c[i*3-2] && c[i*3] == c[i*3-1])){
          answer++;
        }
      }
    }
  }
}
