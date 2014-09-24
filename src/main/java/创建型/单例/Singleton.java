package 创建型.单例;

/**
 * Created with IntelliJ IDEA.
 * User: Tianjun
 * Date: 14-9-13
 * Time: 上午10:41
 * 懒汉式单例
 */
public class Singleton {
    private static Singleton singleton = new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
        return singleton;
    }
}