import java.util.Scanner;
/**
 * Created by Wangyu on 2016/8/24.
 */
public class RecoverTheString {
    public static void main(String[] args) {
        while (true) {
            System.out.println("«Î ‰»Î£∫");
            Scanner sc = new Scanner(System.in);
            if (sc.hasNext()) {
                int a,b,c,d,n0,n1;
                String s1 = sc.nextLine();
                String[] arr = s1.split(" ");
                a = Integer.parseInt(arr[0]);
                b = Integer.parseInt(arr[1]);
                c = Integer.parseInt(arr[2]);
                d = Integer.parseInt(arr[3]);

                n0 = (int)(Math.sqrt(1+8*a)+1)/2;
                n1 = (int)(Math.sqrt(1+8*d)+1)/2;
                System.out.println(n0);
                System.out.println(n1);

                if ((Math.sqrt(1+8*a)+1)/2-n0 != 0 || (Math.sqrt(1+8*d)+1)/2-n1 != 0 || b+c!= n0*n1){
                    System.out.println("Impossible");
                }else {
                    String result = "";
                    for (int i = 1; i <= n1; i++) {
                        if (i*n0 >= c){
                            if (i*n0-c == 0) {
                                for (int j = 0; j < i; j++) {
                                    result = result + "1";
                                }
                            }
                            if (i*n0-c > 0){
                                for (int j = 0; j < i-1; j++) {
                                    result = result + "1";
                                }
                                for (int j = 0; j < i*n0-c; j++) {
                                    result = result + "0";
                                }
                                result = result + "1";
                            }
                            if (n0 > i*n0-c){
                                for (int j = 0; j < n0-(i*n0-c); j++) {
                                    result = result + "0";
                                }
                            }
                            int l = result.length();
                            if (n0+n1-l > 0){
                                for (int j = 0; j < n0+n1-l; j++) {
                                    result = result + "1";
                                }
                            }
                            i = n1+1;
                        }
                    }
                    System.out.println(result);
                }
            }
        }
    }
}
