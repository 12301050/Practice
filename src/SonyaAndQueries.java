import java.util.*;

/**
 * Created by Kafukaaa on 16/9/17.
 */
/*
 在用scanner.nextLine()时，第一行是无效的！！！
 要学会灵活转化十进制和二进制，脑子动起来啊！！！！
* */
public class SonyaAndQueries {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int t = scanner.nextInt();
    String[] order = new String[t+1];
    int[] answer = new int[10000001];
    for (int i = 0; i < t+1; i++) {
      order[i] = scanner.nextLine();
    }
    for (int i = 1; i < t+1; i++) {
      String pattern = order[i].substring(2);
      StringBuilder s = new StringBuilder();
      for (int j = 0; j < pattern.length(); j++) {
        if (Integer.parseInt(pattern.substring(j,j+1)) % 2 == 1){
          s = s.append("1");
        }else {
          s = s.append("0");
        }
      }
      int ele = Integer.parseInt(s.toString(),2);
      if (order[i].substring(0,1).equals("+")){
        answer[ele] ++;
      }else if (order[i].substring(0,1).equals("-")){
        answer[ele] --;
      }else if (order[i].substring(0,1).equals("?")){
        System.out.println(answer[ele]);
      }
    }
  }
}