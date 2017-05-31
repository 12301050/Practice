import java.util.HashMap;
import java.util.Map;

//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Scanner;
//
///**
// * Created by Kafukaaa on 2016/8/26.
// */
public class A1000 {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> map1 = new HashMap<String, Object>();

        map.put("1", new Integer(1));
        map.put("2", new Integer(2));
        map1.put("1", new Integer(3));
        map1.put("4", new Integer(4));
        map.putAll(map1);
        System.out.println(map1);

        System.out.println(map);
    }
}
//        Scanner scanner = new Scanner(System.in);
//        Integer n = scanner.nextInt();
//        String[] lines = new String[n];
//        Map<String, Integer> map = new HashMap<>();
//        scanner.nextLine();
//        for (int i = 0; i < n; i++) {
//            lines[i] = scanner.nextLine().toLowerCase().replaceAll("\\.", " ");
//            String[] words = lines[i].split(" ");
//            Map<String, Integer> lineMap = new HashMap<>();
//            for (int j = 0; j < words.length; j++) {
//                if (!words[j].equals(" ")) {
//                    if (lineMap.containsKey(words[j])) {
//                        Integer count = lineMap.get(words[j]);
//                        lineMap.put(words[j], count + 1);
//                    } else {
//                        lineMap.put(words[j], 1);
//                    }
//                }
//            }
//            Iterator entries = lineMap.entrySet().iterator();
//            while (entries.hasNext()) {
//                Map.Entry entry = (Map.Entry) entries.next();
//                String key = (String) entry.getKey();
//                Integer value = (Integer) entry.getValue();
//                if (value > 1) {
//                    if (map.containsKey(key + "," + key)) {
//                        Integer count2 = map.get(key + ","  + key);
//                        map.put(key + "," + key, value - 1 + count2);
//                    } else {
//                        map.put(key + "," + key, value - 1);
//                    }
//                }
//                Iterator entries1 = lineMap.entrySet().iterator();
//                while (entries1.hasNext()) {
//                    Map.Entry entry1 = (Map.Entry) entries1.next();
//                    String key1 = (String) entry1.getKey();
//                    Integer value1 = (Integer) entry1.getValue();
//                    if (!key1.equals(key)) {
//                        if (map.containsKey(key + "," + key1)) {
//                            Integer count1 = map.get(key + "," + key1);
//                            map.put(key + "," + key1, value1 + count1);
//                        } else {
//                            map.put(key + "," + key1, value1);
//                        }
//                    }
//                }
//            }
//        }
//        Iterator entries2 = map.entrySet().iterator();
//        while (entries2.hasNext()) {
//            Map.Entry entry2 = (Map.Entry) entries2.next();
//            String key2 = (String) entry2.getKey();
//            Integer value2 = (Integer) entry2.getValue();
//            System.out.println("Key = " + key2 + "    Value = " + value2);
//        }
//    }
//}
