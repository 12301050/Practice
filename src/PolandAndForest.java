import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Kafukaaa on 2017/1/20.
 */
public class PolandAndForest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        List<Integer> nodes = new ArrayList<>();
        Integer n0 = 0, n1 = 0, node;
        for (int i = 0; i < n; i++) {
            node = scanner.nextInt();
            if (node-1 == i){
                n0++;
            }else if (!nodes.contains(node)){
                nodes.add(node);
                n1++;
            }
        }

        System.out.println(n0+n1/2);

    }
}
