package kafka.ProducerWithSerial;

import java.io.Serializable;

/**
 * @ProjectName: SparkAuthGuaid
 * @Package: kafka.ProducerWithSerial
 * @ClassName: JSalarySerial
 * @Description: java类作用描述
 * @Author: gulu
 * @CreateDate: 19-3-25 上午11:07
 * @UpdateUser: 更新者
 * @UpdateDate: 19-3-25 上午11:07
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class JSalarySerial implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String salary;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "JSalarySerial{" +
                "id='" + id + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
