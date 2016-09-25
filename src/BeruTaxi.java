import java.util.Scanner;

/**
 * Created by Kafukaaa on 16/9/23.
 */
public class BeruTaxi {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    int n = scanner.nextInt();
    int [] taxi = new int[n];
    int [][] point = new int[n][3];
    for (int i = 0; i < n; i++) {
      point[i][0] = Math.abs(a-scanner.nextInt());
      point[i][1] = Math.abs(b-scanner.nextInt());
      point[i][2] = scanner.nextInt();
    }

    double answer = 10000;
    for (int i = 0; i < n; i++) {
      if (point[i][0] == 0 && point[i][1] == 0){
        answer = 0;
        break;
      }else {
        double distance = Math.sqrt((point[i][0]*point[i][0] + point[i][1] * point[i][1])) / point[i][2];
        if (distance < answer){
          answer = distance;
        }
      }
    }
    System.out.println(answer);
  }
}
