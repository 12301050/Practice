import java.util.Scanner;

/**
 * Created by Kafukaaa on 16/9/16.
 */
public class MeetingOfOldFriends {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long l1 = scanner.nextLong();
    long r1 = scanner.nextLong();
    long l2 = scanner.nextLong();
    long r2 = scanner.nextLong();
    long k = scanner.nextLong();
    long result = 0;
    if (r1 >= r2){
      if (l1 <= l2) {
        result = r2 - l2 + 1;
        if (l2 <= k && k <= r2 ){
          result = result - 1;
        }
      }else if (l1 <= r2) {
        result = r2 - l1 + 1;
        if (l1 <= k && k <= r2) {
          result = result - 1;
        }
      }
    }else if (l2 <= r1 && l2 >= l1){
      result = r1 - l2 + 1;
      if (k <= r1 && k >= l2){
        result = result - 1;
      }
    }else if (l2 <= r1 && l2 <= l1) {
      result = r1 - l1 + 1;
      if (k <= r1 && k >= l2) {
        result = result - 1;
      }
    }
    System.out.println(result);
  }
}
