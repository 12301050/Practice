import java.util.Scanner;

/**
 * Created by Kafukaaa on 16/10/8.
 */
public class OneDimensionalJapaneseCrossword {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    String square = scanner.next();
    char[] s = square.toCharArray();

    int[] answer = new int[n];
    int flag1 = 0;
    int flag = 0;
    for (int i = 0; i < n; i++) {
      if (s[i] == 'B'){
        flag++;
        if (i == n-1){
          answer[flag1] = flag;
          flag1++;
        }
      }else if (s[i] == 'W'){
        if (i>0 && s[i-1] == 'B') {
          answer[flag1] = flag;
          flag1++;
        }
        flag = 0;
      }
    }

    System.out.println(flag1);
    for (int i = 0; i < n; i++) {
      if (answer[i] != 0){
        if (i == 0) {
          System.out.print(answer[i]);
        }else {
          System.out.print(" "+answer[i]);
        }
      }
    }
  }
}
