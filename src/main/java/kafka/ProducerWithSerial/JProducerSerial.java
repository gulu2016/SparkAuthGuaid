package kafka.ProducerWithSerial;

import kafka.KafkaProducerDemo1;
import org.apache.kafka.clients.producer.*;
import org.json.JSONObject;

import java.util.Date;
import java.util.Properties;

/**
 * @ProjectName: SparkAuthGuaid
 * @Package: kafka.ProducerWithSerial
 * @ClassName: JProducerSerial
 * @Description: java类作用描述
 * @Author: gulu
 * @CreateDate: 19-3-25 上午11:16
 * @UpdateUser: 更新者
 * @UpdateDate: 19-3-25 上午11:16
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class JProducerSerial extends Thread {
    public Properties configure(){
        Properties properties = new Properties();

        properties.put("bootstrap.servers","localhost:9092");   //kafka集群代理节点地址
        properties.put("request.required.acks","1");            //设置应答机制
        properties.put("batch.size",16384);                     //批量提交大小
        properties.put("linger.ms",1);                          //延时提交
        properties.put("buffer.memory",33554432);               //缓冲区大小
        properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer","kafka.ProducerWithSerial.JSalarySerializer");

        return properties;
    }

    public static void main(String[] args){
        JProducerSerial producerSerial = new JProducerSerial();
        producerSerial.start();
    }

    public void run(){
        Producer<String,JSalarySerial> producer = new KafkaProducer<String, JSalarySerial>(configure());

        JSalarySerial jss = new JSalarySerial();
        jss.setId("2018");
        jss.setSalary("100");

        producer.send(new ProducerRecord<String, JSalarySerial>("test_kafka_game_x", "key",jss),
                new Callback() {
                    @Override
                    public void onCompletion(RecordMetadata metadata, Exception exception) {
                        if(exception != null)
                            System.out.println(exception);
                        else
                            System.out.println("successfully");
                    }
                });
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        producer.close();
    }
}
