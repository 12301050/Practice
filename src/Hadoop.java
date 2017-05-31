/**
 * Created by Kafukaaa on 2017/5/27.
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

/**
 * 单词统计MapReduce
 */
public class Hadoop {
    /**
     * Mapper类
     */
    public static class WordCountMapper extends MapReduceBase implements Mapper<Object, Text, Text, IntWritable> {
        private final static IntWritable one = new IntWritable(1);
        private Text word = new Text();

        @Override
        public void map(Object key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter)
                throws IOException {
            StringTokenizer itr = new StringTokenizer(value.toString().toLowerCase().replaceAll("\\.", "").replaceAll
                    ("\\\"", "").replaceAll("\\'", "").replaceAll(",", "").replaceAll("\\*", "").replaceAll("\\[", "").replaceAll("\\]", ""));
            Map<String, Integer> lineMap = new HashMap<>();
            while (itr.hasMoreTokens()) {
                word.set(itr.nextToken());
                if (lineMap.containsKey(word.toString())) {
                    Integer count = lineMap.get(word.toString());
                    lineMap.put(word.toString(), count + 1);
                } else {
                    lineMap.put(word.toString(), 1);
                }
            }
            Iterator entries = lineMap.entrySet().iterator();
            while (entries.hasNext()) {
                Map.Entry entry = (Map.Entry) entries.next();
                String key1 = (String) entry.getKey();
                Integer value1 = (Integer) entry.getValue();
                for (int i = 0; i < value1 - 1; i++) {
                    word.set(key1 + "," + key1);
                    output.collect(word, one);
                }
                Iterator entries1 = lineMap.entrySet().iterator();
                while (entries1.hasNext()) {
                    Map.Entry entry1 = (Map.Entry) entries1.next();
                    String key2 = (String) entry1.getKey();
                    Integer value2 = (Integer) entry1.getValue();
                    if (!key2.equals(key1)) {
                        for (int i = 0; i < value2; i++) {
                            word.set(key1 + "," + key2);
                            output.collect(word, one);
                        }
                    }
                }
            }
        }
    }

    public static class WordCountReducer extends MapReduceBase
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
        JobConf conf = new JobConf(Hadoop.class);
        conf.setJobName("Hadoop");
        //对应单词字符串
        conf.setOutputKeyClass(Text.class);
        //对应单词的统计个数 int类型
        conf.setOutputValueClass(IntWritable.class);
        //设置mapper类
        conf.setMapperClass(WordCountMapper.class);
        conf.setCombinerClass(WordCountReducer.class);
        //设置reduce类
        conf.setReducerClass(WordCountReducer.class);
        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);
        //设置输入数据文件路径
        FileInputFormat.setInputPaths(conf, new Path(args[0]));
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));
        //启动mapreduce
        JobClient.runJob(conf);
    }

}

