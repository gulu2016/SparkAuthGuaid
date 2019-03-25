package kafka.ProducerWithSerial;

import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

/**
 * @ProjectName: SparkAuthGuaid
 * @Package: kafka.ProducerWithSerial
 * @ClassName: JSalarySerializer
 * @Description: java类作用描述
 * @Author: gulu
 * @CreateDate: 19-3-25 上午11:12
 * @UpdateUser: 更新者
 * @UpdateDate: 19-3-25 上午11:12
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 *
 * 自定义序列化JSalarySeralizer类
 * 就是使用kafka自带的序列化接口，对自定义的JSalarySerial类进行序列化
 * 序列化的方法SerializeUtils.serialize也只自定义的
 */
public class JSalarySerializer implements Serializer<JSalarySerial> {
    @Override
    public void configure(Map<String,?> configs,boolean isKey){

    }

    @Override
    public byte[] serialize(String topic, JSalarySerial data) {
        //使用自定义的SerializeUtils中的静态方法serialize对数据进行序列化
        return SerializeUtils.serialize(data);
    }

    @Override
    public void close() {

    }
}
