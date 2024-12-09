import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class ProductMapper extends Mapper<Object, Text, Text, IntWritable> {

    private final static IntWritable one = new IntWritable(1);
    private Text product = new Text();

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        // Split the input line into fields using a comma as the delimiter
        String[] fields = value.toString().split(",", -1);

        // Check if the record has the expected number of fields and is not a header
        if (fields.length > 1 && !fields[1].equalsIgnoreCase("product")) {
            String productName = fields[1].trim(); // Extract the "product" field
            if (!productName.isEmpty()) {
                product.set(productName);
                context.write(product, one);
            }
        }
    }
}