import java.util.Scanner;

/**
 * Created by Kafukaaa on 16/9/12.
 */
/*����Ҫ�㣺����˼ά��̰���㷨*/
public class MemoryAndDeEvolution {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int x = scanner.nextInt();
    int y = scanner.nextInt();
    int a = y, b = y, c = y;
    int result = 0 ;
    while (a < x || b < x || c < x){
      a = b;
      b = c;
      c = a + b -1;
      result++;
    }
    System.out.println(result);
  }
}
