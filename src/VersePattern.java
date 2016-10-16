import java.util.Scanner;

/**
 * Created by Kafukaaa on 16/10/15.
 */
public class VersePattern {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    String[] t = new String[n];
    int[] p = new int[n];
    for (int i = 0; i < n; i++) {
      p[i] = scanner.nextInt();
    }

    String useless = scanner.nextLine();
    for (int i = 0; i < n; i++) {
      t[i] = scanner.nextLine();
    }

    int result = 1;
    for (int i = 0; i < n; i++) {
      int flag = 0;
      char[] text = t[i].toCharArray();
      if (t[i].length() == 1){
      }
      for (int j = 0; j < t[i].length(); j++) {
        if (text[j] == 97 || text[j] == 101 ||text[j] == 105 || text[j] == 111
            || text[j] == 117 || text[j] == 121){
          flag++;
        }
      }
      if (flag != p[i]){
        result = 0;
        break;
      }
    }

    if (result == 0){
      System.out.println("NO");
    }else {
      System.out.println("YES");
    }
  }
}
