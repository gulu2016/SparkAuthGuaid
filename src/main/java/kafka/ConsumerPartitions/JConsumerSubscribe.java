package kafka.ConsumerPartitions;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * @ProjectName: SparkAuthGuaid
 * @Package: kafka.ConsumerPartitions
 * @ClassName: JConsumerSubscribe
 * @Description: java类作用描述
 * @Author: gulu
 * @CreateDate: 19-3-26 上午9:06
 * @UpdateUser: 更新者
 * @UpdateDate: 19-3-26 上午9:06
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 * 消费者自动获取分区，通过subscribe实现
 */
public class JConsumerSubscribe extends Thread {
    public static void main(String[] args){
        JConsumerSubscribe jConsumerSubscribe = new JConsumerSubscribe();
        jConsumerSubscribe.start();
    }

    public Properties configure(){
        Properties properties = new Properties();

        properties.put("bootstrap.servers","localhost:9092");   //kafka集群代理节点地址
        properties.put("group.id","ke");                        //指定消费者组
        properties.put("enable.auto.commit","true");            //开启自动提交
        properties.put("auto.commit.interval.ms","1000");       //自动提交间隔
        //反序列化消息主键
        properties.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        //反序列化消费记录
        properties.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");

        return properties;
    }

    @Override
    public void run(){
        //创建一个消费者对象
        KafkaConsumer<String,String> consumer = new KafkaConsumer<String, String>(configure());
        //订阅消费者主题集合
        consumer.subscribe(Arrays.asList("test_kafka_game_y"));
        //实时消费标识
        boolean flag = true;

        while (flag){
            //获取主题消息数据
            ConsumerRecords<String,String> records = consumer.poll(100);
            for(ConsumerRecord<String,String> record:records){
                System.out.printf("offset = %d,key = %s,value = %s%n",
                        record.offset(),record.key(),record.value());
            }
        }
        consumer.close();
    }
}
