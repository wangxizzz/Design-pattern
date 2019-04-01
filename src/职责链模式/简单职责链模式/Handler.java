package 职责链模式.简单职责链模式;

/**
 * Description 定义职责对象的接口
 * Date 2019/4/1 11:55
 */
public abstract class Handler {
    /**
     * 持有下一个处理请求的对象
     */
    protected Handler successor = null;

    /**
     * 设置下一个处理请求的对象
     * @param successor 下一个处理请求的对象
     */

    public void setSuccessor(Handler successor){
        this.successor = successor;
    }

    /**
     * 处理聚餐费用的申请
     * @param user 申请人
     * @param fee 申请的钱数
     * @return 成功或失败的具体通知
     */
    public abstract String handleFeeRequest(String user, double fee);
}