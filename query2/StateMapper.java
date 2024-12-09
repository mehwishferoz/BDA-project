import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class StateMapper extends Mapper<Object, Text, Text, IntWritable> {

    private final static IntWritable one = new IntWritable(1);
    private Text state = new Text();

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        // Split the input line into fields using a comma as the delimiter
        String[] fields = value.toString().split(",", -1);

        // Check if the record has the expected number of fields and is not a header
        if (fields.length > 9 && !fields[9].equalsIgnoreCase("state")) {
            String stateName = fields[9].trim(); // Extract the "state" field
            if (!stateName.isEmpty()) {
                state.set(stateName);
                context.write(state, one);
            }
        }
    }
}
