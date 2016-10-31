import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Kafukaaa on 2016/9/7.
 */
public class PythagoreanTriples {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long a = scanner.nextLong();

    long n,b,c;
    if (a == 1 || a == 2){
      System.out.println(-1);
    }else if (a%2 != 0){
      n = (a-1)/2;
      b = (n*n+n)*2;
      c = (n*n+n)*2+1;
      System.out.println(b+" "+c);
    }else {
      n = a/2;
      b = n*n-1;
      c = n*n+1;
      System.out.println(b+" "+c);
    }
  }
}
