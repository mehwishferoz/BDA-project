import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class ComplaintsMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    private Text company = new Text();
    private final static IntWritable one = new IntWritable(1);

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] fields = value.toString().split(",", -1); // Split by comma
        if (fields.length > 7) { // Ensure enough fields exist
            String companyName = fields[7].trim(); // Assuming the 8th column is 'company'
            if (!companyName.isEmpty() && !companyName.equals("company")) { // Skip header row
                company.set(companyName);
                context.write(company, one);
            }
        }
    }
}