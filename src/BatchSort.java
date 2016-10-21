import java.util.Scanner;

/**
 * Created by Kafukaaa on 16/10/19.
 */
public class BatchSort {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int[][] number = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        number[i][j] = scanner.nextInt();
      }
    }

    int result = 1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (number[i][j] != j) {
          int flag = number[i][number[i][j]];
          number[i][number[i][j]] = number[i][j];
          number[i][j] = flag;
          break;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (number[i][j] != j) {
          if (number[i][j] != j){

          }
        }
      }
    }
  }
}
