import java.util.Scanner;

/**
 * Created by Kafukaaa on 16/10/2.
 */
public class EfimAndStrangeGrade {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int t = scanner.nextInt();
    String number = scanner.next();
    char[] c = number.toCharArray();
    int[] p = new int[n];

    int flag = 0;
    int position = n;
    int flag1 = 0;
    int flag2 = 0;
    for (int i = 0; i < n; i++) {
      if (c[i] == '.'){
        position = i;
      }
      if (position < n && c[i] >= 53){
        flag2 = i;
        break;
      }
    }

    for (int i = position; i < n; i++) {
      if (c[i] > 52){
        break;
      }
      if (c[i] == 52){
        p[flag1] = i;
        flag1++;
      }
    }
    if (flag2 > 0){
      p[flag1] = flag2;
    }
    int flag3 = Math.min(Math.min(t,n-position),flag1+1);
    for (int k = 0; k < flag3; k++) {
      int i = p[flag1-k];
      if (p[flag1-k] > 0) {
        if (c[i] >= 53) {
          if (c[i] == 57) {
            if (c[i - 1] == '.') {
              flag = i - 1;
            } else {
              flag = i;
            }
            for (int j = i; j > 0; j--) {
              if (c[j] == 57 || c[j] == 58) {
                c[j] = 48;
                if (c[j - 1] == '.') {
                  c[j - 2]++;
                } else {
                  c[j - 1]++;
                }
              }else if (c[j] == '.'){
                continue;
              }else {
                break;
              }
            }
          } else {
            c[i] = 48;
            if (c[i - 1] == '.') {
              flag = i - 1;
              c[i - 2]++;
            } else {
              flag = i;
              c[i - 1]++;
            }
          }
        }
      }
    }

    for (int i = position-1; i > 0; i--) {
      if (c[i] == 58){
        c[i] = 48;
        c[i-1]++;
      }
    }
    if (flag > 0){
      if (c[0] == 58){
        System.out.print("10");
        for (int i = 1; i < flag; i++) {
          System.out.print(c[i]);
        }
      }else {
        for (int i = 0; i < flag; i++) {
          System.out.print(c[i]);
        }
      }
    }else {
      System.out.println(number);
    }

  }
}
