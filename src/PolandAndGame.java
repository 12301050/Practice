import java.util.*;

/**
 * Created by Kafukaaa on 2017/1/19.
 */
public class PolandAndGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        Integer m = scanner.nextInt();
        scanner.nextLine();
        List<String> words = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            words.add(scanner.nextLine());
        }
        Integer flag = 0;
        for (int i = 0; i < m; i++) {
            if (words.contains(scanner.nextLine())){
                flag++;
            }
        }

        if (n-flag+flag%2 > m-flag){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }

    }
}
