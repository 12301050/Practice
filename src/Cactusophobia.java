import java.util.Scanner;

/**
 * Created by Kafukaaa on 16/9/20.
 */
public class Cactusophobia {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int[] start = new int[m];
    int[] end = new int[m];
    int[] color = new int[m];
    int[] cycle = new  int[m];
    for (int i = 0; i < m; i++) {
      start[i] = scanner.nextInt();
      end[i] = scanner.nextInt();
      color[i] = scanner.nextInt();
    }

    //计算圈的个数并记录围成每个圈的边
    for (int i = 0; i < m; i++) {

    }
  }
}
