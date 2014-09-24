package 行为型.观察者;

/**
 * Created with IntelliJ IDEA.
 * User: Tianjun
 * Date: 14-9-17
 * Time: 下午2:40
 * To change this template use File | Settings | File Templates.
 */
public class ObserverImpl implements Observer {
    @Override
    public void update() {
        System.out.println("检测到变化");
    }
}
