import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Kafukaaa on 2016/9/7.
 */
public class BrainsPhotos {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    List<String>  color = new ArrayList<>(n*m);
    for (int i = 0; i < n*m; i++) {
      color.add(scanner.next());
    }

    String result = "#Black&White";
    for (String flag:color){
      if (flag.equals("C") || flag.equals("M") || flag.equals("Y")){
        result = "#Color";
      }
    }
    System.out.println(result);
  }
}
