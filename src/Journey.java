import java.util.Scanner;

/**
 * Created by Kafukaaa on 2016/10/10.
 */
public class Journey {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int t = scanner.nextInt();
    int[][] road = new int[3][m];
    for (int i = 0; i < m; i++) {
      road[0][i] = scanner.nextInt();
      road[1][i] = scanner.nextInt();
      road[2][i] = scanner.nextInt();
    }

    int[] way = new int[n];
    way[0] = 1;
    int time = 0;
    int flag = 0;
    int[] flags = new int[m];
    for (int i = 0; i < m; i++) {
      if (i == m && way[flag] != n){
        for (int j = 0; j < m; j++) {
          if ((road[0][j] == way[flag-1] && road[1][j] == way[flag]) || road[0][j] == way[flag] && road[1][j] == way[flag-1]){
            time = time-road[2][j];
            flags[j] = 1;
          }
          if ((road[0][j] == way[flag-1] || road[1][j] == way[flag-1]) && flags[j] == 0){
            m = j;
            flag--;
            break;
          }
        }
      }
      if (road[0][i] == way[flag] && time+road[2][i] <= t && flags[i] == 0){
        flag++;
        way[flag] = road[1][i];
        time = time+road[2][i];
      }else if (road[1][i] == way[flag] && time+road[2][i] <= t && flags[i] == 0){
        flag++;
        way[flag] = road[0][i];
        time = time+road[2][i];
      }
    }

    System.out.println(flag+1);
    for (int i = 0; i < n; i++) {
      if (way[i] != 0){
        if (i > 0) {
          System.out.print(" " + way[i]);
        }else {
          System.out.print(way[i]);
        }
      }
    }
  }
}
