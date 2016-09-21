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
    int[] sumOfColor = new int[m];
    int[] degree = new  int[m];
    for (int i = 0; i < m; i++) {
      start[i] = scanner.nextInt();
      degree[start[i]]++;
      end[i] = scanner.nextInt();
      degree[end[i]]++;
      color[i] = scanner.nextInt();
      sumOfColor[color[i]]++;
    }

    int flag = 0;
    for (int i = 0; i < m; i++) {
      if (degree[i] == 1){
        for (int j = 0; j < m; j++) {
          if (start[j] == i || end[j] == i){
            degree[start[j]]--;
            degree[end[j]]--;
          }
        }
      }
    }

    int s = -1, e = -1;
    for (int i = 0; i < m; i++) {
      if (degree[i] == 2){
        for (int j = 0; j < m; j++) {
          if (start[j] == i){
            if (s == -1){
              s = end[j];
            }else if (e == -1){
              e = end[j];
            }
          }else if (end[j] == i){
            if (s == -1){
              s = end[j];
            }else if (e == -1){
              e = end[j];
            }
          }

        }
      }
    }

  }
}
