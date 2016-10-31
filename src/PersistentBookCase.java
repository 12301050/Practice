import java.security.PublicKey;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Kafukaaa on 2016/9/7.
 */
public class PersistentBookCase {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int k = scanner.nextInt();
    int[][] book = new int[n][m];
    int[] sum = new int[k+1];
    String[] order = new  String[k+1];
    for (int i = 0; i <= k; i++) {
      order[i] = scanner.nextLine();
    }

    sum[0] = 0;
    for (int i = 1; i <= k; i++) {
      sum[i] = Operation(i,order,book,sum,m,n);
    }

    for (int i = 1; i <= k; i++) {
      System.out.println(sum[i]);
    }
  }

  private static int Operation (int number, String[] order, int[][] book,int[] sum,int m,int n) {
    int a = Integer.parseInt(order[number].split(" ")[0]);
    int flag = 0;
    if (a == 1){
      int b = Integer.parseInt(order[number].split(" ")[1]) - 1;
      int c = Integer.parseInt(order[number].split(" ")[2]) - 1;
      if (book[b][c] == 0){
        book[b][c] = 1;
        flag = 1;
      }
      sum[number] = sum[number-1] + flag;
    }else if (a == 2){
      int b = Integer.parseInt(order[number].split(" ")[1]) - 1;
      int c = Integer.parseInt(order[number].split(" ")[2]) - 1;
      if (book[b][c] == 1){
        book[b][c] = 0;
        flag = -1;
      }
      sum[number] = sum[number-1] + flag;
    }else if (a == 3){
      int b = Integer.parseInt(order[number].split(" ")[1]) - 1;
      for (int j = 0; j < m; j++) {
        if (book[b][j] == 0) {
          book[b][j] = 1;
          flag = flag + 1;
        } else {
          book[b][j] = 0;
          flag = flag - 1;
        }
      }
      sum[number] = sum[number-1] + flag;
    }else if (a == 4) {
      int b = Integer.parseInt(order[number].split(" ")[1]);
      if (b == 0){
        sum[number] = 0;
        for (int j = 0; j < n; j++) {
          for (int l = 0; l < m; l++) {
            book[j][l] = 0;
          }
        }
      }else {
        /*for (int i = number; i >0 ; i--) {
          if (Integer.parseInt(order[i].split(" ")[0]) == 4) {
            for (int j = Integer.parseInt(order[i].split(" ")[1]) + 1; j <= i; j++) {
              order[j] = "0";
            }
          }
          i = 0;
        }*/
        for (int i = 1; i <= b; i++) {
          if (i == 1){
            for (int j = 0; j < n; j++) {
              for (int l = 0; l < m; l++) {
                book[j][l] = 0;
              }
            }
          }
          if (!order[i].equals("0"))
          sum[number] = Operation(i, order, book, sum, m, n);
        }
      }
    }
    return  sum[number];
  }
}

    /*int[][][] book = new  int[k+1][n][m];
    int[] sum = new int[k+1];

    for (int j = 0; j < n; j++) {
      for (int l = 0; l < m; l++) {
        book[0][j][l] = 0;
      }
    }

    sum[0] = 0;
    for (int i = 1; i <= k; i++) {
      int a = scanner.nextInt();
        for (int j = 0; j < n; j++) {
          for (int l = 0; l < m; l++) {
            book[i][j][l] = book[i-1][j][l];
          }
        }
      int flag = 0;
      if (a == 1){
        int b = scanner.nextInt() - 1;
        int c = scanner.nextInt() - 1;
        if (book[i][b][c] == 0){
          book[i][b][c] = 1;
          flag = 1;
        }
        sum[i] = sum[i-1] + flag;
      }else if (a == 2){
        int b = scanner.nextInt() -1;
        int c = scanner.nextInt() -1;
        if (book[i][b][c] == 1){
          book[i][b][c] = 0;
          flag = -1;
        }
        sum[i] = sum[i-1] + flag;
      }else if (a == 3){
        int b = scanner.nextInt() - 1;
        for (int j = 0; j < m; j++) {
          if (book[i][b][j] == 0) {
            book[i][b][j] = 1;
            flag = flag + 1;
          } else {
            book[i][b][j] = 0;
            flag = flag - 1;
          }
        }
        sum[i] = sum[i-1] + flag;
      }else if (a == 4) {
        int b = scanner.nextInt();
        if (b == 0){
          sum[i] = 0;
          for (int j = 0; j < n; j++) {
            for (int l = 0; l < m; l++) {
              book[i][j][l] = 0;
            }
          }
        }else {
          sum[i] = sum[b];
          for (int j = 0; j < n; j++) {
            for (int l = 0; l < m; l++) {
              book[i][j][l] = book[b][j][l];
            }
          }
        }
      }
    }

    for (int i = 1; i <= k; i++) {
      System.out.println(sum[i]);
    }
  }
}*/