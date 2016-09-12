import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Created by Kafukaaa on 2016/9/7.
 */
public class RandomCode {
  public static void main(String[] args) {
    String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    for (int i = 0; i < 10; i++) {
      Random random = new Random();
      StringBuffer sb = new StringBuffer();
      for (int j = 0; j < 8; j++) {
        int number = random.nextInt(base.length());
        sb.append(base.charAt(number));
      }
      String str = sb.toString();
      MD5(str);
    }
  }

  private static String MD5(String sourceStr) {
    String result = "";
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update(sourceStr.getBytes());
      byte b[] = md.digest();
      int i;
      StringBuffer buf = new StringBuffer("");
      for (int offset = 0; offset < b.length; offset++) {
        i = b[offset];
        if (i < 0)
          i += 256;
        if (i < 16)
          buf.append("0");
        buf.append(Integer.toHexString(i));
      }
      result = buf.toString();
      System.out.println(sourceStr + "  " + result);
    } catch (NoSuchAlgorithmException e) {
      System.out.println(e);
    }
    return result;
  }

}
