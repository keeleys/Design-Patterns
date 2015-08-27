package 行为型.观察者;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tianjun
 * Date: 14-9-17
 * Time: 下午2:41
 * To change this template use File | Settings | File Templates.
 */
public class Client {
    public static void main(String []args){
        User s = new User();
        s.addListen(new ObserverImpl());
        s.setName("keeley");
    }
}

/**
 * 观察者
 */
interface Observer<T extends Observable> {
    public void update(T a);
}
class ObserverImpl implements Observer<User> {
    @Override
    public void update(User a) {
        System.out.println("检测到name:"+a.getName());
    }
}
/**
 * 被观察者
 */
abstract class Observable{
    private List<Observer> observerList = new ArrayList<Observer>();
    public Observable addListen(Observer observer){
        observerList.add(observer);
        return this;
    }
    public Observable deleteListen(Observer observer){
        observerList.remove(observer);
        return this;
    }
    protected void notifyObserver(){
        for(Observer o: observerList){
            o.update(this);
        }
    }
}
//被观察者
class User extends Observable {
    private String name;
    public void setName(String name) {
        this.name=name;
        this.notifyObserver();
    }
    public String getName(){
        return name;
    }
}
