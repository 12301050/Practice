import java.util.Scanner;

/**
 * Created by Kafukaaa on 16/10/31.
 */
public class NightAtTheMuseum {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String name = scanner.next();
    char[] letters = name.toCharArray();

    Integer result = 0;
    for (int i = 0; i < letters.length; i++) {
      if (i == 0){
        result += Math.min(letters[i] - 97, 26 - (letters[i] - 97));
      }else {
        result += Math.min(Math.abs(letters[i] - letters[i-1]), 26 - Math.abs(letters[i] - letters[i-1]));
      }
    }
    System.out.println(result);
  }
}
