package 职责链模式.简单职责链模式;

/**
 * Description 项目经理处理
 * Date 2019/4/1 11:57
 */
public class ProjectManager extends Handler{
    /**
     * 处理聚餐费用的申请
     *
     * @param user 申请人
     * @param fee  申请的钱数
     * @return 成功或失败的具体通知
     */
    @Override
    public String handleFeeRequest(String user, double fee) {
        String str = "";        //项目经理的权限比较小，只能在500以内
        if(fee < 500){            //为了测试，简单点，只同意小李的
            if("小李".equals(user)){
                str = "项目经理同意"+user+"聚餐费用"+fee+"元的请求";
            }else{                //其他人一律不同意
                str = "项目经理不同意"+user+"聚餐费用"+fee+"元的请求";
            }
            return str;
        }else{            //超过500，继续传递给级别更高的人处理
            if(this.successor!=null){
                return successor.handleFeeRequest(user, fee);
            }
        }
        return str;

    }
}