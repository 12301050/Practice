import java.util.Scanner;

/**
 * Created by Kafukaaa on 2016/9/18.
 */
public class CompleteTheWord {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String c = scanner.next();
    char[] s = c.toCharArray();

    int result = 0;
    for (int i = 0; i < s.length - 25; i++) {
      int sum1 = 0,sum2 = 0;
      int[] flag = new int[26];
      int[] letter = new int[26];
      for (int j = 0; j < 26; j++) {
        if (s[i+j] == '?'){
          flag[sum1] = i+j;
          sum1 ++;
        }else {
          if (letter[(int)s[i+j] - 65] != 1){
            letter[(int)s[i+j] - 65] = 1;
            sum2 ++;
          }
        }
      }
      if (sum1 + sum2 == 26) {
        result = 1;
        int sum3 = 0;
        for (int j = 0; j < 26; j++) {
          if (letter[j] != 1 ){
            s[flag[sum3]] = (char)(j + 65);
            sum3 ++;
          }
        }
        for (int j = 0; j < s.length; j++) {
          if (s[j] == '?'){
            s[j] = 'A';
          }
        }
        i = s.length;
      }
    }
    if (result == 1){
      System.out.println(String.valueOf(s));
    }else {
      System.out.println(-1);
    }
  }
}
