import java.util.Scanner;

/**
 * Created by Kafukaaa on 2016/9/18.
 */
public class CompleteTheWord {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String c = scanner.next();
    int[] flag = new int[26];
    int[] letter = new int[26];
    char[] s = c.toCharArray();

    int sum = 0;
    for (int i = 0; i < s.length; i++) {
      if (s[i] == '?'){
        if (sum < 26) {
          flag[sum] = i;
          sum++;
        }
      }else {
        letter[(int)s[i] - 65] = 1;
      }
    }

    int account1 = 0;
    for (int i = 0; i < 26; i++) {
      if (letter[i] != 1){
        account1++;
      }
    }
    if (account1 > sum){
      System.out.println(-1);
    }else {
      int account2 = 0;
      for (int i = 0; i < 26; i++) {
        if (letter[i] != 1){
          if (account2 < account1){
            flag[account2] = (char)(i+65);
            account2++;
          }
        }
      }
      //TODO fori
    }
  }
}
