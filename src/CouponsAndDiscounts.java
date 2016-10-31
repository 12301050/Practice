import java.util.Scanner;

/**
 * Created by Kafukaaa on 16/10/31.
 */
public class CouponsAndDiscounts {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Integer n = scanner.nextInt();
    Integer[] number = new Integer[n];
    for (int i = 0; i < n; i++) {
      number[i] = scanner.nextInt();
    }

    Integer amount = 0;
    for (int i = 0; i < n; i++) {
      if (number[i] != 0){
        amount += number[i];
      }else {
        if (amount%2 == 1){
          break;
        }
      }
    }
    if (amount%2 == 1){
      System.out.println("NO");
    }else {
      System.out.println("YES");
    }
  }
}

