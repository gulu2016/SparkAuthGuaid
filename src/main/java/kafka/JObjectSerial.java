package kafka;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @ProjectName: SparkAuthGuaid
 * @Package: kafka
 * @ClassName: JObjectSerial
 * @Description: java类作用描述
 * @Author: gulu
 * @CreateDate: 19-3-25 上午10:43
 * @UpdateUser: 更新者
 * @UpdateDate: 19-3-25 上午10:43
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 *
 * 将类序列化写入文件中，其实在文件中就是一串16进制代码
 */
public class JObjectSerial implements Serializable {
    private static final long serialCersionUID = 1L;

    public byte id = 1;
    public byte money = 100;

    public static void main(String[] args){
        try {
            FileOutputStream fos = new FileOutputStream("/home/zhangjiaqian/temp.out");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            JObjectSerial jos = new JObjectSerial();
            oos.writeObject(jos);
            oos.flush();
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
