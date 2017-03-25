import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Scanner;

/**
 * Created by Kafukaaa on 2016/8/26.
 */
public class A1000 {
  public static String getUTF8XMLString(String xml) {
    // A StringBuffer Object
    StringBuffer sb = new StringBuffer();
    sb.append(xml);
    String xmString = "";
    String xmlUTF8="";
    try {
      xmString = new String(sb.toString().getBytes("UTF-8"));
      xmlUTF8 = URLEncoder.encode(xmString, "UTF-8");
      System.out.println("utf-8 编码：" + xmlUTF8) ;
    } catch (UnsupportedEncodingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    // return to String Formed
    return xmlUTF8;
  }
  public static void main(String[] args){
//    String result = getUTF8XMLString("我爱洗澡");
//    System.out.println(result);
//    System.out.println(System.currentTimeMillis());
    int f = 1, s = 2, t = 0;
    for (int i = 0; i < 15; i++) {
      t = f + s;
      f = s;
      s = t;
      System.out.println(t);
    }
  }
}
