import java.util.Scanner;

/**
 * Created by Kafukaaa on 2017/1/25.
 */
public class BlownDarland {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();
        char[] light = n.toCharArray();
        int[] dead = new int[4];
        int[] result = new int[4];
        char[] turn = new char[4];
        for (int i = 0; i < light.length; i++) {
            if (light[i] == '!'){
                dead[i%4]++;
            }else if (turn[i%4] != '0'){
                turn[i%4] = light[i];
            }
        }

        for (int i = 0; i < 4; i++) {
            if (turn[i] == 'R'){
                result[0] = dead[i];
            }else if (turn[i] == 'B'){
                result[1] = dead[i];
            }else if (turn[i] == 'Y'){
                result[2] = dead[i];
            }else if (turn[i] == 'G'){
                result[3] = dead[i];
            }
        }

        System.out.println(result[0]+" "+result[1]+" "+result[2]+" "+result[3]);

    }
}
