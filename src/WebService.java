import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Kafukaaa on 2017/5/26.
 */
public class WebService {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        FileReader reader = null;
        try {
            reader = new FileReader("/Users/Kafukaaa/Documents/WebService/input.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(reader);
        String s1 = null;
        try {
            while ((s1 = br.readLine()) != null) {
                String[] words = s1.toLowerCase().replaceAll("\\.", "").replaceAll("\\\"", "").replaceAll("\\'", ""
                        + "").replaceAll(",", "").replaceAll("\\*", "").replaceAll("\\[", "").replaceAll("\\]", "")
                        .split(" ");
                Map<String, Integer> lineMap = new HashMap<>();
                for (int j = 0; j < words.length; j++) {
                    if (!words[j].equals(" ") && words[j] != "") {
                        if (lineMap.containsKey(words[j])) {
                            Integer count = lineMap.get(words[j]);
                            lineMap.put(words[j], count + 1);
                        } else {
                            lineMap.put(words[j], 1);
                        }
                    }
                }
                Iterator entries = lineMap.entrySet().iterator();
                while (entries.hasNext()) {
                    Map.Entry entry = (Map.Entry) entries.next();
                    String key = (String) entry.getKey();
                    Integer value = (Integer) entry.getValue();
                    if (value > 1) {
                        if (map.containsKey(key + "," + key)) {
                            Integer count2 = map.get(key + "," + key);
                            map.put(key + "," + key, value - 1 + count2);
                        } else {
                            map.put(key + "," + key, value - 1);
                        }
                    }
                    Iterator entries1 = lineMap.entrySet().iterator();
                    while (entries1.hasNext()) {
                        Map.Entry entry1 = (Map.Entry) entries1.next();
                        String key1 = (String) entry1.getKey();
                        Integer value1 = (Integer) entry1.getValue();
                        if (!key1.equals(key)) {
                            if (map.containsKey(key + "," + key1)) {
                                Integer count1 = map.get(key + "," + key1);
                                map.put(key + "," + key1, value1 + count1);
                            } else {
                                map.put(key + "," + key1, value1);
                            }
                        }
                    }
                }
            }
            br.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            StringBuffer str = new StringBuffer();
            FileWriter fw = new FileWriter("/Users/Kafukaaa/Documents/WebService/output.txt", true);

            Iterator entries2 = map.entrySet().iterator();
            while (entries2.hasNext()) {
                Map.Entry entry2 = (Map.Entry) entries2.next();
                String key2 = (String) entry2.getKey();
                Integer value2 = (Integer) entry2.getValue();
                str.append(key2 + "     " + value2 + System.getProperty("line.separator"));
            }
            fw.write(str.toString());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
