import sun.org.mozilla.javascript.internal.ast.IfStatement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Kafukaaa on 16/9/20.
 */
public class Cactusophobia {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    String[] start = new String[m];
    String[] end = new String[m];
    int[] color = new int[m];
    String[][] cycle = new String[n][m];
    int[][] colors = new int[n][m];
    int[] account = new int[m+1];
    for (int i = 0; i < m; i++) {
      start[i] = scanner.next();
      end[i] = scanner.next();
      color[i] = scanner.nextInt();
    }

    List<String> node = new ArrayList<>();
    int sum = 0;
    for (int i = 0; i < m; i++) {
      if (node.contains(start[i])) {
        int j = node.indexOf(start[i]);
        if (node.size() - j >= 2) {
          for (int k = 0; k + j < node.size(); k++) {
            cycle[sum][k] = node.get(j + k);
            if (!Arrays.asList(colors[sum]).contains(color[i])) {
              colors[sum][k] = color[i-k];
            }
          }
          node.remove(j);
          sum++;
        }
      } else if (node.size() == 0 || node.get(node.size() - 1) != start[i]) {
        node.add(start[i]);
      }
      if (node.contains(end[i])) {
        int j = node.indexOf(end[i]);
        if (node.size() - j >= 2) {
          for (int k = 0; k + j < node.size(); k++) {
            cycle[sum][k] = node.get(j + k);
            if (!Arrays.asList(colors[sum]).contains(color[i])) {
              colors[sum][k] = color[i-k];
            }
          }
          node.remove(j);
          sum++;
        }
      } else if (node.size() == 0 || node.get(node.size() - 1) != end[i]) {
        node.add(end[i]);
      }
    }

    int result = 0;
    for (int i = 0; i < sum; i++) {
      for (int j = 0; j < m; j++) {
        if (colors[i][j] != 0) {
          account[colors[i][j]]++;
          if (!Arrays.asList(color).contains(colors[i][j])){
            result++;
          }
        }

      }
    }

    for (int i = 1; i < m+1; i++) {
    }
  }
}
