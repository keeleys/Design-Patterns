package 行为型.观察者;

/**
 * Created with IntelliJ IDEA.
 * User: Tianjun
 * Date: 14-9-17
 * Time: 下午2:41
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String []args){
        Subject s = new SubjectImpl();
        s.addListen(new ObserverImpl());
        s.doSomethings();
    }
}
