import java.util.Scanner;
/**
 * Created by Kafukaaa on 2016/9/5.
 */

public class Bakery {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int k = scanner.nextInt();
    int[] node1 = new int[m];
    int[] node2 = new int[m];
    int[] length = new int[m];
    int[] storage = new int[n+1];
    for (int i = 0; i < m; i++) {
      length[i] = 1000000001;
    }
    for (int i = 0; i < m; i++) {
      node1[i] = scanner.nextInt();
      node2[i] = scanner.nextInt();
      length[i] = scanner.nextInt();
    }
    for (int i = 0; i < k; i++) {
      storage[scanner.nextInt()] = 1;
    }

    int answer = 1000000001;
    for (int i = 0; i < m; i++) {
      if ((storage[node1[i]] != 1 && storage[node2[i]] == 1) || storage[node1[i]] == 1 && storage[node2[i]] != 1){
        answer = Math.min(answer,length[i]);
      }
    }
    if (answer == 1000000001) {
      answer = -1;
    }
    System.out.println(answer);
  }
}

   /* int a,b,c;
    for (int i = 0; i < m; i++) {
      a = scanner.nextInt()-1;
      b = scanner.nextInt()-1;
      c = scanner.nextInt();
    }

    int[] s = new int[k];
    if (k != 0){
      for (int i = 0; i < k; i++) {
        s[i] = scanner.nextInt();
      }
    }

    int answer = 100001;*/
   /* for (int i = 0; i < n; i++) {
      boolean flag = Arrays.asList(s).contains(i);
      if (flag == false) {
        for (int j = 0; j < k; j++) {
          if (path[s[j] - 1][i] < 100001 && s[j]-1 != i) {
            answer = Math.min(answer, path[s[j] - 1][i]);
          }
        }
        for (int j = 0; j < k; j++) {
          if (path[i][s[j] - 1] < 100001 && s[j]-1 != i) {
            answer = Math.min(answer, path[i][s[j] - 1]);
          }
        }
      }
    }*/
    /*for (int i = 0; i < k; i++) {
      d = s[i] - 1;
      for (int j = 0; j < n; j++) {
        boolean flag = Arrays.asList(s).contains(j+1);
        if (path[d][j] < 100001 && flag == false){
          answer = Math.min(path[d][j],answer);
        }
      }
      for (int j = 0; j < n; j++) {
        boolean flag = Arrays.asList(s).contains(j+1);
        if (path[j][d] < 100001 && flag == false){
          answer = Math.min(path[j][d],answer);
        }
      }
    }*/
  /*  if (answer == 100001) {
      answer = -1;
    }
    System.out.println(answer);*/

