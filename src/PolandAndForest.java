import java.util.Scanner;

/**
 * Created by Kafukaaa on 2017/1/20.
 */
public class PolandAndForest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        Integer m = scanner.nextInt();
        int[] nodes = new int[n];
        for (int i = 0; i < m*2; i++) {
            nodes[scanner.nextInt()-1]++;
        }

        Integer n0 = 0, n1 = 0;
        for (int i = 0; i < n; i++) {
            if (nodes[i] == 0){
                n0++;
            }else if (nodes[i] == 1){
                n1++;
            }
        }

        System.out.println(n0+(n1/2));
    }
}
