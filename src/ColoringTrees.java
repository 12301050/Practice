import org.omg.CORBA.AnySeqHelper;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Kafukaaa on 2016/9/5.
 */
public class ColoringTrees {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int k = scanner.nextInt();
    int[] trees = new int[n];
    int[][] colors = new int[n][m];
    BigInteger[][][] dp = new BigInteger[n][m][k];
    for (int i = 0; i < n; i++) {
      trees[i] = scanner.nextInt();
    }

    BigInteger define = new BigInteger("9999999999",10);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        colors[i][j] = scanner.nextInt();
        for (int l = 0; l < k; l++) {
          dp[i][j][k] = define;
        }
      }
    }


    /*int result = 0, flag = 0, sum = 0;
    if (n == 1){
      if (n == k && trees[0] != 0){
        Arrays.sort(colors);
        result = colors[0][0];
        System.out.println(result);
      }else {
        result = -1;
        System.out.println(result);
      }
    }else {
      for (int i = 0; i < n; i++) {
        if (trees[i] == 0){
          flag = flag + 1;
        }
      }
      if (flag == 0){
        for (int i = 0; i < n-1; i++) {
          if (trees[i] != trees[i + 1]) {
            sum = sum + 1;
          }
        }
        if (sum == k){
          System.out.println(result);
        }else {
          System.out.println(-1);
        }
      }else {
        int answer = 0,tag = -1;
        int[] answers = new int[flag*m];
        for (int i = 0; i < n; i++) {
          if (trees[i] == 0){
            tag = tag + 1;
            for (int j = 0; j < m; j++) {
              answers[flag*tag+i] = answers[i] + colors[i][j];
              trees[i] = j;
              sum = 0;
              for (int l = 0; l < n-1; l++) {
                if (trees[l] != trees[l+1]){
                  sum = sum +1;
                }
              }
              if (sum == k){
                answer = 1;
                j = m;
              }
            }
          }
        }
        if (answer == 0){
          System.out.println(-1);
        }
      }
    }*/
  }
}
