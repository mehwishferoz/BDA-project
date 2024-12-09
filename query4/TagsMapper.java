import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class TagsMapper extends Mapper<Object, Text, Text, IntWritable> {

    private final static IntWritable one = new IntWritable(1);
    private Text tag = new Text();

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        // Split the input line into fields using a comma as the delimiter
        String[] fields = value.toString().split(",", -1);

        // Check if the record has the expected number of fields and is not a header
        if (fields.length > 10 && !fields[10].equalsIgnoreCase("tags")) {
            String tagValue = fields[10].trim(); // Extract the "tags" field
            if (!tagValue.isEmpty()) {
                tag.set(tagValue);
                context.write(tag, one);
            }
        }
    }
}
