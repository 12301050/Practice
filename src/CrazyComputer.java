import java.util.Scanner;

/**
 * Created by Kafukaaa on 2016/9/18.
 */
public class CrazyComputer {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int c = scanner.nextInt();
    int[] number = new int[n];
    for (int i = 0; i < n; i++) {
      number[i] = scanner.nextInt();
    }
    int answer = 1;
    for (int i = 0; i < n-1; i++) {
      if (number[i+1] - number[i] <= c){
        answer ++;
      }else {
        answer = 1;
      }
    }
    System.out.println(answer);
  }
}
