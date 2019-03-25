package kafka.ProducerWithSerial;

import java.io.UnsupportedEncodingException;

/**
 * @ProjectName: SparkAuthGuaid
 * @Package: kafka.ProducerWithSerial
 * @ClassName: SerializeUtils
 * @Description: java类作用描述
 * @Author: gulu
 * @CreateDate: 19-3-25 上午11:10
 * @UpdateUser: 更新者
 * @UpdateDate: 19-3-25 上午11:10
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SerializeUtils {
    public static byte[] serialize(Object object){
        try {
            return object.toString().getBytes("UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
