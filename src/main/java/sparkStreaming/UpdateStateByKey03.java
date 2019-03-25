package sparkStreaming;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import scala.Tuple2;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.*;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.Optional;
import org.apache.spark.api.java.StorageLevels;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.State;
import org.apache.spark.streaming.StateSpec;
import org.apache.spark.streaming.api.java.*;
/**
 * @ProjectName: SparkAuthGuaid
 * @Package: PACKAGE_NAME
 * @ClassName: sparkStreaming.UpdateStateByKey03
 * @Description: java类作用描述
 * @Author: gulu
 * @CreateDate: 19-3-22 下午4:15
 * @UpdateUser: 更新者
 * @UpdateDate: 19-3-22 下午4:15
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 *  使用mapWithState更新状态，可以带有历史记录的去更新状态
 */
//public class UpdateStateByKey03 {
//    private static final Pattern SPACE = Pattern.compile(" ");
//
//    public static void main(String[] args) throws Exception {
//        // Create the context with a 1 second batch size
//        SparkConf sparkConf = new SparkConf().setAppName("JavaStatefulNetworkWordCount").setMaster("local[2]");
//        JavaStreamingContext ssc = new JavaStreamingContext(sparkConf, Durations.seconds(5));
//        ssc.checkpoint("/home/zhangjiaqian/wordcount");
//
//        // Initial state RDD input to mapWithState
//        @SuppressWarnings("unchecked")
//        List<Tuple2<String, Integer>> tuples =
//                Arrays.asList(new Tuple2<>("hello", 1), new Tuple2<>("world", 1));
//        JavaPairRDD<String, Integer> initialRDD = ssc.sparkContext().parallelizePairs(tuples);
//
//        JavaReceiverInputDStream<String> lines = ssc.socketTextStream("localhost", 9999);
//
//        JavaDStream<String> words = lines.flatMap(x -> Arrays.asList(SPACE.split(x)).iterator());
//
//        JavaPairDStream<String, Integer> wordsDstream = words.mapToPair(s -> new Tuple2<>(s, 1));
//
//        // Update the cumulative count function
//        Function3<String, Optional<Integer>, State<Integer>, Tuple2<String, Integer>> mappingFunc =
//                (word, one, state) -> {
//                    int sum = one.orElse(0) + (state.exists() ? state.get() : 0);
//                    Tuple2<String, Integer> output = new Tuple2<>(word, sum);
//                    state.update(sum);
//                    return output;
//                };
//
//        // DStream made of get cumulative counts that get updated in every batch
//        JavaMapWithStateDStream<String, Integer, Integer, Tuple2<String, Integer>> stateDstream =
//                wordsDstream.mapWithState(StateSpec.function(mappingFunc).initialState(initialRDD));
//
//        stateDstream.print();
//        ssc.start();
//        ssc.awaitTermination();
//    }
//}
