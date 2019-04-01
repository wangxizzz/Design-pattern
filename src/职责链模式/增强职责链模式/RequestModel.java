package 职责链模式.增强职责链模式;

/**
 * Description 通用的请求对象
 * Date 2019/4/1 15:42
 */
public class RequestModel {
    /**
     * 表示具体的业务类型
     */
    private String type;
    /**
     * 通过构造方法把具体的业务类型传递进来
     * @param type 具体的业务类型
     */
    public RequestModel(String type){
        this.type = type;
    }
    public String getType() {
        return type;
    }
}