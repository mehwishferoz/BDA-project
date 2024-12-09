# Big Data Analysis: Consumer Complaints Project 🚀📊

This project performs MapReduce operations on the Consumer Complaints Database using Hadoop. It includes five different queries to analyze and extract meaningful insights from the dataset.

## Queries Implemented 🔍
1. **Complaints by Product**: Count the number of complaints for each product.
2. **Complaints by State**: Count the number of complaints per state.
3. **Timely Response**: Count the number of complaints that received a timely response.
4. **Complaints by Tags**: Count the number of complaints by their tags.
5. **Complaints by Company**: Count the number of complaints for each company.

---

## Prerequisites
- Hadoop installed and configured.
- Java Development Kit (JDK) installed.
- The `complaints.csv` dataset.

---

## How to Run the Project 🛠️

### 1. Start Hadoop Services ⚙️
```bash
cd C:\Hadoop\sbin  
start-dfs.cmd  
start-yarn.cmd  
jps  
```
Ensure that the `DataNode`, `NameNode`, `ResourceManager`, and `NodeManager` are running.

---

### 2. Set Up Input Data on HDFS 🗂️
```bash 
hdfs dfs -mkdir -p /user/mehwish/complaints  
hdfs dfs -put C:\Users\Dell\Downloads\complaints.csv /user/mehwish/complaints/  
hdfs dfs -ls /user/mehwish/complaints  
```
---

### 3. Run Queries 🚀

#### Query 1: Complaints by Product 📦
```bash
cd C:\Users\Dell\Desktop\BDA-project\query1  
javac -classpath "C:\hadoop\share\hadoop\common\*;C:\hadoop\share\hadoop\mapreduce\*" -d . ProductDriver.java ProductMapper.java ProductReducer.java  
jar -cvf ComplaintsJob.jar *.class  
hadoop jar ComplaintsJob.jar ProductDriver /user/mehwish/complaints/complaints.csv /user/mehwish/output_product  
hdfs dfs -cat /user/mehwish/output_product/part-r-00000  
```
#### Query 2: Complaints by State 🗺️
```bash
cd ..\query2  
javac -classpath "C:\hadoop\share\hadoop\common\*;C:\hadoop\share\hadoop\mapreduce\*" -d . StateMapper.java StateReducer.java StateDriver.java  
jar -cvf StateComplaintsJob.jar *.class  
hadoop jar StateComplaintsJob.jar StateDriver /user/mehwish/complaints/complaints.csv /user/mehwish/output_state  
hdfs dfs -cat /user/mehwish/output_state/part-r-00000  
```
#### Query 3: Timely Response ⏰
```bash
cd ..\query3  
javac -classpath "C:\hadoop\share\hadoop\common\*;C:\hadoop\share\hadoop\mapreduce\*" -d . TimelyResponseMapper.java TimelyResponseReducer.java TimelyResponseDriver.java  
jar -cvf TimelyResponseComplaintsJob.jar *.class  
hadoop jar TimelyResponseComplaintsJob.jar TimelyResponseDriver /user/mehwish/complaints/complaints.csv /user/mehwish/output_timely_response  
hdfs dfs -cat /user/mehwish/output_timely_response/part-r-00000  
```
#### Query 4: Complaints by Tags 🏷️
```bash
cd ..\query4  
javac -classpath "C:\hadoop\share\hadoop\common\*;C:\hadoop\share\hadoop\mapreduce\*" -d . TagsMapper.java TagsReducer.java TagsDriver.java  
jar -cvf TagsComplaintsJob.jar *.class  
hadoop jar TagsComplaintsJob.jar TagsDriver /user/mehwish/complaints/complaints.csv /user/mehwish/output_tags  
hdfs dfs -cat /user/mehwish/output_tags/part-r-00000  
```
#### Query 5: Complaints by Company 🏢
```bash
cd ..\query5  
javac -classpath "C:\hadoop\share\hadoop\common\*;C:\hadoop\share\hadoop\mapreduce\*" -d . ComplaintsMapper.java ComplaintsReducer.java ComplaintsDriver.java  
jar -cvf Complaints.jar *.class  
hadoop jar Complaints.jar ComplaintsDriver /user/mehwish/complaints/complaints.csv /user/mehwish/output_complaints  
hdfs dfs -cat /user/mehwish/output_complaints/part-r-00000  
```
---

### 4. Cleanup 🧹
```bash
hdfs dfs -rm -r /user/mehwish/output_product  
hdfs dfs -rm -r /user/mehwish/output_state  
hdfs dfs -rm -r /user/mehwish/output_timely_response  
hdfs dfs -rm -r /user/mehwish/output_tags  
hdfs dfs -rm -r /user/mehwish/output_complaints  
hdfs dfs -rm -r /user  
hdfs dfs -rm -r /tmp  
```
Enjoy Exploring Big Data! 🎉
