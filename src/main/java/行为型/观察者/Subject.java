package 行为型.观察者;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tianjun
 * Date: 14-9-17
 * Time: 下午2:35
 * To change this template use File | Settings | File Templates.
 */
public abstract class Subject {
    private List<Observer> observerList = new ArrayList<Observer>();
    public Subject addListen(Observer observer){
        observerList.add(observer);
        return this;
    }
    public Subject deleteListen(Observer observer){
        observerList.remove(observer);
        return this;
    }
    protected void notifyObserver(){
        for(Observer o: observerList){
            o.update();
        }
    }
    public void doSomethings(){
        doSomething();
        this.notifyObserver();
    }
    protected abstract void doSomething();

}
