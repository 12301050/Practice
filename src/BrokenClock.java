import java.util.Scanner;

/**
 * Created by Kafukaaa on 2016/10/11.
 */
public class BrokenClock {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int format = scanner.nextInt();
    String s = scanner.next();

    char[] clocks = s.toCharArray();
    if (format == 12){
      if (clocks[0] > 49){
        if (clocks[1] < 51){
          clocks[0] = 49;
        }else {
          clocks[0] = 48;
        }
      }else if (clocks[0] == 49 && clocks[1] > 50){
        clocks[1] = 50;
      }else if (clocks[0] == 48 && clocks[1] == 48){
        clocks[1] = 49;
      }
    }else if (format == 24){
      if (clocks[0] > 50){
        clocks[0] = 48;
      }
      if (clocks[0] == 50 && clocks[1] > 51){
        clocks[1] = 50;
      }
    }
    if (clocks[3] > 53){
      clocks[3] = 48;
    }

    System.out.println(String.valueOf(clocks));
  }
}
