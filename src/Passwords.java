import java.util.Scanner;

/**
 * Created by Kafukaaa on 2016/10/10.
 */
public class Passwords {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int k = scanner.nextInt();
    String[] pwd = new String[n];
    for (int i = 0; i < n; i++) {
      pwd[i] = scanner.next();
    }

    String password = scanner.next();
    int max = 0, min = 0;
    int[] length = new int[101];
    for (int i = 0; i < n; i++) {
      length[pwd[i].length()]++;
    }

    for (int i = 0; i < 101; i++) {
      if (length[i] >0 && i < password.length()){
        min = min + length[i];
        max = max + length[i];
      }else if (length[i] >0 && i == password.length()){
        min = min+1;
        max = max+length[i];
      }
    }

    min = (min-1)/k*5 + min;
    max = (max-1)/k*5 + max;
    System.out.print(min + " " + max);
  }
}
