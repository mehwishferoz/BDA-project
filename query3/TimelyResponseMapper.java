import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class TimelyResponseMapper extends Mapper<Object, Text, Text, IntWritable> {

    private final static IntWritable one = new IntWritable(1);
    private Text timelyResponse = new Text("Timely Response");

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        // Split the input line into fields using a comma as the delimiter
        String[] fields = value.toString().split(",", -1);

        // Check if the record has the expected number of fields and is not a header
        if (fields.length > 16 && !fields[16].equalsIgnoreCase("timely_response")) {
            String response = fields[16].trim(); // Extract the "timely_response" field
            if (response.equalsIgnoreCase("yes")) { // Check if the response was "yes"
                context.write(timelyResponse, one);
            }
        }
    }
}
