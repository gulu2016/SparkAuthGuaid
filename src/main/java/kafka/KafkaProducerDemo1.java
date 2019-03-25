package kafka;

import org.apache.kafka.clients.producer.*;
import org.slf4j.LoggerFactory;
import org.json.JSONObject;

import java.util.Date;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * @ProjectName: SparkAuthGuaid
 * @Package: kafka
 * @ClassName: KafkaProducerDemo1
 * @Description: java类作用描述
 * @Author: gulu
 * @CreateDate: 19-3-25 上午8:45
 * @UpdateUser: 更新者
 * @UpdateDate: 19-3-25 上午8:45
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 *
 * 使用单线程实现kafka生产者任务
 */
public class KafkaProducerDemo1 extends Thread{
    public Properties configure(){
        Properties properties = new Properties();

        properties.put("bootstrap.servers","localhost:9092");   //kafka集群代理节点地址
        properties.put("request.required.acks","1");            //设置应答机制
        properties.put("batch.size",16384);                     //批量提交大小
        properties.put("linger.ms",1);                          //延时提交
        properties.put("buffer.memory",33554432);               //缓冲区大小
        properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

        return properties;
    }

    public static void main(String[] args){
        KafkaProducerDemo1 producerDemo1 = new KafkaProducerDemo1();
        producerDemo1.start();
    }

    public void run(){
        Producer<String,String> producer = new KafkaProducer<String, String>(configure());

        for(int i = 0;i < 100;i++) {
            JSONObject json = new JSONObject();
            json.put("id", i);
            json.put("ip", "192.168.0." + i);
            json.put("date", new Date().toString());
            String k = "key" + i;

            producer.send(new ProducerRecord<String, String>("test_kafka_game_x", k,
                    json.toString()), new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    if (exception != null)
                        System.out.println(exception);
                    else
                        System.out.println("send success!");
                }
            });
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        producer.close();
    }
}
