@echo off
echo Removing all output directories from HDFS...

hdfs dfs -rm -r /user/mehwish/output_product
hdfs dfs -rm -r /user/mehwish/output_state
hdfs dfs -rm -r /user/mehwish/output_timely_response
hdfs dfs -rm -r /user/mehwish/output_tags
hdfs dfs -rm -r /user/mehwish/output_complaints

echo All specified output directories have been removed.