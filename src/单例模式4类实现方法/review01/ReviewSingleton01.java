package 单例模式4类实现方法.review01;

/**
 * @Author wangxi
 * @Time 2020/4/11 17:09
 */
public class ReviewSingleton01 {
    public static ReviewSingleton01 singleton = null;

    private ReviewSingleton01(){}

    public static ReviewSingleton01 get() {
        if (singleton == null) {
            synchronized (singleton) {
                if (singleton == null) {
                    singleton = new ReviewSingleton01();
                }
            }
        }
        return singleton;
    }
}
