import java.util.Scanner;
import java.util.jar.Manifest;

/**
 * Created by Kafukaaa on 2017/3/25.
 */
public class Monster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int min=Math.min(a, c);
        int  maxMultiple = 1;
        for(int i=min;i>0;i--)
        {
            if(a%i==0&&c%i==0)
            {
                maxMultiple = i;
                break;
            }
        }
        if (a%2 == 0 && b%2 == 1 && c%2 == 0 && d%2 ==0){
            System.out.println(-1);
        }else if (Math.abs(b-d)%maxMultiple != 0){
            System.out.println(-1);
        }else {
            int x = b , y = d;
            while (true){
                if (x < y){
                    x += a;
                }else if (x > y){
                    y += c;
                }else {
                    System.out.println(x);
                    System.exit(0);
                }
            }
        }
    }
}