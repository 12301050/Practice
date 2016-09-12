import java.util.Scanner;

/**
 * Created by Kafukaaa on 2016/9/12.
 */
public class MemoryAndTrident {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String string = scanner.nextLine();
    int left = 0, right = 0, up = 0, down = 0, result = 0;
    if (string.length()%2 == 0) {
      for (int i = 0; i < string.length(); i++) {
        if (string.substring(i,i+1).equals("L")){
          left = left + 1;
        }else if (string.substring(i,i+1).equals("R")){
          right = right + 1;
        }else if (string.substring(i,i+1).equals("U")){
          up = up + 1;
        }else  if (string.substring(i,i+1).equals("D")){
          down = down + 1;
        }
      }
      result = (Math.abs(left - right)+Math.abs(up - down))/2;
      System.out.println(result);
    }else {
      System.out.println(-1);
    }
  }
}
