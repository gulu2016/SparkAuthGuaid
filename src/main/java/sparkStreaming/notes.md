### 官网的笔记
地址：http://spark.apache.org/docs/latest/streaming-programming-guide.html#initializing-streamingcontext
    1.Once a context has been started, no new streaming 
      computations can be set up or added to it.
      一旦SparkStreamingContext启动，不能加入新的流计算
    2. Once a context has been stopped, it cannot be restarted.
      一旦停止，就不能被重启（应该是指SparkStreamingContext对象不能被重用）
    3.Only one StreamingContext can be active in a JVM at the same time.
      同一时间只有一个StreamingContext在一个JVM上运行
    4.stop() on StreamingContext also stops the SparkContext. 
      To stop only the StreamingContext, set the optional parameter of 
      stop() called stopSparkContext to false.
      关于停止StreamingContext，而不停止SparkContext的，暂时用不到
    5.A SparkContext can be re-used to create multiple StreamingContexts, 
      as long as the previous StreamingContext is stopped (without stopping 
      the SparkContext) before the next StreamingContext is created.
      SparkContext可以被重用建立多个StreamingContexts，停掉一个StreamingContext
      就可以建立下一个StreamingContext了
地址：http://spark.apache.org/docs/latest/streaming-programming-guide.html#discretized-streams-dstreams
    1.DStream的底层就是RDD流，RDD流是由多个RDD组成的，
      而每个RDD都要经过QuickStart.scala中2中的业务处理，这就是对流的处理
      
地址：http://spark.apache.org/docs/latest/streaming-programming-guide.html#input-dstreams-and-receivers
    1.Input DStream是代表从源头的输入流，在QuickStart.scala中，lines就是Input DStream
    2.每个Input DStream都和一个Receiver结合，Receiver是从一个源头接收数据，并将数据存储在spark内存中的
    3.当运行SparkStreaming 程序的时候，不要使用“local” or “local[1]”，因为至少有一个线程运行
      Receiver
      
该看：http://spark.apache.org/docs/latest/streaming-programming-guide.html#window-operations
      
收藏博客
1.设置日志打印级别的博客：https://blog.csdn.net/a123demi/article/details/72821488
2.设置语言级别的帖子：https://blog.csdn.net/amoscn/article/details/79718400    


问题：
1.使用java的话，匿名内部类要会写，lambda表达式要会写
2.要熟悉scala语法