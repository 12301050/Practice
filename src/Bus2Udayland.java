import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Kafukaaa on 2016/8/31.
 */
public class Bus2Udayland {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] seats = new String[n];
        for (int i = 0; i < n; i++) {
            seats[i] = scanner.next();
        }

        String result = "NO";
        for (int i = 0; i < n; i++) {
            if (seats[i].contains("OO")){
                seats[i] = seats[i].replaceFirst("OO","++");
                result = "YES";
                i = n;
            }
        }

        System.out.println(result);
        if (result.equals("YES")) {
            for (int i = 0; i < n; i++) {
                System.out.println(seats[i]);
            }
        }
    }
}
