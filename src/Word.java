/**
 * Created by Wanhaixin on 2017/5/27.
 */

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;
public class Word {
    public static class WordMapper extends MapReduceBase implements Mapper<Object, Text, Text, IntWritable> {
        private final static IntWritable one = new IntWritable(1);
        private Text word = new Text();

        @Override
        public void map(Object key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter)
                throws IOException {
            String str = value.toString().toLowerCase().replaceAll("\\.", "").replaceAll
                    ("\\\"", "").replaceAll("\\'", "").replaceAll(",", "").replaceAll("\\*", "").replaceAll("\\[",
                    "").replaceAll("\\]", "");
            StringTokenizer itr = new StringTokenizer(str);
            Map<String, Integer> map = new HashMap<>();
            while (itr.hasMoreTokens()) {
                word.set(itr.nextToken());
                if (map.containsKey(word.toString())) {
                    Integer count = map.get(word.toString());
                    map.put(word.toString(), 1 + count);
                } else {
                    map.put(word.toString(), 1);
                }
            }
            Iterator entries1 = map.entrySet().iterator();
            while (entries1.hasNext()) {
                Map.Entry entry = (Map.Entry) entries1.next();
                String key1 = (String) entry.getKey();
                Integer value1 = (Integer) entry.getValue();
                IntWritable iw = new IntWritable(value1 - 1);
                if (value1 > 1) {
                    word.set(key1 + "," + key1);
                    output.collect(word, iw);
                }

                Iterator entries2 = map.entrySet().iterator();
                while (entries2.hasNext()) {
                    Map.Entry entry1 = (Map.Entry) entries2.next();
                    String key2 = (String) entry1.getKey();
                    Integer value2 = (Integer) entry1.getValue();
                    IntWritable iw1 = new IntWritable(value2);
                    if (!key2.equals(key1)) {
                        word.set(key1 + "," + key2);
                        output.collect(word, iw1);
                    }
                }
            }
        }
    }

    public static class WordReducer extends MapReduceBase
            implements Reducer<Text, IntWritable, Text, IntWritable> {
        private IntWritable result = new IntWritable();

        @Override
        public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output,
                           Reporter reporter) throws IOException {
            int sum = 0;
            while (values.hasNext()) {
                sum += values.next().get();
            }
            result.set(sum);
            output.collect(key, result);
        }
    }

    public static void main(String[] args) throws Exception {
        JobConf conf = new JobConf(Word.class);
        conf.setJobName("Word");
        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(IntWritable.class);
        //设置mapper类
        conf.setMapperClass(WordMapper.class);
        conf.setCombinerClass(WordReducer.class);
        //设置reduce类
        conf.setReducerClass(WordReducer.class);
        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);
        //设置输入数据文件路径
        FileInputFormat.setInputPaths(conf, new Path(args[0]));
        //设置输出数据文件路径
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));
        JobClient.runJob(conf);
    }
}
