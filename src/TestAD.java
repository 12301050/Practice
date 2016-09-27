/**
 * Created by Kafukaaa on 2016/9/26.
 */

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import java.util.Hashtable;

public class TestAD {
  public static void main(String[] args) {
    TestAD testAD = new TestAD();
    String result = testAD.connect("intra\\wangyu3", "b3Dii3#7");
    System.out.println(result);
  }
  public String  connect(String username,String password) {
    Hashtable<String,String> HashEnv = new Hashtable<String,String>();
    HashEnv.put(Context.SECURITY_AUTHENTICATION, "simple"); // LDAP访问安全级别(none,simple,strong)
    HashEnv.put(Context.SECURITY_PRINCIPAL, username); //AD的用户名
    HashEnv.put(Context.SECURITY_CREDENTIALS, password); //AD的密码
    HashEnv.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory"); // LDAP工厂类
    HashEnv.put("com.sun.jndi.ldap.connect.timeout", "3000");//连接超时设置为3秒
    HashEnv.put(Context.PROVIDER_URL, "ldap://" +"192.168.1.1" +":" + "389");// 默认端口389
    try {
      LdapContext ctx = new InitialLdapContext(HashEnv, null);// 初始化上下文
      SearchControls searchCtls = new SearchControls();
      searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
      String searchFilter = "(&(objectCategory=person)(objectClass=user)(name=*))";
      String searchBase = "OU=Enterprise,DC=intra,DC=nsfocus,DC=com";
      String returnedAtts[] = {"sAMAccountName","displayName","Department2","physicalDeliveryOfficeName","mailc"};
      searchCtls.setReturningAttributes(returnedAtts);
      NamingEnumeration<SearchResult> answer = ctx.search(searchBase, searchFilter,searchCtls);
      System.out.println(answer.hasMoreElements());
      int amount = 0;
      String pd = "";
      while (answer.hasMoreElements()) {
        SearchResult sr = (SearchResult) answer.next();
        System.out.println("");
        System.out.println("Line"+(++amount)+ ":**********************************************************");
        String dn = sr.getName();
        String match = dn.split("CN=")[1].split(",")[0];//返回格式一般是CN=ptyh,OU=专卖
        Attributes Attrs = sr.getAttributes();// 得到符合条件的属性集
        if (Attrs != null) {
          try {
            for (NamingEnumeration ne = Attrs.getAll(); ne.hasMore();) {
              Attribute Attr = (Attribute) ne.next();// 得到下一个属性
              System.out.print(Attr.getID().toString()+":");
              // 读取属性值
              pd =  Attr.getAll().next().toString();
              System.out.println(pd);
            }
          } catch (NamingException e) {
            System.err.println("Throw Exception : " + e);
          }
        }
      }
      ctx.close();
      System.out.println("*******************************************************************");
      System.out.println("The amount is:"+amount);
      System.out.println("*******************************************************************");
      return "auth success";
    } catch (AuthenticationException e) {
      return "auth failed";
    } catch (javax.naming.CommunicationException e) {
      return "failed";
    } catch (Exception e) {
      return "failed";
    }
  }
}