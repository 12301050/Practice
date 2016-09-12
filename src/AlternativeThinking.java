import java.util.Scanner;

/**
 * Created by Kafukaaa on 2016/8/30.
 */
public class AlternativeThinking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String a = scanner.next();
        String[] b = new String[a.length()];
        for (int i = 0; i < a.length(); i++) {
            b[i] = a.substring(i,i+1);
        }
        int flag = 0,result = 1,answer;
        if (n == 1){
            answer = 1;
        }else {
            for (int i = 0; i < n - 1; i++) {
                if (b[i].equals(b[i + 1])) {
                    flag = flag + 1;
                }else {
                    result = result + 1;
                }
            }
            answer = Math.min(result+2,result+flag);
        }
        System.out.println(answer);
    }
}
