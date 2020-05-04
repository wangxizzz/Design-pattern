package 单例模式4类实现方法.review01;

/**
 * @Author wangxi
 * @Time 2020/4/11 18:47
 */
public class ReviewSingle02 {


    public static class Holder {
        public static ReviewSingle02 single02 = new ReviewSingle02();
        private Holder(){}
    }

    private ReviewSingle02(){}

    public static ReviewSingle02 get() {
        return Holder.single02;
    }
}
