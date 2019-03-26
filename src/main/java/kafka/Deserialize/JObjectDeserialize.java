package kafka.Deserialize;

import kafka.JObjectSerial;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

/**
 * @ProjectName: SparkAuthGuaid
 * @Package: kafka.Deserialize
 * @ClassName: JObjectDeserialize
 * @Description: java类作用描述
 * @Author: gulu
 * @CreateDate: 19-3-26 上午9:46
 * @UpdateUser: 更新者
 * @UpdateDate: 19-3-26 上午9:46
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class JObjectDeserialize {
    public static void main(String[] args){
        try {
            FileInputStream fis = new FileInputStream("/home/zhangjiaqian/salary.out");
            JObjectSerial jos = (JObjectSerial) new ObjectInputStream(fis).readObject();
            System.out.printf(jos.id+" "+jos.money);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
