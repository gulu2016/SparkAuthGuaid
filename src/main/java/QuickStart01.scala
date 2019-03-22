import org.apache.spark._
import org.apache.spark.streaming._
import org.apache.spark.streaming.StreamingContext._ // not necessary since Spark 1.3

/**
  *
  * @ProjectName: SparkAuthGuaid
  * @Package:
  * @ClassName: QuickStart
  * @Description: java类作用描述 
  * @Author: gulu
  * @CreateDate: 19-3-21 下午1:40
  * @UpdateUser: 更新者
  * @UpdateDate: 19-3-21 下午1:40
  * @UpdateRemark: 更新说明
  * @Version: 1.0
  * 看注释，已经标注出大体流程
  */
object QuickStart01 {
  def main(args: Array[String]): Unit = {
    //0.建立SparkConf对象,设置主机名称和setAppName，并建立程序入口点StreamingContext
    val conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount")
    val ssc = new StreamingContext(conf, Seconds(5))

    //1.Define the input sources by creating input DStreams.
    //确定数据的输入源
    val lines = ssc.socketTextStream("localhost", 9999)

    //2.Define the streaming computations
    // by applying transformation and output operations to DStreams.
    //定义处理数据的过程
    val words = lines.flatMap(_.split(" "))
    // Count each word in each batch
    val pairs = words.map(word => (word, 1))
    val wordCounts = pairs.reduceByKey(_ + _)
    // Print the first ten elements of each RDD generated in this DStream to the console
    wordCounts.print()

    //3.Start receiving data and processing it using streamingContext.start().
    //开始接受数据
    ssc.start()             // Start the computation

    //4.Wait for the processing to be stopped (manually or due to any error)
    // using streamingContext.awaitTermination().
    //等待数据处理结束
    ssc.awaitTermination()  // Wait for the computation to terminate
  }

}
