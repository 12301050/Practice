import java.util.Scanner;

/**
 * Created by Kafukaaa on 16/10/19.
 */
public class CheckingTheCalender {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s1 = scanner.next();
    String s2 = scanner.next();
    if (s1.equals("monday")){
      if (s2.equals("monday") || s2.equals("wednesday") || s2.equals("thursday") ){
        System.out.println("YES");
      }else {
        System.out.println("NO");
      }
    }else if (s1.equals("tuesday")){
      if (s2.equals("tuesday") || s2.equals("friday") || s2.equals("thursday") ){
        System.out.println("YES");
      }else {
        System.out.println("NO");
      }
    }else if (s1.equals("wednesday")){
      if (s2.equals("friday") || s2.equals("saturday") || s2.equals("wednesday") ){
        System.out.println("YES");
      }else {
        System.out.println("NO");
      }
    }else if (s1.equals("thursday")){
      if (s2.equals("thursday") || s2.equals("saturday") || s2.equals("sunday") ){
        System.out.println("YES");
      }else {
        System.out.println("NO");
      }
    }else if (s1.equals("friday")){
      if (s2.equals("friday") || s2.equals("sunday") || s2.equals("monday") ){
        System.out.println("YES");
      }else {
        System.out.println("NO");
      }
    }else if (s1.equals("saturday")){
      if (s2.equals("saturday") || s2.equals("monday") || s2.equals("tuesday") ){
        System.out.println("YES");
      }else {
        System.out.println("NO");
      }
    }else if (s1.equals("sunday")){
      if (s2.equals("sunday") || s2.equals("tuesday") || s2.equals("wednesday") ){
        System.out.println("YES");
      }else {
        System.out.println("NO");
      }
    }


  }
}
